<%@page import="com.javaquarium.action.LoginAction"%>
<%@page import="com.javaquarium.action.AjoutUserPoissonAction"%>
<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@page import="com.javaquarium.util.SessionUtils"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="message.listerespece.title.pagetitle" /></title>
<link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>
		<bean:message key="message.listerespece.title.headertitle" />
		<%=request.getSession().getAttribute(LoginAction.SESSION_USERNAME)%></h1>
	<hr />
	<p style="display: block; float: left;">
		<b><bean:message key="message.listerespece.title.aquarium" /></b>
	</p>
	<p style="display: block; float: left; margin-left: 3px;">(</p>
	<p style="display: block; float: left;">
		<b><%=SessionUtils.countNumberOfPoisson(request.getSession().getAttribute(
					AjoutUserPoissonAction.SESSION_USER_POISSONS))%></b>
	</p>
	<p style="display: block; float: left; margin-right: 10px;">)</p>
	<div class="btn-group" style="float: left;">
		<a class="btn btn-xs btn-success"
			href="/Javaquarium/sauvegarderUserPoisson.do">
			<span class="glyphicon glyphicon-ok-sign"></span>
			<bean:message key="message.listerespece.button.save.espece.title" />
		</a>
		<a class="btn btn-xs btn-danger" href="/Javaquarium/viderUserPoisson.do">
			<span class="glyphicon glyphicon-remove-sign"></span>
			<bean:message key="message.listerespece.button.empty.espece.title" />
		</a>
	</div>
	<br>
	<br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th><bean:message key="message.listerespece.table.title.name" /></th>
				<th><bean:message
						key="message.listerespece.table.title.description" /></th>
				<th><bean:message key="message.listerespece.table.title.color" /></th>
				<th><bean:message
						key="message.listerespece.table.title.dimension" /></th>
				<th><bean:message key="message.listerespece.table.title.price" /></th>
				<th><bean:message
						key="message.listerespece.table.title.aquarium" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="<%=ListerEspeceAction.SESSION_LIST_POISSON%>"
				id="currentPoisson">
				<tr>
					<td><bean:write name="currentPoisson" property="espece" /></td>
					<td><bean:write name="currentPoisson" property="description" /></td>
					<td><bean:write name="currentPoisson" property="couleur" /></td>
					<td><bean:write name="currentPoisson" property="dimension" /></td>
					<td><bean:write name="currentPoisson" property="prix" /></td>
					<td><a class="btn btn-xs btn-success"
						href="/Javaquarium/ajoutUserPoisson.do?espece=<bean:write 
						name="currentPoisson" property="espece" />">
						<bean:message key="message.listerespece.button.add" />
					</a>
					<a class="btn btn-xs btn-danger"
						href="/Javaquarium/enleverUserPoisson.do?espece=<bean:write 
						name="currentPoisson" property="espece" />">
						<bean:message key="message.listerespece.button.remove" />
					</a>
					</td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
	<a class="btn btn-xs btn-primary"
		href="/Javaquarium/jsp/UC02_ajout.jsp"> <span
		class="glyphicon glyphicon-plus-sign"></span> <bean:message
			key="message.listerespece.button.ajout.espece.title" />
	</a>
</body>
</html>