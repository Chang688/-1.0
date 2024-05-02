package com.niuma.langbei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.langbei.mapper.DynamicCommentMapper;
import com.niuma.langbei.model.domain.Dynamic;
import com.niuma.langbei.model.domain.DynamicComment;
import com.niuma.langbei.model.vo.DynamicVO;
import com.niuma.langbei.service.DynamicCommentService;
import com.niuma.langbei.service.DynamicService;
import com.niuma.langbei.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author changwei
* @description 针对表【dynamic_comment(动态评论关联表)】的数据库操作Service实现
* @createDate 2023-05-09 10:42:42
*/
@Service
public class DynamicCommentServiceImpl extends ServiceImpl<DynamicCommentMapper, DynamicComment>
    implements DynamicCommentService {

    @Resource
    private DynamicService dynamicService;
    @Resource
    private UserService userService;
    @Override
    public List<DynamicVO> getDynamic(int user_id){
        QueryWrapper<DynamicComment> queryWrapper = new QueryWrapper();
        queryWrapper = queryWrapper.like("userId", user_id);
        List<DynamicComment> dynamicCommentList = this.list(queryWrapper);
        List<DynamicVO> dynamicVOList = new ArrayList<>();
        for (DynamicComment dynamicComment:dynamicCommentList){
            int dynamicid = dynamicComment.getDynamicid();

            Dynamic byId = dynamicService.getById(dynamicid);
            DynamicVO dynamicVO = new DynamicVO();
            dynamicVO.setId(byId.getId());
            dynamicVO.setUserid(byId.getUserid());
            dynamicVO.setCreatetime(byId.getCreatetime());
            dynamicVO.setContext(byId.getContext());
            dynamicVO.setAvtarUrl(userService.getById(byId.getUserid()).getAvatarUrl());
            dynamicVO.setName(userService.getById(byId.getUserid()).getUsername());
            dynamicVOList.add(dynamicVO);
        }
        return dynamicVOList;
    }
}




