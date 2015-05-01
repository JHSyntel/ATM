<%-- 
    Document   : RetrieveCash
    Created on : Apr 24, 2015, 10:17:03 AM
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
        <h1>Retrieve Your Withdrawal</h1>
        <div>
            <a href="/ATM/Views/Withdrawals/WithdrawalSuccess.jsp"><img src="/ATM/Views/Withdrawals/cashslot.jpeg" alt="Submit"/></a><br>
            (Press the image to simulate retrieving your withdrawal of <s:property value="getText('{0,number,currency}', {withdrawamt})"/>.)
        </div>
    </body>
</html>
