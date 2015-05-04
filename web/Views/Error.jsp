<%-- 
    Document   : Error
    Created on : Apr 29, 2015, 3:43:04 PM
    Author     : EH5024424
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header><h1>Error</h1></header>
        <div>
            Unfortunately, there was an error during your transaction. Your transaction details may not have been saved. Please contact a bank teller for assistance.<br>
            <form method="link">
                <input type="submit" value="Quit" formaction="SplashScreen.jsp"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
