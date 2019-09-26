<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 2019-07-21
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
    <div class="col-lg-12 col-sm-12">
        <form action="simple.act">
            <input type="text" name="sentence" size="100"/>
            <button type="submit">OK</button>
        </form>
    </div>
</div>
<c:if test="${ requestScope.get('mp3Path') != null}">
    <div class="row">
        <div class="col-lg-12 col-sm-12">
            <audio controls>
                <source src="horse.mp3" type="audio/mpeg">
            </audio>
        </div>
    </div>
</c:if>

