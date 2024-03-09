package oppgave_4;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrSize = 1000000;

        HashSet<Integer> hasjListe = new HashSet<>();
        int[] tabell = new int[arrSize];
        int tall = 376;
        for (int i = 0; i < arrSize; i++) {
            tall = (tall + 45713) % 1000000;
            tabell[i] = tall;
            hasjListe.add(tall);
        }
        Arrays.sort(tabell);
        Random random = new Random();

        Instant start = Instant.now();
        int antallFunnetSet = 0;
        for (int i = 0; i < 10000; i++) {
            int number = random.nextInt(1000000);
            if (hasjListe.contains(number)) {
                antallFunnetSet++;
            }
        }
        System.out.println("Set funnet: " + antallFunnetSet);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Set tid: " + timeElapsed.toMillis() + "ms");

        start = Instant.now();
        int antallFunnetTab = 0;
        for (int i = 0; i < 10000; i++) {
            int number = random.nextInt(1000000);
            if (binarySearch(tabell, number) != -1) {
                antallFunnetTab++;
            }
        }
        System.out.println("Tab funnet: " + antallFunnetTab);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Tab tid: " + timeElapsed.toMillis() + "ms");
    }

    public static int binarySearch(int[] numbers, int numberToFind, int low, int high) {
        int startIndex = low, endIndex = high;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int midValue = numbers[midIndex];
            if (numberToFind == midValue) {
                return midIndex;
            }
            // høyre side
            if (numberToFind < midValue) {
                endIndex = midIndex - 1;
            } else {
            // venstre side
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] numbers, int numberToFind) {
        return binarySearch(numbers, numberToFind, 0, numbers.length - 1);
    }
}
