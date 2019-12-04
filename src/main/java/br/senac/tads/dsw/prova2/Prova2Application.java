package br.senac.tads.dsw.prova2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inicialização do Spring Boot - DSW-A. Na primeira execução, irá carregar o
 * banco de dados com dois registros.
 * 
 * @author ftsuda-senac
 */
@SpringBootApplication
public class Prova2Application implements CommandLineRunner {

	@Autowired
	private InicializacaoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Prova2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (repository.count() == 0) {
			repository.save(new Tarefa("Varrer o chão", "João da Silva"));
			repository.save(new Tarefa("Lavar a louça", "Maria de Souza"));
			repository.save(new Tarefa("Arrumaro quarto", "José das Cruzes"));

		}
	}
}
