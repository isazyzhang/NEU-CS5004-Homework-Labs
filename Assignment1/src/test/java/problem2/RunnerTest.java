package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {
    Runner mike;
    Time mikeStart;
    Time mikeEnd;
    Time mikeNewStart;
    Time mikeNewEnd;
    Time expectedDuration;

    @Before
    public void setUp() throws Exception {
        mikeStart = new Time(9, 17, 20);
        mikeEnd = new Time(12, 20, 50);
        mike = new Runner("Mike", "Seattle Lions", mikeStart, mikeEnd);
        expectedDuration = new Time(3, 3, 30);
        mikeNewStart = new Time(10, 20, 30);
        mikeNewEnd = new Time(11, 50, 59);
    }

    @Test
    public void getDuration() {
        Time mikeDuration = mike.getDuration();
        assertEquals(3, mikeDuration.getHours());
        assertEquals(3, mikeDuration.getMinutes());
        assertEquals(30, mikeDuration.getSeconds());
    }

    @Test
    public void getName() {
        assertEquals("Mike", mike.getName());
    }

    @Test
    public void setName() {
        mike.setName("Michael");
        assertEquals("Michael", mike.getName());
    }

    @Test
    public void getTeam() {
        assertEquals("Seattle Lions", mike.getTeam());
    }

    @Test
    public void setTeam() {
        mike.setTeam("Seattle Tigers");
        assertEquals("Seattle Tigers", mike.getTeam());
    }

    @Test
    public void getStart() {
        assertEquals(mikeStart, mike.getStart());
    }

    @Test
    public void setStart() {
        mike.setStart(mikeNewStart);
        assertEquals(mikeNewStart, mike.getStart());
    }

    @Test
    public void getEnd() {
        assertEquals(mikeEnd, mike.getEnd());
    }

    @Test
    public void setEnd() {
        mike.setEnd(mikeNewEnd);
        assertEquals(mikeNewEnd, mike.getEnd());
    }
}