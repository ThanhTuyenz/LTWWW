-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for employees_jpa_webmvc
DROP DATABASE IF EXISTS `employees_jpa_webmvc`;
CREATE DATABASE IF NOT EXISTS `employees_jpa_webmvc` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `employees_jpa_webmvc`;

-- Dumping structure for table employees_jpa_webmvc.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `modified_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table employees_jpa_webmvc.address: ~1 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`id`, `address`, `created_date`, `modified_date`) VALUES
	(1, '123 Main St, Springfield, IL', '2025-11-09 00:53:24', '2025-11-09 00:53:24');

-- Dumping structure for table employees_jpa_webmvc.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email_address` varchar(255) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `modified_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `address_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_address` (`address_id`),
  CONSTRAINT `fk_employee_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `chk_phone_number` CHECK (`phone_number` regexp '\\(\\d{3}\\)\\d{3}-\\d{4}')
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table employees_jpa_webmvc.employee: ~1 rows (approximately)
DELETE FROM `employee`;
INSERT INTO `employee` (`id`, `first_name`, `last_name`, `gender`, `email_address`, `phone_number`, `dob`, `created_date`, `modified_date`, `address_id`, `email`) VALUES
	(1, 'John', 'Doe', NULL, 'john.doe@example.com', '(123)456-7890', '1980-06-15', '2025-11-09 00:53:24', '2025-11-09 00:53:24', 1, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
