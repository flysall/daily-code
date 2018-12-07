-- 48、查询下周过生日的学生

SELECT * FROM student WHERE WEEK(DATE_FORMAT(NOW(), '%Y%m%d')) + 1 = WEEK(s_birth);

-- 终极sql
    select * from student where WEEK(DATE_FORMAT(NOW(),'%Y%m%d'))+1 =WEEK(s_birth);

-- 查询结果
/*
Empty set (0.00 sec)

Empty set (0.00 sec)
*/