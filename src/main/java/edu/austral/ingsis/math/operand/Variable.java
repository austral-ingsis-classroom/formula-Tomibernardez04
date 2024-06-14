package edu.austral.ingsis.math.operand;

import edu.austral.ingsis.math.Function;

import java.util.List;

public class Variable implements Function {

    private final String name;
    private final Double value;

    public Variable(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<String> getVariables() {
        return List.of(name);
    }
}
