CREATE TABLE `CHIT_EmployeeAttendanceDB`.`AttendanceLog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `empid` INT NOT NULL,
  `daydate` DATE NOT NULL,
  `logtimein` DATETIME NOT NULL,
  `logtimeout` DATETIME NOT NULL,
  PRIMARY KEY (`id`));


ALTER TABLE `CHIT_EmployeeAttendanceDB`.`AttendanceLog` 
ADD INDEX `fk_AttendanceLog_1_idx` (`empid` ASC);
ALTER TABLE `CHIT_EmployeeAttendanceDB`.`AttendanceLog` 
ADD CONSTRAINT `fk_AttendanceLog_1`
  FOREIGN KEY (`empid`)
  REFERENCES `CHIT_EmployeeAttendanceDB`.`Employee` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
