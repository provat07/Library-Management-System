-- Create database
CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    isAvailable BOOLEAN DEFAULT TRUE
);

INSERT INTO books (id, title, author) VALUES
(1, 'Java Basics', 'Author A'),
(2, 'Python for Beginners', 'Author B'),
(3, 'Data Structures', 'Author C');
