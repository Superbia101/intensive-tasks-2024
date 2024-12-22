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
        Sphere sphereNum1 = new Sphere(new double[]{0, 0, 0}, 3);
//        Sphere sphereNum2 = new Sphere(new double[]{10, 2, 0}, 3);
//        System.out.println(sphereNum1.isIntersectSphere(sphereNum2));
//        Parallelepiped objectNum1 = new Parallelepiped(new double[]{0, 0, 0}, new double[]{1, 1, 1});
//        Parallelepiped objectNum2 = new Parallelepiped(new double[]{0.5, 0.5, 0.5}, new double[]{-3, -3, -3});
        Parallelepiped objectNum3 = new Parallelepiped(new double[]{3, 0, 0}, new double[]{4, 4, 4});
//        System.out.println(objectNum1.isIntersectParallelepiped(objectNum2));
        System.out.println(isIntersected(sphereNum1, objectNum3));
    }

    static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {
        double[] minCoordinateP = new double[3];
        double[] lengthWidthHeight = new double[3];
        double[] shift = new double[]{sphere.getCentre()[0], sphere.getCentre()[1], sphere.getCentre()[2]};

        for (int i = 0; i < 3; i++) {
            minCoordinateP[i] = Math.min(parallelepiped.getPointNumberOne()[i], parallelepiped.getPointNumberTwo()[i]);
            lengthWidthHeight[i] = Math.abs(parallelepiped.getPointNumberOne()[i] - parallelepiped.getPointNumberTwo()[i]);
        }

        for (int i = 0; i < 3; i++) {
            if (shift[i] < minCoordinateP[i]) {
                shift[i] = minCoordinateP[i];
            }
            if (shift[i] > (minCoordinateP[i] + lengthWidthHeight[i])) {
                shift[i] = (minCoordinateP[i] + lengthWidthHeight[i]);
            }
        }

        Sphere sphereTest = new Sphere(shift, sphere.getR());

        return Sphere.isIncludedCoordinate(sphereTest, sphere.getCentre());
    }
}
