public class tshirts {

    /**
     * Returns the size category based on chest measurement in cm.
     * 
     * @param cms chest size in centimeters
     * @return "S", "M", or "L"
     */
    public static String getSize(int cms) {
        if (cms < 38) {
            return "S";
        } else if (cms > 38 && cms < 42) {
            return "M";
        } else {
            return "L";
        }
    }
}
