<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Tarefas</title>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>
    <script type="text/javascript">
        function finalizaAgora(id) {
            $.post("closeTask", {'id' : id}, function(resposta) {
              $("#tarefa_"+id).html(resposta);
            });
        }
    </script>

    <h1>Tarefas</h1>
    <a href="newForm">Criar nova tarefa</a>

    <br />
    <br />

    <table>
        <tr>
            <th>Id</th>
            <th>Descrição</th>
            <th>Finalizado?</th>
            <th>Data de Finalização</th>
        </tr>
        <c:forEach items="${tasks}" var="tarefa">
            <tr id="tarefa_${tarefa.id}">
                <td>${tarefa.id}</td>
                <td>${tarefa.descricao}</td>
                <c:if test="${tarefa.finalizado eq true}">
                    <td>Finalizado</td>
                </c:if>
                <c:if test="${tarefa.finalizado eq false}">
                    <td><a href="#" onClick="finalizaAgora(${tarefa.id})">Finalizar</a></td>
                </c:if>
                <td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" /></td>
                <td><a href="removeTask?id=${tarefa.id}">Remover</a></td>
                <td><a href="showTask?id=${tarefa.id}">Alterar</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
