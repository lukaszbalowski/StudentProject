-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: school
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

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
-- Table structure for table `class_teacher`
--

DROP TABLE IF EXISTS `class_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_teacher` (
  `class_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  PRIMARY KEY (`class_id`,`teacher_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `class_teacher_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `class_teacher_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_teacher`
--

LOCK TABLES `class_teacher` WRITE;
/*!40000 ALTER TABLE `class_teacher` DISABLE KEYS */;
INSERT INTO `class_teacher` VALUES (1,8),(2,8),(3,8),(4,8),(1,9),(2,9),(1,10),(1,11),(1,12),(3,12),(2,13),(2,14),(3,14),(2,15),(3,15),(2,16),(3,16),(2,17),(3,17),(1,18),(3,18),(4,18),(1,19),(2,19),(3,19),(1,24);
/*!40000 ALTER TABLE `class_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Klasa 1 - nowa nazwa','Nowy Opis dla klasy 1: Parę słów o klasie 2: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis diam sit amet tincidunt porttitor. In tortor leo, euismod interdum feugiat vel, dictum vel neque. Vestibulum imperdiet arcu ut nunc mollis molestie. Integer mollis vitae tortor ac fringilla. Suspendisse enim urna, egestas et sem et, volutpat tincidunt mauris. Donec leo elit, commodo et dapibus sit amet, hendrerit at enim. Proin mauris lacus, ultrices id quam vitae, pellentesque venenatis velit. Etiam vehicula, leo eget placerat elementum, erat nulla facilisis turpis, ut efficitur diam nisl nec tortor.'),(2,'Klasa 2','Parę słów o klasie 2: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis diam sit amet tincidunt porttitor. In tortor leo, euismod interdum feugiat vel, dictum vel neque. Vestibulum imperdiet arcu ut nunc mollis molestie. Integer mollis vitae tortor ac fringilla. Suspendisse enim urna, egestas et sem et, volutpat tincidunt mauris. Donec leo elit, commodo et dapibus sit amet, hendrerit at enim. Proin mauris lacus, ultrices id quam vitae, pellentesque venenatis velit. Etiam vehicula, leo eget placerat elementum, erat nulla facilisis turpis, ut efficitur diam nisl nec tortor.'),(3,'Klasa 3','Parę słów o klasie 3: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis diam sit amet tincidunt porttitor. In tortor leo, euismod interdum feugiat vel, dictum vel neque. Vestibulum imperdiet arcu ut nunc mollis molestie. Integer mollis vitae tortor ac fringilla. Suspendisse enim urna, egestas et sem et, volutpat tincidunt mauris. Donec leo elit, commodo et dapibus sit amet, hendrerit at enim. Proin mauris lacus, ultrices id quam vitae, pellentesque venenatis velit. Etiam vehicula, leo eget placerat elementum, erat nulla facilisis turpis, ut efficitur diam nisl nec tortor.'),(4,'Klasa 4','Na koniec parę słów o klasie 4: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis diam sit amet tincidunt porttitor. In tortor leo, euismod interdum feugiat vel, dictum vel neque. Vestibulum imperdiet arcu ut nunc mollis molestie. Integer mollis vitae tortor ac fringilla. Suspendisse enim urna, egestas et sem et, volutpat tincidunt mauris. Donec leo elit, commodo et dapibus sit amet, hendrerit at enim. Proin mauris lacus, ultrices id quam vitae, pellentesque venenatis velit. Etiam vehicula, leo eget placerat elementum, erat nulla facilisis turpis, ut efficitur diam nisl nec tortor.');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parents` (
  `parent_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (1,'John','Doe','john.doe@example.com','1234567890'),(2,'Jane','Smith','jane.smith@example.com','9876543210'),(3,'John','Doe','john.doe@example.com','1234567890'),(4,'Jane','Smith','jane.smith@example.com','9876543210'),(5,'Michael','Johnson','michael.johnson@example.com','1111111111'),(6,'Emily','Williams','emily.williams@example.com','2222222222'),(7,'David','Brown','david.brown@example.com','3333333333'),(8,'Sarah','Jones','sarah.jones@example.com','4444444444'),(9,'Jan','Nowak','jan.nowak@example.com','111111111'),(10,'Anna','Kowalska','anna.kowalska@example.com','222222222'),(11,'Piotr','Wiśniewski','piotr.wisniewski@example.com','333333333'),(12,'Maria','Lewandowska','maria.lewandowska@example.com','444444444'),(13,'Tomasz','Dąbrowski','tomasz.dabrowski@example.com','555555555'),(14,'Magdalena','Kamińska','magdalena.kaminska@example.com','666666666'),(15,'Robert','Zając','robert.zajac@example.com','777777777'),(16,'Dorota','Król','dorota.krol@example.com','888888888'),(17,'Grzegorz','Wójcik','grzegorz.wojcik@example.com','999999999'),(18,'Katarzyna','Kaczmarek','katarzyna.kaczmarek@example.com','111111110'),(19,'Marek','Grabowski','marek.grabowski@example.com','222222221'),(20,'Aleksandra','Nowakowska','aleksandra.nowakowska@example.com','333333332'),(21,'Rafał','Pawlak','rafal.pawlak@example.com','444444443'),(22,'Sylwia','Michalak','sylwia.michalak@example.com','555555554'),(52,'Rodzic','Testowy','email@email.com','69984654');
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `study_start_date` varchar(255) DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (3,'Bob','Doe','bob.doe@example.com','2222222222','2000-03-01','2022-02-15',1,2),(4,'Eva','Smith','eva.smith@example.com','3333333333','2004-12-10','2020-09-01',2,1),(5,'Max','Smith','max.smith@example.com','4444444444','2006-07-20','2022-02-15',2,2),(6,'Alice','Doe','alice.doe@example.com','1111111111','2005-01-01','2020-09-01',1,4),(7,'Bob','Doe','bob.doe@example.com','2222222222','2007-03-15','2022-02-15',1,1),(8,'Eva','Smith','eva.smith@example.com','3333333333','2004-12-10','2020-09-01',2,4),(9,'Max','Smith','max.smith@example.com','4444444444','2006-07-20','2022-02-15',2,1),(10,'Sophia','Johnson','sophia.johnson@example.com','5555555555','2005-06-05','2020-09-01',3,1),(11,'Oliver','Johnson','oliver.johnson@example.com','6666666666','2007-11-18','2022-02-15',3,1),(12,'Emma','Williams','emma.williams@example.com','7777777777','2005-09-23','2021-09-01',4,2),(13,'Noah','Williams','noah.williams@example.com','8888888888','2007-02-12','2023-02-15',4,2),(16,'Mia','Jones','mia.jones@example.com','11112222333','2006-01-14','2021-09-01',6,2),(17,'William','Jones','william.jones@example.com','44443333222','2008-04-27','2023-02-15',6,2),(18,'Charlotte','Smith','charlotte.smith@example.com','55554444333','2005-10-19','2022-09-01',2,3),(19,'James','Smith','james.smith@example.com','44443333555','2007-01-30','2024-02-15',2,3),(20,'Harper','Johnson','harper.johnson@example.com','77772222333','2005-07-07','2022-09-01',3,3),(21,'Benjamin','Johnson','benjamin.johnson@example.com','11113333555','2007-12-22','2024-02-15',3,3),(22,'Amelia','Williams','amelia.williams@example.com','99992222333','2006-03-08','2022-09-01',4,3),(23,'Elijah','Williams','elijah.williams@example.com','44442222111','2008-06-17','2024-02-15',4,3),(26,'Grace','Jones','grace.jones@example.com','66665555444','2005-08-09','2023-09-01',8,4),(27,'Lucas','Jones','lucas.jones@example.com','33331111444','2007-11-04','2025-02-15',9,4),(28,'Chloe','Smith','chloe.smith@example.com','88882222333','2006-05-21','2023-09-01',10,4),(29,'Alexander','Smith','alexander.smith@example.com','55553333444','2008-08-14','2025-02-15',11,4),(30,'Adam','Nowak','adam.nowak@example.com','123456789','2000-01-05','2021-09-01',12,1),(31,'Marta','Kowalska','marta.kowalska@example.com','987654321','2001-03-12','2021-09-01',13,2),(32,'Jakub','Dąbrowski','jakub.dabrowski@example.com','123450000','2002-05-15','2022-09-01',14,1),(33,'Weronika','Kamińska','weronika.kaminska@example.com','123450001','2003-07-20','2022-09-01',15,2),(34,'Bartosz','Zając','bartosz.zajac@example.com','123450002','2002-09-10','2022-09-01',16,3),(35,'Natalia','Król','natalia.krol@example.com','123450003','2003-01-25','2022-09-01',17,4),(36,'Mateusz','Wójcik','mateusz.wojcik@example.com','123450004','2002-04-12','2022-09-01',18,1),(37,'Paulina','Kaczmarek','paulina.kaczmarek@example.com','123450005','2003-06-28','2022-09-01',19,2),(38,'Kamil','Grabowski','kamil.grabowski@example.com','123450006','2002-08-05','2022-09-01',20,3),(39,'Oliwia','Nowak','oliwia.nowakowska@example.com','123450007','2003-02-17','2022-09-01',21,4),(40,'Michał','Pawlak','michal.pawlak@example.com','123450008','2002-03-30','2022-09-01',22,1),(41,'Izabela','Michalak','izabela.michalak@example.com','123450009','2003-05-10','2022-09-01',19,2),(65,'aaa','aaa','balos@tlen.pl','6546894','2023-01-01','2023-06-02',52,1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) DEFAULT NULL,
  `subject_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (22,'Matematyka','Przedmiot obejmujący zagadnienia arytmetyki, geometrii i algebra.'),(23,'Język polski','Przedmiot skupiający się na nauce czytania, pisania i poprawnej gramatyki.'),(24,'Historia','Przedmiot ukazujący wydarzenia historyczne i rozwijający świadomość historyczną.'),(25,'Przyroda','Przedmiot poświęcony badaniu świata przyrody, takiego jak flora, fauna i zjawiska przyrodnicze.'),(26,'Muzyka','Przedmiot rozwijający zainteresowania muzyczne i umiejętności muzyczne.'),(27,'Plastyka','Przedmiot skupiający się na rozwijaniu zdolności manualnych i artystycznych.'),(28,'Wychowanie fizyczne','Przedmiot mający na celu rozwój sprawności fizycznej i zdrowego trybu życia.'),(29,'Przyrodo-wiedza','Przedmiot łączący elementy biologii, geografii i chemii.'),(30,'Język obcy','Przedmiot nauki języka obcego, takiego jak angielski, niemiecki czy francuski.'),(31,'Informatyka','Przedmiot wprowadzający do podstawowych zagadnień z dziedziny informatyki i programowania.');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subject`
--

DROP TABLE IF EXISTS `teacher_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subject` (
  `teacher_id` int NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`teacher_id`,`subject_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `teacher_subject_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`),
  CONSTRAINT `teacher_subject_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subject`
