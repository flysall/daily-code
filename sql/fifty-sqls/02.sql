-- 2、查询"01"课程比"02"课程成绩低的学生的信息及课程分数

SELECT a.*, b.s_score AS 01_score, c.s_score AS 02_score FROM
    student AS a INNER JOIN score AS b ON a.s_id = b.s_id AND b.c_id = '01'
    INNER JOIN score AS c ON a.s_id = c.s_id AND c.c_id = '02' WHERE
    b.s_score < c.s_score;