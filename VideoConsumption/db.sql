# --------------------------------------------------------
# Host:                         localhost
# Server version:               5.5.25
# Server OS:                    Win64
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2012-08-19 22:00:36
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


# Dumping structure for table test.bookmark
DROP TABLE IF EXISTS `bookmark`;
CREATE TABLE IF NOT EXISTS `bookmark` (
  `videoId` int(10) NOT NULL AUTO_INCREMENT,
  `time` time DEFAULT NULL,
  `videoName` varchar(100) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  KEY `FK_bookmark_fileinfo` (`videoId`,`videoName`),
  CONSTRAINT `FK_bookmark_fileinfo` FOREIGN KEY (`videoId`, `videoName`) REFERENCES `fileinfo` (`fileId`, `fileName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

# Dumping data for table test.bookmark: ~1 rows (approximately)
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;
INSERT INTO `bookmark` (`videoId`, `time`, `videoName`, `title`) VALUES
	(8, '00:00:12', 'Intro_Decision_Making.mp4', 'hhhhh');
/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;


# Dumping structure for table test.componentnest
DROP TABLE IF EXISTS `componentnest`;
CREATE TABLE IF NOT EXISTS `componentnest` (
  `nestid` int(10) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nestid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table test.componentnest: ~20 rows (approximately)
/*!40000 ALTER TABLE `componentnest` DISABLE KEYS */;
INSERT INTO `componentnest` (`nestid`, `description`) VALUES
	(1, 'Topic 1'),
	(2, 'Topic 2'),
	(3, 'Topic 3'),
	(4, 'Topic 4'),
	(5, 'Topic 5'),
	(6, 'Topic 6'),
	(7, 'Topic 7'),
	(8, 'Topic 8'),
	(9, 'Topic 9'),
	(10, 'Topic 10'),
	(11, 'Topic 11'),
	(12, 'Topic 12'),
	(13, 'Topic 13'),
	(14, 'Topic  14'),
	(15, 'Topic  15'),
	(16, 'Topic  16'),
	(17, 'Topic  17'),
	(18, 'Topic  18'),
	(19, 'Topic  19'),
	(20, 'Topic  20');
/*!40000 ALTER TABLE `componentnest` ENABLE KEYS */;


# Dumping structure for table test.componenttype
DROP TABLE IF EXISTS `componenttype`;
CREATE TABLE IF NOT EXISTS `componenttype` (
  `componenttypeid` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(144) DEFAULT NULL,
  PRIMARY KEY (`componenttypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table test.componenttype: ~3 rows (approximately)
/*!40000 ALTER TABLE `componenttype` DISABLE KEYS */;
INSERT INTO `componenttype` (`componenttypeid`, `name`, `description`) VALUES
	(1, 'Notes', 'Component Enrichment Notes'),
	(2, 'Reference Material', 'Component Enrchment Reference Material'),
	(3, 'Topic', 'Component Enrichment Topic Item');
/*!40000 ALTER TABLE `componenttype` ENABLE KEYS */;


# Dumping structure for table test.enrichment
DROP TABLE IF EXISTS `enrichment`;
CREATE TABLE IF NOT EXISTS `enrichment` (
  `enrichmentid` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(144) DEFAULT NULL,
  `description` varchar(144) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `videoid` int(10) DEFAULT NULL,
  `videoname` varchar(100) DEFAULT NULL,
  `componenttypeid` int(10) DEFAULT NULL,
  `nestparentid` int(10) DEFAULT NULL,
  `componentnestid` int(10) DEFAULT NULL,
  PRIMARY KEY (`enrichmentid`),
  KEY `fk_videoid` (`videoid`),
  KEY `fk_comptypeid` (`componenttypeid`),
  KEY `fk_compnestid` (`componentnestid`),
  CONSTRAINT `fk_compnestid` FOREIGN KEY (`componentnestid`) REFERENCES `componentnest` (`nestid`),
  CONSTRAINT `fk_comptypeid` FOREIGN KEY (`componenttypeid`) REFERENCES `componenttype` (`componenttypeid`),
  CONSTRAINT `fk_videoid` FOREIGN KEY (`videoid`) REFERENCES `fileinfo` (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

# Dumping data for table test.enrichment: ~5 rows (approximately)
/*!40000 ALTER TABLE `enrichment` DISABLE KEYS */;
INSERT INTO `enrichment` (`enrichmentid`, `title`, `description`, `starttime`, `endtime`, `videoid`, `videoname`, `componenttypeid`, `nestparentid`, `componentnestid`) VALUES
	(2, 'Topic1', 'desc', '00:00:02', '00:00:32', 5, 'Aggregation.mp4', 3, 0, 1),
	(4, 'Ref Material', 'RF', '00:00:40', '00:04:20', 5, 'Aggregation.mp4', 2, NULL, NULL),
	(5, 'Topic2', 'child for topic 1', NULL, NULL, 5, 'Aggregation.mp4', 3, 1, 2),
	(7, 'Topic3', 'child for topic1', NULL, NULL, 5, 'Aggregation.mp4', 3, 1, 3),
	(8, 'Topic4', 'child for Topic2', NULL, NULL, 5, 'Aggregation.mp4', 3, 2, 4),
	(9, 'Note at 0.20 Mins', 'This is the note description', '00:00:20', '00:00:30', 5, 'Aggregation.mp4', 1, NULL, NULL),
	(10, 'Ref Materal at 0.55', 'Reference material that displays at 1.55mins', '00:00:55', '00:01:05', 5, 'Aggregation.mp4', 2, NULL, NULL),
	(11, 'Ref Material at 1.55', 'Reference material that displays at 0.50sec', '00:01:55', '00:02:55', 5, 'Aggregation.mp4', 2, NULL, NULL),
	(12, 'Ref Material at 2.55', 'Ref Material at 2.55', '00:02:55', '00:02:58', 5, 'Aggregation.mp4', 2, NULL, NULL);
/*!40000 ALTER TABLE `enrichment` ENABLE KEYS */;


# Dumping structure for table test.file
DROP TABLE IF EXISTS `file`;
CREATE TABLE IF NOT EXISTS `file` (
  `videoId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `bookmarkTitle` text,
  KEY `FK_file_fileinfo` (`videoId`,`name`),
  CONSTRAINT `FK_file_fileinfo` FOREIGN KEY (`videoId`, `name`) REFERENCES `fileinfo` (`fileId`, `fileName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='file';

# Dumping data for table test.file: ~4 rows (approximately)
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` (`videoId`, `name`, `description`, `time`, `bookmarkTitle`) VALUES
	(5, 'Aggregation.mp4', 'hello world', '00:00:29', 'Note at 0.29 Mins');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;


# Dumping structure for table test.fileinfo
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE IF NOT EXISTS `fileinfo` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileId`,`fileName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

# Dumping data for table test.fileinfo: ~11 rows (approximately)
/*!40000 ALTER TABLE `fileinfo` DISABLE KEYS */;
INSERT INTO `fileinfo` (`fileId`, `fileName`, `filePath`, `title`) VALUES
	(1, 'video2.mp4', 'videos/', 'Video2 Titl1'),
	(2, 'video.mp4', 'videos/', 'Video Title'),
	(3, 'video3.mp4', 'videos/', 'Video3 Title'),
	(4, 'video1.mp4', 'videos/', 'Video1 Title'),
	(5, 'Aggregation.mp4', 'videos/', 'Aggregation Video Title'),
	(6, 'Game_of_Life.mp4', 'videos/', 'Game of Life Video Title'),
	(7, 'Intelligent_Citizens.mp4', 'videos/', 'Intelligent Citizens Video Title'),
	(8, 'Intro_Decision_Making.mp4', 'videos/', 'Intro Decision Making Video Title'),
	(9, 'Probability.mp4', 'videos/', 'Probability Video Title'),
	(10, 'Six_Sigma.mp4', 'videos/', 'Six Sigma video title'),
	(11, 'Why_Model.mp4', 'videos/', 'Why Model Video Title');
/*!40000 ALTER TABLE `fileinfo` ENABLE KEYS */;


# Dumping structure for table test.playlist
DROP TABLE IF EXISTS `playlist`;
CREATE TABLE IF NOT EXISTS `playlist` (
  `fileId` int(10) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(250) DEFAULT NULL,
  `filePath` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1 COMMENT='PlayList information';

# Dumping data for table test.playlist: ~5 rows (approximately)
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` (`fileId`, `fileName`, `filePath`) VALUES
	(57, 'Aggregation.mp4', 'videos/'),
	(58, 'Six_Sigma.mp4', 'videos/'),
	(59, 'Probability.mp4', 'videos/'),
	(60, 'Why_Model.mp4', 'videos/'),
	(61, 'Intro_Decision_Making.mp4', 'videos/');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
