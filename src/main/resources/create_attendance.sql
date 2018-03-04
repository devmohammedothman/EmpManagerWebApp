CREATE TABLE `CHIT_EmployeeAttendanceDB`.`AttendanceLog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `empid` INT NOT NULL ,
  `daydate` DATE NOT NULL,
  `logtimein` DATETIME NOT NULL,
  `logtimeout` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_AttendanceLog_1`
    FOREIGN KEY (`empid`)
    REFERENCES `CHIT_EmployeeAttendanceDB`.`Employee` (`empid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



insert into CHIT_EmployeeAttendanceDB.AttendanceLog (id,empid,daydate,logtimein,logtimeout)
values (1,3,'2017-02-01','2017-02-01 08:10:12','2017-02-01 17:20:01');

insert into CHIT_EmployeeAttendanceDB.AttendanceLog (id,empid,daydate,logtimein,logtimeout)
values (2,3,'2017-02-02','2017-02-02 10:02:12','2017-02-02 17:20:01');

insert into CHIT_EmployeeAttendanceDB.AttendanceLog (id,empid,daydate,logtimein,logtimeout)
values (3,3,'2017-02-03','2017-02-03 09:10:12','2017-02-03 17:20:01');

insert into CHIT_EmployeeAttendanceDB.AttendanceLog (id,empid,daydate,logtimein,logtimeout)
values (4,3,'2017-02-04','2017-02-04 09:10:12','2017-02-04 19:30:22');
