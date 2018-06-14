package com.ccttic.cqytjgpt.webapi.mapper.attachment;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.attchment.Attachment;
import com.ccttic.util.exception.AppException;


/**
功能说明：      MyBatis岗位映射
@version  1.0.0
@author  lm
@see  com.studio.framework.mapper.attachment.AttachmentMapper.java
@date  2016年12月19日
*/

public interface AttachmentMapper {

	/**
	 * 根据业务ID获取附件信息
	 * @param busid(业务ID)
	 * @return
	 * @throws AppException
	 */
	public List<Attachment> findAttachmentList(Map<String, Object> params);
	
	/**
	 * 取得有效总记录数
	 * @param params
	 * @return
	 */
	public Long count(Map<String, Object> params);
	
	/**
	 * 根据ID获取附件信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Attachment findAttachmentById(String attachmentId);
	
	
	/**
	 * 根据ID更新附件信息
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public boolean updateAttachment(Map<String, Object> map);
	
	
	/**
	 * 解除附件与业务之间的关系
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public boolean removeAttachment(String attachmentId);
	
	
	
	/**
	 * 上传附件信息
	 * @param map
	 * @return
	 * @throws AppException
	 */
	public boolean uploadAttachment(Attachment atta);
}
	