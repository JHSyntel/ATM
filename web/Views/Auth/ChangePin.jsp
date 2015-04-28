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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Please swipe (input card number) your card.</h1>
        <S:form action="ChangePin">
            <s:label>Confirm Current Pin #</s:label>
            <s:textfield name="currentPin"/>
            <s:label>New Pin #</s:label>
            <s:textfield name="newPin"/>
            <s:label>Confirm New Pin #</s:label>
            <s:textfield name="newPinDupe"/>
            <s:submit name="submit">Submit</s:submit>
            <s:submit name="cancel">Cancel</s:submit>
        </S:form>
    </body>
</html>
