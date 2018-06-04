package com.ccttic.controller.attachment;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccttic.entity.attchment.Attachment;
import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.common.exception.AppException;
import com.ccttic.service.attachment.FastDfsService;
import com.ccttic.util.logger.annotation.OperLogging;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

/**
功能说明：     附件信息
@version  1.0.0
@author  xgYin
@see  com.studio.framework.controller.attachment.AttachmentController.java
@date  2016年12月13日
*/
@RestController
@RequestMapping("/attachment")
public class AttachmentController implements Serializable {
	private static final long serialVersionUID = 213026144265132682L;
	
	private Logger logger = LoggerFactory.getLogger(AttachmentController.class);
	
	@Autowired
	private FastDfsService attachmentService;
	
	/**
	 * 根据业务ID获取附件信息
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 * @throws AppException
	 */
	@GetMapping("/getPage")
	@OperLogging(content="分页获取附件")
	public ResponseMsg<List<Attachment>> getAttachments(PageRequest page) throws AppException {
		ResponseMsg<List<Attachment>>  resp = new ResponseMsg<List<Attachment>>();
		Page<Attachment> attas =  attachmentService.getAttachments(page);
		resp.success("获取附件分页成功");
		resp.setData(attas.getRecords());
		resp.setTotal(attas.getTotalRows().intValue());
		return resp;
	}
	
	
	@GetMapping("/get")
	@OperLogging(content="获取附件")
	public ResponseMsg<Attachment> getAttachment(String attachmentId) throws AppException {
		ResponseMsg<Attachment> resp = new ResponseMsg<Attachment>();
		Attachment atta = attachmentService.getAttachment(attachmentId);
		resp.setData(atta);
		resp.success("获取附件成功");
		return resp;
	}
	
	/**
	 * 根据ID删除附件信息
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	@OperLogging(content="移除附件")
	public ResponseMsg<String> deleteAttachment(String attachmentId) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			attachmentService.deleteFile(attachmentId);
			resp.success("删除附件失败");
			resp.setData(attachmentId);
		}catch (Exception e) {
			logger.error("删除附件失败", e);
			resp.fail("删除附件失败");
		}
		return resp;
	}
	
	
	/**
	 * 上传附件
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 */
	@PutMapping("/upload")
	@OperLogging(content="上传附件")
	public ResponseMsg<Attachment> uploadAttachment(MultipartFile uploadFile) {
		ResponseMsg<Attachment> resp = new ResponseMsg<Attachment>();
		try {
			Attachment att = attachmentService.uploadFile(uploadFile);
			resp.success("上传附件成功");
			resp.setData(att);
		} catch (Exception e) {
			logger.error("创建文件失败:"+uploadFile.getOriginalFilename(),e);
			resp.fail("上传附件失败");
		}
		return resp;
	}
	
	@GetMapping("/download")
	@OperLogging(content="下载附件")
	public ResponseEntity<byte[]> downloadAttachment(String attachmentId){
		HttpHeaders headers = new HttpHeaders();
		Attachment atta = attachmentService.downloadFile(attachmentId);
		headers.setContentDispositionFormData("attachment",atta.getAttachmentNm());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(atta.getFileBytes(),headers,HttpStatus.OK);
	}	
}