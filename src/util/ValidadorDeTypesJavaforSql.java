/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Max Cell
 */
public class ValidadorDeTypesJavaforSql {
    
    public String ConversordeTypes(String typesJava) {
        
        String typesSql = null;
        // nesse converor pegamos os tipos dos atributos em java e convertermos para tipos em sql
        if(typesJava.equals("String")) {
            typesJava = "VARCHAR(255)";
        } else if (typesJava.equals("Integer") || typesJava.equals("int") || typesJava.equals("Long")) {
            typesJava = "INT";
        } else if (typesJava.equals("double")) {
            typesJava = "DOUBLE(5,2)";
        } else if(typesJava.equals("float")) {
            typesJava = "FLOAT";
        } else if(typesJava.equals("Date")) {
            typesJava = "DATE";
        }
        
        return typesJava;
    }
}
