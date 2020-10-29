package com.amos.service.Impl;

import com.amos.dao.TypeDao;
import com.amos.entity.Type;
import com.amos.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-28 21:19
 *
 * # @Service注解：用于标注业务层组件
 *
 * # @Autowired注解：@Autowired表示被修饰的类需要注入对象,spring会扫描所有被@Autowired标注的类,然后根据类型在ioc容器中找到匹配的类注入
 *
 * # @Transactional注解：实现事务操作
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }
}
