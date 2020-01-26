package me.dsnet.quickopener.actions.popup;

import javax.swing.Icon;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/**
 *
 * @author SessonaD
 */
@ActionID(
    category = "File",
    id = "me.dsnet.quickopener.actions.popup.CustomCommandPopupAction"
)
@ActionRegistration(
    displayName = "#CTL_CustomCommandPopupAction", lazy = false
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 955),
    @ActionReference(path = "Loaders/Languages/Actions", position = 1000),
    @ActionReference(path = "Shortcuts", name = "O-5")
})
@NbBundle.Messages("CTL_CustomCommandPopupAction=Launch Custom Command...")
public class CustomCommandPopupAction extends PopupAction {

    public CustomCommandPopupAction() {
        super();
    }

    public CustomCommandPopupAction(String name) {
        super(name);
    }

    public CustomCommandPopupAction(String name, Icon icon) {
        super(name, icon);
    }

    @Override
    protected PopupActionDialog initDialog() {
        return new DialogCustomCommandRun(WindowManager.getDefault().getMainWindow(), true);    
    }

    @Override
    protected void executeCommand(String command) throws Exception {
    }

}
