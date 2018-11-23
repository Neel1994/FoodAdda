-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: foodadda
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdebwvad6pp1ekiqy5jtixqbaj` (`customer_id`),
  KEY `FK9fhia6b3ekuddn6pkxlsks7rr` (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'GH-1','vipul@gmail.com','Vipul','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),(2,'BITS Pilani','nilesh@gmail.com','Nilesh','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt9gnevqw4oo5jnbv4e68tu0ua` (`restaurant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3),(3),(3),(3),(3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ip7t8cv2p1ghfi1e796yet7d` (`restaurant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'MasalaDosa',50,1),(2,'PaperDosa',70,1),(3,'RawaDosa',80,1),(4,'Manchurian',60,1),(5,'MalaiKofta',70,1),(6,'Shahi Paneer',100,1),(7,'Matar Paneer',120,1),(8,'Pizza',180,1),(9,'Biryani',170,1),(10,'Shahi Pulav',200,1),(11,'Matan Korma ',180,2),(12,'Matar Malai',140,2),(13,'Veg Pizza',160,2),(14,'Navaratna Korma',120,2),(15,'Malai Kofta',130,2),(16,'Tandoori Chicken',160,2),(17,'Roomali Roti',10,2),(18,'Tandoori Roti',20,2),(19,'Veg Biryani',80,2),(20,'Mughlai',200,2),(21,'Litti',25,3),(22,'Cold Cofee',40,3),(23,'Cappacuino',80,3),(24,'Kheer',100,3),(25,'Kaju Katli',80,3),(26,'Tandoori Chicken',250,3),(27,'Chicken Curry',300,3),(28,'Chicken Korma',270,3),(29,'Egg Curry',40,3),(30,'Special Thali',80,3),(31,'Veg Burger',50,4),(32,'Paneer Roll',40,4),(33,'Veg Roll',60,4),(34,'Egg Roll',40,4),(35,'Chicken Chilly',190,4),(36,'Potato Chilly',200,4),(37,'Paneer Lababdaar',100,4),(38,'Milk Shake',60,4),(39,'Fruit Salad',80,4),(40,'Mutton Biryani',100,4),(41,'Chicken Hyderabadi',400,5),(42,'Paneer Tikka Butter Masala',350,5),(43,'Cheese Burst Pizza',300,5),(44,'Nachos',200,5),(45,'Navratna Korma',250,5),(46,'Aaloo Jeeera',70,5),(47,'Palak Methi',80,5),(48,'Paneer Butter Masala',140,5),(49,'Pumpkin Masala',70,5),(50,'Sundae',80,5),(51,'Butter Scotch',70,6),(52,'Manchurian',60,6),(53,'Shahi Toast',70,6),(54,'Veg Sandwich',50,6),(55,'Mughlai Kebab',60,6),(56,'Gulab Jamun',60,7),(57,'Rasmalai',80,7),(58,'Chhola Bhatura',60,7),(59,'Paneer Kulcha',80,7),(60,'Paneer Frankie',90,7);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `rating_points` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Bits Pilani','Looters',0,0),(2,'Bits Pilani','Annapurna',0,0),(3,'Bits Pilani','Food King',0,0),(4,'Bits Pilani','Subhas Reddi',0,0),(5,'Bits Pilani','Gandhi Reddi',0,0),(6,'Bits Pilani','ANC Online Canteen',0,0),(7,'Bits Pilani','Rana Pratap Reddi',0,0);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-24  1:54:39
