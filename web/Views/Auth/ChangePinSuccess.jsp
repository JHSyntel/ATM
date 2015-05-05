<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "ChangePinSuccess";
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
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Change Pin Successful</h1></header>
        <div>
            Please select an option.<br><br>
            <form method="link">
                <input type="submit" value="Return to Main Menu" formaction="/ATM/Views/MainMenu.jsp"/>
                <input type="submit" value="Quit" formaction="SignoutAct"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
