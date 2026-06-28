CREATE DATABASE employee_payroll_system;

use employee_payroll_system;

CREATE TABLE employees(
                          emp_id INT PRIMARY KEY AUTO_INCREMENT,
                          name  varchar(100) not null,
                          age INT not null,
                          email varchar(100) unique,
                          mobile varchar(10),
                          department varchar(50),
                          designation varchar(50),
                          basic_salary double
);

INSERT INTO employees
(name, age, email, mobile, department, designation, basic_salary)
VALUES
    ('Aryan Malhotra',26,'aryan.malhotra@gmail.com','9810001026','IT','Developer',57000),
    ('Krish Kapoor',24,'krish.kapoor@gmail.com','9810001027','HR','Executive',36000),
    ('Devansh Chadha',29,'devansh.chadha@gmail.com','9810001028','Finance','Manager',93000),
    ('Naman Grover',27,'naman.grover@gmail.com','9810001029','Sales','Executive',43000),
    ('Arjun Luthra',30,'arjun.luthra@gmail.com','9810001030','IT','Senior Developer',85000),
    ('Yashvardhan Mehra',25,'yashvardhan.mehra@gmail.com','9810001031','Marketing','Executive',46000),
    ('Harshit Kalra',28,'harshit.kalra@gmail.com','9810001032','Finance','Analyst',61000),
    ('Aakash Saini',31,'aakash.saini@gmail.com','9810001033','IT','Team Lead',99000),
    ('Raghav Bhatia',23,'raghav.bhatia@gmail.com','9810001034','HR','Executive',34000),
    ('Kartik Dutta',26,'kartik.dutta@gmail.com','9810001035','Sales','Developer',56000),
    ('Samar Bhalla',27,'samar.bhalla@gmail.com','9810001036','Marketing','Manager',78000),
    ('Tushar Kohli',29,'tushar.kohli@gmail.com','9810001037','Finance','Manager',96000),
    ('Niharika Bedi',24,'niharika.bedi@gmail.com','9810001038','IT','Developer',54000),
    ('Meher Arora',25,'meher.arora@gmail.com','9810001039','Marketing','Executive',42000),
    ('Diya Sachdeva',22,'diya.sachdeva@gmail.com','9810001040','HR','Executive',35000),
    ('Aditi Narula',28,'aditi.narula@gmail.com','9810001041','Finance','Analyst',60000),
    ('Rhea Chhabra',26,'rhea.chhabra@gmail.com','9810001042','Sales','Executive',41000),
    ('Sanya Batra',27,'sanya.batra@gmail.com','9810001043','Marketing','Developer',58000),
    ('Trisha Gulati',30,'trisha.gulati@gmail.com','9810001044','HR','Manager',74000),
    ('Ira Walia',23,'ira.walia@gmail.com','9810001045','Finance','Executive',39000),
    ('Anshul Pahwa',32,'anshul.pahwa@gmail.com','9810001046','IT','Manager',102000),
    ('Keshav Bahl',28,'keshav.bahl@gmail.com','9810001047','Sales','Manager',83000),
    ('Madhav Sehgal',25,'madhav.sehgal@gmail.com','9810001048','IT','Developer',59000),
    ('Eshan Miglani',24,'eshan.miglani@gmail.com','9810001049','Marketing','Executive',44000);