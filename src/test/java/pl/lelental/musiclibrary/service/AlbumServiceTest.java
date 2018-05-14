package pl.lelental.musiclibrary.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.lelental.musiclibrary.TestConfiguration;
import pl.lelental.musiclibrary.model.Album;
import pl.lelental.musiclibrary.model.Author;

import static org.junit.Assert.*;

/**
 * @author Paweł Lelental
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class AlbumServiceTest {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AlbumService albumService;

    private Album album;
    private Author author;

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

}