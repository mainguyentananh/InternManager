create database nienluannganh;
use nienluannganh;
drop database nienluannganh;

create table bomon(
	MaBoMon int primary key auto_increment,
	TenBoMon varchar(255)
);

create table nganh(
	MaNganh char(10) primary key,
	TenNganh varchar(255),
    MaBoMon int,
    constraint FK_Nganh_BoMon
		FOREIGN KEY (MaBoMon) REFERENCES bomon(MaBoMon)
);

create table lopchuyennganh(
	MaLopCN char(10) primary key,
    MaNganh char(10),
    constraint FK_LopChuyenNganh_Nganh
		FOREIGN KEY (MaNganh) REFERENCES nganh(MaNganh)
);

create table giangvien(
	MaSoGV char(10) primary key,
    HoTen varchar(100),
    Email varchar(255),
    MatKhau varchar(255),
    GioiTinh tinyint default 0,
    ChucVu varchar(255),
    ChuyenMon varchar(255),
    NoiSinh varchar(255),
    NgaySinh date,
    SoDienThoai char(11),
    MaBoMon int,
    constraint FK_GiangVien_BoMon
		FOREIGN KEY (MaBoMon) REFERENCES bomon(MaBoMon)
);

create table khoahoc(
	MaKhoaHoc int primary key,
    TenKhoaHoc varchar(255)
);


create table sinhvien(
	MaSoSV char(10) primary key,
    HoTen varchar(100),
    Email varchar(255),
    MatKhau varchar(255),
    GioiTinh tinyint default 0,
    ChucVu varchar(255),
    NoiSinh varchar(255),
    NgaySinh date,
    SoDienThoai char(11),
    MaLopCN char(10),
    MaKhoaHoc int,
    constraint FK_SinhVien_LopChuyenNganh
		FOREIGN KEY (MaLopCN) REFERENCES lopchuyennganh(MaLopCN),
	constraint FK_SinhVien_KhoaHoc
		FOREIGN KEY (MaKhoaHoc) REFERENCES khoahoc(MaKhoaHoc),
	constraint U_SinhVien_Email unique(Email)
);


create table namhoc(
	MaNamHoc char(10) primary key,
	NienKhoa varchar(255)
);

create table hocky(
	MaHocKy char(10) primary key,
	TenHocKy varchar(255)
);

create table hocphan(
	MaHocPhan char(10) primary key,
	TenHocPhan varchar(255)
);

create table diem(
	MaSoSV char(10),
	MaNamHoc char(10),
    MaHocKy char(10),
    MaHocPhan char(10),
    GhiChu varchar(255) null, 
    diem float,
	constraint FK_Diem_NamHoc
		FOREIGN KEY (MaNamHoc) REFERENCES namhoc(MaNamHoc),
	constraint FK_Diem_MaHocPhan
		FOREIGN KEY (MaHocPhan) REFERENCES hocphan(MaHocPhan),
	constraint FK_Diem_MaSoSV
		FOREIGN KEY (MaSoSV) REFERENCES sinhvien(MaSoSV),
	constraint FK_Diem_MaHocKy
		FOREIGN KEY (MaHocKy) REFERENCES hocky(MaHocKy),
	constraint PK_Diem primary key(MaSoSV,MaNamHoc,MaHocPhan,MaHocKy),
    constraint CK_diem check (diem >=0  and diem <= 10)
);

create table lophocphan(
	MaLopHP char(255) primary key,
	TenLop varchar(255),
    SiSo int,
    SiSoConLai int,
	MaHocPhan char(10),
    MaNamHoc char(10),
    MaHocKy char(10),
	constraint FK_LopHocPhan_HocPhan
		FOREIGN KEY (MaHocPhan) REFERENCES hocphan(MaHocPhan),
	constraint FK_LopHocPhan_HocKy
		FOREIGN KEY (MaHocKy) REFERENCES hocky(MaHocKy),
	constraint FK_LopHocPhan_NamHoc
		FOREIGN KEY (MaNamHoc) REFERENCES namhoc(MaNamHoc)
);

create table donvithuctap(
	MaSoDVTT char(20) primary key,
	TenDV varchar(255),
	DiaChi varchar(255),
	TinhThanhPho varchar(255),
	SoDienThoaiDV varchar(50),
	EmailDV varchar(255),
	HoTenNHD varchar(255),
	SoDienThoaiNHD varchar(50), 
	EmailNHD varchar(255),
	MoiTruong varchar(255), 
	NoiDungCV text,
	ThoiGianTT int,
    BatDauThucTap date null,
    HoTro text null,
	GhiChu text null
);


