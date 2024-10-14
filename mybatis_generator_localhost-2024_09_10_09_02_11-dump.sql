-- MySQL dump 10.13  Distrib 5.7.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mybatis_generator
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `mybatis_user`
--


# 切换到指定数据库
USE MYBATIS_PAGINATION;

DROP TABLE IF EXISTS `mybatis_user`;
/*!40101 SET @SAVED_CS_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET character_set_client = UTF8 */;
CREATE TABLE `mybatis_user`
(
    `USER_ID`       int(4)                                  NOT NULL AUTO_INCREMENT,
    `USER_NAME`     varchar(20) COLLATE UTF8MB4_CROATIAN_CI NOT NULL,
    `USER_PASSWORD` varchar(20) COLLATE UTF8MB4_CROATIAN_CI NOT NULL,
    `USER_SALARY`   float(6, 2)                             NOT NULL,
    `USER_BIRTHDAY` date                                    NOT NULL,
    PRIMARY KEY (`USER_ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = UTF8MB4
  COLLATE = UTF8MB4_CROATIAN_CI;
/*!40101 SET character_set_client = @SAVED_CS_CLIENT */;

--
-- Dumping data for table `mybatis_user`
--

LOCK TABLES `mybatis_user` WRITE;
/*!40000 ALTER TABLE `mybatis_user`
    DISABLE KEYS */;
INSERT INTO `mybatis_user`
VALUES (1, 'C罗', 'admin', 88.34, '2024-08-29'),
       (2, 'zhangsan', 'admin', 12.34, '2024-08-29'),
       (4, 'lisi', '123', 100.00, '2024-09-09'),
       (5, 'abc', 'abc', 200.00, '2024-09-09');
/*!40000 ALTER TABLE `mybatis_user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-09-10  9:02:11
