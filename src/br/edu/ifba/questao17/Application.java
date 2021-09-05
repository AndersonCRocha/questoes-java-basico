package br.edu.ifba.questao17;

import javax.swing.*;

public class Application {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Natal");
    NatalForm form = new NatalForm(frame);
    form.initialize();
    frame.setContentPane(form.getMainPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
