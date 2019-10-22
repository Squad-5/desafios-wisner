package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.domain.Jogador;
import br.com.codenation.domain.Time;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	public Map<Long, Jogador> jogadores = new HashMap<>();
	public Map<Long, Time> times = new HashMap<>();
	public Map<Long, Time> jogadorTimeMap = new HashMap<>();

	public Map<Long, Jogador> getJogadores() {
		return jogadores;
	}

	public Map<Long, Time> getTimes() {
		return times;
	}

	public Map<Long, Time> getJogadorTimeMap() {
		return jogadorTimeMap;
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (this.getTimes().containsKey(id)) throw new IdentificadorUtilizadoException();
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		this.getTimes().put(id, time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (this.getJogadores().containsKey(id)) throw new IdentificadorUtilizadoException();
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		this.getJogadores().put(id, jogador);
		this.getTimes().get(idTime).getJogadoresList().add(jogador);
		this.getJogadorTimeMap().put(id, this.getTimes().get(idTime));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		if (this.getJogadorTimeMap().get(idJogador) == null || !this.getJogadorTimeMap().get(idJogador).getIdsJogadoresList().contains(idJogador) ||
                !this.getJogadores().containsKey(idJogador)) throw new JogadorNaoEncontradoException();
		this.getJogadorTimeMap().get(idJogador).setIdCapitao(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		if (this.getTimes().get(idTime).getIdCapitao() == 0L || this.getTimes().get(idTime).getIdCapitao() == null)
			throw new CapitaoNaoInformadoException();
		return this.getTimes().get(idTime).getIdCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		if (!this.getJogadores().containsKey(idJogador)) throw new JogadorNaoEncontradoException();
		return this.getJogadores().get(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		return this.getTimes().get(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		return this.getTimes().get(idTime).getIdsJogadoresList();
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		return this.getTimes().get(idTime).getMelhorJogadorDoTime();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		return this.getTimes().get(idTime).getJogadorMaisVelho();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return this.getTimes().keySet().stream().sorted().collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!this.getTimes().containsKey(idTime)) throw new TimeNaoEncontradoException();
		return this.getTimes().get(idTime).getJogadorMaiorSalario();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (!this.getJogadores().containsKey(idJogador)) throw new JogadorNaoEncontradoException();
		return this.getJogadores().get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
	    return this.getJogadores().values().stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.limit(top).map(Jogador::getId).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        if (!this.getTimes().containsKey(timeDaCasa)) throw new TimeNaoEncontradoException();
        if (!this.getTimes().containsKey(timeDeFora)) throw new TimeNaoEncontradoException();

        Time timeCasa = this.getTimes().get(timeDaCasa);
        Time timeFora = this.getTimes().get(timeDeFora);

        return timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal()) ?
                    timeFora.getCorUniformeSecundario() : timeFora.getCorUniformePrincipal();
	}

}
