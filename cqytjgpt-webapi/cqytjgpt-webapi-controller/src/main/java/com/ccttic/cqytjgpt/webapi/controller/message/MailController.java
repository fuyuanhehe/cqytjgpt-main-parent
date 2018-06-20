package com.ccttic.cqytjgpt.webapi.controller.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.message.MessageService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.message.Message;
import com.ccttic.util.annotation.OperLogging;

@RestController
@RequestMapping("/mail")
public class MailController {
	
    private Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired  
	MessageService messageService;
	
	@Value("${spring.mail.username}")
	private String sendMail;

	@RequestMapping("/send")
	@OperLogging(operType=0,content="发送邮件",remark="新增消息发送邮件")
	public ResponseMsg<String> send(String title,String sendTo,String content){
		ResponseMsg<String> resp = new ResponseMsg<String>();
		Message msg = new Message();
		msg.setTitle(title);
		msg.setSendTo(sendTo);
		msg.setSendFrom(sendMail);
		msg.setContent(content);
		try{
			messageService.sendMail(msg);
			resp.success("邮件已发送！");
			resp.setData("邮件已发送！");
		}catch(Exception e){
			logger.error("邮件发送失败",e);
			resp.fail("邮件发送失败！");
			resp.setData("邮件发送失败！");
		}
		return resp;
	}
}
