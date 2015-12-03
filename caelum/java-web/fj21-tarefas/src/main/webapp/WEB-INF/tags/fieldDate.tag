<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<%@ attribute name="id" required="true"%>
<%@ attribute name="value" type="java.util.Calendar" required="false"%>

<input id="${id}" name="${id}"
    value="<fmt:formatDate value="${value.time}" pattern="dd/MM/yyyy" />" />

<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy'
	});
</script>