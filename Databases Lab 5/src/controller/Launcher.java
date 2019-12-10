package controller;

import model.ArtistDAO;
import model.SongDAO;
import view.MainFrame;


public class Launcher {
    public static void main(String[] args) {
        ArtistDAO artistDAO = new ArtistDAO();
        SongDAO songDAO = new SongDAO();
        MainFrame mainFrame = new MainFrame("Artist/Song Database Program");
        Controller controller = new Controller(artistDAO, songDAO, mainFrame);
    }
}
