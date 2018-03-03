use TEST;

create table Employees (
    id int not null,
    age int not null,
    first varchar(255),
    last varchar(255)
);

insert into Employees values (100, 18, 'Zara', 'Ali');

insert into Employees values (101, 25, 'Mathnaz', 'Fatma');

insert into Employees values (102, 30, 'Zaid', 'Khan');

insert into Employees values (103, 28, 'Sumit', 'Mittal');
