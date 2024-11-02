package com.music.service;

import com.music.model.Song;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private List<Song> songs = new LinkedList<>();

    //adding a song to the list
    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added: " + song);
    }

    //removing a song from the list
    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
    }

    //displaying the songs present in the list
    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            songs.forEach(song -> System.out.println(song));
        }
    }

    //reordering the songs indexes in the list
    public void reorderSong(int oldIndex, int newIndex) {
        if (oldIndex < 0 || oldIndex >= songs.size() || newIndex < 0 || newIndex >= songs.size()) {
            System.out.println("Invalid indices.");
            return;
        }
        Song song = songs.remove(oldIndex);
        songs.add(newIndex, song);
    }

    //searching for a particular song in the list
    public Song searchSong(String title) {
        return songs.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
