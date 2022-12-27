package com.sporting.admin.service;

import com.sporting.admin.dto.uploadFile.UploadFileDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    UploadFileDTO uploadFile(MultipartFile file);
}
