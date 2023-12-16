package cn.neusoft.query;

import lombok.Data;

/**
 * 分页条件类
 */
@Data
public class BaseQuery {

    private Integer current;
    private Integer size;

}
