package me.dsnet.quickopener.actions.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Icon;

/**
 * Abstract class for an action that shows a PopupActionDialog and runs the command it returns.
 *
 * @author bmiller
 */
public abstract class PopupAction extends AbstractAction implements ActionListener {

    private static final Logger LOG = Logger.getLogger(PopupAction.class.getName());

    public PopupAction() {
        super();
    }

    public PopupAction(String name) {
        super(name);
    }

    public PopupAction(String name, Icon icon) {
        super(name, icon);
    }

    /**
     * Override this method to create the dialog
     * @return 
     */
    protected abstract PopupActionDialog initDialog();

    /**
     * Override this method to execute the command returned by the dialog
     * @param command
     * @throws Exception 
     */
    protected abstract void executeCommand(String command) throws Exception;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PopupActionDialog dialog = initDialog();
                    dialog.center();

                    if (dialog.showDialog() == PopupActionDialog.ReturnStatus.OK) {
                        executeCommand(dialog.getCommand());
                    }
                } catch (Exception ex) {
                    LOG.log(Level.SEVERE, "Error opening Custom Action Dialog", ex);
                }
            }
        });
    }
}
