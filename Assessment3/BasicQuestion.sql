CREATE DATABASE IF NOT EXISTS west2;
USE west2;

CREATE TABLE IF NOT EXISTS students(
studentId INT PRIMARY KEY,
`name` VARCHAR(20) NOT NULL,
gender VARCHAR CHECK(gender IN ('F','M'))
);

CREATE TABLE IF NOT EXISTS classes(
classId INT NOT NULL,
studentId INT,
arrivalTime TIMESTAMP,
FOREIGN KEY (studentId) REFERENCES students(studentId) ON UPDATE CASCADE ON DELETE CASCADE
);

