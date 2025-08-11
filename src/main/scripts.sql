

create database myweb;
use myweb;

-- Tạo bảng TheLoai
CREATE TABLE TheLoai (
                         maTheLoai NVARCHAR(50) PRIMARY KEY,
                         tenTheLoai NVARCHAR(100) NOT NULL
);
GO

-- Tạo bảng TacGia
CREATE TABLE TacGia (
                        maTacGia NVARCHAR(50) PRIMARY KEY,
                        hoVaTen NVARCHAR(100) NOT NULL,
                        ngaySinh DATE,
                        tieuSu NVARCHAR(MAX)
);
GO

-- Tạo bảng Sanpham
CREATE TABLE Sanpham (
                         maSanPham NVARCHAR(50) PRIMARY KEY,
                         tenSanPham NVARCHAR(200) NOT NULL,
                         maTacGia NVARCHAR(50) NOT NULL,
                         namXuatBan INT,
                         giaNhap DECIMAL(18, 2) NOT NULL,
                         giaGoc DECIMAL(18, 2) NOT NULL,
                         giaBan DECIMAL(18, 2) NOT NULL,
                         soLuong INT NOT NULL,
                         maTheLoai NVARCHAR(50) NOT NULL,
                         ngonNgu NVARCHAR(50),
                         moTa NVARCHAR(MAX),
                         FOREIGN KEY (maTacGia) REFERENCES TacGia(maTacGia),
                         FOREIGN KEY (maTheLoai) REFERENCES TheLoai(maTheLoai)
);
GO

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
                           maKhachHang NVARCHAR(50) PRIMARY KEY,
                           tenDangNhap NVARCHAR(100) UNIQUE NOT NULL,
                           matKhau NVARCHAR(100) NOT NULL,
                           hoVaTen NVARCHAR(100) NOT NULL,
                           gioiTinh NVARCHAR(20),
                           diaChi NVARCHAR(200),
                           diaChiNhanHang NVARCHAR(200),
                           diaChiMuaHang NVARCHAR(200),
                           ngaySinh DATE,
                           soDienThoai NVARCHAR(20),
                           email NVARCHAR(100),
                           dangKiNhanBangTin BIT NOT NULL DEFAULT 0
);
GO

-- Tạo bảng DonHang
CREATE TABLE DonHang (
                         maDonHang NVARCHAR(50) PRIMARY KEY,
                         maKhachHang NVARCHAR(50) NOT NULL,
                         diaChiMuaHang NVARCHAR(200),
                         diaChiNhanHang NVARCHAR(200),
                         trangThai NVARCHAR(50) NOT NULL,
                         hinhThucThanhToan NVARCHAR(50) NOT NULL,
                         trangThaiThanhToan NVARCHAR(50) NOT NULL,
                         soTienDaThanhToan DECIMAL(18, 2) NOT NULL DEFAULT 0,
                         soTienConThieu DECIMAL(18, 2) NOT NULL DEFAULT 0,
                         ngayDatHang DATETIME NOT NULL,
                         ngayGiaoHang DATETIME,
                         FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang)
);
GO

-- Tạo bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
                                maChiTietDonHang NVARCHAR(50) PRIMARY KEY,
                                maDonHang NVARCHAR(50) NOT NULL,
                                maSanPham NVARCHAR(50) NOT NULL,
                                soLuong DECIMAL(18, 2) NOT NULL,
                                giaGoc DECIMAL(18, 2) NOT NULL,
                                giamGia DECIMAL(18, 2) NOT NULL DEFAULT 0,
                                giaBan DECIMAL(18, 2) NOT NULL,
                                thueVAT DECIMAL(18, 2) NOT NULL DEFAULT 0,
                                tongTien DECIMAL(18, 2) NOT NULL,
                                FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang),
                                FOREIGN KEY (maSanPham) REFERENCES Sanpham(maSanPham)
);
GO

---
-- Chèn dữ liệu vào bảng TheLoai
INSERT INTO TheLoai (maTheLoai, tenTheLoai) VALUES
                                                ('TL001', N'Văn học'),
                                                ('TL002', N'Khoa học'),
                                                ('TL003', N'Tiểu thuyết'),
                                                ('TL004', N'Kinh tế'),
                                                ('TL005', N'Truyện ngắn');
GO

-- Chèn dữ liệu vào bảng TacGia
INSERT INTO TacGia (maTacGia, hoVaTen, ngaySinh, tieuSu) VALUES
                                                             ('TG001', N'Nguyễn Nhật Ánh', '1955-05-07', N'Nhà văn nổi tiếng với các tác phẩm dành cho tuổi trẻ'),
                                                             ('TG002', N'Tô Hoài', '1920-09-27', N'Tác giả của Dế Mèn phiêu lưu ký'),
                                                             ('TG003', N'Paulo Coelho', '1947-08-24', N'Nhà văn Brazil, tác giả Nhà giả kim'),
                                                             ('TG004', N'Yuval Noah Harari', '1976-02-24', N'Nhà sử học, tác giả Sapiens'),
                                                             ('TG005', N'Nguyễn Ngọc Tư', '1976-10-20', N'Nhà văn với các tác phẩm đậm chất miền Tây');
GO

