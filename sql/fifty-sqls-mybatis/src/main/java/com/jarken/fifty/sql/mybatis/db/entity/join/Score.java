package com.jarken.fifty.sql.mybatis.db.entity.join;

import com.jarken.fifty.sql.mybatis.db.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * score表作为student和course多对多关系的关联表，被放在了join包下；
 * 同时，它作为一张关联表，它的成员变量并不与数据库的字段一一对应，
 * 数据库score表中的s_id字段在Score类中没有对应成员变量，
 * c_id字段对应course。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    private Course course;

    private Integer sScore;
}
