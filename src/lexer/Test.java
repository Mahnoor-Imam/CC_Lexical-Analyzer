package lexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum Test {

    ID(256),PLUS('+'){
        @Override
        public String toString()
        {
            return "'+'";
        }
    };

    private int val;
    Test(int v)
    {
        this.val = v;
    }

    public static void main(String[]args) throws IOException {
        System.out.println(Test.ID);
        System.out.println(Test.ID.name());
        System.out.println(Test.ID.val);

        System.out.println(Test.PLUS);
        System.out.println(Test.PLUS.name());
        System.out.println(Test.PLUS.val);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("x");
        String[] text = arrayList.toArray(String[]::new);

        Lexer.main(text);
    }
}
