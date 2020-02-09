<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>login</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <form id="loginform" action="${pageContext.request.contextPath}/login.do" method="POST">
        ${msg}
        <table>
            <tr>
                <td>用户名</td>
                <td>
                    <input id="name" type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input id="password" type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    <input id="submit" type="submit"  value="login">
                </td>
            </tr>
        </table>
        <label id="searchResult"></label>
    </form>
</body>
</html>
<script type="text/javascript">
    function fnsubmit() {
        alert("ajax");
       /* $.ajaxSettings.async = true;
        $.ajax({
            type:"POST",
            url:"login.do",
            data:{"name":$("#name").val(),"password":$("#password").val()},
            contentType:"application/json;charset=utf-8"
    });*/
        $.ajaxSettings.async = true;
        $.post("login.do", {"name":$("#name").val(),"password":$("#password").val()}, function(result) {
            // 请求处理
        },"json");
    }
</script>
