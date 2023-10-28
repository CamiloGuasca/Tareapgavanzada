<%-- 
    Document   : Producto
    Created on : Oct 18, 2023, 8:57:18 PM
    Author     : camilog
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Producto" %>
<%@ page import="Modelo.Empleado" %>
<%
    HttpSession sesion = (HttpSession)request.getSession();
    Empleado emp = (Empleado)sesion.getAttribute("usuario");
    if (emp == null) {
        response.sendRedirect("index.jsp");
    }else{
            
%>  
<!DOCTYPE html>
<html>
    <head>s
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Producto</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="post">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombres()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">   
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">   
                    </form>
                </div> 
            </div>    
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           List<Producto> produc = (List<Producto>) request.getAttribute("productos"); // Obtén la lista de empleados del ámbito de la solicitud
                           for(Producto pr : produc) {
                        %>
                            <tr>
                                <td><%=pr.getIdProducto()%></td>
                                <td><%=pr.getNombres()%></td>
                                <td><%=pr.getPrecio()%></td>
                                <td><%=pr.getStock()%></td>
                                <td><%=pr.getEstado()%></td>
                                <td>
                                    <a href="Controlador?menu=Producto&accion=Editar&id=<%=pr.getIdProducto()%>" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Producto&accion=Delete&id=<%=pr.getIdProducto()%>" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>    
            </div>    
        </div>   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
    </body>
</html>
<%}%>
