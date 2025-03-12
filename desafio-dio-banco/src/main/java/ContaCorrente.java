public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato conta corrente ===" );
        super.imprimirInfosComuns();
    }
}
