package com.gamedoora.model;

import com.gamedoora.model.util.HibernateUtil;

public class GenerateSchemaApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        // Call the generateSchema() method after the application starts
            HibernateUtil hibernateUtil = new HibernateUtil();
            hibernateUtil.generateSchema();
            System.out.println("Schema generation completed.");

    }
}
