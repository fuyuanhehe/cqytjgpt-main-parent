package com.ccttic.service.attachment.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ccttic.entity.attchment.Attachment;
import com.ccttic.mapper.attachment.AttachmentMapper;
import com.ccttic.service.attachment.FastDfsService;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class FastDfsServiceImpl implements FastDfsService {

	@Autowired
	private AttachmentMapper attachmentMapper;

	@Autowired
	private FastFileStorageClient storageClient;

	@Override
	@Transactional
	public Page<Attachment> getAttachments(Pageable page) {
		Page<Attachment> pager = new PageImpl<Attachment>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		long totolRols = attachmentMapper.count(params);
		List<Attachment> records = attachmentMapper.findAttachmentList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	@Transactional
	public Attachment getAttachment(String attachmentId) {
		return attachmentMapper.findAttachmentById(attachmentId);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 *            文件对象
	 * @return 文件访问地址
	 * @throws IOException
	 */
	@Transactional
	public Attachment uploadFile(MultipartFile file) throws IOException {
		// Metadata
		Set<MataData> metaDataSet = new HashSet<MataData>();
		metaDataSet.add(new MataData("Author", "cqytjg"));
		String now = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		metaDataSet.add(new MataData("CreateDate", now));
		StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
				FilenameUtils.getExtension(file.getOriginalFilename()), metaDataSet);
		Attachment atta = new Attachment();
		atta.setId(RandomHelper.uuid());
		atta.setAttachmentNm(file.getOriginalFilename());
		atta.setAttachmentPath(storePath.getFullPath());
		atta.setAttachementGroup(storePath.getGroup());
		// atta.setCreateNm(this.getEmployeeNm());
		// atta.setCreateBy(this.getEmployeeCd());
		atta.setUploadTime(new Date());
		attachmentMapper.uploadAttachment(atta);
		return atta;
	}

	/**
	 * 下文件
	 * 
	 * @param attachmentId
	 * @param callback
	 */
	@Transactional
	public Attachment downloadFile(String attachmentId) {
		Attachment atta = attachmentMapper.findAttachmentById(attachmentId);
		byte [] fileBytes = storageClient.downloadFile(atta.getAttachementGroup(), atta.getAttachmentPath(), new DownloadCallback<byte[]>() {
			@Override
			public byte[] recv(InputStream ins) throws IOException {
				 ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
				 byte[] buff = new byte[100];  
				 int rc = 0;  
				 while ((rc = ins.read(buff, 0, 100)) > 0) {  
				   swapStream.write(buff, 0, rc);  
				 }  
				 return swapStream.toByteArray();
			}
		});
		atta.setFileBytes(fileBytes);
		return atta;
	}

	/**
	 * 删除文件
	 * 
	 * @param fileUrl
	 *            文件访问地址
	 * @return
	 */
	public void deleteFile(String attachmentId) {
		Attachment atta = attachmentMapper.findAttachmentById(attachmentId);
		StorePath storePath = StorePath.praseFromUrl(atta.getAttachmentPath());
		storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
		attachmentMapper.removeAttachment(attachmentId);
	}

}
