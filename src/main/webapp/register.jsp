<%--
  Created by IntelliJ IDEA.
  User: 84968
  Date: 8/13/2025
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
    <style>
        .red {
            color: red;
        }

    </style>
</head>
<body>
    <%
        String baoLoi = request.getAttribute("baoLoi") != null ? request.getAttribute("baoLoi").toString() : "";

        String tenDangNhap = request.getAttribute("tenDangNhap") +"";
        tenDangNhap = (tenDangNhap.equals("null"))? "" : tenDangNhap;

        String hoVaTen = request.getAttribute("hoVaTen")+"";
        hoVaTen = (hoVaTen.equals("null"))? "" : hoVaTen;

        String gioiTinh = request.getAttribute("gioiTinh")+"";
        gioiTinh = (gioiTinh.equals("null"))? "" : gioiTinh;

        String ngaySinh = request.getAttribute("ngaySinh")+"";
        ngaySinh = (ngaySinh.equals("null"))? "" : ngaySinh;

        String diaChiKhachHang = request.getAttribute("diaChiKhachHang")+"";
        diaChiKhachHang = (diaChiKhachHang.equals("null"))? "" : diaChiKhachHang;

        String diachiMuaHang = request.getAttribute("diachiMuaHang")+"";
        diachiMuaHang = (diachiMuaHang.equals("null"))? "" : diachiMuaHang;

        String diachiNhanHang = request.getAttribute("diachiNhanHang")+"";
        diachiNhanHang = (diachiNhanHang.equals("null"))? "" : diachiNhanHang;

        String soDienThoai = request.getAttribute("soDienThoai")+"";
        soDienThoai = (soDienThoai.equals("null"))? "" : soDienThoai;

        String email = request.getAttribute("email")+"";
        email = (email.equals("null"))? "" : email;

        String dongYNhanMail = request.getAttribute("dongYNhanMail")+"";
        dongYNhanMail = (dongYNhanMail.equals("null"))? "" : dongYNhanMail;


    %>

<div class="container">
    <div class="text-center">
        <h1>Đăng Kí Tài Khoản </h1>
    </div>
    <div class="red" id="baoLoi">
       <%=baoLoi%>
    </div>
    <form class="form" action="register" method="post">
        <div class="row">
            <div class="col">
                <h3>Tài Khoản</h3>
                    <div class = "mb-3">
                        <label for="tenDangNhap" class = "form-label">Tên Đăng Nhập<span class ="red">*</span></label>
                        <input type="text" class = "form-control" id="tenDangNhap" name="tenDangNhap"
                               placeholder="Nhập họ và tên của bạn" required value="<%=tenDangNhap%>">
                    </div>
                    <div class = "mb-3">
                        <label  for="matKhau" class = "form-label">Mật Khẩu<span class ="red" >*</span></label>
                        <input type="password" class = "form-control" id="matKhau" name="matKhau"
                               placeholder="Nhập mật khẩu của bạn" required onkeyup="kiemTraMatKhau()">
                    </div>
                    <div class = "mb-3">
                        <label  for="xacNhanMatKhau" class = "form-label">Xác Nhận Mật Khẩu<span class ="red" >*</span><span class = "red" id="msg"></span></label>
                        <input  type="password" class = "form-control" id="xacNhanMatKhau" name="xacNhanMatKhau" placeholder="Nhập lại mật khẩu của bạn" required onkeyup="kiemTraMatKhau()">
                    </div>
                    <br/>
                <h3>Thông Tin Khách Hàng</h3>
                    <div class = "mb-3">
                        <label for="hoVaTen" class = "form-label">Họ Và Tên<span class ="red">*</span></label>
                        <input type="text" class = "form-control" id="hoVaTen" name="hoVaTen"
                               placeholder="Nhập họ và tên của bạn" required value="<%=hoVaTen%>">
                    </div>
                <div class="mb-3">
                    <label for="gioiTinh" class="form-label">Giới Tính</label>
                    <select class="form-control" id="gioiTinh" name="gioiTinh">
                        <option value="" <%= gioiTinh.isEmpty() ? "selected" : "" %>></option>
                        <option value="Nam" <%= "Nam".equals(gioiTinh) ? "selected" : "" %>>Nam</option>
                        <option value="Nữ" <%= "Nữ".equals(gioiTinh) ? "selected" : "" %>>Nữ</option>
                        <option value="Khác" <%= "Khác".equals(gioiTinh) ? "selected" : "" %>>Khác</option>
                    </select>
                </div>
                    <div class = "mb-3">
                        <label for="ngaySinh" class = "form-label">Ngày Sinh</label>
                        <input type="date" class = "form-control" id="ngaySinh" name="ngaySinh"  value="<%=ngaySinh%>">
                    </div>
            </div>
            <div class="col">

                <h3>Địa Chỉ</h3>
                    <div class = "mb-3">
                        <label for="diaChiKhachHang" class = "form-label">Địa chỉ khách hàng</label>
                        <input type="text" class = "form-control" id="diaChiKhachHang" name="diaChiKhachHang" value="<%=diaChiKhachHang%>">
                    </div>
                    <div class = "mb-3">
                        <label for="diaChiMuaHang" class = "form-label">Địa chỉ Mua hàng</label>
                        <input type="text" class = "form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diachiMuaHang%>">
                    </div>
                    <div class = "mb-3">
                        <label for="diaChiNhanHang" class = "form-label">Địa chỉ Nhận hàng</label>
                        <input type="text" class = "form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diachiNhanHang%>" >
                    </div>
                    <div class = "mb-3">
                        <label for="dienThoai" class = "form-label">Số Điện Thoại</label>
                        <input type="tel" class = "form-control" id="dienThoai" name="soDienThoai" value="<%=soDienThoai%>">
                    </div>
                    <div class = "mb-3">
                        <label for="email" class = "form-label">Email</label>
                        <input type="email" class = "form-control" id="email" name="email" value="<%= email%>" >
                    </div>
                    <hr/>
                    <div class = "mb-3">
                        <label for="dongYDieuKhoan" class = "form-label">Đồng ý với điều khoản công ty<span class ="red">*</span></label>
                        <input type="checkbox" class = "form-check-input" id="dongYDieuKhoan" name="dongYDieuKhoan" required="required" onchange="xuLichonDongY()">
                    </div>
                    <div class = "mb-3">
                        <label for="dongYNhanMail" class = "form-label">Đồng ý Nhận Email</label>
                        <input type="checkbox" class = "form-check-input" id="dongYNhanMail" name="dongYNhanMail" >
                    </div>
                <input  type="submit" class = "btn btn-primary form-control" name="submit" value="Đăng Kí" id="submit" style="visibility: hidden;">
            </div>
        </div>
    </form>
</div>

</body>
<script>

    function kiemTraMatKhau(){
        var matKhau = document.getElementById("matKhau").value;
        var xacNhanMatKhau = document.getElementById("xacNhanMatKhau").value;
        if (matKhau !== xacNhanMatKhau) {
           document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
            return false;
        }else{
            document.getElementById("msg").innerHTML = "";
            return true;
        }
    }
    function xuLichonDongY() {
        var dongYDieuKhoan = document.getElementById("dongYDieuKhoan");
        if (dongYDieuKhoan.checked && kiemTraMatKhau()) {
            document.getElementById("submit").style.visibility = "visible";
        } else {
            document.getElementById("submit").style.visibility = "hidden";
        }

    }
</script>
</html>
