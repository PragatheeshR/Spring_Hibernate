USE `ACADEMIC_DIRECTORY`;

CREATE TABLE `STUDENT`(
	
    `id` int(10) NOT NULL PRIMARY KEY auto_increment,
	`first_name` varchar(25),
    `last_name` varchar(25),
    `department` varchar(25),
    `email` varchar(25),
    `phone_number` varchar(12)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `STUDENT_DETAILS`(
	`id` int(10) NOT NULL PRIMARY KEY auto_increment,
    `father_name` varchar(25),
    `address` varchar(25),
    `blood_group` varchar(3),
    `student_id` int(10),
    
    foreign key(`student_id`) references  student(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;