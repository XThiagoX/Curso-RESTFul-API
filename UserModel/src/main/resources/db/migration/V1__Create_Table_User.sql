DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
   id           BIGINT       NOT NULL AUTO_INCREMENT,
   first_name   VARCHAR(80)  NOT NULL,
   last_name    VARCHAR(80)  NOT NULL,
   address      VARCHAR(100),
   gender       VARCHAR(10),
   PRIMARY KEY (id)
);
