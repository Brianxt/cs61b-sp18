//import java.util.LinkedList;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char k = word.charAt(i);
            D.addLast(k);
        }
        return D;
    }

    private boolean judgement(Deque<Character> D) {
        int size = D.size();
        if (size == 0 || size == 1) {
            return true;
        } else {
            Character first = D.removeFirst();
            Character last = D.removeLast();
            if (first == last) {
                return judgement(D);
            } else {
                return false;
            }
        }

    }

    public boolean isPalindrome(String word) {
        Deque<Character> D = wordToDeque(word);
        return judgement(D);
    }

    private boolean judgement(Deque<Character> D, CharacterComparator cc) {
        int size = D.size();
        if (size == 0 || size == 1) {
            return true;
        } else {
            Character first = D.removeFirst();
            Character last = D.removeLast();
            if (cc.equalChars(first, last)) {
                return judgement(D, cc);
            } else {
                return false;
            }
        }

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> D = wordToDeque(word);
        return judgement(D, cc);
    }
}
