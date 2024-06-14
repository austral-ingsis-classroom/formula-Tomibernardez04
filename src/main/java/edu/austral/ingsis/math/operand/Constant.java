package edu.austral.ingsis.math.operand;

import edu.austral.ingsis.math.Function;

import java.util.List;

public class Constant implements Function {

    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf((int) value);
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }
}
