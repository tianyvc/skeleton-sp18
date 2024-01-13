public class OffByOne {
    @Override
    public boolean equalChars(char x, char y)
    {
        return Math.abs(x - y) == 1;
    }
}
