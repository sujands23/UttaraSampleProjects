<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#progressIndicator
{     
position: absolute;
left: 50%;
top: 50%;
z-index: 100;
height: 200px;
width: 300px;  
}
</style>

<script>
function getAJAXObject()
{
	var xmlHttp=false;//XHRObject
	/* try{
		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP")
	}
	catch(e){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
	catch(e2){
		xmlHttp=false
	}
	if(!xmlHttp && typeof XMLHttpRequest != 'undefined'){
		xmlHttp=new XMLHttpRequest();
	} */
	xmlHttp=new XMLHttpRequest();
	return xmlHttp;	
}


var ajaxObj=new getAJAXObject();//This object is executed when the Browser loads.This variable is a global object.It has the reference of XHRObject.

function emailCheck()
{
	var email=document.getElementById("mailid").value;
	var url="emailCheck.do?email="+email;//url pattern configured in web.xml
	ajaxObj.open("get",url,true);
	ajaxObj.send(null);//data is sent/submitted in the url as the request method type is get.So data to be sent is null.
	ajaxObj.onreadystatechange=function()//Attaching a CallBack function to the JavaScript Object.Everytime the readyState state changes, this function is executed.
	{
		if(ajaxObj.readyState==3)//Progress indicator when the XHRObject is receiving data
		{
			document.getElementById("progressIndicator").style.display="block";
		}
		if(ajaxObj.readyState==4)//Complete response has come to XHRObject
		{
			if(ajaxObj.status==200)//response Status is 200:Success
			{
				document.getElementById("progressIndicator").style.display="none";
				var response=ajaxObj.responseText;//Response is a text which is contained in responseText.
				if(response!="")
				{
					document.getElementById("message").innerHTML=response;
				}
				else
				{
					document.getElementById("message").innerHTML="";
				}
			}
		}
	}
}

</script>
</head>
<body>
<h1>AJAX Test</h1>
Enter your mail Id : <input type="text" id="mailid" name="email" onblur=""></input><br>
<input type="button" onclick="emailCheck()" value="checkEmail"></input>
<div id="message"></div>
<span id="progressIndicator" style="display:none">
	<img id="loading_globalFilter_img" src="PreLoader.gif">
	<i id="globalFilterLoading_msg" name="LoadingMessage">Loading...</i>
</span>

</body>
</html>