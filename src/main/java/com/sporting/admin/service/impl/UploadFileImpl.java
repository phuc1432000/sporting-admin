package com.sporting.admin.service.impl;

import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.uploadFile.UploadFileDTO;
import com.sporting.admin.service.UploadFile;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

@Service
@Slf4j
public class UploadFileImpl implements UploadFile {
    @Value("${admin.host.url}")
    String url;

    @Override
    public UploadFileDTO uploadFile(MultipartFile file) {
        try {
            String getUrl = url + URLConstants.UPLOAD_FILE;
            InputStream input = file.getInputStream();
            File imageFile = new File(file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(input, imageFile);
            UploadFileDTO result = HttpOkUtils.callApiPostMultipartFile(getUrl,
                    "",
                    imageFile,
                    file.getOriginalFilename(),
                    "file",
                    UploadFileDTO.class);
            // clear file
            if (imageFile.exists()) {
                imageFile.delete();
            }
            return result;
        } catch (Exception e) {
            log.error("Failed to upload file: ", e);
        }
        return null;
    }
}