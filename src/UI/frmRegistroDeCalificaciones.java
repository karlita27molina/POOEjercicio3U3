package UI;

import BLL.GestionMatricula;
import Molina.Util;
import java.io.IOException;
import javax.swing.JOptionPane;

public class frmRegistroDeCalificaciones extends javax.swing.JInternalFrame {

    private final String titulo = "Registro de Calificacion de Matricula";
    private GestionMatricula matriculaBLL=new GestionMatricula();
   
    public frmRegistroDeCalificaciones() {
        initComponents();
    }
    
    private boolean validar(){
         float nota=(float) this.snnCalificacion.getValue();
        if(nota==0.f){
            vtnPrincipal.verMensaje("Nota no valida", titulo, JOptionPane.WARNING_MESSAGE);
            return false; 
                    }
         return true;
    }
    
    private void consultarMatricula() throws IOException{
        String numero=this.txtNumeroMatricula.getText();
        matriculaBLL.consultar(numero);
        this.txtDatosMatricula.setText(matriculaBLL.imprimir());
    }
    
    private String calificar() throws IOException{
        float nota=(float) this.snnCalificacion.getValue();
        String mensaje= matriculaBLL.calificar(nota);
        matriculaBLL.archivar();
        return mensaje;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistroCalificaciones = new javax.swing.JPanel();
        lblNumeroMatricula = new javax.swing.JLabel();
        txtNumeroMatricula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlDAtosMatricula = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatosMatricula = new javax.swing.JTextArea();
        pnlCalificacion = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        snnCalificacion = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pnlRegistroCalificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Calificaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        lblNumeroMatricula.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblNumeroMatricula.setText("Numero de Matricula:");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/Descargas/iconos/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        pnlDAtosMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Matricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        txtDatosMatricula.setEditable(false);
        txtDatosMatricula.setColumns(20);
        txtDatosMatricula.setRows(5);
        jScrollPane1.setViewportView(txtDatosMatricula);

        javax.swing.GroupLayout pnlDAtosMatriculaLayout = new javax.swing.GroupLayout(pnlDAtosMatricula);
        pnlDAtosMatricula.setLayout(pnlDAtosMatriculaLayout);
        pnlDAtosMatriculaLayout.setHorizontalGroup(
            pnlDAtosMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDAtosMatriculaLayout.setVerticalGroup(
            pnlDAtosMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosMatriculaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCalificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Calificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        lblValor.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblValor.setText("Valor:");

        snnCalificacion.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), Float.valueOf(0.05f)));

        javax.swing.GroupLayout pnlCalificacionLayout = new javax.swing.GroupLayout(pnlCalificacion);
        pnlCalificacion.setLayout(pnlCalificacionLayout);
        pnlCalificacionLayout.setHorizontalGroup(
            pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(snnCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlCalificacionLayout.setVerticalGroup(
            pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(snnCalificacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon("/home/labctr/Descargas/iconos/save.png")); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroCalificacionesLayout = new javax.swing.GroupLayout(pnlRegistroCalificaciones);
        pnlRegistroCalificaciones.setLayout(pnlRegistroCalificacionesLayout);
        pnlRegistroCalificacionesLayout.setHorizontalGroup(
            pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDAtosMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                        .addComponent(lblNumeroMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(pnlCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlRegistroCalificacionesLayout.setVerticalGroup(
            pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlDAtosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlRegistroCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistroCalificacionesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardar)))
                .addGap(309, 309, 309))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegistroCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnlRegistroCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String mensaje=calificar();
            vtnPrincipal.verMensaje(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            Util.imprimir("Error " + e.toString());
            vtnPrincipal.verMensaje("Error al calificar la matricula", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
           consultarMatricula();
        } catch (Exception e) {
            Util.imprimir("Error " + e.toString());
            vtnPrincipal.verMensaje("Error al buscar matricula ", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroMatricula;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlCalificacion;
    private javax.swing.JPanel pnlDAtosMatricula;
    private javax.swing.JPanel pnlRegistroCalificaciones;
    private javax.swing.JSpinner snnCalificacion;
    private javax.swing.JTextArea txtDatosMatricula;
    private javax.swing.JTextField txtNumeroMatricula;
    // End of variables declaration//GEN-END:variables
}
