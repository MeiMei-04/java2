CREATE DATABASE QLSV_Java2;
use QLSV_Java2;
CREATE TABLE NganhHoc(
    manh varchar(10) PRIMARY KEY not null,
    tennh nvarchar(50) not null
)
CREATE TABLE SinhVien(
    masv varchar(10) PRIMARY KEY not null,
    manh varchar(10) not null,
    tensv nvarchar(50) not null,
    diem float default 0
    FOREIGN KEY (manh)
    REFERENCES NganhHoc(manh)
)
INSERT INTO NganhHoc (manh, tennh) VALUES 
    ('NH001', N'Khoa Học Máy Tính'),
    ('NH002', N'Khoa Học Dữ Liệu'),
    ('NH003', N'Hệ Thống Thông Tin'),
    ('NH004', N'Công Nghệ Thông Tin'),
    ('NH005', N'An Toàn Thông Tin');

-- Inserting data into SinhVien table
INSERT INTO SinhVien (masv, manh, tensv, diem) VALUES
    ('SV001', 'NH001', N'Nguyễn Văn A', 8.5),
    ('SV002', 'NH002', N'Trần Thị B', 7.8),
    ('SV003', 'NH003', N'Hoàng Văn C', 6.9),
    ('SV004', 'NH004', N'Lê Thị D', 9.2),
    ('SV005', 'NH005', N'Phạm Văn E', 7.5);
SELECT masv,tensv,diem,tennh FROM SinhVien
JOIN NganhHoc on SinhVien.manh = NganhHoc.manh
SELECT * FROM NganhHoc
UPDATE SinhVien SET manh =?,tensv=?,diem=? where masv = ?
Delete SinhVien Where masv = ?