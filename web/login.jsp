<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 2019-07-21
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">Logowanie</h1>
    <label for="inputLogin" class="sr-only">Login</label>
    <input type="text" name="login" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
    <label for="inputPassword" class="sr-only">Hasło</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <div class="checkbox mb-3">
        <label>
            <input name="remeber" type="checkbox" value="remember-me"> Zapamiętaj mnie
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Logowanie</button>
</form>