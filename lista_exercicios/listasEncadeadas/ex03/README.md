# 🛒 Justificativa da Estrutura Utilizada - Carrinho de Compras

## ✅ Estrutura Escolhida: Lista Duplamente Encadeada

## 🔍 Motivos da Escolha

1. **Navegação Bidirecional**
   - O carrinho deve permitir **avançar** e **voltar** entre os itens, o que exige acesso tanto ao próximo quanto ao item anterior.
   - A **lista duplamente encadeada** oferece essa capacidade de forma direta e eficiente.

2. **Inserção ao Final**
   - Os itens geralmente são adicionados ao final da lista conforme o usuário seleciona produtos.
   - A lista duplamente encadeada permite isso com **custo constante (`O(1)`)** se mantivermos ponteiro para o último item.

3. **Remoção de Item Atual**
   - Ao remover o item atual, é importante atualizar as ligações anteriores e posteriores, o que a estrutura duplamente encadeada facilita.

4. **Ordem de Inserção Mantida**
   - A lista encadeada mantém os itens na ordem em que foram inseridos, o que é coerente com o uso típico de um carrinho de compras.

---

## ❌ Por que não Lista Simples?

- Não permite **voltar ao item anterior** de forma eficiente.
- A remoção de um item do meio exige percorrer desde o início até o nó anterior.

## ❌ Por que não Lista Circular?

- A navegação no carrinho é **linear e finita**.
- Não há necessidade de retornar automaticamente do fim para o início ou vice-versa.

---

## 🧠 Conclusão

A **lista duplamente encadeada** atende perfeitamente às necessidades do carrinho de compras:
- ✅ Permite avançar e voltar entre itens.
- ✅ Suporta remoção e adição de itens com facilidade.
- ✅ Mantém a ordem e oferece controle sobre o item atual.

Por isso, é a estrutura **mais adequada** para essa aplicação.