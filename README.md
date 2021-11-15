# expression-solver

Projeto baseado em java para resolver expressões matemáticas simples.

São interpretadas operações de soma, subtração, multiplicação e divisão, sem a presença de espaços em nenhum momento.

As expressões são transformadas em notação pós fixa e posteriomente resolvidas.

Casos exemplo:
+ `"3+2/5+3"`. Resultado: 6.4
+ `"8*4/2-5*2"`. Resultado: = 6
+ `"3+2/(5+3)+8"`. Resultado: = 11.25
+ `"3+5*(7-2)/4"`. Resultado: = 9.25
+ `"3+(5-8/2)*(3+5-1)+7"`. Resultado: = 17