-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2020 at 05:35 AM
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
  `nation` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`author_ID`, `name`, `nation`) VALUES
('CODO', 'Arthur Conan Doyle', 'Ireland'),
('DABU', 'Ashley Davis Bush', 'American'),
('DACA', 'Dale Carnegie', 'American'),
('DIGA', 'Diana Gabaldon', 'American'),
('ELFE', 'Ellen Fein', 'American'),
('KIKI', 'Triệu Kiền Kiền', 'China'),
('MAMA', 'Mark Manson', 'American'),
('MEMO', 'Mễ Mông ', 'China'),
('NGTH', 'Nguyễn Ngọc Thạch', 'VietNam'),
('NHAN', 'Nguyễn Nhật Ánh', 'VIetNam'),
('NIFL', 'Night-fly', 'VietNam'),
('ROSIE', 'Rosie Nguyễn', 'VietNam'),
('SHMA', 'Shinkai Makoto', 'Japan'),
('SHSC', 'Sherrie Schneider', 'American'),
('TOMA', 'Tống Mặc', 'China'),
('TONY', 'Tony Buổi Sáng', 'VietNam'),
('TRPH', 'Vũ Trọng Phụng', 'VietNam'),
('TUHU', 'Sử Tú Hùng', 'China');

-- --------------------------------------------------------

--
-- Table structure for table `au_book`
--

