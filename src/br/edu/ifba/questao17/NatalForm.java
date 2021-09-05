package br.edu.ifba.questao17;

import br.edu.ifba.commons.KeyboardUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class NatalForm {
  private final JFrame frame;
  private JPanel panel1;
  private JTextField dayOfMonthTextField;
  private JButton calculateButton;
  private JComboBox<String> monthComboBox;
  private JTextField resultTextField;
  private JPanel mainPanel;

  public NatalForm(JFrame frame) {
    this.frame = frame;
  }

  public JPanel getMainPanel() {
    return mainPanel;
  }

  public void initialize() {
    calculateButton.addActionListener(this::calculate);
  }

  private void calculate(ActionEvent event) {
    int dayOfMonth = this.getDayOfMonth();
    if (dayOfMonth == 0) return;

    int month = this.monthComboBox.getSelectedIndex() + 1;
    int currentYear = LocalDate.now().getYear();

    LocalDate selectedDate = LocalDate.of(currentYear, month, dayOfMonth);
    LocalDate christmasDate = LocalDate.of(currentYear, Month.DECEMBER.getValue(), 25);

    if (selectedDate.isAfter(christmasDate)) {
      this.resultTextField.setText("O Natal de %d já passou!".formatted(currentYear));
      this.resetFields();
      return;
    }

    if (selectedDate.isEqual(christmasDate)) {
      this.resultTextField.setText("É Natal de %d!".formatted(currentYear));
      this.resetFields();
      return;
    }

    if (selectedDate.isEqual(christmasDate)) {
      this.resultTextField.setText("É Natal de %d!".formatted(currentYear));
      this.resetFields();
      return;
    }

    LocalDate christmasEveDate = LocalDate.of(currentYear, Month.DECEMBER.getValue(), 24);
    if (selectedDate.isEqual(christmasEveDate)) {
      this.resultTextField.setText("É véspera de Natal de %d!".formatted(currentYear));
      this.resetFields();
      return;
    }

    long daysLeft = ChronoUnit.DAYS.between(selectedDate, christmasDate);
    this.resultTextField.setText("Faltam %s dias para o Natal de %s".formatted(daysLeft, currentYear));
    this.resetFields();
  }

  private void resetFields() {
    this.dayOfMonthTextField.setText("");
    this.monthComboBox.setSelectedIndex(0);
  }

  private int getDayOfMonth() {
    try {
      int dayOfMonth = Integer.parseInt(dayOfMonthTextField.getText());
      String month = this.getMonth();

      return switch (month) {
        case "Janeiro":
        case "Março":
        case "Maio":
        case "Julho":
        case "Agosto":
        case "Outubro":
        case "Dezembro":
          if (dayOfMonth > 0 && dayOfMonth <= 31) {
            yield dayOfMonth;
          }
        case "Abril":
        case "Junho":
        case "Setembro":
        case "Novembro":
          if (dayOfMonth > 0 && dayOfMonth <= 30) {
            yield dayOfMonth;
          }
        case "Fevereiro":
          boolean isLeapYear = LocalDate.now().isLeapYear();
          if (dayOfMonth > 0 && ((isLeapYear && dayOfMonth <= 29) || dayOfMonth <= 28)) {
            yield dayOfMonth;
          }
        default:
          throw new RuntimeException("Dia do mês inválido.");
      };
    } catch (Exception ex) {
      this.dayOfMonthTextField.setText("");
      this.resultTextField.setText("");
      KeyboardUtils.showErrorMessage(frame, "Dia do mês inválido.");
    }
    return 0;
  }

  private String getMonth() {
    return Objects.requireNonNull(monthComboBox.getSelectedItem()).toString();
  }

}
