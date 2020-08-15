select student_name, student_surname, student_email
from students, student_class
where students.student_id = student_class.fk_student_id and student_class.fk_class_id 
in (select class_id from classes where class_name = "1a");

select student_name, student_surname, student_email
from students, student_class
where students.student_id = student_class.fk_student_id and student_class.fk_class_id = 1;

create table teacher_class(
	fk_teacher_id int,
    fk_class_id int,
	FOREIGN KEY (fk_teacher_id) references teachers(teacher_id), 
    FOREIGN KEY (fk_class_id) references classes(class_id)
);

insert into teacher_class(fk_teacher_id, fk_class_id) values(1, 1);
insert into teacher_class(fk_teacher_id, fk_class_id) values(4, 1);
insert into teacher_class(fk_teacher_id, fk_class_id) values(2, 2);
insert into teacher_class(fk_teacher_id, fk_class_id) values(3, 3);
insert into teacher_class(fk_teacher_id, fk_class_id) values(2, 3);
insert into teacher_class(fk_teacher_id, fk_class_id) values(4, 4);