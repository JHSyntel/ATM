<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Invalid Card</h1>
        <div>
            Please try again or see a teller for assistance.<br><br>
            <form method="link">
                <input type="submit" value="Try Again" formaction="SwipeCard.jsp"/>
                <input type="submit" value="Quit"/>
            </form>
        </div>
    </body>
</html>
