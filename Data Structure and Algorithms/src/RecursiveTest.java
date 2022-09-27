import java.util.*;

public class RecursiveTest {
    ArrayList<String> getAnagram(String str_in) {
        ArrayList<String> result = new ArrayList<>();
        if (str_in.length() == 1) {
            result.add(str_in);
            return result;
        }
        ArrayList<String> str_set = getAnagram(str_in.substring(1));
        for (String str_i : str_set) {
            for (int i = 0; i <= str_in.substring(1).length(); i++) {
                StringBuilder temp_builder = new StringBuilder();
                temp_builder.append(str_i);
                System.out.println(temp_builder.toString());
                temp_builder.insert(i, str_in.charAt(0));
                result.add(temp_builder.toString());
            }
        }
        return result;
    }

    static public void main (String[] args) {
        String test = "abcd";
        RecursiveTest solution = new RecursiveTest();
        ArrayList<String> result = solution.getAnagram(test);
        System.out.println(result);
    }
}
