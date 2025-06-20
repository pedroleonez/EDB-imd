package lista_exercicios.revisao01;

/**
+--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Característica           | Bubble Sort                              | Selection Sort                             | Insertion Sort                             |
+--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Estabilidade             | Sim                                      | Não                                        | Sim                                        |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Complexidade de Tempo    |                                          |                                            |                                            |
|   Melhor Caso            | O(N) (com otimização, já ordenado)       | O(N^2) (comparações) / O(N) (trocas)       | O(N) (já ordenado ou quase ordenado)       |
|   Caso Médio             | O(N^2)                                   | O(N^2)                                     | O(N^2)                                     |
|   Pior Caso              | O(N^2) (em ordem inversa)                | O(N^2) (em ordem inversa ou aleatória)     | O(N^2) (em ordem inversa)                  |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Uso de Memória           | O(1) (in-place)                          | O(1) (in-place)                            | O(1) (in-place)                            |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Uso Recomendado          | Principalmente para fins didáticos;      | Para arrays muito pequenos onde a          | Para arrays pequenos, especialmente aqueles|
|                          | raramente em produção.                   | simplicidade é crucial; quando a contagem  | que estão quase ordenados ou para dados    |
|                          |                                          | de trocas é uma preocupação.               | incrementais.                              |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Eficiência Prática       | Muito Baixa (lento, muitas trocas).      | Baixa (número fixo e elevado de            | Boa para N pequeno; Excelente para dados   |
|                          |                                          | comparações).                              | quase ordenados.                           |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Ponto Forte              | Simplicidade extrema.                    | Número mínimo de trocas.                   | Adaptabilidade e eficiência para dados     |
|                          |                                          |                                            | quase ordenados.                           |
|--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+
| Ponto Fraco              | Ineficiência geral; muitas trocas.       | Número fixo e elevado de comparações;      | O(N^2) para dados muito desordenados.      |
|                          |                                          | não adaptável.                             |                                            |
+--------------------------+------------------------------------------+--------------------------------------------+--------------------------------------------+

 */
