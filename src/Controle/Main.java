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

            do {
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
                        }

                    case 3:
                        Gastos gastos = new Gastos();
                        Usuario users = new Usuario();
                        Empresa empres = new Empresa();
                        String usuario;
                        String empreza;

                        System.out.println(" --- MENU GASTOS --- ");

                        users.listar();

                        System.out.println("Digite o Usuario: ");
                        usuario = tc.next();

                        if (users.nomeusuario.equals(usuario)) {

                            empres.listar();
                            System.out.println("Digite o nome da Empresa: ");
                            empreza = tc.next();

                            if (empres.nomeempresa.equals(empreza)) {
                                gastos.ler();
                                gastos.inserir();
                            }
                        }
                }
            } while (opintermed != 5);
        } while (opmaster != 4);
    }
}
