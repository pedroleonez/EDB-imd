package lista_exercicios.aula09;

/**
 O Bubble Sort não é utilizado em aplicações de grande escala por sua ineficiência inerente, especialmente quando comparado a outros algoritmos de ordenação. A principal razão reside em sua complexidade de tempo assintótica, que é de O(n2) (lê-se "ordem de n ao quadrado") tanto no pior caso quanto no caso médio.

    Complexidade de Tempo O(n2):
        Isso significa que o tempo que o algoritmo leva para ordenar um vetor cresce quadraticamente com o número de elementos (n). Se você dobrar o número de elementos, o tempo de execução quadruplica. Se multiplicar por 10, o tempo de execução multiplica por 100.
        Para um vetor com 10.000 elementos (n=104), n2 é 108 (100 milhões) de operações. Para 1.000.000 de elementos (n=106), n2 é 1012 (1 trilhão) de operações.
        Em contraste, algoritmos mais eficientes como Merge Sort, Quick Sort ou Heap Sort têm uma complexidade de tempo média (e muitas vezes de pior caso) de O(nlogn). Para 1.000.000 de elementos, nlogn é aproximadamente 1.000.000×log2​(1.000.000)≈1.000.000×20=20.000.000 operações, uma diferença monumental em relação a 1 trilhão.

    Alto Número de Comparações e Trocas:
        Em cada passagem, o Bubble Sort compara pares de elementos adjacentes. Mesmo com a otimização que interrompe o algoritmo se nenhuma troca ocorrer em uma passagem, ele ainda precisa percorrer quase todo o array (ou toda a parte não ordenada) para verificar se ele já está ordenado.
        Para um array totalmente desordenado, ele realiza um número excessivo de trocas. Pense em um pequeno elemento que está no final de um array grande: ele precisa "borbulhar" uma posição por vez, passando por n−1 trocas no pior cenário de cada passagem até chegar ao início.

    Ineficiência em Movimentos:
        O Bubble Sort é ineficiente na forma como move os elementos para suas posições corretas. Um elemento pode se mover apenas uma posição por vez em cada comparação-e-troca. Isso faz com que elementos que estão muito longe de sua posição final (pequenos elementos no final do array ou grandes elementos no início) exijam muitas passagens e trocas.

    Não Aproveita Estruturas Parciais:
        Embora a otimização ajude no melhor caso (array já ordenado), no caso médio ou pior caso, ele não se adapta bem a arrays que já possuem alguma ordem parcial, diferente de algoritmos como Insertion Sort que se beneficiam disso.

Em resumo, enquanto o Bubble Sort é excelente para propósitos educacionais devido à sua simplicidade e facilidade de visualização, sua performance quadrática o torna impraticável para qualquer aplicação real que envolva ordenação de grandes volumes de dados. Para essas aplicações, são preferidos algoritmos com complexidade O(nlogn) por sua escalabilidade muito superior.
 */
