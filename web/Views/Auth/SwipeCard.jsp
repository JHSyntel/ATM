<%-- 
    Document   : SwipeCard
    Created on : Apr 27, 2015, 3:59:33 PM
    Author     : JH5024430
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Please swipe your card (input number):</h1>
        <s:form action="SwipeCard">
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Card Number</s:label>
            <s:textfield name="cardNumber"/>
            <s:submit value="Swipe Card"/>
        </s:form>
    </body>
</html>