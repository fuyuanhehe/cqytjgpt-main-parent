package com.ccttic.cqytjgpt.enterpriseapi.service.message;

import org.springframework.stereotype.Service;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.message.MessageService;

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
