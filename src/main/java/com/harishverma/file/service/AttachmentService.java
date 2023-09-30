package com.harishverma.file.service;

import com.harishverma.file.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file);

    Attachment getAttachment(String fileId);
}
