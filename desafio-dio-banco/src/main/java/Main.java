import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Banco Java");

        System.out.println("Bem-vindo ao " + banco.getNome() + "!");
        System.out.print("Quantos clientes deseja cadastrar? ");
        int qtdClientes = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < qtdClientes; i++) {
            System.out.println("\nCadastro do Cliente #" + (i + 1));

            System.out.print("Nome do Cliente: ");
            String nomeCliente = scanner.nextLine();

            Cliente cliente = new Cliente();
            cliente.setNome(nomeCliente);

            System.out.print("Escolha o tipo de conta (1 - Corrente, 2 - Poupança): ");
            int tipoConta = scanner.nextInt();
            scanner.nextLine();

            Conta novaConta = (tipoConta == 1) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);

            System.out.print("Depósito inicial: R$ ");
            double depositoInicial = scanner.nextDouble();
            scanner.nextLine();

            novaConta.depositar(depositoInicial);
            banco.adicionarConta(novaConta);
        }

        int opcao;
        do{
            System.out.println("\nMenu de Operações:");
            System.out.println("[1] Depositar");
            System.out.println("[2] Sacar");
            System.out.println("[3] Transferir");
            System.out.println("[4] Listar Contas");
            System.out.println("[5] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeDeposito = scanner.nextLine();
                    Conta contaDeposito = banco.buscarContaPorNome(nomeDeposito);

                    if(contaDeposito != null) {
                        System.out.print("Digite o valor para depósito: R$ ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        contaDeposito.depositar(valor);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeSaque = scanner.nextLine();
                    Conta contaSaque = banco.buscarContaPorNome(nomeSaque);

                    if(contaSaque != null) {
                        System.out.print("Digite o valor para saque: R$ ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        contaSaque.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do cliente que irá transferir: ");
                    String nomeRemetente = scanner.nextLine();
                    Conta contaRemetente = banco.buscarContaPorNome(nomeRemetente);

                    if(contaRemetente != null) {
                        System.out.print("Digite o nome do destinatário: ");
                        String nomeDestinatario = scanner.nextLine();
                        Conta contaDestinatario = banco.buscarContaPorNome(nomeDestinatario);

                        if(contaDestinatario != null) {
                            System.out.print("Digite o valor para transferência: R$ ");
                            double valor = scanner.nextDouble();
                            scanner.nextLine();
                            contaRemetente.transferir(valor, contaDestinatario);
                        } else {
                            System.out.println("Conta do destinatário não encontrada.");
                        }
                    } else {
                        System.out.println("Conta do remetente não encontrada.");
                    }
                    break;

                case 4:
                    banco.listarContas();
                    break;

                case 5:
                    System.out.println("Obrigado por utilizar o Banco Java! Até logo.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 5);

        scanner.close();
    }
}
