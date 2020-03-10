package SortingAlgorithms;

public class SelectSort {   //sortowanie przez wybieranie najmniejszego indeksu

    public static void sort(int[]arrayToSort) {
        int n = arrayToSort.length;
        int minIndex;
        for(int i = 0; i < n - 1; i++) {
            minIndex = i;   //ustawianie wartosci indeksu "i" ktorego bedziemy porównywać z reszta liczb
            for(int j = i + 1; j < n; j++) {
                if(arrayToSort[j] < arrayToSort[minIndex]) {  //jeżeli następna liczba jest mniejsza niz wartosc indeksu to ustawiamy nowy indeks
                    minIndex = j;  //ustawiamy nowe indeks
                }
            }
            if(minIndex != i){                    //sprawdzanie czy zmieniliśmy wartość pierwotnego indeksu.
                SortUtils.swap(arrayToSort, minIndex, i); //zamiana miejscami mniejszej liczby spod "i" z minIndeks
            }
        }
    }
}

