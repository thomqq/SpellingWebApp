<%--
  Created by IntelliJ IDEA.
  User: tkudas
  Date: 19.07.2019
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="/FrontController" />
<html>
  <head>
    <title>${requestScope.get("title")}</title>
  </head>
  <body>
  ${requestScope.get("title")}
  </body>
</html>
