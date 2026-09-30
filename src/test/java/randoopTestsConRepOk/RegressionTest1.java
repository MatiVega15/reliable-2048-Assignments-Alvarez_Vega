package randoopTestsConRepOk;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

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
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test501");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.isWinningBoard();
        boolean boolean35 = board33.moveUp();
        ar.edu.unrc.game2048.Board board36 = new ar.edu.unrc.game2048.Board(board33);
        boolean boolean37 = board36.repOk();
        boolean boolean38 = board36.moveLeft();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test502");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (byte) 1);
        ar.edu.unrc.game2048.Cell cell3 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str4 = cell3.toString();
        boolean boolean6 = cell3.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell8 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str9 = cell8.toString();
        boolean boolean11 = cell8.equals((java.lang.Object) 100L);
        boolean boolean12 = cell3.canMergeWith(cell8);
        ar.edu.unrc.game2048.Cell cell14 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean15 = cell8.canMergeWith(cell14);
        ar.edu.unrc.game2048.Cell cell17 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean18 = cell17.isEmpty();
        ar.edu.unrc.game2048.Cell cell20 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str21 = cell20.toString();
        boolean boolean23 = cell20.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell25 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str26 = cell25.toString();
        boolean boolean28 = cell25.equals((java.lang.Object) 100L);
        boolean boolean29 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Cell cell31 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean32 = cell25.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell33 = cell17.mergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell35 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean36 = cell35.isEmpty();
        ar.edu.unrc.game2048.Cell cell38 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str39 = cell38.toString();
        boolean boolean41 = cell38.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell43 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str44 = cell43.toString();
        boolean boolean46 = cell43.equals((java.lang.Object) 100L);
        boolean boolean47 = cell38.canMergeWith(cell43);
        ar.edu.unrc.game2048.Cell cell49 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean50 = cell43.canMergeWith(cell49);
        ar.edu.unrc.game2048.Cell cell51 = cell35.mergeWith(cell49);
        boolean boolean52 = cell31.canMergeWith(cell35);
        int int53 = cell31.getValue();
        boolean boolean54 = cell14.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell55 = cell1.mergeWith(cell14);
        int int56 = cell14.getValue();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1" + "'", str4, "1");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1" + "'", str9, "1");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "1" + "'", str21, "1");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "1" + "'", str26, "1");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertNotNull(cell33);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "1" + "'", str39, "1");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertEquals("'" + str44 + "' != '" + "1" + "'", str44, "1");
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertNotNull(cell51);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + 1 + "'", int53 == 1);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertNotNull(cell55);
        org.junit.Assert.assertTrue("'" + int56 + "' != '" + 1 + "'", int56 == 1);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test503");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str2 = cell1.toString();
        boolean boolean4 = cell1.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell6 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str7 = cell6.toString();
        boolean boolean9 = cell6.equals((java.lang.Object) 100L);
        boolean boolean10 = cell1.canMergeWith(cell6);
        ar.edu.unrc.game2048.Cell cell12 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str13 = cell12.toString();
        boolean boolean15 = cell12.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell17 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str18 = cell17.toString();
        boolean boolean20 = cell17.equals((java.lang.Object) 100L);
        boolean boolean21 = cell12.canMergeWith(cell17);
        ar.edu.unrc.game2048.Cell cell23 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean24 = cell17.canMergeWith(cell23);
        ar.edu.unrc.game2048.Cell cell25 = cell6.mergeWith(cell23);
        java.lang.String str26 = cell25.toString();
        java.lang.Object obj27 = null;
        boolean boolean28 = cell25.equals(obj27);
        java.lang.Class<?> wildcardClass29 = cell25.getClass();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "1" + "'", str7, "1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "1" + "'", str13, "1");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "1" + "'", str18, "1");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "2" + "'", str26, "2");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(wildcardClass29);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test504");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str2 = cell1.toString();
        boolean boolean4 = cell1.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell6 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str7 = cell6.toString();
        boolean boolean9 = cell6.equals((java.lang.Object) 100L);
        boolean boolean10 = cell1.canMergeWith(cell6);
        ar.edu.unrc.game2048.Cell cell12 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean13 = cell6.canMergeWith(cell12);
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy15 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int16 = deterministicTileStrategy15.determinarValor();
        ar.edu.unrc.game2048.Board.Position position19 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean21 = position19.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean26 = position24.equals((java.lang.Object) true);
        int int27 = position24.col;
        ar.edu.unrc.game2048.Board.Position position30 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str31 = position30.toString();
        java.lang.String str32 = position30.toString();
        ar.edu.unrc.game2048.Board.Position position35 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position38 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str39 = position38.toString();
        ar.edu.unrc.game2048.Board.Position position42 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray43 = new ar.edu.unrc.game2048.Board.Position[] { position19, position24, position30, position35, position38, position42 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet44 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet44, positionArray43);
        ar.edu.unrc.game2048.Board.Position position46 = deterministicTileStrategy15.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet44);
        ar.edu.unrc.game2048.Board board47 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy15);
        boolean boolean48 = board47.moveDown();
        int int49 = board47.getScore();
        boolean boolean50 = board47.moveDown();
        int int51 = board47.getScore();
        boolean boolean52 = board47.isLosingBoard();
        boolean boolean53 = board47.isFull();
        boolean boolean54 = board47.moveDown();
        ar.edu.unrc.game2048.Cell cell58 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str59 = cell58.toString();
        boolean boolean61 = cell58.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell63 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str64 = cell63.toString();
        boolean boolean66 = cell63.equals((java.lang.Object) 100L);
        boolean boolean67 = cell58.canMergeWith(cell63);
        ar.edu.unrc.game2048.Cell cell69 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str70 = cell69.toString();
        boolean boolean72 = cell69.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell74 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str75 = cell74.toString();
        boolean boolean77 = cell74.equals((java.lang.Object) 100L);
        boolean boolean78 = cell69.canMergeWith(cell74);
        ar.edu.unrc.game2048.Cell cell80 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean81 = cell74.canMergeWith(cell80);
        ar.edu.unrc.game2048.Cell cell82 = cell63.mergeWith(cell80);
        board47.setCell((int) (short) 10, 10, cell80);
        boolean boolean84 = cell12.canMergeWith(cell80);
        java.lang.String str85 = cell12.toString();
        ar.edu.unrc.game2048.Cell cell86 = null;
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell87 = cell12.mergeWith(cell86);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot read field \"value\" because \"other\" is null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "1" + "'", str7, "1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 2 + "'", int16 == 2);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 97 + "'", int27 == 97);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "(-1, 100)" + "'", str31, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "(-1, 100)" + "'", str32, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "(97, 97)" + "'", str39, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray43);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        org.junit.Assert.assertNotNull(position46);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + 4 + "'", int51 == 4);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertEquals("'" + str59 + "' != '" + "1" + "'", str59, "1");
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertEquals("'" + str64 + "' != '" + "1" + "'", str64, "1");
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + true + "'", boolean67 == true);
        org.junit.Assert.assertEquals("'" + str70 + "' != '" + "1" + "'", str70, "1");
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertEquals("'" + str75 + "' != '" + "1" + "'", str75, "1");
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + true + "'", boolean78 == true);
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + true + "'", boolean81 == true);
        org.junit.Assert.assertNotNull(cell82);
        org.junit.Assert.assertTrue("'" + boolean84 + "' != '" + true + "'", boolean84 == true);
        org.junit.Assert.assertEquals("'" + str85 + "' != '" + "1" + "'", str85, "1");
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test505");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy3 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int4 = deterministicTileStrategy3.determinarValor();
        ar.edu.unrc.game2048.Board.Position position7 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean9 = position7.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position12 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean14 = position12.equals((java.lang.Object) true);
        int int15 = position12.col;
        ar.edu.unrc.game2048.Board.Position position18 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str19 = position18.toString();
        java.lang.String str20 = position18.toString();
        ar.edu.unrc.game2048.Board.Position position23 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position26 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str27 = position26.toString();
        ar.edu.unrc.game2048.Board.Position position30 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray31 = new ar.edu.unrc.game2048.Board.Position[] { position7, position12, position18, position23, position26, position30 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet32 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet32, positionArray31);
        ar.edu.unrc.game2048.Board.Position position34 = deterministicTileStrategy3.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy3);
        boolean boolean36 = board35.moveDown();
        int int37 = board35.getScore();
        boolean boolean38 = board35.moveDown();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet39 = board35.getEmptyPositions();
        ar.edu.unrc.game2048.Board.Position position40 = deterministicTileStrategy1.determinarPosicion(positionSet39);
        ar.edu.unrc.game2048.Board board41 = new ar.edu.unrc.game2048.Board(100, (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean42 = board41.moveDown();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet43 = board41.getEmptyPositions();
        int int44 = board41.getSize();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 2 + "'", int4 == 2);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 97 + "'", int15 == 97);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "(-1, 100)" + "'", str19, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "(-1, 100)" + "'", str20, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "(97, 97)" + "'", str27, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray31);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertNotNull(position34);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 0 + "'", int37 == 0);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertNotNull(positionSet39);
        org.junit.Assert.assertNotNull(position40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertNotNull(positionSet43);
        org.junit.Assert.assertTrue("'" + int44 + "' != '" + 100 + "'", int44 == 100);
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test506");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) ' ', (int) (byte) 100);
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test507");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str2 = cell1.toString();
        boolean boolean4 = cell1.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell6 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str7 = cell6.toString();
        boolean boolean9 = cell6.equals((java.lang.Object) 100L);
        boolean boolean10 = cell1.canMergeWith(cell6);
        java.lang.Object obj11 = null;
        boolean boolean12 = cell1.equals(obj11);
        ar.edu.unrc.game2048.Cell cell14 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str15 = cell14.toString();
        boolean boolean17 = cell14.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell19 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str20 = cell19.toString();
        boolean boolean22 = cell19.equals((java.lang.Object) 100L);
        boolean boolean23 = cell14.canMergeWith(cell19);
        ar.edu.unrc.game2048.Cell cell25 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str26 = cell25.toString();
        boolean boolean28 = cell25.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell30 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str31 = cell30.toString();
        boolean boolean33 = cell30.equals((java.lang.Object) 100L);
        boolean boolean34 = cell25.canMergeWith(cell30);
        ar.edu.unrc.game2048.Cell cell36 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean37 = cell30.canMergeWith(cell36);
        ar.edu.unrc.game2048.Cell cell38 = cell19.mergeWith(cell36);
        ar.edu.unrc.game2048.Cell cell40 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str41 = cell40.toString();
        boolean boolean43 = cell40.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell45 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str46 = cell45.toString();
        boolean boolean48 = cell45.equals((java.lang.Object) 100L);
        boolean boolean49 = cell40.canMergeWith(cell45);
        ar.edu.unrc.game2048.Cell cell50 = cell19.mergeWith(cell40);
        boolean boolean51 = cell19.repOk();
        boolean boolean52 = cell1.equals((java.lang.Object) cell19);
        java.lang.Class<?> wildcardClass53 = cell19.getClass();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "1" + "'", str7, "1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "1" + "'", str15, "1");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "1" + "'", str20, "1");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "1" + "'", str26, "1");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "1" + "'", str31, "1");
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertNotNull(cell38);
        org.junit.Assert.assertEquals("'" + str41 + "' != '" + "1" + "'", str41, "1");
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "1" + "'", str46, "1");
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertNotNull(cell50);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + true + "'", boolean51 == true);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertNotNull(wildcardClass53);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test508");
        ar.edu.unrc.game2048.Board.Position position3 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean5 = position3.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy7 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int8 = deterministicTileStrategy7.determinarValor();
        ar.edu.unrc.game2048.Board.Position position11 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean13 = position11.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean18 = position16.equals((java.lang.Object) true);
        int int19 = position16.col;
        ar.edu.unrc.game2048.Board.Position position22 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str23 = position22.toString();
        java.lang.String str24 = position22.toString();
        ar.edu.unrc.game2048.Board.Position position27 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position30 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str31 = position30.toString();
        ar.edu.unrc.game2048.Board.Position position34 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray35 = new ar.edu.unrc.game2048.Board.Position[] { position11, position16, position22, position27, position30, position34 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet36 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet36, positionArray35);
        ar.edu.unrc.game2048.Board.Position position38 = deterministicTileStrategy7.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet36);
        int int39 = deterministicTileStrategy7.determinarValor();
        ar.edu.unrc.game2048.Board board40 = new ar.edu.unrc.game2048.Board(10, (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy7);
        boolean boolean41 = position3.equals((java.lang.Object) deterministicTileStrategy7);
        ar.edu.unrc.game2048.Board board42 = new ar.edu.unrc.game2048.Board(100, (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy7);
        int int43 = deterministicTileStrategy7.determinarValor();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 2 + "'", int8 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 97 + "'", int19 == 97);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "(-1, 100)" + "'", str23, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "(-1, 100)" + "'", str24, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "(97, 97)" + "'", str31, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray35);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertNotNull(position38);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 2 + "'", int39 == 2);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 2 + "'", int43 == 2);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test509");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        int int33 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board board34 = new ar.edu.unrc.game2048.Board(10, (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean35 = board34.moveLeft();
        boolean boolean36 = board34.hasEmptyCells();
        boolean boolean37 = board34.moveUp();
        ar.edu.unrc.game2048.Board.Position position40 = new ar.edu.unrc.game2048.Board.Position(2048, (int) (byte) 1);
        boolean boolean41 = board34.equals((java.lang.Object) (byte) 1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 2 + "'", int33 == 2);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test510");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.moveDown();
        boolean boolean37 = board33.moveDown();
        ar.edu.unrc.game2048.Board board38 = new ar.edu.unrc.game2048.Board(board33);
        boolean boolean39 = board33.isWinningBoard();
        boolean boolean40 = board33.isFull();
        boolean boolean41 = board33.isLosingBoard();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test511");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean2 = cell1.isEmpty();
        boolean boolean3 = cell1.repOk();
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy5 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int6 = deterministicTileStrategy5.determinarValor();
        ar.edu.unrc.game2048.Board.Position position9 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean11 = position9.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position14 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean16 = position14.equals((java.lang.Object) true);
        int int17 = position14.col;
        ar.edu.unrc.game2048.Board.Position position20 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str21 = position20.toString();
        java.lang.String str22 = position20.toString();
        ar.edu.unrc.game2048.Board.Position position25 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str29 = position28.toString();
        ar.edu.unrc.game2048.Board.Position position32 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray33 = new ar.edu.unrc.game2048.Board.Position[] { position9, position14, position20, position25, position28, position32 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet34 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet34, positionArray33);
        ar.edu.unrc.game2048.Board.Position position36 = deterministicTileStrategy5.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet34);
        ar.edu.unrc.game2048.Board board37 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy5);
        boolean boolean38 = board37.moveDown();
        int int39 = board37.getScore();
        boolean boolean40 = board37.moveDown();
        int int41 = board37.getScore();
        boolean boolean42 = board37.isLosingBoard();
        boolean boolean43 = board37.isFull();
        boolean boolean44 = board37.moveDown();
        ar.edu.unrc.game2048.Cell cell48 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str49 = cell48.toString();
        boolean boolean51 = cell48.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell53 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str54 = cell53.toString();
        boolean boolean56 = cell53.equals((java.lang.Object) 100L);
        boolean boolean57 = cell48.canMergeWith(cell53);
        ar.edu.unrc.game2048.Cell cell59 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str60 = cell59.toString();
        boolean boolean62 = cell59.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell64 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str65 = cell64.toString();
        boolean boolean67 = cell64.equals((java.lang.Object) 100L);
        boolean boolean68 = cell59.canMergeWith(cell64);
        ar.edu.unrc.game2048.Cell cell70 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean71 = cell64.canMergeWith(cell70);
        ar.edu.unrc.game2048.Cell cell72 = cell53.mergeWith(cell70);
        board37.setCell((int) (short) 10, 10, cell70);
        boolean boolean74 = cell1.equals((java.lang.Object) (short) 10);
        int int75 = cell1.getValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 2 + "'", int6 == 2);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 97 + "'", int17 == 97);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "(-1, 100)" + "'", str21, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "(-1, 100)" + "'", str22, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "(97, 97)" + "'", str29, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNotNull(position36);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 0 + "'", int39 == 0);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 4 + "'", int41 == 4);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "1" + "'", str49, "1");
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertEquals("'" + str54 + "' != '" + "1" + "'", str54, "1");
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertEquals("'" + str60 + "' != '" + "1" + "'", str60, "1");
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertEquals("'" + str65 + "' != '" + "1" + "'", str65, "1");
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + false + "'", boolean67 == false);
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + true + "'", boolean68 == true);
        org.junit.Assert.assertTrue("'" + boolean71 + "' != '" + true + "'", boolean71 == true);
        org.junit.Assert.assertNotNull(cell72);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertTrue("'" + int75 + "' != '" + 1 + "'", int75 == 1);
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test512");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (byte) 1);
        ar.edu.unrc.game2048.Cell cell3 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str4 = cell3.toString();
        boolean boolean6 = cell3.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell8 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str9 = cell8.toString();
        boolean boolean11 = cell8.equals((java.lang.Object) 100L);
        boolean boolean12 = cell3.canMergeWith(cell8);
        ar.edu.unrc.game2048.Cell cell14 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean15 = cell8.canMergeWith(cell14);
        ar.edu.unrc.game2048.Cell cell17 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean18 = cell17.isEmpty();
        ar.edu.unrc.game2048.Cell cell20 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str21 = cell20.toString();
        boolean boolean23 = cell20.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell25 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str26 = cell25.toString();
        boolean boolean28 = cell25.equals((java.lang.Object) 100L);
        boolean boolean29 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Cell cell31 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean32 = cell25.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell33 = cell17.mergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell35 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean36 = cell35.isEmpty();
        ar.edu.unrc.game2048.Cell cell38 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str39 = cell38.toString();
        boolean boolean41 = cell38.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell43 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str44 = cell43.toString();
        boolean boolean46 = cell43.equals((java.lang.Object) 100L);
        boolean boolean47 = cell38.canMergeWith(cell43);
        ar.edu.unrc.game2048.Cell cell49 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean50 = cell43.canMergeWith(cell49);
        ar.edu.unrc.game2048.Cell cell51 = cell35.mergeWith(cell49);
        boolean boolean52 = cell31.canMergeWith(cell35);
        int int53 = cell31.getValue();
        boolean boolean54 = cell14.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell55 = cell1.mergeWith(cell14);
        int int56 = cell1.getValue();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1" + "'", str4, "1");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1" + "'", str9, "1");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "1" + "'", str21, "1");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "1" + "'", str26, "1");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertNotNull(cell33);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "1" + "'", str39, "1");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertEquals("'" + str44 + "' != '" + "1" + "'", str44, "1");
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertNotNull(cell51);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + 1 + "'", int53 == 1);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertNotNull(cell55);
        org.junit.Assert.assertTrue("'" + int56 + "' != '" + 1 + "'", int56 == 1);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test513");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str2 = cell1.toString();
        boolean boolean4 = cell1.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell6 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str7 = cell6.toString();
        boolean boolean9 = cell6.equals((java.lang.Object) 100L);
        boolean boolean10 = cell1.canMergeWith(cell6);
        ar.edu.unrc.game2048.Cell cell12 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean13 = cell6.canMergeWith(cell12);
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy15 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int16 = deterministicTileStrategy15.determinarValor();
        ar.edu.unrc.game2048.Board.Position position19 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean21 = position19.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean26 = position24.equals((java.lang.Object) true);
        int int27 = position24.col;
        ar.edu.unrc.game2048.Board.Position position30 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str31 = position30.toString();
        java.lang.String str32 = position30.toString();
        ar.edu.unrc.game2048.Board.Position position35 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position38 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str39 = position38.toString();
        ar.edu.unrc.game2048.Board.Position position42 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray43 = new ar.edu.unrc.game2048.Board.Position[] { position19, position24, position30, position35, position38, position42 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet44 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet44, positionArray43);
        ar.edu.unrc.game2048.Board.Position position46 = deterministicTileStrategy15.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet44);
        ar.edu.unrc.game2048.Board board47 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy15);
        boolean boolean48 = board47.moveDown();
        int int49 = board47.getScore();
        boolean boolean50 = board47.moveDown();
        int int51 = board47.getScore();
        boolean boolean52 = board47.isLosingBoard();
        boolean boolean53 = board47.isFull();
        boolean boolean54 = board47.moveDown();
        ar.edu.unrc.game2048.Cell cell58 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str59 = cell58.toString();
        boolean boolean61 = cell58.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell63 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str64 = cell63.toString();
        boolean boolean66 = cell63.equals((java.lang.Object) 100L);
        boolean boolean67 = cell58.canMergeWith(cell63);
        ar.edu.unrc.game2048.Cell cell69 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str70 = cell69.toString();
        boolean boolean72 = cell69.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell74 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str75 = cell74.toString();
        boolean boolean77 = cell74.equals((java.lang.Object) 100L);
        boolean boolean78 = cell69.canMergeWith(cell74);
        ar.edu.unrc.game2048.Cell cell80 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean81 = cell74.canMergeWith(cell80);
        ar.edu.unrc.game2048.Cell cell82 = cell63.mergeWith(cell80);
        board47.setCell((int) (short) 10, 10, cell80);
        boolean boolean84 = cell12.canMergeWith(cell80);
        int int85 = cell12.getValue();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "1" + "'", str7, "1");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 2 + "'", int16 == 2);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 97 + "'", int27 == 97);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "(-1, 100)" + "'", str31, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "(-1, 100)" + "'", str32, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "(97, 97)" + "'", str39, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray43);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        org.junit.Assert.assertNotNull(position46);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + 4 + "'", int51 == 4);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertEquals("'" + str59 + "' != '" + "1" + "'", str59, "1");
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertEquals("'" + str64 + "' != '" + "1" + "'", str64, "1");
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + true + "'", boolean67 == true);
        org.junit.Assert.assertEquals("'" + str70 + "' != '" + "1" + "'", str70, "1");
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertEquals("'" + str75 + "' != '" + "1" + "'", str75, "1");
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + true + "'", boolean78 == true);
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + true + "'", boolean81 == true);
        org.junit.Assert.assertNotNull(cell82);
        org.junit.Assert.assertTrue("'" + boolean84 + "' != '" + true + "'", boolean84 == true);
        org.junit.Assert.assertTrue("'" + int85 + "' != '" + 1 + "'", int85 == 1);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test514");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.moveDown();
        int int37 = board33.getScore();
        boolean boolean38 = board33.isLosingBoard();
        boolean boolean39 = board33.isFull();
        boolean boolean40 = board33.moveDown();
        int int41 = board33.getSize();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 4 + "'", int37 == 4);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 52 + "'", int41 == 52);
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test515");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.moveDown();
        boolean boolean37 = board33.hasEmptyCells();
        ar.edu.unrc.game2048.Cell cell40 = board33.getCell(0, (int) ' ');
        boolean boolean42 = board33.equals((java.lang.Object) (short) 0);
        boolean boolean43 = board33.repOk();
        boolean boolean44 = board33.moveDown();
        boolean boolean45 = board33.isWinningBoard();
        int int46 = board33.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell49 = board33.getCell((int) (byte) -1, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (-1, 97) is out of bounds for board size 52");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 52 + "'", int46 == 52);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test516");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.repOk();
        ar.edu.unrc.game2048.Board board37 = new ar.edu.unrc.game2048.Board(board33);
        boolean boolean38 = board37.isFull();
        boolean boolean39 = board37.repOk();
        boolean boolean40 = board37.hasEmptyCells();
        boolean boolean41 = board37.moveDown();
        ar.edu.unrc.game2048.Cell cell43 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean44 = cell43.isEmpty();
        ar.edu.unrc.game2048.Cell cell46 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str47 = cell46.toString();
        boolean boolean49 = cell46.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell51 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str52 = cell51.toString();
        boolean boolean54 = cell51.equals((java.lang.Object) 100L);
        boolean boolean55 = cell46.canMergeWith(cell51);
        ar.edu.unrc.game2048.Cell cell57 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean58 = cell51.canMergeWith(cell57);
        ar.edu.unrc.game2048.Cell cell59 = cell43.mergeWith(cell57);
        int int60 = cell57.getValue();
        ar.edu.unrc.game2048.Cell cell62 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str63 = cell62.toString();
        boolean boolean65 = cell62.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell66 = cell57.mergeWith(cell62);
        java.lang.Object obj67 = new java.lang.Object();
        boolean boolean68 = cell62.equals(obj67);
        ar.edu.unrc.game2048.Cell cell70 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean71 = cell62.canMergeWith(cell70);
        ar.edu.unrc.game2048.Cell cell73 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str74 = cell73.toString();
        boolean boolean76 = cell73.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell78 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str79 = cell78.toString();
        boolean boolean81 = cell78.equals((java.lang.Object) 100L);
        boolean boolean82 = cell73.canMergeWith(cell78);
        ar.edu.unrc.game2048.Cell cell84 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean85 = cell84.isEmpty();
        boolean boolean86 = cell73.canMergeWith(cell84);
        boolean boolean87 = cell62.canMergeWith(cell84);
        boolean boolean88 = board37.equals((java.lang.Object) cell62);
        ar.edu.unrc.game2048.Board board89 = new ar.edu.unrc.game2048.Board(board37);
        int int90 = board89.getSize();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet91 = board89.getEmptyPositions();
        ar.edu.unrc.game2048.Board board92 = new ar.edu.unrc.game2048.Board(board89);
        boolean boolean93 = board89.moveDown();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertEquals("'" + str47 + "' != '" + "1" + "'", str47, "1");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "1" + "'", str52, "1");
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + true + "'", boolean55 == true);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + true + "'", boolean58 == true);
        org.junit.Assert.assertNotNull(cell59);
        org.junit.Assert.assertTrue("'" + int60 + "' != '" + 1 + "'", int60 == 1);
        org.junit.Assert.assertEquals("'" + str63 + "' != '" + "1" + "'", str63, "1");
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + false + "'", boolean65 == false);
        org.junit.Assert.assertNotNull(cell66);
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertTrue("'" + boolean71 + "' != '" + true + "'", boolean71 == true);
        org.junit.Assert.assertEquals("'" + str74 + "' != '" + "1" + "'", str74, "1");
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertEquals("'" + str79 + "' != '" + "1" + "'", str79, "1");
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + false + "'", boolean81 == false);
        org.junit.Assert.assertTrue("'" + boolean82 + "' != '" + true + "'", boolean82 == true);
        org.junit.Assert.assertTrue("'" + boolean85 + "' != '" + false + "'", boolean85 == false);
        org.junit.Assert.assertTrue("'" + boolean86 + "' != '" + true + "'", boolean86 == true);
        org.junit.Assert.assertTrue("'" + boolean87 + "' != '" + true + "'", boolean87 == true);
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + false + "'", boolean88 == false);
        org.junit.Assert.assertTrue("'" + int90 + "' != '" + 52 + "'", int90 == 52);
        org.junit.Assert.assertNotNull(positionSet91);
        org.junit.Assert.assertTrue("'" + boolean93 + "' != '" + true + "'", boolean93 == true);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test517");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(100, (-1));
        int int3 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test518");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.repOk();
        boolean boolean37 = board33.isFull();
        boolean boolean38 = board33.repOk();
        boolean boolean39 = board33.moveRight();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test519");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (byte) 1);
        ar.edu.unrc.game2048.Cell cell3 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str4 = cell3.toString();
        boolean boolean6 = cell3.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell8 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str9 = cell8.toString();
        boolean boolean11 = cell8.equals((java.lang.Object) 100L);
        boolean boolean12 = cell3.canMergeWith(cell8);
        ar.edu.unrc.game2048.Cell cell14 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean15 = cell8.canMergeWith(cell14);
        ar.edu.unrc.game2048.Cell cell17 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean18 = cell17.isEmpty();
        ar.edu.unrc.game2048.Cell cell20 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str21 = cell20.toString();
        boolean boolean23 = cell20.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell25 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str26 = cell25.toString();
        boolean boolean28 = cell25.equals((java.lang.Object) 100L);
        boolean boolean29 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Cell cell31 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean32 = cell25.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell33 = cell17.mergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell35 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean36 = cell35.isEmpty();
        ar.edu.unrc.game2048.Cell cell38 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str39 = cell38.toString();
        boolean boolean41 = cell38.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell43 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str44 = cell43.toString();
        boolean boolean46 = cell43.equals((java.lang.Object) 100L);
        boolean boolean47 = cell38.canMergeWith(cell43);
        ar.edu.unrc.game2048.Cell cell49 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean50 = cell43.canMergeWith(cell49);
        ar.edu.unrc.game2048.Cell cell51 = cell35.mergeWith(cell49);
        boolean boolean52 = cell31.canMergeWith(cell35);
        int int53 = cell31.getValue();
        boolean boolean54 = cell14.canMergeWith(cell31);
        ar.edu.unrc.game2048.Cell cell55 = cell1.mergeWith(cell14);
        ar.edu.unrc.game2048.Cell cell57 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean58 = cell57.isEmpty();
        ar.edu.unrc.game2048.Cell cell60 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str61 = cell60.toString();
        boolean boolean63 = cell60.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell65 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str66 = cell65.toString();
        boolean boolean68 = cell65.equals((java.lang.Object) 100L);
        boolean boolean69 = cell60.canMergeWith(cell65);
        ar.edu.unrc.game2048.Cell cell71 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean72 = cell65.canMergeWith(cell71);
        ar.edu.unrc.game2048.Cell cell73 = cell57.mergeWith(cell71);
        int int74 = cell71.getValue();
        ar.edu.unrc.game2048.Cell cell76 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str77 = cell76.toString();
        boolean boolean79 = cell76.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell80 = cell71.mergeWith(cell76);
        java.lang.Object obj81 = null;
        boolean boolean82 = cell76.equals(obj81);
        boolean boolean83 = cell55.equals(obj81);
        int int84 = cell55.getValue();
        int int85 = cell55.getValue();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1" + "'", str4, "1");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "1" + "'", str9, "1");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "1" + "'", str21, "1");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "1" + "'", str26, "1");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertNotNull(cell33);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "1" + "'", str39, "1");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertEquals("'" + str44 + "' != '" + "1" + "'", str44, "1");
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertNotNull(cell51);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + 1 + "'", int53 == 1);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertNotNull(cell55);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertEquals("'" + str61 + "' != '" + "1" + "'", str61, "1");
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertEquals("'" + str66 + "' != '" + "1" + "'", str66, "1");
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertTrue("'" + boolean69 + "' != '" + true + "'", boolean69 == true);
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + true + "'", boolean72 == true);
        org.junit.Assert.assertNotNull(cell73);
        org.junit.Assert.assertTrue("'" + int74 + "' != '" + 1 + "'", int74 == 1);
        org.junit.Assert.assertEquals("'" + str77 + "' != '" + "1" + "'", str77, "1");
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + false + "'", boolean79 == false);
        org.junit.Assert.assertNotNull(cell80);
        org.junit.Assert.assertTrue("'" + boolean82 + "' != '" + false + "'", boolean82 == false);
        org.junit.Assert.assertTrue("'" + boolean83 + "' != '" + false + "'", boolean83 == false);
        org.junit.Assert.assertTrue("'" + int84 + "' != '" + 2 + "'", int84 == 2);
        org.junit.Assert.assertTrue("'" + int85 + "' != '" + 2 + "'", int85 == 2);
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test520");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(97, 4);
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test521");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.moveDown();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet37 = board33.getEmptyPositions();
        boolean boolean38 = board33.moveUp();
        boolean boolean39 = board33.moveRight();
        ar.edu.unrc.game2048.Board.Position position42 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str43 = position42.toString();
        ar.edu.unrc.game2048.Cell cell45 = new ar.edu.unrc.game2048.Cell(0);
        boolean boolean46 = position42.equals((java.lang.Object) cell45);
        int int47 = position42.col;
        boolean boolean48 = board33.equals((java.lang.Object) position42);
        boolean boolean49 = board33.moveRight();
        ar.edu.unrc.game2048.Cell cell51 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str52 = cell51.toString();
        boolean boolean54 = cell51.equals((java.lang.Object) 100L);
        ar.edu.unrc.game2048.Cell cell56 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        java.lang.String str57 = cell56.toString();
        boolean boolean59 = cell56.equals((java.lang.Object) 100L);
        boolean boolean60 = cell51.canMergeWith(cell56);
        ar.edu.unrc.game2048.Cell cell62 = new ar.edu.unrc.game2048.Cell((int) (short) 1);
        boolean boolean63 = cell56.canMergeWith(cell62);
        boolean boolean64 = board33.equals((java.lang.Object) boolean63);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertNotNull(positionSet37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertEquals("'" + str43 + "' != '" + "(-1, 100)" + "'", str43, "(-1, 100)");
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 100 + "'", int47 == 100);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + "1" + "'", str52, "1");
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertEquals("'" + str57 + "' != '" + "1" + "'", str57, "1");
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + true + "'", boolean63 == true);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test522");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) -1, (int) (short) 0);
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 0)" + "'", str3, "(-1, 0)");
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test523");
        ar.edu.unrc.game2048.DeterministicTileStrategy deterministicTileStrategy1 = new ar.edu.unrc.game2048.DeterministicTileStrategy();
        int int2 = deterministicTileStrategy1.determinarValor();
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean7 = position5.equals((java.lang.Object) true);
        ar.edu.unrc.game2048.Board.Position position10 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        boolean boolean12 = position10.equals((java.lang.Object) true);
        int int13 = position10.col;
        ar.edu.unrc.game2048.Board.Position position16 = new ar.edu.unrc.game2048.Board.Position((int) (byte) -1, (int) (byte) 100);
        java.lang.String str17 = position16.toString();
        java.lang.String str18 = position16.toString();
        ar.edu.unrc.game2048.Board.Position position21 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position position24 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        java.lang.String str25 = position24.toString();
        ar.edu.unrc.game2048.Board.Position position28 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) 'a');
        ar.edu.unrc.game2048.Board.Position[] positionArray29 = new ar.edu.unrc.game2048.Board.Position[] { position5, position10, position16, position21, position24, position28 };
        java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position> positionSet30 = new java.util.LinkedHashSet<ar.edu.unrc.game2048.Board.Position>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<ar.edu.unrc.game2048.Board.Position>) positionSet30, positionArray29);
        ar.edu.unrc.game2048.Board.Position position32 = deterministicTileStrategy1.determinarPosicion((java.util.Set<ar.edu.unrc.game2048.Board.Position>) positionSet30);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board((int) '4', (ar.edu.unrc.game2048.TileStrategy) deterministicTileStrategy1);
        boolean boolean34 = board33.moveDown();
        int int35 = board33.getScore();
        boolean boolean36 = board33.moveDown();
        boolean boolean37 = board33.hasEmptyCells();
        ar.edu.unrc.game2048.Cell cell40 = board33.getCell(0, (int) ' ');
        boolean boolean42 = board33.equals((java.lang.Object) (short) 0);
        boolean boolean43 = board33.isFull();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 97 + "'", int13 == 97);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "(-1, 100)" + "'", str17, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 100)" + "'", str18, "(-1, 100)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(97, 97)" + "'", str25, "(97, 97)");
        org.junit.Assert.assertNotNull(positionArray29);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(position32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
    }
}

