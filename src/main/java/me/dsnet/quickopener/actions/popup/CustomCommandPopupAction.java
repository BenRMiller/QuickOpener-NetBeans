package me.dsnet.quickopener.actions.popup;

import javax.swing.Icon;
import org.openide.windows.WindowManager;

/**
 *
 * @author SessonaD
 */
/*
@NbBundle.Messages("CTL_CustomCommandPopupAction=Launch custom command...")
@ActionID(id = "me.dsnet.quickopener.actions.popup.CustomCommandPopupAction", category = "Tools")
@ActionRegistration(displayName = "#CTL_CustomCommandPopupAction", iconInMenu = true)
@ActionReference(path = "Shortcuts", name = "O-5")
*/
public class CustomCommandPopupAction extends PopupAction {

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
