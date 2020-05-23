package ru.coursera.designpatterns.composite;

import java.util.ArrayList;

public class Playlist implements IComponent {

    public String playlistName;
    public ArrayList<IComponent> playlist = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public void play() {
        // Logic to play this playlist
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        // Setting a playback speed
    }

    @Override
    public String getName() {
        return playlistName;
    }

    /**
     * Adding a playlist or a song to a current playlist.
     *
     * @param component playlist or a song
     */
    void add(IComponent component) {
        playlist.add(component);
    }

    /**
     * Removing a playlist or a song from a current playlist.
     *
     * @param component playlist or a song
     */
    void remove(IComponent component) {
        playlist.remove(component);
    }
}
