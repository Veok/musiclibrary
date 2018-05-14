package pl.lelental.musiclibrary.service;

import org.junit.After;
import org.junit.Before;
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
    @Autowired
    private AlbumService albumService;

    private Author author;

    @Before
    public void setUp() {
        author = new Author();
        author.setName("IRA");
        author.setDateOfCreation(new Date(1995, 3, 3));

        Album album1 = new Album();
        album1.setAuthor(author);
        album1.setName("Test");
        album1.setDateOfPublish(new Date(1999, 3, 3));

        Album album2 = new Album();
        album2.setName("Test2");
        album2.setDateOfPublish(new Date(2000, 1, 1));
        album2.setAuthor(author);

        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);

        author.setAlbumList(albums);
        authorService.saveAuthor(author);
    }

    @After
    public void tearDown() {
        authorService.authorRepository.deleteAll();
        albumService.albumRepository.deleteAll();
    }

    @Test
    public void testAdding() {
        assertTrue(authorService.saveAuthor(author));
    }

    @Test
    public void testDelete() {
        Author retrievedAuthor = authorService.findByName(author.getName());
        assertTrue(authorService.deleteAuthor(retrievedAuthor.getId()));
    }

    @Test
    public void testUpdate() {
        Author authorWithNewName = new Author();
        Author retrievedAuthor = authorService.findByName(author.getName());
        authorWithNewName.setId(retrievedAuthor.getId());
        authorWithNewName.setName("Rammstein");
        authorWithNewName.setDateOfCreation(retrievedAuthor.getDateOfCreation());
        authorWithNewName.setAlbumList(retrievedAuthor.getAlbumList());
        assertTrue(authorService.updateAuhtor(authorWithNewName));
    }

    @Test
    public void testFindByName() {
        assertEquals(author.getName(), authorService.findByName(author.getName()).getName());
    }

    @Test
    public void testFindById(){
        author = authorService.findByName(author.getName());
        assertEquals(author.getId(), authorService.findById(author.getId()).getId());
    }


}