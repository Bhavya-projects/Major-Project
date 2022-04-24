-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2019 at 07:20 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `minor_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_class`
--

CREATE TABLE IF NOT EXISTS `add_class` (
  `class_id` int(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) NOT NULL,
  `semester` int(20) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `add_class`
--

INSERT INTO `add_class` (`class_id`, `course_name`, `semester`, `teacher`) VALUES
(6, 'BE CIVIL', 4, 'mayank'),
(7, 'BE CSE', 7, 'Ravi'),
(8, 'BE MECH', 6, 'Ravi'),
(9, 'BE IT', 2, 'Pankaj'),
(10, 'BE IT', 3, 'Aman'),
(11, 'BE CSE', 7, 'Aman'),
(12, 'BE CSE', 7, 'Mohan'),
(13, 'BE CSE', 7, 'Manjal'),
(14, 'BE CSE', 7, 'Rajesh'),
(15, 'BE CSE', 7, 'Piyush'),
(16, 'BE CSE', 6, 'Akash'),
(17, 'BE MECH', 6, 'Aman'),
(18, 'BE CSE', 3, 'shankar tripathi');

-- --------------------------------------------------------

--
-- Table structure for table `insertfeedback`
--

CREATE TABLE IF NOT EXISTS `insertfeedback` (
  `sno` int(20) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) NOT NULL,
  `ratings` int(20) NOT NULL,
  `comment` varchar(100) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `insertfeedback`
--

INSERT INTO `insertfeedback` (`sno`, `teacher_name`, `ratings`, `comment`, `date`) VALUES
(1, 'Manjal', 1, 'hello', '2019-03-30'),
(2, 'Piyush', 2, 'hello', '2019-04-05'),
(3, 'Manjal', 3, 'hello', '2019-03-30'),
(4, 'Ravi', 4, 'Good', '2019-04-07');

-- --------------------------------------------------------

--
-- Table structure for table `login_check`
--

CREATE TABLE IF NOT EXISTS `login_check` (
  `s_no` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_type` varchar(100) NOT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `login_check`
--

INSERT INTO `login_check` (`s_no`, `name`, `user_id`, `user_password`, `user_type`) VALUES
(1, 'Admin', 'admin1234', 'ad', 'Admin'),
(6, 'Aman', 'aman1234', 'am', 'teacher'),
(9, 'mayank', 'mayank1234', 'ma', 'teacher'),
(10, 'harneet', 'harneet1234', 'ha', 'student'),
(11, 'Ravi', 'r1234', 'r1', 'teacher'),
(12, 'divakar', 'd1234', 'd1', 'student'),
(13, 'Pankaj', 'pan1234', 'pa', 'teacher'),
(14, 'Kulvinder', 'k1234', 'k1', 'student'),
(15, 'Mohan', 'm123', 'm1', 'teacher'),
(16, 'Manjal', 'm1234', 'ma', 'teacher'),
(17, 'Rajesh', 'r1234', 'ra', 'teacher'),
(18, 'Piyush', 'p1234', 'p1', 'student'),
(19, 'Prakash', 'p12345', 'pr', 'student'),
(20, 'Ajay', 'a12345', 'aj', 'student'),
(21, 'Aman', 'am1234', 'ama', 'student'),
(22, 'Piyush', 'p1234', 'pi', 'teacher'),
(23, 'Ankit', 'a1234', 'an', 'student'),
(24, 'Akash', 'ak1234', 'ak', 'teacher'),
(25, 'shankar tripathi', 'shankar1234', '1234', 'teacher'),
(26, 'ramesh', 'ramesh1234', 'ra', 'teacher'),
(27, 'harleen', 'harleen1234', 'ha', 'student'),
(28, 'Ravi', 'ravi1234', 'ra', 'teacher'),
(29, 'shankar', 'shankar01', 'shan', 'teacher'),
(30, 'shankar', 'shankar01', 'shan', 'teacher'),
(31, 'shankar', 'shankar01', 'shan', 'teacher'),
(32, 'shankar', 'shankar01', 'shan', 'teacher'),
(33, 'shankar', 'shankar01', 'shan', 'teacher'),
(34, 'shankar', 'shankar01', 'shan', 'teacher'),
(35, 'shankar', 'shankar01', 'shan', 'teacher'),
(36, 'shankar', 'shankar01', 'shan', 'teacher'),
(37, 'shankar', 'shankar01', 'shan', 'teacher'),
(38, 'Bhavya', 'bhavya1234', 'bh', 'teacher');

-- --------------------------------------------------------

--
-- Table structure for table `student_attendance`
--

CREATE TABLE IF NOT EXISTS `student_attendance` (
  `sno` int(20) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) NOT NULL,
  `attendance` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `took_by` varchar(20) NOT NULL,
  `semester` int(20) NOT NULL,
  `class` varchar(20) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `student_attendance`
--

INSERT INTO `student_attendance` (`sno`, `s_name`, `attendance`, `date`, `took_by`, `semester`, `class`) VALUES
(1, 'harneet', 'present', '2018-10-24', 'piyush', 6, 'BE CSE'),
(3, 'harneet', 'present', '2018-10-25', 'manoj', 6, 'BE CSE'),
(4, 'harneet', 'absent', '2018-10-23', 'aman', 6, 'BE CSE'),
(5, 'ankit', 'absent', '2018-10-24', 'aman', 6, 'BE CSE'),
(6, 'ankit', 'present', '2018-10-23', 'aman', 6, 'BE CSE');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE IF NOT EXISTS `student_details` (
  `student_id` int(20) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `class` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `student_email_id` varchar(20) NOT NULL,
  `semester` int(20) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `student_name`, `user_name`, `password`, `class`, `phone`, `student_email_id`, `semester`) VALUES
(5, 'harneet', 'harneet1234', 'ha', 'BE CSE', '8224005549', 'har@gmail.com', 7),
(6, 'divakar', 'd1234', 'd1', 'BE MECH', '987456325', 'd@gmail.com', 6),
(7, 'Kulvinder', 'k1234', 'k1', 'BE MECH', '65656566', 'k@gmail.com', 6),
(8, 'Piyush', 'p1234', 'p1', 'BE MECH', '789654111', 'pi@gmail.com', 6),
(9, 'Prakash', 'p12345', 'pr', 'BE MECH', '789655555', 'pr@gmail.com', 6),
(10, 'Ajay', 'a12345', 'aj', 'BE MECH', '789655555', 'aj@gmail.com', 6),
(11, 'Aman', 'am1234', 'ama', 'BE MECH', '66658888', 'am@gmail.com', 6),
(12, 'Ankit', 'a1234', 'an', 'BE MECH', '9875554111', 'a@gmail.com', 6),
(13, 'harleen', 'harleen1234', 'ha', 'BE CSE', '9827960217', '123@gmail.com', 7);

-- --------------------------------------------------------

--
-- Table structure for table `teachers_details`
--

CREATE TABLE IF NOT EXISTS `teachers_details` (
  `teacher_id` int(20) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `teacher_mobileno` int(100) NOT NULL,
  `teacher_emailid` varchar(20) NOT NULL,
  `teacher_highestqualification` varchar(20) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `teachers_details`
--

INSERT INTO `teachers_details` (`teacher_id`, `teacher_name`, `user_name`, `password`, `teacher_mobileno`, `teacher_emailid`, `teacher_highestqualification`) VALUES
(9, 'Aman', 'aman1234', 'am', 36985214, 'a@gmail.com', 'BSC'),
(10, 'mayank', 'mayank1234', 'ma', 12365987, 'm@gmail.com', 'BE'),
(11, 'Ravi', 'r1234', 'r1', 56987132, 'r@gmail.com', 'M-TECH'),
(12, 'Pankaj', 'pan1234', 'pa', 656525565, 'p@gmail.com', 'MSC'),
(13, 'Mohan', 'm123', 'm1', 563214789, 'm@gmail.com', 'BE'),
(14, 'Manjal', 'm1234', 'ma', 56698788, 'm@gmail.com', 'BE'),
(15, 'Rajesh', 'r1234', 'ra', 99698788, 'ra@gmail.com', 'BE'),
(16, 'Piyush', 'p1234', 'pi', 987655542, 'p@gmail.com', 'BE'),
(17, 'Akash', 'ak1234', 'ak', 987963214, 'ak@gmail.com', 'BE'),
(18, 'shankar tripathi', 'shankar1234', '1234', 2147483647, 's@gmail.com', 'BE'),
(19, 'ramesh', 'ramesh1234', 'ra', 2147483647, 'ramesh@gmail.com', 'M-TECH'),
(20, 'Ravi', 'ravi1234', 'ra', 2147483647, 'ravi@gmail.com', 'BE'),
(21, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(22, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(23, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(24, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(25, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(26, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(27, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(28, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(29, 'shankar', 'shankar01', 'shan', 2147483647, 'tripathishankar01@gm', ''),
(30, 'Bhavya', 'bhavya1234', 'bh', 2147483647, 'bhavya@gmail.com', 'Be');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
