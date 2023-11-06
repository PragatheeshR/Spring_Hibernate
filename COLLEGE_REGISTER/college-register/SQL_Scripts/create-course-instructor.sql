use academic_directory;

create table course(
	id int(10) not null primary key auto_increment,
    course_name varchar(125)    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table course_student(
	course_id int(12),
    student_id int(12),
    primary key(course_id, student_id),
    foreign key (course_id) references course(id),
    foreign key (student_id) references student(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table instructor(
   id int(12) not null auto_increment primary key,
   first_name varchar(125),
   last_name varchar(125),
   email varchar(25),
   phone_numer varchar(12)
   
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table intructor_detail(
	id int not null auto_increment,
    dob date,
    address varchar(125),
    qualification varchar(50),
    instructor_id int(12),
    primary key(id),
    foreign key(instructor_id) references instructor(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


alter table course add column author varchar(125);

alter table instructor add column course_id int;
alter table instructor add foreign key(course_id) references course(id);