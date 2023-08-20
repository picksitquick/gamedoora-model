package com.gamedoora.model.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.persistence.Entity;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private String outputDir = "Your local gamedoora-data directory";

    private int schemaVersion = 3; // remove 3 and add the next version number which you want

    /**
     * Generates database create commands for the specified entities using Hibernate native API, SchemaExport.
     * Creation commands are exported into the create.sql file.
     */
    public void generateSchema() throws ClassNotFoundException {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "Driver_name");
        settings.put("dialect", "DB_Dialect");
        settings.put("hibernate.connection.url", "DB_URL");
        settings.put("hibernate.connection.username", "USERNAME");
        settings.put("hibernate.connection.password", "PASSWORD");
        settings.put("hibernate.hbm2ddl.auto", "create");
        settings.put("show_sql", "true");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        //adding all models within metadata sources manually
        //metadataSources.addAnnotatedClass(Users.class);
        //metadataSources.addAnnotatedClass();

        // adding all models within metadata sources using ClassPath Scanner.
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));

        for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.gamedoora.model.dao")) {
            Class<?> annotatedClass = Class.forName(beanDefinition.getBeanClassName());
            metadataSources.addAnnotatedClass(annotatedClass);
        }

        Metadata metadata = metadataSources.buildMetadata();

        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setHaltOnError(true);
        schemaExport.setFormat(true);

        // Specify the custom output directory and generate schema script with a new version number
        String outputDirectory = outputDir; // Replace with the desired directory path
        String scriptFileName = "gamedoora-beta-v" + schemaVersion + ".sql";

        schemaExport.setOutputFile(outputDirectory + "/" + scriptFileName);
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);

        schemaVersion++; // Increment the version number
    }
}
