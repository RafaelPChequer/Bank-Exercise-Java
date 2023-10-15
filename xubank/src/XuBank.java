import java.util.Scanner;

public class XuBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administracao administracao = new Administracao();
        int opcao;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Virar Cliente");
            System.out.println("2. Criar Conta");
            System.out.println("3. Consulta de saldo");
            System.out.println("4. Consulta de extrato");
            System.out.println("5. Depósito");
            System.out.println("6. Saque");
            System.out.println("7. Transferências");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você irá se tornar cliente. Escolha o tipo de cliente:");
                    System.out.println("1. Regular");
                    System.out.println("2. Gold");
                    System.out.println("3. VIP");
                    int tipoCliente = scanner.nextInt();
                    switch (tipoCliente) {
                        case 1:
                            // Feito.
                            System.out.println("Você escolheu Regular.");
                            ClienteRegular clienteRegular = new ClienteRegular("Nome do Cliente", "123.456.789-00", "senhaDoCliente");
                            administracao.adicionarCliente(clienteRegular);
                            break;
                        case 2:
                            // Feito.
                            System.out.println("Você escolheu Gold.");
                            ClienteGold clienteGold = new ClienteGold("Nome do Cliente", "123.456.789-00", "senhaDoCliente");
                            administracao.adicionarCliente(clienteGold);
                            break;
                        case 3:
                            // Feito.
                            System.out.println("Você escolheu VIP.");
                            ClienteVip clienteVip = new ClienteVip("Nome do Cliente", "123.456.789-00", "senhaDoCliente");
                            administracao.adicionarCliente(clienteVip);
                            break;
                        default:
                            // Feito.
                            System.out.println("Opção inválida para tipo de cliente.");
                    }
                    break;
                case 2:
                    System.out.println("Você selecionou criar conta. Escolha o tipo de conta:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Poupança");
                    System.out.println("3. Renda Fixa");
                    System.out.println("4. Investimento");
                    int tipoConta = scanner.nextInt();
                    // Feito.
                    switch (tipoConta) {
                        case 1:
                            // Feito.
                            System.out.println("Você escolheu Conta Corrente.");
                            ContaCorrente contaCorrente = new ContaCorrente(0);
                            administracao.adicionarConta(contaCorrente);
                            break;
                        case 2:
                            // Feito.
                            System.out.println("Você escolheu Poupança.");
                            Poupanca poupanca = new Poupanca(0);
                            administracao.adicionarConta(poupanca);
                            break;
                        case 3:
                            // Feito.
                            System.out.println("Você escolheu Renda Fixa.");
                            RendaFixa rendaFixa = new RendaFixa(0, 0);
                            administracao.adicionarConta(rendaFixa);
                            break;
                        case 4:
                            // Feito.
                            System.out.println("Você escolheu Investimento.");
                            Investimento investimento = new Investimento(0, 0);
                            administracao.adicionarConta(investimento);
                            break;
                        default:
                            // Feito.
                            System.out.println("Opção inválida para tipo de conta.");
                    }
                    break;
                case 3:
                    System.out.println("Você selecionou Consulta de Saldo");
                    break;
                case 4:
                    System.out.println("Você selecionou Consulta de Extrato");
                    break;
                case 5:
                    System.out.println("Você selecionou Depósito");
                    break;
                case 6:
                    System.out.println("Você selecionou Saque");
                    break;
                case 7:
                    System.out.println("Você selecionou Transferências");
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}