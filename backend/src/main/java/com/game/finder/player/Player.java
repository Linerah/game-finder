package com.game.finder.player;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;

// to map player to DB:
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity //hibernate
@Table  // table in database
public class Player implements Serializable, UserDetails {
    // The class going to be in different types of stream (JSON, object, ect..) with the DB.
    //That is why it implements Serializable, it helps the process.
    @SequenceGenerator(
            name= "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    //some variables may change, because they are related to authentication. ;)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private AppPlayerRole appPlayerRole;
    private Boolean locked = false;
    private Boolean enabled = false;
//    @Transient //makes it so there is no column in DB for the value below
//    private Integer age;

    public Player(String name,
                  String username,
                  String email, String password,
                  AppPlayerRole appPlayerRole) {
        this.firstName = name;
        this.lastName = username;
        this.email = email;
        this.password = password;
        this.appPlayerRole = appPlayerRole;
    }

    public Player(Long id,
                  String firstName,
                  String lastName,
                  String email,
                  String password,
//                  LocalDate dateOfBirth,
                  AppPlayerRole appPlayerRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
//        this.dateOfBirth = dateOfBirth;
        this.appPlayerRole = appPlayerRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appPlayerRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

//    public Integer getAge() {
//        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
//    }


}
