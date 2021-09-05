package br.edu.ifba.questao01;

import br.edu.ifba.commons.KeyboardUtils;

import java.util.Date;
import java.util.Objects;

public class Application {

  private static final PessoaRepository repository = new PessoaRepository();

  public static void main(String[] args) {
    showMenu();
  }

  private static void showMenu() {
    do {
      int chosenOption = KeyboardUtils.readPositiveNumber("""
        O que deseja fazer? (Digite o número referente a opção escolhida)
        1 - Incluir nova pessoa
        2 - Consultar quantidade de pessoas casadas cadastradas
        3 - Exibir dados da pessoa mais velha
        
        Digite "sair" a qualquer momento para encerrar o programa.
        """);

      switch (chosenOption) {
        case 1 -> addPerson();
        case 2 -> showNumberOfMarriedPeople();
        case 3 -> showOlderPersonData();
        default -> KeyboardUtils.showErrorMessage("Opção inválida!");
      }
    } while(true);
  }

  private static void addPerson() {
    String name = KeyboardUtils.readText("Nome da pessoa:");
    Date birthDate = KeyboardUtils.readDate("Data de nascimento:");
    boolean isMarried = KeyboardUtils.readBoolean("É casada?");
    repository.save(name, birthDate, isMarried);
  }

  private static void showNumberOfMarriedPeople() {
    final long numberOfMarriedPeople = repository.getNumberOfMarriedPeople();
    KeyboardUtils.showMessage("Quantidade de pessoas casadas cadastradas: %d".formatted(numberOfMarriedPeople));
  }

  private static void showOlderPersonData() {
    Pessoa olderPerson = repository.getOlderPerson();

    if (Objects.isNull(olderPerson)) {
      KeyboardUtils.showErrorMessage("Nenhuma pessoa cadastrada.");
      return;
    }

    KeyboardUtils.showMessage("""
      Pessoa mais velha cadastrada:
      Nome: %s
      Data de nascimento: %s
      É casada: %s
      """.formatted(
        olderPerson.getNome(), KeyboardUtils.DATE_FORMATTER.format(olderPerson.getDataNascimento().getTime()),
        olderPerson.isCasada() ? "Sim" : "Não"
      )
    );
  }

}
