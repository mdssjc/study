<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mds" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contatos</title>
</head>
<body>
    <mds:header name="Marcelo" />

    <table>
        <c:forEach var="contato" items="${contatos}">
            <tr>
                <td>${contato.nome}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:when>
                        <c:otherwise>
                            <p>E-mail não informado</p>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${contato.endereco}</td>
                <td>
                    <fmt:parseDate value="${contato.dataNascimento}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                    <fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy" type="date" />
                </td>
                <td>
                    <a href="do?cmd=RemoveContactLogic&id=${contato.id}">Remover</a>
                </td>
                <td>
                    <a href="do?cmd=UpdateContactLogic&id=${contato.id}">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <mds:footer />
</body>
</html>
