public class tshirtstest {

    private static int totalTests = 0;
    private static int failedTests = 0;

    public static void main(String[] args) {
        System.out.println("Running T-Shirt size tests...\n");

        // Small size tests
        runTest("Test: Lower bound (cms = 0)", 0, "S");
        runTest("Test: Negative value (cms = -5)", -5, "S");
        runTest("Test: Just below medium (cms = 37)", 37, "S");

        // Medium size tests (BUG HERE)
        runTest("Test: Lower bound of M (cms = 38)", 38, "M"); // ❌ will fail due to bug
        runTest("Test: Middle of M (cms = 39)", 39, "M");
        runTest("Test: Upper bound of M (cms = 40)", 40, "M");

        // Large size tests
        runTest("Test: Just outside M (cms = 41)", 41, "L");
        runTest("Test: Typical L (cms = 42)", 42, "L");
        runTest("Test: Very large size (cms = 100)", 100, "L");

        System.out.println("\nTests complete.");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Failed tests: " + failedTests);

        if (failedTests > 0) {
            throw new AssertionError("Some tests failed. Check the output above.");
        } else {
            System.out.println("✅ All tests passed (unexpectedly, since the bug is still present).");
        }
    }

    private static void runTest(String label, int input, String expected) {
        totalTests++;
        String actual = tshirts.size(input);
        if (!expected.equals(actual)) {
            failedTests++;
            System.err.println("❌ " + label + 
                " | Input = " + input + 
                " | Expected = " + expected + 
                " | Got = " + actual);
        } else {
            System.out.println("✅ " + label + " passed.");
        }
    }
}
