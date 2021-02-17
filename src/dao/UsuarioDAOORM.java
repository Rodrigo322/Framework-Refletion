/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConexcaoDB;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ValidadorDeTypesJavaforSql;

/**
 *
 * @author Max Cell
 */
public class UsuarioDAOORM {

    Connection conexao = null;

    public UsuarioDAOORM() throws SQLException {
        Connection conexao = (Connection) new ConexcaoDB().conectar();
    }

    //METODO PARA CRIAR UMA TABELA NO BANCO DE DADOS
    public <T> void criarTabela(Class<T> classGenericType) throws SQLException {

        // instanciando o validador de tipos
        ValidadorDeTypesJavaforSql validator = new ValidadorDeTypesJavaforSql();

        //FieldList, para percorrer os campos que irão conter na tabela, pegando nome e tipo
        Field FieldList[] = classGenericType.getDeclaredFields();
        
        // responsavel pela criação da tabela, pegando o nome da classe pra ser uma representação de tabela no banco de dados.
        String criarTabela = "CREATE TABLE IF NOT EXISTS " + classGenericType.getSimpleName() + "(";

        criarTabela += "" + "\n" + FieldList[1 - 1].getName() + " "
                + validator.ConversordeTypes(FieldList[1 - 1]
                        .getType()
                        .toString()
                        .replaceAll("class java.lang", "")) + " AUTO_INCREMENT,";

        // percorrer todos os campos da tabela utilzando o for, pegando nome e tipo, com FieldList
        for (int index = 2; index <= FieldList.length; index++) {
            criarTabela += "" + "\n" + FieldList[index - 1].getName()
                    + " " + validator.ConversordeTypes(FieldList[index - 1]
                            .getType()
                            .toString()
                            .replaceAll("class java.lang", "")) + ",";
            criarTabela += "" + "\n" + "PRIMARY KEY (" + FieldList[1 - 1].getName() + ")";
            criarTabela += "\n )";

            PreparedStatement stmt = conexao.prepareStatement(criarTabela);
            stmt.execute();
            stmt.close();
        }
    }
}
