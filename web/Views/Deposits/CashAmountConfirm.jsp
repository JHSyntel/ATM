<%-- 
    Document   : CashAmountConfirm
    Created on : Apr 24, 2015, 10:04:44 AM
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
        <h1>Confirm Amount Deposited</h1>
        <div>
            <s:property value="depositcashamt"/>
            <s:form action="Deposit">
                <s:submit value="Yes"/>
            </s:form>
            <a href="WrongAmount.jsp"><s:submit value="No"/></a>
        </div>
    </body>
</html>
