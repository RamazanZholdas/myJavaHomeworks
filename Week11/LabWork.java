package com.company;

import java.util.*;
import java.io.*;

/*
Lab work 11 Zholdas Ramazan ITIS - 1913r
 */
public class LabWork {
    public static void main(String[] args) throws InterruptedException{
        Spotify.standardAmount();
        Scanner s = new Scanner(System.in);
        boolean globalLock = true;
        while(globalLock){
            System.out.println("Welcome to lab 11!");
            boolean localLock = true;
            while(localLock){
                System.out.println("1)Create user account \n" +
                        "2)Create artist account \n" +
                        "3)Go into the Spotify");
                int choice1 = s.nextInt();
                s.nextLine();
                switch(choice1){
                    case 1:
                        System.out.println("Pls write ur name:");
                        String name1 = s.nextLine();
                        System.out.println("Pls write ur lastName");
                        String lastName1 = s.nextLine();
                        System.out.println("Pls create password \n" +
                                "Password requirements:\n" +
                                "a)Password must contain at least one digit [0-9].\n" +
                                "b)Password must contain at least one lowercase Latin character [a-z].\n" +
                                "c)Password must contain at least one uppercase Latin character [A-Z].\n" +
                                "d)Password must contain at least one special character like ! @ # & ( ).\n" +
                                "e)Password must contain a length of at least 8 characters and a maximum of 20 characters.");
                        String password1 = s.nextLine();
                        while(!password1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
                            System.out.println("Invalid Password try again");
                            password1 = s.nextLine();
                        }
                        System.out.println("Password is valid, account created!");
                        Spotify.addUser(new User(name1,lastName1,password1));
                        break;
                    case 2:
                        System.out.println("Pls write ur nickName:");
                        String name2 = s.nextLine();
                        System.out.println("Pls create password \n" +
                                "Password requirements:\n" +
                                "a)Password must contain at least one digit [0-9].\n" +
                                "b)Password must contain at least one lowercase Latin character [a-z].\n" +
                                "c)Password must contain at least one uppercase Latin character [A-Z].\n" +
                                "d)Password must contain at least one special character like ! @ # & ( ).\n" +
                                "e)Password must contain a length of at least 8 characters and a maximum of 20 characters.");
                        String password2 = s.nextLine();
                        while(!password2.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
                            System.out.println("Invalid Password try again");
                            password2 = s.nextLine();
                        }
                        System.out.println("Password is valid, account created!");
                        Spotify.addArtist(new Artist(name2,password2));
                        break;
                    case 3:
                        localLock = false;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            boolean choice3 = true;
            localLock = true;
            while (localLock){
                System.out.println("1)Login as an user \n" +
                        "2)Login as an artist");
                int choice2 = s.nextInt();
                s.nextLine();
                switch (choice2){
                    case 1:
                        System.out.println("Pls write ur name:");
                        String name1 = s.nextLine();
                        System.out.println("Pls write ur lastname");
                        String lastname1 = s.nextLine();
                        System.out.println("Pls write ur password");
                        String password1 = s.nextLine();
                        if(Spotify.LoginUser(name1,lastname1,password1)){
                            choice3 = true;
                            localLock = false;
                        }
                        break;
                    case 2:
                        System.out.println("Pls write ur nickname");
                        String nickname = s.nextLine();
                        System.out.println("Pls write ur password");
                        String password2 = s.nextLine();
                        if(Spotify.LoginArtist(nickname,password2)){
                            choice3 = false;
                            localLock = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            localLock = true;
            if (choice3) {
                while (localLock) {
                    System.out.println("1)All songs in spotify \n" +
                            "2)Create playlist \n" +
                            "3)See own playlist \n" +
                            "4)Press like to playlist \n" +
                            "5)See other users playlist \n" +
                            "6)See all artists \n" +
                            "7)Log out from spotify \n" +
                            "8)Exit program");
                    int choice = s.nextInt();
                    s.nextLine();
                    switch (choice){
                        case 1:
                            Spotify.seeAllSongs();
                            break;
                        case 2:
                            System.out.println("Pls write playlist name");
                            String name1 = s.nextLine();
                            System.out.println("Pls write date");
                            String date1 = s.nextLine();
                            System.out.println("Pls write category");
                            String category1 = s.nextLine();
                            Spotify.createPlaylistForUser(name1,date1,category1);
                            break;
                        case 3:
                            Spotify.ownPlaylistOfUser();
                            break;
                        case 4:
                            Spotify.showAllPlaylists();
                            System.out.println("Choose one of them");
                            int choice2 = s.nextInt();
                            s.nextLine();
                            Spotify.pressLike(--choice2);
                            break;
                        case 5:
                            Spotify.showAllPlaylists();
                            break;
                        case 6:
                            Spotify.seeAllArtists();
                            break;
                        case 7:
                            localLock = false;
                            break;
                        case 8:
                            globalLock = false;
                            localLock = false;
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                }
            }
            else {
                while (localLock) {
                    System.out.println("1)Add song! \n" +
                            "2)Create playlist \n" +
                            "3)See own playlist \n" +
                            "4)Log out from spotify \n" +
                            "5)Exit program");
                    int choice = s.nextInt();
                    s.nextLine();
                    switch(choice){
                        case 1:
                            System.out.println("Write songs name");
                            String name = s.nextLine();
                            System.out.println("Write songs duration");
                            String duration = s.nextLine();
                            System.out.println("Write albums name");
                            String albumsName = s.nextLine();
                            Spotify.addSong(name,duration,albumsName);
                            break;
                        case 2:
                            System.out.println("Pls write playlist name");
                            String name1 = s.nextLine();
                            System.out.println("Pls write date");
                            String date1 = s.nextLine();
                            System.out.println("Pls write category");
                            String category1 = s.nextLine();
                            Spotify.createPlaylistForArtist(name1,date1,category1);
                            break;
                        case 3:
                            Spotify.ownPlaylistOfArtist();
                            break;
                        case 4:
                            localLock = false;
                            break;
                        case 5:
                            globalLock = false;
                            localLock = false;
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                }
            }
        }
        try {
            File file = new File("Text.txt");
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(Spotify.writeSongsAndPlaylists());
            fw.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Spotify{
    private static List<Song> songs = new LinkedList<>();
    private static List<Artist> artists = new LinkedList<>();
    private static List<Playlist> playlists = new LinkedList<>();
    private static List<User> users = new LinkedList<>();
    private static StringBuilder songsForExporting = new StringBuilder();
    private static StringBuilder PlaylistForExporting = new StringBuilder();
    private static int onlineUserId;
    private static int onlineArtistId;

    static String writeSongsAndPlaylists(){
        return songsForExporting.append("\n").append(PlaylistForExporting.toString()).toString();
    }

    static void addSong(String name, String duration, String albumsName){
        songs.add(new Song(name, duration,artists.get(onlineArtistId),albumsName));
        addSongForExporting(name,duration,albumsName);
    }

    static void seeAllArtists(){
        int i = 1;
        for(Artist x : artists){
            System.out.println(i + ")" +x.getNickname());
            i++;
        }
    }

    static void ownPlaylistOfArtist(){
        artists.get(onlineArtistId).printAllPlaylists();
    }

    static void ownPlaylistOfUser(){
        users.get(onlineUserId).printAllPlaylists();
    }

    static void showAllPlaylists(){
        if(playlists.size() == 0){
            System.out.println("Dont have playlist");
            return;
        }
        int i = 1;
        for(Playlist x : playlists){
            System.out.println(i +")" + x);
            i++;
        }
    }

    static void pressLike(int i){
        playlists.get(i).setLikeCounter(playlists.get(i).getLikeCounter() + 1);
    }

    static void createPlaylistForArtist(String name, String date, String category){
        playlists.add(new Playlist(name,date,category,artists.get(onlineArtistId).getNickname()));
        addPlaylistForExporting(name, date, category,artists.get(onlineArtistId).getNickname());
        artists.get(onlineArtistId).addPlaylist(new Playlist(name,date,category,users.get(onlineUserId).getName()));
    }

    static void createPlaylistForUser(String name, String date, String category){
        playlists.add(new Playlist(name,date,category,users.get(onlineUserId).getName()));
        addPlaylistForExporting(name, date, category,users.get(onlineUserId).getName());
        users.get(onlineUserId).addPlaylist(new Playlist(name,date,category,users.get(onlineUserId).getName()));
    }

    private static void addPlaylistForExporting(String name, String date, String category, String ownerName){
        for(Playlist x : playlists){
            if(x.getName().equals(name) && x.getCategory().equals(category) && x.getDate().equals(date) && x.getOwnerName().equals(ownerName)){
                PlaylistForExporting.append(x.toString() + "\n");
            }
        }
    }

    private static void addSongForExporting(String name, String duration, String albumsName){
        for(Song x : songs){
            if(x.getName().equals(name) && x.getDuration().equals(duration) && x.getAlbum().equals(albumsName)){
                songsForExporting.append(x.toString() + "\n");
            }
        }
    }

    static void seeAllSongs(){
        int i = 1;
        for(Song x : songs){
            System.out.println(i + ")" + x.toString());
            i++;
        }
    }

    static boolean LoginUser(String name, String lastName, String password){
        int i = 0;
        for(User x : users){
            if(x.getName().equals(name) && x.getLastName().equals(lastName) && x.getPassword().equals(password)){
                System.out.println("Congratulations! You have logged successfully");
                onlineUserId = i;
                return true;
            }
            i++;
        }
        System.out.println("Invalid input rewrite ur data");
        return false;
    }

    static boolean LoginArtist(String nickname, String password){
        int i = 0;
        for(Artist x : artists){
            if(x.getNickname().equals(nickname) && x.getPassword().equals(password)){
                System.out.println("Congratulations! You have logged successfully");
                onlineArtistId = i;
                return true;
            }
            i++;
        }
        System.out.println("Invalid input rewrite ur data");
        return false;
    }

    static void standardAmount(){
        artists.add(new Artist("Valentin Strikalo", "qwerty123"));
        songs.add(new Song("Bespolezno", "3:12", artists.get(0),"Entertainment"));
        songsForExporting.append("Here is all songs: \n" +
                songs.get(0).toString() + "\n");
    }

    static void addUser(User user){
        users.add(user);
    }

    static void addArtist(Artist artist){
        artists.add(artist);
    }
}

class Playlist{
    private List<Song> songs = new ArrayList<>();
    private String name;
    private String date;
    private String category;
    private int amountOfSongs;
    private int likeCounter = 0;
    private String ownerName;

    public Playlist(String name, String date, String category, String ownerName) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", likeCounter=" + likeCounter +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public void addSongToThePlaylist(Song song){
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return amountOfSongs == playlist.amountOfSongs &&
                likeCounter == playlist.likeCounter &&
                Objects.equals(songs, playlist.songs) &&
                name.equals(playlist.name) &&
                date.equals(playlist.date) &&
                category.equals(playlist.category) &&
                ownerName.equals(playlist.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songs, name, date, category, amountOfSongs, likeCounter, ownerName);
    }
}

class Song{
    private String name;
    private String duration;
    private Artist artist;
    private String album;

    public Song(String name, String duration, Artist artist, String album) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", artist=" + artist.getNickname() +
                ", album='" + album + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}

class Artist{
    private List<Playlist> userPlaylist = new LinkedList<>();
    private static int idGenerator = 1;
    private String nickname;
    private int id;
    private String password;

    public Artist(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
        this.id = idGenerator;
        idGenerator++;
    }

    public void addPlaylist(Playlist playlist){
        userPlaylist.add(playlist);
    }

    public void printAllPlaylists(){
        if(userPlaylist.size() == 0){
            System.out.println("Dont have playlist");
            return;
        }
        int i = 1;
        for(Playlist x : userPlaylist){
            System.out.println(i + ")" + x);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

class User{
    private List<Playlist> userPlaylist = new LinkedList<>();
    private static int idGenerator = 1;
    private String name;
    private String lastName;
    private int id;
    private String password;

    public User(String name, String lastName, String password){
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this. id = idGenerator;
        idGenerator++;
    }

    public boolean havePlaylist(){
        return userPlaylist.size() != 0;
    }

    public boolean checkForPlaylist(Playlist playlist){
        return userPlaylist.contains(playlist);
    }

    public void addPlaylist(Playlist playlist){
        userPlaylist.add(playlist);
    }

    public void printAllPlaylists(){
        if(userPlaylist.size() == 0){
            System.out.println("Dont have playlist");
            return;
        }
        int i = 1;
        for(Playlist x : userPlaylist){
            System.out.println(i + ")" + x);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}