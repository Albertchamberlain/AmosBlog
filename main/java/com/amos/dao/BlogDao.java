package com.amos.dao;

import com.amos.entity.Blog;
import com.amos.queryvo.BlogQuery;
import com.amos.queryvo.DetailedBlog;
import com.amos.queryvo.FirstPageBlog;
import com.amos.queryvo.RecommendBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-29 22:00
 */
@Mapper
@Repository
public interface BlogDao {

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
    List<BlogQuery> getAllBlogQuery();

    /**
     * 查询首页最新博客列表信息
     * @return
     */
    List<FirstPageBlog> getFirstPageBlog();

    /**
     * 查询首页最新推荐信息
     * @return
     */
    List<RecommendBlog> getAllRecommendBlog();

    /**
     * 搜索博客列表
     * @param query
     * @return
     */
    List<FirstPageBlog> getSearchBlog(@Param("query") String query);

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
    DetailedBlog getDetailedBlog(Long id);

    /**
     * 文章访问更新
     * @param id
     * @return
     */
    int updateViews(Long id);

    /**
     * 根据博客id查询出评论数量
     * @param id
     * @return
     */
    int getCommentCountById(Long id);

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
