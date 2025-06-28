# 🎵 Justificativa da Estrutura Utilizada - Playlist de Músicas

## ✅ Estrutura Escolhida: Lista Duplamente Encadeada Circular

## 🔍 Motivos da Escolha

1. **Modo Contínuo (Loop Infinito)**
   - O problema exige que a playlist continue tocando indefinidamente. Uma **lista circular** é ideal para este caso, pois permite **voltar ao início automaticamente** ao chegar ao final.

2. **Navegação em Duas Direções**
   - O usuário pode **avançar para a próxima música** e **voltar para a anterior**. Para isso, é necessário que cada nó conheça tanto o **anterior quanto o próximo**, o que justifica o uso de **lista duplamente encadeada**.

3. **Inserção e Remoção em Qualquer Posição**
   - A estrutura deve permitir **inserir ou remover músicas em qualquer lugar da lista**, e a lista duplamente encadeada facilita esse processo mantendo o controle dos dois lados.

---

## ❌ Por que não Lista Simples?

- Uma lista encadeada simples **não permite voltar à música anterior** de forma eficiente.
- A lógica de looping também seria mais difícil de implementar, exigindo percorrer toda a lista para "voltar ao começo".

## ❌ Por que não Lista Circular Simples?

- Embora facilite o loop, **a ausência de ponteiro para o nó anterior** tornaria inviável a operação de "voltar para a música anterior".

---

## 🧠 Conclusão

A **lista duplamente encadeada circular** atende perfeitamente aos requisitos da playlist:
- ✅ Loop infinito
- ✅ Avanço e retrocesso entre músicas
- ✅ Inserções e remoções em qualquer posição

Portanto, é a **estrutura de dados ideal** para esse cenário.