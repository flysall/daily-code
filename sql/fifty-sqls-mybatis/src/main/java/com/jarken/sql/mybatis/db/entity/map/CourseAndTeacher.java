package com.jarken.sql.mybatis.db.entity.map;

import com.jarken.sql.mybatis.db.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseAndTeacher {

    private String cId;

    private String cName;

    private Teacher teacher;
}
