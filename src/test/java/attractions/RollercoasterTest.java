package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor youngVisitor;
    Visitor oldVisitor;
    Visitor youngTallVisitor;
    Visitor oldTallVisitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        youngVisitor = new Visitor(7, 100, 10);
        youngTallVisitor = new Visitor (11, 150, 10);
        oldVisitor = new Visitor(20, 180, 30);
        oldTallVisitor = new Visitor (24, 210, 40);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void checksAllowedToRide__oldAndTall() {
        assertTrue(rollerCoaster.isAllowedTo(oldVisitor));
    }

    @Test
    public void checksAllowedToRide__youngAndTall() {
        assertFalse(rollerCoaster.isAllowedTo(youngTallVisitor));
    }

    @Test
    public void checksAllowedToRide__youngAndShort() {
        assertFalse(rollerCoaster.isAllowedTo(youngVisitor));
    }

    @Test
    public void getPrice__oldEnoughAndLessThan200() {
        assertEquals(8.40, rollerCoaster.priceFor(oldVisitor), 0.01);
    }

    @Test
    public void getPrice__oldEnoughAndOverThan200() {
        assertEquals(16.80, rollerCoaster.priceFor(oldTallVisitor), 0.01);
    }
}
