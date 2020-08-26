-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2019 at 10:04 AM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminNum` int(5) NOT NULL,
  `email` varchar(20) NOT NULL,
  `pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminNum`, `email`, `pass`) VALUES
(1, 'admin001@pps.com', '1234'),
(2, 'admin002@pps.com', '5678');

-- --------------------------------------------------------

--
-- Table structure for table `assistant`
--

CREATE TABLE `assistant` (
  `First_name` varchar(10) NOT NULL,
  `Middle_name` varchar(10) NOT NULL,
  `Last_name` varchar(10) NOT NULL,
  `assist_id` int(4) NOT NULL,
  `doctor_id` varchar(5) NOT NULL,
  `pass` int(5) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistant`
--

INSERT INTO `assistant` (`First_name`, `Middle_name`, `Last_name`, `assist_id`, `doctor_id`, `pass`, `phoneNumber`) VALUES
('', 'Mohan', '', 1, 'D002', 12, '01780864523'),
('Dr', 'Sultan', '', 2, 'D004', 13, '01844433545'),
('Dr', 'Sadik', 'Rahman', 3, 'D007', 14, '01944433545'),
('', 'Eftekhar', '', 4, 'D006', 16, '01780789523'),
('Mamun', '', '', 5, 'D001', 123, '01987663122'),
('Istiaq', 'Akash', '', 6, 'D009', 135, '01780869801'),
('Dr', 'Zawad', '', 7, 'D005', 246, '01780869823'),
('Mahmud', '', '', 8, 'D003', 345, '01982327267'),
('Sanji', '', 'Lamia', 9, 'D001', 579, '01822233582'),
('Dr', 'Sonia', 'Haque', 10, 'D010', 6810, '01822233545'),
('Dr', 'Ashik', 'Khan', 11, 'D12', 342, '0178098012');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `First_name` varchar(10) NOT NULL,
  `Middle_name` varchar(10) NOT NULL,
  `Last_name` varchar(10) NOT NULL,
  `doctor_id` int(5) NOT NULL,
  `Department` varchar(10) NOT NULL,
  `Sex` text NOT NULL,
  `pass` varchar(8) NOT NULL,
  `p_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`First_name`, `Middle_name`, `Last_name`, `doctor_id`, `Department`, `Sex`, `pass`, `p_number`) VALUES
('Dr. ', 'Mahbub ', 'Rahman', 1, 'Dental', 'M', 'D123', '01780869801'),
('Dr', 'Krimiya', '', 2, 'Lungh', 'M', 'D779', '01327362452'),
('Dr.', 'Shamma', '', 3, 'Sergery', 'F', 'D002', '01480869803'),
('Dr. ', 'Ratul ', 'Roy', 4, 'Medicine', 'M', 'D246', '01808667801'),
('Ezaz', 'Nitol', 'Roy', 5, 'Eye', 'M', 'D6810', '01780869982'),
('', 'Sourov', 'Roy', 7, 'Bone', 'M', '579', '01543869801'),
('Dr.', '', 'Ontu', 8, 'Brain', 'M', '258', '01983232201'),
('Dr', 'Sovon', '', 9, 'Nero Sarg.', 'M', '679', '01628372838'),
('Dr.', 'Krisno', 'Roy', 10, 'Gastrology', 'M', '358', '01926231127');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `First_name` varchar(10) NOT NULL,
  `Middle_name` varchar(10) NOT NULL,
  `Last_name` varchar(10) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Sex` text NOT NULL,
  `Patient_id` int(5) NOT NULL,
  `password` varchar(8) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `age` int(5) NOT NULL,
  `blood_group` varchar(5) NOT NULL,
  `doctor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`First_name`, `Middle_name`, `Last_name`, `DateOfBirth`, `Sex`, `Patient_id`, `password`, `phone`, `age`, `blood_group`, `doctor_id`) VALUES
('Ashik', '', '', '1998-04-02', 'M', 1, '123', '01876736131', 21, 'A+', 2),
('Mobin', 'Bin', 'Rahman', '1994-08-30', 'M', 2, '379', '01678938232', 23, 'A+', 10),
('Nitol', '', '', '1990-01-03', 'M', 3, '2467', '01982323191', 29, 'B+', 5),
('Omar', 'Islam', '', '1998-06-20', 'M', 4, '234', '01892738232', 21, 'B+', 4),
('Sadman', '', 'Rafat', '1998-05-03', 'M', 5, '135', '01876738931', 21, 'O+', 3),
('Yeasib', 'Bin', 'Hasan', '1990-06-10', 'M', 6, '579', '01792738232', 29, 'O-', 9),
('Jilan', 'Al', 'Saif', '1978-04-23', 'M', 7, '235', '01996738931', 39, 'B-', 8),
('Omal', '', 'Barmon', '1996-06-15', 'M', 8, '248', '01662738232', 19, 'AB-', 6),
('Arafat', '', 'Moon', '1994-07-05', 'M', 9, '348', '01552738232', 25, 'A-', 6),
('Maisha', '', 'Islam', '1999-07-28', 'F', 10, '335', '01336738931', 21, 'B+', 2),
('Farzana', 'Binte', 'Sadman', '1980-06-29', 'F', 11, '558', '01442458232', 37, 'AB+', 5);

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `patient_id` int(5) NOT NULL,
  `doctor_id` varchar(5) NOT NULL,
  `problem` text NOT NULL,
  `medicine` varchar(50) NOT NULL,
  `schedule` varchar(30) NOT NULL,
  `re_visit` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `tests` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminNum`),
  ADD UNIQUE KEY `mail` (`email`);

--
-- Indexes for table `assistant`
--
ALTER TABLE `assistant`
  ADD PRIMARY KEY (`assist_id`),
  ADD UNIQUE KEY `pass` (`pass`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`),
  ADD UNIQUE KEY `pass` (`pass`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Patient_id`),
  ADD UNIQUE KEY `password` (`password`),
  ADD KEY `Patient_id` (`Patient_id`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`patient_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminNum` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `assistant`
--
ALTER TABLE `assistant`
  MODIFY `assist_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `Patient_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `treatment`
--
ALTER TABLE `treatment`
  MODIFY `patient_id` int(5) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
