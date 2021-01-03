package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
// import static org.mockito.ArgumentMatchers.anyInt;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class SquaredBoundedCoordinateTest {

  private SquaredBoundedCoordinate coordinate;

  @BeforeEach
  public void beforeEach() {
    this.coordinate = this.getCoordinate(1, 1);
  }

  protected abstract SquaredBoundedCoordinate getCoordinate(int row, int column);
 
  @Test
  public void testGivenCoordinateWhenIsNullThenValues() {
    assertThat(this.coordinate.isNull(), is(false));
    assertThat(this.getNullCoordinate().isNull(), is(true));
  }

  protected abstract SquaredBoundedCoordinate getNullCoordinate();
 
  @Test
  public void testGivenCoordinateWhenNewThenValues() {
    assertThat(this.coordinate.getRow(), is(1));
    assertThat(this.coordinate.getColumn(), is(1));
  }

  @Test
  public void testGivenCoordinateWhenLessWrongNewThenException() {
    Assertions.assertThrows(AssertionError.class, () -> this.getCoordinate(-1, -1));
  }

  @Test
  public void testGivenCoordinateWhenGreaterWrongNewThenException() {
    Assertions.assertThrows(AssertionError.class, () -> this.getCoordinate(4, 4));
  }

  @Test
  public void testGivenCoordinateWhenGetDirectionThenValues() {
    assertThat(this.coordinate.getDirection(this.getCoordinate(0,0)), is(Direction.MAIN_DIAGONAL));
    assertThat(this.coordinate.getDirection(this.getCoordinate(0,1)), is(Direction.VERTICAL));
    assertThat(this.coordinate.getDirection(this.getCoordinate(0,2)), is(Direction.INVERSE_DIAGONAL));
    assertThat(this.coordinate.getDirection(this.getCoordinate(1,0)), is(Direction.HORIZONTAL));
    assertThat(this.coordinate.getDirection(this.coordinate), is(Direction.NULL));
    assertThat(this.coordinate.getDirection(this.getNullCoordinate()), is(Direction.NULL));
    assertThat(this.getNullCoordinate().getDirection(this.getNullCoordinate()), is(Direction.NULL));
    assertThat(this.getNullCoordinate().getDirection(this.coordinate), is(Direction.NULL));
  }

  // @Test
  // public void testGivenCoordinateWhenReadThenValues(){
  //   int row = 1;
  //   int column = 3;
  //   Console console = mock(Console.class);
  //   when(console.readInt("")).thenReturn(0, row, 4, column);
  //   SquaredBoundedCoordinate coordinate = this.getNullCoordinate();
  //   coordinate.read("TITLE");
  //   assertThat(coordinate.getRow(), is(row - 1));
  //   assertThat(coordinate.getColumn(), is(column - 1));
  // }

  // @Test
  // public void testGivenCoordinateWhenRandomThenValues(){
  //   int row = 2;
  //   int column = 0;
  //   Random random = mock(Random.class);
  //   when(random.nextInt(anyInt())).thenReturn(row, column);
  //   SquaredBoundedCoordinate coordinate = this.getNullCoordinate();
  //   coordinate.random();
  //   assertThat(coordinate.getRow(), is(row));
  //   assertThat(coordinate.getColumn(), is(column));
  // }

}
