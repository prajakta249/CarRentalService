-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: trail3
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_credentials`
--

DROP TABLE IF EXISTS `admin_credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_credentials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_credentials`
--

LOCK TABLES `admin_credentials` WRITE;
/*!40000 ALTER TABLE `admin_credentials` DISABLE KEYS */;
INSERT INTO `admin_credentials` VALUES (1,'Kalpit','Vyas','7972381305','kalpit','kalpit@123'),(2,'Pranav','Wagh','8552968489','pranav','pranav@123'),(3,'Rahul','Baghel','7389733980','rahul','rahul@123');
/*!40000 ALTER TABLE `admin_credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `ongoing_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `driver_id` int DEFAULT NULL,
  `booking_time` varchar(50) DEFAULT (curtime()),
  `booking_date` varchar(50) DEFAULT (curdate()),
  `journey_time` varchar(50) DEFAULT (curtime()),
  `journey_date` varchar(50) DEFAULT (curdate()),
  `Total_ride_price` int DEFAULT NULL,
  `source` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `ride_status` int DEFAULT '0',
  PRIMARY KEY (`ongoing_id`),
  KEY `fk_userid` (`customer_id`),
  KEY `fk_carreg` (`vehicle_id`),
  KEY `fk_ond` (`driver_id`),
  CONSTRAINT `fk_carreg` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`),
  CONSTRAINT `fk_ond` FOREIGN KEY (`driver_id`) REFERENCES `driver_details` (`driver_id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (5,5,4,2,'11:34:06','2022-02-25','11:34:06','2022-02-25',500,'Pune','Mumbai',1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_details` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `phone_no` varchar(10) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Pincode` int DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_no` (`phone_no`),
  UNIQUE KEY `phone_no_2` (`phone_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_details`
--

LOCK TABLES `customer_details` WRITE;
/*!40000 ALTER TABLE `customer_details` DISABLE KEYS */;
INSERT INTO `customer_details` VALUES (4,'Pranav','Wagh','8552968489','pranav','pranav@123','waghpranav222@gmail.com','Auranagabad',431139,'Maharashtra'),(5,'Kalpit','Vyas','7972381305','kalpit','kalpit@123','kalpitvyas0716@gmail.com','Pune',431136,'Maharashtra'),(6,'Dhiraj','Chaudhari','7856953856','dhiraj','dhiraj@123','dhiraj@gmail.com','Pune',411041,'Maharashtra'),(7,'Ashwini','Aghav','8566953856','ashwini','ashwini@123','ashwini@gmail.com','Nashik',402341,'Maharashtra');
/*!40000 ALTER TABLE `customer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_details`
--

DROP TABLE IF EXISTS `driver_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_details` (
  `driver_id` int NOT NULL AUTO_INCREMENT,
  `driver_firstname` varchar(30) DEFAULT NULL,
  `driver_lastname` varchar(50) DEFAULT NULL,
  `driver_phone_no` varchar(10) DEFAULT NULL,
  `driver_license` varchar(50) DEFAULT NULL,
  `driver_status` tinyint(1) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `pincode` int DEFAULT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_details`
--

LOCK TABLES `driver_details` WRITE;
/*!40000 ALTER TABLE `driver_details` DISABLE KEYS */;
INSERT INTO `driver_details` VALUES (1,'manoj','dupargude','9876543210','XX1001XXX',1,'Pune',431136),(2,'Ramesh','sonule','9789654123','XX1002XXX',1,'Aurangabad ',431109),(3,'Suresh','Sharma','9658496124','XX11021XX',1,'Nagpur',410215),(4,'Kishor','Verma','9856986112','XX11021XX',0,'Mumbai',400015);
/*!40000 ALTER TABLE `driver_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `user_rating` int DEFAULT '4',
  `description` varchar(500) DEFAULT 'NA',
  `ongoing_id` int DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `fk_uid` (`user_id`),
  KEY `fk_feedride` (`ongoing_id`),
  CONSTRAINT `fk_feedride` FOREIGN KEY (`ongoing_id`) REFERENCES `booking` (`ongoing_id`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`user_id`) REFERENCES `customer_details` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `distance` int DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Pune','Mumbai',250),(2,'Pune','Aurangabad',200),(3,'Kolhapur','Pune',400),(4,'Kolhapur','Mumbai',450),(5,'Mumbai','Nashik',200),(6,'Ahemadnagar','Pune',120),(7,'Delhi','Mumbai',1000),(8,'Nagpur','Mumbai',600),(9,'Nagpur','Pune',500),(10,'Indore','Pune',600),(11,'Indore','Mumbai',500);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `payment_date` varchar(20) DEFAULT (curdate()),
  `payment_time` varchar(20) DEFAULT (curtime()),
  `ongoing_id` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `fk_user_id` (`customer_id`),
  KEY `fk_carid` (`vehicle_id`),
  KEY `fk_ongoingpayment` (`ongoing_id`),
  CONSTRAINT `fk_carid` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`),
  CONSTRAINT `fk_ongoingpayment` FOREIGN KEY (`ongoing_id`) REFERENCES `booking` (`ongoing_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) DEFAULT NULL,
  `seating_capacity` int DEFAULT NULL,
  `vehicle_name` varchar(45) DEFAULT NULL,
  `brand_name` varchar(45) DEFAULT NULL,
  `price_per_km` double DEFAULT NULL,
  `fuel_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'SEDAN',5,'VERNA','HYUNDAI',15,'petrol'),(2,'SUV',6,'CRETA','HYUNDAI',20,'petrol'),(3,'Crossover',4,'S-Presso','Maruti',20,'Petrol'),(4,'SUV',7,'Safari','TATA',25,'Diesel'),(5,'Hatchback',5,'S-Cross','Maruti',18,'Petrol');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-25 11:38:26
