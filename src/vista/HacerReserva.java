/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import dao.ReservaDAO;
import dao.VueloDAO;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;
import modelo.Usuario;
import modelo.Vuelo;

/**
 *
 * @author pame
 */
public class HacerReserva extends javax.swing.JFrame {
private Usuario usuario;

    public HacerReserva(java.awt.Frame parent, boolean modal, Usuario usuarioLogueado) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Hacer Reserva de Vuelo");
        this.usuario = usuarioLogueado; // aquí sí funcionará
        cargarVuelos();
    }
    
    private void cargarVuelos() {
        VueloDAO dao = new VueloDAO();
        List<Vuelo> vuelos = dao.listarVuelos();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Aerolínea");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Escalas");
        modelo.addColumn("Precio");
        modelo.addColumn("Cupos");

        for (Vuelo v : vuelos) {
            modelo.addRow(new Object[]{
                v.getId(), v.getAerolinea(), v.getOrigen(), v.getDestino(),
                v.getFecha(), v.getHora(), v.getEscalas(), v.getPrecio(), v.getCupos()
            });
        }

        tablaVuelos.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVuelos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnReservarVuelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaVuelos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnReservarVuelo.setText("Reservar Vuelo");
        btnReservarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(33, 33, 33)
                .addComponent(btnReservarVuelo)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservarVuelo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnReservarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarVueloActionPerformed
        int fila = tablaVuelos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un vuelo.");
            return;
        }

        int idVuelo = (int) tablaVuelos.getValueAt(fila, 0);

        Reserva reserva = new Reserva();
        reserva.setIdUsuario(usuario.getId());
        reserva.setIdVuelo(idVuelo);
        reserva.setFechaReserva(LocalDate.now());

        ReservaDAO dao = new ReservaDAO();
        if (dao.insertarReserva(reserva)) {
            JOptionPane.showMessageDialog(this, "Reserva realizada exitosamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la reserva.");
        }
    }//GEN-LAST:event_btnReservarVueloActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReservarVuelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVuelos;
    // End of variables declaration//GEN-END:variables
}
