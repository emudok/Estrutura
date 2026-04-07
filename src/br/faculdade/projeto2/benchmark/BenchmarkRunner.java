package br.faculdade.projeto2.benchmark;

import br.faculdade.projeto2.model.BinarySearchTree;
import br.faculdade.projeto2.search.SearchAlgorithms;
import br.faculdade.projeto2.util.DataGenerator;
import br.faculdade.projeto2.util.Statistics;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkRunner {

    private static final int EXECUTIONS = 30;
    private static final int[] DATA_SIZES = {1000, 5000, 10000, 50000, 100000};
    private static final int QUERIES_PER_EXECUTION = 1000;

    public void execute() {
        List<BenchmarkResult> results = new ArrayList<>();

        System.out.println("===============================================================");
        System.out.println("PROJETO 2 - COMPARACAO DE DESEMPENHO ENTRE SISTEMAS DE BUSCA");
        System.out.println("Execucoes por tamanho: " + EXECUTIONS);
        System.out.println("Consultas por execucao: " + QUERIES_PER_EXECUTION);
        System.out.println("===============================================================\n");

        for (int size : DATA_SIZES) {
            System.out.println("Gerando benchmark para n = " + size);

            long[] sequentialTimes = new long[EXECUTIONS];
            long[] binaryTimes = new long[EXECUTIONS];
            long[] treeTimes = new long[EXECUTIONS];

            for (int execution = 0; execution < EXECUTIONS; execution++) {
                int[] originalData = DataGenerator.generateUniqueRandomArray(size, 20);
                int[] sortedData = DataGenerator.sortedCopy(originalData);
                BinarySearchTree tree = DataGenerator.buildRandomizedTree(originalData);
                int[] queries = DataGenerator.generateQuerySet(originalData, QUERIES_PER_EXECUTION);

                warmUp(sortedData, tree, queries);

                sequentialTimes[execution] = measureSequentialSearch(originalData, queries);
                binaryTimes[execution] = measureBinarySearch(sortedData, queries);
                treeTimes[execution] = measureTreeSearch(tree, queries);
            }

            results.add(new BenchmarkResult(
                    "Busca Sequencial",
                    size,
                    Statistics.mean(sequentialTimes),
                    Statistics.standardDeviation(sequentialTimes)
            ));

            results.add(new BenchmarkResult(
                    "Busca Binaria",
                    size,
                    Statistics.mean(binaryTimes),
                    Statistics.standardDeviation(binaryTimes)
            ));

            results.add(new BenchmarkResult(
                    "Busca em Arvore",
                    size,
                    Statistics.mean(treeTimes),
                    Statistics.standardDeviation(treeTimes)
            ));

            System.out.println("Concluido n = " + size + "\n");
        }

        printResults(results);
        printComplexityAnalysis();
    }

    private void warmUp(int[] sortedData, BinarySearchTree tree, int[] queries) {
        for (int i = 0; i < Math.min(100, queries.length); i++) {
            SearchAlgorithms.binarySearch(sortedData, queries[i]);
            tree.contains(queries[i]);
        }
    }

    private long measureSequentialSearch(int[] data, int[] queries) {
        long start = System.nanoTime();

        int foundCount = 0;
        for (int query : queries) {
            if (SearchAlgorithms.sequentialSearch(data, query)) {
                foundCount++;
            }
        }

        long end = System.nanoTime();

        validateFoundCount(foundCount, queries.length);
        return end - start;
    }

    private long measureBinarySearch(int[] sortedData, int[] queries) {
        long start = System.nanoTime();

        int foundCount = 0;
        for (int query : queries) {
            if (SearchAlgorithms.binarySearch(sortedData, query)) {
                foundCount++;
            }
        }

        long end = System.nanoTime();

        validateFoundCount(foundCount, queries.length);
        return end - start;
    }

    private long measureTreeSearch(BinarySearchTree tree, int[] queries) {
        long start = System.nanoTime();

        int foundCount = 0;
        for (int query : queries) {
            if (tree.contains(query)) {
                foundCount++;
            }
        }

        long end = System.nanoTime();

        validateFoundCount(foundCount, queries.length);
        return end - start;
    }

    private void validateFoundCount(int foundCount, int totalQueries) {
        if (foundCount < 0 || foundCount > totalQueries) {
            throw new IllegalStateException("Resultado de benchmark invalido.");
        }
    }

    private void printResults(List<BenchmarkResult> results) {
        System.out.println("===============================================================");
        System.out.println("RESULTADOS FINAIS");
        System.out.println("===============================================================");

        for (BenchmarkResult result : results) {
            System.out.println(result);
        }
    }

    private void printComplexityAnalysis() {
        System.out.println("\n===============================================================");
        System.out.println("ANALISE ASSINTOTICA");
        System.out.println("===============================================================");
        System.out.println("Busca Sequencial:");
        System.out.println("  Melhor caso: O(1)");
        System.out.println("  Caso medio:  O(n)");
        System.out.println("  Pior caso:   O(n)");

        System.out.println("\nBusca Binaria:");
        System.out.println("  Melhor caso: O(1)");
        System.out.println("  Caso medio:  O(log n)");
        System.out.println("  Pior caso:   O(log n)");
        System.out.println("  Observacao: exige vetor ordenado.");

        System.out.println("\nBusca em Arvore Binaria de Busca:");
        System.out.println("  Melhor caso: O(1)");
        System.out.println("  Caso medio:  O(log n)");
        System.out.println("  Pior caso:   O(n)");
        System.out.println("  Observacao: o pior caso ocorre quando a arvore degenera.");
    }
}
