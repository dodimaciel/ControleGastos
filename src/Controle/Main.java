package Controle;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Douglas on 16/11/2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        int opmaster = 0;
        int opintermed = 0;
        Gastos gastos = new Gastos();
        Usuario user = new Usuario();
        Empresa empresa1 = new Empresa();

        do {
            Scanner tc = new Scanner(System.in);
            System.out.println(" ------------------------------------- ");
            System.out.println(" ---- MENU PRINCIPAL ---- ");
            System.out.println(" ---- 1 MENU USUARIO ---- ");
            System.out.println(" ---  2 MENU EMPRESA ---- ");
            System.out.println(" ---  3 MENU GASTOS  ----");
            System.out.println(" ---  4 FINALIZAR PROGRAMA ---- ");
            System.out.println(" ------------------------------------- ");
            opmaster = tc.nextInt();

            switch (opmaster) {
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


                case 2: {

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
                        case 5:
                            break;
                    }
                }

                case 3:
                    int op = 0;
                    Scanner l = new Scanner(System.in);

                    System.out.println(" ** 1 - Adicionar Gasto ** ");
                    System.out.println(" ** 2 - Exibir Gasto ** ");
                    System.out.println(" ** 3 - Remover Gasto por ID");
                    System.out.println(" ** 4 - Voltar para o meu principal ** ");
                    op = l.nextInt();

                    switch (op) {
                        case 1:

                            String iduser;
                            String idemp;

                            System.out.println("\n - - - - - - - - USUARIO - - - - - - - - ");
                            user.pesquisa();
                            System.out.println("\n - - - - - - - - EMPRESA - - - - - - - - ");
                            empresa1.pesquisa();
                            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");


                            System.out.println("Digite o ID do Usuario: ");
                            iduser = l.next();
                            System.out.println("Digite o ID da Empresa");
                            idemp = l.next();

                            gastos.ler();
                            gastos.inserir(iduser, idemp);
                            break;
                        case 2:
                            gastos.pesquisaGastos();
                            break;
                        case 3:
                            gastos.pesquisaGastos();
                            gastos.remover();
                            break;
                    }
            }

        } while (opmaster != 5) ;
    }
}