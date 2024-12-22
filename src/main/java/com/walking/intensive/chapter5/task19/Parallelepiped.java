package com.walking.intensive.chapter5.task19;

public class Parallelepiped {
    private double[] pointNumberOne = new double[3];
    private double[] pointNumberTwo = new double[3];

    Parallelepiped(double[] coordinates1, double[] coordinates2) {
        if (coordinates1.length == 3 || coordinates2.length == 3) {

            if (coordinates1[0] != coordinates2[0] || coordinates1[1] != coordinates2[1] || coordinates1[2] != coordinates2[2]) {
                this.pointNumberOne = coordinates1;
                this.pointNumberTwo = coordinates2;
            } else {
                System.out.println("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }

        } else {
            System.out.println("Координаты должны содержать 3 оси: x, y, z!");
        }
    }

    public boolean isIntersectParallelepiped(Parallelepiped object) {
        if (this == object) {
            System.out.println("Это тот же объект!");
            return true;
        }

        int intersect = 0;

        for (int i = 0; i < 3; i++) {
            if (isIntersectInAxis(this.pointNumberOne[i], this.pointNumberTwo[i],
                    object.pointNumberOne[i], object.pointNumberTwo[i])) {
                intersect++;
            }
        }

        return intersect == 3;
    }

    private static boolean isIntersectInAxis(double start1, double end1, double start2, double end2) {
        double min1 = Math.min(start1, end1);
        double min2 = Math.min(start2, end2);
        double max1 = Math.max(start1, end1);
        double max2 = Math.max(start2, end2);

        return min2 <= min1 && min1 <= max2 || min1 <= min2 && min2 <= max1;
    }

    public double[] getPointNumberOne() {
        return pointNumberOne;
    }

    public double[] getPointNumberTwo() {
        return pointNumberTwo;
    }
}
