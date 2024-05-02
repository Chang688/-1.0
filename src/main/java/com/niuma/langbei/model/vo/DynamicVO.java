package com.niuma.langbei.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class DynamicVO implements Serializable {
    


        /**
         * 自增id
         */

        private Integer id;

        /**
         * 用户名字
         */

        private String name;

    /**
     * 用户名字
     */

        private Integer userid;

    /**
     * 用户头像
     */
        private String avtarUrl;
        /**
         * 动态内容
         */

        private String context;

        /**
         * 0-发的动态 1-代表评论
         */
        private Integer status;

        /**
         * 创建时间
         */

        private Date createtime;
    /**
     * 评论
     */
    private List<DynamicVO> listDynamic;

        @TableField(exist = false)
        private static final long serialVersionUID = 1L;





}
