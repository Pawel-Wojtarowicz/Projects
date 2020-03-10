package SortingAlgorithms;

public class InsertionSort {  //sortowanie przez wstawianie

    public static void sort(int[]arrayToSort) {
        int n = arrayToSort.length;
        int current;
        int otherIndex;
        for(int i = 1; i < n; i++) {   //zaczynamy od drugiego elementu
            current = arrayToSort[i];  //zapamietujemy 2gi element tablicy
            otherIndex = i;            //j.w
            while(otherIndex > 0 && current < arrayToSort[otherIndex - 1]) {  //sprawdzamy czy obecny element jest mniejeszy od poprzedniego
                arrayToSort[otherIndex] = arrayToSort[otherIndex - 1];  //podmieniamy pomocniczą zmienną, liczbą 1sza (teraz na pozycji 0 i 1 jest ta sama liczba, większa)
                otherIndex--;  //zmniejszamy indeks na poprzedni (przesuwamy sie po tablicy do tyłu) i porównujemy wartosci liczb ponownie.
            }
            arrayToSort[otherIndex] = current;  //ustawiamy naszą zapamiętaną liczbę na odpowiedniej pozycji w tablicy do posortowania (pozycja ta będzie wiadoma dzięki petli "while")
        }
    }
}

