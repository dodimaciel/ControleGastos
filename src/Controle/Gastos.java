package Controle;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Created by Douglas on 16/11/2016.
 */
public class Gastos {
    public int iduser;
    public int idemp;
    public String nome;
    public double valor;

    public void ler() {
        Scanner l = new Scanner(System.in);

        System.out.println("Digite o ID do Usuario: ");
        iduser = l.nextInt();
        System.out.println("Digite o ID da empresa: ");
        idemp = l.nextInt();
        System.out.println("Digite o nome do Gasto: ");
        nome = l.next();
        System.out.println("Digite o valor do Gasto: ");
        valor = l.nextDouble();
    }

    public void exibir() {
        System.out.println("ID Usuario: " +iduser);
        System.out.println("ID Empresa: " +idemp);
        System.out.println("Nome Gasto: " + nome);
        System.out.println("Valor Gasto: " + valor);
    }

    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO gastos(iduser, idemp, nome, valor)" +
                    "VALUES ('" + this.iduser + "', '" + this.idemp+ "', '" + this.nome + "', '" + this.valor + "')";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando comando...");
            comando.execute();
            //System.out.println("Fechando conexão...");
            conexao.close();
            System.out.println("\nINSERIDO COM SUCESSO!!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}