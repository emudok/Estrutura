package br.faculdade.projeto2.util;

public class Statistics {

    private Statistics() {
    }

    public static double mean(long[] values) {
        double sum = 0.0;

        for (long value : values) {
            sum += value;
        }

        return sum / values.length;
    }

    public static double standardDeviation(long[] values) {
        double mean = mean(values);
        double sum = 0.0;

        for (long value : values) {
            double diff = value - mean;
            sum += diff * diff;
        }

        return Math.sqrt(sum / values.length);
    }
}
