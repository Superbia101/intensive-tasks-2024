package com.walking.intensive.chapter4.task17;

//import java.util.Arrays;

import java.util.Random;

/**
 * Смауг, живущий в пещере с золотом, был заперт внутри горы.
 * Чтобы занять свое время, он развлекал себя следующей игрой.
 * Он складывал произвольное количество одинаковых монеток по мешочкам,
 * расставлял их в ряд произвольным образом и придумывал алгоритмы,
 * которыми он будет пользоваться для того, чтобы расставить мешочки в порядке возрастания ценности.
 * Времени было много и у него получилось придумать десятки алгоритмов
 * с целью выбрать лучший, который справится с сортировкой за минимальное количество действий.
 *
 * <p>Сортировка — алгоритм расположения элементов массива по неубыванию (возрастанию, если элементы не повторяются).
 *
 * <p>Создайте два метода сортировки: пузырьком и quicksort. Описание алгоритмов вы найдете ниже.
 *
 * <p>
 * При использовании встроенных методов сортировок, коллекций, Stream API и иного материала,
 * выходящего за рамки пройденного курса, задача не принимается к проверке.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task17 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
//        System.out.println(Arrays.toString(sortByBubble(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 10, 10})));
//        System.out.println(getBenchmarkOn1000());
//        System.out.println(getBenchmarkOn10000());
    }

    /**
     * Сортировка пузырьком:
     *
     * <ol>
     * <li> Метод заключается в попарном сравнении соседних элементов в массиве слева направо.
     *      Сначала сравнивается 0 и 1 индексы в массиве.
     *      Если значения элемента с 0-м индексом больше элемента с 1-м индексом -
     *      элементы меняются местами.
     * <li> Потом сравниваются 1 и 2 индексы, и так последовательно попарно сравниваются все элементы массива.
     *      При этом максимальный элемент массива окажется самым правым в массиве.
     * <li> Далее массивом будем считать неотсортированную часть массива,
     *      то есть без последнего самого правого элемента.
     * <li> Повторяем шаги 1 и 2 до полной сортировки массива.
     * </ol>
     */
    static int[] sortByBubble(int[] array) {
        if (array == null) {
            return new int[0];
        }

        int lengthArray = array.length;

        for (int i = 0; i < lengthArray; i++) {
            int numberComparisons = 0;
            for (int j = 1; j < lengthArray - i; j++) {
                if (array[j - 1] > array[j]) {
                    numberComparisons = 0;
                    swapElementArray(array, j, j - 1);
                }
                numberComparisons++;
            }
            if (numberComparisons == lengthArray - i) {
                break;
            }
        }

        return array;
    }

    /**
     * Быстрая сортировка, она же QuickSort:
     *
     * <p>Это рекурсивный метод, основанный на разделении 1 массива на 2 подмассива
     * по принципу поиска опорного элемента. Далее каждый из двух массивов снова
     * рекурсивно вызывает тот же метод сортировки.
     *
     * <p>Разбиение 1 массива на 2 подмассива происходит поиском «опорного элемента».
     *
     * <p>Опорный элемент делит массив таким образом, что элементы, меньшие опорного,
     * помещаются перед ним(левее), а большие или равные — после(правее).
     * При этом сам опорный элемент не обязан быть элементом массива.
     *
     * <p>Вопрос выбора лучшего опорного элемента пока остается открытым в математике.
     * Цель опорного элемента — попытаться разделить массив пополам,
     * тогда сортировка пройдет максимально быстро.
     * В задаче опорный элемент = (max + min) / 2
     * (считается каждый раз для каждого нового подмассива).
     * Где max и min — максимальный и минимальный элементы массива (подмассива).
     *
     * <ol>
     * <li> В одном цикле два итератора: i слева направо от left до right,
     *      j – справа налево от right до left, где left и right индексы,
     *      вставляемые в метод в качестве аргументов. Ищем значение опорного элемента.
     * <li> Пока i <= j: двигаем i, пока не встретим элемент, который >= опорного элемента.
     *      Двигаем j, пока не встретим элемент, который <= опорного элемента.
     *      Если i <= j, то делаем обмен элементов по этим индексам.
     *      Нужно добиться, чтобы каждый элемент слева от опорного элемента
     *      был <= опорного элемента, а каждый элемент справа от
     *      опорного элемента был >= опорного элемента.
     *      Таким способом мы найдем индекс опорного элемента в массиве или
     *      2 соседних индекса, если опорного элемента в массиве нет.
     * <li> Мы узнали индекс опорного элемента и добились того, что опорный элемент
     *      поделил массив на 2 массива. Осталось каждый подмассив поставить
     *      в качестве аргумента вызывая рекурсию.
     * <li> Выход из рекурсии: массив длины 2 – если нужно,
     *      меняем эти два элемента местами.
     *      Если длина входного массива меньше двух, выходим.
     * </ol>
     */
    static int[] sortByQuicksort(int[] array) {
        int lengthArray = array.length;

        switch (lengthArray) {
            case 0, 1:
                return array;
            case 2:
                if (array[0] > array[1]) {
                    swapElementArray(array, 0, 1);
                }
                return array;
        }

        quickSort(array, 0, lengthArray - 1);

        return array;
    }

    /**
     * Создайте массив случайных целых чисел из 1 000 элементов и сравните время,
     * которое потребуются для каждой из сортировок.
     * Ожидаемое возвращаемое значение - разница в выполнении сортировки в миллисекундах.
     *
     * <p>Для получения текущего UNIX-времени (в миллисекундах) можно использовать `System.currentTimeMillis()`.
     * Время выполнения - разность времени после работы алгоритма и времени до работы алгоритма
     */
    static long getBenchmarkOn1000() {
        int[] randomNums = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            randomNums[i] = random.nextInt(1000);
        }

