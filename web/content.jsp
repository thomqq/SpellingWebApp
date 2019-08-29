<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 2019-07-21
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<input type="text" value="${ param.get("mp3Path")}">
<form action="simple.act">
    <input type="text" name="sentence"/>
    <button type="submit" >OK</button>
</form>