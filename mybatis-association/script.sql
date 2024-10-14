-- MySQL dump 10.13  Distrib 5.7.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mybatis_association
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mybatis_category`
--

DROP TABLE IF EXISTS `mybatis_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_category` (
                                    `CATEGORY_ID` int(4) NOT NULL AUTO_INCREMENT,
                                    `CATEGORY_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                    `PARENT_ID` int(4) DEFAULT NULL,
                                    PRIMARY KEY (`CATEGORY_ID`),
                                    KEY `FK_PARENT_ID` (`PARENT_ID`),
                                    CONSTRAINT `FK_PARENT_ID` FOREIGN KEY (`PARENT_ID`) REFERENCES `mybatis_category` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_category`
--

LOCK TABLES `mybatis_category` WRITE;
/*!40000 ALTER TABLE `mybatis_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `mybatis_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_department`
--

DROP TABLE IF EXISTS `mybatis_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_department` (
                                      `DEPARTMENT_ID` int(4) NOT NULL AUTO_INCREMENT,
                                      `DEPARTMENT_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                      `DEPARTMENT_LOCATION` varchar(100) COLLATE utf8mb4_croatian_ci NOT NULL,
                                      PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_department`
--

LOCK TABLES `mybatis_department` WRITE;
/*!40000 ALTER TABLE `mybatis_department` DISABLE KEYS */;
INSERT INTO `mybatis_department` VALUES (1,'IBM','BOSTON'),(2,'SUN','LOS');
/*!40000 ALTER TABLE `mybatis_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_employee`
--

DROP TABLE IF EXISTS `mybatis_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_employee` (
                                    `EMPLOYEE_ID` int(4) NOT NULL AUTO_INCREMENT,
                                    `EMPLOYEE_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                    PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_employee`
--

LOCK TABLES `mybatis_employee` WRITE;
/*!40000 ALTER TABLE `mybatis_employee` DISABLE KEYS */;
INSERT INTO `mybatis_employee` VALUES (1,'zhangsan'),(2,'lisi');
/*!40000 ALTER TABLE `mybatis_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_employee_role`
--

DROP TABLE IF EXISTS `mybatis_employee_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_employee_role` (
                                         `EMPLOYEE_ROLE_ID` int(4) NOT NULL AUTO_INCREMENT,
                                         `EMPLOYEE_ID` int(4) DEFAULT NULL,
                                         `ROLE_ID` int(4) DEFAULT NULL,
                                         PRIMARY KEY (`EMPLOYEE_ROLE_ID`),
                                         KEY `FK_EMPLOYEE_ID` (`EMPLOYEE_ID`),
                                         KEY `FK_ROLE_ID` (`ROLE_ID`),
                                         CONSTRAINT `FK_EMPLOYEE_ID` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `mybatis_employee` (`EMPLOYEE_ID`),
                                         CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `mybatis_role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_employee_role`
--

LOCK TABLES `mybatis_employee_role` WRITE;
/*!40000 ALTER TABLE `mybatis_employee_role` DISABLE KEYS */;
INSERT INTO `mybatis_employee_role` VALUES (1,1,1),(2,1,3),(3,2,2),(4,2,3);
/*!40000 ALTER TABLE `mybatis_employee_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_id_card`
--

DROP TABLE IF EXISTS `mybatis_id_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_id_card` (
                                   `ID_CARD_ID` int(4) NOT NULL AUTO_INCREMENT,
                                   `ID_CARD_NUMBER` varchar(50) COLLATE utf8mb4_croatian_ci NOT NULL,
                                   PRIMARY KEY (`ID_CARD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_id_card`
--

LOCK TABLES `mybatis_id_card` WRITE;
/*!40000 ALTER TABLE `mybatis_id_card` DISABLE KEYS */;
INSERT INTO `mybatis_id_card` VALUES (1,'88888888'),(2,'55555555');
/*!40000 ALTER TABLE `mybatis_id_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_person`
--

DROP TABLE IF EXISTS `mybatis_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_person` (
                                  `PERSON_ID` int(4) NOT NULL AUTO_INCREMENT,
                                  `PERSON_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                  `ID_CARD_ID` int(4) DEFAULT NULL,
                                  PRIMARY KEY (`PERSON_ID`),
                                  UNIQUE KEY `UK_ID_CARD_ID` (`ID_CARD_ID`),
                                  CONSTRAINT `FK_ID_CARD_ID` FOREIGN KEY (`ID_CARD_ID`) REFERENCES `mybatis_id_card` (`ID_CARD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_person`
--

LOCK TABLES `mybatis_person` WRITE;
/*!40000 ALTER TABLE `mybatis_person` DISABLE KEYS */;
INSERT INTO `mybatis_person` VALUES (1,'zhangsan',1),(2,'lisi',2);
/*!40000 ALTER TABLE `mybatis_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_role`
--

DROP TABLE IF EXISTS `mybatis_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_role` (
                                `ROLE_ID` int(4) NOT NULL AUTO_INCREMENT,
                                `ROLE_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_role`
--

LOCK TABLES `mybatis_role` WRITE;
/*!40000 ALTER TABLE `mybatis_role` DISABLE KEYS */;
INSERT INTO `mybatis_role` VALUES (1,'系统管理员'),(2,'部门经理'),(3,'市场经理');
/*!40000 ALTER TABLE `mybatis_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_user`
--

DROP TABLE IF EXISTS `mybatis_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_user` (
                                `USER_ID` int(4) NOT NULL AUTO_INCREMENT,
                                `USER_NAME` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                `USER_PASSWORD` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
                                `USER_SALARY` float(6,2) NOT NULL,
                                `USER_BIRTHDAY` date NOT NULL,
                                `DEPARTMENT_ID` int(4) DEFAULT NULL,
                                PRIMARY KEY (`USER_ID`),
                                UNIQUE KEY `UK_USER_NAME` (`USER_NAME`),
                                KEY `FK_DEPARTMENT_ID` (`DEPARTMENT_ID`),
                                CONSTRAINT `FK_DEPARTMENT_ID` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `mybatis_department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_user`
--

LOCK TABLES `mybatis_user` WRITE;
/*!40000 ALTER TABLE `mybatis_user` DISABLE KEYS */;
INSERT INTO `mybatis_user` VALUES (1,'zhangsan','admin',12.34,'2024-08-30',1),(2,'lisi','123456',12.34,'2024-08-30',2),(3,'wangwu','test',55.34,'2024-08-30',1);
/*!40000 ALTER TABLE `mybatis_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-03  8:59:35
