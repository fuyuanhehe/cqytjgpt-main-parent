package com.ccttic.gateway.servicefallback;

import com.ccttic.util.common.JsonUtil;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：cqytjgpt-web-api 服务的降级数据
 */
@Component
public class CqytjgptWebApiFallBack implements FallbackProvider {

    public static final String WEB_API_FALL_BACK = "CqytjgptWebApiFallBack";

    private static final byte[] RESULT_BYTES;

    static {
        Map<String, Object> strMap = new HashMap<>();
        strMap.put("state", -1);
        strMap.put("error", "");
        strMap.put("msg", "当前访问的模块不可用");
        RESULT_BYTES = JsonUtil.objectToJson(strMap).getBytes();
    }

    @Override
    public String getRoute() {
        return "cqytjgpt-web-api";
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(RESULT_BYTES);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                RequestContext currentContext = RequestContext.getCurrentContext();
                currentContext.set(WEB_API_FALL_BACK, cause.getMessage());
                headers.setContentType(mt);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(RESULT_BYTES);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                RequestContext currentContext = RequestContext.getCurrentContext();
                currentContext.set(WEB_API_FALL_BACK, "cqytjgpt-web-api 服务访问失败");
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
