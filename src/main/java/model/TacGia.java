package model;

import lombok.*;

import java.util.Date;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class TacGia {

    private String maTacGia;
    private String hoVaTen;
    private Date ngaySinh;
    private String tieuSu;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TacGia tacGia = (TacGia) o;
        return Objects.equals(maTacGia, tacGia.maTacGia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTacGia, hoVaTen, ngaySinh, tieuSu);
    }
}
