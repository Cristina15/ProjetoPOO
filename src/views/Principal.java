/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import views.cadastro.CadastroPlanta;
import views.cadastro.CadastroFlores;
import views.cadastro.CadastroArvores;
import views.cadastro.CadastroArbusto;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author matheus.jmaia
 */
public class Principal extends javax.swing.JFrame {

    private CadastroArbusto cadastroArbustos = null;
    private CadastroArvores cadastroArvores = null;
    private CadastroFlores cadastroFlores = null;
    private CadastroPlanta cadstroPlanta = null;

    public CadastroArbusto getCadastroArbustos() {
        return cadastroArbustos;
    }

    public void setCadastroArbustos(CadastroArbusto cadastroArbustos) {
        this.cadastroArbustos = cadastroArbustos;
    }

    public CadastroArvores getCadastroArvores() {
        return cadastroArvores;
    }

    public void setCadastroArvores(CadastroArvores cadastroArvores) {
        this.cadastroArvores = cadastroArvores;
    }

    public CadastroFlores getCadastroFlores() {
        return cadastroFlores;
    }

    public void setCadastroFlores(CadastroFlores cadastroFlores) {
        this.cadastroFlores = cadastroFlores;
    }

    public CadastroPlanta getCadstroPlanta() {
        return cadstroPlanta;
    }

    /**
     * Creates new form Principal2
     */
    public void setCadstroPlanta(CadastroPlanta cadstroPlanta) {
        this.cadstroPlanta = cadstroPlanta;
    }

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuCadastrarClientes = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        menuCadastrarProdutos = new javax.swing.JMenuItem();
        menuPesquisarProdutos = new javax.swing.JMenuItem();
        menuPesquisarProdutos1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DesktopPrincipalLayout = new javax.swing.GroupLayout(DesktopPrincipal);
        DesktopPrincipal.setLayout(DesktopPrincipalLayout);
        DesktopPrincipalLayout.setHorizontalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1546, Short.MAX_VALUE)
        );
        DesktopPrincipalLayout.setVerticalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );

        menuClientes.setText("Planta");

        menuCadastrarClientes.setText("Cadastrar plantas");
        menuCadastrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuCadastrarClientes);

        jMenuBar1.add(menuClientes);

        menuProdutos.setText("Regar");

        menuCadastrarProdutos.setText("Arbusto");
        menuCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(menuCadastrarProdutos);

        menuPesquisarProdutos.setText("Arvore");
        menuPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(menuPesquisarProdutos);

        menuPesquisarProdutos1.setText("Flor");
        menuPesquisarProdutos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarProdutos1ActionPerformed(evt);
            }
        });
        menuProdutos.add(menuPesquisarProdutos1);

        jMenuBar1.add(menuProdutos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = DesktopPrincipal.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    private void menuCadastrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarClientesActionPerformed
        if (cadstroPlanta == null || !cadstroPlanta.isDisplayable()) {
            cadstroPlanta = new CadastroPlanta();
            DesktopPrincipal.add(cadstroPlanta);
            this.openFrameInCenter(cadstroPlanta);
        }
        cadstroPlanta.toFront();
    }//GEN-LAST:event_menuCadastrarClientesActionPerformed

    private void menuCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarProdutosActionPerformed
        
    }//GEN-LAST:event_menuCadastrarProdutosActionPerformed

    private void menuPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarProdutosActionPerformed
       
    }//GEN-LAST:event_menuPesquisarProdutosActionPerformed

    private void menuPesquisarProdutos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarProdutos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPesquisarProdutos1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCadastrarClientes;
    private javax.swing.JMenuItem menuCadastrarProdutos;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuPesquisarProdutos;
    private javax.swing.JMenuItem menuPesquisarProdutos1;
    private javax.swing.JMenu menuProdutos;
    // End of variables declaration//GEN-END:variables
}
