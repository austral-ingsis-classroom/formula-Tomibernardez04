package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

import java.util.ArrayList;
import java.util.List;

public class Multiplication implements Function {

    private final Function a;
    private final Function b;

    public Multiplication(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double evaluate() {
        return a.evaluate() * b.evaluate();
    }

    @Override
    public String toString() {
        String aString = a.toString();
        String bString = b.toString();
        if (a instanceof Addition || a instanceof Subtraction || a instanceof Division) {
            aString = "(" + aString + ")";
        }
        if (b instanceof Addition || b instanceof Subtraction || b instanceof Division) {
            bString = "(" + bString + ")";
        }
        return aString + " * " + bString;
    }

    @Override
    public List<String> getVariables() {
        return mergeList(a.getVariables(), b.getVariables());
    }

    private List<String> mergeList(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }
}
