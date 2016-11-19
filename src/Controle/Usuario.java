package Controle;

import Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Douglas on 16/11/2016.
 */
public class Usuario {
    public int idusuario;
    public String nomeusuario;
    public String enderecousuario;
    public String contatousuario;

    public void ler() {
        Scanner l = new Scanner(System.in);

        System.out.println("Digite o id do Usuário: ");
        idusuario = l.nextInt();
        System.out.println("Digite o nome do Usuário: ");
        nomeusuario = l.next();
        System.out.println("Digite o endereço do usuário: ");
        enderecousuario = l.next();
        System.out.println("Digite o contato do usuario: ");
        contatousuario = l.next();
    }

    public void exibir() {
        System.out.println("Nome: " +this.nomeusuario);
        System.out.println("Endereço: " +this.enderecousuario);
        System.out.println("Contato: " +this.contatousuario + "\n");
    }

    public void inserir() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO usuario(idusuario, nomeusuario, enderecousuario, contatousuario)" +
                    "VALUES ('" + this.idusuario + "', '" + this.nomeusuario + "', '" + this.enderecousuario + "', '" + this.contatousuario + "')";

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

    public void listar() {
        try {
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();
            String sql = "SELECT * FROM usuario;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("ID: %d  \nNome: %s \nEndereco: %s \nContato: %s ",
                        resultado.getInt("idusuario"),
                        resultado.getString("nomeusuario"),
                        resultado.getString("enderecousuario"),
                        resultado.getString("contatousuario"));
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
            System.out.println("Digite o id do Usuario: ");
            int ide = l.nextInt();

            String novonome;
            String novoendereco;
            String novocontato;

            System.out.println("Novo nome: ");
            novonome = l.next();
            System.out.println("Novo Contato: ");
            novocontato = l.next();
            System.out.println("Novo Endereço: ");
            novoendereco = l.next();

            String sql = "UPDATE usuario SET nomeusuario = '" + novonome + "',  enderecousuario = '" + novoendereco + "'," +
                    "  contatousuario = '" + novocontato + "' WHERE idusuario = " + ide +";";

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
            String iduser;

            listar();
            System.out.print("Digite o id do Usuario para efetuar a Exclusão:  ");
            iduser = l.next();

            String sql = "DELETE FROM usuario where idusuario = '" + iduser + "'";

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

}
