package com.worms.transactional.section01.annotation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {
    List<Menu> selectMenuByMenuCodes(java.util.Map<java.lang.String,java.util.List<java.lang.Integer>> map);
}
