<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1.0" >
	<meta charset="utf-8">
	<title>Assignment</title>
	<link rel = "icon" href = "title_logo.jpg" type = "image/x-icon"> 
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<SCRIPT language="Javascript">
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      //-->
   </SCRIPT>
</head>
<body>
 <h1 align="center">Terribly Tiny Tales - Online Test</h1><br><br><br>
 <h2 align="center">Submit N value to get Top N words frequency Table</h2>
	<form action="./backend" method="post" align="center">
			<input placeholder="Enter N value" onkeypress="return isNumberKey(event)" type="text" name="input"/><br>
		    <input   class="button" type="submit"  value="SUBMIT"/>
	</form>
<style type="text/css">
	 	body{
	 		background-color:#abb1ad; 

	 	}
	   form{
	   	 margin-top: 10%;
	   }

input[type=text], input[type=password] {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
	   .button {
 	 background-color: #1a3c55;
 	 color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
}


     </style>

</body>