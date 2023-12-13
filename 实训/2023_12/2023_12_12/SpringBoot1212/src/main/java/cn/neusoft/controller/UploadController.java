package cn.neusoft.controller;

import cn.neusoft.exception.AppException;
import cn.neusoft.exception.AppExceptionCodeMsg;
import cn.neusoft.vo.ResponseObj;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@RestController
@Api(value = "文件上传的API",description="文件上传的功能")
public class UploadController {

    @ApiOperation(value = "上传文件" )
    @PostMapping("/up")
    public ResponseObj uploadFile(@RequestPart("upFile") MultipartFile upFile){
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

            return ResponseObj.SUCCESS("上传成功","http://s4tdoh0lx.bkt.clouddn.com/"+fileName);

        } catch (Exception ex) {
            throw new AppException(AppExceptionCodeMsg.UPLOAD_ERROR);
        }

    }

}
