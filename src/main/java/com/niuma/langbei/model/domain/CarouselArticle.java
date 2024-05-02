package com.niuma.langbei.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 轮播图_文章
 * @TableName carousel_article
 */
@TableName(value ="carousel_article")
@Data
public class CarouselArticle implements Serializable {
    /**
     * 轮播图id
     */
    @TableId(value = "carouselId", type = IdType.AUTO)
    private Integer carouselid;

    /**
     * 文章id
     */
    @TableField(value = "articleId")
    private Integer articleid;

    /**
     * 轮播图头像
     */
    @TableField(value = "carouserUrl")
    private String carouserurl;

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
     * 是否删除
     */
    @TableField(value = "isDelete")
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}