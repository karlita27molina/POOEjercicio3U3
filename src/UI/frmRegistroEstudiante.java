package UI;

import BEU.Estudiante;
import BLL.GestionEstudiante;
import Molina.Util;
import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class frmRegistroEstudiante extends javax.swing.JInternalFrame {

    private final String titulo = "Registro de Estudiantes";
    private GestionEstudiante estudianteBLL = new GestionEstudiante();

    private String verificarClub(JCheckBox chk) {
        if (chk.isSelected()) {
            return chk.getText();
        }
        return "";
    }

    private void iniciarListado() throws IOException {
        estudianteBLL.leerEstudiante();
    }

    private void crearEstudiante() {
        Estudiante nuevo = new Estudiante();
        nuevo.setCedula(txtCedula.getText());
        nuevo.setNombre(txtNombre.getText());
        nuevo.setApellido(txtApellido.getText());
        nuevo.setCarrera(cmbCarrera.getSelectedItem().toString());
        nuevo.addClub(this.verificarClub(chkArtes));
        nuevo.addClub(this.verificarClub(chkDanza));
        nuevo.addClub(this.verificarClub(chkAndinismo));
        nuevo.addClub(this.verificarClub(chkRobotica));
        nuevo.addClub(this.verificarClub(chkMusica));
        nuevo.addClub(this.verificarClub(chkDrama));
        nuevo.addClub(this.verificarClub(chkAjedrez));
        nuevo.addClub(this.verificarClub(chkFutbol));    

        estudianteBLL.getEstudiante().add(nuevo);
    }

    private void archivar() throws IOException {
        estudianteBLL.archivar();
    }

    public frmRegistroEstudiante() {
        initComponents();
        try {
            iniciarListado();
        } catch (IOException ex) {
            Util.imprimir(ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        pnlDatosCliente = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        chkDanza = new javax.swing.JCheckBox();
        chkAndinismo = new javax.swing.JCheckBox();
        chkRobotica = new javax.swing.JCheckBox();
        chkMusica = new javax.swing.JCheckBox();
        chkDrama = new javax.swing.JCheckBox();
        chkAjedrez = new javax.swing.JCheckBox();
        chkArtes = new javax.swing.JCheckBox();
        chkFutbol = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblTitulo.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        lblTitulo.setText("Registro de Estudiante");

        pnlDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        lblNombre.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblApellido.setText("Apellido:");

        lblCedula.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        lblCedula.setText("Cédula:");

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(118, 118, 118)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtNombre)))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Académicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel1.setText("Carrera:");

        cmbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingeniería Electrónica", "Ingeniería Electromecánica", "Ingeniería de Software", "Ingeniería Petroquímica", "Ingeniería Mecatrónica" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Extracurriculares", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Palladio L", 1, 18))); // NOI18N

        chkDanza.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkDanza.setText("Club de Danza");

        chkAndinismo.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkAndinismo.setText("Club de Andinismo");

        chkRobotica.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkRobotica.setText("Club de Robótica");

        chkMusica.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkMusica.setText("Club de Música");

        chkDrama.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkDrama.setText("Club de Drama");

        chkAjedrez.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkAjedrez.setText("Club de Ajedrez");

        chkArtes.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkArtes.setText("Club de Artes Marciales");

        chkFutbol.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        chkFutbol.setText("Club de Fútbol");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkAndinismo)
                    .addComponent(chkDanza)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(chkMusica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkRobotica, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkAjedrez)
                    .addComponent(chkDrama)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(chkFutbol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkArtes, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkDanza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkAndinismo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkRobotica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkMusica))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chkDrama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkAjedrez)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkArtes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkFutbol)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(49, 214, 214));
        btnGuardar.setFont(new java.awt.Font("URW Bookman L", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon("/home/labctr/Descargas/iconos/save.png")); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            crearEstudiante();
            archivar();
            vtnPrincipal.verMensaje("Estudiante agregado correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            Util.imprimir("Error " + e.toString());
            vtnPrincipal.verMensaje("Error al guardar estudiante", titulo, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkAjedrez;
    private javax.swing.JCheckBox chkAndinismo;
    private javax.swing.JCheckBox chkArtes;
    private javax.swing.JCheckBox chkDanza;
    private javax.swing.JCheckBox chkDrama;
    private javax.swing.JCheckBox chkFutbol;
    private javax.swing.JCheckBox chkMusica;
    private javax.swing.JCheckBox chkRobotica;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDatosCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
