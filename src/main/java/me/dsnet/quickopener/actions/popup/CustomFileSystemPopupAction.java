package me.dsnet.quickopener.actions.popup;

import com.sessonad.oscommands.commands.Commands;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.Icon;
import org.openide.windows.WindowManager;

/**
 *
 * @author SessonaD
 */
//@ActionID(category = "Tools",id = "com.sessonad.quickopener.actions.popup.CustomFileSystemPopupAction")
//@ActionRegistration(displayName = "#CTL_CustomFileSystemPopupAction")
//@ActionReferences({
//    @ActionReference(path = "Shortcuts", name = "O-5")
//})
/*
@NbBundle.Messages("CTL_CustomFileSystemPopupAction=Open filesystem in...")
@ActionID(id = "me.dsnet.quickopener.actions.popup.CustomFileSystemPopupAction", category = "Tools")
@ActionRegistration(displayName = "#CTL_CustomFileSystemPopupAction", iconInMenu = true)
@ActionReference(path = "Shortcuts", name = "O-6")
*/
public class CustomFileSystemPopupAction extends PopupAction {

    private static final Logger LOG = Logger.getLogger(CustomFileSystemPopupAction.class.getName());
    
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
