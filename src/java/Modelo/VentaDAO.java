/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author camilog
 */
public class VentaDAO {
    Connection  con;
    Conexion  cn = new  Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public String GenerarSerie(){
        String numeroserie = "";
        String  sql = "select (CAST(NumeroSerie AS SIGNED)) from ventas";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                numeroserie = rs.getString(1);
            }
        }catch(Exception ex){
            System.out.println("|||| Error Al Obtener Numero Serie ||||"+ex.getMessage());
        }
        return numeroserie;
    }
    
    public  String IdVentas(){
        String idVentas = "";
        String  sql = "SELECT  max(IdVentas) from ventas";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                idVentas = rs.getString(1);
            }
        }catch(Exception ex){
            System.out.println("#### Error En IdVentas ####"+ex);
        }
        return idVentas;
    }
    
    public int guardarVenta(Venta ve){
        String  sql = "INSERT INTO ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) VALUES (?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            System.out.println("INGRESOSSS");
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("$$$$ Error En Guardar Venta $$$$"+ex.getMessage());
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql = "INSERT INTO detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) VALUES (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId(
            ));
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("$$$$ Error En Guardar Venta $$$$"+ex.getMessage());
        }
        return r;
    }
}
