public class Principal {
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