## Question

Imagine que um banco com milhões de conta do tipo
Poupança. Em todo dia 10 do mês, o saldo da conta
deve ser adicionado em 1%. Nesse dia, é executada
uma thread que carrega a coleção de contas do banco e
executa o método atualizar(), que faz a adição do lucro
mensal

 Imagine a conta do professor com R$100 de saldo. Ele
entra na agência e faz um depósito de R$1000 (seu
salário). Isso dispara o depositar() - que está dentro de
uma thread, obviamente -, e calcula o novo saldo
(R$1100). Por um motivo que desconhecemos, o
escalonador para essa thread...

Neste exato instante, ele começa a executar outra thread
que chama o método atualizar() da mesma conta. Isso
quer dizer que, neste momento, o novo saldo calculado
da conta virá a ser R$101. Logo, o escalonador volta
para a thread que estava fazendo o depósito. O saldo
agora valerá R$1100. O depositar() acaba.
Acabando o depositar(), o escalonador volta para o
atualizar() e o executa. O saldo valerá R$101.

Esta é uma situação possível? Qual sua sugestão para
contornar este problema?

## Resposta

Esta é uma situaçào possível, e a minha sugestão é a
solução que fiz em java no src dessa pasta. Usando 
uma variável que indique que a thread está atuando
e tambem utilizando o conceito de sincronização 
que existe em java e em outras linguagens que trabalham com
multithreading.

## English

Imagine that a bank with millions of accounts of the type
Savings. On every 10th of the month, the account balance
must be added by 1%. On that day, it is performed
a thread that loads the bank account collection and
executes the update() method, which adds the profit
monthly

 Imagine the teacher's account with R$100 in balance. He
enter the branch and make a deposit of R$1000 (your
wage). This triggers deposit() - which is inside
a thread, obviously -, and calculates the new balance
(R$1100). For reasons unknown to us, the
scheduler for this thread...

At this exact moment, it starts executing another thread
which calls the update() method of the same account. That
means that, at this moment, the new balance calculated
of the account will be R$101. Then the scheduler returns
to the thread that was making the deposit. The balance
now it will be worth R$1100. The deposit() ends.
Finishing deposit(), the scheduler returns to the
update() and runs it. The balance will be worth R$101.

Is this a possible situation? What is your suggestion for
work around this problem?

## Response

This is a possible situation, and my suggestion is to
solution I made in java in the src of that folder. Using
a variable that indicates that a thread is occupied
and also using the concept of synchronization
that exists in java and other languages ​​that work with
multithread.
