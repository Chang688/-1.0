package com.niuma.langbei.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niuma.langbei.common.BaseResponse;
import com.niuma.langbei.common.DeleteRequest;
import com.niuma.langbei.common.ErrorCode;
import com.niuma.langbei.common.ResultUtils;
import com.niuma.langbei.exception.BusinessException;
import com.niuma.langbei.model.domain.Dynamic;
import com.niuma.langbei.model.domain.DynamicComment;
import com.niuma.langbei.model.domain.User;
import com.niuma.langbei.model.domain.UserTeam;
import com.niuma.langbei.model.dto.request.DynamicAddRequest;
import com.niuma.langbei.model.vo.DynamicVO;
import com.niuma.langbei.service.DynamicCommentService;
import com.niuma.langbei.service.DynamicService;
import com.niuma.langbei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dynamic")
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
public class DynamicController {
    @Resource
    private DynamicService dynamicService;

    @Resource
    private DynamicCommentService dynamicCommentService;
    @Resource
    private UserService userService;


    @GetMapping("/getDynamic")
    public BaseResponse<List<DynamicVO>> getDynamic(HttpServletRequest request){
        userService.getLoginUser(request);

        QueryWrapper<Dynamic> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.like("status",0);
        List<Dynamic> dynamicList = dynamicService.list(queryWrapper);
        List<DynamicVO> dynamicVOList = new ArrayList<>();
        for (Dynamic dynamic:dynamicList){
            DynamicVO dynamicVO = new DynamicVO();
            dynamicVO.setId(dynamic.getId());
            dynamicVO.setUserid(dynamic.getUserid());
            dynamicVO.setCreatetime(dynamic.getCreatetime());
            dynamicVO.setContext(dynamic.getContext());
            dynamicVO.setAvtarUrl(userService.getById(dynamic.getUserid()).getAvatarUrl());
            dynamicVO.setName(userService.getById(dynamic.getUserid()).getUsername());
            dynamicVO.setListDynamic(dynamicCommentService.getDynamic(dynamic.getId()));
            dynamicVOList.add(dynamicVO);
        }

        return ResultUtils.success(dynamicVOList);
    }
    @PostMapping ("/createDynamic")
    public BaseResponse<Boolean> createDynamic(@RequestBody DynamicAddRequest dynamicAddRequest,HttpServletRequest request){
        userService.getLoginUser(request);
        Dynamic dynamic =new Dynamic();
        dynamic.setId(null);
        dynamic.setContext(dynamicAddRequest.getContext());
        dynamic.setUserid(dynamicAddRequest.getUserid());
        dynamic.setStatus(dynamicAddRequest.getStatus());
        Boolean save = dynamicService.save(dynamic);
        Integer dynamic_id  = dynamic.getId();
        if (!save || dynamic.getId()==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "添加评论失败");
        }
        if(dynamicAddRequest.getStatus()==1 || dynamicAddRequest.getFid()>0){
            DynamicComment dynamicComment = new DynamicComment();
            dynamicComment.setUserid(dynamicAddRequest.getFid());
            dynamicComment.setDynamicid(dynamic_id);
            dynamicCommentService.save(dynamicComment);
        }
        return ResultUtils.success(save);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteTeam(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {

        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = deleteRequest.getId();
        User loginUser = userService.getLoginUser(request);
        boolean res = dynamicService.removeById(deleteRequest.getId());
        if (!res) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "删除动态失败");
        }
        QueryWrapper<DynamicComment> queryWrapper = new QueryWrapper<>();
        long dynamicId = deleteRequest.getId();
        queryWrapper.eq("userId", dynamicId);
        //移除关系
        dynamicCommentService.remove(queryWrapper);
        return ResultUtils.success(true);
    }
}