CREATE TABLE `au_book` (
  `No` int(11) NOT NULL,
  `book_ID` varchar(30) NOT NULL,
  `author_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `au_book`
--

INSERT INTO `au_book` (`No`, `book_ID`, `author_ID`) VALUES
(13, 'BK01', 'TOMA'),
(14, 'BK02', 'MEMO'),
(15, 'BK03', 'TRPH'),
(16, 'BK04', 'ELFE'),
(17, 'BK04', 'SHSC'),
(18, 'BK05', 'TUHU'),
(19, 'BK06', 'DIGA'),
(20, 'BK07', 'DIGA'),
(21, 'BK08', 'CODO'),
(22, 'BK09', 'CODO'),
(23, 'BK10', 'CODO'),
(24, 'BK11', 'NGTH'),
(25, 'BK12', 'NIFL'),
(26, 'BK13', 'DABU'),
(27, 'BK14', 'MAMA'),
(28, 'BK15', 'DACA'),
(29, 'BK16', 'TONY'),
(30, 'BK17', 'ROSIE'),
(31, 'BK18', 'NHAN'),
(32, 'BK19', 'NHAN'),
(33, 'BK20', 'SHMA');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_ID` varchar(30) NOT NULL,
  `call_number` varchar(30) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  `title` varchar(100) NOT NULL,
  `category_ID` int(11) NOT NULL,
  `publish_ID` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_ID`, `call_number`, `isbn`, `title`, `category_ID`, `publish_ID`, `quantity`) VALUES
('BK01', 'NO-TO-260', '9786047764013', 'Nóng giận là bản năng , tĩnh lặng là bản lĩnh', 7, 'nxbtg', 30),
('BK02', 'SO-ME-358', '9786048894276', 'Sống thực tế giữa đời thực dụng', 3, 'nxbdt', 32),
('BK03', 'GI-PH-367', '8935212317368', 'Giông tố', 4, 'nxbvh', 13),
('BK04', 'BI-EL-253', '9786045657553', 'The Rules', 8, 'nxbpn', 10),
('BK05', 'DA-SU-320', '9786045674550', 'Đập tan sự thân mật giả mạo', 7, 'nxbpn', 10),
('BK06', 'OU-DI-615', '9786046475071', 'Outlander 1', 4, 'nxbdt', 3),
('BK07', 'OU-DI-620', '8935212331272', 'Outlander 2', 4, 'nxbdt', 4),
('BK08', 'SH-DO-695', '9786049637230', 'Sherlock Holmes 1', 1, 'nxbvh', 5),
('BK09', 'SH-DO-684', '8935095627899', 'Sherlock Holmes 2', 1, 'nxbvh', 6),
('BK10', 'SH-DO-700', '8935095622832', 'Sherlock Holmes 3', 1, 'nxbvh', 6),
('BK11', 'TU-TH-286', '9786049829789', 'Tuổi trẻ hoang dại ', 7, 'nxbvh', 20),
('BK12', 'DU-NI-198', '8936186544064', 'Đừng sợ mình sai , đừng tin mình đúng', 3, 'nxbpn', 36),
('BK13', 'TO-BU-135', '9786045556870', 'Tôi không thích ồn ào', 3, 'nxbnn', 23),
('BK14', 'NG-MA-292', '9786049768385', 'Nghệ thuật tinh tế của việc \"đếch\" quan tâm', 7, 'nxbvh', 21),
('BK15', 'HO-DA-313', '8935086823392', 'How to Win Friends & Influence People', 8, 'nxbtg', 10),
('BK16', 'TR-TO-301', '9786041076945', 'Trên đường băng', 3, 'nxbtn', 32),
('BK17', 'TU-RO-285', '9786045370193', 'Tuổi trẻ đáng giá bao nhiêu', 3, 'nxbnn', 25),
('BK18', 'CO-AN-251', '9786041081291', 'Chú chó nhỏ mang giỏ hoa hồng', 3, 'nxbtn', 12),
('BK19', 'TO-AN-251', '9786041140936', 'Tôi là Bê Tô', 3, 'nxbtn', 12),
('BK20', 'CM-MA-187', '9786048965747', '5 Centimet trên giây', 4, 'nxbvh', 30);

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

--
-- Dumping data for table `borrow_bill`
--

INSERT INTO `borrow_bill` (`borrow_ID`, `member_ID`, `employee_ID`, `description`, `status`, `borrow_date`, `term_date`, `return_date`, `deposit_fee`, `late_fee`) VALUES
('bor01', 'member1', 'emp01', 'hmm, nothing', 1, '2020-09-23', '2020-09-28', '2020-09-27', 10, 0),
('bor02', 'member4', 'emp01', 'test', 1, '2020-09-26', '2020-10-02', '2020-09-30', 6, 0),
('bor03', 'member2', 'emp01', 'hihi', 1, '2020-09-24', '2020-10-29', '2020-09-30', 14, 5),
('bor04', 'member3', 'emp01', 'haahaa', 0, '2020-09-29', '2020-10-07', '0000-00-00', 15, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bor_book`
--

CREATE TABLE `bor_book` (
  `No` int(11) NOT NULL,
  `book_ID` varchar(30) NOT NULL,
  `borrow_ID` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bor_book`
--

INSERT INTO `bor_book` (`No`, `book_ID`, `borrow_ID`, `status`) VALUES
(1, 'BK01', 'bor01', 0),
(2, 'BK05', 'bor01', 0),
(3, 'BK10', 'bor01', 0),
(4, 'BK07', 'bor01', 0),
(5, 'BK04', 'bor04', 0),
(6, 'BK14', 'bor04', 0),
(7, 'BK14', 'bor02', 0),
(8, 'BK04', 'bor02', 0),
(9, 'BK09', 'bor02', 0),
(10, 'BK10', 'bor02', 0),
(11, 'BK08', 'bor02', 0),
(12, 'BK19', 'bor03', 0),
(13, 'BK18', 'bor03', 0),
(14, 'BK04', 'bor03', 0),
(15, 'BK09', 'bor03', 0),
(16, 'BK11', 'bor03', 0);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_ID`, `name`) VALUES
(1, 'Thriller'),
(2, 'Autobiography'),
(3, 'Short story'),
(4, 'Novel'),
(5, 'Comic'),
(6, 'Horror'),
(7, 'Self-help'),
(8, 'Foreign language');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_ID` varchar(30) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `dob` date NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL,
  `photo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_ID`, `username`, `password`, `name`, `dob`, `gender`, `address`, `phone`, `email`, `photo`) VALUES
('emp01', 'employee1', 'emp01abc', 'Miss Monica', '1995-09-16', 0, '24 Phan Liem St , Dakao Ward , District 1  , HCMC', '0354751761', 'monica@gmail.com', '');

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

--
-- Dumping data for table `lib_card`
--

INSERT INTO `lib_card` (`card_number`, `start_date`, `expiration_date`, `description`) VALUES
('Std1241152', '2019-08-08', '2023-03-08', ''),
('Std1241243', '2019-09-01', '2023-04-01', ''),
('Std1241296', '2019-08-09', '2023-03-09', ''),
('Std1241312', '2019-09-12', '2023-04-12', '');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_ID` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `address` varchar(300) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `card_number` varchar(13) NOT NULL,
  `photo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_ID`, `name`, `dob`, `gender`, `address`, `phone`, `card_number`, `photo`) VALUES
