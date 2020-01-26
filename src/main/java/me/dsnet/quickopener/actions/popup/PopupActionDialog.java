package me.dsnet.quickopener.actions.popup;

import java.awt.Frame;
import java.awt.Rectangle;
import javax.swing.JDialog;

/**
 * A dialog that returns a status and, on success, a command to be run
 * 
 * @author bmiller
 */
public abstract class PopupActionDialog extends JDialog {
    public enum ReturnStatus {
        OK,
        CANCEL
    };

    private ReturnStatus returnStatus = ReturnStatus.CANCEL;

    public PopupActionDialog(Frame parent, boolean modal) {
        super(parent, modal);
    }

    public ReturnStatus showDialog() {
        setVisible(true);
        return returnStatus;
    }

    protected void doClose(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
        setVisible(false);
        dispose();
    }

    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public abstract String getCommand();

    /**
     * Center dialog on same screen as parent
     */
    public void center() {
        final Rectangle screen = getGraphicsConfiguration().getBounds();
        final int x = screen.x + (screen.width - getWidth()) / 2;
        final int y = screen.y + (screen.height - getHeight()) / 2;
        setLocation(x, y);
    }
}
