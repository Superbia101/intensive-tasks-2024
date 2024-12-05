package com.walking.intensive.chapter3.task15;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания может быть строго положительной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
//        System.out.println(getMaxFloors(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

    static int getMaxFloors(int[][] city) {
        if (!isValidation(city)) {
            return -1;
        }

        int lengthCity = city.length;
        int maxFloors = 0;
        int[] arrayMaximumsLines = new int[lengthCity];
        int[] arrayMaximumsColumns = new int[lengthCity];

        for (int i = 0; i < lengthCity; i++) {
            int maximumInLine = 0;
            int maximumInColumn = 0;
            for (int j = 0; j < lengthCity; j++) {
                maximumInLine = Math.max(maximumInLine, city[i][j]);
                maximumInColumn = Math.max(maximumInColumn, city[j][i]);
            }
            arrayMaximumsLines[i] = maximumInLine;
            arrayMaximumsColumns[i] = maximumInColumn;
        }

        for (int i = 0; i < lengthCity; i++) {
            for (int j = 0; j < lengthCity; j++) {
                if (city[i][j] < arrayMaximumsLines[i] && city[i][j] < arrayMaximumsColumns[j]) {
                    maxFloors += Math.min(arrayMaximumsLines[i], arrayMaximumsColumns[j]) - city[i][j];
                }
            }
        }

        return maxFloors;
    }

    static boolean isValidation(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        int lenCity = city.length;

        for (int i = 0; i < lenCity - 1; i++) {
            if (city[i].length != lenCity) {
                return false;
            }

            for (int j = 0; j < lenCity; j++) {
                if (city[i][j] < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
