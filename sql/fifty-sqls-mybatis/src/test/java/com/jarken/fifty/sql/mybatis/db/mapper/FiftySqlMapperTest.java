package com.jarken.fifty.sql.mybatis.db.mapper;

import com.jarken.fifty.sql.mybatis.db.entity.join.CourseJoinTeacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class FiftySqlMapperTest {

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
            FiftySqlMapper mapper = session.getMapper(FiftySqlMapper.class);
            List<CourseJoinTeacher> courseJoinTeachers = mapper.selectCourseAndTeacher();
            System.out.println(">>> courseJoinTeachers are:");
            for (CourseJoinTeacher column : courseJoinTeachers) {
                System.out.println(column);
            }
        }
    }
}
