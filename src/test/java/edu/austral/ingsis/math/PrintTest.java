package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operand.Constant;
import edu.austral.ingsis.math.operand.Variable;
import edu.austral.ingsis.math.operation.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final String result =
            new Addition(
                    new Constant(1.0),
                    new Constant(6.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final String result =
            new Division(
                    new Constant(12.0),
                    new Constant(2.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final String result =
            new Multiplication(
                    new Division(
                            new Constant(9.0),
                            new Constant(2.0)),
                    new Constant(3.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final String result =
            new Exponentiation(
                    new Division(
                            new Constant(27.0),
                            new Constant(6.0)),
                    new Constant(2.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result =
            new Subtraction(
                    new Modulus(
                            new Variable("value", 0.0)),
                    new Constant(8.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result =
            new Subtraction(
                    new Modulus(
                            new Variable("value", 0.0)),
                    new Constant(8.0)).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result =
            new Multiplication(
                    new Subtraction(
                            new Constant(5.0),
                            new Variable("i", 0.0)),
                    new Constant(8.0)).toString();

    assertThat(result, equalTo(expected));
  }
}