--

LOCK TABLES `teacher_subject` WRITE;
/*!40000 ALTER TABLE `teacher_subject` DISABLE KEYS */;
INSERT INTO `teacher_subject` VALUES (8,22),(17,22),(9,23),(14,23),(15,23),(16,23),(17,23),(8,24),(10,24),(13,24),(16,24),(17,24),(11,25),(15,25),(16,25),(17,25),(12,26),(13,26),(16,26),(18,26),(24,26),(11,27),(15,27),(18,27),(24,27),(17,28),(8,29),(11,29),(13,29),(15,29),(8,30),(14,30),(16,30),(19,30),(19,31);
/*!40000 ALTER TABLE `teacher_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (8,'Anna','Nowak','anna.nowak@example.com','65465484321',NULL),(9,'Piotr','Wiśniewski','piotr.wisniewski@example.com','555555555',NULL),(10,'Barbara','Kamińska','barbara.kaminska@example.com','666666666',NULL),(11,'Krzysztof','Lewandowski','krzysztof.lewandowski@example.com','777777777',NULL),(12,'Małgorzata','Dąbrowska','malgorzata.dabrowska@example.com','888888888',NULL),(13,'Robert','Zieliński','robert.zielinski@example.com','999999999',NULL),(14,'Magdalena','Szymańska','magdalena.szymanska@example.com','111111111',NULL),(15,'Marek','Woźniak','marek.wozniak@example.com','222222222',NULL),(16,'Agnieszka','Kozłowska','agnieszka.kozlowska@example.com','333333333',NULL),(17,'Adam','Jankowski','adam.jankowski@example.com','444444444',NULL),(18,'Joanna','Wojciechowska','joanna.wojciechowska@example.com','555555555',NULL),(19,'Kamil','Kowalczyk','kamil.kowalczyk@example.com','666666666',NULL),(24,'AAA','AAA','emai@email.com','654984',NULL);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-15 19:50:04