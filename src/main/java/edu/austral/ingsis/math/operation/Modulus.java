package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.List;

public class Modulus implements Function {

  private final Function a;

  public Modulus(Function a) {
    this.a = a;
  }

  @Override
  public double evaluate() {
    double modulus = a.evaluate();
    return modulus > 0 ? modulus : -modulus;
  }

  @Override
  public String toString() {
    return "|" + a.toString() + "|";
  }

  @Override
  public List<String> getVariables() {
    return a.getVariables();
  }
}
