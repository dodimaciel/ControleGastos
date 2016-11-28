package Controle;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void inserir(String idusuario, String idempresa) {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();
            String sql = "INSERT INTO gastos(idusuario, idempresa, nome, valor) " +
                    "VALUES (" + idusuario + ", " + idempresa + ", '" + this.nome + "', " + this.valor + ")";
            System.out.println(sql);
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


    public void remover () throws SQLException {
        try {
            Scanner tc = new Scanner(System.in);
            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Abrindo Conexão... ");
            String removeGasto;

            System.out.print("Digite o id dos Gastos para efetuar a Exclusão:  ");
            removeGasto = tc.next();

            String sql = "DELETE FROM gastos where idgasto = '" + removeGasto + "'";

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.execute();
            conexao.close();

            System.out.println("\nDELETADO COM SUCESSO\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void pesquisaGastos() throws SQLException {
        Connection conexao = ConnectionFactory.createConnection();
        String sql = "SELECT * FROM gastos";
        PreparedStatement comando = conexao.prepareStatement(sql);

        ResultSet result = comando.executeQuery(sql);

        while (result.next()) {

            Gastos gastos = new Gastos();

            System.out.println(" ---------RESULTADO------------- ");
            System.out.println("ID GASTO = " + result.getInt(1));
            System.out.println("ID USUARIO = " + result.getInt(4));
            System.out.println("NOME GASTO = " + result.getString(2));
            System.out.println("VALOR GASTO = " + result.getInt(3));
            System.out.println(" -------------------------------- ");
        }
    }
}