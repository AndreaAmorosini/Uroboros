CREATE DATABASE  IF NOT EXISTS `e-commerce` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `e-commerce`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: e-commerce
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `CF` varchar(45) DEFAULT NULL,
  `nome_azienda` varchar(45) DEFAULT NULL,
  `numCarta` int DEFAULT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `admin` tinyint DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `indirizzo_via_idx` (`indirizzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin1','6c7ca345f63f835cb353ff15bd6c5e052ec08e7a','3',NULL,3,'via 3',1),('Utente2','dc1a15cdbb5fd392024055bdb8483d059d545fb1','234567',NULL,23456,'via2',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azienda` (
  `nome_azienda` varchar(45) NOT NULL,
  `partita_IVA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nome_azienda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carta_di_credito`
--

DROP TABLE IF EXISTS `carta_di_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carta_di_credito` (
  `numCarta` int NOT NULL,
  `data_di_scadenza` date DEFAULT NULL,
  `CSV` int DEFAULT NULL,
  `nome_titolare` varchar(45) DEFAULT NULL,
  `cognome_titolare` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numCarta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carta_di_credito`
--

LOCK TABLES `carta_di_credito` WRITE;
/*!40000 ALTER TABLE `carta_di_credito` DISABLE KEYS */;
INSERT INTO `carta_di_credito` VALUES (3,'2030-01-01',333,'nome3','cognome3');
/*!40000 ALTER TABLE `carta_di_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_prodotti`
--

DROP TABLE IF EXISTS `categoria_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria_prodotti` (
  `ID_prodotto` int NOT NULL,
  `ID_categoria` int NOT NULL,
  PRIMARY KEY (`ID_prodotto`,`ID_categoria`),
  KEY `noemCategoria_Index` (`ID_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_prodotti`
--

LOCK TABLES `categoria_prodotti` WRITE;
/*!40000 ALTER TABLE `categoria_prodotti` DISABLE KEYS */;
INSERT INTO `categoria_prodotti` VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(6,2),(7,3),(8,3),(9,3);
/*!40000 ALTER TABLE `categoria_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `idCategoria` int NOT NULL,
  `nomeCategoria` varchar(45) DEFAULT NULL,
  `descrizioneCategoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  KEY `nomeCategoria` (`nomeCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Giochi','Giochi per Computer'),(2,'Software','Software per Computer'),(3,'Hardware','Hardware per Computer');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `CF` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `età` int DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CF`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES ('234567','Utente','2',NULL,'2000-03-24',2345678,'mail2@mail.it'),('3','nome3','cognome3',30,'1990-03-24',33333,'mail3@mail.com');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indirizzo`
--

DROP TABLE IF EXISTS `indirizzo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `indirizzo` (
  `via` varchar(45) NOT NULL,
  `CAP` int NOT NULL,
  `via2` varchar(45) DEFAULT NULL,
  `nazione` varchar(45) DEFAULT NULL,
  `regione` varchar(45) DEFAULT NULL,
  `città` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`via`,`CAP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indirizzo`
--

LOCK TABLES `indirizzo` WRITE;
/*!40000 ALTER TABLE `indirizzo` DISABLE KEYS */;
INSERT INTO `indirizzo` VALUES ('via 3',3000,'','nazione3','regione3','citta3'),('via2',23456,'2','nazione2','regione2','città2');
/*!40000 ALTER TABLE `indirizzo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotti` (
  `ID_Prodotto` int NOT NULL,
  `quantità_disponibile` int DEFAULT NULL,
  `nome_prodotto` varchar(45) DEFAULT NULL,
  `descrizione_prodotto` varchar(400) DEFAULT NULL,
  `prezzo` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,10,'videogioco 1','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',19.99),(2,23,'videogioco 2','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',30.00),(3,31,'videogioco 3','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',59.99),(4,22,'software 1','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',70.00),(5,15,'software 2','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',15.99),(6,41,'software 3','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',5.50),(7,100,'hardware 1','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',7.80),(8,55,'hardware 2','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',45.30),(9,70,'hardware 3','Paragraph one lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.',33.33);
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('admin1'),('utente2'),('Utente4');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transazione`
--

DROP TABLE IF EXISTS `transazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transazione` (
  `ID_transazione` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `data_transazione` date DEFAULT NULL,
  `spesa` double DEFAULT NULL,
  PRIMARY KEY (`ID_transazione`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transazione`
--

LOCK TABLES `transazione` WRITE;
/*!40000 ALTER TABLE `transazione` DISABLE KEYS */;
INSERT INTO `transazione` VALUES (15,'admin1','2020-08-01',30),(25,'Utente2','2021-01-11',19.99),(32,'admin1','2021-01-12',19.99),(36,'admin1','2021-01-12',19.99);
/*!40000 ALTER TABLE `transazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transazione_item`
--

DROP TABLE IF EXISTS `transazione_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transazione_item` (
  `ID_transazione` int NOT NULL,
  `ID_prodotto` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_transazione`,`ID_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transazione_item`
--

LOCK TABLES `transazione_item` WRITE;
/*!40000 ALTER TABLE `transazione_item` DISABLE KEYS */;
INSERT INTO `transazione_item` VALUES (15,2,'admin1'),(25,1,'Utente2'),(32,1,'admin1'),(36,1,'admin1');
/*!40000 ALTER TABLE `transazione_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-12 14:49:29
