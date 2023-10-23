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
public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
        public Cliente buscar(String dni){
        Cliente cli = new Cliente();
        String sql ="SELECT * FROM cliente WHERE Dni="+dni;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        }catch(Exception ex){
            System.out.println("#### Error AL Buscar Producto #### "+ex);
        }
        return cli;
    }
        
    public List Listar(){
        String sql = "SELECT * FROM Cliente";
        List<Cliente>lista = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt("IdCliente"));
                cli.setDni(rs.getString("Dni"));
                cli.setNombres(rs.getString("Nombres"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setEstado(rs.getString("Estado"));
            }
        }catch(Exception ex){
            System.out.println("???? Error al listar clientes ???? "+ex);
        }
        return lista;
    }
    
    public int agregar(Cliente cli){
        String sql = "INSERT INTO cliente(IdCliente,Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
            ps.setString(2, cli.getDni());
            ps.setString(3, cli.getNombres());
            ps.setString(4, cli.getDireccion());
            ps.setString(5, cli.getDireccion());
            ps.executeUpdate();
            
        }catch (Exception ex){
            System.out.println("&&&& Error Al Insertar Cliente &&&&"+ex);
        }
        return r;
    }
    
    public Cliente listarId(int id){
        Cliente cli = new Cliente();
        String sql ="SELECT * FROM cliente WHERE IdCliente="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        }catch(Exception ex){
            System.out.println("#### Error AL Buscar Cliente #### "+ex);
        }
        return cli;
    }
    
    public int actualizar(Cliente cli){
        String sql = "UPDATE cliente SET Dni = ?, Nombres = ?, Direccion = ?, Estado = ? WHERE IdCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(6, cli.getIdCliente());
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println("!!!! Error Al Actualizar Cliente !!!! "+ex);
        }
        return r;
    }
    public void delete(int id){
        String sql ="DELETE FROM cliente WHERE IdCliente="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("//// Error Al Eliminar Cliente ////");
        }
    }
}
