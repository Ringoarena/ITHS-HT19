package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane jTabbedPane;
    private ArtistFormPanel artistFormPanel;
    private SongFormPanel songFormPanel;
    private TablePanel tablePanel;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem viewArtists;
    private JMenuItem viewSongs;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        jTabbedPane = new JTabbedPane();
        artistFormPanel = new ArtistFormPanel();
        songFormPanel = new SongFormPanel();
        tablePanel = new TablePanel();
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("Show");
        viewArtists = new JMenuItem("Artists");
        viewSongs = new JMenuItem("Songs");

        jMenu.add(viewArtists);
        jMenu.add(viewSongs);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);


        jTabbedPane.addTab("Artist form", artistFormPanel);
        jTabbedPane.addTab("Song form",songFormPanel);
        jTabbedPane.setPreferredSize(new Dimension(260,600));

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
        add(jTabbedPane, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public ArtistFormPanel getArtistFormPanel() {
        return artistFormPanel;
    }

    public SongFormPanel getSongFormPanel() {
        return songFormPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public JMenuItem getViewArtists() {
        return viewArtists;
    }

    public JMenuItem getViewSongs() {
        return viewSongs;
    }
}
