package com.jarken.fifty.sql.mybatis.db.entity.enhanced;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.jarken.fifty.sql.mybatis.db.entity.Class;

import java.util.List;

/**
 * 留意与{@link com.jarken.fifty.sql.mybatis.db.entity.Grade}这个类的区别
 * @author flysall
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeJoinClass {

    private Long gId;

    private String gName;

    private List<Class> classes;
}
