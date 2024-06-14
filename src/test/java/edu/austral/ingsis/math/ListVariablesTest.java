package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operand.Constant;
import edu.austral.ingsis.math.operand.Variable;
import edu.austral.ingsis.math.operation.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = new Addition(new Constant(1.0), new Constant(6.0)).getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result =
        new Division(new Constant(12.0), new Variable("div", 4.0)).getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result =
        new Multiplication(
                new Division(new Constant(9.0), new Variable("x", 3.0)), new Variable("y", 4.0))
            .getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result =
        new Exponentiation(
                new Division(new Constant(27.0), new Variable("a", 9.0)), new Variable("b", 3.0))
            .getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result =
        new Exponentiation(
                new Variable("z", 36.0), new Division(new Constant(1.0), new Constant(2.0)))
            .getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result =
        new Subtraction(new Modulus(new Variable("value", 8.0)), new Constant(8.0)).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result =
        new Subtraction(new Modulus(new Variable("value", 8.0)), new Constant(8.0)).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result =
        new Multiplication(
                new Subtraction(new Constant(5.0), new Variable("i", 2.0)), new Constant(8.0))
            .getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
