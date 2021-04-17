DROP SCHEMA IF EXISTS courses;
CREATE SCHEMA IF NOT EXISTS courses;
USE courses;

CREATE TABLE student (
    id INTEGER NOT NULL,
    first_name VARCHAR(99) NOT NULL,
	last_name VARCHAR(99) NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE course (
	id INTEGER NOT NULL,
    cap INTEGER NOT NULL,
    name VARCHAR(99) NOT NULL,
    
    PRIMARY KEY (id)
    );
    
CREATE TABLE student_course (
	student_id INT NULL DEFAULT NULL,
	course_id INT NULL DEFAULT NULL,
    
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
    );
    
CREATE TABLE waitlist(
	student_id INT NULL DEFAULT NULL,
	course_id INT NULL DEFAULT NULL,
    
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
)
    
/* INSERT INTO student VALUES(123, 'Quinn', 'Melssen'); */
/* DELETE FROM student WHERE id = '123'; */
