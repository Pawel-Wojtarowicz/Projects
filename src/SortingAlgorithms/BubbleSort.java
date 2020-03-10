package SortingAlgorithms;

public class BubbleSort {  //sortowanie babelkowe. Największa liczba ustawiana jest na samym koncu

    public static void sort(int[]arrayToSort) {
        int n = arrayToSort.length;
        int it = 0;  // licznik konca tablicy (w petli for nie bedzie już porownywal ostatnich znaków)
        boolean swapped = true;
        while (it < n - 1 && swapped) {
            swapped = false;
            for (int j = 0; j < n - 1 - it; j++) {  //iterujemy po ciagu liczb z pominięciem "it"
                if (arrayToSort[j] > arrayToSort[j + 1]) {  //porównujemy dwie liczby
                    SortUtils.swap(arrayToSort, j, j + 1);  //jak liczba po lewej stronie jest większa to zamieniamy ją miejscami z liczba po prawej stronie
                    swapped = true;  //warunek ktory sprawdza czy byla jakas zamiana.
                }
            }
            it++; //zmniejszamy tablice
        }
    }
}

