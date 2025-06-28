# 🎮 Justificativa da Estrutura Utilizada - Sistema de Rodízio de Jogadores

## ✅ Estrutura Escolhida: Lista Encadeada Circular

## 🔍 Motivos da Escolha

1. **Rodízio Contínuo**
   - O jogo exige que os jogadores se alternem indefinidamente.
   - A **lista circular** permite retornar ao primeiro jogador automaticamente após o último, sem lógica adicional.

2. **Eficiência ao Avançar**
   - A operação de passar ao próximo jogador é feita em tempo constante (`O(1)`), pois cada nó conhece seu sucessor.

3. **Remoção e Adição Flexíveis**
   - Permite adicionar novos jogadores ao final e remover o jogador atual de forma eficiente.
   - É possível manter a estrutura circular mesmo com remoções intermediárias.

---

## ❌ Por que não Lista Simples?

- A lista encadeada simples **não retorna automaticamente ao início**, o que exigiria lógica extra para reiniciar o rodízio manualmente.

## ❌ Por que não Lista Duplamente Encadeada?

- A navegação para trás **não é necessária** neste problema.
- Adicionar ponteiros para o anterior aumentaria a complexidade sem benefício.

---

## 🧠 Conclusão

A **lista circular simples** é a estrutura **mais adequada** para gerenciar rodízio de jogadores:
- ✅ Naturalmente cíclica
- ✅ Leve e eficiente
- ✅ Ideal para jogos com turnos repetitivos

Ela cumpre todos os requisitos do problema com elegância e desempenho.