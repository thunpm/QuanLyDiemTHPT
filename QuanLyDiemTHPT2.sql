DROP DATABASE IF EXISTS QuanLyDiemTHPT;

CREATE DATABASE QuanLyDiemTHPT;

USE QuanLyDiemTHPT;

CREATE TABLE KHOIHOC (
   MaKH VARCHAR(10) PRIMARY KEY,
   TenKH NVARCHAR(50)
);

CREATE TABLE LOPHOC (
    MaLH VARCHAR(10) PRIMARY KEY,
	TenLH NVARCHAR(100),
	MaKH VARCHAR(10),
	MaNH VARCHAR(10),
	MaGVCN VARCHAR(10)
);

CREATE TABLE HOCSINH (
    MaHS VARCHAR(10) PRIMARY KEY,
	MaLH VARCHAR(10),
	Ho NVARCHAR(255),
	Ten NVARCHAR(255),
	GioiTinh NVARCHAR(15),
	NgaySinh DATE,
	DiaChi NVARCHAR(100)
);

CREATE TABLE NAMHOC (
    MaNH VARCHAR(10) PRIMARY KEY,
	TenNH NVARCHAR(255),
	ThoiGianBatDau DATE,
	ThoiGianKetThuc DATE
);

CREATE TABLE HOCKY (
   MaHK VARCHAR(10) PRIMARY KEY,
   MaNH VARCHAR(10),
   TenHK NVARCHAR(100),
   ThoiGianBatDau DATE,
   ThoiGianKetThuc DATE
);

CREATE TABLE GIAOVIEN (
   MaGV VARCHAR(10) PRIMARY KEY,
   Ho NVARCHAR(255),
   Ten NVARCHAR(255),
   GioiTinh NVARCHAR(15),
   NgaySinh DATE,
   DiaChi NVARCHAR(100),
   SDT CHAR(15),
   Email VARCHAR(255),
   MatKhau VARCHAR(255),
   Role NVARCHAR(10)
);

CREATE TABLE QUANTRI (
	MaQT VARCHAR(10) PRIMARY KEY,
	Ho NVARCHAR(255),
	Ten NVARCHAR(255),
	Email VARCHAR(255),
	MatKhau VARCHAR(255),
	Role NVARCHAR(10)
);

CREATE TABLE MONHOC (
   MaMH VARCHAR(10) PRIMARY KEY,
   TenMH NVARCHAR(100)
);

CREATE TABLE PHANCONGGIANGDAY (
   MaPC VARCHAR(10) PRIMARY KEY,
   MaGV VARCHAR(10),
   MaLH VARCHAR(10),
   MaHK VARCHAR(10),
   MaMH VARCHAR(10),
   GhiChu TEXT
);

CREATE TABLE DIEM (
	MaDiem VARCHAR(10),
    MaHS VARCHAR(10),
	MaPC VARCHAR(10),
	DiemHe1 FLOAT,
	DiemHe2 FLOAT,
	DiemHe3 FLOAT,
	GhiChu TEXT,
	PRIMARY KEY (MaDiem)
);

ALTER TABLE LOPHOC ADD FOREIGN KEY(MaKH) REFERENCES KHOIHOC(MaKH);
ALTER TABLE LOPHOC ADD FOREIGN KEY(MaNH) REFERENCES NAMHOC(MaNH);
ALTER TABLE HOCSINH ADD FOREIGN KEY(MaLH) REFERENCES LOPHOC(MaLH);
ALTER TABLE DIEM ADD FOREIGN KEY(MaPC) REFERENCES PHANCONGGIANGDAY(MaPC);
ALTER TABLE HOCKY ADD FOREIGN KEY(MaNH) REFERENCES NAMHOC(MaNH);
ALTER TABLE PHANCONGGIANGDAY ADD FOREIGN KEY(MaGV) REFERENCES GIAOVIEN(MaGV);
ALTER TABLE PHANCONGGIANGDAY ADD FOREIGN KEY(MaHK) REFERENCES HOCKY(MaHK);
ALTER TABLE PHANCONGGIANGDAY ADD FOREIGN KEY(MaLH) REFERENCES LOPHOC(MaLH);
ALTER TABLE PHANCONGGIANGDAY ADD FOREIGN KEY(MaMH) REFERENCES MONHOC(MaMH);

