-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2016 at 09:54 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `smzx`
--

-- --------------------------------------------------------

--
-- Table structure for table `cardlevel`
--

CREATE TABLE IF NOT EXISTS `cardlevel` (
  `type` varchar(64) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `minCharge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cardlevel`
--

INSERT INTO `cardlevel` (`type`, `discount`, `minCharge`) VALUES
('金卡会员', 8.00, 500),
('银卡会员', 9.00, 400);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `cardNumber` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `gender` varchar(64) NOT NULL,
  `phoneNumber` varchar(64) NOT NULL,
  `type` varchar(64) NOT NULL,
  `balance` decimal(11,0) NOT NULL,
  PRIMARY KEY (`cardNumber`),
  UNIQUE KEY `cardNumber` (`cardNumber`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`cardNumber`, `name`, `gender`, `phoneNumber`, `type`, `balance`) VALUES
(1, '吕博文', 'M', '18792862883', '金卡会员', '6195'),
(3, '王子腾', 'M', '11111111111', '金卡会员', '184'),
(4, '吕博文', 'M', '99999999999', '金卡会员', '10391'),
(5, '吕小婷', 'F', '13309200089', '银卡会员', '99'),
(6, '13241吕', 'F', '44444444444', '银卡会员', '34'),
(7, 'x', 'M', '44555555555', '银卡会员', '444'),
(8, '金卡会员', 'M', '66665555555', '银卡会员', '44444'),
(9, '测试测', 'M', '62222222222', '银卡会员', '33'),
(10, '嘎嘎嘎', 'M', '78777777777', '银卡会员', '3'),
(11, ' 发生的', 'M', '09382384437', '银卡会员', '2481'),
(12, '凤啊', 'M', '43124461283', '银卡会员', '341'),
(13, '发', 'M', '43252345356', '银卡会员', '1234'),
(14, '杜', 'M', '12121212121', '金卡会员', '472'),
(15, '吕博文', 'M', '83838383838', '银卡会员', '288');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `staffId` int(11) NOT NULL,
  `staffId2` int(11) NOT NULL,
  `cardNumber` int(11) NOT NULL,
  `serviceId` int(11) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `dateTime`, `staffId`, `staffId2`, `cardNumber`, `serviceId`, `amount`, `type`) VALUES
(1, '2015-12-18 20:54:25', 1, 0, 0, 1, '20', '现金'),
(2, '2015-12-18 20:54:41', 1, 0, 0, 8, '300', '微信'),
(3, '2015-12-18 20:55:06', 1, 0, 0, 2, '35', 'POS'),
(4, '2015-12-19 14:13:31', 1, 0, 0, 5, '200', '现金'),
(5, '2015-12-19 16:17:50', 1, 0, 1, 8, '270', '会员卡'),
(6, '2015-12-19 16:23:31', 1, 0, 1, 2, '32', '会员卡'),
(7, '2015-12-19 16:26:16', 1, 0, 3, 4, '120', '会员卡'),
(8, '2015-12-19 16:28:30', 1, 0, 3, 6, '240', '会员卡'),
(9, '2015-12-19 16:30:46', 1, 0, 1, 2, '32', '会员卡'),
(10, '2015-12-19 16:32:11', 1, 0, 1, 5, '180', '会员卡'),
(11, '2015-12-19 16:35:14', 1, 0, 1, 5, '180', '会员卡'),
(12, '2015-12-19 16:36:55', 1, 0, 1, 6, '270', '会员卡'),
(13, '2015-12-19 16:39:04', 1, 0, 1, 6, '270', '会员卡'),
(14, '2015-12-19 16:41:02', 1, 0, 4, 8, '240', '会员卡'),
(15, '2015-12-19 16:43:32', 1, 0, 3, 8, '240', '会员卡'),
(16, '2015-12-19 16:48:15', 1, 0, 4, 8, '240', '会员卡'),
(17, '2015-12-19 17:13:29', 1, 0, 1, 5, '180', '会员卡'),
(18, '2015-12-19 17:15:05', 1, 0, 1, 5, '180', '微信'),
(19, '2015-12-19 17:27:21', 2, 0, 0, 2, '35', '现金'),
(20, '2015-12-20 21:26:38', 1, 0, 1, 2, '32', '会员卡'),
(21, '2015-12-21 10:45:15', 2, 1, 0, 9, '300', '现金'),
(22, '2015-12-21 12:03:34', 2, 0, 0, 2, '30', '现金'),
(23, '2015-12-21 12:10:34', 2, 0, 14, 2, '28', '会员卡'),
(24, '2015-12-21 12:10:36', 2, 0, 14, 2, '28', '会员卡'),
(25, '2015-12-21 12:18:44', 2, 1, 11, 6, '760', '会员卡'),
(26, '2015-12-21 12:19:38', 1, 0, 0, 2, '35', '现金'),
(27, '2015-12-21 12:20:07', 1, 0, 1, 1, '8', '会员卡'),
(28, '2015-12-22 10:52:57', 1, 0, 0, 8, '300', '现金'),
(29, '2015-12-22 10:53:37', 1, 0, 4, 1, '16', '会员卡'),
(30, '2015-12-31 10:49:46', 1, 0, 0, 4, '150', '现金'),
(31, '2015-12-31 15:29:47', 1, 0, 3, 1, '20', '会员卡'),
(32, '2015-12-31 15:32:11', 1, 0, 0, 1, '20', '现金'),
(33, '2015-12-31 15:32:24', 1, 0, 3, 9, '240', '会员卡');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `moneytaken` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `cost`, `moneytaken`) VALUES
(1, '产品', '100', '20'),
(2, '产品新', '100', '20');

