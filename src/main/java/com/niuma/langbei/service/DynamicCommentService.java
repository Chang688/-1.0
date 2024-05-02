package com.niuma.langbei.service;


import com.niuma.langbei.model.domain.DynamicComment;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niuma.langbei.model.vo.DynamicVO;

import java.util.List;

/**
* @author changwei
* @description 针对表【dynamic_comment(动态评论关联表)】的数据库操作Service
* @createDate 2023-05-09 10:42:42
*/
public interface DynamicCommentService extends IService<DynamicComment> {

    List<DynamicVO> getDynamic(int user_id);

}
