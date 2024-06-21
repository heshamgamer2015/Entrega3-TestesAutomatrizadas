package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.entity.Entrada;
import app.entity.Saida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculoServiceTest {

	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("TESTE UNITÁRIO DE SOMA DE 2 + 3")
	void testarSoma() {

		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);


		int retorno = this.calculoService.somar(lista);

		assertEquals(5, retorno);

	}

	@Test
	@DisplayName("TESTE UNITÁRIO DE LANÇAMENTO DE EXCEÇÃO/ERRO")
	void testarSoma2() {

		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(4);

		assertThrows(Exception.class, () -> {
			int retorno = this.calculoService.somar(lista);
		});


	}

	
	
	@Test
	@DisplayName("TESTANDO MAIOR NÚMERO ENTRE 4,5,8,1")
	void testarMaiorNumero() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(5);
		lista.add(8);
		lista.add(1);
		
		int retorno = this.calculoService.buscarMaiorNumero(lista);
		
		assertEquals(8, retorno);
		
	}

	@Test
	@DisplayName("Teste de Unidade: Calcular Sucesso")
	void testCalcularSucesso() {
		Entrada entrada = new Entrada(1, Arrays.asList(1, 2, 3, 4));
		Saida saida = calculoService.calcular(entrada);

		assertEquals(10, saida.getSoma());
		assertEquals(4, saida.getMaiorNumeroLista());
	}

	@Test
	@DisplayName("Teste de Unidade: Calcular com Exceção")
	void testCalcularException() {
		Entrada entrada = new Entrada(1, Arrays.asList());

		assertThrows(IllegalArgumentException.class, () -> {
			calculoService.calcular(entrada);
		});
	}


}
