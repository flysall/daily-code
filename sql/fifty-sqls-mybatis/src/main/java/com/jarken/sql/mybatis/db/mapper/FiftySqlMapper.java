package com.jarken.sql.mybatis.db.mapper;

import com.jarken.sql.mybatis.db.entity.map.CourseAndTeacher;

import java.util.List;

public interface FiftySqlMapper {

    /**
     * 一对一查询, 查询课程及老师
     */
    List<CourseAndTeacher> selectCourseAndTeacher();
}
