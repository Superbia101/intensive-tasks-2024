package com.walking.intensive.chapter5.task19;

/**
 * Создайте классы фигур: класс сфера и параллелепипед.
 * Объект «Сфера» должен задаваться по координате точки центра
 * (x;y;z), где каждая координата задается полем класса,
 * а так же радиусом R.
 *
 * <p>Объект «Параллелепипед» должен задаваться по координате точек
 * A (x1;y1;z1) и B (x2;y2;z2), где каждая координата задается полем класса.
 * AB - главная диагональ прямоугольного параллелепипеда, а ребра параллельны базису.
 *
 * <p>Создайте в main() несколько объектов сфер и параллелепипедов и напишите метод,
 * который отвечает на вопрос: пересекается (или касается) ли объект сфера с объектом параллелепипед?
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task19 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        Sphere sphereNum1 = new Sphere(0, 0.5, 0, 8);
        Sphere sphereNum2 = new Sphere(10, 2, 0, 3);
        System.out.println(sphereNum2.getX());
        System.out.println(Sphere.isIntersectSphere(sphereNum1, sphereNum2));
        Parallelepiped objectNum1 = new Parallelepiped(0, 0, 0, 1, 1, 1);
//        Parallelepiped objectNum2 = new Parallelepiped(0.5, 0.5, 0.5, -3, -3, -3);
        Parallelepiped objectNum2 = new Parallelepiped(-1, -1, -1, -3, -3, -3);
        System.out.println(Parallelepiped.isIntersectParallelepiped(objectNum1, objectNum2));
    }

    static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {
        // Ваш код
        return false;
    }
}
