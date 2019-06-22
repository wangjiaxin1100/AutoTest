package com.ab.dao;

import java.util.LinkedHashMap;
import java.util.List;

public interface BaseMapper {
    List<LinkedHashMap<String, Object>> select(String sql);
    int insert(String sql);
    int update(String sql);
    int delete(String sql);
}
