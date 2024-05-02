package com.niuma.langbei.service.impl;

import com.alibaba.fastjson.JSON;
import com.niuma.langbei.service.QiniuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author: 12613
 * @project: mooc
 * @pcakage: com.king.mooc.service.impl.QiniuServiceImpl
 * @date: 2022年05月02日 00:38
 * @description:
 */
@Service
public class QiniuServiceImpl implements QiniuService {
    @Value(value = "${Qiniu.AccessKey}")
    private String accessKey;
    @Value(value = "${Qiniu.SecretKey}")
    private String secretKey;

    //测试文件上传
    public String testUpload(MultipartFile file) {
        System.out.println(11);
        //构造一个带指定 Region 对象的配置类，指定存储区域，和存储空间选择的区域一致
        Configuration cfg = new Configuration(Region.huanan());
        //其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传
        String bucket = "chang123";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        /*String key = UUID.randomUUID() + ".png";*/



        String fileName="";
        try {
            // 获取上传文件的输入流
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            fileName = file.getOriginalFilename();
            //添加随机值 key为文件名字
            String key = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = key + fileName;
            //把文件按照日期分类  //获取当前日期
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //拼接日期
            fileName = datePath + "/" + fileName;
            //得到本地文件的字节数组
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //认证
            Auth auth = Auth.create(accessKey, secretKey);
            //认证通过后得到token（令牌）
            String upToken = auth.uploadToken(bucket);

            //上传文件,参数：字节数组，key，token令牌
            //key: 建议我们自已生成一个不重复的名称
            Response response = uploadManager.put(bytes, fileName, upToken);
            String url = "http://rv3c46pfr.hn-bkt.clouddn.com/" + fileName;
            return url;
        } catch (IOException ex) {
            return null;
        }
    }
}
