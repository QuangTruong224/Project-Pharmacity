<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }

        ul {
            padding-left: 0;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="700" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#7ed957" style="padding: 40px 0 30px 0;">
            <img src="https://i.ibb.co/yYRSH4y/Pharmarcode.png" alt="https://www.pharmacode.com" style="height: 30%; width: 30%; display: block;"/>
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 10px 30px 10px 30px;">
            <p>Chào <b>${customer.customerName}</b>,</p>
            <br>
            <p>Cảm ơn bạn đã lựa chọn Pharmacode! Đơn hàng của bạn đã được xác nhận.</p>
            <ul>Thông tin nhận hàng:
                <li>Tên người nhận: <b> ${customer.customerName}</b></li>
                <li>Số điện thoại: <b>${customer.customerPhone}</b></li>
                <li>Địa chỉ: <b>${customer.customerAddress}</b></li>
            </ul>
            <p>Chi tiết đơn hàng:</p>
            <hr>
            <table>
                <tr style="padding-bottom: 2px">
                    <td width="400" colspan="2"><b>Sản Phẩm</b></td>
                    <td width="100"><b>Số lượng</b></td>
                    <td width="150"><b>Giá</b></td>
                </tr>
                <#list cartDetailDtos as detail>
                    <tr>
                        <td width="50">
                            <div style="width: 40px; height: 50px">
                                <img style="height: 100%; width: 100%;"
                                     src="${detail.medicine.medicineImage}" alt="medicineImage">
                            </div>
                        </td>
                        <td width="350">
                            <b>${detail.medicine.medicineName}</b>
                        </td>
                        <td width="100">
                            ${detail.quantity}
                        </td>
                        <td width="100">
                            ${detail.medicine.medicinePrice} VND
                        </td>
                    </tr>
                </#list>
            </table>
            <hr>
            <br>
            <table>
                <tr>
                    <td width="200">Tổng tiền hóa đơn:</td>
                    <td>${total} VND</td>
                </tr>
                <tr>
                    <td width="200">Giảm giá:</td>
                    <td>${discount} %</td>
                </tr>
                <tr style="font-size: 16px">
                    <td width="200"><b>Tổng tiền thanh toán:</b></td>
                    <td><b>${totalAfter} VND</b></td>
                </tr>
            </table>
            <p>Đơn hàng của bạn đã được đóng gói và sẽ được giao đến trong thời gian sớm nhất.</p>
            <p>Rất hân hạnh được phục vụ</p>
            <br>
            <p>Trân trọng! </p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
            <p style="color: white"><b>${signature}</b></p>
            <p style="color: white">${location}</p>
        </td>
    </tr>
</table>

</body>
</html>