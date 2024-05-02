package com.niuma.langbei.controller;


import com.niuma.langbei.common.BaseResponse;
import com.niuma.langbei.common.ErrorCode;
import com.niuma.langbei.common.ResultUtils;
import com.niuma.langbei.exception.BusinessException;
import com.niuma.langbei.model.domain.Article;
import com.niuma.langbei.model.domain.CarouselArticle;
import com.niuma.langbei.service.CarouselArticleService;
import com.niuma.langbei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/carouselArticle")
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
public class CarouselArticleController {

    @Resource
    private CarouselArticleService carouselArticleService;
    @Resource
    private UserService userService;

    @GetMapping("/getByCarouselArticle")
    public BaseResponse<List<CarouselArticle>> getByArticleId( Integer id,HttpServletRequest request){
        userService.getLoginUser(request);
        List<CarouselArticle> carouselArticleList = carouselArticleService.list();
        return ResultUtils.success(carouselArticleList);
    }
/*    @PostMapping("/")
    public BaseResponse<Boolean> addArticle(@RequestBody Article articleAddRequest,HttpServletRequest request){
        userService.getLoginUser(request);
        boolean isAdmin = userService.isAdmin(request);
        if (isAdmin){
            throw new BusinessException(ErrorCode.NO_AUTH,"未登录");
        }
        Boolean result = articleService.save(articleAddRequest);
        return ResultUtils.success(result);
    }*/
}
