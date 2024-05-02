package com.niuma.langbei.controller;


import com.niuma.langbei.common.BaseResponse;
import com.niuma.langbei.common.ResultUtils;
import com.niuma.langbei.service.OssService;
import com.niuma.langbei.service.QiniuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@Api(description = "阿里云文件管理")
@CrossOrigin(origins = {"https://hb.dogbin.vip/"}, allowCredentials = "true")
@RestController
@RequestMapping("/fileOss")
public class OssController {

    @Resource
    private OssService ossService;
    @Resource
    private QiniuService qiniuService;

    //上传头像
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public BaseResponse<String> uploadOssFile(@RequestParam(required = false) MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            return null;
        }
        //返回上传到oss的路径
        String url = qiniuService.testUpload(file);
        System.out.println(url);
        //返回url对象
        return ResultUtils.success(url);
    }

}
