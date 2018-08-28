package com.ccttic.cqytjgpt.webapi.listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.menu.ResourceBuilder;
import com.ccttic.cqytjgpt.webapi.interfaces.menu.ResourceScannerService;
import com.ccttic.entity.employee.ResourceInfo;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.exception.ResourceMappingException;
import com.google.common.collect.Sets;

/**
 * 
    * @ClassName: ResourceScanner  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author syao  
    * @date 2018年6月5日  
    *
 */
@Component
public class ResourceScanner implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(ResourceScanner.class);

    private static Map<String,Class>  controllerMap = new HashMap<String,Class>();
    
    @Autowired
    private ResourceScannerService resourceScannerService;

    @Autowired
    private ResourceBuilder<ResourceInfo> resourceBuilder;
    
    /* (non-Javadoc)
     * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	  
    	
    	
        if (event.getApplicationContext().getParent() != null) {

            if (resourceBuilder.scannerEnable()) {
                // 保存菜单
                String[] beanNames = event.getApplicationContext().getBeanDefinitionNames();
                if (beanNames != null) {
                    logger.debug("开始扫描资源对象...");
                    doScan(beanNames, event.getApplicationContext());
                    logger.debug("结束扫描资源对象...");
                }
            }
            
        

        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void doScan(String[] beanNames, ApplicationContext context) {
    	
    	
        Set<ResourceInfo> appResourceSet = Sets.newConcurrentHashSet();
        for (String beanName : beanNames) {
            // spring 托管bean
            Object beanObj = context.getBean(beanName);

            if (beanObj == null) {
                continue;
            }

            Class clazz = null;
            if (AopUtils.isAopProxy(beanObj)) {
                try {
                    clazz = getTarget(beanObj);
                } catch (Exception e) {
                    clazz = beanObj.getClass();
                }
            } else {
                clazz = beanObj.getClass();
            }
            // 处理类注解
            Annotation clazzControllerAnno = clazz.getAnnotation(Controller.class);
            if (clazzControllerAnno == null) {
                clazzControllerAnno = clazz.getAnnotation(RestController.class);
            }

            if (clazzControllerAnno == null) {
                logger.info("跳过Controller类：" + clazz.getName());
            } else {
            	if(controllerMap.containsKey(clazz.getName())) {
            		logger.info("Controller类:" + clazz.getName()+"，已经被扫瞄过了，跳过此类");
            		continue;
            	}
            	controllerMap.put(clazz.getName(), clazz);
                logger.info("正在扫描Controller类:" + clazz.getName());
                RequestMapping clazzRequestMappingAnno = (RequestMapping) clazz.getAnnotation(RequestMapping.class);

                // 当前控制器的类级别请求路径 在class 上使用@Controller或@RestController注解定义的请求路径
                String[] controllerRequestUri = clazzRequestMappingAnno == null ? null : clazzRequestMappingAnno
                        .value();
                // 遍历当前控制器类的所有方法
                for (Method method : clazz.getMethods()) {
                    // 控制器方法请求路径注解
                    RequestMapping methodRequestMappingAnno = (RequestMapping) method
                            .getAnnotation(RequestMapping.class);
                    if (methodRequestMappingAnno == null) {
                        logger.info("跳过Controller方法：" + method.getName());
                        continue;
                    } else {
                        logger.info("正在扫描Controller方法:" + method.getName());
                        // 控制器方法请求路径
                        String[] methodRequestUri = methodRequestMappingAnno.value();
                        ResourceScan resourceScan = method.getAnnotation(ResourceScan.class);
                        if (resourceScan == null) {
                            logger.info("Controller方法:" + method.getName() + "不是资源管理对象");
                            continue;
                        } else {
                            ResourceInfo resourceInfo = resourceBuilder.createSysResource(resourceScan,
                                    controllerRequestUri, methodRequestUri);
                            appResourceSet.add(resourceInfo);
                        }
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(appResourceSet)) {
            try {
				resourceScannerService.installResources(appResourceSet);
			} catch (ResourceMappingException e) {
				logger.error("注册controller上的资源菜单失败:",e);
			}finally {
				//清除所有controller类
		    	controllerMap.clear();
			}
        }
    }

    /**
     * 获取 目标对象
     * 
     * @param proxy
     *            代理对象
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    private static Class getTarget(Object proxy) throws Exception {

        if (AopUtils.isJdkDynamicProxy(proxy)) {
            Object object= getJdkDynamicProxyTargetObject(proxy);
            return object.getClass();
        } else { // cglib
            Object object= getCglibProxyTargetObject(proxy);
            Class clazz = AopUtils.getTargetClass(object);
            return clazz;
        }

    }

    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);

        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();

        return target;
    }

    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();

        return target;
    }

}
