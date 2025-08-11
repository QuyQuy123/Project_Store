package model;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class KhachHang
{
    private String maKhachHang;
    private String tenDangNhap;
    private String matKhau;
    private String hoVaTen;
    private String  gioiTinh;
    private String diaChi;
    private String diaChiNhanHang;
    private String diaChiMuaHang;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private boolean dangKiNhanBangTin;

}
