package com.amos.service.Impl;

import com.amos.dao.BlogDao;
import com.amos.entity.Blog;
import com.amos.queryvo.BlogQuery;
import com.amos.queryvo.DetailedBlog;
import com.amos.queryvo.FirstPageBlog;
import com.amos.queryvo.RecommendBlog;
import com.amos.service.BlogService;
import com.amos.util.MarkDownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * @author Amos
 * @date 2020-10-29 23:11
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    /**
     * 保存新增博客
     * @param blog
     * @return
     */
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    /**
     * 查询文章管理列表
     * @return
     */
    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    /**
     * 查询首页最新博客列表信息
     * @return
     */
    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    /**
     * 查询首页最新推荐信息
     * @return
     */
    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        return blogDao.getAllRecommendBlog();
    }

    /**
     * 搜索博客列表
     * @param query
     * @return
     */
    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    /**
     * 统计博客总数
     * @return
     */
    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) throws NotFoundException {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkDownUtils.markdownToHtmlExtensions(content));
        //文章访问数量自增
        blogDao.updateViews(id);
        //文章评论数量更新
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    /**
     * 统计访问总数
     * @return
     */
    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    /**
     * 统计评论总数
     * @return
     */
    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    /**
     * 统计留言总数
     * @return
     */
    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }
}
