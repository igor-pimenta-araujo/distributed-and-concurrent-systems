## Relatorio

- Felipe Kafuri
- Igor 
- Mozaniel

## Primeiro Experimento

Entrada de dados: Usuario 1, Usuario 2, Usuario 3, Usuario 4.
Saida de dados: 
```
Usuario 02
Usuario 02
Usuario 02
Usuario 02
Usuario 02
Usuario 04
Usuario 04
Usuario 02
Usuario 01
Usuario 04
Usuario 03
Usuario 03
Usuario 01
Usuario 01
Usuario 01
Usuario 04
Usuario 01
Usuario 01
Usuario 01
Usuario 01
```

Problema: Os usuarios deveriam aparecer cinco vezes cada, mas aparecem indefinidamente. 

## Segundo Experimento

Entrada de dados: Usuario 1, Usuario 2, Usuario 3, Usuario 4
Saida de dados: 
```
Usuario 02
Usuario 02
Usuario 02
Usuario 02
Usuario 02
Usuario 01
Usuario 01
Usuario 01
Usuario 01
Usuario 01
Usuario 03
Usuario 03
Usuario 03
Usuario 03
Usuario 03
Usuario 04
Usuario 04
Usuario 04
Usuario 04
Usuario 04
```

Problema: Foi resolvido
Solution: O usuario 1 apareceu 5 vezes, o usuario 2 apareceu 5 vezes, o usuario 3 apareceu 5 vezes, o usuario 4 apareceu 5 vezes. A forma como isso foi feito é utilizando monitores de Hoare. Assim, o recurso é protegido e as threads ficam coordenadas, pois o monitor é um artefato que cria uma proteção: a thread pede permissão ao monitor pra poder entrar no recurso.
