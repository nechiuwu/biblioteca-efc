/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inacap.biblioteca.database;

import com.inacap.biblioteca.dto.LibrosDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author otaku
 */
public class LibreriaDb {
    public ArrayList<LibrosDto> listLibros(){
        ArrayList<LibrosDto> libros = new ArrayList();
        try{
            java.sql.Connection conn= Connection.connectSql();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT LIBISBN, LIBEDITORIAL, LIBAUTOR, LIBTITULO, LIBDESCRIPCION,LIBVALOR,LIBSTOCK "
                    + "FROM LIBROS WHERE LIBSTOCK != 0");
            while(result.next()){
                LibrosDto lb = new LibrosDto();
                lb.setIsbn(result.getLong("LIBISBN"));
                lb.setEditorial(result.getString("LIBEDITORIAL"));
                lb.setAutor(result.getString("LIBAUTOR"));
                lb.setTitulo(result.getString("LIBTITULO"));
                lb.setDescripcion(result.getString("LIBDESCRIPCION"));
                lb.setValor(result.getInt("LIBVALOR"));
                lb.setStock(result.getInt("LIBSTOCK"));
                libros.add(lb);
            }
        }catch(SQLException ex){
            System.out.println("Error en listado");
            System.out.println(ex.getMessage());
        }
        return libros;
    }
    
    public ArrayList<LibrosDto> listLibrosCriticos(){
        ArrayList<LibrosDto> libros = new ArrayList();
        try{
            java.sql.Connection conn= Connection.connectSql();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT LIBISBN, LIBEDITORIAL, LIBAUTOR, LIBTITULO, LIBDESCRIPCION,LIBVALOR,LIBSTOCK "
                    + "FROM LIBROS WHERE LIBSTOCK <= 5");
            while(result.next()){
                LibrosDto lb = new LibrosDto();
                lb.setIsbn(result.getLong("LIBISBN"));
                lb.setEditorial(result.getString("LIBEDITORIAL"));
                lb.setAutor(result.getString("LIBAUTOR"));
                lb.setTitulo(result.getString("LIBTITULO"));
                lb.setDescripcion(result.getString("LIBDESCRIPCION"));
                lb.setValor(result.getInt("LIBVALOR"));
                lb.setStock(result.getInt("LIBSTOCK"));
                libros.add(lb);
            }
        }catch(SQLException ex){
            System.out.println("Error en listado");
            System.out.println(ex.getMessage());
        }
        return libros;
    }
    
    public void createLibros(LibrosDto libros){
        try{
            java.sql.Connection conn= Connection.connectSql();
            PreparedStatement state = conn.prepareStatement("INSERT INTO LIBROS(LIBISBN, LIBEDITORIAL, LIBAUTOR, LIBTITULO, LIBDESCRIPCION, LIBVALOR, LIBSTOCK) "
                    + "VALUES (?,?,?,?,?,?,?)");
            state.setLong(1, libros.getIsbn());
            state.setString(2, libros.getEditorial());
            state.setString(3, libros.getAutor());
            state.setString(4, libros.getTitulo());
            state.setString(5, libros.getDescripcion());
            state.setInt(6, libros.getValor());
            state.setInt(7, libros.getStock());
            state.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al crear libros");
            System.out.println(ex.getMessage());
        }
    }
    
    public LibrosDto searchLibros(LibrosDto libros){
        LibrosDto lb = new LibrosDto();
        try{ 
            java.sql.Connection conn= Connection.connectSql();
            PreparedStatement state = conn.prepareStatement("SELECT * FROM LIBROS WHERE LIBISBN=?");
            state.setLong(1, libros.getIsbn());
            ResultSet result = state.executeQuery();
            while(result.next()){
                lb.setIsbn(Long.parseLong(result.getString("LIBISBN")));
                lb.setEditorial(result.getString("LIBEDITORIAL"));
                lb.setAutor(result.getString("LIBAUTOR"));
                lb.setTitulo(result.getString("LIBTITULO"));
                lb.setDescripcion(result.getString("LIBDESCRIPCION"));
                lb.setValor(Integer.parseInt(result.getString("LIBVALOR")));
                lb.setStock(Integer.parseInt(result.getString("LIBSTOCK")));
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar libros");
            System.out.println(ex.getMessage());
        }
        return lb;
    }
    
    public void editLibros(LibrosDto libros){
        try{
            java.sql.Connection conn= Connection.connectSql();
            PreparedStatement state = conn.prepareStatement("UPDATE LIBROS SET LIBISBN=?, LIBEDITORIAL=?, LIBAUTOR=?, LIBTITULO=?, LIBDESCRIPCION=?, LIBVALOR=?, LIBSTOCK=? "
                    + "WHERE LIBISBN=?");
            state.setLong(1, libros.getIsbn());
            state.setString(2, libros.getEditorial());
            state.setString(3, libros.getAutor());
            state.setString(4, libros.getTitulo());
            state.setString(5, libros.getDescripcion());
            state.setInt(6, libros.getValor());
            state.setInt(7, libros.getStock());
            state.setLong(8, libros.getIsbn());
            state.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al editar libros");
            System.out.println(ex.getMessage());
        }
    }
    
    public Boolean deleteLibros(LibrosDto libros){
        try{
            java.sql.Connection conn= Connection.connectSql();
            PreparedStatement state = conn.prepareStatement("DELETE FROM LIBROS WHERE LIBISBN=?");
            state.setLong(1, libros.getIsbn());
            state.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Error al eliminar libro");
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
