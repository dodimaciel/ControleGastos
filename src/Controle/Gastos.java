package Controle;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Created by Douglas on 16/11/2016.
 */
public class Gastos {
    public String nome;
    public double valor;

    public void ler() {
        Scanner l = new Scanner(System.in);

        System.out.println("Digite o nome do Gasto: ");
        nome = l.next();
        System.out.println("Digite o valor do Gasto: ");
        valor = l.nextDouble();
    }

    public void exibir() {
        System.out.println("Nome Gasto: " + nome);
        System.out.println("Valor Gasto: " + valor);
    }

    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO gastos(nome, valor)" +
                    "VALUES ('" + this.nome + "', '" + this.valor + "')";

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


