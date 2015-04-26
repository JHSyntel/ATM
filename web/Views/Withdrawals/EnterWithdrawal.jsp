<%-- 
    Document   : EnterWithdrawal
    Created on : Apr 24, 2015, 9:56:06 AM
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
        <h1>Enter Amount to Withdraw</h1>
        <div>
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:form action="withdraw">
                <s:textfield name="withdrawamt" size="10"/>
                <s:submit value="Enter"/>
            </s:form>
        </div>
    </body>
</html>
