

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/welcome.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/css/welcome.js"></script>

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100&display=swap" rel="stylesheet">

    <script>
   $(document).ready(function(){
    $('#nav-placeholder').load('navbar.html');
    });
    </script>

</head>
<body>

    
    <div id="nav-placeholder">
    </div>
    
    <%
                if (gDep!=null && gDep.getCantidad()>0)
                {
            %>                    
                <table border="1">
                    <thead> 
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i=0; i<gDep.getCantidad(); i++) 
                            {
                                Departamento d= gDep.getDepartamento(i);
                        %>
                            <tr>
                                <td> <%=d.getCodigo()%> </td>
                                <td> <%=d.getNombre()%> </td>
                            </tr>
                          <%}%>
                    </tbody>
                </table>
            <%}%>
 
    
</body>
</html>