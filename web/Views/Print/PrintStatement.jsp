<%-- 
    Document   : PrintStatement
    Created on : May 5, 2015, 12:15:27 PM
    Author     : NN5024428
--%>

<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <title>ATM</title>
    </head>
    <body>
        <header>
            <h1>View Balance Summary:</h1>
        </header>
            <!--<% ActionContext.getContext().getValueStack().pop();%>-->
        <div>
            <b>Account ID :</b>
            <s:property value="%{accountid}"></s:property>
       
        </div>
        <div>
            <b>Account Balance:</b>
            <s:property value="%{balance}"></s:property>
                
           
            <%! String balance=""; %>
            <% 
                Map<String, Object> userSession = ActionContext.getContext().getSession();
                balance = (String) userSession.get("selectedaccountbalance");
                System.out.println("balance: " + balance); %>
        </div>

        <s:form method="link">
            <s:submit formaction="/ATM/Views/MainMenu.jsp" value="Back"/>
        </s:form>

    </body>

    <footer>

    </footer>
</html>
