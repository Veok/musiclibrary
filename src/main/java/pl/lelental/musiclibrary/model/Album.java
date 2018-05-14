package pl.lelental.musiclibrary.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Paweł Lelental
 **/
@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateOfPublish;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
}
