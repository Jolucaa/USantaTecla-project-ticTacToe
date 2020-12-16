package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Token;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SessionTest {

    @Test
    void testGivenTwoUsersSessionWithOneActionWhenUndoThenActionIsUndone() {
        Session session = new SessionBuilder().users(2).rows("X  ",
                "   ",
                "   ").build();
        session.undo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.NULL));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenOneUserSessionWithOneActionWhenUndoThenActionIsUndone() {
        Session session = new SessionBuilder().users(1).rows("X  ",
                "O  ",
                "   ").build();
        session.undo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.NULL));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenTwoUsersSessionWithOneActionWhenUndoAndRedoThenActionIsUndoneAndRedone() {
        Session session = new SessionBuilder().users(2).rows("X  ",
                "   ",
                "   ").build();
        session.undo();
        session.redo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.X));
        assertThat(session.getToken(), is(Token.O));
    }

    @Test
    void testGivenOneUserSessionWithOneActionWhenUndoAndRedoThenActionIsUndoneAndRedone() {
        Session session = new SessionBuilder().users(1).rows("X  ",
                "O  ",
                "   ").build();
        session.undo();
        session.redo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.X));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.O));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenTwoUsersSessionWithThreeActionWhenUndoThreeTimesThenActionsAreUndone() {
        Session session = new SessionBuilder().users(2).rows("XX ",
                "O  ",
                "   ").build();
        session.undo();
        session.undo();
        session.undo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(0, 1)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.NULL));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenOneUserSessionWithThreeActionWhenUndoThreeTimesThenActionsAreUndone() {
        Session session = new SessionBuilder().users(1).rows("XX ",
                "OO ",
                "XO ").build();
        session.undo();
        session.undo();
        session.undo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(2, 0)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(0, 1)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(1, 1)), is(Token.NULL));
        assertThat(session.getToken(new Coordinate(2, 1)), is(Token.NULL));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenTwoUsersSessionWithThreeActionWhenUndoAndRedoThreeTimesThenActionsAreUndoneAndRedone() {
        Session session = new SessionBuilder().users(2).rows("XX ",
                "O  ",
                "   ").build();
        session.undo();
        session.undo();
        session.undo();
        session.redo();
        session.redo();
        session.redo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.X));
        assertThat(session.getToken(new Coordinate(0, 1)), is(Token.X));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.O));
        assertThat(session.getToken(), is(Token.O));
    }

    @Test
    void testGivenOneUserSessionWithThreeActionWhenUndoAndRedoThreeTimesThenActionsAreUndoneAndRedone() {
        Session session = new SessionBuilder().users(1).rows("XX ",
                "OO ",
                "XO ").build();
        session.undo();
        session.undo();
        session.undo();
        session.redo();
        session.redo();
        session.redo();
        assertThat(session.getToken(new Coordinate(0, 0)), is(Token.X));
        assertThat(session.getToken(new Coordinate(1, 0)), is(Token.O));
        assertThat(session.getToken(new Coordinate(2, 0)), is(Token.X));
        assertThat(session.getToken(new Coordinate(0, 1)), is(Token.X));
        assertThat(session.getToken(new Coordinate(1, 1)), is(Token.O));
        assertThat(session.getToken(new Coordinate(2, 1)), is(Token.O));
        assertThat(session.getToken(), is(Token.X));
    }

    @Test
    void testGivenSessionWithOneActionWhenUndoActionAndDoOtherActionThenSessionIsNotRedoable() {
        Session session = new SessionBuilder().users(2).rows("X  ",
                "   ",
                "   ").build();
        session.undo();
        session.put(new Coordinate(1,1));
        assertThat(session.redoable(), is(false));
    }

}
