package com.zhiyue.manager.dao;

import com.zhiyue.manager.entity.PersonFiles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonFilesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonFiles record);

    int insertSelective(PersonFiles record);

    PersonFiles selectByPrimaryKey(Integer id);

    List<PersonFiles> selectPersonFiles(PersonFiles personFiles);

    int updateByPrimaryKeySelective(PersonFiles record);

    int updateByPrimaryKey(PersonFiles record);
}