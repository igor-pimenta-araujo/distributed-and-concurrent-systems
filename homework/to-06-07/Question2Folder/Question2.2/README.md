## 2.2

- A existência de threads concorrentes exige a necessidade de sincronização. Cada objeto, em
Java, tem associado um monitor que garante o acesso exclusivo às seções críticas do objeto,
ou seja, às áreas compartilhadas pelas threads. O programador precisa assinalar a seção
crítica usando synchronized. Um bloco de código sincronizado é uma região que apenas pode
ser executada por uma thread de cada vez.
Analise a classe Depósito e identifique possíveis problemas de concorrência. Altere a
implementação da classe usando synchronized.
