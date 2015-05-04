<%-- 
    Document   : SelectDepositType
    Created on : Apr 24, 2015, 9:57:37 AM
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
        <h1>Select Deposit Type</h1>
        <div>
            <form method="link">
                <input type="submit" value="Cash" formaction="/ATM/Views/Deposit/InsertCash.jsp"/>
                <input type="submit" value="Check" formaction="/ATM/Views/Deposit/InsertCheck.jsp"/>
                <input type="submit" value="Back" formaction="/ATM/Views/SelectAccount.jsp"/>
            </form>
        </div>
    </body>
</html>
