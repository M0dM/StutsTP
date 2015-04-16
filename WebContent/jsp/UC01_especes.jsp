<%@page import="com.javaquarium.action.LoginAction"%>
<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><bean:message key="message.listerespece.title.pagetitle"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	</head>
	<body class="container">
		<h1><bean:message key="message.listerespece.title.headertitle"/> <%= request.getSession().getAttribute(LoginAction.SESSION_USER) %></h1>
		<hr />
		<a class="btn btn-xs btn-success" href="/Javaquarium/jsp/UC02_ajout.jsp">
		  <span class="glyphicon glyphicon-plus-sign"></span> <bean:message key="message.listerespece.button.ajout.espece.title"/>
	  </a>
	  <br>
	  <br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><bean:message key="message.listerespece.table.title.name"/></th>
					<th><bean:message key="message.listerespece.table.title.description"/></th>
					<th><bean:message key="message.listerespece.table.title.color"/></th>
					<th><bean:message key="message.listerespece.table.title.dimension"/></th>
					<th><bean:message key="message.listerespece.table.title.price"/></th>
					<th><bean:message key="message.listerespece.table.title.detail"/></th>
					<th><bean:message key="message.listerespece.table.title.aquarium"/></th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate name="<%= ListerEspeceAction.SESSION_LIST_POISSON %>" id="currentPoisson">
					<tr>
						<td><bean:write name="currentPoisson" property="espece" /></td>
						<td><bean:write name="currentPoisson" property="description" /></td>
						<td><bean:write name="currentPoisson" property="couleur" /></td>
						<td><bean:write name="currentPoisson" property="dimension" /></td>
						<td><bean:write name="currentPoisson" property="prix" /></td>
						<td><a class="btn btn-xs btn-info" href="#detail"><bean:message
									key="message.listerespece.button.detail" /></a></td>
						<td><a class="btn btn-xs btn-success" href="#ajouter"><bean:message
									key="message.listerespece.button.add" /></a> <a
							class="btn btn-xs btn-danger" href="#remove"><bean:message
									key="message.listerespece.button.remove" /></a></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</body>
</html>