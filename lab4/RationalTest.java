import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testCreateRationalHasGCD() {
        assertEquals(new Rational(5,25).numerator(),1);
        assertEquals(new Rational(5,25).denominator(),5);
    }
    public void testCreateRationalNoGCD() {
        assertEquals(new Rational(4,9).numerator(),4);
        assertEquals(new Rational(4,9).denominator(),9);
    }

    public void testCreateRationalNumEqlDen() {
        assertEquals(new Rational(4,4).numerator(),1);
        assertEquals(new Rational(4,4).denominator(),1);
    }

    public void testCreateRationalMaxValue() {
        assertEquals(new Rational(Integer.MAX_VALUE,1).numerator(),Integer.MAX_VALUE);
        assertEquals(new Rational(1,Integer.MAX_VALUE).denominator(),Integer.MAX_VALUE);
        assertEquals(new Rational(Integer.MAX_VALUE,Integer.MAX_VALUE).numerator(),1);
        assertEquals(new Rational(Integer.MAX_VALUE,Integer.MAX_VALUE).denominator(),1);
    }

    public void testCreateRationalNegative() {
        assertEquals(new Rational(-5,25).numerator(),-1);
        assertEquals(new Rational(-5,25).denominator(),5);
        assertEquals(new Rational(5,-25).numerator(),1);
        assertEquals(new Rational(5,-25).denominator(),-5);
    }

    public void testCreateRationalBothZero() {
        Boolean gotException = false;
        try {
            Rational myRational = new Rational(0,0);
        } catch (Exception e) {
            gotException = true;
            e.printStackTrace();
        } 
        assertTrue(gotException);       
    }

    public void testCreateRationalDenZero() {    
        Boolean gotException = false;
        try {
            Rational myRational = new Rational(5,0);
        } catch (Exception e) {
            gotException = true;
            e.printStackTrace();
        } 
        assertTrue(gotException);    
    }

    public void testCreateRationalNumZero() {
        assertEquals(0, new Rational(0,5).numerator());
        assertEquals(5, new Rational(0,5).denominator());        
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(15,3), new Rational(5,1));
        assertEquals(new Rational(3,3), new Rational(1,1));
        assertEquals(new Rational(0,3), new Rational(0,3));
        assertEquals(new Rational(Integer.MAX_VALUE,3), new Rational(Integer.MAX_VALUE,3));
        assertEquals(new Rational(1,Integer.MAX_VALUE), new Rational(1,Integer.MAX_VALUE));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(new Rational(1,3)));
        assertFalse(new Rational(2,6).equals(new Rational(1,4)));
        assertFalse(new Rational(15,3).equals(new Rational(5,2)));
        assertFalse(new Rational(0,3).equals(new Rational(0,4)));
        assertFalse(new Rational(Integer.MAX_VALUE,1).equals(new Rational(Integer.MAX_VALUE,3)));
        assertFalse(new Rational(1,Integer.MAX_VALUE).equals(new Rational(3,Integer.MAX_VALUE)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testPlus() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational fifth = new Rational(Integer.MAX_VALUE,4);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        assertEquals(new Rational(19,12),first.plus(second));
        assertEquals(new Rational(1,4),first.plus(third));
        assertEquals(new Rational(5,4),first.plus(fourth));
        assertEquals(new Rational(Integer.MIN_VALUE,4),first.plus(fifth));
        assertEquals(new Rational(0,4),first.plus(sixth));
        assertEquals(new Rational(0,4),first.plus(seventh));
    }

    public void testMinus() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational fifth = new Rational(Integer.MAX_VALUE,4);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        assertEquals(new Rational(-13,12),first.minus(second));
        assertEquals(new Rational(1,4),first.minus(third));
        assertEquals(new Rational(-3,4),first.minus(fourth));
        assertEquals(new Rational(2147483646,4),fifth.minus(first));
        assertEquals(new Rational(2,4),first.minus(sixth));
        assertEquals(new Rational(2,4),first.minus(seventh));        
    }

    public void testDivides() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        Boolean gotException = false;
        assertEquals(new Rational(3,16),first.divides(second));
        try {
            first.divides(third);    
        } catch(Exception e) {
            gotException = true;
            e.printStackTrace();
        }
        assertTrue(gotException);
        assertEquals(new Rational(1,4),first.divides(fourth));
        assertEquals(new Rational(-1,1),first.divides(sixth));
        assertEquals(new Rational(1,-1),first.divides(seventh)); 
    }  

    public void testTimes() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        assertEquals(new Rational(1,3),first.times(second));
        assertEquals(new Rational(0,8),first.times(third));
        assertEquals(new Rational(1,4),first.times(fourth));
        assertEquals(new Rational(1,-16),first.times(sixth));
        assertEquals(new Rational(-1,16),first.times(seventh));        
    }     

    public void testSetGetTolerance() {
        Rational s = new Rational(1,4);
        Rational.setTolerance(s);
        assertEquals(Rational.getTolerance(),new Rational(1,4));
        s = new Rational(4,1);
        Rational.setTolerance(s);
        assertEquals(Rational.getTolerance(),new Rational(4,1));
        Boolean gotException = false;
        s = new Rational(-1,4);
        try {
            Rational.setTolerance(s);
        } catch (Exception e) {
            gotException = true;
            e.printStackTrace();
        }
        assertTrue(gotException);
        gotException = false;
        s = new Rational(4,-1);
        try {
            Rational.setTolerance(s);
        } catch(Exception e) {
            gotException = true;
            e.printStackTrace();
        }
        assertTrue(gotException);
        s = new Rational(-1,-4);
        gotException = false;
        try {
            Rational.setTolerance(s);
        } catch (Exception e) {
            gotException = true;
            e.printStackTrace();
        }
        assertTrue(gotException);
        s = new Rational(0,1);
        Rational.setTolerance(s);
        assertEquals(Rational.getTolerance(),new Rational(0,1));

    }

    public void testIsLessThan() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational fifth = new Rational(2,8);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        assertTrue(first.isLessThan(second));
        assertFalse(first.isLessThan(third));
        assertTrue(first.isLessThan(fourth));  
        assertFalse(first.isLessThan(fifth)); 
        assertFalse(first.isLessThan(sixth));
        assertFalse(first.isLessThan(seventh));
    }

    public void testAbs() {
        Rational first = new Rational(1,4);
        Rational second = new Rational(4,3);
        Rational third = new Rational(0,2);
        Rational fourth = new Rational(1,1);
        Rational fifth = new Rational(Integer.MIN_VALUE,1);
        Rational sixth = new Rational(1,-4);
        Rational seventh = new Rational(-1,4);
        Rational eighth = new Rational(-1,-4);
        Boolean gotException = false;
        assertEquals(new Rational(1,4),first.abs());
        assertEquals(new Rational(4,3),second.abs());
        assertEquals(new Rational(0,2),third.abs());
        try {
            Rational result = fifth.abs();
        } catch (Exception e) {
            gotException = true;
            e.printStackTrace();
        }
        assertTrue(gotException);
        assertEquals(new Rational(1,4),sixth.abs());
        assertEquals(new Rational(1,4),seventh.abs());
        assertEquals(new Rational(1,4),seventh.abs());     
    }

    public void testToSTring() {
        Rational s = new Rational(1,4);
        assertEquals(s.toString(),"1/4");
    }


    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}