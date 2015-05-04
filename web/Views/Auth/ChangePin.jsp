<%-- 
    Document   : ChangePin
    Created on : Apr 27, 2015, 3:55:03 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "ChangePin";
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Please swipe (input card number) your card.</h1>
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
</html>
