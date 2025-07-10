public class tshirtstest {
    public static void main(String[] args) {
        assert "S".equals(tshirts.size(37));
        assert "M".equals(tshirts.size(38)); // edge case test
        assert "M".equals(tshirts.size(40));
        assert "L".equals(tshirts.size(43));
        System.out.println("All tests passed (probably!)");
    }
}
