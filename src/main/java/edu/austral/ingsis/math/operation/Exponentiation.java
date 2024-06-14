package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class Exponentiation implements Function {

  private final Function base;
  private final Function exponent;

  public Exponentiation(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  @Override
  public double evaluate() {
    return Math.pow(base.evaluate(), exponent.evaluate());
  }

  @Override
  public String toString() {

    String baseString = base.toString();
    String exponentString = exponent.toString();
    if (base instanceof Addition || base instanceof Subtraction || base instanceof Division) {
      baseString = "(" + baseString + ")";
    }
    if (exponent instanceof Addition
        || exponent instanceof Subtraction
        || exponent instanceof Division) {
      exponentString = "(" + exponentString + ")";
    }
    return baseString + " ^ " + exponentString;
  }

  @Override
  public List<String> getVariables() {
    return mergeList(base.getVariables(), exponent.getVariables());
  }

  private List<String> mergeList(List<String> a, List<String> b) {
    List<String> result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }
}
