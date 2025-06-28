# 🍽️ Justificativa da Estrutura Utilizada - Histórico de Pedidos em um Restaurante

## ✅ Estrutura Escolhida: Lista Encadeada Simples

## 🔍 Motivos da Escolha

1. **Inserção na Ordem de Chegada**
   - Os pedidos devem ser registrados conforme são feitos.
   - A **lista encadeada simples** permite adicionar elementos ao final de forma eficiente (`O(1)`), mantendo a ordem natural dos pedidos.

2. **Cancelamento de Pedidos**
   - É possível cancelar qualquer pedido da lista, o que pode ser feito com um simples **percurso sequencial** até encontrar o pedido com o número desejado.
   - A operação de remoção é eficiente o suficiente para o volume esperado de pedidos em um restaurante.

3. **Listagem de Pedidos em Andamento**
   - A estrutura permite **varrer os pedidos do início ao fim** mantendo a ordem em que foram realizados.

---

## ❌ Por que não Lista Duplamente Encadeada?

- A lista dupla só é vantajosa quando há **navegação para trás**, o que não é necessário neste caso.
- Usar uma estrutura dupla aumentaria a complexidade de implementação e consumo de memória sem oferecer benefício prático.

## ❌ Por que não Lista Circular?

- A navegação **não precisa ser cíclica**.
- A listagem e o controle seguem uma ordem linear de início para fim.

---

## 🧠 Conclusão

A **lista encadeada simples** é a estrutura mais adequada para gerenciar o histórico de pedidos de um restaurante, pois:

- ✅ Mantém a ordem dos pedidos.
- ✅ Permite cancelamentos e listagens com facilidade.
- ✅ É leve e eficiente para os requisitos do problema.

Ela atende perfeitamente as operações exigidas de forma direta e com baixo custo computacional.