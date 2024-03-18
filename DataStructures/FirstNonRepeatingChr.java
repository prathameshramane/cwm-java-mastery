package MyJava.DataStructures;

import java.util.Map;
import java.util.HashMap;
public class FirstNonRepeatingChr {
    public static void main(String[] args) {
        String string = "prathamesh";
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : string.toCharArray()) {
            if(hm.containsKey(ch))
                hm.put(ch, hm.get(ch) + 1);
            else
                hm.put(ch, 1);
        }

        char ans='0';
        for (var item : hm.entrySet()) {
            // if(item.getValue() == 1){
            //     ans=item.getKey();
            // }
            System.out.println(item.getKey() + "-->" + item.getValue());
        }
        System.out.println(ans);
    }
}
