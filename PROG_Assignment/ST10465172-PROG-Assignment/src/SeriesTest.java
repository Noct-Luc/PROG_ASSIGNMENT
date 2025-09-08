import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    SeriesModel testSeries1;
    SeriesModel testSeries2;

    @BeforeEach
    public void setUp() {
        
        SeriesModel.seriesList.clear();
        testSeries1 = new Series("S001", "Breaking Bad", "16", "62");
        testSeries2 = new Series("S002", "Stranger Things", "13", "34");
        SeriesModel.seriesList.add(testSeries1);
        SeriesModel.seriesList.add(testSeries2);
    }

    @Test
    public void TestSearchSeries() {
        Optional<SeriesModel> result = SeriesModel.seriesList.stream()
                .filter(s -> s.getSeriesId().equalsIgnoreCase("S001"))
                .findFirst();

        assertTrue(result.isPresent());
        assertEquals("Breaking Bad", result.get().getSeriesName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Optional<SeriesModel> result = SeriesModel.seriesList.stream()
                .filter(s -> s.getSeriesId().equalsIgnoreCase("INVALID_ID"))
                .findFirst();

        assertFalse(result.isPresent());
    }

    @Test
    public void TestUpdateSeries() {
   
        for (SeriesModel s : SeriesModel.seriesList) {
            if (s.getSeriesId().equalsIgnoreCase("S002")) {
                s.SeriesName = "Updated Name";
                s.SeriesAge = "15";
                s.SeriesNumberOfEpisodes = "40";
            }
        }

        SeriesModel updated = SeriesModel.seriesList.stream()
                .filter(s -> s.getSeriesId().equals("S002"))
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals("Updated Name", updated.getSeriesName());
        assertEquals("15", updated.getSeriesAge());
        assertEquals("40", updated.getSeriesNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        boolean removed = SeriesModel.seriesList.removeIf(s -> s.getSeriesId().equalsIgnoreCase("S001"));
        assertTrue(removed);
        assertEquals(1, SeriesModel.seriesList.size());
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean removed = SeriesModel.seriesList.removeIf(s -> s.getSeriesId().equalsIgnoreCase("INVALID_ID"));
        assertFalse(removed);
        assertEquals(2, SeriesModel.seriesList.size());
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        String age = "15";
        assertTrue(age.matches("\\d+"));
        int ageNum = Integer.parseInt(age);
        assertTrue(ageNum >= 2 && ageNum <= 18);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        String age = "25";
        assertTrue(age.matches("\\d+"));
        int ageNum = Integer.parseInt(age);
        assertFalse(ageNum >= 2 && ageNum <= 18);
    }
}
