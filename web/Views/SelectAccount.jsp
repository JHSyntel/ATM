<%-- 
    Document   : accountselection
    Created on : Apr 27, 2015, 4:22:09 PM
    Author     : KB5024427
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
        <h1>Select Account</h1>
        <s:form action="SelectAccount">
   
            <s:iterator>
                <s:submit value="%{accountid}" name="accountid"/>
                <br><br>
            </s:iterator>
                
            <br><br><br>
            <s:submit value="Cancel" name="cancel"/>
        </s:form>
            
    </body>
</html>
