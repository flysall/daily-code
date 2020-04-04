package com.jarken.fifty.sql.mybatis.db.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jarken.fifty.sql.mybatis.db.entity.enhanced.CourseJoinTeacher;
import com.jarken.fifty.sql.mybatis.db.entity.enhanced.GradeJoinClass;
import com.jarken.fifty.sql.mybatis.db.entity.enhanced.StudentJoinCourse;
import com.jarken.fifty.sql.mybatis.db.mapper.enhanced.AssociationQueryMapper;
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
            System.out.println(">>> gradeJoinClasses are:");
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

    /**
     * 一对一查询分页，分页成功
     */
    @Test
    public void testSelectCourseAndTeacherPage() {
        try (SqlSession session = sessionFactory.openSession()) {
            AssociationQueryMapper mapper = session.getMapper(AssociationQueryMapper.class);
            PageInfo<CourseJoinTeacher> pageInfo = PageHelper.startPage(1, 2)
                    .doSelectPageInfo(mapper::selectCourseAndTeacher);
            showPageInfo(pageInfo);
            System.out.println(">>> courseJoinTeachers in current page are:");
            for (CourseJoinTeacher courseJoinTeacher : pageInfo.getList()) {
                System.out.println(courseJoinTeacher);
            }
        }
    }

    /**
     * 一对多查询，分页失败。原因是pagehelper是按sql查询结果的行数来分页的。
     * 多对多查询同理
     */
    @Test
    public void testSelectGradeAndClass() {
        try (SqlSession session = sessionFactory.openSession()) {
            AssociationQueryMapper mapper = session.getMapper(AssociationQueryMapper.class);
            PageInfo<GradeJoinClass> pageInfo = PageHelper.startPage(1, 2, true)
                    .doSelectPageInfo(mapper::selectGradeAndClass);
            showPageInfo(pageInfo);
            System.out.println(">>> gradeJoinClass in current page are:");
            for (GradeJoinClass gradeJoinClass : pageInfo.getList()) {
                System.out.println(gradeJoinClass);
            }
        }
    }

    private <T> void showPageInfo(PageInfo<T> pageInfo) {
        int page = pageInfo.getPageNum();
        int totalPage = pageInfo.getPages();
        int pageSize = pageInfo.getSize();
        System.out.println(">>> pageInfo are:");
        System.out.println("page = " + page + ", totalPage = " + totalPage + ", pageSize = " + pageSize);
    }
}
