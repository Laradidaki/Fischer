<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX calls to Servlet using JQuery and JSON</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $('#regione').change(function(event) {  
        var $regione=$("select#regione").val();
           $.get('dropDownRegione',{nomiRegioni:$regione},function(responseJson) {   
           var $select = $('#citta');                           
               $select.find('option').remove();                          
               $.each(responseJson, function(key, value) {               
                   $('<option>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });          
</script>
</head>
<body>
<h1>AJAX calls to Servlet using JQuery and JSON</h1>
Select Regione:
<select id="regione">
<option>Select Regione</option>
<option value="Lombardia">Lombardia</option>
<option value="Sardegna">Sardegna</option>
</select>
<br/>
<br/>
Select Città:
<select id="citta">
<option>Select Città</option>
</select>
</body>
</html>