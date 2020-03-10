package SortingAlgorithms;

public class MergeSort {   //sortowanie przez scalanie

    private static int[]extraArray;

    public static void sort(int[]arrayToSort) {
        extraArray = new int[arrayToSort.length];
        mergeSort(arrayToSort, 0 , arrayToSort.length -1); //lewa granica i prawa granica tablicy
    }
    private static void mergeSort (int[]array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {  //dzielenie tablicy do jednego elementu
            int middle = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middle);  //dzielenie lewej czesci do 2 elementów rekurencyjnie
            mergeSort(array, middle + 1, rightIndex);  //dzielenie prawej czesci do 2 elementów rekurencyjnie
            merge(array, leftIndex, middle, rightIndex); //łaczenie czesci lewej i prawej (wykona sie dopiero wtedy gdy wywołania rekurencyjne beda skonczone)
        }
    }
    private static void merge(int[]array, int leftIndex, int middleIndex, int rightIndex) {  //wypisywanie 0ego i 1ego elementu tablicy do posortowania (plus zwiekszenie licznika "i")
        for (int i = leftIndex; i <= rightIndex; i++) {
            extraArray[i] = array[i];   //do tablicy pomocniczej wpisujemy dwie kolejne liczby (z tablicy do posortowania)
        }

        //ustawianie wskaźników
        int finger1 = leftIndex;   //pierwsza liczba z lewej strony o indeksie 0   --lewa
        int finger2 = middleIndex + 1; //pierwsza liczba z prawej strony           --prawa
        int current = leftIndex;
        ///////////////////////

        while(finger1 <= middleIndex && finger2 <= rightIndex) {  //?????
            //porownywanie elementów
            if(extraArray[finger1] <= extraArray[finger2]) {  //porownywanie wartosci liczb po indeksie (czy wartosc finger 1 jest mniejsza o wartosci finger2)
                array[current] = extraArray[finger1];
                finger1++;
            }
            else {
                array[current] = extraArray[finger2];
                finger2++;
            }
            ////////////////////////////
            current++;  //zwiekszam indeks o jeden i wpisuje/porównuje kolejną liczbę
        }
        while(finger1 <= middleIndex) {   //jezeli prawa strona sie skonczyla i jest posortowana to tutaj zostaje dopisana liczba z lewej storny lub jak
            //z lewej strony sie skonczy liczba to to sie nie wykona bo prawa strona bewdzie juz na swoim miejscu.
            array[current] = extraArray[finger1];
            finger1++;
            current++;
        }
    }
}

