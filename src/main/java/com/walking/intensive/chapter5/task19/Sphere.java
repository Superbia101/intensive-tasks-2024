package com.walking.intensive.chapter5.task19;

public class Sphere {
    private double x, y, z, R;

    Sphere(double x, double y, double z, double R) {
        setX(x);
        setY(y);
        setZ(z);
        setR(R);
    }

    static public boolean isIntersectSphere(Sphere object1, Sphere object2) {
        if (object1 == object2){
            System.out.println("Это тот же объект!");
            return true;
        }

        double centersDifferenceInSquareX = Math.pow(object2.x - object1.x, 2);
        double centersDifferenceInSquareY = Math.pow(object2.y - object1.y, 2);
        double centersDifferenceInSquareZ = Math.pow(object2.z - object1.z, 2);
        double lengthBetweenCenters = Math.sqrt(centersDifferenceInSquareX +
                centersDifferenceInSquareY + centersDifferenceInSquareZ);

        return lengthBetweenCenters <= object1.R + object2.R;
    }

    static public boolean isIncludedCoordinate(Sphere object, double x, double y, double z) {
        double centersDifferenceInSquareX = Math.pow(x - object.x, 2);
        double centersDifferenceInSquareY = Math.pow(y - object.y, 2);
        double centersDifferenceInSquareZ = Math.pow(z - object.z, 2);
        double lengthBetweenCoordinate = Math.sqrt(centersDifferenceInSquareX +
                centersDifferenceInSquareY + centersDifferenceInSquareZ);

        return lengthBetweenCoordinate <= object.R;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getR() {
        return R;
    }

    public void setR(double R) {
        try {
            if (R <= 0) {
                throw new Exception("Неверное значение радиуса! Такой шар существовать не может.");
            }
            this.R = R;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
