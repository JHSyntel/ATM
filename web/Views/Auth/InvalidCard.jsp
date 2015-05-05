<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "InvalidCard";
    int authStatus = Authentication.authCheck();
    if(authStatus == -1) { %>
        <jsp:forward page="/Views/Auth/NoSession.jsp"/> 
<%  }
    if(authStatus == 0) { %>
    <jsp:forward page="/Views/Auth/NotAuthorized.jsp"/>
<%  }  
    System.out.println("authCheck at " + ACTIONNAME + " action is " + authStatus);
%>

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
        <header><h1>Invalid Card</h1></header>
        <div>
            Please try again or see a teller for assistance.<br><br>
            <form method="link">
                <input type="submit" value="Try Again" formaction="SwipeCard"/>
                <input type="submit" value="Quit" formaction="SignoutAct"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
