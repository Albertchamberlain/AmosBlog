package com.amos.service;

import com.amos.entity.Blog;
import com.amos.queryvo.BlogQuery;

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
}
