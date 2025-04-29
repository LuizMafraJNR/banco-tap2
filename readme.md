### README

# Simulação do Banco Firmeza Investimentos

## Objetivo
O objetivo da simulação é determinar o número ideal de atendentes de caixa para que cada cliente não espere mais de **2 minutos** na fila durante o horário de pico (11:00 -> 13:00).

## Cenário
- **Intervalo de chegada dos clientes:** entre 5 e 50 segundos.
- **Tempo de atendimento por cliente:** entre 30 e 120 segundos.

A simulação utiliza programação concorrente para processar os atendimentos e gerar estatísticas.

## Estatísticas Geradas
1. Quantidade de clientes atendidos.
2. Tempo máximo de espera na fila.
3. Tempo máximo de atendimento.
4. Tempo médio que um cliente permanece no banco (entrada até saída).
5. Tempo médio de espera na fila, indicando se o objetivo de **2 minutos** foi atingido.

---

## Resultados das Simulações

### Caso 1: 3 Atendentes por 300 segundos
- **Clientes atendidos:** 7
- **Tempo máximo de espera:** 0s
- **Tempo máximo de atendimento:** 109s
- **Tempo médio no banco:** 64s
- **Tempo médio de espera:** 0s
- **Objetivo:** **Atingido**

### Caso 2: 8 Atendentes por 300 segundos
- **Clientes atendidos:** 9
- **Tempo máximo de espera:** 0s
- **Tempo máximo de atendimento:** 113s
- **Tempo médio no banco:** 70s
- **Tempo médio de espera:** 0s
- **Objetivo:** **Atingido**

---

## Conclusão
Com base nos resultados:
- Tanto com **3 atendentes** quanto com **8 atendentes**, o objetivo de manter o tempo médio de espera abaixo de **2 minutos** foi atingido.
- O aumento no número de atendentes resultou em um pequeno aumento no número de clientes atendidos, mas o tempo médio de espera permaneceu **0 segundos** em ambos os casos.

Portanto, o banco pode operar eficientemente com **3 atendentes** durante o horário de pico, garantindo que os clientes não esperem mais de **2 minutos** na fila.