package br.faculdade.projeto2.util;

import br.faculdade.projeto2.model.BinarySearchTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataGenerator {

    private static final Random RANDOM = new Random();

    private DataGenerator() {
    }

    public static int[] generateUniqueRandomArray(int size, int boundMultiplier) {
        Set<Integer> values = new HashSet<>();

        int bound = Math.max(size * boundMultiplier, size + 1);

        while (values.size() < size) {
            values.add(RANDOM.nextInt(bound));
        }

        int[] array = new int[size];
        int index = 0;

        for (Integer value : values) {
            array[index++] = value;
        }

        return array;
    }

    public static int[] sortedCopy(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    public static int[] shuffledCopy(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        for (int i = copy.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }

        return copy;
    }

    public static BinarySearchTree buildRandomizedTree(int[] values) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] shuffled = shuffledCopy(values);

        for (int value : shuffled) {
            tree.insert(value);
        }

        return tree;
    }

    public static int[] generateQuerySet(int[] existingValues, int totalQueries) {
        int[] queries = new int[totalQueries];
        int half = totalQueries / 2;

        for (int i = 0; i < half; i++) {
            queries[i] = existingValues[RANDOM.nextInt(existingValues.length)];
        }

        int maxValue = Arrays.stream(existingValues).max().orElse(0);
        for (int i = half; i < totalQueries; i++) {
            queries[i] = maxValue + 1 + RANDOM.nextInt(totalQueries * 10);
        }

        return shuffledCopy(queries);
    }
}
