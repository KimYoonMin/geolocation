<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script type="text/javascript">
window.onload = function geoFindMe() {
	  var output = document.getElementById("out");
	
	  if (!navigator.geolocation){
	    output.innerHTML = "<p>������� �������� ���������̼��� �������� �ʽ��ϴ�.</p>";
	    return;
	  }

	  function success(position) {
		  var latitude  = position.coords.latitude;
		  var longitude = position.coords.longitude;

	    /* output.innerHTML = '<p>���� : ' + latitude + '�� <br>�浵 : ' + longitude + '��</p>';
	    test = latitude; */
	    document.getElementById("latitude").value = latitude;
	    document.getElementById("longitude").value = longitude;   
	    document.f.submit();
	    /* var img = new Image();
	    img.src = "http://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=13&size=300x300&sensor=false"; */

	    /* output.appendChild(img); */
	  };
	  

	   function error() {
	    output.innerHTML = "������� ��ġ�� ã�� �� �����ϴ�.";
	  }; 

	  /* output.innerHTML = "<p>Locating��</p>"; */

	  navigator.geolocation.getCurrentPosition(success, error);
	  /* document.getElementById('form').submit(); */
	  
	  
	}
</script>

<%
	System.out.println(request.getRealPath("/"));
%>


<body>


<div id="out"></div>
<form id="form" name="f" action="geolocation2.gps">
<input type="text" name="latitude" id="latitude">
<input type="text" name="longitude" id="longitude">
<input type="submit" value="Ȯ��">

</form>
</body>
</html>