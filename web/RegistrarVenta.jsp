<%-- 
    Document   : RegistrarVenta
    Created on : Oct 20, 2023, 11:58:19 AM
    Author     : camilog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Venta" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos Del Cliente</label>   
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" value="${cliente.getDni()}" class="form-control" placeholder="Código">
                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>     
                            <div class="col-sm-6"> 
                                <input type="text" name="nombrescliente" value="${cliente.getNombres()}" placeholder="Datos Cliente" class="form-control">
                            </div>    
                        </div>
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                           <div class="col-sm-6 d-flex">
                               <input type="text" name="codigoproducto" class="form-control" value="${producto.getIdProducto()}" placeholder="Código">
                                <button type="submit" name="accion" value="BuscarProducto" placeholder="Datos Producto" class="btn btn-outline-info">Buscar</button>
                            </div>     
                            <div class="col-sm-6"> 
                                <input type="text" name="nomproducto" value="${producto.getNombres()}" class="form-control">
                            </div> 
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="S/0.00">
                            </div>     
                            <div class="col-sm-3"> 
                                <input type="number" name="cant" value="1" class="form-control" >
                            </div>  
                            <div class="col-sm-3"> 
                                <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                            </div>  
                        </div>
                        <div class="form-group">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                        </div>
                    </div>
                        </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label class="col-sm-5">Número De Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Número</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Sub Total</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Venta> ven = (List<Venta>) request.getAttribute("lista");
                                    if(ven != null){
                                        for(Venta v : ven){
                                %>
                                <tr>
                                    <td><%=v.getItem()%></td>
                                    <td><%=v.getId()%></td>
                                    <td><%=v.getDescripcionP()%></td>
                                    <td><%=v.getPrecio()%></td>
                                    <td><%=v.getCantidad()%></td>
                                    <td><%=v.getSubtotal()%></td>
                                    <td class="d-flex">
                                        <a href="" class="btn btn-warning">Editar</a>
                                        <a href="" class="btn btn-danger" style="margin-left: 10px;">Eliminar</a>
                                    </td>
                                </tr>
                                <%     }
                                   }%>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" value="$ ${totalpagar}" name="txtTotal" class="form-control">
                        </div> 
                    </div>
                </div>    
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
    </body>
</html>
