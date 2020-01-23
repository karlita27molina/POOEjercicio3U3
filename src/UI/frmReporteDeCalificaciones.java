package UI;

import BEU.Curso;
import BEU.Matricula;
import BLL.GestionCurso;
import BLL.GestionMatricula;
import Molina.Util;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmReporteDeCalificaciones extends javax.swing.JInternalFrame {

    private final String titulo="Reporte de calificaciones"; 
    private GestionCurso cursoBLL=new GestionCurso();
    private GestionMatricula matriculaBLL=new GestionMatricula();
    private List<Curso> cursos;
    private final DefaultTableModel dtmCalificaciones =new DefaultTableModel();
    private List<Matricula> calificaciones;
    
    public frmReporteDeCalificaciones() {
        initComponents();
        leerCursos();
        configurarModeloDeTabla();
    }
    
    private void configurarModeloDeTabla(){
        String[] columnas={"Nombre","Promedio","Estado"};
        this.dtmCalificaciones.setColumnIdentifiers(columnas);
        this.tblCalificaciones.setModel(dtmCalificaciones);
    }
    private void leerCursos(){
        try {
            Curso ficticio=new Curso("-Seleccione-",0.0f,"");
            this.cmbCursos.addItem(ficticio);
            cursos=cursoBLL.getCurso();
            //Expresion lambda
            cursos.forEach((c) -> {
                this.cmbCursos.addItem(c);
            });
        } catch (IOException e) {
            Util.imprimir("Error "+e.toString());
            vtnPrincipal.verMensaje("Error al leer los cursos " ,titulo, JOptionPane.ERROR_MESSAGE);
        }
        }
    
    private void buscarMatricula() throws IOException{
        Curso seleccionado=(Curso)cmbCursos.getSelectedItem();
        calificaciones=matriculaBLL.reportar(seleccionado.getTitulo());
        mostrarCalificaciones();
    }

    private void mostrarCalificaciones(){
        int lim=dtmCalificaciones.getRowCount()-1;
        for(int i=lim;i>=0;i--){
            this.dtmCalificaciones.removeRow(i);
        }
        for (Matricula m:calificaciones){
            Vector fila=new Vector();
            fila.addElement(m.getEstudiante());
            fila.addElement(m.getPromedio());
            fila.addElement(m.getEstado());
            this.dtmCalificaciones.addRow(fila);
        }
        this.tblCalificaciones.setModel(dtmCalificaciones);
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurso = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        lblReporte = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalificaciones = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblCurso.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblCurso.setText("Curso:");

        cmbCursos.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N

        lblReporte.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblReporte.setText("Reporte de Calificaciones");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/Descargas/iconos/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCalificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscarMatricula();
        } catch (Exception e) {
            Util.imprimir("Error " + e.toString());
            vtnPrincipal.verMensaje("Error al buscar matricula ", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JTable tblCalificaciones;
    // End of variables declaration//GEN-END:variables
}
