package br.edu.ifba.questao01;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class PessoaRepository {

  private static final List<Pessoa> people = new ArrayList<>();

  public void save(String name, Date birthDate, boolean isMarried) {
    GregorianCalendar gregorianBirthDate = (GregorianCalendar) GregorianCalendar.getInstance();
    gregorianBirthDate.setTime(birthDate);
    Pessoa person = new Pessoa(name, gregorianBirthDate, isMarried);
    people.add(person);
  }

  public long getNumberOfMarriedPeople() {
    return people.stream()
      .filter(Pessoa::isCasada)
      .count();
  }

  public Pessoa getOlderPerson() {
    if (people.size() == 1) {
      return people.get(0);
    }

    return people.stream()
      .reduce(null,
        (personOne, personTwo) -> {
          if (Objects.isNull(personOne)) {
            return personTwo;
          }

          return personOne.getDataNascimento().after(personTwo.getDataNascimento())
            ? personTwo
            : personOne;
        }
      );
  }

}
