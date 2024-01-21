drop table contacts if exists;
create table contacts (
                         id INT NOT NULL AUTO_INCREMENT,
                         contactid VARCHAR(255) NOT NULL UNIQUE,
                         firstname VARCHAR(255) NOT NULL,
                         lastname VARCHAR(255) NOT NULL,
                         phonenumber INT NOT NULL,
                         address VARCHAR(255),
                         PRIMARY KEY (id)
);