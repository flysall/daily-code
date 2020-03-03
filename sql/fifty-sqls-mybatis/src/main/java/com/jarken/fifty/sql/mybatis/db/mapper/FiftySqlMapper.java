package com.jarken.fifty.sql.mybatis.db.mapper;

import com.jarken.fifty.sql.mybatis.db.entity.join.CourseJoinTeacher;

import java.util.List;

public interface FiftySqlMapper {

    /**
     * 一对一, 联结查询课程及老师
     */
    List<CourseJoinTeacher> selectCourseAndTeacher();
}
