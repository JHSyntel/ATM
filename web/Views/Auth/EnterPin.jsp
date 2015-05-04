<%-- 
    Document   : Login
    Created on : Apr 27, 2015, 3:53:52 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "EnterPin";
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
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Please enter your pin number:</h1></header>
        <s:form action="EnterPin">
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Pin #</s:label>
            <s:textfield name="pinNumber"/>
            <s:submit/>
        </s:form>
    </body>
    <footer></footer>
</html>
