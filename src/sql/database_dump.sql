CREATE DATABASE IF NOT EXISTS CR7_Ekinci;

use CR7_Ekinci; 

drop table if exists teachers, students, classes, student_class;

create table teachers(
  teacher_id int NOT NULL auto_increment,
  teacher_name varchar(50),
  teacher_surname varchar(50), 
  teacher_email varchar(50),
  primary key(teacher_id)
);

create table students(
   student_id int NOT NULL auto_increment,
   student_name varchar(50),
   student_surname varchar(50), 
   student_email varchar(50),
   primary key(student_id)
);

create table classes(
  class_id int NOT NULL auto_increment,
  class_name varchar(10),
  primary key(class_id)
);

insert into teachers(teacher_name, teacher_surname, teacher_email) values('Manfred', 'Wagner', 'wagner@wagner.a');
insert into teachers(teacher_name, teacher_surname, teacher_email) values('Julia', 'Blatt', 'blatt@blatt.at');
insert into teachers(teacher_name, teacher_surname, teacher_email) values('Ahmed', 'Murdar', 'murda@murda.at');
insert into teachers(teacher_name, teacher_surname, teacher_email) values('Drake', 'Future', 'lifeisgood@lifeisgood.at');

insert into students(student_name, student_surname, student_email) values('John', 'Tischler', 'john@john.com');
insert into students(student_name, student_surname, student_email) values('Bea', 'Buttons', 'buttons@buttons.com');
insert into students(student_name, student_surname, student_email) values('Leila', 'Garden', 'garden@garden.com');
insert into students(student_name, student_surname, student_email) values('Melanie', 'Ekinci', 'ekinci@ekinci.com');
insert into students(student_name, student_surname, student_email) values('Susanna', 'Trello', 'trello@trello.com');
insert into students(student_name, student_surname, student_email) values('Metin', 'Mango', 'mango@mango.com');
insert into students(student_name, student_surname, student_email) values('Bilgi', 'Zara', 'zara@zara.com');
insert into students(student_name, student_surname, student_email) values('Simon', 'Lewis', 'lewis@lewis.com');
insert into students(student_name, student_surname, student_email) values('Cornelia', 'Coder', 'coder@coder.com');
insert into students(student_name, student_surname, student_email) values('Sedef', 'Mango', 'mango@mango.com');

insert into classes(class_name) values("1A");
insert into classes(class_name) values("2A");
insert into classes(class_name) values("3A");
insert into classes(class_name) values("4A");

create table student_class(
	fk_student_id int,
    fk_class_id int,
	FOREIGN KEY (fk_student_id) references students(student_id), 
    FOREIGN KEY (fk_class_id) references classes(class_id)
);

insert into student_class(fk_student_id, fk_class_id) values(1, 1);
insert into student_class(fk_student_id, fk_class_id) values(2, 1);
insert into student_class(fk_student_id, fk_class_id) values(3, 1);
insert into student_class(fk_student_id, fk_class_id) values(4, 2);
insert into student_class(fk_student_id, fk_class_id) values(4, 3);
insert into student_class(fk_student_id, fk_class_id) values(1, 3);
insert into student_class(fk_student_id, fk_class_id) values(2, 2);
insert into student_class(fk_student_id, fk_class_id) values(3, 3);
insert into student_class(fk_student_id, fk_class_id) values(1, 3);
insert into student_class(fk_student_id, fk_class_id) values(2, 3);

create table teacher_class(
	fk_teacher_id int,
    fk_class_id int,
	FOREIGN KEY (fk_teacher_id) references teachers(teacher_id),
    FOREIGN KEY (fk_class_id) references classes(class_id)
);

insert into teacher_class(fk_teacher_id, fk_class_id) values(1, 1);
insert into teacher_class(fk_teacher_id, fk_class_id) values(2, 1);
insert into teacher_class(fk_teacher_id, fk_class_id) values(3, 1);
insert into teacher_class(fk_teacher_id, fk_class_id) values(4, 2);
insert into teacher_class(fk_teacher_id, fk_class_id) values(4, 3);
insert into teacher_class(fk_teacher_id, fk_class_id) values(1, 3);
insert into teacher_class(fk_teacher_id, fk_class_id) values(2, 2);
insert into teacher_class(fk_teacher_id, fk_class_id) values(3, 3);