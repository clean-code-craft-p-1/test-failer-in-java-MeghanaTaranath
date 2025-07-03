import java.util.ArrayList;
import java.util.List;

public class misaligned {

    // Helper method to format a single color map entry
    public static String getColorMapEntry(int index, String major, String minor) {
        return String.format("%2d | %-6s | %-6s", index, major, minor);
    }

    // Generate the full color map with a bug still present
    public static List<String> generateColorMap() {
        String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};
  List<String> colorMapEntries = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            // BUG: should be minorColors[j]
            String line = getColorMapEntry(i * 5 + j, majorColors[i], minorColors[i]);
            colorMapEntries.add(line);
        }
    }
    return colorMapEntries;
    }
    

    public static void main(String[] args) {
        List<String> map = generateColorMap();

        assert(map.size() == 25);

        // Failing test that exposes the bug
        // Index 1 should be "White | Orange", but due to bug it will still be "White | Blue"
String expected = getColorMapEntry(1, "White", "Orange");
String actual = map.get(1);

// Stronger, clearer assertion with detailed error message
assert actual.equals(expected) : 
    "Expected row 1 to be: '" + expected + "', but got: '" + actual + "'";
	

        System.out.println("All is well (maybe!)");
    }
}
