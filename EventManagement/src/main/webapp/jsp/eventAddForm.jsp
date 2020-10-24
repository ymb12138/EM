<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加待办事项</title>
  <style>
        /*  div块居中显示  */
        .divcenter {
            width: 850px;
            height: 400px;
           /*  background-color: aquamarine; */
            /* margin: auto;使div块居中显示 */
            margin: auto;
        }
    </style> 
</head>
<body>
<div class="divcenter">

		<div  align="center">
			<h2><font color="red">请输入事项信息</font></h2>
		</div>
		

    <div style="height: 10px"></div>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    <form action="../addEvent" style="text-align: center;" method="post">
        <%-- 表格使用align="center"居中显示 --%>
        <table align="center">
            <tr>
                <td colspan="2" style="text-align: center">
                    <font style="color: red">* 代表必填项</font>
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><input id="event" name="event" placeholder="请输入" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>优先级：</td>
                <td>
                    <input type="radio" value="1" name="level">1
                    <input type="radio" value="2" name="level">2
                    <input type="radio" value="3" name="level">3
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>截止时间：</td>
                <td>
                    <input type="datetime-local" name="endDateStr" id="endDateStr">
                    <font style="color: red">*</font>
                </td>
            </tr>
        </table>
        <table align="center">
            <tr style="text-align: center">
                <td>
                    <input type="submit" value="增加">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
                <td>
                    <input type="button" value="返回" onclick="window.location.href='../find'">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
