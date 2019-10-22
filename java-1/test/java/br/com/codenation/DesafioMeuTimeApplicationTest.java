package br.com.codenation;

import br.com.codenation.DesafioMeuTimeApplication;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.domain.Jogador;
import br.com.codenation.domain.Time;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DesafioMeuTimeApplicationTest {
    public DesafioMeuTimeApplication classe = new DesafioMeuTimeApplication();

    Time time1;
    Time time2;
    Time time3;
    Time time4;

    Jogador jogador1;
    Jogador jogador2;
    Jogador jogador3;
    Jogador jogador4;
    Jogador jogador5;
    Jogador jogador6;
    Jogador jogador7;
    Jogador jogador8;
    Jogador jogador9;
    Jogador jogador10;
    Jogador jogador11;

    @Before
    public void setUp() {
        time1 = new Time(1L, "Time 1", LocalDate.now(), "Azul", "Verde");
        time2 = new Time(2L, "Time 2", LocalDate.now(), "Azul", "Verde");
        time3 = new Time(3L, "Time 3", LocalDate.now(), "Vermelho", "Branco");
        time4 = new Time(99L, "Time 99", LocalDate.now(), "Branco", "Preto");

        jogador1 = new Jogador(1L, 1L, "Jogador 1", LocalDate.now().minusYears(21l), 90,
                new BigDecimal(1000L));
        jogador2 = new Jogador(2L, 1L, "Jogador 2", LocalDate.now().minusYears(18l), 80,
                new BigDecimal(2000L));
        jogador3 = new Jogador(3L, 2L, "Jogador 3", LocalDate.now().minusYears(30l), 100,
                new BigDecimal(3000L));
        jogador4 = new Jogador(4L, 2L, "Jogador 4", LocalDate.now().minusYears(25l), 30,
                new BigDecimal(3000));
        jogador5 = new Jogador(5L, 3L, "Jogador 5", LocalDate.now().minusYears(21l), 56,
                new BigDecimal(5000L));
        jogador6 = new Jogador(6L, 3L, "Jogador 6", LocalDate.now().minusYears(21l), 70,
                new BigDecimal(6000L));

        jogador7 = new Jogador(7L, 99L, "Jogador 7", LocalDate.now().minusYears(21l), 70,
                new BigDecimal(6000L));
        jogador8 = new Jogador(8L, 99L, "Jogador 8", LocalDate.now().minusYears(21l), 100,
                new BigDecimal(6000L));
        jogador9 = new Jogador(9L, 99L, "Jogador 9", LocalDate.now().minusYears(21l), 70,
                new BigDecimal(6000L));
        jogador10 = new Jogador(10L, 99L, "Jogador 10", LocalDate.now().minusYears(21l), 100,
                new BigDecimal(6000L));
        jogador11 = new Jogador(11L, 99L, "Jogador 11", LocalDate.now().minusYears(21l), 50,
                new BigDecimal(6000L));

        time1.setJogadoresList(new ArrayList<>(Arrays.asList(this.jogador1, this.jogador2)));
        time2.setJogadoresList(new ArrayList<>(Arrays.asList(this.jogador3, this.jogador4)));
        time3.setJogadoresList(new ArrayList<>(Arrays.asList(this.jogador5, this.jogador6)));
        time4.setJogadoresList(new ArrayList<>(Arrays.asList(this.jogador7, this.jogador8, this.jogador9, this.jogador10, this.jogador11)));

        this.classe.getTimes().put(1L, this.time1);
        this.classe.getTimes().put(2L, this.time2);
        this.classe.getTimes().put(3L, this.time3);
        this.classe.getTimes().put(99L, this.time4);

        this.classe.getJogadores().put(1L, this.jogador1);
        this.classe.getJogadores().put(2L, this.jogador2);
        this.classe.getJogadores().put(3L, this.jogador3);
        this.classe.getJogadores().put(4L, this.jogador4);
        this.classe.getJogadores().put(5L, this.jogador5);
        this.classe.getJogadores().put(6L, this.jogador6);

        this.classe.getJogadores().put(7L, this.jogador7);
        this.classe.getJogadores().put(8L, this.jogador8);
        this.classe.getJogadores().put(9L, this.jogador9);
        this.classe.getJogadores().put(10L, this.jogador10);
        this.classe.getJogadores().put(11L, this.jogador11);

        this.classe.getJogadorTimeMap().put(1L, this.time1);
        this.classe.getJogadorTimeMap().put(2L, this.time1);
        this.classe.getJogadorTimeMap().put(3L, this.time2);
        this.classe.getJogadorTimeMap().put(4L, this.time2);
        this.classe.getJogadorTimeMap().put(5L, this.time3);
        this.classe.getJogadorTimeMap().put(6L, this.time3);

        this.classe.getJogadorTimeMap().put(7L, this.time4);
        this.classe.getJogadorTimeMap().put(8L, this.time4);
        this.classe.getJogadorTimeMap().put(9L, this.time4);
        this.classe.getJogadorTimeMap().put(10L, this.time4);
        this.classe.getJogadorTimeMap().put(11L, this.time4);

        time1.setIdCapitao(1L);
    }

    @Test
    public void testIncluirTime() {
        this.classe.incluirTime(4L, "Time 4", LocalDate.now(), "Azul", "Verde");

        assertTrue(this.classe.getTimes().containsKey(4L));
        assertFalse(this.classe.getTimes().containsKey((10L)));
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void testIncluirTimeException() {
        this.classe.incluirTime(1L, "Time 1", LocalDate.now(), "Azul", "Verde");
    }

    @Test
    public void testIncluirJogador() {
        this.classe.incluirJogador(15L, 1L, "Jogador 7", LocalDate.now().minusYears(21l), 90,
                new BigDecimal(1000L));
        assertTrue(this.classe.getJogadores().containsKey(7L));
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void testIncluirJogadorExceptionJogador() {
        this.classe.incluirJogador(1L, 1L, "Jogador 1", LocalDate.now().minusYears(21l), 90,
                new BigDecimal(1000L));
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testIncluirJogadorExceptionTime() {
        this.classe.incluirJogador(15L, 10L, "Jogador 1", LocalDate.now().minusYears(21l), 90,
                new BigDecimal(1000L));
    }

    @Test
    public void testDefinirCapitao() {
        this.classe.definirCapitao(this.jogador1.getId());

        assertEquals(this.jogador1.getId(), this.classe.getTimes().get(this.jogador1.getIdTime()).getId());
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void testDefinirCapitaoException() {
        this.classe.definirCapitao(15L);
    }

    @Test
    public void testBuscarCapitaoDoTime() {
        this.classe.buscarCapitaoDoTime(1L);

        assertEquals(this.classe.getTimes().get(this.jogador1.getId()).getIdCapitao(), this.jogador1.getId());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarCapitaoDoTimeExceptionTime() {
        this.classe.buscarCapitaoDoTime(15L);

    }

    @Test(expected = CapitaoNaoInformadoException.class)
    public void testBuscarCapitaoDoTimeCapitaoException() {
        this.classe.buscarCapitaoDoTime(2L);
    }

    @Test
    public void testBuscarNomeJogador() {
        String nome = this.classe.buscarNomeJogador(1L);

        assertEquals(nome, this.jogador1.getNome());
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void testBuscarNomeJogadorException() {
        this.classe.buscarNomeJogador(15L);
    }

    @Test
    public void testBuscarNomeTime() {
        String nomeTime = this.classe.buscarNomeTime(1L);

        assertEquals(nomeTime, this.time1.getNome());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarNomeTimeException() {
        this.classe.buscarNomeTime(10L);
    }

    @Test
    public void testBuscarJogadoresDoTime() {
        List<Long> idsJogadores = this.classe.buscarJogadoresDoTime(1L);

        assertEquals(idsJogadores, this.time1.getIdsJogadoresList());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarJogadoresDoTimeException() {
        this.classe.buscarJogadoresDoTime(10L);
    }

    @Test
    public void testBuscarMelhorJogadorDoTime() {
        Long idMelhorJogador = this.classe.buscarMelhorJogadorDoTime(3L);

        assertEquals(idMelhorJogador, this.jogador6.getId());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarMelhorJogadorDoTimeException() {
        this.classe.buscarMelhorJogadorDoTime(10L);
    }

    @Test
    public void testBuscarJogadorMaisVelho() {
        Long idJogadorMaisVelho = this.classe.buscarJogadorMaisVelho(3L);

        assertEquals(idJogadorMaisVelho, this.jogador5.getId());

        idJogadorMaisVelho = this.classe.buscarJogadorMaisVelho(2L);

        assertEquals(idJogadorMaisVelho, this.jogador3.getId());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarJogadorMaisVelhoException() {
        this.classe.buscarMelhorJogadorDoTime(10L);
    }

    @Test
    public void testBuscarTimes() {
        List<Long> listaTimes = this.classe.buscarTimes();

        List<Long> array = new ArrayList<>();
        array.add(1L);
        array.add(2L);
        array.add(3L);
        array.add(99L);

        assertEquals(listaTimes, array);

        this.classe.getTimes().clear();
        listaTimes = this.classe.buscarTimes();
        assertTrue(listaTimes.isEmpty());
    }

    @Test
    public void buscarJogadorMaiorSalario() {
        Long idJogadorMaiorSalario = this.classe.buscarJogadorMaiorSalario(2L);
        assertEquals(idJogadorMaiorSalario, this.jogador3.getId());

        idJogadorMaiorSalario = this.classe.buscarJogadorMaiorSalario(3L);
        assertEquals(idJogadorMaiorSalario, this.jogador6.getId());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void buscarJogadorMaiorSalarioException() {
        this.classe.buscarJogadorMaiorSalario(10L);
    }

    @Test
    public void testBuscarSalarioDoJogador() {
        BigDecimal salarioDoJogador = this.classe.buscarSalarioDoJogador(1L);
        assertEquals(salarioDoJogador, this.jogador1.getSalario());
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void testBuscarSalarioDoJogadorException() {
        this.classe.buscarSalarioDoJogador(15L);
    }

    @Test
    public void testBuscarTopJogadores() {
        List<Long> listTopJogadores = this.classe.buscarTopJogadores(5);

        assertEquals(listTopJogadores, Arrays.asList(3L,8L,10L, 1L, 2L));

        listTopJogadores = this.classe.buscarTopJogadores(3);

        assertEquals(listTopJogadores, Arrays.asList(3L, 8L, 10L));

        listTopJogadores = this.classe.buscarTopJogadores(2);
        assertEquals(listTopJogadores, Arrays.asList(3L, 8L));
    }

    @Test
    public void testBuscarCorCamisaTimeDeFora() {

        String camisaTimeFora = this.classe.buscarCorCamisaTimeDeFora(1L, 2L);

        assertEquals(camisaTimeFora, "Verde");

        camisaTimeFora = this.classe.buscarCorCamisaTimeDeFora(1L, 3L);

        assertEquals(camisaTimeFora, "Vermelho");
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarCorCamisaTimeDeForaTimeCasaException() {
        this.classe.buscarCorCamisaTimeDeFora(10L, 1L);

    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void testBuscarCorCamisaTimeDeForaTimeForaException() {
        this.classe.buscarCorCamisaTimeDeFora(1L, 10L);
    }
}
