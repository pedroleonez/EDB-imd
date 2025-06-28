# 🌐 Justificativa da Estrutura Utilizada - Navegação de Páginas no Navegador

## ✅ Estrutura Escolhida: Lista Duplamente Encadeada

## 🔍 Motivos da Escolha

1. **Navegação Bidirecional**
   - O problema exige a possibilidade de **voltar à página anterior** e **avançar à próxima página**.
   - Uma lista duplamente encadeada permite essa navegação eficiente com ponteiros `anterior` e `próximo`.

2. **Alterações na Estrutura ao Visitar Nova Página**
   - Ao visitar uma nova página após voltar, todas as páginas futuras devem ser **descartadas**.
   - A lista duplamente encadeada facilita essa exclusão, permitindo reorganizar os ponteiros com facilidade.

3. **Sem Necessidade de Estrutura Circular**
   - A navegação não é cíclica: ao chegar no fim ou no início, o usuário não deve "voltar automaticamente" para o outro extremo.
   - Portanto, **lista circular não é apropriada**.

4. **Ordem Importa**
   - O histórico deve manter a **ordem de visitação**, o que é naturalmente preservado por uma lista encadeada.

---

## ❌ Por que não Lista Simples?

- A volta à página anterior exigiria percorrer a lista desde o início a cada vez.
- A remoção de páginas posteriores (quando se visita uma nova) seria menos eficiente.

## ❌ Por que não Lista Circular?

- A navegação em navegador **não é cíclica**.
- Ir do fim para o começo automaticamente seria comportamento incorreto.

---

## 🧠 Conclusão

A **lista duplamente encadeada** é a estrutura **mais adequada** para simular o histórico de navegação:
- ✅ Permite navegação para frente e para trás
- ✅ Suporta visitação de nova página com descarte de futuras
- ✅ Mantém a ordem de acesso

Ela atende perfeitamente às necessidades funcionais de um navegador moderno.