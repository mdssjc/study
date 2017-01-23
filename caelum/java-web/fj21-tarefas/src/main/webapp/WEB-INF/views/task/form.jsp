<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar tarefas</title>
</head>
<body>
    <h3>Adicionar tarefas</h3>
    <form:errors path="task.descricao" cssStyle="color: red"/>
    <form action="newTask" method="post">
        Descrição:
        <br />
        <textarea name="descricao" rows="5" cols="100"></textarea>
        <br />
        <input type="submit" value="Adicionar">
    </form>
</body>
</html>
