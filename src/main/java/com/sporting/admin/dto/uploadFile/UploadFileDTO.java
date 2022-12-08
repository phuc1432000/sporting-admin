package com.sporting.admin.dto.uploadFile;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadFileDTO implements Serializable {
    String message;
    UploadFileInitDTO data;
    String error_code;
}
