package br.com.codenation.domain;

import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.*;

public class Time {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private List<Jogador> jogadoresList = new ArrayList<>();
    private Long idCapitao;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.idCapitao = 0L;
    }

    public Long getMelhorJogadorDoTime() {
        Integer maiorHabilidade = jogadoresList.stream().map(Jogador::getNivelHabilidade).max(Integer::compare).get();

        Jogador melhorJogador = this.jogadoresList.stream().filter(jogador -> jogador.getNivelHabilidade()
                .equals(maiorHabilidade)).findFirst().get();

        return melhorJogador.getId();
    }

    public Long getJogadorMaisVelho() {
        LocalDate dataNascimento = jogadoresList.stream().map(Jogador::getDataNascimento)
                .min(comparing(LocalDate::getYear)).get();

        Jogador jogadorMaisVelho = this.jogadoresList.stream().filter(jogador -> jogador.getDataNascimento()
                .equals(dataNascimento)).sorted(comparingLong(Jogador::getId)).findFirst().get();

        return jogadorMaisVelho.getId();
    }

    public Long getJogadorMaiorSalario() {
        BigDecimal maiorSalario = jogadoresList.stream().map(Jogador::getSalario)
                .max(naturalOrder()).get();

        Jogador jogadorMaiorSalario = this.jogadoresList.stream().filter(jogador -> jogador.getSalario()
                .equals(maiorSalario)).sorted(comparingLong(Jogador::getId)).findFirst().get();

        return jogadorMaiorSalario.getId();
    }

    public List<Long> getIdsJogadoresList() {
        return jogadoresList.stream().map(Jogador::getId).sorted().collect(Collectors.toList());
    }

    public List<Jogador> getJogadoresList() {
        return jogadoresList;
    }

    public void setJogadoresList(List<Jogador> jogadoresList) {
        this.jogadoresList = jogadoresList;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public void setIdCapitao(Long idCapitao) {
        if (this.jogadoresList.stream().noneMatch(jogador -> jogador.getId().equals(idCapitao))) throw new JogadorNaoEncontradoException();
        this.idCapitao = idCapitao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }
}
