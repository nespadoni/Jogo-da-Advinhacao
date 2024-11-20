package br.com.jogodaadvinhacao.Principal;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void exibeMenu() {
        int sair = -1;

        while (sair != 0) {
            System.out.println("""
                Olá, seja bem vindo ao Jogo da Adivinhação!
                Escolha uma opção abaixo.
                
                1- Iniciar Jogo
                2- Instruções
                
                0- Sair
                
                """);

            sair = scanner.nextInt();
            scanner.nextLine();

            switch (sair) {
                case 1:
                    iniciarJogo();
                    break;
                case 2:
                    instrucoes();
                    break;
                case 0:
                    sairDoJogo();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    private void sairDoJogo() {
        System.out.println("Obrigado por jogar!");
        System.out.println("Saindo!");
    }

    private void instrucoes() {
        System.out.println("""
                Instruções:
                Nós geraremos um número aleatório dentro de um intervalo fixo de 1 a 100.
                A sua função é tentar adivinhar o número no menor número de tentativas possíveis.
                """);
    }

    private void iniciarJogo() {
        int min = 1;
        int max = 100;

        int numeroAleatorio = random.nextInt(max-min+1);
        int numeroEscolhido = 0;
        int tentativas = 0;
        int tentativasMax = 10;

        while (numeroEscolhido != numeroAleatorio && tentativas < tentativasMax) {
            System.out.println("Escolha um número dentro de 1 a 100.");
            numeroEscolhido = scanner.nextInt();
            scanner.nextLine();

            if (numeroEscolhido < numeroAleatorio) {
                System.out.println("O seu número é menor que o número correto: Tente um número maior");
                tentativas++;
            } else if (numeroEscolhido > numeroAleatorio){
                System.out.println("O seu número é maior que o número correto: Tente um número menor");
                tentativas++;
            } else {
                System.out.println("Parabéns você acertou! \nO número aleatório era: " + numeroAleatorio);
            }

            if (tentativas == tentativasMax) {
                System.out.println("As suas tentativas acabaram! O número aleatório era: " + numeroAleatorio);
            }

        }

        System.out.println("Retornando ao menu...");
    }
}
