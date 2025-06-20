package lista_exercicios.revisao01;

/**
Em um sistema onde as notas dos alunos já vêm quase sempre em ordem crescente (ou seja, o vetor está "quase ordenado"), o algoritmo de ordenação mais eficiente seria o Insertion Sort.

Justificativa para a Escolha: Insertion Sort

    Adaptabilidade: A principal vantagem do Insertion Sort nesse cenário é sua adaptabilidade. Ele é um algoritmo que se beneficia enormemente de um array que já está parcial ou quase totalmente ordenado.
        No melhor caso (quando o array já está completamente ordenado), o Insertion Sort tem uma complexidade de tempo de O(N), pois ele apenas percorre o array uma vez, fazendo N−1 comparações e 0 trocas.
        Quando o array está quase ordenado, a "chave" (elemento a ser inserido) só precisa se deslocar algumas posições para a esquerda, resultando em poucas comparações e deslocamentos (swaps). Isso faz com que seu desempenho se aproxime muito de O(N).

    Simplicidade: É um algoritmo fácil de entender e implementar, o que é uma vantagem para sistemas de menor escala ou onde a clareza do código é importante.

    Baixo Overhead: Para o tamanho de um conjunto de notas de alunos (geralmente centenas, talvez poucos milhares), os fatores constantes do Insertion Sort são pequenos, e ele supera algoritmos mais complexos (O(NlogN) como Merge Sort ou Quick Sort) que têm uma sobrecarga inicial maior, mas são mais eficientes para arrays muito grandes e completamente desordenados.

Por que não os outros O(N2)?

    Selection Sort: Sua complexidade de comparações é sempre O(N2), independentemente da ordem inicial do array. Ele não se beneficia de arrays quase ordenados.
    Bubble Sort: Embora sua versão otimizada também possa atingir O(N) no melhor caso (array totalmente ordenado), no caso de arrays quase ordenados com alguns elementos fora do lugar, ele ainda pode fazer muitas comparações e trocas desnecessárias, sendo geralmente menos eficiente que o Insertion Sort na prática para esse cenário.
 */
