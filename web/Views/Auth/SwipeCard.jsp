<%-- 
    Document   : SwipeCard
    Created on : Apr 27, 2015, 3:59:33 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.ChangePinNum"%>
<%@page import="java.util.Map"%>
<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "SwipeCard";
    Boolean authStatus = Authentication.sessionActiveCheck();
    System.out.println("session at " + ACTIONNAME + " action is " + authStatus);
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
        <header><h1>Please swipe your card (input number):</h1></header>
        <s:form action="SwipeCard">
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Card Number</s:label>
            <s:textfield name="cardNumber"/>
            <s:submit value="Swipe Card"/>
        </s:form>
    </body>
    <footer></footer>
</html>
