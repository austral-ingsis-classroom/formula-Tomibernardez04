package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class SquareRoot implements Function {

  private final Function radicand;
  private final Function index;

  public SquareRoot(Function radicand, Function index) {
    this.radicand = radicand;
    this.index = index;
  }

  @Override
  public double evaluate() {
    return Math.pow(radicand.evaluate(), 1 / index.evaluate());
  }

  @Override
  public String toString() {
    return "(" + (radicand).toString() + ")" + " ^ (1/" + (index).toString() + ")";
  }

  @Override
  public List<String> getVariables() {
    return mergeList(radicand.getVariables(), index.getVariables());
  }

  private List<String> mergeList(List<String> a, List<String> b) {
    List<String> result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }
}
