-- MySQL dump 10.16  Distrib 10.1.8-MariaDB, for osx10.6 (i386)
--
-- Host: localhost    Database: lib_reborn
-- ------------------------------------------------------
-- Server version	10.1.8-MariaDB

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
-- Table structure for table `book_catalogue`
--

DROP TABLE IF EXISTS `book_catalogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_catalogue` (
  `Book_Id` varchar(20) NOT NULL,
  `Book_Name` varchar(300) DEFAULT NULL,
  `Author` varchar(100) DEFAULT NULL,
  `Genre` varchar(50) DEFAULT NULL,
  `Date_Added` varchar(30) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Book_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_catalogue`
--

LOCK TABLES `book_catalogue` WRITE;
/*!40000 ALTER TABLE `book_catalogue` DISABLE KEYS */;
INSERT INTO `book_catalogue` VALUES ('1503','TFIOS','dummu','Fiction','2015-12-13 23:31:40','AVAILABLE'),('1504','Whatev','dumy','Fiction','2015-12-13 23:31:52','AVAILABLE'),('1505','Test Book','Nick','Fiction','2015-12-13 23:32:34','AVAILABLE');
/*!40000 ALTER TABLE `book_catalogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_transaction_log`
--

DROP TABLE IF EXISTS `book_transaction_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_transaction_log` (
  `Mem_Id` int(10) DEFAULT NULL,
  `Mem_Name` varchar(200) DEFAULT NULL,
  `Book_Id` varchar(30) DEFAULT NULL,
  `Book_Name` varchar(400) DEFAULT NULL,
  `Date_Issued` varchar(30) DEFAULT NULL,
  `Date_Deposit` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_transaction_log`
--

LOCK TABLES `book_transaction_log` WRITE;
/*!40000 ALTER TABLE `book_transaction_log` DISABLE KEYS */;
INSERT INTO `book_transaction_log` VALUES (2974,'Niraj','1503','TFIOS','2015-12-13 23:35:08','2015-12-13 23:58:04'),(2974,'Niraj','1504','Whatev','2015-12-13 23:36:00','2015-12-13 23:58:22'),(2974,'Niraj','1505','Test Book','2015-12-13 23:36:21','2015-12-13 23:57:30');
/*!40000 ALTER TABLE `book_transaction_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_transactions`
--

DROP TABLE IF EXISTS `book_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_transactions` (
  `Mem_Id` int(10) NOT NULL,
  `Mem_Name` varchar(200) DEFAULT NULL,
  `Book_Id` varchar(30) NOT NULL,
  `Book_Name` varchar(400) DEFAULT NULL,
  `Date_Issued` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Book_Id`),
  UNIQUE KEY `Book_Id` (`Book_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_transactions`
--

LOCK TABLES `book_transactions` WRITE;
/*!40000 ALTER TABLE `book_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `library_users`
--

DROP TABLE IF EXISTS `library_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library_users` (
  `Uid` int(10) NOT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Doj` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library_users`
--

LOCK TABLES `library_users` WRITE;
/*!40000 ALTER TABLE `library_users` DISABLE KEYS */;
INSERT INTO `library_users` VALUES (2974,'Niraj','8302716971','nickk.2974@gmail.com','2015-12-13 23:33:58'),(2975,'Pulkit','8456123410','dummy@hackintosh.net','2015-12-13 23:34:49');
/*!40000 ALTER TABLE `library_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logon`
--

DROP TABLE IF EXISTS `logon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logon` (
  `alpha` varchar(50) DEFAULT NULL,
  `bravo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logon`
--

LOCK TABLES `logon` WRITE;
/*!40000 ALTER TABLE `logon` DISABLE KEYS */;
INSERT INTO `logon` VALUES ('niraj','e555f863fb09593119fe2f3459e9783a');
/*!40000 ALTER TABLE `logon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_stat`
--

DROP TABLE IF EXISTS `pro_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pro_stat` (
  `CStat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_stat`
--

LOCK TABLES `pro_stat` WRITE;
/*!40000 ALTER TABLE `pro_stat` DISABLE KEYS */;
INSERT INTO `pro_stat` VALUES (403);
/*!40000 ALTER TABLE `pro_stat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-13 23:59:44
