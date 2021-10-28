package com.game.finder.player;

import com.game.finder.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//<type of object, type of the primary key/id for the object>
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

    //We could run it without the @Query tag, but just leave it to be more specific.
    //This is JPQL, not straight SQL
    //It is a query method, so it can run its own, thanks to JPA ;)
    @Query("SELECT s FROM Player s WHERE s.email = ?1")
    Optional<Player> findPlayerByEmail(String email);
}
