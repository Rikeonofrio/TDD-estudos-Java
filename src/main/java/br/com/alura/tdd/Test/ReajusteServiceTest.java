package main.java.br.com.alura.tdd.Test;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {

        this.service = new ReajusteService();
        this.funcionario = new Funcionario("edina", LocalDate.now(), new BigDecimal("1000.00"));
    }
    @AfterEach
    public void finalizar(){
        System.out.println("fim");
    }
    @BeforeAll
    public static void AntesDeTodos(){
        System.out.println("antes de todos");
    }
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("unica vez depois de todos");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDeixarADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoBateAMeta() {
        service.concederReajuste(funcionario, Desempenho.SATISFATORIO);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVinteQuandoUltrapassaAMeta() {
        service.concederReajuste(funcionario, Desempenho.EXPLENDIDO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
