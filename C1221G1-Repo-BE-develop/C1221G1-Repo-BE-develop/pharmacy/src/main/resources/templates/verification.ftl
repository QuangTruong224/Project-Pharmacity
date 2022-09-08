<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#7ed957" style="padding: 40px 0 30px 0;">
            <img src="https://i.ibb.co/yYRSH4y/Pharmarcode.png" alt="https://www.pharmacode.com" style="height: 50%; width: 50%; display: block;" />
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 10px 30px 10px 30px;">
            <p>Chào <b>${name}</b>,</p>
            <br>
            <p>Cảm ơn bạn đã lựa chọn Pharmacode!</p>
            <p>Vui lòng truy cập vào  <a href="http://localhost:4200/log/verify/${token}/${name}">đường dẫn này</a> để xác thực tài khoản của bạn</p>
            <p>Rất hân hạnh được phục vụ</p>
            <br>
            <p>Trân trọng! </p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
            <p style="color: white"> <b>${signature}</b></p>
            <p style="color: white">${location}</p>
        </td>
    </tr>
</table>

</body>
</html>