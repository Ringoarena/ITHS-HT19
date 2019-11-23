package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private JSplitPane jSplitPane;

    public MainFrame(String title) {
        super(title);
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,formPanel,tablePanel);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(700,600));
        add(jSplitPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }
}
