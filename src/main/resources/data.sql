INSERT INTO country (name) VALUES ('India');
INSERT INTO country (name) VALUES ('Brazil');
INSERT INTO country (name) VALUES ('USA');
INSERT INTO country (name) VALUES ('Italy');

INSERT INTO searchbar_db.actors (name, age, nationality) VALUES ('Brad', 50, 'USA');
INSERT INTO searchbar_db.actors (name, age, nationality) VALUES ('Juan', 20, 'MX');
INSERT INTO searchbar_db.actors (name, age, nationality) VALUES ('Hugo', 32, 'CO');
INSERT INTO searchbar_db.actors (name, age, nationality) VALUES ('Paco', 34, 'IT');
INSERT INTO searchbar_db.actors (name, age, nationality) VALUES ('Luis', 36, 'ES');

INSERT INTO searchbar.content_has_actors (content_id, actor_id) VALUES (1, 1);

INSERT INTO searchbar.content (id, title, duration, type, date, director_id, description)
VALUES ('1', 'Lo que el viento se llevaria', '00:00:23', 'pssss', '2021-01-01', '1', 'Good');

INSERT INTO searchbar.directors (id, name, age, nationality) VALUES ('1', 'Juan', '33', 'COL');
