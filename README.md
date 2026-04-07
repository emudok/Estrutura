# Projeto 2 - Sistemas de Busca

## Descrição
Este projeto compara o desempenho de três estratégias de busca:

- Busca Sequencial
- Busca Binária
- Busca em Árvore Binária de Busca (BST)

A análise experimental é realizada com diferentes volumes de dados e 30 execuções para cada tamanho de entrada, calculando:

- Média do tempo de execução
- Desvio padrão

## Estrutura
- `search/`: algoritmos de busca
- `model/`: estrutura da árvore binária de busca
- `util/`: geração de dados e estatística
- `benchmark/`: execução dos experimentos e consolidação dos resultados

## Complexidade Teórica

### Busca Sequencial
- Melhor caso: O(1)
- Caso médio: O(n)
- Pior caso: O(n)

### Busca Binária
- Melhor caso: O(1)
- Caso médio: O(log n)
- Pior caso: O(log n)

### Busca em Árvore Binária de Busca
- Melhor caso: O(1)
- Caso médio: O(log n)
- Pior caso: O(n)

## Observações
A busca binária exige vetor ordenado.
A busca em árvore pode degradar para O(n) se a árvore ficar desbalanceada.
