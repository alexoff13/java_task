package org.alexoff;

import org.alexoff.utils.CsvParser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь до файла с расширением <.csv> с фильмами в формате " +
                "Название;Жанр;Режиссер;Год;Продолжительность;Рейтинг ");
        Scanner reader = new Scanner(System.in);
        String path = reader.nextLine();
//        CsvParser.ParseFilmsCsv("/Users/alexoff/git/univer/java_task/LaboratoryWork-9Final/src/main/resources/film.csv");
        CsvParser.ParseFilmsCsv(path);
        System.out.println("Парсинг начался");
        System.out.println("Фильмы успешно добавлены");


    }
}
