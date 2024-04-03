-- Drop customer first if they exist
DROP USER if exists 'customer'@'%' ;

-- Now create user with prop privileges
CREATE USER 'customer'@'%' IDENTIFIED BY 'customer123';

GRANT ALL PRIVILEGES ON * . * TO 'customer'@'%';