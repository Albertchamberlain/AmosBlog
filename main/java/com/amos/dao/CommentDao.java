package com.amos.dao;
import com.amos.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Amos
 * @date 2020-10-30 23:58
 */
@Mapper
@Repository
public interface CommentDao {
    /**
     * 查询父级评论
     * @param blogId
     * @param blogParentId
     * @return
     */
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    /**
     * 查询一级回复
     * @param blogId
     * @param id
     * @return
     */
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    /**
     * 查询二级回复
     * @param blogId
     * @param childId
     * @return
     */
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);

    /**
     * 添加一个评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);

    /**
     * 删除评论
     * @param id
     */
    void deleteComment(Long id);

}
