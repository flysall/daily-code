package com.jarken.fifty.sql.mybatis.db.entity.enhanced;

import com.jarken.fifty.sql.mybatis.db.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 留意与{@link com.jarken.fifty.sql.mybatis.db.entity.Course}这个类的区别
 * @author flysall
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseJoinTeacher {

    private String cId;

    private String cName;

    private Teacher teacher;
}
