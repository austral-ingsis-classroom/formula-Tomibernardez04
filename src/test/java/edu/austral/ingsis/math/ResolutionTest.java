package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operand.Constant;
import edu.austral.ingsis.math.operation.*;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = new Addition(new Constant(1.0), new Constant(6.0)).evaluate();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = new Division(new Constant(12.0), new Constant(2.0)).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result =
        new Multiplication(new Division(new Constant(9.0), new Constant(2.0)), new Constant(3.0))
            .evaluate();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result =
        new Exponentiation(new Division(new Constant(27.0), new Constant(6.0)), new Constant(2.0))
            .evaluate();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result =
        new Exponentiation(new Constant(36.0), new Division(new Constant(1.0), new Constant(2.0)))
            .evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = new Modulus(new Constant(136.0)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = new Modulus(new Constant(-136.0)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result =
        new Multiplication(new Subtraction(new Constant(5.0), new Constant(5.0)), new Constant(8.0))
            .evaluate();

    assertThat(result, equalTo(0d));
  }
}