('member1', 'Barry Allen', '2001-09-16', 1, '17 Nguyen Thi Minh Khai , Ben Nghe Ward , District 1 ,HCMC', '0321654852', 'Std1241152', ''),
('member2', 'Wong Beyonce', '2001-10-13', 0, '159 Dien Bien Phu , Dakao Ward , District 1 ,HCMC', '0654128963', 'Std1241296', ''),
('member3', 'Stephen Strange', '2001-09-13', 1, '212 Nguyen Dinh Chieu , Ward  6 , District 3 ,HCMC', '0564286943', 'Std1241243', ''),
('member4', 'Astrid Jamseson', '2001-07-25', 0, '159 Dien Bien Phu , Dakao Ward , District 1 ,HCMC', '0654128963', 'Std1241312', '');

-- --------------------------------------------------------

--
-- Table structure for table `publish_house`
--

CREATE TABLE `publish_house` (
  `publish_ID` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publish_house`
--

INSERT INTO `publish_house` (`publish_ID`, `name`, `address`, `phone`) VALUES
('nxbdt', 'Nhà xuất bản Dân Trí', '347 Doi Can, Ba Dinh District, Hanoi', '0987632541'),
('nxbkd', 'Nhà xuất bản Kim Đồng', '28 Cong Quynh , Pham Ngu Lao WWards , District 1 , HCMC', '0623546987'),
('nxbnn', 'Nhà xuất bản Nhã Nam', '10 Cong xa Paris , Ben Nghe Wards , District 1 , HCMC', '0912945598'),
('nxbpn', 'Nhà xuất bản Phụ Nữ', '16 Alexandre de Rhodes, Ben Nghe Wards , District 1, HCMC', '0965412378'),
('nxbtg', 'Nhà xuất bản Thế Giới', '7 Nguyen Thi Minh Khai, Ben Nghe, District 1, Ho Chi Minh City', '0356985621'),
('nxbtn', 'Nhà xuất bản Thanh Niên', '64 Ba Trieu, Tran Hung Dao, Hoan Kiem, Hanoi', '0654089365'),
('nxbvh', 'Nhà xuất bản Văn Học', '290/20 Nam Ky Khoi Nghia, Ward 14, District 3, Ho Chi Minh City', '0659863215');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_ID`);

--
-- Indexes for table `au_book`
--
ALTER TABLE `au_book`
  ADD PRIMARY KEY (`No`),
  ADD KEY `book_ID` (`book_ID`),
  ADD KEY `author_ID` (`author_ID`);

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
  ADD PRIMARY KEY (`No`),
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
  ADD UNIQUE KEY `card_number_2` (`card_number`),
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
-- AUTO_INCREMENT for table `au_book`
--
ALTER TABLE `au_book`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `bor_book`
--
ALTER TABLE `bor_book`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `au_book`
--
ALTER TABLE `au_book`
  ADD CONSTRAINT `au_book_ibfk_1` FOREIGN KEY (`book_ID`) REFERENCES `books` (`book_ID`),
  ADD CONSTRAINT `au_book_ibfk_2` FOREIGN KEY (`author_ID`) REFERENCES `author` (`author_ID`);

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`publish_ID`) REFERENCES `publish_house` (`publish_ID`),
  ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`category_ID`) REFERENCES `category` (`category_ID`);

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
