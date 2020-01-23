package UI;


import BEU.Curso;
import BEU.Estudiante;
import BLL.GestionCurso;
import BLL.GestionEstudiante;
import BLL.GestionMatricula;
import Molina.Util; 
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class frmRegistroMatricula extends javax.swing.JInternalFrame {

    private final String titulo="Registro de Matricula"; 
    //SERVICIO
    private GestionCurso cursoBLL=new GestionCurso();
    private GestionEstudiante estudianteBLL=new GestionEstudiante();
    private List<Curso> cursos;
     private List<Estudiante> estudiantes;
    private GestionMatricula matriculaBLL=new GestionMatricula();
    
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
    private void leerEstudiante(){
        try {
            Estudiante ficticio= new Estudiante();            
            ficticio.setNombre("-Seleccione-");
            ficticio.setApellido("");
            this.cmbEstudiantes.addItem(ficticio);
            estudiantes=estudianteBLL.leerEstudiante();
            //Expresion lambda
            estudiantes.forEach((e) -> {
                this.cmbEstudiantes.addItem(e);
            });
        } catch (IOException e) {
            Util.imprimir("Error "+e.toString());
            vtnPrincipal.verMensaje("Error al leer los estudiantes " ,titulo, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean validar(){
        Curso cr=(Curso) this.cmbCursos.getSelectedItem();
        if(cr.getTitulo().equals("-Seleccione-")){
            vtnPrincipal.verMensaje("Curso no válido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        Estudiante est=(Estudiante)this.cmbEstudiantes.getSelectedItem();
        if(est.getNombre().equals("-Seleccione-")){
            vtnPrincipal.verMensaje("Estudiante no válido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void crearMatricula() throws IOException{
        
        Curso cr=(Curso) this.cmbCursos.getSelectedItem();
        Estudiante est=(Estudiante)this.cmbEstudiantes.getSelectedItem();
        matriculaBLL.crear();
        matriculaBLL.configurar(cr, est);
        matriculaBLL.archivar();
    
    }
   
    public frmRegistroMatricula() {
        initComponents();
        leerCursos();
        leerEstudiante();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistroMatricula = new javax.swing.JPanel();
        lblEstudiante = new javax.swing.JLabel();
        cmbEstudiantes = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pnlRegistroMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Matricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        lblEstudiante.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblEstudiante.setText("Estudiante:");

        cmbEstudiantes.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N

        lblCurso.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblCurso.setText("Curso:");

        cmbCursos.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroMatriculaLayout = new javax.swing.GroupLayout(pnlRegistroMatricula);
        pnlRegistroMatricula.setLayout(pnlRegistroMatriculaLayout);
        pnlRegistroMatriculaLayout.setHorizontalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEstudiantes, 0, 253, Short.MAX_VALUE)
                    .addComponent(cmbCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroMatriculaLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        pnlRegistroMatriculaLayout.setVerticalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCursos)
                    .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(validar()){
            crearMatricula();
            vtnPrincipal.verMensaje("Matricula creada correctamente " ,titulo, JOptionPane.INFORMATION_MESSAGE);
            } } catch (IOException e) {
            Util.imprimir("Error "+e.toString());
           vtnPrincipal.verMensaje("Error al crear la matricula " ,titulo, JOptionPane.ERROR_MESSAGE);
         
}
    }//GEN-LAST:event_btnGuardarActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JComboBox<Estudiante> cmbEstudiantes;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JPanel pnlRegistroMatricula;
    // End of variables declaration//GEN-END:variables
}
