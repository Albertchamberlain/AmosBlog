package com.amos.dao;

import com.amos.entity.Blog;
import com.amos.queryvo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
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
}