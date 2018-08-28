package com.ccttic.cqytjgpt.webapi.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.message.MessageService;
import com.ccttic.cqytjgpt.webapi.mapper.message.MessageMapper;
import com.ccttic.entity.message.Message;
import com.ccttic.util.common.RandomHelper;

@Service
public class MessageServiceImpl implements MessageService{
	
/*	@Autowired  
	JavaMailSender jms;  
	
	@Value("${spring.mail.username}")
	private String sendMail;
	
	@Autowired
	MessageMapper messageMapper;

	@Async
	@Override
	@Transactional
	public void sendMail(Message message) {
		message.setId(RandomHelper.uuid());
		message.setMsgType(Message.MSG_TYPE_1);
		message.setState(Message.STATE_1);
		messageMapper.createMessage(message);
		SimpleMailMessage sendMail = new SimpleMailMessage();
		sendMail.setFrom(message.getSendFrom());
		sendMail.setTo(message.getSendTo());
		sendMail.setSubject(message.getTitle());
		sendMail.setText(message.getContent());
		jms.send(sendMail);		
	}*/
}
