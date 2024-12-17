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
        Sphere sphereNum1 = new Sphere(10, 0, 0, 3);
//        Sphere sphereNum2 = new Sphere(10, 2, 0, 3);
//        System.out.println(Sphere.isIntersectSphere(sphereNum1, sphereNum2));
//        Parallelepiped objectNum1 = new Parallelepiped(0, 0, 0, 1, 1, 1);
//        Parallelepiped objectNum2 = new Parallelepiped(0.5, 0.5, 0.5, -3, -3, -3);
        Parallelepiped objectNum3 = new Parallelepiped(3, 3, 3, -4, -4, -4);
//        System.out.println(Parallelepiped.isIntersectParallelepiped(objectNum1, objectNum2));
        System.out.println(isIntersected(sphereNum1, objectNum3));
    }

    static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {
        double minCoordinateX = Math.min(parallelepiped.getX1(), parallelepiped.getX2());
        double minCoordinateY = Math.min(parallelepiped.getY1(), parallelepiped.getY2());
        double minCoordinateZ = Math.min(parallelepiped.getZ1(), parallelepiped.getZ2());
        double lengthParallelepiped = Math.abs(parallelepiped.getX1() - parallelepiped.getX2());
        double widthParallelepiped = Math.abs(parallelepiped.getY1() - parallelepiped.getY2());
        double heightParallelepiped = Math.abs(parallelepiped.getZ1() - parallelepiped.getZ2());
        double testX = sphere.getX();
        double testY = sphere.getY();
        double testZ = sphere.getZ();

        if (testX < minCoordinateX)
            testX = minCoordinateX;
        if (testX > (minCoordinateX + lengthParallelepiped))
            testX = (minCoordinateX + lengthParallelepiped);
        if (testY < minCoordinateY)
            testY = minCoordinateY;
        if (testY > (minCoordinateY + widthParallelepiped))
            testY = (minCoordinateY + widthParallelepiped);
        if (testZ < minCoordinateZ)
            testZ = minCoordinateZ;
        if (testZ > (minCoordinateZ + heightParallelepiped))
            testZ = (minCoordinateZ + heightParallelepiped);

        Sphere sphereTest = new Sphere(testX, testY, testZ, sphere.getR());

        return Sphere.isIncludedCoordinate(sphereTest, sphere.getX(), sphere.getY(), sphere.getZ());
    }
}
