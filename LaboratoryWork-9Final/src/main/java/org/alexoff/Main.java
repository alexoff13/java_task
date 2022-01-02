package org.alexoff;

import org.alexoff.utils.CsvParser;
import org.alexoff.utils.HibernateUtil;
import org.alexoff.utils.ParsedFilms;
import org.hibernate.Session;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO: 02.01.2022 добавить проверку данных при записи, если уже существуют в бд не записывать
        // TODO: 02.01.2022 расширить количество столбцов можно взять за основу https://raw.githubusercontent.com/miptgirl/kinopoisk_data/master/kp_all_movies.csv
        // TODO: 02.01.2022 Как то придумать прописать связь потому что после того как мы заносим данные в паред филмс мы уже не храним связь фильма и жанра фильма и автора
//        CsvParser parser = new ();
        ParsedFilms films = CsvParser.ParseFilmsCsv("/Users/alexoff/git/univer/java_task/LaboratoryWork-9Final/src/main/resources/films.csv");
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
//            for films.getFilms();
            session.getTransaction().commit();
        }
    }
}
