package org.alexoff.utils;

import org.alexoff.models.Author;
import org.alexoff.models.Film;
import org.alexoff.models.Genre;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;

public class CsvParser {
    public static void ParseFilmsCsv(String filePath) throws IOException {
        //Загружаем строки из файла
        List<Film> films = new ArrayList<Film>();
        List<Genre> genres = new ArrayList<Genre>();
        List<Author> authors = new ArrayList<Author>();

        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(";");
            ArrayList<String> columnList = new ArrayList<String>();
            for (int i = 0; i < splitedText.length; i++) {
                //Если колонка начинается на кавычки или заканчиваеться на кавычки
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + "," + splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }


            try (Session session = HibernateUtil.getSession()) {
                session.beginTransaction();

                Query query = session.createQuery("from Film where name='" + columnList.get(0) + "'");
                List<Genre> filmNames = query.list();
                if (filmNames.size() == 0) {
                    Film film = new Film();
                    film.setName(columnList.get(0));
                    film.setYear(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + columnList.get(3)));
                    try {
                        film.setDuration(Integer.valueOf(columnList.get(4)));
                    } catch (NumberFormatException e) {
                        film.setDuration(0);
                        System.out.println("Фильму " + columnList.get(0) + " поставлена нулевая длительность, так как поле не заполнено ");
                    }
                    try {
                        film.setRating(Integer.valueOf(columnList.get(5)));
                    } catch (NumberFormatException e) {
                        film.setRating(0);
                        System.out.println("Фильму " + columnList.get(0) + " поставлен рейтинг -1, так как поле не заполнено ");
                    }
                    session.save(film);

                    query = session.createQuery("from Genre where name='" + columnList.get(1) + "'");
                    List<Genre> genreNames = query.list();
                    if (genreNames.size() > 0) {
                        genreNames.get(0).addFilm(film);
                        session.saveOrUpdate(genreNames.get(0));
                    } else {
                        Genre genre = new Genre();
                        genre.setName(columnList.get(1));
                        genre.addFilm(film);
                        session.save(genre);
                    }
                    query = session.createQuery("from Author where name='" + columnList.get(2) + "'");
                    List<Author> authorNames = query.list();
                    if (authorNames.size() > 0) {
                        authorNames.get(0).addFilm(film);
                        session.saveOrUpdate(authorNames.get(0));
                    } else {
                        Author author = new Author();
                        author.setName(columnList.get(2));
                        author.addFilm(film);
                        session.save(author);
                    }
                }
                session.getTransaction().commit();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    //Проверка является ли колонка частью предыдущей колонки
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}
