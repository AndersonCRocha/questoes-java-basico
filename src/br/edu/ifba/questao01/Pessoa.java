package br.edu.ifba.questao01;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

public class Pessoa {
  private String nome; // nome
  private GregorianCalendar dataNascimento; // data de nascimento
  private boolean isCasada; // indicativo da pessoa ser casada ou não

  public Pessoa(String nome, GregorianCalendar dataNascimento, boolean isCasada) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.isCasada = isCasada;
  }

  public String getNome() {
    return nome;
  }

  public GregorianCalendar getDataNascimento() {
    return dataNascimento;
  }

  public boolean isCasada() {
    return isCasada;
  }

  public String toString() {
    return MessageFormat.format(
      "Pessoa [Nome: {0}, Data de Nascimento: {1}, Casado(a): {2}]",
      nome, dataNascimento, isCasada ? "Sim" : "Não"
    );
  }
}