-- Chèn dữ liệu vào bảng Sanpham
INSERT INTO Sanpham (maSanPham, tenSanPham, maTacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, maTheLoai, ngonNgu, moTa) VALUES
                                                                                                                                  ('SP001', N'Mắt Biếc', 'TG001', 1990, 50000, 80000, 100000, 50, 'TL003', N'Tiếng Việt', N'Câu chuyện tình yêu đầy cảm xúc'),
                                                                                                                                  ('SP002', N'Dế Mèn Phiêu Lưu Ký', 'TG002', 1941, 30000, 50000, 60000, 30, 'TL001', N'Tiếng Việt', N'Tác phẩm kinh điển về hành trình của Dế Mèn'),
                                                                                                                                  ('SP003', N'Nhà Giả Kim', 'TG003', 1988, 70000, 100000, 120000, 20, 'TL003', N'Tiếng Việt', N'Hành trình tìm kiếm ước mơ'),
                                                                                                                                  ('SP004', N'Sapiens', 'TG004', 2011, 100000, 150000, 180000, 15, 'TL002', N'Tiếng Việt', N'Lịch sử loài người'),
                                                                                                                                  ('SP005', N'Cánh Đồng Bất Tận', 'TG005', 2005, 40000, 60000, 75000, 25, 'TL001', N'Tiếng Việt', N'Truyện về cuộc sống miền Tây');
GO

-- Chèn dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKiNhanBangTin) VALUES
                                                                                                                                                                         ('KH001', 'user1', 'pass123', N'Nguyễn Văn A', N'Nam', N'123 Đường Láng, Hà Nội', N'123 Đường Láng, Hà Nội', N'123 Đường Láng, Hà Nội', '1990-01-01', '0901234567', 'user1@example.com', 1),
                                                                                                                                                                         ('KH002', 'user2', 'pass456', N'Trần Thị B', N'Nữ', N'456 Nguyễn Trãi, TP.HCM', N'456 Nguyễn Trãi, TP.HCM', N'456 Nguyễn Trãi, TP.HCM', '1995-02-15', '0912345678', 'user2@example.com', 0),
                                                                                                                                                                         ('KH003', 'user3', 'pass789', N'Lê Văn C', N'Nam', N'789 Hai Bà Trưng, Đà Nẵng', N'789 Hai Bà Trưng, Đà Nẵng', N'789 Hai Bà Trưng, Đà Nẵng', '1985-03-20', '0923456789', 'user3@example.com', 1),
                                                                                                                                                                         ('KH004', 'user4', 'pass101', N'Phạm Thị D', N'Nữ', N'101 Lê Lợi, Huế', N'101 Lê Lợi, Huế', N'101 Lê Lợi, Huế', '1992-04-10', '0934567890', 'user4@example.com', 0),
                                                                                                                                                                         ('KH005', 'user5', 'pass202', N'Hoàng Văn E', N'Nam', N'202 Trần Phú, Cần Thơ', N'202 Trần Phú, Cần Thơ', N'202 Trần Phú, Cần Thơ', '1988-05-05', '0945678901', 'user5@example.com', 1);
GO

-- Chèn dữ liệu vào bảng DonHang
INSERT INTO DonHang (maDonHang, maKhachHang, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang) VALUES
                                                                                                                                                                                                ('DH001', 'KH001', N'123 Đường Láng, Hà Nội', N'123 Đường Láng, Hà Nội', N'Đang xử lý', N'Thẻ tín dụng', N'Đã thanh toán', 100000, 0, '2025-08-01 10:00:00', NULL),
                                                                                                                                                                                                ('DH002', 'KH002', N'456 Nguyễn Trãi, TP.HCM', N'456 Nguyễn Trãi, TP.HCM', N'Đã giao', N'Tiền mặt', N'Chưa thanh toán', 0, 180000, '2025-08-02 12:00:00', '2025-08-05 15:00:00'),
                                                                                                                                                                                                ('DH003', 'KH003', N'789 Hai Bà Trưng, Đà Nẵng', N'789 Hai Bà Trưng, Đà Nẵng', N'Đang giao', N'Chuyển khoản', N'Đã thanh toán', 120000, 0, '2025-08-03 14:00:00', NULL),
                                                                                                                                                                                                ('DH004', 'KH004', N'101 Lê Lợi, Huế', N'101 Lê Lợi, Huế', N'Đang xử lý', N'Thẻ tín dụng', N'Đã thanh toán', 75000, 0, '2025-08-04 16:00:00', NULL),
                                                                                                                                                                                                ('DH005', 'KH005', N'202 Trần Phú, Cần Thơ', N'202 Trần Phú, Cần Thơ', N'Đã hủy', N'Tiền mặt', N'Chưa thanh toán', 0, 60000, '2025-08-05 09:00:00', NULL);
GO

-- Chèn dữ liệu vào bảng ChiTietDonHang
INSERT INTO ChiTietDonHang (maChiTietDonHang, maDonHang, maSanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien) VALUES
                                                                                                                             ('CTDH001', 'DH001', 'SP001', 1, 80000, 0, 100000, 10000, 110000),
                                                                                                                             ('CTDH002', 'DH002', 'SP004', 1, 150000, 0, 180000, 18000, 198000),
                                                                                                                             ('CTDH003', 'DH003', 'SP003', 1, 100000, 0, 120000, 12000, 132000),
                                                                                                                             ('CTDH004', 'DH004', 'SP005', 1, 60000, 0, 75000, 7500, 82500),
                                                                                                                             ('CTDH005', 'DH005', 'SP002', 1, 50000, 0, 60000, 6000, 66000);
GO












