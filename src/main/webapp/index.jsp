<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Thong bao</title>
    <meta charset="UTF-8 ">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body, input, button {
            font-family: 'Roboto', Arial, sans-serif;
            margin: 20px;
        }
        input[type="text"] {
            padding: 10px;
            width: 200px;
        }
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
Nhap vao ten cua ban: <input type="text" id="name" name="name"><br>
<button onclick="thongBao()">Submit</button>
<p id="message"></p>

<script>
    function thongBao() {
        var name = document.getElementById('name').value;
        var message = document.getElementById('message');
        if (name === "") {
            message.textContent = "Vui long nhap ten cua ban!";
        } else {
            message.textContent = "Xin chào " + name + "!";
        }
    }
</script>
</body>
</html>