package com.amos.service;

import com.amos.entity.Type;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-28 21:18
 */
public interface TypeService {
    /**
     * 新增保存分类
     * @param type
     * @return
     */
    int saveType(Type type);

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 查询所有分类
     * @return
     */
    List<Type> getAllType();

    /**
     * 根据分类名称查询分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 编辑修改分类
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
