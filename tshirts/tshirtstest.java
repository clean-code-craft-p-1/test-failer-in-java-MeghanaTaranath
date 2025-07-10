public class tshirtstest {
    public static void main(String[] args) {
        assert tshirts.size(37).equals("S") : "Test failed: Expected S";
        assert tshirts.size(40).equals("M") : "Test failed: Expected M";
        assert tshirts.size(43).equals("L") : "Test failed: Expected L";
        assert tshirts.size(38).equals("M") : "Test failed: Expected M";

        System.out.println("All tests passed.");
    }
}
