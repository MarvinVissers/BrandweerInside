-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 21 dec 2019 om 16:02
-- Serverversie: 10.1.30-MariaDB
-- PHP-versie: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brandweer_inside`
--
CREATE DATABASE IF NOT EXISTS `brandweer_inside` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `brandweer_inside`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `gebruiker`
--

DROP TABLE IF EXISTS `gebruiker`;
CREATE TABLE IF NOT EXISTS `gebruiker` (
  `gid` int(5) NOT NULL AUTO_INCREMENT,
  `naam` varchar(100) NOT NULL,
  `werk` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `wachtwoord` varchar(255) NOT NULL,
  `regio` varchar(10) DEFAULT NULL,
  `recht` varchar(35) NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `kazerne`
--

DROP TABLE IF EXISTS `kazerne`;
CREATE TABLE IF NOT EXISTS `kazerne` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `regio` varchar(10) NOT NULL,
  `jaar` year(4) NOT NULL,
  `professioneel_man` int(5) NOT NULL,
  `professioneel_vrouw` int(5) NOT NULL,
  `professioneel_hoger_rank` int(5) NOT NULL,
  `professioneel_midden_rank` int(5) NOT NULL,
  `professioneel_laag_rank` int(5) NOT NULL,
  `vrijwilliger_man` int(5) NOT NULL,
  `vrijwilliger_vrouw` int(5) NOT NULL,
  `vrijwilliger_hoger_rank` int(5) NOT NULL,
  `vrijwilliger_midden_rank` int(5) NOT NULL,
  `vrijwilliger_laag_rank` int(5) NOT NULL,
  `niet_operationeel_hbo_wo` int(5) NOT NULL,
  `niet_operationeel_mbo` int(5) NOT NULL,
  `niet_operationeel_lbo` int(5) NOT NULL,
  `tekort` int(1) NOT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
