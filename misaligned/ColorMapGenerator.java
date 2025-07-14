import java.util.ArrayList;
import java.util.List;

public class ColorMapGenerator {

    public static String getColorMapEntry(int index, String major, String minor) {
        return String.format("%2d | %-6s | %-6s", index, major, minor);
    }

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
}
