package application;

import java.awt.*;
import javax.swing.*;
import com.jidesoft.app.framework.*;
import com.jidesoft.app.framework.gui.*;
import com.jidesoft.app.framework.file.*;
import com.jidesoft.app.framework.gui.filebased.*;

/**
 *
 * FileBasedApplication.java
 *
 */
public class MainMujiForeignTrade implements 
   ApplicationLifecycleListener,
   MenuBarCustomizer,
   ToolBarCustomizer,
   HelpSource
{

   /**
    * The DesktopApplication instance
    */
   private FileBasedApplication application;

    /**
     * Construct a MainMujiForeignTrade.
     */
    public MainMujiForeignTrade() {
       
        // create a FileBasedApplication instance
        application = new FileBasedApplication(GUIApplication.DEFAULT_APPLICATION_STYLE);
      
        // install DataModels and DataViews
      
        // The FileBasedApplication installs its own Data and View Factories.
        // Simply add one or more file/view mappings here, for example...
        application.addFileMapping(new TextFileFormat(), TextView.class);

        // add as listener
        application.addLifecycleListener(this);
         
        // actions      
        installActions(application.getActionMap());

        // menus
        application.addMenuBarCustomizer(this);
    
        // toolbars
        application.addToolBarCustomizer(this);

        // help
        application.setHelp(this);
  
    }

    /**
     * Get the application instance.
     *
     * @return application instance
     */
    public GUIApplication getApplication() {
       return this.application;
    }

    /**
     * Topic can be set in the HelpAction. Add more HelpActions
     * for multiple topics.
     */
    public void openHelp(Object topic) {
    }
    
    /**
     * Install Actions. Try using GUIApplicationAction for better
     * perceived performance in menus and toolbars.
     */
    private void installActions(ActionMap actionMap) {
    }
    
    /**
     * Customize the Standard Menus.
     */
    public void customizeStandardMenu(String menuID, JMenu menu, ApplicationMenuBarsUI menusUI) {
    }
    
    /**
     * Return custom menus here.
     */
    public JMenu[] createApplicationMenus(ApplicationMenuBarsUI menusUI) {
       return null;
    }
    
    /**
     * Customize the standard toolbar. If using the Jide Action framework
     * toolbar is a CommandBarHolder, otherwise it's a JToolBar.
     */
    public void customizeStandardToolBar(String toolbarName, Container toolbar, ApplicationToolBarsUI toolbarsUI) {
    }
    
    /**
     * Return the names of custom toolbars here.
     */ 
    public String[] getToolbarNames() {
        return null;
    }
    
    /**
     * Create toolbars for each custom toolbar name.
     */
    public void createApplicationToolBar(String toolbarName, Container toolbar, ApplicationToolBarsUI toolbarsUI) {
    }

    /**
     * Before the UI us loaded. Throw an ApplicationVetoException to exit.
     *
     * @see com.jidesoft.app.framework.ApplicationLifecycleListener#applicationOpening(com.jidesoft.app.framework.ApplicationLifecycleEvent)
     */
    public void applicationOpening(ApplicationLifecycleEvent e) throws ApplicationVetoException {
    }
    
    /**
     * After the UI is loaded.
     *
     * @see com.jidesoft.app.framework.ApplicationLifecycleListener#applicationOpened(com.jidesoft.app.framework.ApplicationLifecycleEvent)
     */
    public void applicationOpened(ApplicationLifecycleEvent e) {
    }
    
    /**
     * Before the quitting procedure is begun, including the disposing of the UI.
     *
     * @see com.jidesoft.app.framework.ApplicationLifecycleListener#applicationClosing(com.jidesoft.app.framework.ApplicationLifecycleEvent)
     */
    public void applicationClosing(ApplicationLifecycleEvent e) throws ApplicationVetoException {
    }
    
    /**
     * After the application has closed, but before System.exit().
     *
     * @see com.jidesoft.app.framework.ApplicationLifecycleListener#applicationClosed(com.jidesoft.app.framework.ApplicationLifecycleEvent)
     */
    public void applicationClosed(ApplicationLifecycleEvent e) {
    }
    
    /**
     * Main
     *
     * @param args - program arguments
     */
    public static void main(String[] args) {

        // run application
        new MainMujiForeignTrade().getApplication().run(args);
    }
}
