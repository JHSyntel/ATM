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
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Select Account</h1></header>
        <s:form action="SelectAccount">
   
            <s:iterator>
                <s:submit value="%{accountid}" name="accountid"/>
                <br><br>
            </s:iterator>
                
            <br><br><br>
            <s:submit value="Cancel" name="cancel"/>
        </s:form>
            
    </body>
    <footer></footer>
</html>
