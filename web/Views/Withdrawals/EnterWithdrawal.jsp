<%-- 
    Document   : EnterWithdrawal
    Created on : Apr 24, 2015, 9:56:06 AM
    Author     : EH5024424
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
            <script type="text/javascript">
            function addCode(key){
                    var code = document.forms[0].withdrawamt;
                    if (key === "Delete" && code.value !== "0")
                        code.value = code.value.substr(0,code.value.length-2)*10;
                    else if (key === "Delete" && code.value === "0")
                        code.value = "0";
                    else
                        code.value = ((code.value/10) + key) * 10;
            }

            function submitForm(){
                    document.forms[0].submit();
            }

            function emptyCode(){
                    document.forms[0].withdrawamt.value = "0";
            }
            </script>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body onload="emptyCode();">
        <header><h1>Enter Amount to Withdraw</h1></header>
        <div>
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>

            <s:form action="withdraw">
                <s:textfield name="withdrawamt" size="10" readonly="true"/>
            </s:form>
            
            <table id="keypad" cellpadding="5" cellspacing="3">
                <tr>
                    <td onclick="addCode('1');">1</td>
                    <td onclick="addCode('2');">2</td>
                    <td onclick="addCode('3');">3</td>
                </tr>
                <tr>
                    <td onclick="addCode('4');">4</td>
                    <td onclick="addCode('5');">5</td>
                    <td onclick="addCode('6');">6</td>
                </tr>
                <tr>
                    <td onclick="addCode('7');">7</td>
                    <td onclick="addCode('8');">8</td>
                    <td onclick="addCode('9');">9</td>
                </tr>
                <tr>
                    <td onclick="addCode('Delete');">Delete</td>
                    <td onclick="addCode('0');">0</td>
                    <td onclick="submitForm();">OK</td>
                </tr>
            </table>
            <form method="link">
                <input type="submit" value="Back" formaction="/ATM/Views/SelectAccount.jsp">
            </form>
        </div>
    </body>
    <footer></footer>
</html>
