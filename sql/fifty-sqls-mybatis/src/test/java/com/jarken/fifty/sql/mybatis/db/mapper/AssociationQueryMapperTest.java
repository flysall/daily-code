package com.jarken.fifty.sql.mybatis.db.mapper;

import com.jarken.fifty.sql.mybatis.db.entity.join.CourseJoinTeacher;
import com.jarken.fifty.sql.mybatis.db.entity.join.GradeJoinClass;
import com.jarken.fifty.sql.mybatis.db.entity.join.StudentJoinCourse;
import com.jarken.fifty.sql.mybatis.db.mapper.join.AssociationQueryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AssociationQueryMapperTest {

    private static final String MYBATIS_CONFIGURATION_PATH = "/mybatis-config.xml";

    private SqlSessionFactory sessionFactory;

    @Before
    public void initSessionFactory() {
        InputStream stream = this.getClass().getResourceAsStream(MYBATIS_CONFIGURATION_PATH);
        if (stream == null) {
            throw new RuntimeException("stream is null, please check file " + MYBATIS_CONFIGURATION_PATH + " exist");
        }

        sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    }

    @Test
    public void testSelectCourseAndTeacher() {
        try (SqlSession session = sessionFactory.openSession()) {
            AssociationQueryMapper mapper = session.getMapper(AssociationQueryMapper.class);
            List<CourseJoinTeacher> courseJoinTeachers = mapper.selectCourseAndTeacher();
            System.out.println(">>> courseJoinTeachers are:");
            for (CourseJoinTeacher column : courseJoinTeachers) {
                System.out.println(column);
            }
        }
    }

    @Test
    public void testSelectGradeAndCourse() {
        try (SqlSession session = sessionFactory.openSession()) {
            AssociationQueryMapper mapper = session.getMapper(AssociationQueryMapper.class);
            List<GradeJoinClass> gradeJoinClasses = mapper.selectGradeAndClass();
            for (GradeJoinClass gradeJoinClass : gradeJoinClasses) {
                System.out.println(gradeJoinClass);
            }
        }
    }

    @Test
    public void testSelectStudentAndCourse() {
        try (SqlSession session = sessionFactory.openSession()) {
            AssociationQueryMapper mapper = session.getMapper(AssociationQueryMapper.class);
            List<StudentJoinCourse> studentJoinCourses = mapper.selectStudentAndCourse();
            System.out.println(">>> studentJoinCourse are:");
            for (StudentJoinCourse studentJoinCourse : studentJoinCourses) {
                System.out.println(studentJoinCourse);
            }
        }
    }
}
