package com.niuma.langbei.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 动态评论关联表
 * @TableName dynamic_comment
 */
@TableName(value ="dynamic_comment")
@Data
public class DynamicComment implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "userId")
    private Integer userid;

    /**
     * 动态id
     */
    @TableField(value = "dynamicId")
    private Integer dynamicid;

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