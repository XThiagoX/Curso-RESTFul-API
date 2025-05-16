DROP TABLE IF EXISTS `users`;
CREATE TABLE user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  address VARCHAR(255),
  gender VARCHAR(10)
);

