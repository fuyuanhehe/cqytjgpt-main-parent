package com.ccttic.cqytjgpt.webapi.controller.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
	
    private Logger logger = LoggerFactory.getLogger(MailController.class);
	
/*	@Autowired  
	JavaMailSender jms;  
	
	@Value("spring.mail.username")
	private String sendMail;

	@RequestMapping("/send")
	public ResponseMsg<String> send(String title, String msg, String sendTo){
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(sendMail);
			message.setTo(sendTo);
			message.setSubject(title);
			message.setText(msg);
			jms.send(message);
			resp.success("邮件发送成功！");
			resp.setData("邮件发送成功！");
		}catch(Exception e){
			logger.error("邮件发送失败",e);
			resp.fail("邮件发送失败！");
			resp.setData("邮件发送失败！");
		}
		return resp;
	}*/
}
