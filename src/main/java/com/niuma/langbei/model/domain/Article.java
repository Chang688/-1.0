package com.niuma.langbei.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章表
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;


    /**
     * 比赛的时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 文章内容
     */
    @TableField(value = "context")
    private String context;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createtime;

    /**
     * 
     */
    @TableField(value = "updateTime")
    private Date updatetime;

    /**
     *
     */
    @TableField(value = "status")
    private int status;

    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}