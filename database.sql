#创建临时用户表
CREATE TABLE IF NOT EXISTS user(
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB;