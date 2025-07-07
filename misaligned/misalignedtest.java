// File: ColorMapGeneratorTest.java
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class ColorMapGeneratorTest {

    @Test
    public void testColorMapSize() {
        List<String> map = ColorMapGenerator.generateColorMap();
        assertEquals(25, map.size());
    }

    @Test
    public void testSpecificColorMapping() {
        List<String> map = ColorMapGenerator.generateColorMap();
        String expected = ColorMapGenerator.getColorMapEntry(1, "White", "Orange");
        String actual = map.get(1);
        assertEquals("Mismatch in color mapping at index 1", expected, actual);
    }
}
