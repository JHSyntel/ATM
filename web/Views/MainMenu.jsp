<%-- 
    Document   : MainMenu
    Created on : Apr 27, 2015, 4:07:18 PM
    Author     : KB5024427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Main Menu</h1>
        <form>
            <input type="submit" value="Withdraw" formaction="WithdrawSelected"/>
            <br><br>
            <input type="submit" value="Deposit" formaction="DepositSelected"/>
            <br><br>
            <input type="submit" value="View Summary" formaction="SummarySelected"/>
            <br><br>
            <input type="submit" value="Print Mini Statement" formaction="StatementSelected"/>
            <br><br>
            <input type="submit" value="Change Pin" formaction="PinChangeSelected"/>
            <br><br><br><br>
            <input type="submit" value="Logout" formaction="LogoutSelected"/>
        </form>
    </body>
</html>
