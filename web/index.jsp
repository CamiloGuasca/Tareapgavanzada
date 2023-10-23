<%-- 
    Document   : index
    Created on : Oct 16, 2023, 6:28:39 PM
    Author     : camilog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>
        <div class = "container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form action="Validar" method="post" class="form-sign">
                        <div class="form-group  text-center">
                            <h3>Login</h3>
                            <img src="img/label-2016248_1280.png" alt="imagen de ventas"height="170"/>
                            <label>Bienvenidos Al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario: </label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario: </label>
                            <input type="password" name="txtpass" class="form-control">
                            
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block"> 
                    </form>
                </div>  
            </div>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
