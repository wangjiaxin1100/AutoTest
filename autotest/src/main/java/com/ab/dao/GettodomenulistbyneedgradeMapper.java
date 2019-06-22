package com.ab.dao;

import com.ab.model.Gettodomenulistbyneedgrade;
import java.util.List;

public interface GettodomenulistbyneedgradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gettodomenulistbyneedgrade record);

    Gettodomenulistbyneedgrade selectByPrimaryKey(Integer id);

    List<Gettodomenulistbyneedgrade> selectAll();

    int updateByPrimaryKey(Gettodomenulistbyneedgrade record);
}