package oppgave_4;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrSize = 1000000;
        int antallTall = 10000;

        HashSet<Integer> hasjSet = new HashSet<>();
        int[] tabell = new int[arrSize];
        int tall = 376;
        for (int i = 0; i < arrSize; i++) {
            tall = (tall + 45713) % 1000000;
            tabell[i] = tall;
            hasjSet.add(tall);
        }
        Arrays.sort(tabell);
        Random random = new Random();

        int antallFunnetSet = 0;
        Instant start = Instant.now();
        for (int i = 0; i < antallTall; i++) {
            int number = random.nextInt(1000000);
            if (hasjSet.contains(number)) {
                antallFunnetSet++;
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Set funnet: " + antallFunnetSet + " / " + antallTall);
        System.out.println("Set tid: " + timeElapsed.toMillis() + "ms");

        int antallFunnetTab = 0;
        start = Instant.now();
        for (int i = 0; i < antallTall; i++) {
            int number = random.nextInt(1000000);
            if (binarySearch(tabell, number) != -1) {
                antallFunnetTab++;
            }
        }
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Tab funnet: " + antallFunnetTab + " / " + antallTall);
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
            // venstre side
            if (numberToFind < midValue) {
                endIndex = midIndex - 1;
            } else {
                // høyre side
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int numberToFind) {
        return binarySearch(numbers, numberToFind, 0, numbers.length - 1);
    }
}
