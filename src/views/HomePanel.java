package views;

import controller.resources.Report;
import controller.service.WorkOrderService;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import views.tableModel.DetailTableModel;
import views.tableModel.WorkDiaryTableModel;

public class HomePanel extends javax.swing.JPanel {

    private ImageIcon ic;
    private final WorkOrderService wos;
    private final WorkDiaryTableModel wdtm;
    private final DetailTableModel dtm;
    private String imagePath;

    public HomePanel(String imagePath) {
        this.imagePath = imagePath;
        this.wos = new WorkOrderService();
        this.wdtm = new WorkDiaryTableModel();
        this.dtm = new DetailTableModel();
        initComponents();

        this.updateWorkOrderDiaryTable();

    }

    private void updateWorkOrderDiaryTable() {
        if (!this.wos.getWorkOrderListByState().isEmpty()) {
            this.wdtm.setList(this.wos.getWorkOrderListByState());
            this.workDiaryTable.setModel(wdtm);
            this.workDiaryTable.updateUI();
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

        workOrderOptionsPopupMenu = new javax.swing.JPopupMenu();
        workOrderViewMenuItem = new javax.swing.JMenuItem();
        editWorkOrderMenuItem = new javax.swing.JMenuItem();
        finishWorkOrderMenuItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        workDiaryTable = new javax.swing.JTable();

        workOrderViewMenuItem.setText("Visualizar ");
        workOrderViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workOrderViewMenuItemActionPerformed(evt);
            }
        });
        workOrderOptionsPopupMenu.add(workOrderViewMenuItem);

        editWorkOrderMenuItem.setText("Editar");
        editWorkOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWorkOrderMenuItemActionPerformed(evt);
            }
        });
        workOrderOptionsPopupMenu.add(editWorkOrderMenuItem);

        finishWorkOrderMenuItem.setText("Finalizar");
        finishWorkOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishWorkOrderMenuItemActionPerformed(evt);
            }
        });
        workOrderOptionsPopupMenu.add(finishWorkOrderMenuItem);

        setPreferredSize(new java.awt.Dimension(692, 528));

        workDiaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        workDiaryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workDiaryTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                workDiaryTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(workDiaryTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void workDiaryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workDiaryTableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
           // this.wos.setInstance(this.wdtm.getList().get(this.workDiaryTable.getSelectedRow()));
          //  new ReceiptView(null, true, wos).setVisible(true);
            //Actualizamos la tabla quitando los trabajos terminados y volviendo a cargar los pendientes
           // this.updateWorkOrderDiaryTable();
        }
    }//GEN-LAST:event_workDiaryTableMouseClicked

    private void workDiaryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workDiaryTableMousePressed
        // TODO add your handling code here:
        tableOptionsPopup(evt);
    }//GEN-LAST:event_workDiaryTableMousePressed

    private void workOrderViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workOrderViewMenuItemActionPerformed
        // TODO add your handling code here:
        Report report = new Report();
        dtm.setList(this.wos.getWorkOrder().getDetailList());
        report.printWorkOrder(wos,dtm);
    }//GEN-LAST:event_workOrderViewMenuItemActionPerformed

    private void finishWorkOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishWorkOrderMenuItemActionPerformed
        // TODO add your handling code here:
        this.wos.getWorkOrder().setWorkOrderState(3);
        if(this.wos.updateWorkOrder()){
            JOptionPane.showMessageDialog(this, "La orden de trabajo a terminado");
            this.updateWorkOrderDiaryTable();
        }
        
    }//GEN-LAST:event_finishWorkOrderMenuItemActionPerformed

    private void editWorkOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWorkOrderMenuItemActionPerformed
        // TODO add your handling code here:
        //Cargamos la instancia de una orden de trabajo 
        this.wos.setInstance(this.wdtm.getList().get(this.workDiaryTable.getSelectedRow()));
        //Cargamos la ventana de documento 
        new ReceiptView(null, true, wos, "WorkOrder", 1).setVisible(true);
        //Actualizamos la tabla quitando los trabajos terminados y volviendo a cargar los pendientes
        this.updateWorkOrderDiaryTable();
    }//GEN-LAST:event_editWorkOrderMenuItemActionPerformed

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ic = new ImageIcon(getClass().getResource(getImagePath()));
        g.drawImage(ic.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    private void tableOptionsPopup(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON3) {
            Point p = evt.getPoint();
            int rowNumber = workDiaryTable.rowAtPoint(p);
            ListSelectionModel modelo = workDiaryTable.getSelectionModel();
            modelo.setSelectionInterval(rowNumber, rowNumber);

            System.out.println("fila presionada " + workDiaryTable.getSelectedRow());
            //Cargamos una nueva instancia del una orden de trabajo
            this.wos.setInstance(this.wdtm.getList().get(this.workDiaryTable.getSelectedRow()));

            workOrderOptionsPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            workOrderOptionsPopupMenu.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editWorkOrderMenuItem;
    private javax.swing.JMenuItem finishWorkOrderMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workDiaryTable;
    private javax.swing.JPopupMenu workOrderOptionsPopupMenu;
    private javax.swing.JMenuItem workOrderViewMenuItem;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
