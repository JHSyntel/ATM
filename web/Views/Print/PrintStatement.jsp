<%-- 
    Document   : PrintStatement
    Created on : May 5, 2015, 12:15:27 PM
    Author     : EH5024424
--%>

<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.syntelinc.BOK.ATM.menupkg.Hibernate"%>
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
        <%!Hibernate h = new Hibernate();%>
        <%!List l = (List)ActionContext.getContext().getValueStack().peek();%>
        <%!int count=0;%>
        <%!Account account;%>
    <s:iterator>
        <%
            account = (Account)l.get(count);
            System.out.println(h.checkAccountType(Long.toString(account.getAccountID())));
            
            count++;
        %>
        <s:property value="%{accountid}"></s:property>
    </s:iterator>
    </body>
</html>
