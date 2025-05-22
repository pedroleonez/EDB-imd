public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}