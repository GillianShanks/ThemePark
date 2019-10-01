package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 6);
        youngVisitor = new Visitor(7, 100, 10);
        oldVisitor = new Visitor(20, 180, 30);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void checksAllowedToBuy__pass() {
        assertTrue(tobaccoStall.isAllowedTo(oldVisitor));
    }

    @Test
    public void checksAllowedToBuy__fail() {
        assertFalse(tobaccoStall.isAllowedTo(youngVisitor));
    }

    @Test
    public void hasRating() {
        assertEquals(6, tobaccoStall.getRating());
    }
}
