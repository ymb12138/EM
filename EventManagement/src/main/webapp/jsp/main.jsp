<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>

        body{
            background-color: #9bfaff;
            /* overflow: auto;当内容溢出时添加滚动条 */
            overflow: auto;
            /* margin: auto;使div块居中显示 */
            margin: auto;
        }
        td, th {
            /* white-space: nowrap; 文本不换行显示 */
            white-space: nowrap;
            width: 70px;
            height: 35px;
            /*text-align: center;文本居中显示*/
            text-align: center;
            padding: 4px 8px;
        }
        input{
            padding: 4px 8px
        }
    </style>
    <title>待办事项信息</title>
    <%--<link rel="stylesheet" type="text/css" href="css/sims2.css">--%>
</head>
<body>

<div class="div_middle1" align="center">
    <div>
        <h1><font color="red">欢迎使用待办事项管理系统！</font></h1>
    </div>
    <%-- style="text-align: center; 使form表单居中显示 --%>
    <form action="findByEvent" class="text_center" style="margin-top: 10px" method="post" >
        <input id="event" name="event" placeholder="按内容查询">
        <input type="submit" value="查询">
        <input type="button" value="增加待办事项" onclick="window.location.href='jsp/eventAddForm.jsp'">
        <input type="button" value="首页列表" onclick="window.location.href='find'">
        <input type="button" value="下载事项" onclick="window.location.href='download'"><font color="red">${message}</font>
        <hr>
    </form>
    <form action="find" class="text_center" style="margin-top: 10px" method="post">
        距离截止时间<input type="text" name="time" id="time" placeholder="24" value="${t}" >小时以内提醒
        <input type="submit" value="确定">
    </form>
    <table border="1" cellspacing="0" align="center">
        <tr>
            <th>编号</th>
            <th>内容</th>
            <th>级别</th>
            <th>创建时间</th>
            <th>截止时间</th>
            <%--  colspan属性用于将指定的横向单元格合并  --%>
            <th colspan="3">操作</th>
        </tr>
        <c:forEach items="${events}" var="event">
            <tr id="${event.id}">
                <td>${event.id}</td>
                <td>${event.event}</td>
                <td>${event.levelStr}</td>
                <td>${event.startDateStr}</td>
                <td>${event.endDateStr}</td>
                <td>
                    <a href="./jsp/eventModForm.jsp?id=${event.id}&event=${event.event}&level=${event.level}&endDate=${event.endDate}"
                       style="text-decoration: none;color: black" ><font color="red">修改</font></a>
                </td>
                <td>
                    <a href="./deleteEvent?id=${event.id}" style="text-decoration: none;color: black"><font color="red">删除</font></a>
                </td>
                <td>${event.status}</td>
            </tr>
        </c:forEach>
    </table>
<br/>
<br/>
    <h3><font color="red">以下事件即将超时，请尽快处理！</font></h3>

    <table border="1" cellspacing="0" align="center">
        <tr>
            <th>编号</th>
            <th>内容</th>
            <th>级别</th>
            <th>剩余时间（小时）</th>
            <th>创建时间</th>
            <th>截止时间</th>
        </tr>
        <c:forEach items="${list}" var="event">
            <tr id="${event.id}">
                <td>${event.id}</td>
                <td>${event.event}</td>
                <td>${event.levelStr}</td>
                <td>${event.rdate}</td>
                <td>${event.startDateStr}</td>
                <td>${event.endDateStr}</td>
        </c:forEach>
    </table>
</div>
</body>
</html>
