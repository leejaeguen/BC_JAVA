package com.worms.section02.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("SELECT NOW()")
    java.util.Date selectNow();
}