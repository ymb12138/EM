<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>事件信息修改页面</title>
    <style>
        .divcenter {
            width: 850px;
            height: 400px;
           /*  background-color: papayawhip; */
            /* margin: auto;使div块居中显示 */
            margin: auto;
        }
    </style>
</head>
<body>
<div class="divcenter">
    <div style="height: 10px"></div>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    
     <div align="center">
			<h2><font color="red">请修改事项信息</font></h2><br>
		</div>
		
    <form action="../alterEvent" style="text-align: center" method="post">
        <table align="center">
            <tr>
                <td>编号：</td>
                <%-- readonly属性规定字段只能读，不能编辑修改--%>
                <td><input id="id" name="id" value="<%=request.getParameter("id") %>" required readonly onclick="alert('编号不可修改')"></td>
            </tr>
            <tr>
                <td>内容：</td>
                <%--  required 属性规定必需在提交表单之前填写输入字段  --%>
                <td><input id="event" name="event" value="<%=new String(request.getParameter("event").getBytes("ISO8859_1"),"utf-8")%>" required>
            </tr>
            <tr>
                <td>级别：</td>
                <td><input id="level" name="level" value="<%=new String(request.getParameter("level").getBytes("ISO8859_1"),"utf-8")%>"></td>
            </tr>
            <tr>
                <td>截止时间：</td>
                <td><input type="datetime-local" id="endDateStr" name="endDateStr" required></td>
            </tr>
        </table>
        <table align="center">
            <tr style="text-align: center">
                <td>
                    <input type="submit" value="确认修改">
                </td>
                <td>
                    <input type="button" value="返回" onclick="window.location.href='find'">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
