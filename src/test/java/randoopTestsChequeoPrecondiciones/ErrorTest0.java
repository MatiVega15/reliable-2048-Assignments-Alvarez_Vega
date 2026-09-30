package randoopTestsChequeoPrecondiciones;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore ("El propósito de estos tests (detectar falta de validación) ya fue cumplido.")
public class ErrorTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test1");
        ar.edu.unrc.game2048.Board board0 = null;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(board0);
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test2");
        ar.edu.unrc.game2048.Cell cell0 = ar.edu.unrc.game2048.Cell.EMPTY;
        ar.edu.unrc.game2048.Cell cell1 = ar.edu.unrc.game2048.Cell.EMPTY;
        int int2 = cell1.getValue();
        boolean boolean3 = cell0.canMergeWith(cell1);
        ar.edu.unrc.game2048.Cell cell4 = ar.edu.unrc.game2048.Cell.EMPTY;
        ar.edu.unrc.game2048.Cell cell5 = ar.edu.unrc.game2048.Cell.EMPTY;
        int int6 = cell5.getValue();
        boolean boolean7 = cell4.canMergeWith(cell5);
        boolean boolean8 = cell0.canMergeWith(cell5);
        ar.edu.unrc.game2048.Cell cell9 = null;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        ar.edu.unrc.game2048.Cell cell10 = cell5.mergeWith(cell9);
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test3");
        ar.edu.unrc.game2048.TileStrategy tileStrategy1 = null;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        ar.edu.unrc.game2048.Board board2 = new ar.edu.unrc.game2048.Board((int) (byte) 10, tileStrategy1);
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test4");
        ar.edu.unrc.game2048.TileStrategy tileStrategy1 = null;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        ar.edu.unrc.game2048.Board board2 = new ar.edu.unrc.game2048.Board((int) 'a', tileStrategy1);
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test5");
        ar.edu.unrc.game2048.TileStrategy tileStrategy1 = null;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        ar.edu.unrc.game2048.Board board2 = new ar.edu.unrc.game2048.Board(1, tileStrategy1);
    }
}

