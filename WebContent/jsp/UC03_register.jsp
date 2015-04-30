<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><bean:message key="message.register.title.pagetitle"/></title>
    <link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
	</head>
	<body class="container">
		<h1><bean:message key="message.register.title.headertitle"/></h1>
		<hr />
    <ul class="list-group">
      <html:errors/>
    </ul>
    <html:form styleClass="form-horizontal" action="register">
      <div class="form-group">
		    <label for="login" class="col-sm-3 control-label">
		      <bean:message key="message.register.input.name.login"/>
	      </label>
	      <div class="col-sm-5">
	        <html:text styleClass="form-control" styleId="login" property="login" /> 
	      </div>
	    </div>
	    <div class="form-group">
		    <label for="password" class="col-sm-3 control-label">
		      <bean:message key="message.register.input.name.password"/>
		    </label>
		    <div class="col-sm-5"> 
		      <html:password styleClass="form-control" styleId="password" property="password"/>
		    </div>
	    </div>
	    <div class="form-group">
        <label for="password-repeat" class="col-sm-3 control-label">
          <bean:message key="message.register.input.name.repeat_password"/>
        </label>
        <div class="col-sm-5"> 
          <html:password styleClass="form-control" styleId="password-repeat" property="repeatPassword"/>
        </div>
      </div>
	    <br />
	    <div class="form-group">
	      <div class="col-sm-offset-3 col-sm-9">
			    <html:submit property="submit" styleClass="btn btn-success">
			      <bean:message key="message.register.button.name.submit"/>
			    </html:submit>
		      <html:reset property="reset" styleClass="btn btn-danger">
		        <bean:message key="message.register.button.name.reset"/>
		      </html:reset>
		      <a class="btn btn-primary col-sm-offset-1" href="/Javaquarium/jsp/UC00_login.jsp">
            <bean:message key="message.register.button.login"/>
          </a>
	      </div>
      </div>
    </html:form>
	</body>
</html>