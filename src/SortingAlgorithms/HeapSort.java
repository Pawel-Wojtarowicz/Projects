package SortingAlgorithms;

public class HeapSort {  //sortowanie przez kopcowanie

    public static void sort(int[]arrayToSort) {
        int n = arrayToSort.length;

        for (int i = n/2 - 1; i>=0; i--){      //tworzenie kopca i szukanie ostatniego rodzica
            HeapSort.validateMaxHeap(arrayToSort, n, i);    //sprawdzanie czy jest 'maxheap'
        }
        for (int i = n - 1; i>0; i--){          //iterowanie od konca do poczatku
            SortUtils.swap(arrayToSort, 0, i);  //zamiana ostatniego elementu kopca z pierwszysm rodzicem (czyli najwieksza wartosc wedruje na sam koniec)
            n--;                                //zmniejszanie kopca poprzez odcięcię ostatniego dziecka z najwiekszą wartością
            HeapSort.validateMaxHeap(arrayToSort, n, 0); //walidacja kopca zmniejszonego o 1
        }
    }
    private static void validateMaxHeap(int[] array, int heapSize, int parentIndex){

        ///////ustawianie wskaźników
        int maxIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;
        ////////////////////////////

        if(leftChild < heapSize && array[leftChild] > array[maxIndex]){  //sprawdzanie po wartosci
            maxIndex = leftChild;
        }
        if(rightChild < heapSize && array[rightChild] > array[maxIndex]){ //sprawdzanie po wartosci
            maxIndex = rightChild;
        }
        if(maxIndex != parentIndex){                       //jeżeli rodzic został zamieniony z dzieckiem to:
            SortUtils.swap(array, maxIndex, parentIndex);  //zamieniamy miejscami parentIndex z maxIndex (od tej pory oryginalny rodzic jest na mijescu dziecka ktore było większe)
            validateMaxHeap(array, heapSize, maxIndex);    //i sprawdzamy rekurencyjnie czy struktura drzewa jest zachowana. (czy rodzic ma większą wartość niz jego dzieci)
        }
    }
}

