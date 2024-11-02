package com.music;

import com.music.model.Song;
import com.music.service.Playlist;
import com.music.file.FileHandler;
import java.util.Scanner;

public class MusicPlaylistManagerApp {
    public static void main(String[] args)  {
        Playlist playlist = new Playlist();
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMusic Playlist Manager");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Reorder Song");
            System.out.println("5. Search Song");
            System.out.println("6. Save Playlist");
            System.out.println("7. Load Playlist");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consumes newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (seconds): ");
                    int duration = scanner.nextInt();
                    playlist.addSong(new Song(title, artist, duration));
                }
                case 2 -> {
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    playlist.removeSong(title);
                }
                case 3 -> playlist.displayPlaylist();
                case 4 -> {
                    System.out.print("Enter current index: ");
                    int oldIndex = scanner.nextInt();
                    System.out.print("Enter new index: ");
                    int newIndex = scanner.nextInt();
                    playlist.reorderSong(oldIndex, newIndex);
                }
                case 5 -> {
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    Song song = playlist.searchSong(title);
                    System.out.println(song != null ? song : "Song not found.");
                }
                case 6 -> {
                    System.out.print("Enter file path to save: ");
                    String filePath = scanner.nextLine();
                    fileHandler.savePlaylist(playlist.getSongs(), filePath);
                }
                case 7 -> {
                    System.out.print("Enter file path to load: ");
                    String filePath = scanner.nextLine();
                    playlist.getSongs().clear();
                    playlist.getSongs().addAll(fileHandler.loadPlaylist(filePath));
                }
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}