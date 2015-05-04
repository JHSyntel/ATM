<%-- 
    Document   : Login
    Created on : Apr 27, 2015, 3:53:52 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%
    String ACTIONNAME = "EnterPin";
    int authStatus = Authentication.authCheck();
    if(authStatus == -1) { %>
        <jsp:forward page="/ATM/Auth/NoSession.jsp"/> 
<%  }
    if(authStatus == 0) { %>
        <jsp:forward page="/ATMS/Views/Auth/NotAuthorized.jsp"/>
<%  }  
    System.out.println("authCheck at " + ACTIONNAME + " action is " + authStatus);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
        <script type="text/javascript">
            function addCode(key){
                    var code = document.forms[0].pinNumber;
                    if(code.value.length < 5){
                            code.value = code.value + key;
                    }
            }

            function submitForm(){
                    document.forms[0].submit();
            }

            function emptyCode(){
                    document.forms[0].code.value ='';
//                    document.getElementById('pinNumber').value ='';
            }

            function nextPage(){
                    window.location.replace("http://localhost:8084/ATM/index.html");
            }
        </script>
    </head>
    <body onload="emptyCode();">
        <header><h1>Please enter your pin number:</h1></header>
        <s:form action="EnterPin">
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <table id="keypad" cellpadding="5" cellspacing="3">
                <s:textfield type="password" id= "pinNumber" name="pinNumber" value="" maxlength="5" class="display" readonly="readonly" />
                <tr>
                    <td onclick="addCode('1');"><button type="button" class="keypad">1</button></td>
                    <td onclick="addCode('2');"><button type="button" class="keypad">2</button></td>
                    <td onclick="addCode('3');"><button type="button" class="keypad">3</button></td>
                </tr>
                <tr>
                    <td onclick="addCode('4');"><button type="button" class="keypad">4</button></td>
                    <td onclick="addCode('5');"><button type="button" class="keypad">5</button></td>
                    <td onclick="addCode('6');"><button type="button" class="keypad">6</button></td>
                </tr>
                <tr>
                    <td onclick="addCode('7');"><button type="button" class="keypad">7</button></td>
                    <td onclick="addCode('8');"><button type="button" class="keypad">8</button></td>
                    <td onclick="addCode('9');"><button type="button" class="keypad">9</button></td>
                </tr>
                <tr>
                    <td><button formaction="/ATM/Views/SplashScreen.jsp" id="btnCancel">Cancel</button></td>
                    <td onclick="addCode('*');"><button type="button" class="keypad">0</button></td>
                    <td><button id="btnOkay">OK</button></td>
                    <td></td>
                </tr>
            </table>
          
        </s:form>
    </body>
    <footer></footer>
</html>