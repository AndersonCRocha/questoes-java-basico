package br.edu.ifba.commons;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyboardUtils {

  public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

  public static int readPositiveNumber(String message) {
    boolean hasError = false;
    int value = 0;

    do {
      try {
        value = Integer.parseInt(readText(message));
        if (value <= 0) {
          throw new RuntimeException("Valor inserido inválido");
        }
      } catch (Exception ex) {
        hasError = true;
        showErrorMessage("Valor inserido inválido. Digite apenas números inteiros positivos.");
      }
    } while (hasError);

    return value;
  }

  public static String readText(String message) {
    String text = JOptionPane.showInputDialog(message);

    if ("sair".equalsIgnoreCase(text)) {
      System.exit(0);
    }

    return text;
  }

  public static boolean readBoolean(String message) {
    boolean hasError = false;
    boolean value = false;

    do {
      try {
        String text = readText(message.concat("\nDigite S para Sim e N para Não."));
        if (!"S".equalsIgnoreCase(text) && !"N".equalsIgnoreCase(text)) {
          throw new RuntimeException("Valor inserido inválido");
        }
        value = "S".equalsIgnoreCase(text);
      } catch (Exception ex) {
        hasError = true;
        showErrorMessage("Valor inserido inválido. Digite S para Sim e N para Não.");
      }
    } while (hasError);

    return value;
  }

  public static Date readDate(String message) {
    boolean hasError = false;
    Date value = null;

    do {
      try {
        String text = readText(message.concat("\nFormato válido: 01/01/1111"));
        value = DATE_FORMATTER.parse(text);
      } catch (Exception ex) {
        ex.printStackTrace();
        hasError = true;
        showErrorMessage("Valor inserido inválido. Formato válido: 01/01/1111.");
      }
    } while (hasError);

    return value;
  }

  public static void showMessage(Component component, String message) {
    JOptionPane.showMessageDialog(component, message);
  }

  public static void showMessage(String message) {
    showMessage(null, message);
  }

  public static void showErrorMessage(Component parentComponent, String message) {
    JOptionPane.showMessageDialog(parentComponent, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public static void showErrorMessage(String message) {
    showErrorMessage(null, message);
  }

}
