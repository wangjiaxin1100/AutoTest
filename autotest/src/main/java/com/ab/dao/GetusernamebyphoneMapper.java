package com.ab.dao;

import com.ab.model.Getusernamebyphone;
import java.util.List;

public interface GetusernamebyphoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Getusernamebyphone record);

    Getusernamebyphone selectByPrimaryKey(Integer id);

    List<Getusernamebyphone> selectAll();

    int updateByPrimaryKey(Getusernamebyphone record);
}