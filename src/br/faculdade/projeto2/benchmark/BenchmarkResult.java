package br.faculdade.projeto2.benchmark;

public class BenchmarkResult {
    private final String algorithmName;
    private final int dataSize;
    private final double averageTimeNs;
    private final double standardDeviationNs;

    public BenchmarkResult(String algorithmName, int dataSize, double averageTimeNs, double standardDeviationNs) {
        this.algorithmName = algorithmName;
        this.dataSize = dataSize;
        this.averageTimeNs = averageTimeNs;
        this.standardDeviationNs = standardDeviationNs;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public int getDataSize() {
        return dataSize;
    }

    public double getAverageTimeNs() {
        return averageTimeNs;
    }

    public double getStandardDeviationNs() {
        return standardDeviationNs;
    }

    @Override
    public String toString() {
        return String.format(
                "%-18s | n=%-8d | media = %12.2f ns | desvio padrao = %12.2f ns",
                algorithmName, dataSize, averageTimeNs, standardDeviationNs
        );
    }
}