INSERT INTO KHOIHOC (MaKH, TenKH)
VALUES
	('KH01', N'Kh???i 10'),
	('KH02', N'Kh???i 11'),
	('KH03', N'Kh???i 12');

INSERT INTO NAMHOC (MaNH, TenNH, ThoiGIanBatDau, ThoiGianKetThuc)
VALUES
	('NH001', N'N??m h???c 2018-2019', '2018-08-25', '2019-05-31'),
    ('NH002', N'N??m h???c 2019-2020', '2019-08-26', '2020-06-01'),
	('NH003', N'N??m h???c 2020-2021', '2020-08-26', '2021-05-22'),
	('NH004', N'N??m h???c 2021-2022', '2021-09-07', '2022-06-22');

INSERT INTO GIAOVIEN (MaGV, Ho, Ten, GioiTinh, NgaySinh, DiaChi, SDT, Email, MatKhau, Role)
VALUES
	('GV001', N'L?? V??n', N'N??m', 'Nam', '1980-07-15', N'C???m L???', '0987654321', 'lvnam@ddt.com', '123', ''),
	('GV002', N'L??m Th???', N'H??ng', 'Nam', '1975-06-23', N'Ho?? Xu??n', '0987654322', 'lthung@ddt.com', '123', ''),
	('GV003', N'D????ng Ph????ng', N'Thu', N'N???', '1965-03-22', N'Li??n Chi???u', '0987654323', 'dpthu@ddt.com', '123', ''),
	('GV004', N'L??m Th??? Th??y', N'Ng??n', N'N???', '1981-12-05', N'Ho?? C?????ng', '0987654324', 'lttngan@ddt.com', '123', ''),
	('GV005', N'Tr???n H???u', N'Quy???t', 'Nam', '1991-11-24', N'S??n Tr??', '0987654325', 'thquyet@ddt.com', '123', ''),
	('GV006', N'N??ng Th???', N'Th???c', N'N???', '1991-12-14', N'H???i Ch??u', '0987654326', 'ntthuc@ddt.com', '123', ''),
	('GV007', N'??o??n Th???', N'Dung', N'N???', '1990-09-26', N'Thanh Kh??', '0987654327', 'dtdung@ddt.com', '123', ''),
	('GV008', N'N??ng Th???', N'Tuy???n', N'N???', '1984-04-15', N'Ho?? Vang', '0987654328', 'nttuyen@ddt.com', '123', ''),
	('GV009', N'Nguy???n V??n', N'H??ng', 'Nam', '1981-03-20', N'Ho?? Kh??nh', '0987654329', 'nvhung@ddt.com', '123', ''),
	('GV010', N'L?? Thu', N'Huy???n', N'N???', '1978-06-23', N'Li??n Chi???u', '0987654320', 'lthuyen@ddt.com', '123', ''),
	('GV011', N'Nguy???n Th???', N'H??', N'N???', '1982-08-25', N'Ho?? C?????ng', '0987654331', 'ntha@ddt.com', '123', ''),
	('GV012', N'Tri???u Th???', N'Vinh', N'N???', '1989-12-25', N'S??n Tr??', '0987654332', 'ttvinh@ddt.com', '123', ''),
	('GV013', N'Ph???m T??ng', N'L??m', 'Nam', '1984-04-06', N'H???i Ch??u', '0987654333', 'ptlam@ddt.com', '123', ''),
	('GV014', N'Ph???m Th??? Thu', N'H??', N'N???', '1991-12-01', N'Thanh Kh??', '0987654334', 'pttha@ddt.com', '123', ''),
	('GV015', N'Tr????ng Th???', N'Th???y', N'N???', '1989-06-18', N'Ho?? Vang', '0987654335', 'ttthuy@ddt.com', '123', ''),
	('GV016', N'??o??n Th???', N'Ph????ng', N'N???', '1988-09-16', N'Ho?? Kh??nh', '0987654336', 'dtphuong@ddt.com', '123', ''),
	('GV017', N'??u Th???', N'H???nh', N'N???', '1964-08-06', N'Li??n Chi???u', '0987654337', 'athanh@ddt.com', '123', ''),
    ('GV018', N'Nguy???n Phan Minh', N'Th??', N'N???', '1972-02-13', N'Li??n Chi???u', '0989828383', 'npmthu@ddt.com', '123', 'admin');
   
