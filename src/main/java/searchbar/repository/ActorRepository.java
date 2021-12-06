package searchbar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import searchbar.entity.Actors;

import java.util.List;

@Repository
public class ActorRepository {

    @Autowired
    private JdbcTemplate template;

    public Actors findActor(@Param("value") String actorName) {
        List<Actors> actors = template.query("SELECT a.id, name, age, nationality FROM content c, actores a, contenidos_has_actors ca " +
                        "WHERE c.id = ca.contenido_id AND ca.actor_id = a.id AND a.name LIKE '%" + actorName + "%'",
                (result, rowNum) -> new Actors(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getString("nationality")));

        if (actors.size() > 0) {
            return actors.get(0);
        }
        return null;
    }

}
