package com.example.SongApi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2,  "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream()
                .filter(song -> song.getId() == id)
                .findFirst().
                orElse(null);
    }

    public void addSong(Song s) {
        s.setId(list.size() + 1);
        list.add(s);
    }

    public void updateSong(Song s) {
       list.stream()
               .filter(song -> song.getId() == s.getId())
               .findFirst()
               .ifPresent(songToUpdate -> {
                     songToUpdate.setNome(s.getNome());
                     songToUpdate.setArtista(s.getArtista());
                     songToUpdate.setAlbum(s.getAlbum());
                     songToUpdate.setAnoLancamento(s.getAnoLancamento());
                });
    }

    public void removeSong(Song s) {
        list.stream()
                .filter(song -> song.getId() == s.getId())
                .findFirst()
                .ifPresent(songToRemove -> list.remove(songToRemove));
    }
}