INSERT INTO LOPHOC (MaLH, TenLH, MaKH, MaNH, MaGVCN)
VALUES
	('LH001', N'L???p 10A1', 'KH01', 'NH004', 'GV001'),
	('LH002', N'L???p 10A2', 'KH01', 'NH004', 'GV002'),
	('LH003', N'L???p 10A3', 'KH01', 'NH004', 'GV003'),
	('LH004', N'L???p 10A4', 'KH01', 'NH001', 'GV001'),
	('LH005', N'L???p 10A5', 'KH01', 'NH001', 'GV001'),
	('LH006', N'L???p 11A1', 'KH02', 'NH004', 'GV006'),
	('LH007', N'L???p 11A2', 'KH02', 'NH004', 'GV006'),
	('LH008', N'L???p 11A3', 'KH02', 'NH003', 'GV008'),
	('LH009', N'L???p 11A4', 'KH02', 'NH003', 'GV009'),
	('LH010', N'L???p 11A5', 'KH02', 'NH002', 'GV010'),
	('LH011', N'L???p 12A1', 'KH03', 'NH004', 'GV011'),
	('LH012', N'L???p 12A2', 'KH03', 'NH004', 'GV012'),
	('LH013', N'L???p 12A3', 'KH03', 'NH001', 'GV013'),
	('LH014', N'L???p 12A4', 'KH03', 'NH002', 'GV014'),
	('LH015', N'L???p 12A5', 'KH03', 'NH001', 'GV001');

INSERT INTO HOCKY (MaHK, MaNH, TenHK, ThoiGIanBatDau, ThoiGianKetThuc)
VALUES
	('HK001', 'NH001', N'K??? I 2018-2019', '2018-08-26', '2018-12-28'),
    ('HK002', 'NH001', N'K??? I 2018-2019', '2018-12-30', '2019-05-31'),
    ('HK003', 'NH002', N'K??? I 2019-2020', '2019-08-26', '2019-12-28'),
    ('HK004', 'NH002', N'K??? I 2019-2020', '2019-12-30', '2020-05-31'),
	('HK005', 'NH003', N'K??? I 2020-2021', '2020-09-07', '2019-12-28'),
	('HK006', 'NH003', N'K??? II 2020-2021', '2019-12-30', '2020-05-31'),
	('HK007', 'NH004', N'K??? I 2021-2022', '2020-09-07', '2021-01-09'),
	('HK008', 'NH004', N'K??? II 2021-2022', '2021-01-11', '2021-06-22');

