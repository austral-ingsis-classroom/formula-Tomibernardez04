package edu.austral.ingsis.math;

import java.util.List;

public interface Function {
  double evaluate();

  String toString();

  List<String> getVariables();
}
