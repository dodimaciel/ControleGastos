package Controle;

import java.util.Scanner;

/**
 * Created by Douglas on 16/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        int opmaster = 0;
        int opintermed = 0;

        Usuario user = new Usuario();
        Empresa empresa1 = new Empresa();

        Scanner tc = new Scanner(System.in);
        do {
            System.out.println(" ------------------------------------- ");
            System.out.println(" ---- MENU PRINCIPAL ---- ");
            System.out.println(" ---- 1 MENU USUARIO ---- ");
            System.out.println(" ---  2 MENU EMPRESA ---- ");
            System.out.println(" ---  3 MENU GASTOS  ----");
            System.out.println(" ---  4 FINALIZAR PROGRAMA ---- ");
            System.out.println(" ------------------------------------- ");
            opmaster = tc.nextInt();

            do switch (opmaster) {
                case 1:
                    System.out.println(" ** 1 - Adicionar Usuario ** ");
                    System.out.println(" ** 2 - Remover Usuario ** ");
                    System.out.println(" ** 3 - Editar Usuario ** ");
                    System.out.println(" ** 4 - Listar Usuario ** ");
                    System.out.println(" ** 5 - Voltar para o meu principal ** ");
                    opintermed = tc.nextInt();

                    switch (opintermed) {
                        case 1:
                            user.ler();
                            user.inserir();
                            break;
                        case 2:
                            user.delete();
                            break;
                        case 3:
                            user.update();
                            break;
                        case 4:
                            user.listar();
                            break;
                        default:
                            break;
                    }
                    break;

                case 2:
                    int emp = 0;
                    Empresa empresa = new Empresa();
                    System.out.println(" ** 1 - Adicionar Empresa ** ");
                    System.out.println(" ** 2 - Remover Empresa ** ");
                    System.out.println(" ** 3 - Editar Empresa ** ");
                    System.out.println(" ** 4 - Listar Empresa ** ");
                    System.out.println(" ** 5 - Voltar para o meu principal ** ");
                    emp = tc.nextInt();

                    switch (emp) {
                        case 1:
                            empresa.ler();
                            empresa.inserir();
                            break;
                        case 2:
                            empresa.delete();
                            break;
                        case 3:
                            empresa.update();
                            break;
                        case 4:
                            empresa.listar();
                            break;
                        default:
                    }
                    break;

                case 3:
                    Scanner l = new Scanner(System.in);

                    Gastos gastos = new Gastos();

                    int usuarioid;
                    int empresaid;

                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("ESCOLHENDO UM USUARIO PARA INSERIR NO BANCO!");
                    user.exibir();
                    System.out.println("ESCOLHENDO UMA EMPRESA PARA INSERIR NO BANCO!");
                    empresa1.exibir();
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");

                    System.out.println("Digite o ID do Usuario: ");
                    usuarioid = l.nextInt();

                    System.out.println("Digite o ID da Empresa: ");
                    empresaid = l.nextInt();


            } while (opintermed != 5);
        } while (opmaster != 4);
    }
}