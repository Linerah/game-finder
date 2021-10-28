package com.game.finder.player;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

// to map player to DB:
@Entity //hibernate
@Table  // table in database
public class Player implements Serializable {
    // The class going to be in different types of stream (JSON, object, ect..) with the DB.
    //That is why it implements Serializable, it helps the process.
    @Id
    @SequenceGenerator(
            name= "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    //some variables may change, because they are related to authentication. ;)
    private Long id;
    private String name;
    private String username;
    private String email;
    private LocalDate dateOfBirth;
    @Transient //makes it so there is no column in DB for the value below
    private Integer age;

    public Player() {
    }

    public Player(Long id, String name, String username, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;

    }

    //  Constructor without id, because postgres generates one. ;P
    public Player(String name, String username, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
