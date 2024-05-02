package com.niuma.langbei.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niuma.langbei.common.BaseResponse;
import com.niuma.langbei.common.ErrorCode;
import com.niuma.langbei.common.ResultUtils;
import com.niuma.langbei.exception.BusinessException;
import com.niuma.langbei.model.domain.Article;
import com.niuma.langbei.model.domain.User;
import com.niuma.langbei.model.dto.request.ArticleAddRequest;
import com.niuma.langbei.service.ArticleService;
import com.niuma.langbei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private UserService userService;

    @GetMapping("/listArticle")
    public BaseResponse<List<Article>> listArticle(HttpServletRequest request) {

        userService.getLoginUser(request);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.like("status",0);
        List<Article> articleList = articleService.list(queryWrapper);
        if (articleList.isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "未找到文章信息");
        }
        return ResultUtils.success(articleList);
    }
    @GetMapping("/listShare")
    public BaseResponse<List<Article>> listShare(HttpServletRequest request) {
        userService.getLoginUser(request);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.like("status",1);
        List<Article> articleList = articleService.list(queryWrapper);
        if (articleList.isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "未找到分享经验信息");
        }
        return ResultUtils.success(articleList);
    }
    @GetMapping("/getByArticleId")
    public BaseResponse<Article> getByArticleId( Integer id,HttpServletRequest request){
        userService.getLoginUser(request);
        Article article = articleService.getById(id);
        return ResultUtils.success(article);
    }
    @PostMapping("/add")
    public BaseResponse<Boolean> addArticle(@RequestBody Article articleAddRequest,HttpServletRequest request){
        userService.getLoginUser(request);
        boolean isAdmin = userService.isAdmin(request);
        if (!isAdmin){
            throw new BusinessException(ErrorCode.NO_AUTH,"非管理员");
        }
        Boolean result = articleService.save(articleAddRequest);
        return ResultUtils.success(result);
    }
}
