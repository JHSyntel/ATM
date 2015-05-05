<%-- 
    Document   : SplashScreen
    Created on : Apr 28, 2015, 12:49:35 PM
    Author     : KB5024427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Welcome to Bank of Kyle's ATM service!</h1></header>
        <form method="link">
            <input type="submit" value ="START" formaction="/ATM/Views/Auth/SwipeCard.jsp"/>
        </form>
        <footer></footer>
    </body>
</html>
