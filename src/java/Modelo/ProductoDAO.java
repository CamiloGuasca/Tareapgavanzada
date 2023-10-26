/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilog
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public int actualizarstok(int id, int stock){
        String sql = "UPDATE producto SET Stock = ? WHERE IdProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("#### Error Al Actuazar Stock #### "+ex.getMessage());
        }
        return r;
    }
    public List Listar(){
        String sql = "SELECT * FROM producto";
        List<Producto>pro = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
              Producto pr = new Producto();
              pr.setIdProducto(rs.getInt("IdProducto"));
              pr.setNombres(rs.getString("Nombres"));
              pr.setPrecio(rs. getDouble("Precio"));
              pr.setStock(rs.getInt("Stock"));
              pr.setEstado(rs.getString("Estado"));
              pro.add(pr);
            }
        }catch(Exception ex){
            System.out.println("|||| Error Al Listar Producto |||| "+ex.getMessage());
        }
        return pro;
    }
    public int agregar(Producto pro){
        String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("==== Error Al Agregar Producto ===="+ex.getMessage());
        }
        return r;
    }
    
    public Producto listarId(int id){
        String sql = "SELECT * FROM producto where IdProducto="+id;
        Producto pro = new Producto();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pro.setIdProducto(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock( rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
        }catch(Exception ex){
            System.out.println("#### Error Al Buscar Producto ####"+ex.getMessage());
        }
        return pro;
    }
    
    public int actualizar(Producto pro){
        String sql = "UPDATE producto SET Nombres = ?, Precio = ?, Stock = ?, Estado = ? WHERE IdProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getIdProducto());
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("%%%% Error Al Actualizar Producto %%%%"+ex.getMessage());
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "DELETE FROM producto WHERE IdProducto="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("$$$$ Error Al Borrar Producto $$$$"+ex.getMessage());
        }
    }
}
