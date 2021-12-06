package searchbar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import searchbar.entity.Content;

import java.util.List;

@Repository
public class ContentRepository {

    @Autowired
    private JdbcTemplate template;


    public Content finContent(@Param("value") String content) {
        List<Content> contentList = template.query("SELECT id, title, duration, description, type, date, directorId " +
                        "FROM content WHERE title LIKE '%" + content + "%'",
                (result, rowNum) -> new Content((result.getInt("id")),
                        result.getString("title"),
                        result.getString("duration"),
                        result.getString("description"),
                        result.getString("type"),
                        result.getString("date"),
                        result.getInt("directorId")));

        if (contentList.size() > 0) {
            return contentList.get(0);
        }
        return null;
    }

}
