package com.niuma.langbei.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.langbei.model.domain.Article;
import com.niuma.langbei.service.ArticleService;
import org.springframework.stereotype.Service;
import com.niuma.langbei.mapper.ArticleMapper;

/**
* @author changwei
* @description 针对表【article(文章表)】的数据库操作Service实现
* @createDate 2023-04-13 10:35:20
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

}




