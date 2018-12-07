-- 50、查询下月过生日的学生

SELECT * FROM student WHERE MONTH(DATE_FORMAT(NOW(), '%Y%m%d'))+1 =
    MONTH(s_birth);

-- 终极sql
    select * from student where MONTH(DATE_FORMAT(NOW(),'%Y%m%d'))+1 =MONTH(s_birth);

-- 查询结果
/*
Empty set (0.00 sec)

Empty set (0.00 sec)
*/