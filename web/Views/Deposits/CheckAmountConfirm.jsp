<%-- 
    Document   : CheckAmountConfirm
    Created on : Apr 24, 2015, 10:01:41 AM
    Author     : EH5024424
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Confirm the Amount on Your Check</h1>
        <div>
            Picture of check.<br>
            <s:property value="depositcheckamt"/>
            <s:form action="Deposit">
                <s:submit value="Yes"/>
            </s:form>
            <a href="WrongAmount.jsp"><s:submit value="No"/></a>
        </div>
    </body>
</html>
