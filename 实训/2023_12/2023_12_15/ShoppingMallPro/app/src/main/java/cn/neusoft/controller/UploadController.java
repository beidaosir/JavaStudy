package cn.neusoft.controller;

import cn.neusoft.vo.ResponseObj;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    /**
     * 上传到七牛云的服务器
     * @param upFile
     * @return
     */
    @PostMapping("/up")
    public ResponseObj uploadFile(MultipartFile upFile) throws IOException {
        System.out.println("上传文件："+upFile);
        Configuration cfg = new Configuration(Region.huadongZheJiang2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本

        UploadManager uploadManager = new UploadManager(cfg);

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

            if (response.statusCode == 200){
                System.out.println("*********上传成功****************");
                return ResponseObj.SUCCESS("http://s4tdoh0lx.bkt.clouddn.com/"+fileName);
            }

        } catch (QiniuException ex) {
            ex.printStackTrace();
        }

        return ResponseObj.ERROR(502,"上传失败");
    }

}
