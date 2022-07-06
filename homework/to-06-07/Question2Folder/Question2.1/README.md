## 2.1

- Crie uma classe Produtor que funcione como uma thread e que vai invocando o método
armazenar() da classe Depósito, acrescentando caixas ao depósito. A classe Produtor deve
receber, através do construtor, uma referência ao objeto dep onde os métodos vão ser
invocados e um inteiro correspondente ao tempo em segundos entre as produções de caixas.
Defina a classe Produtor como sendo uma classe que implementa o método Runnable.
Crie uma classe Consumidor que funcione como uma thread e que vai invocando o método
retirar() da classe Depósito, retirando caixas do depósito. A classe Consumidor deve
receber, através do construtor, uma referência ao objeto dep onde os métodos vão ser
invocados e um inteiro correspondente ao tempo em segundos entre as retiradas de caixas.
Defina a classe Consumidor como sendo uma classe que implementa o método Runnable.
Perceba que a thread Produtor deve produzir itens sucessivamente, enquanto que a thread
Consumidor deve consumi-los sucessivamente e que ambas estarão rodando em paralelo.
Execute o sistema e faça experiências:
- a) Adicione à classe Consumidor mensagens que permitam identificar o que cada objeto
Consumidor está fazendo e, em particular, se está bloqueado à espera de caixas para retirar.
- b) Altere o número de consumidores ou de produtores e os tempos médios entre produções e
consumos.