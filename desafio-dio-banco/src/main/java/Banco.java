import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorNome(String nomeCliente) {
        for (Conta conta : contas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        System.out.println("\n=== Contas Cadastradas ===");
        for (Conta conta : contas) {
            System.out.println("Cliente: " + conta.getCliente().getNome() +
                    " | Tipo: " + conta.getClass().getSimpleName() +
                    " | Saldo: R$ " + conta.getSaldo());
        }
    }
}
