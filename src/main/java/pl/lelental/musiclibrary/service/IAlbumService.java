package pl.lelental.musiclibrary.service;

import pl.lelental.musiclibrary.model.Album;

import java.util.List;

/**
 * @author Paweł Lelental
 **/
public interface IAlbumService {

    Album findById(long id);

    List<Album> findByAuthorId(long authorId);

    Album findByName(String name);

    boolean saveAlbum(Album album);

    boolean updateAlbum(Album album);

    boolean deleteAlbum(long id);
}
