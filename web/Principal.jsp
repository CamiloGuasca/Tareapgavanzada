<%-- 
    Document   : Principal  
    Created on : Oct 16, 2023, 6:30:10 PM
    Author     : camilog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Producto" target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Clientes" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=NuevaVenta" target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                  ${usuario.getNom()}
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                          <li><a class="dropdown-item" href="#">
                                  <img src="img/gratis-png-monstruo-de-ojos-saltones-monstruo.png" alt="usuario" width="60" height="60"/>
                      </a></li>
                  <li><a class="dropdown-item" href="#">papeldormido@gmail.com</a></li>
                  <div class="dropdown-divider"></div>  
                  <form action="Validar" method="post">
                    <li><button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button></li>
                  </form>
                </ul>
              </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 550px;">
            <iframe name="myFrame" style="height: 100%; width: 100%;">
            </iframe>
        </div>  
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
