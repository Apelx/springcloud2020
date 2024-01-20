CREATE TABLE `payment`(

                          `pay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',

                          `pay_serial_number` varchar(200) DEFAULT '',

                          PRIMARY KEY(`pay_id`)

)  ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;