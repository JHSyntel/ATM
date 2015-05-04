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
            You deposited: <s:property value="getText('{0,number,currency}', {depositcashamt})"/>
            <s:form method="link">
                <s:submit value="Yes" formaction="Deposit"/>
                <s:submit value="No" formaction="/ATM/Views/Deposit/WrongAmount.jsp"/>
            </s:form>
            
            
        </div>
    </body>
</html>
