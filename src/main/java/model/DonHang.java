package model;

import lombok.*;

import java.util.Date;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class DonHang {
    private String maDonHang;
    private KhachHang khachHang;
    private String diaChiMuaHang;
    private String diaChiNhanHang;
    private String trangThai;
    private String hinhThucThanhToan;
    private String getTrangThaiThanhToan;
    private double soTienDaThanhToan;
    private double soTienConThieu;
    private Date ngayDatHang;
    private Date ngayGiaoHang;



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DonHang donHang = (DonHang) o;
        return Objects.equals(maDonHang, donHang.maDonHang);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maDonHang);
    }
}
