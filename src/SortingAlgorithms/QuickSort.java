package SortingAlgorithms;

public class QuickSort {   //Sorotwanie z pivotem

    public static void sort(int[]arrayToSort) {
        int n = arrayToSort.length;
        quicksort(arrayToSort, 0, n-1);
    }
    public static void quicksort(int[]array, int left, int right) {
        if (left >= right){  //sprawdzanie czy jest wiecej niz jedna liczba
            return;
        }
        ///////////////////////////ustawianie wskaźników
        int pivotValue = array[right];
        int border = left - 1;   //granica po ktorej sortujemy
        int i = left;            //iteracja po liczbach
        ///////////////////////////


        while (i < right){                //jak doszlismy do konca lanucha to wychodzimy z petli...
            if (array[i] < pivotValue){   //sprawdzanie wartości (czy liczba po lewej stronie granicy jest mniejsza od pivota)
                border++;                 //jak jest mniejsza to przesywamy granice o jeden w prawo
                if(border != i){          //zamieniamy liczbe spod "i" z liczba po lewej stronie od granicy
                    SortUtils.swap(array, border, i);
                }
            }
            i++;
        }
        border++;   //...i przesuwamy granice w prawo
        if (border != right){  //zamieniamy miejscami pivota z liczba po lewej stronie od granicy
            SortUtils.swap(array, border, right);
        }
        quicksort(array, left, border-1);  //sprawdzamy lewa strone rekurencyjnie
        quicksort(array, border+1, right);  //sprawdzamy prawa strone rekurencyjnie
    }

}

