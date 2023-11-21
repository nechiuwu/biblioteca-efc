/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inacap.biblioteca.dto;

/**
 *
 * @author otaku
 */
public class LibrosDto {
    long isbn;
    String editorial;
    String autor;
    String titulo;
    String descripcion;
    int valor;
    int stock;
    
    public LibrosDto(){}
    
    public LibrosDto(long isbn, String editorial,String autor,String titulo,String descripcion,int valor,int stock){
        this.isbn = isbn;
        this.editorial= editorial;
        this.autor= autor;
        this.titulo= titulo;
        this.descripcion= descripcion;
        this.valor= valor;
        this.stock= stock;
    }
    
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
