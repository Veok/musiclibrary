package pl.lelental.musiclibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lelental.musiclibrary.model.Album;
import pl.lelental.musiclibrary.repository.IAlbumRepository;

import java.util.List;

/**
 * @author Paweł Lelental
 **/
@Service("alubService")
public class AlbumService implements IAlbumService {

    @Autowired
    IAlbumRepository albumRepository;

    @Override
    public Album findById(long id) {
        return albumRepository.findById(id);
    }

    @Override
    public List<Album> findByAuthorId(long authorId) {
        return albumRepository.findByAuthorId(authorId);
    }

    @Override
    public Album findByName(String name) {
        return albumRepository.findByName(name);
    }

    @Override
    public boolean saveAlbum(Album album) {
        try {
            albumRepository.save(album);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateAlbum(Album album) {
        try {
            Album retrievedAlbum = findById(album.getId());
            retrievedAlbum.setAuthor(album.getAuthor());
            retrievedAlbum.setDateOfPublish(album.getDateOfPublish());
            retrievedAlbum.setName(album.getName());
            albumRepository.save(retrievedAlbum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAlbum(long id) {
        try {
            albumRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
