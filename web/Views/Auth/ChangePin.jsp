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
    if(authStatus == 0) { %>
    <jsp:forward page="/Views/Auth/NotAuthorized.jsp"/>
<%  }  
    System.out.println("authCheck at " + ACTIONNAME + " action is " + authStatus);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
        <script type="text/javascript">
            var code = document.forms[0].currentPinNumber;
            function switchToCurrentPinField() {
                code = document.forms[0].currentPinNumber;
                code.style.border = "3px solid #0000FF";
                document.forms[0].newPinNumber.style.border = "2px solid #DDDDDD";
                document.forms[0].confirmNewPinNumber.style.border = "2px solid #DDDDDD";
            }
            function switchToNewPinField() {
                code = document.forms[0].newPinNumber;
                code.style.border = "3px solid #0000FF";
                document.forms[0].currentPinNumber.style.border = "2px solid #DDDDDD";
                document.forms[0].confirmNewPinNumber.style.border = "2px solid #DDDDDD";
            }
            function switchToCornfirmNewPinField() {
                code = document.forms[0].confirmNewPinNumber;
                code.style.border = "3px solid #0000FF";
                document.forms[0].currentPinNumber.style.border = "2px solid #DDDDDD";;
                document.forms[0].newPinNumber.style.border = "2px solid #DDDDDD";
            }
            function addCode(key){
                    if(code.value.length < 5){
                            code.value = code.value + key;
                    }
            }

            function submitForm(){
                    document.forms[0].submit();
            }

            function emptyCode(){
                    document.forms[0].currentPinNumber.value = '';
                    document.forms[0].newPinNumber.value = '';
                    document.forms[0].confirmNewPinNumber.value = '';
            }

            function nextPage(){
                    window.location.replace("http://localhost:8084/ATM/index.html");
            }
        </script>
    </head>
    <body onload="emptyCode()">
        <header><h1>Please swipe your card (input card number)</h1></header>
        <s:form>
            <s:if test="hasActionErrors()">
                <s:actionerror/>
            </s:if>
            <s:label>Current Pin #</s:label>
            <s:textfield type="password" name="currentPinNumber" class='formField'/>
            <button onclick="switchToCurrentPinField()" type="button" class="edit">Edit</button>
            <br>
            <s:label>New Pin #</s:label>
            <s:textfield type="password" name="newPinNumber" class='formField'/>
            <button onclick="switchToNewPinField()" type="button" class="edit">Edit</button>
            <br>
            <s:label>Confirm New Pin #</s:label>
            <s:textfield type="password" name="confirmNewPinNumber" class='formField'/>
            <button onclick="switchToCornfirmNewPinField()" type="button" class="edit">Edit</button>
            <table id="keypad" cellpadding="5" cellspacing="3">
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
                    <td><button class="keypad" id="btnCancel">Cancel</button></td>
                    <td onclick="addCode(0);"><button type="button" class="keypad">0</button></td>
                    <td><button id="btnOkay" class="keypad" formaction="ChangePin">OK</button></td>
                </tr>
            </table>
            <button formaction="/ATM/Views/MainMenu.jsp">Return to Main Menu</button>
            <br>
        </s:form>
        <footer></footer>
    </body>
</html>