//      Сортировка Пузырьком
        long timeStart1 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(sortByBubble(randomNums)));
        sortByBubble(randomNums);
        long timeFinish1 = System.currentTimeMillis();
//      Быстрая Сортировка
        long timeStart2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(sortByQuicksort(randomNums)));
        sortByQuicksort(randomNums);
        long timeFinish2 = System.currentTimeMillis();

        return (timeFinish1 - timeStart1) - (timeFinish2 - timeStart2);
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        int[] randomNums = new int[10000];
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            randomNums[i] = random.nextInt(10000);
        }

//      Сортировка Пузырьком
        long timeStart1 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(sortByBubble(randomNums)));
        sortByBubble(randomNums);
        long timeFinish1 = System.currentTimeMillis();
//      Быстрая Сортировка
        long timeStart2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(sortByQuicksort(randomNums)));
        sortByQuicksort(randomNums);
        long timeFinish2 = System.currentTimeMillis();

        return (timeFinish1 - timeStart1) - (timeFinish2 - timeStart2);
    }

    private static int getSupportElementArray(int[] array, int indexStart, int indexEnd) {
        int maxElementArray = array[indexStart];
        int minElementArray = array[indexStart];

        for (int i = indexStart; i < indexEnd; i++) {
            maxElementArray = Math.max(maxElementArray, array[i]);
            minElementArray = Math.min(minElementArray, array[i]);
        }

        return (maxElementArray + minElementArray) / 2;
    }

    private static void swapElementArray(int[] array, int indexNumArray1, int indexNumArray2) {
        int temporaryVariable = array[indexNumArray1];
        array[indexNumArray1] = array[indexNumArray2];
        array[indexNumArray2] = temporaryVariable;
    }

    private static void quickSort(int[] array, int indexStart, int indexEnd) {
        if (indexEnd - indexStart > 1) {
            int supportElementArray = getSupportElementArray(array, indexStart, indexEnd);
            int i = indexStart;
            int j = indexEnd;

            while (i <= j) {
                if (array[i] < supportElementArray) {
                    i++;
                } else {
                    if (array[j] <= supportElementArray) {
                        swapElementArray(array, i, j);
                        i++;
                    }
                    j--;
                }
            }

            quickSort(array, indexStart, i - 1);
            quickSort(array, i, indexEnd);
        }
    }
}
