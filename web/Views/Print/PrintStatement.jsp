<%-- 
    Document   : PrintStatement
    Created on : May 5, 2015, 12:15:27 PM
    Author     : EH5024424
--%>

<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM</title>
    </head>
    <body>
        <h1>View Balance Summary:</h1>
        <s:debug/>
        <s:iterator>
            <s:property value="%{accountid}"></s:property>
        </s:iterator>
        <% ActionContext.getContext().getValueStack().pop();%>
        <s:iterator>
            <s:property value="%{accountid}"></s:property>
        </s:iterator>

    </body>
</html>
