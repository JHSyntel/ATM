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
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Confirm the Amount on Your Check</h1></header>
        <div>
            <img src="/ATM/Views/Deposits/scannedcheck.jpg"/><br>
            (Please note that this is an example check.)<br>
            You deposited: <s:property value="getText('{0,number,currency}', {depositcheckamt})"/>
            <s:form method="link">
                <s:submit value="Yes" formaction="Deposit"/>
                <s:submit value="No" formaction="/ATM/Views/Deposits/WrongAmount.jsp"/>
            </s:form>
        </div>
    </body>
    <footer></footer>
</html>
