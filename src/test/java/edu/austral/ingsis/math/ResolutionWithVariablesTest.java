package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operand.Constant;
import edu.austral.ingsis.math.operand.Variable;
import edu.austral.ingsis.math.operation.*;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = new Addition(new Constant(1.0), new Variable("x", 3.0)).evaluate();

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = new Division(new Constant(12.0), new Variable("div", 4.0)).evaluate();

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new Multiplication(
                new Division(new Constant(9.0), new Variable("x", 3.0)), new Variable("y", 4.0))
            .evaluate();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new Exponentiation(
                new Division(new Constant(27.0), new Variable("a", 9.0)), new Variable("b", 3.0))
            .evaluate();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result =
        new Exponentiation(
                new Variable("z", 36.0), new Division(new Constant(1.0), new Constant(2.0)))
            .evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result =
        new Subtraction(new Modulus(new Variable("value", 8.0)), new Constant(8.0)).evaluate();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result =
        new Subtraction(new Modulus(new Variable("value", 8.0)), new Constant(8.0)).evaluate();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new Multiplication(
                new Subtraction(new Constant(5.0), new Variable("i", 2.0)), new Constant(8.0))
            .evaluate();

    assertThat(result, equalTo(24d));
  }
}
