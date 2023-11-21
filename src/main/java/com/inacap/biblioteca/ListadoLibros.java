/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inacap.biblioteca;

import com.inacap.biblioteca.database.LibreriaDb;
import com.inacap.biblioteca.dto.LibrosDto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author otaku
 */
public class ListadoLibros extends javax.swing.JInternalFrame {

    ArrayList<LibrosDto> libros;
    LibreriaDb ldb = new LibreriaDb();
    
    /**
     * Creates new form ListadoLibros
     */
    public ListadoLibros() {
        initComponents();
    }
    
    public void ListarDatos(){
        libros = ldb.listLibros();
        DefaultTableModel tb = (DefaultTableModel)tblLibros.getModel();
        for(LibrosDto lib: libros){
            tb.addRow(new Object[]{lib.getIsbn(), lib.getEditorial(),lib.getAutor(), lib.getTitulo(),lib.getDescripcion(),lib.getValor(),lib.getStock()});
        }
    }
    
    public void ListarCriticos(){
        libros = ldb.listLibrosCriticos();
        DefaultTableModel tb = (DefaultTableModel)tblLibros.getModel();
        for(LibrosDto lib: libros){
            tb.addRow(new Object[]{lib.getIsbn(), lib.getEditorial(),lib.getAutor(), lib.getTitulo(),lib.getDescripcion(),lib.getValor(),lib.getStock()});
        }
    }
    
    public void Limpiar(){
        DefaultTableModel tb = (DefaultTableModel)tblLibros.getModel();
        for(int i = tb.getRowCount()-1; i >= 0; i--){
            tb.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnCritico = new javax.swing.JButton();

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "EDITORIAL", "AUTOR", "TITULO", "DESCRIPCION", "VALOR", "STOCK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLibros);

        btnListar.setText("Listar Libros");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnCritico.setText("Libros críticos");
        btnCritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnListar)
                .addGap(79, 79, 79)
                .addComponent(btnCritico)
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCritico)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        Limpiar();
        ListarDatos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnCriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriticoActionPerformed
        Limpiar();
        ListarCriticos();
    }//GEN-LAST:event_btnCriticoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCritico;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables
}