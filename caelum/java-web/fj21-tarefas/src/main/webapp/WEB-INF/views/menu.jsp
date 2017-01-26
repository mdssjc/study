<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mds" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>
</head>
<body>
    <mds:header />

    <h2>Página inicial da Lista de Tarefas</h2>

    <p>
        Bem vindo, ${validUser.login} (<a href="logout">Sair do sistema</a>)
    </p>
    <p>
        <a href="listAll">Clique aqui</a> para acessar a lista de tarefas.
        <br />
        <a href="egg">!!!<a/>
    </p>

    <mds:footer />
</body>
</html>
