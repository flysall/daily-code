package com.jarken.fifty.sql.mybatis.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author flysall
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String cId;

    private String cName;

    private String tId;
}
