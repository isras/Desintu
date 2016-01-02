package views;

import controller.service.PetitionService;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class InvoicePanel extends javax.swing.JPanel {

    private String imageDirectory;
    private ImageIcon ic;

    public InvoicePanel(String dir) {
        imageDirectory = dir;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newInvoiceBT = new javax.swing.JButton();
        editInvoiceBT = new javax.swing.JButton();
        invoiceCancellationBT = new javax.swing.JButton();
        searchInvoiceBT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 153, 187));
        setPreferredSize(new java.awt.Dimension(691, 528));

        newInvoiceBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newFactureButtonIcon.png"))); // NOI18N
        newInvoiceBT.setToolTipText("");
        newInvoiceBT.setBorderPainted(false);
        newInvoiceBT.setContentAreaFilled(false);
        newInvoiceBT.setPreferredSize(new java.awt.Dimension(119, 103));
        newInvoiceBT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newFactureButtonIconHover.png"))); // NOI18N
        newInvoiceBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newFactureButtonIconHover.png"))); // NOI18N
        newInvoiceBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newInvoiceBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newInvoiceBTMouseExited(evt);
            }
        });
        newInvoiceBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvoiceBTActionPerformed(evt);
            }
        });

        editInvoiceBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editFactureButtonIcon.png"))); // NOI18N
        editInvoiceBT.setToolTipText("");
        editInvoiceBT.setBorderPainted(false);
        editInvoiceBT.setContentAreaFilled(false);
        editInvoiceBT.setPreferredSize(new java.awt.Dimension(119, 103));
        editInvoiceBT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editFactureButtonIconHover.png"))); // NOI18N
        editInvoiceBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/editFactureButtonIconHover.png"))); // NOI18N
        editInvoiceBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editInvoiceBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editInvoiceBTMouseExited(evt);
            }
        });
        editInvoiceBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInvoiceBTActionPerformed(evt);
            }
        });

        invoiceCancellationBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/removeFactureButtonIcon.png"))); // NOI18N
        invoiceCancellationBT.setToolTipText("");
        invoiceCancellationBT.setBorderPainted(false);
        invoiceCancellationBT.setContentAreaFilled(false);
        invoiceCancellationBT.setPreferredSize(new java.awt.Dimension(119, 103));
        invoiceCancellationBT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/removeFactureButtonIconHover.png"))); // NOI18N
        invoiceCancellationBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/removeFactureButtonIconHover.png"))); // NOI18N
        invoiceCancellationBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceCancellationBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceCancellationBTMouseExited(evt);
            }
        });
        invoiceCancellationBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceCancellationBTActionPerformed(evt);
            }
        });

        searchInvoiceBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/searchFactureButtonIcon.png"))); // NOI18N
        searchInvoiceBT.setToolTipText("");
        searchInvoiceBT.setBorderPainted(false);
        searchInvoiceBT.setContentAreaFilled(false);
        searchInvoiceBT.setPreferredSize(new java.awt.Dimension(119, 103));
        searchInvoiceBT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/searchFactureButtonIconHover.png"))); // NOI18N
        searchInvoiceBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/searchFactureButtonIconHover.png"))); // NOI18N
        searchInvoiceBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchInvoiceBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchInvoiceBTMouseExited(evt);
            }
        });
        searchInvoiceBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInvoiceBTActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/eyetiveLogo.png"))); // NOI18N
        jLabel2.setToolTipText("");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/eyetiveLogoBig.png"))); // NOI18N
        logoLabel.setPreferredSize(new java.awt.Dimension(232, 242));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceCancellationBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(searchInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(editInvoiceBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceCancellationBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ic = new ImageIcon(getClass().getResource(getImageDirectory()));
        g.drawImage(ic.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private void newInvoiceBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvoiceBTActionPerformed
        // TODO add your handling code here:
        new InvoiceView(null, true, 1, "").setVisible(true);
    }//GEN-LAST:event_newInvoiceBTActionPerformed

    private void newInvoiceBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newInvoiceBTMouseEntered
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/newFactureBigLogo.png")));
    }//GEN-LAST:event_newInvoiceBTMouseEntered

    private void editInvoiceBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInvoiceBTMouseEntered
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/editFactureBigLogo.png")));
    }//GEN-LAST:event_editInvoiceBTMouseEntered

    private void invoiceCancellationBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCancellationBTMouseEntered
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/removeFactureBigLogo.png")));
    }//GEN-LAST:event_invoiceCancellationBTMouseEntered

    private void newInvoiceBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newInvoiceBTMouseExited
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/eyetiveLogoBig.png")));
    }//GEN-LAST:event_newInvoiceBTMouseExited

    private void editInvoiceBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInvoiceBTMouseExited
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/eyetiveLogoBig.png")));
    }//GEN-LAST:event_editInvoiceBTMouseExited

    private void invoiceCancellationBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCancellationBTMouseExited
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/eyetiveLogoBig.png")));
    }//GEN-LAST:event_invoiceCancellationBTMouseExited

    private void searchInvoiceBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchInvoiceBTMouseEntered
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/searchFactureBigLogo.png")));
    }//GEN-LAST:event_searchInvoiceBTMouseEntered

    private void searchInvoiceBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchInvoiceBTMouseExited
        // TODO add your handling code here:
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/buttons/eyetiveLogoBig.png")));
    }//GEN-LAST:event_searchInvoiceBTMouseExited

    private void editInvoiceBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInvoiceBTActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "FUNCIÓN SERÁ AÑADIDA PRÓXIMAMENTE");
    }//GEN-LAST:event_editInvoiceBTActionPerformed

    private void invoiceCancellationBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceCancellationBTActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(this, "FUNCIÓN SERÁ AÑADIDA PRÓXIMAMENTE");
        new CancelInvoice(null, true).setVisible(true);
    }//GEN-LAST:event_invoiceCancellationBTActionPerformed

    private void searchInvoiceBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInvoiceBTActionPerformed
        // TODO add your handling code here:
        new SearchInvoiceView(null, true).setVisible(true);
    }//GEN-LAST:event_searchInvoiceBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editInvoiceBT;
    private javax.swing.JButton invoiceCancellationBT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton newInvoiceBT;
    private javax.swing.JButton searchInvoiceBT;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the imageDirectory
     */
    public String getImageDirectory() {
        return imageDirectory;
    }

    /**
     * @param imageDirectory the imageDirectory to set
     */
    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }
}