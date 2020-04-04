package com.jarken.fifty.sql.mybatis.db.mapper.enhanced;

import com.jarken.fifty.sql.mybatis.db.entity.enhanced.CourseJoinTeacher;
import com.jarken.fifty.sql.mybatis.db.entity.enhanced.GradeJoinClass;
import com.jarken.fifty.sql.mybatis.db.entity.enhanced.StudentJoinCourse;

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
     * 一对多，关联查询年级与班级
     */
    List<GradeJoinClass> selectGradeAndClass();

    /**
     * 多对多，student与course表构成多对多关系，通过score表进行关联。
     * 查询顺序是以student作为主表，然后join关联表score，最后join course表
     */
    List<StudentJoinCourse> selectStudentAndCourse();
}
