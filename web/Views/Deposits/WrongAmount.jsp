<%-- 
    Document   : WrongAmount
    Created on : Apr 24, 2015, 10:08:01 AM
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
        <h1>Retrieve Your Deposit</h1>
        <div>
            <img src="depositslot.jpeg"/><br>
            Please try again or see a teller for assistance.<br>
            <form method="link">
                <input type="submit" value="Try Again" formaction="SelectDepositType.jsp"/>
                <input type="submit" value="Quit"/>
            </form>
        </div>
    </body>
</html>
