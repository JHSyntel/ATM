<%-- 
    Document   : ChangePin
    Created on : Apr 27, 2015, 3:55:03 PM
    Author     : JH5024430
--%>

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
        <header><h1>Please swipe (input card number) your card.</h1></header>
        <s:form>
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Confirm Current Pin #</s:label>
            <s:textfield name="currentPinNumber"/>
            <br>
            <s:label>New Pin #</s:label>
            <s:textfield name="newPinNumber"/>
            <br>
            <s:label>Confirm New Pin #</s:label>
            <s:textfield name="confirmNewPinNumber"/>
            <br>
            <s:submit value="Change Pin" formaction="ChangePin"/>
            <s:submit value="Cancel" formaction="/ATM/Views/MainMenu.jsp"/>
        </s:form>
    </body>
    <footer></footer>
</html>
