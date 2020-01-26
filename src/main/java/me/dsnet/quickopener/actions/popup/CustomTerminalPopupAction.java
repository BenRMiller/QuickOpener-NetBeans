package me.dsnet.quickopener.actions.popup;

import com.sessonad.oscommands.commands.Commands;
import javax.swing.Icon;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/**
 *
 * @author SessonaD
 */
//@ActionID(category = "Tools",id = "com.sessonad.quickopener.actions.popup.CustomTerminalPopupAction")
//@ActionRegistration(displayName = "#CTL_CustomTerminalPopupAction")
//@ActionReferences({
//    @ActionReference(path = "Shortcuts", name = "O-6")
//})
@NbBundle.Messages("CTL_CustomTerminalPopupAction=Open shell in...")
public class CustomTerminalPopupAction extends PopupAction {

    public CustomTerminalPopupAction(String name, Icon icon) {
        super(name, icon);
    }

    @Override
    protected PopupActionDialog initDialog() {
        return new DialogCustomTerminal(WindowManager.getDefault().getMainWindow(), true); 
    }

    @Override
    protected void executeCommand(String command) throws Exception {
        Commands.getPlatform().openInShell(command);
    }
}
