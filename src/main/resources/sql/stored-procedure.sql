DELIMITER //

CREATE PROCEDURE InsertUser(IN name VARCHAR(50), IN last_name VARCHAR(50), IN email VARCHAR(255), IN phone_number VARCHAR(20))
BEGIN
INSERT INTO users (name, last_name, email, phone_number) VALUES (name, last_name, email, phone_number);
END //

DELIMITER ;