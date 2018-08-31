package com.ccttic.cqytjgpt.enterpriseapi.mapper.message;

import org.apache.ibatis.annotations.Param;

import com.ccttic.entity.message.Message;

public interface MessageMapper {
	
	public void createMessage(@Param("msg") Message message);

}
