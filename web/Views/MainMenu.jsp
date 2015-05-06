<%-- 
    Document   : MainMenu
    Created on : Apr 27, 2015, 4:07:18 PM
    Author     : KB5024427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Main Menu</h1></header>
        <form>
            <input type="submit" value="Withdraw" formaction="WithdrawSelected"/>
            <input type="submit" value="Deposit" formaction="DepositSelected"/>
            <input type="submit" value="View Summary" formaction="SummarySelected"/>
            <input type="submit" value="Print Mini Statement" formaction="StatementSelected"/>
            <input type="submit" value="Change Pin" formaction="ChangePinSelected"/>
            <input type="submit" value="Logout" formaction="SignoutAct"/>
        </form>
    </body>
    <footer></footer>
</html>
