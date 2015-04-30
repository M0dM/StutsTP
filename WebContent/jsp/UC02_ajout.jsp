<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><bean:message key="message.ajout.title.pagetitle"/></title>
    <link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
	</head>
	<body class="container">
		<h1><bean:message key="message.ajout.title.headertitle"/></h1>
		<hr />
    <ul class="list-group">
      <html:errors/>
    </ul>
    <html:form styleClass="form-horizontal" action="ajout">
      <div class="form-group">
		    <label for="espece" class="col-sm-3 control-label">
		      <bean:message key="message.ajout.input.title.name"/>
	      </label>
	      <div class="col-sm-5">
	        <html:text styleClass="form-control" styleId="espece" property="espece" /> 
	      </div>
	    </div>
	    <div class="form-group">
		    <label for="description" class="col-sm-3 control-label">
		      <bean:message key="message.ajout.input.title.description"/>
		    </label>
		    <div class="col-sm-5"> 
		      <html:textarea styleClass="form-control" styleId="description" property="description"/>
		    </div>
	    </div>
	    <div class="form-group">
        <label for="couleur" class="col-sm-3 control-label">
          <bean:message key="message.ajout.input.title.color"/>
        </label>
        <div class="col-sm-5"> 
          <html:text styleClass="form-control" styleId="couleur" property="couleur"/>
        </div>
      </div>
      <div class="form-group">
        <label for="prix" class="col-sm-3 control-label">
          <bean:message key="message.ajout.input.title.price"/>
        </label>
        <div class="col-sm-5"> 
          <html:text styleClass="form-control" styleId="prix" property="prix"/>
        </div>
      </div>
      <div class="form-group">
        <label for="dimension" class="col-sm-3 control-label">
          <bean:message key="message.ajout.input.title.dimensions"/>
        </label>
        <div class="col-sm-5"> 
          <html:text styleClass="form-control" styleId="dimension" property="dimension"/>
        </div>
      </div>
	    <br />
	    <div class="form-group">
	      <div class="col-sm-offset-3 col-sm-9">
			    <html:submit property="submit" styleClass="btn btn-success">
			      <bean:message key="message.ajout.button.name.submit"/>
			    </html:submit>
		      <html:reset property="reset" styleClass="btn btn-danger">
		        <bean:message key="message.ajout.button.name.reset"/>
		      </html:reset>
	      </div>
      </div>
    </html:form>
	</body>
</html>