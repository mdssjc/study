<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mds" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>Contatos</title>
</head>
<body>
    <mds:header name="Marcelo" />

    <form action="do?cmd=SaveContactLogic" method="post">
        <p>${contato.id}</p>
        <input id="id" name="id" type="hidden" value="${contato.id}" />
        <label for="nome">Nome: </label>
        <input id="nome" name="nome" type="text" value="${contato.nome}" />
        <br />
        <label for="email">E-mail: </label>
        <input id="email" name="email" type="text" value="${contato.email}" />
        <br />
        <label for="endereco">Endereço: </label>
        <input id="endereco" name="endereco" type="text" value="${contato.endereco}" />
        <br />
        <label for="dataNascimento">Data Nascimento: </label>
        <mds:fieldDate id="dataNascimento" value="${contato.dataNascimento}" />
        <br />
        <input type="submit" value="Gravar" />
    </form>
    <br />
    <br />
    <a href="do?cmd=ListContactLogic">Listar</a>

    <mds:footer />
</body>
</html>