-- --------------------------------------------------------

--
-- Table structure for table `productorder`
--

CREATE TABLE IF NOT EXISTS `productorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `staffId` int(11) NOT NULL,
  `cardNumber` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `productorder`
--

INSERT INTO `productorder` (`id`, `dateTime`, `staffId`, `cardNumber`, `productId`, `cost`, `type`) VALUES
(30, '2015-12-31 22:13:06', 1, 0, 1, '100', '现金'),
(31, '2015-12-31 22:21:48', 1, 3, 1, '100', '会员卡'),
(32, '2016-01-01 10:47:16', 1, 1, 1, '8', '会员卡'),
(33, '2016-01-01 14:07:43', 1, 3, 2, '100', '会员卡'),
(34, '2016-01-01 14:07:55', 2, 3, 2, '100', '会员卡'),
(35, '2016-01-01 17:26:58', 3, 0, 1, '100', '现金'),
(36, '2016-01-02 22:23:45', 2, 0, 1, '100', '现金'),
(37, '2016-01-02 22:27:47', 1, 0, 2, '100', '现金'),
(38, '2016-01-03 14:48:01', 1, 0, 1, '100', '现金');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(64) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`id`, `detail`, `price`, `type`) VALUES
(1, '洗发', 20, '大活'),
(2, '剪发', 35, '小活'),
(3, '学生剪发', 30, '小活'),
(4, '烫发', 150, '大活'),
(5, '水果烫', 200, '大活'),
(6, '离子烫', 300, '大活'),
(7, '普通染发', 200, '大活'),
(8, '高级染发', 300, '大活'),
(9, '这是一个特别特别长的名字', 300, '大活');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `gender` varchar(64) NOT NULL,
  `phoneNumber` varchar(64) NOT NULL,
  `status` varchar(64) NOT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `name`, `gender`, `phoneNumber`, `status`, `salary`) VALUES
(1, '曹冰洋', 'M', '15155555555', '发型师', 2000),
(2, '徐哥', 'M', '15112221212', '发型师', 5000),
(3, '齐老师', 'M', '33333333333', '发型师', 222),
(4, '测试人', 'M', '11222222222', '发型师', 222);

-- --------------------------------------------------------

--
-- Table structure for table `topup`
--

CREATE TABLE IF NOT EXISTS `topup` (
  `dateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cardNumber` int(11) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `type` varchar(64) NOT NULL,
  `staffId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `topup`
--

INSERT INTO `topup` (`dateTime`, `cardNumber`, `amount`, `type`, `staffId`) VALUES
('2015-12-18 22:06:17', 1, '2000', '现金', 1),
('2015-12-18 22:06:32', 1, '3000', '现金', 1),
('2015-12-18 22:11:12', 3, '1111', '现金', 1),
('2015-12-19 13:31:13', 4, '9999', '现金', 1),
('2015-12-20 21:29:47', 5, '99', '微信', 2),
('2015-12-20 21:43:12', 4, '888', 'POS', 1),
('2015-12-21 10:32:00', 6, '34', '现金', 2),
('2015-12-21 10:32:11', 7, '444', '现金', 1),
('2015-12-21 10:32:36', 8, '44444', '现金', 2),
('2015-12-21 10:33:24', 9, '33', '现金', 2),
('2015-12-21 10:33:35', 10, '3', '现金', 2),
('2015-12-21 10:33:53', 11, '3241', '现金', 2),
('2015-12-21 10:34:08', 12, '341', '现金', 1),
('2015-12-21 10:34:31', 13, '1234', '现金', 1),
('2015-12-21 12:07:39', 14, '500', 'POS', 1),
('2015-12-21 12:12:30', 14, '28', '现金', 2),
('2015-12-22 10:50:53', 15, '288', '现金', 2),
('2015-12-22 15:51:21', 1, '2000', '现金', 3),
('2015-12-31 15:02:09', 1, '123', '现金', 1),
('2015-12-31 15:03:27', 1, '333', '现金', 1),
('2015-12-31 15:04:25', 1, '3334', '现金', 1),
('2015-12-31 15:04:45', 1, '44', '现金', 1),
('2015-12-31 15:32:37', 3, '333', '现金', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
