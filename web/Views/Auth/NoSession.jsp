<%-- 
    Document   : NotAuthorized
    Created on : May 1, 2015, 2:24:58 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "NoSession.jsp";
    int authStatus = Authentication.authCheck();
    if(authStatus == -1) { %>
        <jsp:forward page="/Views/Auth/NoSession.jsp"/> 
<%  }
    if(authStatus == 1) { %>
    <jsp:forward page="/Views/Auth/NotAuthorized.jsp"/>
<%  }  
    System.out.println("authCheck at " + ACTIONNAME + " action is " + authStatus);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>No user session!</h1>
        <form>
            <input type="submit" value="Back" formaction="/ATM/Views/SplashScreen.jsp"/>
        </form>
    </body>
</html>
