Aqui está uma proposta de **README.md** completa e profissional, estruturada exatamente conforme o modelo solicitado e pronta para ser utilizada no seu repositório do GitHub.

---

# Simulador de Algoritmos de Substituição de Páginas

Este projeto é um simulador de gerenciamento de memória virtual que visa comparar a eficiência de diferentes estratégias de substituição de páginas, contabilizando as faltas de página (*page faults*) em diversos cenários.

---

## Resumo
Este trabalho apresenta o desenvolvimento de um simulador em linguagem Java para avaliar o desempenho dos algoritmos de substituição de páginas: **FIFO**, **LRU**, **Relógio (Segunda Chance)** e **Ótimo**. O sistema recebe uma cadeia de referências e uma quantidade determinada de quadros de memória, processando cada algoritmo de forma independente para comparar o número de faltas de página geradas. O projeto inclui uma interface gráfica (GUI) para facilitar a interação e análise dos resultados.

## 1. Introdução
O gerenciamento de memória virtual é um componente essencial dos sistemas operacionais modernos, permitindo que processos utilizem mais memória do que a disponível fisicamente. Quando uma página necessária não está na RAM, ocorre uma "Falta de Página", exigindo a escolha de uma página residente para ser substituída. 

Neste contexto, o simulador foca em quatro algoritmos fundamentais:
*   **FIFO (First-In, First-Out):** Substitui a página que está na memória há mais tempo.
*   **LRU (Least Recently Used):** Substitui a página que não é utilizada há mais tempo no passado.
*   **Relógio (Clock):** Uma aproximação eficiente do LRU que utiliza um bit de referência em uma lista circular.
*   **Ótimo:** Substitui a página que ficará o maior período de tempo sem ser utilizada no futuro (utilizado como *benchmark*).

## 2. Metodologia
O simulador foi desenvolvido utilizando a linguagem **Java** com uma arquitetura organizada em pacotes para separação de responsabilidades:

*   **`br.com.simulador.logic`**: Contém as classes `Fifo.java`, `Lru.java`, `Otimo.java` e `Relogio.java`. Cada classe implementa a lógica específica do algoritmo de forma isolada.
*   **`br.com.simulador.view`**: Contém a classe `SimuladorGUI.java`, responsável pela interface gráfica desenvolvida em **Swing**. A interface permite a inserção manual da sequência de páginas e a seleção da quantidade de quadros (frames).
*   **`br.com.simulador.main`**: Contém a classe `Main.java`, que atua como o ponto de entrada da aplicação, inicializando a interface gráfica.

O fluxo de processamento consiste na captura da *string* de entrada, conversão para um vetor de inteiros e execução sequencial dos métodos de cálculo de cada algoritmo.

## 3. Resultados e Discussão
Para fins de validação, o simulador foi testado com a seguinte configuração:
*   **Sequência de Páginas:** `7, 0, 1, 8, 3, 3, 0, 8, 2, 3, 0, 3, 2, 9, 2, 0, 1, 7, 0, 13, 1, 0, 0, 1, 14`
*   **Quantidade de Quadros:** `5`

### Tabela Comparativa de Resultados:
| Algoritmo | Faltas de Página | Desempenho Relativo |
| :--- | :---: | :--- |
| **Ótimo** | 9 | Referência Ideal |
| **LRU** | 11 | Eficiência Alta |
| **Relógio** | 11 | Idêntico ao LRU (neste cenário) |
| **FIFO** | 12 | Menor Eficiência |

**Discussão:**
Os resultados demonstram que o algoritmo **Ótimo** obteve o menor número de faltas (9), conforme esperado por sua natureza preditiva. O **LRU** e o **Relógio** apresentaram desempenho idêntico (11 faltas), mostrando-se eficazes ao manter páginas frequentemente acessadas (como o 0 e o 1) na memória. O **FIFO** obteve o pior desempenho (12 faltas), pois substituiu páginas baseando-se apenas no tempo de carga, sem considerar a frequência de uso recente.

## 4. Conclusão
O simulador atingiu os objetivos propostos, permitindo observar de forma prática como a escolha do algoritmo de substituição impacta diretamente a performance do sistema. Conclui-se que, em cenários de uso real, o LRU e o Relógio oferecem um excelente equilíbrio entre custo de implementação e redução de faltas de página, enquanto o FIFO, apesar de simples, pode causar gargalos por sua falta de adaptabilidade ao comportamento do processo.

## 5. Referências
*   TANENBAUM, Andrew S. **Sistemas Operacionais Modernos**. 4. ed. São Paulo: Pearson, 2016.
*   SILBERSCHATZ, Abraham; GALVIN, Peter B.; GAGNE, Greg. **Sistemas Operacionais com Java**. 8. ed. Rio de Janeiro: LTC, 2008.

---

## Como executar o projeto

1.  **Pré-requisitos:** Ter o Java JDK (versão 8 ou superior) instalado.
2.  **Clonagem:** Clone este repositório em sua máquina local.
3.  **Execução via IDE (IntelliJ/Eclipse):**
    *   Abra o projeto em sua IDE preferida.
    *   Certifique-se de que a estrutura de pastas respeita os pacotes mencionados.
    *   Execute a classe `Main.java` localizada em `src/br/com/simulador/main/Main.java`.
4.  **Uso:**
    *   Insira a sequência de números separados por vírgula no campo indicado.
    *   Defina a quantidade de quadros de memória.
    *   Clique em **"Simular Algoritmos"** para visualizar os resultados no painel inferior.
