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

    public static void main(String[] args) {
        var pedro = new ContaBancaria("Pedro", 1000);
        var maria = new ContaBancaria("Maria", 2000);

        System.out.println("Saldo inicial de Pedro: " + pedro.getSaldo());
        System.out.println("Saldo inicial de Maria: " + maria.getSaldo());

        System.out.println("---------------------------------------");

        pedro.depositar(500);
        System.out.println("Saldo de Pedro após depósito: " + pedro.getSaldo());

        System.out.println("---------------------------------------");

        pedro.sacar(200);
        System.out.println("Saldo de Pedro após saque: " + pedro.getSaldo());

        System.out.println("---------------------------------------");

        maria.transferir(pedro, 300);
        System.out.println("Saldo de Maria após transferência: " + maria.getSaldo());

        System.out.println("---------------------------------------");

        System.out.println("Saldo de Pedro após receber transferência: " + pedro.getSaldo());

        System.out.println("---------------------------------------");
    }
}