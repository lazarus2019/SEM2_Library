-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 20, 2020 lúc 06:16 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `author_ID` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nation` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `author`
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
-- Cấu trúc bảng cho bảng `au_book`
--

CREATE TABLE `au_book` (
  `No` int(11) NOT NULL,
  `book_ID` varchar(30) NOT NULL,
  `author_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `au_book`
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
-- Cấu trúc bảng cho bảng `books`
--

CREATE TABLE `books` (
  `book_ID` varchar(30) NOT NULL,
  `call_number` varchar(30) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  `title` varchar(100) NOT NULL,
  `category_ID` int(11) NOT NULL,
  `publish_ID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `isDelete` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `books`
--

INSERT INTO `books` (`book_ID`, `call_number`, `isbn`, `title`, `category_ID`, `publish_ID`, `quantity`, `price`, `isDelete`) VALUES
('BK01', 'NO-TO-260', '9786047764013', 'Nóng giận là bản năng , tĩnh lặng là bản lĩnh', 7, 5, 30, 3, 0),
('BK02', 'SO-ME-358', '9786048894276', 'Sống thực tế giữa đời thực dụng', 3, 5, 32, 4, 0),
('BK03', 'GI-PH-367', '8935212317368', 'Giông tố', 4, 3, 13, 5, 0),
('BK04', 'BI-EL-254', '9786045657553', 'The Rules', 8, 6, 10, 5, 0),
('BK05', 'DA-SU-320', '9786045674550', 'Đập tan sự thân mật giả mạo', 7, 2, 10, 4.5, 0),
('BK06', 'OU-DI-615', '9786046475071', 'Outlander 1', 4, 7, 3, 6, 0),
('BK07', 'OU-DI-620', '8935212331272', 'Outlander 2', 4, 7, 4, 6, 0),
('BK08', 'SH-DO-695', '9786049637230', 'Sherlock Holmes 1', 1, 5, 5, 15, 0),
('BK09', 'SH-DO-684', '8935095627899', 'Sherlock Holmes 2', 1, 5, 6, 15, 0),
('BK10', 'SH-DO-700', '8935095622832', 'Sherlock Holmes 3', 1, 5, 6, 15, 0),
('BK11', 'TU-TH-286', '9786049829789', 'Tuổi trẻ hoang dại ', 7, 6, 20, 3, 0),
('BK12', 'DU-NI-198', '8936186544064', 'Đừng sợ mình sai , đừng tin mình đúng', 3, 3, 36, 4, 0),
('BK13', 'TO-BU-135', '9786045556870', 'Tôi không thích ồn ào', 3, 4, 23, 4, 0),
('BK14', 'NG-MA-292', '9786049768385', 'Nghệ thuật tinh tế của việc \"đếch\" quan tâm', 7, 2, 21, 5, 0),
('BK15', 'HO-DA-313', '8935086823392', 'How to Win Friends & Influence People', 8, 1, 10, 5, 0),
('BK16', 'TR-TO-301', '9786041076945', 'Trên đường băng', 3, 7, 32, 3, 0),
('BK17', 'TU-RO-285', '9786045370193', 'Tuổi trẻ đáng giá bao nhiêu', 3, 7, 25, 4, 0),
('BK18', 'CO-AN-251', '9786041081291', 'Chú chó nhỏ mang giỏ hoa hồng', 3, 5, 12, 5, 0),
('BK19', 'TO-AN-251', '9786041140936', 'Tôi là Bê Tô', 3, 2, 12, 4, 0),
('BK20', 'CM-MA-187', '9786048965747', '5 Centimet trên giây', 4, 1, 30, 5, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `borrow_bill`
--

CREATE TABLE `borrow_bill` (
  `borrow_ID` int(11) NOT NULL,
  `member_ID` varchar(30) NOT NULL,
  `employee_ID` varchar(30) NOT NULL,
  `description` text DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `borrow_date` date DEFAULT NULL,
  `term_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `deposit_fee` double NOT NULL,
  `late_fee` double NOT NULL DEFAULT 0,
  `compen_fee` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `borrow_bill`
--

INSERT INTO `borrow_bill` (`borrow_ID`, `member_ID`, `employee_ID`, `description`, `status`, `borrow_date`, `term_date`, `return_date`, `deposit_fee`, `late_fee`, `compen_fee`) VALUES
(1, 'member1', 'emp02', 'hmm, nothing', 1, '2020-09-23', '2020-09-28', '2020-11-20', 10, 0, 3),
(2, 'member2', 'emp02', 'hihi', 1, '2020-09-24', '2020-10-29', '2020-12-17', 14, 5, 4),
(3, 'member3', 'emp02', 'haahaa', 1, '2020-09-29', '2020-10-07', '2020-10-18', 15, 22, 0),
(4, 'member1', 'emp02', 'hehe', 0, '2020-10-18', '2020-10-23', NULL, 6, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bor_book`
--

CREATE TABLE `bor_book` (
  `No` int(11) NOT NULL,
  `book_ID` varchar(30) NOT NULL,
  `borrow_ID` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 2,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bor_book`
--

INSERT INTO `bor_book` (`No`, `book_ID`, `borrow_ID`, `status`, `description`) VALUES
(1, 'BK01', 1, 1, NULL),
(2, 'BK05', 1, 3, ' '),
(3, 'BK10', 1, 2, NULL),
(4, 'BK07', 1, 1, NULL),
(46, 'BK04', 2, 1, NULL),
(47, 'BK08', 2, 3, NULL),
(48, 'BK09', 2, 1, NULL),
(49, 'BK11', 2, 1, NULL),
(50, 'BK01', 2, 1, NULL),
(51, 'BK05', 3, 1, NULL),
(52, 'BK03', 3, 1, NULL),
(53, 'BK08', 4, 2, NULL),
(54, 'BK11', 4, 2, NULL),
(55, 'BK05', 4, 2, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `category_ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
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
-- Cấu trúc bảng cho bảng `employee`
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
  `photo` text NOT NULL,
  `level` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`employee_ID`, `username`, `password`, `name`, `dob`, `gender`, `address`, `phone`, `email`, `photo`, `level`) VALUES
('emp01', 'admin', '$2a$10$kE9fQIuolwI3xNalfZrQKOChB1I80Sd/bfZUQjojxnSai3A8hlM1u', 'Boss', '1998-10-03', 1, 'HCMC', '0912945598', 'thaisonbk2020@gmail.com', '', 'admin'),
('emp02', 'employee1', '$2a$10$kE9fQIuolwI3xNalfZrQKOChB1I80Sd/bfZUQjojxnSai3A8hlM1u', 'Miss Monica', '2000-09-16', 0, 'HCMC', '0354751761', 'monica@gmail.com', '', 'librarian');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lib_card`
--

CREATE TABLE `lib_card` (
  `card_number` varchar(13) NOT NULL,
  `start_date` date NOT NULL,
  `expiration_date` date NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lib_card`
--

INSERT INTO `lib_card` (`card_number`, `start_date`, `expiration_date`, `description`) VALUES
('Std1241152', '2020-08-08', '2023-03-08', ''),
('Std1241243', '2020-09-01', '2023-04-01', ''),
('Std1241296', '2020-08-09', '2023-03-09', ''),
('Std1241312', '2020-09-12', '2023-04-12', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member`
--

CREATE TABLE `member` (
  `member_ID` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `address` varchar(300) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `card_number` varchar(13) NOT NULL,
  `photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `member`
--

INSERT INTO `member` (`member_ID`, `name`, `dob`, `gender`, `address`, `phone`, `card_number`, `photo`) VALUES
('member1', 'Barry Allen', '2001-09-16', 1, '17 Nguyen Thi Minh Khai , Ben Nghe Ward , District 1 ,HCMC', '0321654852', 'Std1241152', ''),
('member2', 'Wong Beyonce', '2001-10-13', 0, '159 Dien Bien Phu , Dakao Ward , District 1 ,HCMC', '0654128963', 'Std1241296', ''),
('member3', 'Stephen Strange', '2001-09-13', 1, '212 Nguyen Dinh Chieu , Ward  6 , District 3 ,HCMC', '0564286943', 'Std1241243', ''),
('member4', 'Astrid Jamseson', '2001-07-25', 0, '159 Dien Bien Phu , Dakao Ward , District 1 ,HCMC', '0654128963', 'Std1241312', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publish_house`
--

CREATE TABLE `publish_house` (
  `publish_ID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `publish_house`
--

INSERT INTO `publish_house` (`publish_ID`, `name`, `address`, `phone`) VALUES
(1, 'Nhà xuất bản Dân Trí', '347 Doi Can, Ba Dinh District, Hanoi', '0987632541'),
(2, 'Nhà xuất bản Kim Đồng', '28 Cong Quynh , Pham Ngu Lao WWards , District 1 , HCMC', '0623546987'),
(3, 'Nhà xuất bản Nhã Nam', '10 Cong xa Paris , Ben Nghe Wards , District 1 , HCMC', '0912945598'),
(4, 'Nhà xuất bản Phụ Nữ', '16 Alexandre de Rhodes, Ben Nghe Wards , District 1, HCMC', '0965412378'),
(5, 'Nhà xuất bản Thế Giới', '7 Nguyen Thi Minh Khai, Ben Nghe, District 1, Ho Chi Minh City', '0356985621'),
(6, 'Nhà xuất bản Thanh Niên', '64 Ba Trieu, Tran Hung Dao, Hoan Kiem, Hanoi', '0654089365'),
(7, 'Nhà xuất bản Văn Học', '290/20 Nam Ky Khoi Nghia, Ward 14, District 3, Ho Chi Minh City', '0659863215');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `ID` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`ID`, `status`) VALUES
(1, 'Returned'),
(2, 'Not Return'),
(3, 'Lost ');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_ID`);

--
-- Chỉ mục cho bảng `au_book`
--
ALTER TABLE `au_book`
  ADD PRIMARY KEY (`No`),
  ADD KEY `book_ID` (`book_ID`),
  ADD KEY `author_ID` (`author_ID`);

--
-- Chỉ mục cho bảng `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_ID`),
  ADD KEY `category_ID` (`category_ID`),
  ADD KEY `publish_ID` (`publish_ID`);

--
-- Chỉ mục cho bảng `borrow_bill`
--
ALTER TABLE `borrow_bill`
  ADD PRIMARY KEY (`borrow_ID`),
  ADD KEY `member_ID` (`member_ID`),
  ADD KEY `employee_ID` (`employee_ID`);

--
-- Chỉ mục cho bảng `bor_book`
--
ALTER TABLE `bor_book`
  ADD PRIMARY KEY (`No`),
  ADD KEY `book_ID` (`book_ID`),
  ADD KEY `status` (`status`),
  ADD KEY `borrow_ID` (`borrow_ID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_ID`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_ID`);

--
-- Chỉ mục cho bảng `lib_card`
--
ALTER TABLE `lib_card`
  ADD PRIMARY KEY (`card_number`);

--
-- Chỉ mục cho bảng `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_ID`),
  ADD UNIQUE KEY `card_number_2` (`card_number`),
  ADD KEY `card_number` (`card_number`);

--
-- Chỉ mục cho bảng `publish_house`
--
ALTER TABLE `publish_house`
  ADD PRIMARY KEY (`publish_ID`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `au_book`
--
ALTER TABLE `au_book`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `borrow_bill`
--
ALTER TABLE `borrow_bill`
  MODIFY `borrow_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `bor_book`
--
ALTER TABLE `bor_book`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `category_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `publish_house`
--
ALTER TABLE `publish_house`
  MODIFY `publish_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `au_book`
--
ALTER TABLE `au_book`
  ADD CONSTRAINT `au_book_ibfk_1` FOREIGN KEY (`author_ID`) REFERENCES `author` (`author_ID`),
  ADD CONSTRAINT `au_book_ibfk_2` FOREIGN KEY (`book_ID`) REFERENCES `books` (`book_ID`);

--
-- Các ràng buộc cho bảng `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`category_ID`) REFERENCES `category` (`category_ID`),
  ADD CONSTRAINT `books_ibfk_3` FOREIGN KEY (`publish_ID`) REFERENCES `publish_house` (`publish_ID`);

--
-- Các ràng buộc cho bảng `borrow_bill`
--
ALTER TABLE `borrow_bill`
  ADD CONSTRAINT `borrow_bill_ibfk_1` FOREIGN KEY (`member_ID`) REFERENCES `member` (`member_ID`),
  ADD CONSTRAINT `borrow_bill_ibfk_2` FOREIGN KEY (`employee_ID`) REFERENCES `employee` (`employee_ID`);

--
-- Các ràng buộc cho bảng `bor_book`
--
ALTER TABLE `bor_book`
  ADD CONSTRAINT `bor_book_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status` (`ID`),
  ADD CONSTRAINT `bor_book_ibfk_3` FOREIGN KEY (`borrow_ID`) REFERENCES `borrow_bill` (`borrow_ID`),
  ADD CONSTRAINT `bor_book_ibfk_4` FOREIGN KEY (`book_ID`) REFERENCES `books` (`book_ID`);

--
-- Các ràng buộc cho bảng `lib_card`
--
ALTER TABLE `lib_card`
  ADD CONSTRAINT `lib_card_ibfk_1` FOREIGN KEY (`card_number`) REFERENCES `member` (`card_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
