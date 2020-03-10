package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class ShellSort {

    public static void sort(int[]arr, Function<Integer, Integer[]> distGenerator){  //interfejs java8 - poczytac
        int n = arr.length;
        int iter = 1;
        Integer[] distances = distGenerator.apply(n);
        int distance = distances[distances.length - iter];  //pobieranie dystansu od konca (od najwiekszego dystansu do najmniejszego)
        int current, otherIndex;  //zmienne dla porównywanych liczb
        while(distance >= 1){  //SPRAWDZIĆ
            for(int i = distance; i < n; i++){  //sortowanie przez wstawianie
                current = arr[i];  //wartosc "i"
                otherIndex = i;  //indeks "i"
                while(otherIndex >= distance && current < arr[otherIndex - distance]){ //porównujemy wartość pierwszej liczby zza połowy z wartością liczby minus dystans (czyli prawą liczbe z lewą ze swojej pary)
                    arr[otherIndex] = arr[otherIndex - distance];  //jeżeli liczba po prawej stronie jest mniejsza to nadpisujemy ją liczbą z lewej strony.
                    otherIndex -= distance;  //ustawiamy indeks na liczbie po lewej stronie zeby ją zmienić. (ustawiamy ja tak że odejmujemy wartosc dystnasu)
                }
                arr[otherIndex] = current;  //ustawiamy zamieniona liczbe w nowe miejsce (czyli zapamiętana z prawej strony (current) na lewą stronę. (czyli minus dystans).
            }
            distance = distances[distances.length - ++iter];  //zmniejszamy dystans przez pobranie z wygenerowanej wczesniej tablicy dystansów, kolejnego dystansu.
        }
    }

    public static Integer[] shellDistance(int numberOfElements){
        ArrayList<Integer> distances = new ArrayList<>();
        int iteration = 1;
        int generated;
        do{
            generated = numberOfElements / (int)Math.pow(2, iteration);
            distances.add(generated);
            iteration++;
        }while(generated > 0);
        Collections.reverse(distances);
        return distances.toArray(new Integer[distances.size()]);
    }

    // 4^k + 3*2^(k-1) + 1
    public static Integer[] sedgewickDistance(int numberOfElements){
        int generated = 0;
        ArrayList<Integer> distances = new ArrayList<>();
        int k = 0;
        while(generated < numberOfElements){
            if(distances.isEmpty()){
                distances.add(0);
                distances.add(1);
            } else{
                generated = (int) (Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
                if(generated < numberOfElements){
                    distances.add(generated);
                }
            }
            k++;
        }
        return distances.toArray(new Integer[distances.size()]);
    }

}