create table thongtinthuctap(
	MaSoSV char(10),
	MaLopHP char(255),
    MaSoDVTT char(20) null,
	MaSoGV char(10) null,
    MaBoMon int null,
    CongViec varchar(45) null,
    GhiChu varchar(255) null,
    XetDuyet tinyint default 2,
    constraint FK_ThongTinThucTap_BoMon
		FOREIGN KEY (MaBoMon) REFERENCES bomon(MaBoMon),
	constraint FK_ThongTinThucTap_DonViThucTap
		FOREIGN KEY (MaSoDVTT) REFERENCES donvithuctap(MaSoDVTT),
	constraint FK_ThongTinThucTap_GiangVien
		FOREIGN KEY (MaSoGV) REFERENCES giangvien(MaSoGV),
	constraint FK_ThongTinThucTap_LopHocPhan
		FOREIGN KEY (MaLopHP) REFERENCES lophocphan(MaLopHP),
	constraint FK_ThongTinThucTap_SinhVien
		FOREIGN KEY (MaSoSV) REFERENCES sinhvien(MaSoSV),
	constraint PK_ThongTinThucTap primary key(MaSoSV,MaLopHP),
    constraint U_ThongTinThucTap_MaSoSV unique(MaSoSV) /*1 sinh vien chỉ học 1 lớp*/
);



create table tuyendung(
	MaSoTD int primary key,
	TenDV varchar(255),
	DiaChi varchar(255),
	TinhThanhPho varchar(255),
	SoDienThoaiDV varchar(50), 
	EmailDV varchar(255) ,
	DiaChiWeb varchar(255) null, 
	HoTenNHD varchar(255),
	SoDienThoaiNHD varchar(50), 
	EmailNHD varchar(255),
	MoiTruong varchar(255), 
	NoiDungCV text,
	ThoiGianTT int,
	SoLuongNhanSV int null, 
	YeuCau text null,
	QuyenLoi text null,
    DauThoiGian Date ,
	TrangThai varchar(255) null,
    check_state tinyint default 0,
	GhiChu text null
);

create table bantin(
	id int primary key auto_increment,
	TieuDe varchar(255),
	TomTat varchar(255),
    NoiDung text,
    PathFile text null,
    NgayDang DateTime default now()
);



DELIMITER $$
CREATE TRIGGER TRG_DangKiHocPhan
BEFORE INSERT ON thongtinthuctap
FOR EACH ROW
BEGIN
	DECLARE SiSoConLai INT;
	SELECT lhp.SiSoConLai INTO SiSoConLai FROM lophocphan AS lhp
	WHERE NEW.MaLopHP = lhp.MaLopHP;
    
	IF SiSoConLai > 0
	THEN
		UPDATE lophocphan 
        SET SiSoConLai = SiSoConLai - 1
    WHERE NEW.MaLopHP = MaLopHP;
    ELSE
		SIGNAL SQLSTATE '45000'
   		SET MESSAGE_TEXT = 'Loi Khong The Tru Vi Si So Con Lai Da Bang 0';
	END IF;
END $$
 DELIMITER ;

DELIMITER $$
CREATE TRIGGER TRG_XoaHocPhan
BEFORE DELETE ON thongtinthuctap
FOR EACH ROW
BEGIN
	DECLARE SiSo,SiSoConLai INT;
	SELECT lhp.SiSoConLai INTO SiSoConLai FROM lophocphan AS lhp
	WHERE OLD.MaLopHP = lhp.MaLopHP;
    
    SELECT lhp.SiSo INTO SiSo FROM lophocphan AS lhp
	WHERE OLD.MaLopHP = lhp.MaLopHP;
    
	IF SiSoConLai < SiSo
	THEN
		UPDATE lophocphan 
        SET SiSoConLai = SiSoConLai + 1
    WHERE OLD.MaLopHP = MaLopHP;
    ELSE
		SIGNAL SQLSTATE '45000'
   		SET MESSAGE_TEXT = 'Loi Khong Cong Vi Si So Con Lai Bang Si So Lop';
	END IF;
END $$
 DELIMITER ;
 


