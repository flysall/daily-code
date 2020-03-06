package com.jarken.fifty.sql.mybatis.db.mapper.join;

import com.jarken.fifty.sql.mybatis.db.entity.join.CourseJoinTeacher;
import com.jarken.fifty.sql.mybatis.db.entity.join.StudentJoinCourse;

import java.util.List;

/**
 * 包含一对一，一对多，多对多查询
 * @author flysall
 */
public interface AssociationQueryMapper {

    /**
     * 一对一, 关联查询课程及老师
     */
    List<CourseJoinTeacher> selectCourseAndTeacher();

    /**
     * 多对多，student与course表构成多对多关系，通过score表进行关联。
     * 查询顺序是以student作为主表，然后join关联表score，最后join course表
     */
    List<StudentJoinCourse> selectStudentAndCourse();
}
