package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ChiTietDonHang {
    private String maChiTietDonHang;
    private DonHang donHang;
    private Sanpham sanPham;
    private double soLuong;
    private double giaGoc;
    private double giamGia;
    private double giaBan;
    private double thueVAT;
    private double thongTien;

}
