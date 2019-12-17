package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu fileMenu, editMenu, viewMenu, helpMenu;
    private JMenuItem newItem, openItem, closeItem, exitItem, undoItem, redoItem, toolWindowsItem, appearanceItem, helpItem, checkforUpdatesItem, aboutItem;
    private JSplitPane mainSplitPane, formSplitPane, tableSplitPane;
    private AuthorFormPanel authorFormPanel;
    private AuthorTablePanel authorTablePanel;
    private BookFormPanel bookFormPanel;
    private BookTablePanel bookTablePanel;

    public MainFrame(String title) {
        super(title);
        setLayout(new BorderLayout());
        setupMenuBar();
        setupSplitPanes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1400,1000));
        setMinimumSize(new Dimension(1400,1000));
        setVisible(true);
    }

    private void setupSplitPanes() {
        authorFormPanel = new AuthorFormPanel();
        bookFormPanel = new BookFormPanel();
        authorTablePanel = new AuthorTablePanel();
        bookTablePanel = new BookTablePanel();
        formSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,authorFormPanel,bookFormPanel);
        tableSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,authorTablePanel,bookTablePanel);
        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,formSplitPane,tableSplitPane);
        add(mainSplitPane, BorderLayout.CENTER);
    }

    private void setupMenuBar() {
        jMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open...");
        closeItem = new JMenuItem("Close");
        exitItem = new JMenuItem("Exit");
        undoItem = new JMenuItem("Undo");
        redoItem = new JMenuItem("Redo");
        toolWindowsItem = new JMenuItem("Tool Windows");
        appearanceItem = new JMenuItem("Appearance");
        helpItem = new JMenuItem("Help");
        checkforUpdatesItem = new JMenuItem("Check for Updates...");
        aboutItem = new JMenuItem("About");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.add(exitItem);
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        viewMenu.add(toolWindowsItem);
        viewMenu.add(appearanceItem);
        helpMenu.add(helpItem);
        helpMenu.add(checkforUpdatesItem);
        helpMenu.add(aboutItem);
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(viewMenu);
        jMenuBar.add(helpMenu);
        setJMenuBar(jMenuBar);
    }

    public String updateEntity(int option) {
        switch (option) {
            case 0:
                return JOptionPane.showInputDialog("Enter new name");
            case 1:
                return JOptionPane.showInputDialog("Enter new title");
            case 2:
                return JOptionPane.showInputDialog("Enter author ID");
        }
        return null;
    }

    public JMenuBar getjMenuBar() {
        return jMenuBar;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    public JMenu getViewMenu() {
        return viewMenu;
    }

    public JMenu getHelpMenu() {
        return helpMenu;
    }

    public JMenuItem getNewItem() {
        return newItem;
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }

    public JMenuItem getCloseItem() {
        return closeItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getUndoItem() {
        return undoItem;
    }

    public JMenuItem getRedoItem() {
        return redoItem;
    }

    public JMenuItem getToolWindowsItem() {
        return toolWindowsItem;
    }

    public JMenuItem getAppearanceItem() {
        return appearanceItem;
    }

    public JMenuItem getHelpItem() {
        return helpItem;
    }

    public JMenuItem getCheckforUpdatesItem() {
        return checkforUpdatesItem;
    }

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    public JSplitPane getMainSplitPane() {
        return mainSplitPane;
    }

    public JSplitPane getFormSplitPane() {
        return formSplitPane;
    }

    public JSplitPane getTableSplitPane() {
        return tableSplitPane;
    }

    public AuthorFormPanel getAuthorFormPanel() {
        return authorFormPanel;
    }

    public AuthorTablePanel getAuthorTablePanel() {
        return authorTablePanel;
    }

    public BookFormPanel getBookFormPanel() {
        return bookFormPanel;
    }

    public BookTablePanel getBookTablePanel() {
        return bookTablePanel;
    }
}
