package lista_exercicios.revisao01;

/**
Em um sistema com muitos registros novos sendo inseridos a cada segundo, o algoritmo de ordenação menos recomendado seria o Bubble Sort.

Justificativa
    Pior Complexidade de Tempo Prática (O(N2)):
        Tanto o Bubble Sort quanto o Selection Sort e o Insertion Sort têm uma complexidade de tempo quadrática (O(N2)) no pior e no caso médio. Isso significa que, se você dobrar o número de registros (N), o tempo necessário para ordená-los quadruplica.
        No entanto, o Bubble Sort é notório por ter uma constante de proporcionalidade maior (realiza mais comparações e, principalmente, mais trocas) do que os outros algoritmos O(N2) em cenários médios e piores. Ele é geralmente o mais lento entre eles.
        Em um sistema onde N (o número de registros) está crescendo rapidamente a cada segundo, reordenar a coleção inteira com um algoritmo O(N2) rapidamente se tornaria um gargalo insustentável.

    Alto Custo de Trocas (Swaps):
        O Bubble Sort realiza muitas trocas de elementos, especialmente se o vetor estiver muito desordenado. Cada troca envolve três operações (leitura do primeiro, leitura do segundo, escrita do primeiro no segundo, escrita do segundo no primeiro). Esse custo é significativo.

    Não Adequado para Natureza Dinâmica:
        Sistemas com inserções frequentes exigem que a estrutura de dados permaneça ordenada ou possa ser eficientemente reordenada. Reaplicar o Bubble Sort (ou qualquer O(N2) completo) a todo o conjunto de dados a cada nova inserção (ou a cada segundo) é o pior cenário, pois o custo cresce exponencialmente com o tamanho dos dados. Mesmo que você só o execute periodicamente, se N for grande, o tempo de execução será inaceitável.

    Alternativas Muito Superiores:
        Para sistemas com alta taxa de inserção e necessidade de dados ordenados, são preferíveis estruturas de dados que mantêm a ordem automaticamente ao inserir elementos (como Árvores Balanceadas de Busca - TreeSet ou TreeMap em Java, ou ConcurrentSkipListSet para concorrência) ou algoritmos de ordenação com complexidade O(NlogN) (como Merge Sort ou Quick Sort) aplicados a coleções que podem ser eficientemente construídas ou atualizadas.

Em resumo, o Bubble Sort é a pior escolha para cenários de alta inserção porque sua performance O(N2) combinada com seus altos fatores constantes o torna extremamente lento e ineficiente para conjuntos de dados que crescem rapidamente, sobrecarregando o sistema com operações de ordenação desnecessárias.
 */
