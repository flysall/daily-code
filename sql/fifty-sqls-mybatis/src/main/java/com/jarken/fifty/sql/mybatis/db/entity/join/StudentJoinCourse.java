package com.jarken.fifty.sql.mybatis.db.entity.join;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentJoinCourse {

    private String sId;

    private String sName;

    private String sBirth;

    private String sSex;

    private List<Score> scores;
}