INSERT INTO HOCSINH (MaHS, MaLH, Ho, Ten, GioiTinh, NgaySinh, DiaChi)
VALUES
	('HS0001', 'LH001', 'Nguy???n V??n', 'H???u', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0002', 'LH001', 'Tr???n Th???', 'Ngh??a', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0003', 'LH001', 'L?? Th???', 'Nhung', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0004', 'LH001', 'Nguy???n', '?????t', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0005', 'LH001', '????? Th???', 'Dung', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0006', 'LH001', 'Nguy???n V??n', 'Long', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0007', 'LH001', 'L?? V??n', 'D??ng', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0008', 'LH002', 'Ph???m', 'Duy', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0009', 'LH002', 'Tr???n Th???', 'Duy??n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0010', 'LH002', 'Ph???m', 'D??ng', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0011', 'LH002', 'Nguy???n', 'Ph??', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0012', 'LH003', 'Tr???n T???n', 'Qu??', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0013', 'LH003', 'Ph?? V??n', '??o??n', 'N???', '2003-05-23', 'C???m L???'),
	('HS0014', 'LH004', 'Nguy???n Th???', 'Dung', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0015', 'LH004', 'V?? V??n', '??u', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0016', 'LH004', 'Tr???n Ph?????c', 'D??ng', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0017', 'LH005', 'L?? Th???', 'Ph?????c', 'N???', '2003-05-23', 'C???m L???'),
	('HS0018', 'LH005', 'Tr???n V??n', 'Duy', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0019', 'LH005', '????? Ph??', 'Duy??n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0020', 'LH005', 'H??? ', 'T???n', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0021', 'LH006', 'Nguy???n V??n', 'Thy', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0022', 'LH006', 'L?? Th???', 'D??ng', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0023', 'LH006', 'Ph???m', 'H??ng', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0024', 'LH006', 'Tr???n Th???', 'H????ng', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0025', 'LH007', '?????', 'L??', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0026', 'LH007', 'Nguy???n', 'Ho??ng', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0027', 'LH007', 'Tr???n T???n', 'Long', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0028', 'LH007', 'Ph?? Th???', 'T??ng', 'N???', '2003-05-23', 'C???m L???'),
	('HS0029', 'LH008', 'Nguy???n Th???', 'Ph?????ng', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0030', 'LH008', 'V?? V??n', 'L???u', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0031', 'LH008', 'Tr???n Ph?????c', '?????t', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0032', 'LH008', 'L?? Th???', 'Hi???n', 'N???', '2003-05-23', 'C???m L???'),
	('HS0033', 'LH009', 'Tr???n V??n', 'Qu??', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0034', 'LH009', '????? Ph??', 'Quy??n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0035', 'LH009', 'H??? ', 'L??m', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0036', 'LH009', 'H??? Duy', 'T???n', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0037', 'LH004', '?????', 'L??', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0038', 'LH004', 'Nguy???n', 'Ho??ng', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0039', 'LH004', 'Tr???n T???n', 'Long', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0040', 'LH004', 'Ph?? Th???', 'T??ng', 'N???', '2003-05-23', 'C???m L???'),
	('HS0041', 'LH004', 'Nguy???n Th???', 'Ph?????ng', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0042', 'LH004', 'V?? V??n', 'L???u', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0043', 'LH004', 'Tr???n Ph?????c', '?????t', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0044', 'LH004', 'L?? Th???', 'Hi???n', 'N???', '2003-05-23', 'C???m L???'),
	('HS0045', 'LH004', 'Tr???n V??n', 'Qu??', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0046', 'LH004', '????? Ph??', 'Quy??n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0047', 'LH004', 'H??? ', 'L??m', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0048', 'LH004', 'H??? Duy', 'T???n', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0049', 'LH006', '?????', 'L??', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0050', 'LH006', 'Nguy???n', 'Ho??ng', 'Nam', '2003-05-23', 'H???i Ch??u'),
	('HS0051', 'LH006', 'Tr???n T???n', 'Long', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0052', 'LH006', 'Ph?? Th???', 'T??ng', 'N???', '2003-05-23', 'C???m L???'),
	('HS0053', 'LH006', 'Nguy???n Th???', 'Ph?????ng', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0054', 'LH006', 'V?? V??n', 'L???u', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0055', 'LH006', 'Tr???n Ph?????c', '?????t', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0056', 'LH006', 'L?? Th???', 'Hi???n', 'N???', '2003-05-23', 'C???m L???'),
	('HS0057', 'LH006', 'Tr???n V??n', 'Qu??', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0058', 'LH006', '????? Ph??', 'Quy??n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0059', 'LH006', 'H??? ', 'L??m', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0060', 'LH004', 'H??? Duy', 'C?????ng', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0061', 'LH004', 'Tr???n T???n', 'H???', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0062', 'LH004', 'Ph?? Th???', 'Phi', 'N???', '2003-05-23', 'C???m L???'),
	('HS0063', 'LH004', 'Nguy???n Th???', 'Ki???u', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0064', 'LH004', 'V?? V??n', 'v??', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0065', 'LH004', 'Tr???n Ph?????c', 'Huy', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0066', 'LH004', 'L?? Th???', 'th??y', 'N???', '2003-05-23', 'C???m L???'),
	('HS0067', 'LH004', 'Tr???n V??n', 'ngh??a', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0068', 'LH004', '????? Ph??', 'Ho??ng', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0069', 'LH004', 'H??? ', 'T???n', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0070', 'LH004', 'H??? Duy', 'Quy??n', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0071', 'LH006', 'Tr???n T???n', 'D??ng', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0072', 'LH006', 'Ph?? Th???', '????nh', 'N???', '2003-05-23', 'C???m L???'),
	('HS0073', 'LH006', 'Nguy???n Th???', 'N??', 'N???', '2003-05-23', 'Li??n Chi???u'),
	('HS0074', 'LH006', 'V?? V??n', 'B???o', 'Nam', '2003-05-23', 'C???m L???'),
	('HS0075', 'LH006', 'Tr???n Ph?????c', 'Duy', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0076', 'LH006', 'L?? Th???', 'L???', 'N???', '2003-05-23', 'C???m L???'),
	('HS0077', 'LH006', 'Tr???n V??n', 'Tr???c', 'Nam', '2003-05-23', 'Li??n Chi???u'),
	('HS0078', 'LH006', '????? Ph??', 'Quy???n', 'N???', '2003-05-23', 'S??n Tr??'),
	('HS0079', 'LH006', 'H??? ', 'B??', 'Nam', '2003-05-23', 'H??a Kh??nh'),
	('HS0080', 'LH006', 'H??? Duy', 'C?????ng', 'Nam', '2003-05-23', 'H??a Kh??nh');

INSERT INTO MONHOC (MaMH, TenMH)
VALUES
	('MH01', N'To??n'),
	('MH02', N'V???t L??'),
	('MH03', N'H??a H???c'),
	('MH04', N'Sinh H???c'),
	('MH05', N'Ng??? V??n'),
	('MH06', N'L???ch S???'),
	('MH07', N'?????a L??'),
	('MH08', N'Tin H???c'),
	('MH09', N'C??ng Ngh???'),
	('MH10', N'Gi??o D???c C??ng D??n'),
	('MH11', N'Ti???ng Anh'),
	('MH12', N'Qu???c Ph??ng - An Ninh');

INSERT INTO PHANCONGGIANGDAY (MaPC, MaGV, MaLH, MaHK, MaMH, GhiChu)
VALUES
	('PC0001', 'GV005', 'LH001', 'HK001', 'MH07', ''),
	('PC0002', 'GV005', 'LH002', 'HK001', 'MH04', ''),
	('PC0003', 'GV005', 'LH003', 'HK001', 'MH05', ''),
	('PC0004', 'GV001', 'LH004', 'HK002', 'MH01', ''),
	('PC0005', 'GV002', 'LH005', 'HK002', 'MH02', ''),
	('PC0006', 'GV004', 'LH006', 'HK002', 'MH03', ''),
	('PC0007', 'GV008', 'LH007', 'HK003', 'MH09', ''),
	('PC0008', 'GV006', 'LH008', 'HK003', 'MH08', ''),
	('PC0009', 'GV009', 'LH009', 'HK007', 'MH10', ''),
	('PC0010', 'GV010', 'LH010', 'HK007', 'MH11', ''),
	('PC0011', 'GV014', 'LH011', 'HK008', 'MH06', ''),
	('PC0012', 'GV012', 'LH001', 'HK008', 'MH12', ''),
	('PC0013', 'GV013', 'LH001', 'HK008', 'MH07', ''),
	('PC0014', 'GV015', 'LH001', 'HK008', 'MH06', ''),
	('PC0015', 'GV011', 'LH001', 'HK008', 'MH09', '');

INSERT INTO DIEM (MaDiem, MaHS, MaPC, DiemHe1, DiemHe2, DiemHe3, GhiChu)
VALUES
	('D00001', 'HS0001', 'PC0012', '8', '6.5', '7.7', ''),
	('D00002', 'HS0001', 'PC0013', '4.5', '5.9', '6.5', ''),
	('D00003', 'HS0001', 'PC0015', '6', '7.5', '7', ''),
	('D00004', 'HS0001', 'PC0014', '9', '6.5', '8.5', ''),
	('D00005', 'HS0005', 'PC0003', '5.6', '4.5', '7', ''),
	('D00006', 'HS0006', 'PC0003', '8', '6', '7', ''),
	('D00007', 'HS0007', 'PC0004', '3.4', '7', '5.5', ''),
	('D00008', 'HS0008', 'PC0004', '8', '6.5', '7.7', ''),
	('D00009', 'HS0009', 'PC0005', '8', '6.5', '7.7', ''),
	('D00010', 'HS0010', 'PC0005', '8', '6.5', '7.7', ''),
	('D00011', 'HS0011', 'PC0006', '8', '6.5', '7.7', ''),
	('D00012', 'HS0012', 'PC0006', '4.5', '5.9', '6.5', ''),
	('D00013', 'HS0013', 'PC0007', '6', '7.5', '7', ''),
	('D00014', 'HS0014', 'PC0007', '9', '6.5', '8.5', ''),
	('D00015', 'HS0015', 'PC0008', '5.6', '4.5', '7', ''),
	('D00016', 'HS0016', 'PC0008', '8', '6', '7', ''),
	('D00017', 'HS0017', 'PC0009', '3.4', '7', '5.5', ''),
	('D00018', 'HS0018', 'PC0009', '8', '6.5', '7.7', ''),
	('D00019', 'HS0019', 'PC0010', '8', '6.5', '7.7', ''),
	('D00020', 'HS0020', 'PC0010', '8', '6.5', '7.7', ''),
	('D00021', 'HS0021', 'PC0003', '5.6', '4.5', '7', ''),
	('D00022', 'HS0022', 'PC0003', '8', '6', '7', ''),
	('D00023', 'HS0023', 'PC0004', '3.4', '7', '5.5', ''),
	('D00024', 'HS0024', 'PC0004', '8', '6.5', '7.7', ''),
	('D00025', 'HS0025', 'PC0005', '8', '6.5', '7.7', ''),
	('D00026', 'HS0026', 'PC0005', '8', '6.5', '7.7', ''),
	('D00027', 'HS0027', 'PC0006', '8', '6.5', '7.7', ''),
	('D00028', 'HS0028', 'PC0006', '4.5', '5.9', '6.5', ''),
	('D00029', 'HS0029', 'PC0007', '6', '7.5', '7', ''),
	('D00030', 'HS0030', 'PC0007', '9', '6.5', '8.5', ''),
	('D00031', 'HS0031', 'PC0008', '5.6', '4.5', '7', ''),
	('D00032', 'HS0032', 'PC0008', '8', '6', '7', ''),
	('D00033', 'HS0033', 'PC0009', '3.4', '7', '5.5', ''),
	('D00034', 'HS0034', 'PC0009', '8', '6.5', '7.7', ''),
	('D00035', 'HS0035', 'PC0010', '8', '6.5', '7.7', ''),
	('D00036', 'HS0036', 'PC0010', '8', '6.5', '7.7', '');

------------ t_admin ----------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_good_student`()
	SELECT  *,((diemHe1+diemHe2*2+diemHe3*3)/6) as tongdiem FROM diem 
    WHERE ((diemHe1+diemHe2*2+diemHe3*3)/6) > 7.9 
    GROUP BY MaHS  
    ORDER BY tongdiem DESC $$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_top_3_student_score`()
SELECT  * FROM diem 
GROUP BY MaHS 
ORDER BY DiemHe3 DESC, DiemHe2 DESC, DiemHe1 DESC 
LIMIT 3 $$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `statistic_diemHe1`()
SELECT COUNT(round(diemhe1)) AS soLuong, round(diemHe1) FROM diem GROUP BY diemHe1$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `statistic_diemHe2`()
SELECT COUNT(round(diemhe2)) AS soLuong, round(diemHe2) FROM diem GROUP BY diemHe2$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `statistic_diemHe3`()
SELECT COUNT(round(diemhe3)) AS soLuong, round(diemHe3) FROM diem GROUP BY diemHe3$$
DELIMITER ;

------------ t_giaovien ----------------
-- T???o th??? t???c tr??? v??? l???p m?? gi??o vi??n ??ang ch??? nhi???m ??? th???i ??i???m hi???n t???i
DELIMITER //
drop procedure if exists LopChuNhiem //

create procedure LopChuNhiem(id varchar(10))
begin
	select * from lophoc lh
    inner join namhoc nh on nh.MaNH = lh.MaNH
    where (lh.MaGVCN = id) and (curdate() between ThoiGianBatDau and ThoiGianKetThuc);
end //
DELIMITER ;

-- call LopChuNhiem('GV001');

-- T???o th??? t???c tr??? v??? b???ng ch???a danh s??ch ph??n c??ng c???a gi??o vi??n b??? m??n n??o ????
DELIMITER //
drop procedure if exists DanhSachMon //

create procedure DanhSachMon(id varchar(10))
begin
	select mapc, magv, malh, mahk, mamh, ghichu from phanconggiangday pcgd
    where pcgd.magv = id;
end //
DELIMITER ;

-- call DanhSachMon('GV001');

-- T???o th??? t???c tr??? v??? danh s??ch h???c sinh c???a m???t l???p n??o ????
DELIMITER //
drop procedure if exists DanhSachLop //

create procedure DanhSachLop(maLH varchar(10))
begin
	select hs.* from hocsinh hs
    where hs.MaLH = maLH;
end //
DELIMITER ;

-- call DanhSachLop('LH001');

-- T???o th??? t???c tr??? v??? danh s??ch ??i???m ???????c nh???p g???n ????y c???a m???t gi??o vi??n n??o ????
DELIMITER //
drop procedure if exists DanhSachDiem //

create procedure DanhSachDiem(id varchar(10))
begin
	select d.* from diem d
    inner join phanconggiangday pcgd on pcgd.MaPC = d.MaPC
    where MaGV = id
    order by MaDiem desc
    limit 10;
    
end //
DELIMITER ;

-- call DanhSachDiem('GV005');

-- T???o th??? t???c tr??? v??? danh s??ch ??i???m trong n??m h???c hi???n t???i c???a h???c sinh
DELIMITER //
drop procedure if exists DanhSachDiemHocSinh //

create procedure DanhSachDiemHocSinh(id varchar(10))
begin
	select d.* from diem d
    inner join phanconggiangday pcgd on pcgd.MaPC = d.MaPC
    inner join monhoc mh on pcgd.MaMH = mh.MaMH
	inner join hocky hk on hk.MaHK = pcgd.MaHK
	inner join namhoc nh on nh.MaNH = hk.MaNH
	where d.MaHS = id and (curdate() between nh.ThoiGianBatDau and nh.ThoiGianKetThuc)
    order by pcgd.MaHK asc, mh.TenMH asc;
end //
DELIMITER ;

-- call DanhSachDiemHocSinh('HS0001');

-- T???o h??m tr??? v??? s??? l?????ng h???c ph???n m?? gi??o vi??n n??o ???? ???? ph??? tr??ch
DELIMITER //
drop function if exists TongSoHP //

create function TongSoHP(id varchar(10))
returns int
DETERMINISTIC
begin
	declare tong int;
    set tong = 0;
    
	select count(MaPC) into tong from phanconggiangday pcgd
 	where MaGV = id;
    
    return tong;
end //

DELIMITER ;

-- select TongSoHP('GV005');

-- T???o h??m tr??? v??? s??? l?????ng h???c ph???n m?? gi??o vi??n n??o ???? ??ang ph??? tr??ch trong
-- h???c k??? hi???n t???i
DELIMITER //
drop function if exists TongSoHPDangPT //

create function TongSoHPDangPT(id varchar(10))
returns int
DETERMINISTIC
begin
	declare tong int;
    set tong = 0;
    
	select count(MaPC) into tong from phanconggiangday pcgd
    inner join hocky hk on hk.MaHK = pcgd.MaHK
 	where MaGV = id and hk.ThoiGianBatDau <= curdate() and hk.ThoiGianKetThuc >= curdate();
    
    return tong;
end //

DELIMITER ;

-- select TongSoHPDangPT('GV005');

-- T???o h??m tr??? v??? t???ng s??? m??n h???c m?? gi??o vi??n n??o ???? ???? d???y
DELIMITER //
drop function if exists TongSoMH //

create function TongSoMH(id varchar(10))
returns int
DETERMINISTIC
begin
	declare tong int;
    set tong = 0;
    
	select count(distinct MaMH) into tong from phanconggiangday pcgd
 	where MaGV = id;
    
    return tong;
end //

DELIMITER ;

-- select TongSoMH('GV001');

-- T???o h??m tr??? v??? t???ng s??? h???c sinh c???a m???t l???p
DELIMITER //
drop function if exists TongHS //

create function TongHS(id varchar(10))
returns int
DETERMINISTIC
begin
	declare tong int;
    set tong = 0;
    
	select count(distinct MaHS) into tong from hocsinh hs
 	where MaLH = id;
    
    return tong;
end //

DELIMITER ;

/*
-- T???o trigger cho s??? ki???n th??m m???i k?? h???c, v???i ??i???u ki???n th???i gian b???t ?????u
-- v?? k???t th??c c???a k?? h???c ph???i n???m trong th???i gian b???t ?????u v?? k???t th??c
-- c???a n??m h???c.

create trigger insertHocKi
on HocKy
for insert
as
	begin
		declare @batDauKy date, @ketThucKy date, 
			@batDauNam date, @ketThucNam date
		declare @maNH varchar(10)

		select @batDauKy = ThoiGianBatDau, @ketThucKy = ThoiGianKetThuc, @maNH = MaNH from inserted
		select @batDauNam = ThoiGianBatDau, @ketThucNam = ThoiGianKetThuc from NAMHOC
		where MaNH = @maNH

		if not ((@batDauKy < @ketThucKy)
			and (@batDauKy between @batDauNam and @ketThucNam)
			and (@ketThucKy between @batDauNam and @ketThucNam))
			begin
				print 'Thoi gian khong hop le!'
				rollback transaction
			end
	end

INSERT INTO HOCKY (MaHK, MaNH, TenHK, ThoiGIanBatDau, ThoiGianKetThuc)
VALUES
	('HK005', 'NH001', 'Ki I 2019-2020', '2018-08-26', '2019-12-28')

-- T???o trigger cho s??? ki???n thay ?????i ??i???m c???a h???c sinh, m???i khi thay ?????i th?? th??m 
-- v??o ghi ch?? d??ng "S???a ??i???m h??? ... t??? ... th??nh ..."

create trigger updateDiem
on DIEM
for update
as
	if update(DiemHe1)
		begin
			declare @ghiChu nvarchar(100), @diem1 float, @diem2 float
			select @diem1 = DiemHe1 from deleted
			select @diem2 = DiemHe1 from inserted
			set @ghiChu = concat('Sua diem he 1 tu ', convert(nvarchar, @diem1), ' thanh ', convert(nvarchar, @diem2))

			update DIEM
			set GhiChu = concat(GhiChu, '; ', @ghiChu)
			where MaPC = (select MaPC from inserted)
		end
	else if update(DiemHe2)
		begin
			select @diem1 = DiemHe2 from deleted
			select @diem2 = DiemHe2 from inserted
			set @ghiChu = concat('Sua diem he 1 tu ', convert(nvarchar, @diem1), ' thanh ', convert(nvarchar, @diem2))

			update DIEM
			set GhiChu = concat(GhiChu, '; ', @ghiChu)
			where MaPC = (select MaPC from inserted)
		end
	else if update(DiemHe3)
		begin
			select @diem1 = DiemHe3 from deleted
			select @diem2 = DiemHe3 from inserted
			set @ghiChu = concat('Sua diem he 1 tu ', convert(nvarchar, @diem1), ' thanh ', convert(nvarchar, @diem2))

			update DIEM
			set GhiChu = concat(GhiChu, '; ', @ghiChu)
			where MaPC = (select MaPC from inserted)
		end

drop trigger updateDiem

update DIEM
set DiemHe1 = 7.9
where MaHS = 'HS0001' and MaPC = 'PC0001'

select * from DIEM
where MaHS = 'HS0001'
*/