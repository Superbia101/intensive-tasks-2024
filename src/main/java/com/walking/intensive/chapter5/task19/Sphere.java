package com.walking.intensive.chapter5.task19;

import java.util.Arrays;

public class Sphere {
    private double[] centre = new double[3];
    private double R;

    Sphere(double[] coordinateCenter, double R) {
        if (R > 0 && coordinateCenter.length == 3) {
            this.centre = coordinateCenter;
            this.R = R;
        } else {
            System.out.println("Неверное значение радиуса или координат. Радиус должен быть больше нуля, " +
                    "координат центра должно быть три: x, y, z! Иной шар существовать не может.");
        }
    }

    public boolean isIntersectSphere(Sphere object) {
        if (this == object) {
            System.out.println("Это тот же объект!");
            return true;
        }

        double lengthBetweenCenters = 0;

        for (int i = 0; i < 3; i++) {
            lengthBetweenCenters += Math.pow(object.centre[i] - this.centre[i], 2);
        }

        return Math.sqrt(lengthBetweenCenters) <= this.R + object.R;
    }

    static public boolean isIncludedCoordinate(Sphere object, double[] coordinate) {
        if (coordinate.length != 3) {
            System.out.println("Неверное значение координат - их должно быть три: x, y, z!");
            return false;
        }

        double lengthBetweenCoordinate = 0;

        for (int i = 0; i < 3; i++) {
            lengthBetweenCoordinate += Math.pow(coordinate[i] - object.centre[i], 2);
        }

        return Math.sqrt(lengthBetweenCoordinate) <= object.R;
    }

    public double getR() {
        return R;
    }

    public double[] getCentre() {
        return centre;
    }
}
