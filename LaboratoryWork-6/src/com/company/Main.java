package com.company;

/**
 * Разработать приложение, моделирующее один из вариантов классической задачи об обедающих философах. Смоделировать
 * следующий сценарий:
 * - Несколько философов сидят вокруг стола, посреди которого стоит тарелка с рисом.
 * - Каждый философ либо размышляет (спит), либо ест.
 * - Брать рис из тарелки в один момент времени может только один философ (то есть тарелка - общий ресурс, с
 *   синхронизированным доступом к нему).
 * - Философы размышляют в течение случайного времени, потом едят рис из тарелки в течение фиксированного времени. На
 *   это время доступ к тарелке других философов блокируется.
 * - Программа должна выдавать (например, на консоль) информацию о том, что делает каждый философ и сколько риса он
 *   съел. Считать, что в тарелке бесконечный запас риса.
 */

public class Main {

    public static void main(String[] args) {
        new Thread(new Eater(), "А").start();
        new Thread(new Eater(), "Б").start();
        new Thread(new Eater(), "В").start();
        new Thread(new Eater(), "Г").start();
        new Thread(new Eater(), "Д").start();
    }
}
