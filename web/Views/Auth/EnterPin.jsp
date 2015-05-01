<%-- 
    Document   : Login
    Created on : Apr 27, 2015, 3:53:52 PM
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
        <h1>Please enter your pin number:</h1>
        <s:form action="EnterPin">
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Pin #</s:label>
            <s:textfield name="pinNumber"/>
            <s:submit>Submit</s:submit>
        </s:form>
    </body>
</html>
