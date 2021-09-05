package br.edu.ifba.questao13;

import br.edu.ifba.commons.KeyboardUtils;

public class Application {

  public static void main(String[] args) {
    int purchased = KeyboardUtils.readPositiveNumber("Quantos refrigerantes foram comprados?");
    int neededForPromotion = KeyboardUtils.readPositiveNumber("Quantos frascos são necessários para a promoção?");

    int wonInPromotion = purchased / neededForPromotion;
    int amountLeft = purchased % neededForPromotion;
    int total = wonInPromotion + amountLeft;

    KeyboardUtils.showMessage("""
      Ao final do segundo dia de promoção você terá ganho um total de %d garrafas.
      Sobrou %d garrafas
      Ficou com total de %d garrafas
      """.formatted(wonInPromotion, amountLeft, total)
    );
  }

}
