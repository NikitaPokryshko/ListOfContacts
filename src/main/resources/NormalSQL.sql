CREATE TABLE Photo
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    photo_reference VARCHAR(100) NULL
) ENGINE = INNODB;


CREATE TABLE Addresses
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    country VARCHAR(30) NULL,
    city VARCHAR(30) NULL,
    street VARCHAR(45) NULL,
    house INT(11) NULL,
    flat INT(11) NULL,
    zipcode INT(11) NULL
) ENGINE = INNODB;

CREATE TABLE Contacts
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    patronymic VARCHAR(45) NULL,
    date_of_birth DATETIME NULL,
    gender VARCHAR(12) NULL,
    nationality VARCHAR(20) NULL,
    marital_status VARCHAR(15) NULL,
    web_site VARCHAR(45) NULL,
    email VARCHAR(30) NULL,
    current_job VARCHAR(30) NULL,
    photo_id INT(11) NULL,
    address_id INT(11) NULL,
    CONSTRAINT contacts_ibfk_1 FOREIGN KEY (photo_id) REFERENCES Photo (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT contacts_ibfk_2 FOREIGN KEY (address_id) REFERENCES Addresses (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = INNODB;


CREATE TABLE Attachments
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    attachment_file_name VARCHAR(100) NULL,
    attach_path VARCHAR(60) NULL,
    date_of_download DATETIME NULL,
    comment VARCHAR(50) NULL,
    contact_id INT(11) NULL,
    CONSTRAINT attachments_ibfk_1 FOREIGN KEY (contact_id) REFERENCES Contacts (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = INNODB;

CREATE TABLE Phone
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    country_code INT(11) NULL,
    operators_code VARCHAR(15) NULL,
    phone_number INT(11) NULL,
    phone_type VARCHAR(15) NULL,
    comment VARCHAR(50) NULL,
    contact_id INT(11) NULL,
    CONSTRAINT phone_ibfk_1 FOREIGN KEY (contact_id) REFERENCES Contacts (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = INNODB;








