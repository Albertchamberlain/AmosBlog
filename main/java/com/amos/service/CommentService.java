package com.amos.service;

import com.amos.entity.Comment;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-31 00:03
 */
public interface CommentService {
    /**
     * 根据博客id查询评论信息
     * @param blogId
     * @return
     */
    List<Comment> listCommentByBlogId(Long blogId);

    /**
     * 添加保存评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     * @param id
     */
    void deleteComment(Comment comment,Long id);
}
