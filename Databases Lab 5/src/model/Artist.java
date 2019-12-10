package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<Song> songs;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(int id) {
        songs.removeIf(song -> song.getId() == id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getSongCount() {
        return songs.size();
    }
}
