import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(decryption("Hello1 1th1e firs2t1 t1e1s2t"));
    }

    public static String decryption( String input ) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> orderWord = new HashMap<>();
        Arrays.asList(input.split("\\s+")).forEach(x -> validateWord(x, orderWord));

        orderWord.forEach((k, v) -> result.append(v).append(" "));

        return result.toString();
    }

    public static void validateWord(String word, Map<Integer, String> orderWord){
        StringBuilder sb = new StringBuilder(word);
        int value = 0;

        for(int i = 0; i < sb.length(); i++){
            if(Character.isDigit(sb.charAt(i))){
                value += Character.getNumericValue(sb.charAt(i));
                sb.deleteCharAt(i);
            }
        }

        orderWord.put(value, sb.toString());
    }
}
