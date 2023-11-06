use academic_directory;

create table books(
	id int not null primary key auto_increment,
    book_name varchar(125),
    author varchar(100),
    isAvailable bool
)engine=InnoDB auto_increment=1 char set=latin1;

create table reviews(
	id int not null primary key auto_increment,
    review_descr varchar(500),
    book_id int,
    foreign key (book_id) references books(id)    
)engine=InnoDB auto_increment=1;

Alter table books add column course_id int;
Alter table books add foreign key (course_id) references course(id);