package me.dsnet.quickopener.actions.popup;

import com.sessonad.oscommands.commands.Commands;
import java.io.File;
import java.util.logging.Logger;
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
    id = "me.dsnet.quickopener.actions.popup.CustomFileSystemPopupAction"
)
@ActionRegistration(
    displayName = "#CTL_CustomFileSystemPopupAction", lazy = false
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 955),
    @ActionReference(path = "Loaders/Languages/Actions", position = 1000),
    @ActionReference(path = "Shortcuts", name = "O-6")
})
@NbBundle.Messages("CTL_CustomFileSystemPopupAction=Open filesystem in...")
public class CustomFileSystemPopupAction extends PopupAction {

    private static final Logger LOG = Logger.getLogger(CustomFileSystemPopupAction.class.getName());

    public CustomFileSystemPopupAction() {
        super();
    }
    
    public CustomFileSystemPopupAction(String name) {
        super(name);
    }
    
    public CustomFileSystemPopupAction(String name, Icon icon) {
        super(name, icon);
    }

    @Override
    protected PopupActionDialog initDialog() {
        return new DialogCustomFileSystem(WindowManager.getDefault().getMainWindow(), true);
    }

    @Override
    protected void executeCommand(String command) throws Exception {
        File userFile=new File(command);
        Commands.getPlatform().browseInFileSystem(userFile);
    }
}
