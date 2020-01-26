package me.dsnet.quickopener.actions.popup;

import com.sessonad.oscommands.commands.Commands;
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
    id = "me.dsnet.quickopener.actions.popup.CustomTerminalPopupAction"
)
@ActionRegistration(
    displayName = "#CTL_CustomTerminalPopupAction", lazy = false
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 955),
    @ActionReference(path = "Loaders/Languages/Actions", position = 1000),
    @ActionReference(path = "Shortcuts", name = "O-7")
})
@NbBundle.Messages("CTL_CustomTerminalPopupAction=Open shell in...")
public class CustomTerminalPopupAction extends PopupAction {

    public CustomTerminalPopupAction() {
        super();
    }

    public CustomTerminalPopupAction(String name) {
        super(name);
    }

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
