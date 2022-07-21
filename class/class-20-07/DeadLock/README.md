## Motivo do deadlock

O motivo do deadlock no algoritmo é por conta do fato de que o processo A está bloqueado por um processo B, e o processo B está bloqueado por um processo A por conta da exclusão mutua aplicada na flag synchronized dos processos, o processo A chama o processo B e mantém ele bloqueado para terminar seu processo, 