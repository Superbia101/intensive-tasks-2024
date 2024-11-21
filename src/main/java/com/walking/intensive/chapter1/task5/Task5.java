package com.walking.intensive.chapter1.task5;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе

    }

    /* Не знаю можно ли так, но вот:
     * Моя функция определения градации(большая, средняя, меньшая) сторон.  */
    static double[] getGradeSide(double a, double b, double c) {
        double maxSide = Math.max(Math.max(a, b), c);
        double minSide = Math.min(Math.min(a, b), c);
        double meanSide = a + b + c - maxSide - minSide;

        return new double[]{maxSide, meanSide, minSide};
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return -1;
        }

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);

        return new double[]{2 * area / num[0], 2 * area / num[1], 2 * area / num[2]};
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return new double[0];
        }

        return new double[]{0.5 * Math.sqrt(2 * num[1] + 2 * num[2] - num[0]), 0.5 * Math.sqrt(2 * num[0] + 2 * num[2] - num[1]),
                0.5 * Math.sqrt(2 * num[0] + 2 * num[1] - num[2])};
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return new double[0];
        }

        double perimeter = a + b + c;

        return new double[]{Math.sqrt(num[1] * num[2] * perimeter * (num[1] + num[2] - num[0])) / (num[1] + num[2]),
                Math.sqrt(num[0] * num[2] * perimeter * (num[0] + num[2] - num[1])) / (num[0] + num[2]),
                Math.sqrt(num[1] * num[0] * perimeter * (num[1] + num[0] - num[2])) / (num[1] + num[0])};
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return new double[0];
        }

        return new double[]{Math.acos((num[1] * num[1] + num[0] * num[0] - num[2] * num[2]) / (2 * num[1] * num[0])) * 180 / Math.PI,
                Math.acos((num[0] * num[0] + num[2] * num[2] - num[1] * num[1]) / (2 * num[0] * num[2])) * 180 / Math.PI,
                Math.acos((num[1] * num[1] + num[2] * num[2] - num[0] * num[0]) / (2 * num[1] * num[2])) * 180 / Math.PI,};
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return -1;
        }

        return 2 * getAreaByHeron(a, b, c) / (a + b + c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return -1;
        }

        return a * b * c / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {

        double[] num = getGradeSide(a, b, c);

        if (num[0] >= num[1] + num[2]) {
            return -1;
        }

        return 0.5 * a * b * Math.sqrt(1 - Math.pow((a * a + b * b - c * c) / (2 * a * b), 2));
    }
}
