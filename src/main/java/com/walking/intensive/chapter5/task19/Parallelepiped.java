package com.walking.intensive.chapter5.task19;

public class Parallelepiped {
    private double x1, y1, z1, x2, y2, z2;

    Parallelepiped(double x1, double y1, double z1, double x2, double y2, double z2) {
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setZ1(z1);
        setZ2(z2);
    }

    static public boolean isIntersectParallelepiped(Parallelepiped objectA, Parallelepiped objectB) {
        if (objectA == objectB){
            System.out.println("Это тот же объект!");
            return true;
        }

        boolean intersectAxisX = isIntersectInAxis(objectA, objectB, "x");
        boolean intersectAxisY = isIntersectInAxis(objectA, objectB, "y");
        boolean intersectAxisZ = isIntersectInAxis(objectA, objectB, "z");

        return intersectAxisX && intersectAxisY && intersectAxisZ;
    }

    private static boolean isIntersectInAxis(Parallelepiped object1, Parallelepiped object2, String coordinate) {
        double min1, min2, max1, max2;

        switch (coordinate) {
            case "x":
                min1 = Math.min(object1.x1, object1.x2);
                max1 = Math.max(object1.x1, object1.x2);
                min2 = Math.min(object2.x1, object2.x2);
                max2 = Math.max(object2.x1, object2.x2);
                break;

            case "y":
                min1 = Math.min(object1.y1, object1.y2);
                max1 = Math.max(object1.y1, object1.y2);
                min2 = Math.min(object2.y1, object2.y2);
                max2 = Math.max(object2.y1, object2.y2);
                break;

            case "z":
                min1 = Math.min(object1.z1, object1.z2);
                max1 = Math.max(object1.z1, object1.z2);
                min2 = Math.min(object2.z1, object2.z2);
                max2 = Math.max(object2.z1, object2.z2);
                break;

            default:
                System.out.println("Такой координаты нет!");
                return false;
        }

        return min2 <= min1 && min1 <= max2 || min1 <= min2 && min2 <= max1;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x) {
        try {
            if (x == getX2()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.x1 = x;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y) {
        try {
            if (y == getY2()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.y1 = y;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getZ1() {
        return z1;
    }

    public void setZ1(double z) {
        try {
            if (z == getZ2()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.z1 = z;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x) {
        try {
            if (x == getX1()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.x2 = x;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y) {
        try {
            if (y == getY1()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.y2 = y;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getZ2() {
        return z2;
    }

    public void setZ2(double z) {
        try {
            if (z == getZ1()) {
                throw new Exception("Главная диагональ должна находиться в объёме(3-х плоскостях). " +
                        "Такой параллелограмм не может существовать!");
            }
            this.z2 = z;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
