package com.beidao.mall.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录成功响应结果实体类")
public class LoginVo {

    @Schema(description = "令牌")
    private String token ;//token标志用户的唯一标识

    @Schema(description = "刷新令牌,可以为空")
    private String refresh_token ;

}
