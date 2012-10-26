
CREATE TABLE `memmemberziksanarecommendation` (
	`MemziksanaRecommendationId` INT(11) NOT NULL,
	`RecommendationCategory` INT(11) NULL DEFAULT NULL,
	`CurrentState` VARCHAR(45) NULL DEFAULT NULL,
	`TargetState` VARCHAR(45) NULL DEFAULT NULL,
	`DurationtoBump` INT(11) NULL DEFAULT NULL,
	`Active` TINYINT(1) NULL DEFAULT NULL,
	`CreationDate` DATETIME NULL DEFAULT NULL,
	`MemberRoleId` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`MemziksanaRecommendationId`),
	INDEX `MZRMemberRoleID` (`MemberRoleId`),
	CONSTRAINT `FK_MZRMemberRoleID` FOREIGN KEY (`MemberRoleId`) REFERENCES `memmemberrole` (`MemberRoleId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
