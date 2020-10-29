package com.amos.dao;

import com.amos.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-28 21:07
 */

@Mapper
@Repository
public interface TypeDao {
    /**
     * 新增保存分类
     * @param type
     * @return
     */
    int saveType(Type type);

    /**
     * 查询所有分类
     * @return
     */
    List<Type> getAllType();

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Type getType(Long id);


    /**
     * 根据分类名称查询分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     *
     * @param type
     * @return
     */
    int updateType(Type type);

    /**
     * 删除分类
     * @param id
     */
    void deleteType(Long id);

}
