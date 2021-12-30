-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: nienluannganh
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bantin`
--

DROP TABLE IF EXISTS `bantin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bantin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TieuDe` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TomTat` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NoiDung` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `PathFile` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `NgayDang` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bantin`
--

LOCK TABLES `bantin` WRITE;
/*!40000 ALTER TABLE `bantin` DISABLE KEYS */;
/*!40000 ALTER TABLE `bantin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bomon`
--

DROP TABLE IF EXISTS `bomon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bomon` (
  `MaBoMon` int NOT NULL AUTO_INCREMENT,
  `TenBoMon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaBoMon`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bomon`
--

LOCK TABLES `bomon` WRITE;
/*!40000 ALTER TABLE `bomon` DISABLE KEYS */;
INSERT INTO `bomon` VALUES (1,'Bộ Môn Khoa Học Máy Tính'),(2,'Bộ Môn Công Nghệ Thông Tin');
/*!40000 ALTER TABLE `bomon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem` (
  `MaSoSV` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNamHoc` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaHocKy` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaHocPhan` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `diem` float DEFAULT NULL,
  PRIMARY KEY (`MaSoSV`,`MaNamHoc`,`MaHocPhan`,`MaHocKy`),
  KEY `FK_Diem_NamHoc` (`MaNamHoc`),
  KEY `FK_Diem_MaHocPhan` (`MaHocPhan`),
  KEY `FK_Diem_MaHocKy` (`MaHocKy`),
  CONSTRAINT `FK_Diem_MaHocKy` FOREIGN KEY (`MaHocKy`) REFERENCES `hocky` (`MaHocKy`),
  CONSTRAINT `FK_Diem_MaHocPhan` FOREIGN KEY (`MaHocPhan`) REFERENCES `hocphan` (`MaHocPhan`),
  CONSTRAINT `FK_Diem_MaSoSV` FOREIGN KEY (`MaSoSV`) REFERENCES `sinhvien` (`MaSoSV`),
  CONSTRAINT `FK_Diem_NamHoc` FOREIGN KEY (`MaNamHoc`) REFERENCES `namhoc` (`MaNamHoc`),
  CONSTRAINT `CK_diem` CHECK (((`diem` >= 0) and (`diem` <= 10)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donvithuctap`
--

DROP TABLE IF EXISTS `donvithuctap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donvithuctap` (
  `MaSoDVTT` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenDV` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TinhThanhPho` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoaiDV` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EmailDV` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `HoTenNHD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoaiNHD` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EmailNHD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MoiTruong` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NoiDungCV` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `ThoiGianTT` int DEFAULT NULL,
  `BatDauThucTap` date DEFAULT NULL,
  `HoTro` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `GhiChu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MaSoDVTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donvithuctap`
--

LOCK TABLES `donvithuctap` WRITE;
/*!40000 ALTER TABLE `donvithuctap` DISABLE KEYS */;
/*!40000 ALTER TABLE `donvithuctap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvien` (
  `MaSoGV` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` tinyint DEFAULT '0',
  `ChucVu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ChuyenMon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NoiSinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoDienThoai` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaBoMon` int DEFAULT NULL,
  PRIMARY KEY (`MaSoGV`),
  KEY `FK_GiangVien_BoMon` (`MaBoMon`),
  CONSTRAINT `FK_GiangVien_BoMon` FOREIGN KEY (`MaBoMon`) REFERENCES `bomon` (`MaBoMon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES ('GVCNTT1','Giảng Viên CNTT','gvcntt@ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',1,'Giảng Viên Chính','Tiến Sỹ','Cần Thơ','1985-01-01','123456789',2),('GVKHMT1','Trần Nguyễn Minh Thư','tnmthu@ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',0,'Giảng Viên Chính','Tiến Sỹ','Cần Thơ','1985-01-01','123456789',1),('GVKHMT2','Lưu Tiến Đạo','ltdao@ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',1,'Giảng Viên','Tiến Sỹ','Cần Thơ','1985-01-02','987654321',1),('GVKHMT3','admin','admin@ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',0,'Quản Trị','Tiến Sỹ','Cần Thơ','1985-01-05','987654399',1);
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocky`
--

DROP TABLE IF EXISTS `hocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocky` (
  `MaHocKy` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenHocKy` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaHocKy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocky`
--

LOCK TABLES `hocky` WRITE;
/*!40000 ALTER TABLE `hocky` DISABLE KEYS */;
INSERT INTO `hocky` VALUES ('HK1','Học Kỳ I'),('HK2','Học Kỳ II'),('HK3','Học Kỳ Hè');
/*!40000 ALTER TABLE `hocky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocphan`
--

DROP TABLE IF EXISTS `hocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocphan` (
  `MaHocPhan` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenHocPhan` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaHocPhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocphan`
--

LOCK TABLES `hocphan` WRITE;
/*!40000 ALTER TABLE `hocphan` DISABLE KEYS */;
INSERT INTO `hocphan` VALUES ('CT450','Thực Tập Thực Tế - CNTT'),('CT455','Thực Tập Thực Tế - KHMT');
/*!40000 ALTER TABLE `hocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoahoc`
--

DROP TABLE IF EXISTS `khoahoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoahoc` (
  `MaKhoaHoc` int NOT NULL,
  `TenKhoaHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaKhoaHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoahoc`
--

LOCK TABLES `khoahoc` WRITE;
/*!40000 ALTER TABLE `khoahoc` DISABLE KEYS */;
INSERT INTO `khoahoc` VALUES (1,'K44 (2018)');
/*!40000 ALTER TABLE `khoahoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lopchuyennganh`
--

DROP TABLE IF EXISTS `lopchuyennganh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lopchuyennganh` (
  `MaLopCN` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNganh` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaLopCN`),
  KEY `FK_LopChuyenNganh_Nganh` (`MaNganh`),
  CONSTRAINT `FK_LopChuyenNganh_Nganh` FOREIGN KEY (`MaNganh`) REFERENCES `nganh` (`MaNganh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lopchuyennganh`
--

LOCK TABLES `lopchuyennganh` WRITE;
/*!40000 ALTER TABLE `lopchuyennganh` DISABLE KEYS */;
INSERT INTO `lopchuyennganh` VALUES ('18V7A','V7'),('18Z6A','Z6');
/*!40000 ALTER TABLE `lopchuyennganh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophocphan`
--

DROP TABLE IF EXISTS `lophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophocphan` (
  `MaLopHP` char(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenLop` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SiSo` int DEFAULT NULL,
  `SiSoConLai` int DEFAULT NULL,
  `MaHocPhan` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaNamHoc` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaHocKy` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaLopHP`),
  KEY `FK_LopHocPhan_HocPhan` (`MaHocPhan`),
  KEY `FK_LopHocPhan_HocKy` (`MaHocKy`),
  KEY `FK_LopHocPhan_NamHoc` (`MaNamHoc`),
  CONSTRAINT `FK_LopHocPhan_HocKy` FOREIGN KEY (`MaHocKy`) REFERENCES `hocky` (`MaHocKy`),
  CONSTRAINT `FK_LopHocPhan_HocPhan` FOREIGN KEY (`MaHocPhan`) REFERENCES `hocphan` (`MaHocPhan`),
  CONSTRAINT `FK_LopHocPhan_NamHoc` FOREIGN KEY (`MaNamHoc`) REFERENCES `namhoc` (`MaNamHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophocphan`
--

LOCK TABLES `lophocphan` WRITE;
/*!40000 ALTER TABLE `lophocphan` DISABLE KEYS */;
INSERT INTO `lophocphan` VALUES ('TT22CNTT','Thực Tập Thực Tế - CNTT',5,5,'CT450','2022','HK3'),('TT22KHMT','Thực Tập Thực Tế - KHMT',11,11,'CT455','2022','HK3');
/*!40000 ALTER TABLE `lophocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `namhoc` (
  `MaNamHoc` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NienKhoa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaNamHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `namhoc`
--

LOCK TABLES `namhoc` WRITE;
/*!40000 ALTER TABLE `namhoc` DISABLE KEYS */;
INSERT INTO `namhoc` VALUES ('2022','2021 - 2022');
/*!40000 ALTER TABLE `namhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganh`
--

DROP TABLE IF EXISTS `nganh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganh` (
  `MaNganh` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenNganh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaBoMon` int DEFAULT NULL,
  PRIMARY KEY (`MaNganh`),
  KEY `FK_Nganh_BoMon` (`MaBoMon`),
  CONSTRAINT `FK_Nganh_BoMon` FOREIGN KEY (`MaBoMon`) REFERENCES `bomon` (`MaBoMon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganh`
--

LOCK TABLES `nganh` WRITE;
/*!40000 ALTER TABLE `nganh` DISABLE KEYS */;
INSERT INTO `nganh` VALUES ('V7','Công Nghệ Thông Tin',2),('Z6','Khoa Học Máy Tính',1);
/*!40000 ALTER TABLE `nganh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `MaSoSV` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` tinyint DEFAULT '0',
  `ChucVu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NoiSinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoDienThoai` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaLopCN` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaKhoaHoc` int DEFAULT NULL,
  PRIMARY KEY (`MaSoSV`),
  UNIQUE KEY `U_SinhVien_Email` (`Email`),
  KEY `FK_SinhVien_LopChuyenNganh` (`MaLopCN`),
  KEY `FK_SinhVien_KhoaHoc` (`MaKhoaHoc`),
  CONSTRAINT `FK_SinhVien_KhoaHoc` FOREIGN KEY (`MaKhoaHoc`) REFERENCES `khoahoc` (`MaKhoaHoc`),
  CONSTRAINT `FK_SinhVien_LopChuyenNganh` FOREIGN KEY (`MaLopCN`) REFERENCES `lopchuyennganh` (`MaLopCN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES ('B0001','Nguyễn Test 1','test1@student.ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',1,'Sinh Viên','An Giang','2000-01-01','123456789','18V7A',1),('B0002','Nguyễn Test 2','test2@student.ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',0,'Sinh Viên','Cần Thơ','2000-02-02','123456789','18Z6A',1),('B0003','Nguyễn Test 3','test3@student.ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',1,'Sinh Viên','Cà Mau','2000-03-03','123456789','18V7A',1),('B0004','Nguyễn Test 4','test4@student.ctu.edu.vn','$2a$10$R788r4vk2Z4Dk78q2/JVO.zCUh7gfT5hQpzSvenGdSr.gdxp4PglO',0,'Sinh Viên','Sóc Trăng','2000-04-04','123456789','18Z6A',1);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtinthuctap`
--

DROP TABLE IF EXISTS `thongtinthuctap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongtinthuctap` (
  `MaSoSV` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaLopHP` char(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaSoDVTT` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaSoGV` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaBoMon` int DEFAULT NULL,
  `CongViec` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GhiChu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `XetDuyet` tinyint DEFAULT '2',
  PRIMARY KEY (`MaSoSV`,`MaLopHP`),
  UNIQUE KEY `U_ThongTinThucTap_MaSoSV` (`MaSoSV`),
  KEY `FK_ThongTinThucTap_BoMon` (`MaBoMon`),
  KEY `FK_ThongTinThucTap_DonViThucTap` (`MaSoDVTT`),
  KEY `FK_ThongTinThucTap_GiangVien` (`MaSoGV`),
  KEY `FK_ThongTinThucTap_LopHocPhan` (`MaLopHP`),
  CONSTRAINT `FK_ThongTinThucTap_BoMon` FOREIGN KEY (`MaBoMon`) REFERENCES `bomon` (`MaBoMon`),
  CONSTRAINT `FK_ThongTinThucTap_DonViThucTap` FOREIGN KEY (`MaSoDVTT`) REFERENCES `donvithuctap` (`MaSoDVTT`),
  CONSTRAINT `FK_ThongTinThucTap_GiangVien` FOREIGN KEY (`MaSoGV`) REFERENCES `giangvien` (`MaSoGV`),
  CONSTRAINT `FK_ThongTinThucTap_LopHocPhan` FOREIGN KEY (`MaLopHP`) REFERENCES `lophocphan` (`MaLopHP`),
  CONSTRAINT `FK_ThongTinThucTap_SinhVien` FOREIGN KEY (`MaSoSV`) REFERENCES `sinhvien` (`MaSoSV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtinthuctap`
--

LOCK TABLES `thongtinthuctap` WRITE;
/*!40000 ALTER TABLE `thongtinthuctap` DISABLE KEYS */;
INSERT INTO `thongtinthuctap` VALUES ('B0001','TT22CNTT',NULL,NULL,NULL,NULL,NULL,2),('B0002','TT22KHMT',NULL,NULL,NULL,NULL,NULL,2),('B0003','TT22CNTT',NULL,NULL,NULL,NULL,NULL,2),('B0004','TT22KHMT',NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `thongtinthuctap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuyendung`
--

DROP TABLE IF EXISTS `tuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuyendung` (
  `MaSoTD` int NOT NULL,
  `TenDV` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TinhThanhPho` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoaiDV` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EmailDV` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChiWeb` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `HoTenNHD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoaiNHD` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EmailNHD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MoiTruong` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NoiDungCV` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `ThoiGianTT` int DEFAULT NULL,
  `SoLuongNhanSV` int DEFAULT NULL,
  `YeuCau` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `QuyenLoi` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `DauThoiGian` date DEFAULT NULL,
  `TrangThai` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `check_state` tinyint DEFAULT '0',
  `GhiChu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MaSoTD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuyendung`
--

LOCK TABLES `tuyendung` WRITE;
/*!40000 ALTER TABLE `tuyendung` DISABLE KEYS */;
/*!40000 ALTER TABLE `tuyendung` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21 14:22:12
