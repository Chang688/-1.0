package com.niuma.langbei.common;


import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.http.Response;

public class QiNiuYun {

    public static void main(String[] args) {
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);

        String ak = "SM5UsKv-Y9OcKy_oYgJRFfXftJIEsSJrGVCkUg10";
        String sk = "z-NoYGGSuabnK5Vtop1V0XsLAniMfNsKsMHVgyXV";

        String bucket = "chang123";

        Auth auth = Auth.create(ak, sk);
        String uptake = auth.uploadToken(bucket);
        String filePath = "C:\\Users\\86158\\Desktop\\image.jpeg"; //图片路径
        String key = "haha.jpg"; // 设置存储到七牛云的名称

        try {
            Response response = uploadManager.put(filePath, key, uptake);
            System.out.println(response);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}

