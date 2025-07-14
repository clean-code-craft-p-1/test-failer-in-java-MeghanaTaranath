public class tshirtstest {
    public static void main(String[] args) {
        test(36, "S");
        test(37, "S");

        test(38, "M"); // ❌ Bug: will return "L"
        test(39, "M");
        test(40, "M");

        test(41, "L"); // Edge boundary
        test(42, "L");
        test(100, "L");

        test(0, "S");    // Edge case: very low input
        test(-5, "S");   // Negative size (nonsensical, but we test behavior)

        System.out.println("All tests executed (but should fail).");
    }
private static void runTest(int input, String expected) {
        String actual = tshirts.size(input);
        assert expected.equals(actual) : 
            "FAILED: Input = " + input + 
            " | Expected = " + expected + 
            " | Got = " + actual;
    }
}
