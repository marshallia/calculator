Drop table if exists Book;

CREATE TABLE Book (
    ID INT AUTO_INCREMENT PRIMARY KEY ,
    TITLE VARCHAR(255) NOT NULL,
    AUTHOR VARCHAR(255) NOT NULL
);
insert into Book values(1, 'Hamlet','William Shakespeare');
insert into Book values(2, 'Romeo and Juliet','William Shakespeare');
insert into Book values(3, 'Wuthering Heights','Emily Brontë');