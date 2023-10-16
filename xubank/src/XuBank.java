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
                            System.out.println("Você escolheu Regular.");
                            Scanner scannerRegular = new Scanner(System.in);
                            System.out.print("Digite o Nome do cliente: ");
                            String nomeRegular = scannerRegular.next();
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfRegular = scannerRegular.next();
                            System.out.print("Digite a senha do cliente: ");
                            String senhaRegular = scannerRegular.next();
                            ClienteRegular clienteRegular = new ClienteRegular(nomeRegular, cpfRegular, senhaRegular);
                            administracao.adicionarCliente(clienteRegular);
                            break;
                        case 2:
                            System.out.println("Você escolheu Gold.");
                            Scanner scannerGold = new Scanner(System.in);
                            System.out.print("Digite o Nome do cliente: ");
                            String nomeGold = scannerGold.next();
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfGold = scannerGold.next();
                            System.out.print("Digite a senha do cliente: ");
                            String senhaGold = scannerGold.next();
                            ClienteRegular clienteGold = new ClienteRegular(nomeGold, cpfGold, senhaGold);
                            administracao.adicionarCliente(clienteGold);
                            break;
                        case 3:
                            System.out.println("Você escolheu VIP.");
                            Scanner scannerVip = new Scanner(System.in);
                            System.out.print("Digite o Nome do cliente: ");
                            String nomeVip = scannerVip.next();
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfVip = scannerVip.next();
                            System.out.print("Digite a senha do cliente: ");
                            String senhaVip = scannerVip.next();
                            ClienteRegular clienteVip = new ClienteRegular(nomeVip, cpfVip, senhaVip);
                            administracao.adicionarCliente(clienteVip);
                            break;
                        default:
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
                    switch (tipoConta) {
                        case 1:
                            System.out.println("Você escolheu Conta Corrente.");
                            Scanner scannerContaCorrente = new Scanner(System.in);
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfContaCorrente = scannerContaCorrente.next();
                            System.out.print("Digite o saldo a ser depositado: ");
                            double saldoContaCorrente = scannerContaCorrente.nextDouble();
                            System.out.print("Digite o ID da conta: ");
                            int IDContaCorrente = scannerContaCorrente.nextInt();
                            ContaCorrente contaCorrente = new ContaCorrente(IDContaCorrente, saldoContaCorrente);
                            Cliente clienteContaCorrente = administracao.obterClientePorCPF(cpfContaCorrente);
                            clienteContaCorrente.adicionarConta(contaCorrente);
                            break;
                        case 2:
                            System.out.println("Você escolheu Poupança.");
                            Scanner scannerPoupanca = new Scanner(System.in);
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfPoupanca = scannerPoupanca.next();
                            System.out.print("Digite o saldo a ser depositado: ");
                            double saldoPoupanca = scannerPoupanca.nextDouble();
                            System.out.print("Digite o ID da conta: ");
                            int IDPoupanca = scannerPoupanca.nextInt();
                            Poupanca poupanca = new Poupanca(IDPoupanca, saldoPoupanca);
                            Cliente clientePoupanca = administracao.obterClientePorCPF(cpfPoupanca);
                            clientePoupanca.adicionarConta(poupanca);
                            break;
                        case 3:
                            System.out.println("Você escolheu Renda Fixa.");
                            Scanner scannerRendaFixa = new Scanner(System.in);
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfRendaFixa = scannerRendaFixa.next();
                            System.out.print("Digite o saldo a ser depositado: ");
                            double saldoRendaFixa = scannerRendaFixa.nextDouble();
                            System.out.print("Digite o ID da conta: ");
                            int IDRendaFixa = scannerRendaFixa.nextInt();
                            System.out.print("Digite o rendimento contratado: ");
                            double rendimentoContratado = scannerRendaFixa.nextInt();
                            RendaFixa rendaFixa = new RendaFixa(IDRendaFixa, saldoRendaFixa, rendimentoContratado);
                            Cliente clienteRendaFixa = administracao.obterClientePorCPF(cpfRendaFixa);
                            clienteRendaFixa.adicionarConta(rendaFixa);
                            break;
                        case 4:
                            System.out.println("Você escolheu Investimento.");
                            Scanner scannerInvestimento = new Scanner(System.in);
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfInvestimento = scannerInvestimento.next();
                            System.out.print("Digite o saldo a ser depositado: ");
                            double saldoInvestimento = scannerInvestimento.nextDouble();
                            System.out.print("Digite o ID da conta: ");
                            int IDInvestimento = scannerInvestimento.nextInt();
                            System.out.print("Digite o rendimento diário: ");
                            double rendimentoDiario = scannerInvestimento.nextDouble();
                            Investimento contaInvestimento = new Investimento(IDInvestimento, saldoInvestimento, rendimentoDiario);
                            Cliente clienteInvestimento = administracao.obterClientePorCPF(cpfInvestimento);
                            clienteInvestimento.adicionarConta(contaInvestimento);
                            break;
                        default:
                            System.out.println("Opção inválida para tipo de conta.");
                    }
                    break;
                case 3:
                    System.out.println("Você selecionou Consulta de Saldo");
                    Scanner scannerSaldo = new Scanner(System.in);
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfSaldo = scannerSaldo.next();
                    System.out.print("Digite o ID da conta: ");
                    int idContaSaldo = scannerSaldo.nextInt();

                    Cliente cliente = administracao.obterClientePorCPF(cpfSaldo);

                    if (cliente != null) {
                        double saldo = cliente.obterSaldoPorID(idContaSaldo);
                        if (saldo >= 0) {
                            System.out.println("Saldo da conta: " + saldo);
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Você selecionou Consulta de Extrato");
                    Scanner scannerExtrato = new Scanner(System.in);
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfExtrato = scannerExtrato.next();
                    System.out.print("Digite o ID da conta: ");
                    int idContaExtrato = scannerExtrato.nextInt();

                    Cliente clienteExtrato = administracao.obterClientePorCPF(cpfExtrato);
                    Conta contaExtrato = clienteExtrato.obterContaPorID(idContaExtrato);
                    contaExtrato.exibirExtrato();

                    break;
                case 5:
                    System.out.println("Você selecionou Depósito");
                    Scanner scannerDeposito = new Scanner(System.in);
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfDeposito = scannerDeposito.next();
                    System.out.print("Digite a senha do cliente: ");
                    String senhaDeposito = scannerDeposito.next();
                    System.out.print("Digite o ID da conta: ");
                    int idContaDeposito = scannerDeposito.nextInt();
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scannerDeposito.nextDouble();

                    administracao.depositar(cpfDeposito, senhaDeposito, idContaDeposito, valorDeposito);
                    break;
                case 6:
                    System.out.println("Você selecionou Saque");
                    Scanner scannerSaque = new Scanner(System.in);
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfSaque = scannerSaque.next();
                    System.out.print("Digite a senha do cliente: ");
                    String senhaSaque = scannerSaque.next();
                    System.out.print("Digite o ID da conta: ");
                    int idContaSaque = scannerSaque.nextInt();
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scannerSaque.nextDouble();

                    administracao.sacar(cpfSaque, senhaSaque, idContaSaque, valorSaque);
                    break;
                case 7:
                    System.out.println("Você selecionou Transferências");
                    Scanner scannerTransferencia = new Scanner(System.in);
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf1Transferencia = scannerTransferencia.next();
                    System.out.print("Digite o ID da conta do cliente: ");
                    int idConta1Transferencia = scannerTransferencia.nextInt();
                    System.out.print("Digite a senha do cliente: ");
                    String senhaTransferencia = scannerTransferencia.next();
                    System.out.print("Digite o CPF do remetente: ");
                    String cpf2Transferencia = scannerTransferencia.next();
                    System.out.print("Digite o ID da conta do remetente: ");
                    int idConta2Transferencia = scannerTransferencia.nextInt();
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scannerTransferencia.nextDouble();

                    administracao.transferencia(cpf1Transferencia, senhaTransferencia, idConta1Transferencia, cpf2Transferencia, idConta2Transferencia, valorTransferencia);
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