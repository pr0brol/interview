DROP TABLE IF EXISTS durations CASCADE;
CREATE TABLE durations (
  id                      BIGSERIAL,
  duration                SMALLINT,
  PRIMARY KEY(id)
);

INSERT INTO durations
(duration) VALUES
  (60),
  (90),
  (120);

DROP TABLE IF EXISTS movies CASCADE;
CREATE TABLE movies (
  id                      BIGSERIAL,
  title                   VARCHAR(255),
  duration_id             BIGSERIAL,
  PRIMARY KEY(id),
  CONSTRAINT fk_dur_id FOREIGN KEY (duration_id) references durations (id)
);

INSERT INTO movies
(title, duration_id) VALUES
  ('Terminator', 1),
  ('Terminator_2', 2),
  ('Terminator_3', 2),
  ('Terminator_4', 1),
  ('Terminator_5', 3);

DROP TABLE IF EXISTS tickets CASCADE;
CREATE TABLE tickets (
  id                      BIGSERIAL,
  movie_id                BIGSERIAL,
  beginning               TIME,
  price                   NUMERIC(8, 2),
  PRIMARY KEY(id),
  CONSTRAINT fk_mov_id FOREIGN KEY (movie_id) references movies (id)
);

INSERT INTO tickets
(movie_id, beginning, price) VALUES
  (1, '15:00:00', 200.0),
  (1, '15:00:00', 200.0),
  (1, '15:00:00', 200.0),
  (2, '16:00:00', 150.0),
  (2, '16:00:00', 150.0),
  (3, '18:00:00', 170.0),
  (3, '18:00:00', 170.0),
  (3, '18:00:00', 170.0),
  (1, '15:00:00', 200.0),
  (2, '15:00:00', 150.0),
  (2, '15:00:00', 150.0),
  (1, '15:00:00', 200.0),
  (2, '16:00:00', 150.0),
  (2, '16:00:00', 150.0),
  (3, '17:00:00', 170.0),
  (3, '17:00:00', 170.0),
  (3, '18:00:00', 170.0),
  (1, '15:00:00', 200.0),
  (2, '16:00:00', 150.0),
  (2, '16:00:00', 150.0),
  (2, '16:00:00', 150.0),
  (4, '22:00:00', 100.0),
  (4, '22:00:00', 100.0),
  (4, '22:00:00', 100.0);

--Здесь не ругается на minute, но не работает
select m.title, t.beginning, d.duration from movies m
left join durations d on m.duration_id = d.id
left join tickets t on m.id = t.movie_id
group by m.title, t.beginning, d.duration
order by t.beginning
where (dateadd(minute, d.duration, t.beginning) >= lead(t.beginning));

--Вроде должно работать, но тоже ругается на minute
with film as (
select m.id, m.title, t.beginning, d.duration
from movies m
left join durations d on m.duration_id = d.id
left join tickets t on m.id = t.movie_id
)
select film1.title, film1.beginning, film1.duration
from film film1
where (dateadd(minute, film1.duration, film1.beginning) >= lead(film1.beginning));

--это дали, работает только при равенстве
with film as (
select m.id, m.title, t.beginning, d.duration
,(d.duration*'1 minute'::interval)+t.beginning endFilm
from movies m
left join durations d on m.duration_id = d.id
left join tickets t on m.id = t.movie_id
group by m.id, m.title, t.beginning, d.duration
)
select film1.title, film1.beginning, film1.duration
,film2.title, film2.beginning, film2.duration
from film film1
  join film film2 on film1.id<>film2.id
          and film2.beginning between film1.beginning and film1.endFilm;