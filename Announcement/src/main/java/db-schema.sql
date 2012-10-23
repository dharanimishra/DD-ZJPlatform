Table Name


CREATE TABLE `corannouncement` (
`AnouncementId` INT(11) NOT NULL,
`AnnouncementDate` DATETIME NULL DEFAULT NULL,
`Message` VARCHAR(2400) NULL DEFAULT NULL,
`MessageVisibility` INT(11) NULL DEFAULT NULL,
`ValidUntil` DATETIME NULL DEFAULT NULL,
`MemberRoleId` INT(11) NULL DEFAULT NULL,
`InstitutionId` INT(11) NULL DEFAULT NULL,
`InstitutionUnitId` INT(11) NULL DEFAULT NULL,
`CurriculumCourseId` INT(11) NULL DEFAULT NULL,
`LearningProgramId` INT(11) NULL DEFAULT NULL,
`CourseId` INT(11) NULL DEFAULT NULL,
`CourseLearningComponentId` INT(11) NULL DEFAULT NULL,
PRIMARY KEY (`AnouncementId`),
INDEX `PostingMemberRoleID` (`MemberRoleId`),
INDEX `AnnInstitutionID` (`InstitutionId`),
INDEX `AnnInstitutionUnitID` (`InstitutionUnitId`),
INDEX `CurriculumCourse` (`CurriculumCourseId`),
INDEX `LearningProgramID` (`LearningProgramId`),
INDEX `CourseID` (`CourseId`),
INDEX `CourseLearningComponentID` (`CourseLearningComponentId`),
CONSTRAINT `AnnCourseID` FOREIGN KEY (`CourseId`) REFERENCES `corcourse` (`CourseId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `AnnCurriculumCourse` FOREIGN KEY (`CurriculumCourseId`) REFERENCES `corcurriculumcourse` (`CurriculumCourseId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `AnnPostingMemberRoleID` FOREIGN KEY (`MemberRoleId`) REFERENCES `memmemberrole` (`MemberRoleId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `CorCourseLearningComponentID` FOREIGN KEY (`CourseLearningComponentId`) REFERENCES `corcourselearningcomponent` (`CourseLearningComponentId`) ON UP
DATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `CorInstitutionID` FOREIGN KEY (`InstitutionId`) REFERENCES `corinstitution` (`InstitutionId`) ON UPDATE an>NO ACTION ON DELETE NO ACTION,
CONSTRAINT `CorLearningProgramID` FOREIGN KEY (`LearningProgramId`) REFERENCES `corlearningprogram` (`LearningProgramId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `CourseInstitutionUnitID` FOREIGN KEY (`InstitutionUnitId`) REFERENCES `corinstitutionunit` (`InstitutionUnitId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;	