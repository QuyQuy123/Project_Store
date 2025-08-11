package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class Sanpham {
    private String maSanPham;
    private String tenSanPham;
    private TacGia tacGia;
    private int namXuatBan;
    private double giaNhap;
    private double giaGoc;
    private double giaBan;
    private int soLuong;
    private TheLoai theLoai;
    private String ngonNgu;
    private String moTa;

}
