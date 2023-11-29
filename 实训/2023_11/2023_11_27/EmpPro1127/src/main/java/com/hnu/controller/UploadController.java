package com.hnu.controller;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

@CrossOrigin
@RestController
public class UploadController {

    /**
     * 上传到七牛云的服务器
     * @param upFile
     * @param request
     * @return
     */
    @PostMapping("/up1")
    public String upfile1(MultipartFile upFile,HttpServletRequest request) throws IOException {

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huadongZheJiang2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "YG5mNo8xmrQZgrFVALdnDdnK3sZ5d-lBlqqFFXXU";
        String secretKey = "xGKWrfjmnfbID4RhL0EoO2LoFmteCY83DrVUO7S8";
        String bucket = "emppro";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String fileName = UUID.randomUUID().toString().replaceAll("-","")+upFile.getOriginalFilename();

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(upFile.getInputStream(),fileName,upToken,null,null);
            System.out.println(response);
            System.out.println("*********上传成功****************");
        } catch (QiniuException ex) {
            ex.printStackTrace();
            if (ex.response != null) {
                System.err.println(ex.response);

                try {
                    String body = ex.response.toString();
                    System.err.println(body);
                } catch (Exception ignored) {
                }
            }
        }


        return "http://s4tdoh0lx.bkt.clouddn.com/"+fileName;
    }




    @PostMapping("/up")
    public String upfile(MultipartFile upFile, HttpServletRequest request) throws IOException {
        System.out.println(upFile.getName());
        System.out.println(upFile.getOriginalFilename());
        System.out.println(upFile.getContentType());
        System.out.println(upFile.getSize());

        InputStream inputStream = upFile.getInputStream();

        //动态获取服务器路径
        String realPath = request.getServletContext().getRealPath("/upDir");
        System.out.println("realPath="+realPath);
        File upDir = new File(realPath);
        if (!upDir.exists()){
            upDir.mkdirs();
        }

        //给文件的原名称 重命名
        String fileName = upFile.getOriginalFilename();

        fileName = UUID.randomUUID().toString().replaceAll("-","")+fileName;

        //构建要上传的文件
        File targetFile = new File(upDir,fileName);
        //关联输出流
        OutputStream outputStream = new FileOutputStream(targetFile);

        //可以使用工具类进行读写操作  复制文件
        IOUtils.copy(inputStream,outputStream);

        System.out.println("上传成功");

        //返回上传文件的访问路径
        return "http://localhost:8080/upDir/"+fileName;
    }

}
