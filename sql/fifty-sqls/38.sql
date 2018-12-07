-- 38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名； 

SELECT a.s_id, a.s_name FROM student a 
    JOIN score b ON a.s_id = b.s_id 
    WHERE b.s_score > 80 AND b.c_id = '01';
