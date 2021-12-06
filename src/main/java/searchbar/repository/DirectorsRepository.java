package searchbar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import searchbar.entity.Directors;

import java.util.List;

@Repository
public class DirectorsRepository {

    @Autowired
    private JdbcTemplate template;

    public Directors findDirector(@Param("value") String directorName) {
        List<Directors> directors = template.query("SELECT d.id, name, age, nationality FROM content c, directors d " +
                        "WHERE c.director_id = d.id AND d.name LIKE '%" + directorName + "%'",
                (result, rowNum) -> new Directors(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getString("nationality")));

        if (directors.size() > 0) {
            return directors.get(0);
        }
        return null;
    }

}