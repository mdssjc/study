<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mds" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <mds:header />

    <h2>Usuário não logado</h2>

    <form action="doLogin" method="post">
        <fieldset>
            <legend>Login</legend>
            <label for="login">Usuário: </label>
            <input id="login" name="login" type="text" />
            <br />
            <label for="password">Senha: </label>
            <input id="password" name="password" type="password" />
            <br />
            <input type="submit" value="Entrar" />
        </fieldset>
    </form>

    <mds:footer />
</body>
</html>
