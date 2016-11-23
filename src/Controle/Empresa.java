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
public class Empresa {
    public int idempresa;
    public String nomeempresa;
    public String enderecoempresa;
    public String contatoempresa;

    public void ler() {
        Scanner l = new Scanner(System.in);

        System.out.println("Digite o id da Empresa: ");
        idempresa = l.nextInt();
        System.out.println("Digite o nome da Empresa: ");
        nomeempresa = l.next();
        System.out.println("Digite o endereço da Empresa: ");
        enderecoempresa = l.next();
        System.out.println("Digite o contato da Empresa: ");
        contatoempresa = l.next();
    }

    public void exibir() {
        System.out.println("ID Empresa: " +idempresa);
        System.out.println("Nome Empresa: " +nomeempresa);
        System.out.println("Endereço Empresa: " +enderecoempresa);
        System.out.println("Contato Empresa: " +contatoempresa);
    }

    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO empresa(idempresa, nomeempresa, enderecoempresa, contatoempresa)" +
                    "VALUES ('" + this.idempresa + "', '" + this.nomeempresa + "', '" + this.enderecoempresa + "', '"
                    + this.contatoempresa + "')";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando comando...");
            boolean execute = comando.execute();
            //System.out.println("Fechando conexão...");
            conexao.close();
            System.out.println("\nINSERIDO COM SUCESSO!!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();
            String sql = "SELECT * FROM empresa;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("ID: %d  \nNome: %s \nEndereco: %s \nContato: %s ",
                        resultado.getInt("idempresa"),
                        resultado.getString("nomeempresa"),
                        resultado.getString("enderecoempresa"),
                        resultado.getString("contatoempresa"));
            }

            System.out.println("\nFechando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {
        try {
            Scanner l = new Scanner(System.in);
            System.out.println("Abrindo Conexão");
            Connection conexao = ConnectionFactory.createConnection();

            listar();
            System.out.println("Digite o id da Empresa: ");
            int idemp = l.nextInt();

            String novonome;
            String novoendereco;
            String novocontato;

            System.out.println("Novo nome: ");
            novonome = l.next();
            System.out.println("Novo Contato: ");
            novocontato = l.next();
            System.out.println("Novo Endereço: ");
            novoendereco = l.next();

            String sql = "UPDATE empresa SET nomeempresa = '" + novonome + "',  enderecoempresa = '" + novoendereco + "'," +
                    "  contatoempresa = '" + novocontato + "' WHERE idempresa = " + idemp +";";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando Comando...");
            comando.execute();
            //System.out.println("Fechando Conexão...");
            conexao.close();
            System.out.println("ATUALIZADO COM SUCESSO");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void delete() {
        try {
            Scanner l = new Scanner(System.in);
            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Abrindo Conexão... ");
            String idemp;

            listar();
            System.out.print("Digite o id da Empresa para efetuar a Exclusão:  ");
            idemp = l.next();

            String sql = "DELETE FROM empresa where idempresa = '" + idemp + "'";

            PreparedStatement comando = conexao.prepareStatement(sql);

            //System.out.println("Executando comando...");
            comando.execute();
            //System.out.println("\nFechando Conexão...");
            conexao.close();

            System.out.println("\nDELETADO COM SUCESSO\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pesquisa() throws SQLException {
        Connection conexao = ConnectionFactory.createConnection();
        String sql = "SELECT * FROM empresa";

        PreparedStatement comando = conexao.prepareStatement(sql);

        ResultSet result = comando.executeQuery(sql);

        while (result.next()) {

            Empresa user = new Empresa();

            System.out.println("ID = " + result.getInt(1));
            System.out.println("NOME = " + result.getString(2));
            System.out.println("ENDEREÇO = " + result.getString(3));
            System.out.println("CONTATO = " + result.getString(4));
        }
    }

}
