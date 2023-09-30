package com.harishverma.file.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;
}
