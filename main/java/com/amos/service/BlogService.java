package com.amos.service;

import com.amos.entity.Blog;
import com.amos.queryvo.BlogQuery;
import com.amos.queryvo.DetailedBlog;
import com.amos.queryvo.FirstPageBlog;
import com.amos.queryvo.RecommendBlog;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-29 23:10
 */
public interface BlogService {

    /**
     * 保存新增博客
     * @param blog
     * @return
     */
    int saveBlog(Blog blog);

    /**
     * 查询文章管理列表
     * @return
     */
    List<BlogQuery> getAllBlog();

    /**
     * 查询首页最新博客列表信息
     * @return
     */
    List<FirstPageBlog> getAllFirstPageBlog();

    /**
     * 查询首页最新推荐信息
     * @return
     */
    List<RecommendBlog> getRecommendedBlog();

    /**
     * 搜索博客列表
     * @param query
     * @return
     */
    List<FirstPageBlog> getSearchBlog(String query);

    /**
     * 统计博客总数
     * @return
     */
    Integer getBlogTotal();

    /**
     * 查询博客详情
     * @param id
     * @return
     */
    DetailedBlog getDetailedBlog(Long id) throws NotFoundException;

    /**
     * 统计访问总数
     * @return
     */
    Integer getBlogViewTotal();

    /**
     * 统计评论总数
     * @return
     */
    Integer getBlogCommentTotal();

    /**
     * 统计留言总数
     * @return
     */
    Integer getBlogMessageTotal();
}
