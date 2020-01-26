/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.actions.popup;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;
import static me.dsnet.quickopener.LAFUtils.convertToLink;
import me.dsnet.quickopener.PathFinder;
import me.dsnet.quickopener.QuickMessages;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.ImageUtilities;

/**
 *
 * @author SessonaD
 */
public class DialogCustomTerminal extends PopupActionDialog {

    public static final int CHARSNUMBER = 80;
    private String selectioPath;
    private String mynetbeansPath;
    private String mainProjectPath;

    /**
     * Creates new form DialogCustomCommand
     */
    public DialogCustomTerminal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTable2.setModel(new PropertyTableModel("folder"));
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(400);
        jTable2.getColumnModel().getColumn(0).setMinWidth(100);
        mainProjectPath=PathFinder.getMainProjectRootPath();
        if(mainProjectPath!=null){
            jLabel8.setEnabled(true);
            jLabel8.setText(convertToLink(getPathLongerThan(mainProjectPath)));
        }
        selectioPath=PathFinder.getActivePath(null,true);
        if(selectioPath!=null){
            jLabel9.setEnabled(true);
            jLabel9.setText(convertToLink(getPathLongerThan(selectioPath)));
        }
        mynetbeansPath=PathFinder.getMyNetbeansConfPath();
        if(mynetbeansPath!=null){
            jLabel7.setEnabled(true);
            jLabel7.setText(convertToLink(getPathLongerThan(mynetbeansPath)));
        }
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(ReturnStatus.CANCEL);
            }
        });
    }
    
    private String getPathLongerThan(String path){
        if(path.length()>=CHARSNUMBER){            
            String intpath = path.substring(path.length()-CHARSNUMBER);
            int idx = intpath.indexOf("\\");
            if(idx!=-1){
                return "..." + intpath.substring(idx);
            }
            int adx = intpath.indexOf("/");
            if(adx!=-1){
                return "..." + intpath.substring(adx);
            }
            return "..." + intpath;
        }else{
            return path;
        }
    }
    
    public String getCommand(){
        return cmdTextField.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cmdTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setTitle(org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.title")); // NOI18N
        setIconImage(ImageUtilities.mergeImages(ImageUtilities.loadImage("me/dsnet/quickopener/icons/terminal16.png",false), ImageUtilities.loadImage("me/dsnet/quickopener/icons/run16.png",false), 7, 7));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.okButton.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmdTextField, org.jdesktop.beansbinding.ELProperty.create("${not empty text}"), okButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.cancelButton.text")); // NOI18N
        cancelButton.setRequestFocusEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        cmdTextField.setText(org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.cmdTextField.text")); // NOI18N

        jLabel1.setLabelFor(cmdTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel1.text")); // NOI18N
        jLabel1.setRequestFocusEnabled(false);

        jLabel2.setIcon(new ImageIcon(ImageUtilities.mergeImages(ImageUtilities.loadImage("me/dsnet/quickopener/icons/terminal48.png",false), ImageUtilities.loadImage("me/dsnet/quickopener/icons/run24.png",false), 28, 28)));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel2.text")); // NOI18N

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setFillsViewportHeight(true);
        jTable2.setFocusable(false);
        jTable2.setRequestFocusEnabled(false);
        jTable2.setShowVerticalLines(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setLabelFor(jTable2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel3.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setLabelFor(jLabel9);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setLabelFor(jLabel8);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel5.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setLabelFor(jLabel7);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel7.text")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel8.text")); // NOI18N
        jLabel8.setEnabled(false);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel9.text")); // NOI18N
        jLabel9.setEnabled(false);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/dsnet/quickopener/icons/help16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(DialogCustomTerminal.class, "DialogCustomTerminal.jLabel10.text")); // NOI18N
        jLabel10.setToolTipText("<html><a href=\"#\">Click on any path to set the input box.</a><br/>\n<br/>\nYou can customize the your preferred places in:<br/>\n<a href=\"#\">Tools > Options > Miscellaneous > QuickOpener</a>\n</html>"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(okButton)
                    .addComponent(cancelButton)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, jLabel10, okButton});

        getRootPane().setDefaultButton(okButton);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        File file= new File(cmdTextField.getText());
        if(file.exists()&& file.isDirectory()){
            doClose(ReturnStatus.OK);
        }else{
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.NOT_IN_FILE_SYSTEM,NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d); 
        }
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(ReturnStatus.CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(ReturnStatus.CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 1) {
            final int thisrow = jTable2.getSelectedRow();
            if (-1 != thisrow) {
                final int row = jTable2.getRowSorter().convertRowIndexToModel(thisrow);
                String path = (String) jTable2.getModel().getValueAt(row, 1);
                cmdTextField.setText(path);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if(jLabel7.isEnabled()){
            cmdTextField.setText(mynetbeansPath);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if(jLabel8.isEnabled()){
            cmdTextField.setText(mainProjectPath);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(jLabel9.isEnabled()){
            cmdTextField.setText(selectioPath);
        }
    }//GEN-LAST:event_jLabel9MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCustomTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DialogCustomTerminal dialog = new DialogCustomTerminal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cmdTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton okButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
