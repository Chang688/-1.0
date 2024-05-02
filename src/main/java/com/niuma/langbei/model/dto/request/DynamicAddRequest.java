package com.niuma.langbei.model.dto.request;

import com.niuma.langbei.model.vo.DynamicVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户登录请求体
 *
 * @author changwei
 */
@Data
public class DynamicAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 动态内容
     */
    private String context;

    /**
     * 0-发的动态 1-代表评论
     */
    private Integer status;
    /**
     * 父id，动态id
     */
    private Integer Fid;

}
