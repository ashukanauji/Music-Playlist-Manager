package com.music.file;

import com.music.model.Song;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    //saving the current playlist
    public void savePlaylist(List<Song> songs, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Song song : songs) {
                writer.write(song.getTitle() + "," + song.getArtist() + "," + song.getDuration());
                writer.newLine();
            }
            System.out.println("Playlist saved successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loading a particular playlist from the specified path
    public List<Song> loadPlaylist(String filePath) {
        List<Song> songs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                songs.add(new Song(details[0], details[1], Integer.parseInt(details[2])));
            }
            System.out.println("Playlist loaded successfully from " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
