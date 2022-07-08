 DROP TABLE IF EXISTS userLogin; 

/*==============================================================*/
/* Table: userLogin                                             */
/*==============================================================*/
CREATE TABLE userLogin
(
   id                   BIGINT AUTO_INCREMENT ,
   userName             VARCHAR(255),
   userPwd              VARCHAR(255),
   realName             VARCHAR(255),
   PRIMARY KEY (id)
);
 
INSERT INTO userLogin(userName,userPwd,realName) VALUES ("zhangsan","123","张三") ;

INSERT INTO userLogin(userName,userPwd,realName) VALUES ("jack","123","杰克") ;

COMMIT;
SELECT * FROM userLogin;