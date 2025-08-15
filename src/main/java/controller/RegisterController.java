package controller;

import database.KhachHangDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})


public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        String confirmMatKhau = request.getParameter("xacNhanMatKhau");
        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiKhachHang = request.getParameter("diaChiKhachHang");
        String diachiMuaHang = request.getParameter("diaChiMuaHang");
        String diachiNhanHang = request.getParameter("diaChiNhanHang");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongYNhanMail");


        request.setAttribute("tenDangNhap", tenDangNhap);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("hoVaTen", hoVaTen);
        request.setAttribute("ngaySinh", ngaySinh);
        request.setAttribute("diaChiKhachHang", diaChiKhachHang);
        request.setAttribute("diachiMuaHang", diachiMuaHang);
        request.setAttribute("diachiNhanHang", diachiNhanHang);
        request.setAttribute("soDienThoai", soDienThoai);
        request.setAttribute("email", email);
        request.setAttribute("dongYNhanMail", dongYNhanMail);

        String url = "";

        String baoLoi = "";
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        if(khachHangDAO.kiemTraTenDangNhap(tenDangNhap)){
            baoLoi +="Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác.<br/>";
        }
        if(!matKhau.equals(confirmMatKhau)){
            baoLoi +="Mật khẩu xác nhận không khớp. Vui lòng nhập lại.<br/>";
        }
        if(!baoLoi.isEmpty()){
            url = "/register.jsp";
        }else{
            Random rd = new Random();
            String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000)+"";
            KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen,
                    gioiTinh, diaChiKhachHang, diachiNhanHang, diachiMuaHang,
                    Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail !=null);
            khachHangDAO.insert(khachHang);
            url = "registerSuccess.jsp";
        }
        request.setAttribute("baoLoi", baoLoi);
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
