package com.niuma.langbei.model.vo;


import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleVo implements Serializable {
    private static final long serialVersionUID = 7289362995098717607L;


    /**
     * 自增id
     */
    private Integer id;

    /**
     * 文章名字
     */
    private String name;

    /**
     * 比赛的时间
     */
    private String time;

    /**
     * 文章内容
     */
    private String context;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     *更新时间
     */
    private Date updatetime;

}
