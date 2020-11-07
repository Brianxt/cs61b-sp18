public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        int x1 = x;
        int y1 = y;
        if (97 <= x1 && x1 >= 122 && 97 <= y1 && y1 >= 122) {
            if (diff == 1) {
                return true;
            }
            return false;
        }
        return false;
    }

}
