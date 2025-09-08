import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dreamerSleptTest {

    DreamerSlept dreamer;

    @BeforeEach
    void setUp() {
        dreamer = new DreamerSlept(7, "Starfall City");
    }

    @Test
    void TestSetDreamScape() {
        dreamer.setDreamScape("Moonlight Meadows");
        assertEquals("Moonlight Meadows", dreamer.getDreamScape());
    }

    @Test
    void TestGetDreamNum() {
        assertEquals(7, dreamer.getDreamNum());
    }

    @Test
    void TestGetDreamScape() {
        assertEquals("Starfall City", dreamer.getDreamScape());
    }

    @Test
    void TestDreamRank_Bronze() {
        String rank = DreamerSlept.dreamRank(3, "Dark Forest");
        assertEquals("Bronze", rank);
    }

    @Test
    void TestDreamRank_Silver() {
        String rank = DreamerSlept.dreamRank(7, "Sky Haven");
        assertEquals("Silver", rank);
    }

    @Test
    void TestDreamRank_Gold() {
        String rank = DreamerSlept.dreamRank(12, "Crystal Peaks");
        assertEquals(" Gold", rank); // note the space in front of "Gold" in your original code
    }

    @Test
    void TestGetDreamerProcess() {
        DreamerSlept.dreamRank(9, "Frozen Tundra");
        assertEquals("Silver", dreamer.getDreamerProcess());
    }
}
