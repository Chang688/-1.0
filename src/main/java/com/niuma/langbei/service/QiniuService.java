package com.niuma.langbei.service;

import org.springframework.web.multipart.MultipartFile;

public interface QiniuService {
     String testUpload(MultipartFile file);
}
