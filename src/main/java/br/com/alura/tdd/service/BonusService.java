package main.java.br.com.alura.tdd.service;

import main.java.br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;



public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

			if (valor.compareTo(new BigDecimal("1000")) > 0) {
				throw  new IllegalArgumentException("Funcionario com o salario maior 10mil reais nao pode ter bonus ");
			}

		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
