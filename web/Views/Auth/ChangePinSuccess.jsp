<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Change Pin Successful</h1></header>
        <div>
            Please select an option.<br><br>
            <form method="link">
                <input type="submit" value="Return to Main Menu" formaction="/ATM/Views/MainMenu.jsp"/>
                <input type="submit" value="Quit" formaction="ATM/Views/Landing.jsp"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
