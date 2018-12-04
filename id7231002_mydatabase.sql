-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 29, 2018 at 01:25 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id7231002_mydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `teamA` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `teamB` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `goalsA` int(2) NOT NULL,
  `goalsB` int(2) NOT NULL,
  `Winner` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`teamA`, `teamB`, `goalsA`, `goalsB`, `Winner`) VALUES
('real madrid', 'qw', 4, 3, 'real madrid'),
('qw', 'barca', 6, 5, 'qw'),
('real madrid', 'barca', 2, 4, 'barca'),
('baba', 'real madrid', 4, 4, 'TIE'),
('barca', 'real madrid', 6, 0, 'barca'),
('dinamo', 'baba', 0, 4, 'baba');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `age` tinyint(4) NOT NULL,
  `team` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `rule` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `hours` tinyint(4) NOT NULL,
  `field` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `age`, `team`, `rule`, `hours`, `field`) VALUES
('ggg', '0', 23, '', 'rr', 4, ''),
('ben', '0', 23, '', 'rr', 4, ''),
('shlmo', '0', 23, '', 'mid', 3, ''),
('kaka2500', 'abcde123', 50, '', 'striker', 10, ''),
('ovadia', '13432', 44, '', 'gk', 1, ''),
('moshe', '12341234', 66, '', 'cd', 3, ''),
('moshe1', '12521', 55, '', 'st', 5, ''),
('stas', '1122', 25, '', 'left wing', 4, ''),
('rom', '12345', 22, '', 'st', 10, ''),
('stasash', '12345', 30, '', 'at', 2, ''),
('shimhon', 'toti10', 35, '', 'mid', 3, ''),
('stanislav', '12345', 18, '', 'st', 4, ''),
('ben_ist', '12345', 25, 'barca', 'mid', 4, 'Toto_Turner'),
('qwe', '123', 11, 'qw', 'qw', 2, 'Alianz_Arena'),
('qwer', '12345', 55, 'baba', 'sgsd', 5, 'Santiago_Bernabe'),
('chris', '12344', 20, 'real', 'mid', 4, 'Alianz_Arena'),
('lior', '1234321', 22, 'real', 'gk', 1, 'Alianz_Arena'),
('tamar', 'tamar', 16, 'barca', 'cb', 3, 'None'),
('tomi', '123321', 13, 'barca', 'cb', 3, 'Alianz_Arena'),
('isco', 'isco', 27, 'real madrid', 'md', 2, 'Santiago_Bernabe'),
('leo', 'messi', 31, 'barca', 'all', 5, 'Camp_Nou'),
('stasticov', '12345', 31, 'dinamo', 'gk', 3, 'Toto_Turner');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
