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
        <header><h1>Invalid Pin</h1></header>
        <div>
            Please try again or see a teller for assistance.<br><br>
            <form method="link">
                <input type="submit" value="Try Again" formaction="EnterPin"/>
                <input type="submit" value="Quit" formaction="ATM/Views/Landing.jsp"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
