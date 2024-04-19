package com.jciterceros.domainModelORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DomainModelOrmApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DomainModelOrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nPrinting inserted records:");

        System.out.println("Categorias:");
        jdbcTemplate.queryForList("SELECT * FROM tb_categoria").forEach(System.out::println);
        System.out.println();

        System.out.println("Atividades:");
        jdbcTemplate.queryForList("SELECT * FROM tb_atividade").forEach(System.out::println);
        System.out.println();

        System.out.println("Blocos:");
        jdbcTemplate.queryForList("SELECT * FROM tb_bloco").forEach(System.out::println);
        System.out.println();

        System.out.println("Participantes:");
        jdbcTemplate.queryForList("SELECT * FROM tb_participante").forEach(System.out::println);
        System.out.println();

        System.out.println("Participante Atividades:");
        jdbcTemplate.queryForList("SELECT * FROM tb_participante_atividades").forEach(System.out::println);
    }
}
