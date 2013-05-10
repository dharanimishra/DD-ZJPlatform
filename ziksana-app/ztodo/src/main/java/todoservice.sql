 and
		n.ForMemberRoleId=#{userMemberRoleId}

CREATE TABLE `memmember` (                              
`ID` int(11) NOT NULL,                                
`MemberType` int(11) DEFAULT NULL,                    
`Relationship Status` int(11) DEFAULT NULL,           
`JoinedDate` datetime DEFAULT '0000-00-00 00:00:00',  
`FirstName` varchar(45) DEFAULT NULL,                 
`LastName` varchar(45) DEFAULT NULL,                  
`MiddleName` varchar(45) DEFAULT NULL,                
`NickName` varchar(45) DEFAULT NULL,                  
`Salutation` int(11) DEFAULT NULL,                    
`DateofBirth` date DEFAULT '0000-00-00',              
`SunSign` int(11) DEFAULT NULL,                       
`MoonSign` int(11) DEFAULT NULL,                      
`Active` tinyint(1) DEFAULT NULL,                     
`DoNotDistrubIndicator` tinyint(1) DEFAULT NULL,      
`Gender` int(11) DEFAULT NULL,                        
`PicturePath` varchar(45) DEFAULT NULL,               
PRIMARY KEY (`ID`)                                    
) ENGINE=InnoDB DEFAULT CHARSET=latin1                  


CREATE TABLE `memMemberRole` (                                                                                    
`ID` int(11) NOT NULL,                                                                                          
`RoleType` int(11) DEFAULT NULL,                                                                                
`RoleStartDate` datetime DEFAULT '0000-00-00 00:00:00',                                                         
`RoleEndDate` datetime DEFAULT '0000-00-00 00:00:00',                                                           
`Active` tinyint(1) DEFAULT NULL,                                                                               
`DoNotMarketIndicator` tinyint(1) DEFAULT NULL,                                                                 
`ThumbnailPicturePath` varchar(72) DEFAULT NULL,                                                                
PRIMARY KEY (`ID`),                                                                                             
KEY `MemberID` (`ID`),                                                                                          
CONSTRAINT `MemberID` FOREIGN KEY (`ID`) REFERENCES `memmember` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION  
) ENGINE=InnoDB DEFAULT CHARSET=latin1   



CREATE TABLE `memMemberToDo` (
`ID` INT(10) NOT NULL AUTO_INCREMENT,
`category` VARCHAR(45) NOT NULL,
`description` VARCHAR(240) NOT NULL,
`complete` BOOL NOT NULL,
`memberRoleId` INT(11) NOT NULL,
`createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`ID`),
INDEX `FK_todo_memMemberRole` (`memberRoleId`),
CONSTRAINT `FK_todo_memmemberrole` FOREIGN KEY (`memberRoleId`) REFERENCES `memMemberRole` (`ID`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;


CREATE  TABLE `memMemberNotification` (
`ID` INT NOT NULL ,
`Creation Date` DATETIME NULL ,
`Notification Type` INT NULL ,
`Category` VARCHAR(45) NULL ,
`Notification Content` VARCHAR(240) NULL ,
`Priority` INT NULL ,
`Status` INT NULL ,
`Complete By` DATETIME NULL ,
`Creator Type` INT NULL ,
`ActivationDate` DATETIME NULL ,
PRIMARY KEY (`ID`) ,
INDEX `CreatingMemberRoleID` (`ID` ASC) ,
CONSTRAINT `ForMemberRoleID` FOREIGN KEY (`ID`) REFERENCES `memMemberRole` (`ID` ) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `CreatingMemberRoleID` FOREIGN KEY (`ID` ) REFERENCES `memMemberRole` (`ID` ) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE = InnoDB;
