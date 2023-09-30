package com.harishverma.file.service.impl;

import com.harishverma.file.entity.Attachment;
import com.harishverma.file.repository.AttachmentRepository;
import com.harishverma.file.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public Attachment saveAttachment(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new Exception("File contains invalid name");
            }
            Attachment attachment = Attachment.builder()
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) {
        return attachmentRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found with id : " + fileId));
    }
}
