<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<%@ attribute name="id" required="true"%>
<%@ attribute name="value" type="java.time.LocalDate" required="false"%>

<fmt:parseDate value="${value}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
<input id="${id}" name="${id}"
    value="<fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy" var="value" type="date" />" />

<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy'
	});
</script>
