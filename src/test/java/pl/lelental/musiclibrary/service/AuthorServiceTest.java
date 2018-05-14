package pl.lelental.musiclibrary.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.lelental.musiclibrary.TestConfiguration;
import pl.lelental.musiclibrary.model.Album;
import pl.lelental.musiclibrary.model.Author;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Paweł Lelental
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    private Author author;

    @Test
    public void testAdding() {
        testData("1");
        assertTrue(authorService.saveAuthor(author));
    }

    @Test
    public void testDelete() {
        testData("2");
        assertTrue(authorService.saveAuthor(author));
        Author retrievedAuthor = authorService.findByName(author.getName());
        assertTrue(authorService.deleteAuthor(retrievedAuthor.getId()));
    }

    @Test
    public void testUpdate() {
        testData("3");
        assertTrue(authorService.saveAuthor(author));
        Author authorWithNewName = new Author();
        Author retrievedAuthor = authorService.findByName(author.getName());
        authorWithNewName.setId(retrievedAuthor.getId());
        authorWithNewName.setName("Rammstein");
        authorWithNewName.setDateOfCreation(retrievedAuthor.getDateOfCreation());
        authorWithNewName.setAlbumList(retrievedAuthor.getAlbumList());
        assertTrue(authorService.updateAuhtor(authorWithNewName));
    }


    private void testData(String name) {
        author = new Author();
        author.setName("IRA" + name);
        author.setDateOfCreation(new Date(1995, 3, 3));
        Album album1 = new Album();
        album1.setAuthor(author);
        album1.setName("Test" + name);
        album1.setDateOfPublish(new Date(1999, 3, 3));
        Album album2 = new Album();
        album2.setName("Test2" + name);
        album2.setDateOfPublish(new Date(2000, 1, 1));
        album2.setAuthor(author);
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        author.setAlbumList(albums);
    }
}