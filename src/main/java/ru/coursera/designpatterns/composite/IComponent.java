package ru.coursera.designpatterns.composite;

public interface IComponent {

    /**
     * Rendering a playlist or a song to play
     */
    void play();

    /**
     * Setting playback speed for a currently playing song.
     */
    void setPlaybackSpeed(float speed);

    /**
     * Retrieving a name for this playlist or song.
     */
    String getName();
}
