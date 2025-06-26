# 📄 Justificativa da Estrutura Utilizada

## ✅ Estrutura Escolhida: Lista Encadeada Simples

### 🔍 Motivos da Escolha

1. **Inserção com Prioridade**
   - A lógica exige que pacientes com idade maior ou igual a 60 anos sejam inseridos *logo após o último idoso já na fila*.
   - A lista encadeada simples permite percorrer a lista até encontrar esse ponto e inserir o novo nó sem complicações.

2. **Remoção no Início da Fila**
   - O atendimento ocorre sempre com o *primeiro paciente da fila*, e a remoção do primeiro nó em uma lista simples é uma operação de custo constante (`O(1)`).

3. **Baixa Complexidade**
   - Como o problema *não exige retrocesso na lista*, não há necessidade de ponteiros para o elemento anterior (como em listas duplamente encadeadas).

4. **Fila Linear**
   - A fila é naturalmente linear, ou seja, *não há ciclo* nem repetição automática de elementos.
   - Portanto, *não há vantagem no uso de listas circulares* neste cenário.

---

### ❌ Por que não Lista Duplamente Encadeada?

- A navegação para trás nunca é necessária.
- Adicionaria complexidade e consumo de memória desnecessários.

---

### ❌ Por que não Lista Circular?

- Não existe necessidade de voltar ao início da fila automaticamente.
- O ciclo não traria nenhum benefício à lógica do problema.

---

## 🧠 Conclusão

A **lista encadeada simples** é a estrutura **mais adequada** para representar uma fila com prioridade, como a do atendimento do posto de saúde.  
Ela oferece **eficiência, simplicidade e economia de recursos**, atendendo perfeitamente aos requisitos do problema.