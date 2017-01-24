<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mds" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>Alterar Tarefa</title>
</head>
<body>
    <h3>Alterar tarefa - ${tarefa.id}</h3>
    <form action="updateTask" method="post">
        <input type="hidden" name="id" value="${tarefa.id}" />
        Descrição:
        <br />
        <textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
        <br />
        Finalizado? <input type="checkbox" name="finalizado"
            value="true" ${tarefa.finalizado? 'checked' : '' } />
        <br />
        Data de finalização:
        <br />
        <mds:fieldDate id="dataFinalizacao" value="${tarefa.dataFinalizacao}" />
        <br />
        <input type="submit" value="Alterar" />
    </form>
</body>
</html>
