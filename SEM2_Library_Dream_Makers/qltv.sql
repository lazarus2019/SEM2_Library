-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2020 at 05:08 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltv`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_ID` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `dob` date NOT NULL,
  `position_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `au_book`
--

CREATE TABLE `au_book` (
  `book_ID` varchar(30) NOT NULL,
  `author_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `au_position`
--

CREATE TABLE `au_position` (
  `position_ID` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_ID` varchar(30) NOT NULL,
  `call_number` varchar(30) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  `title` varchar(100) NOT NULL,
  `category_ID` varchar(30) NOT NULL,
  `publish_ID` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `borrow_bill`
--

CREATE TABLE `borrow_bill` (
  `borrow_ID` varchar(13) NOT NULL,
  `member_ID` varchar(30) NOT NULL,
  `employee_ID` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `status` tinyint(1) NOT NULL,
  `borrow_date` date NOT NULL,
  `term_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `deposit_fee` double NOT NULL,
  `late_fee` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bor_book`
--

CREATE TABLE `bor_book` (
  `book_ID` varchar(30) NOT NULL,
  `borrow_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_ID` varchar(30) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_ID` varchar(30) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `lib_card`
--

CREATE TABLE `lib_card` (
  `card_number` varchar(13) NOT NULL,
  `start_date` date NOT NULL,
  `expiration_date` date NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_ID` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(300) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `card_number` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `publish_house`
--

CREATE TABLE `publish_house` (
  `publish_ID` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_ID`),
  ADD KEY `position_ID` (`position_ID`);

--
-- Indexes for table `au_book`
--
ALTER TABLE `au_book`
  ADD KEY `author_ID` (`author_ID`),
  ADD KEY `book_ID` (`book_ID`);

--
-- Indexes for table `au_position`
--
ALTER TABLE `au_position`
  ADD PRIMARY KEY (`position_ID`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_ID`),
  ADD KEY `category_ID` (`category_ID`),
  ADD KEY `publish_ID` (`publish_ID`);

--
-- Indexes for table `borrow_bill`
--
ALTER TABLE `borrow_bill`
  ADD PRIMARY KEY (`borrow_ID`),
  ADD KEY `borrow_ID` (`borrow_ID`),
  ADD KEY `member_ID` (`member_ID`),
  ADD KEY `employee_ID` (`employee_ID`);

--
-- Indexes for table `bor_book`
--
ALTER TABLE `bor_book`
  ADD KEY `book_ID` (`book_ID`),
  ADD KEY `borrow_ID` (`borrow_ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_ID`);

--
-- Indexes for table `lib_card`
--
ALTER TABLE `lib_card`
  ADD PRIMARY KEY (`card_number`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_ID`),
  ADD KEY `card_number` (`card_number`);

--
-- Indexes for table `publish_house`
--
ALTER TABLE `publish_house`
  ADD PRIMARY KEY (`publish_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `au_position`
--
ALTER TABLE `au_position`
  MODIFY `position_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `author_ibfk_1` FOREIGN KEY (`position_ID`) REFERENCES `au_position` (`position_ID`);

--
-- Constraints for table `au_book`
--
ALTER TABLE `au_book`
  ADD CONSTRAINT `au_book_ibfk_1` FOREIGN KEY (`author_ID`) REFERENCES `author` (`author_ID`),
  ADD CONSTRAINT `au_book_ibfk_2` FOREIGN KEY (`book_ID`) REFERENCES `books` (`book_ID`);

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`category_ID`) REFERENCES `category` (`category_ID`),
  ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`publish_ID`) REFERENCES `publish_house` (`publish_ID`);

--
-- Constraints for table `borrow_bill`
--
ALTER TABLE `borrow_bill`
  ADD CONSTRAINT `borrow_bill_ibfk_1` FOREIGN KEY (`member_ID`) REFERENCES `member` (`member_ID`),
  ADD CONSTRAINT `borrow_bill_ibfk_2` FOREIGN KEY (`employee_ID`) REFERENCES `employee` (`employee_ID`);

--
-- Constraints for table `bor_book`
--
ALTER TABLE `bor_book`
  ADD CONSTRAINT `bor_book_ibfk_1` FOREIGN KEY (`book_ID`) REFERENCES `books` (`book_ID`),
  ADD CONSTRAINT `bor_book_ibfk_2` FOREIGN KEY (`borrow_ID`) REFERENCES `borrow_bill` (`borrow_ID`);

--
-- Constraints for table `lib_card`
--
ALTER TABLE `lib_card`
  ADD CONSTRAINT `lib_card_ibfk_1` FOREIGN KEY (`card_number`) REFERENCES `member` (`card_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
