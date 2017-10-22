package amazonQuestion;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String result = "0";

        for (int i = num2.length() - 1, j = 0; i >= 0; j++, i--) {
            String tempResult = mul(num1, num2.substring(i, i + 1));
            for (int m = 0; m < j; m++) {
                tempResult = tempResult + "0";
            }
            result = add(tempResult, result);
        }
        return result;
    }

    //there is only one digit in string two
    public String mul(String one, String two) {
        int valueOfStringTwo = Integer.parseInt(two);
        if (valueOfStringTwo == 0)
            return "0";
        String result = "";
        int bit = 0;
        for (int i = one.length() - 1; i >= 0; i--) {
            int valueOfOne = Integer.parseInt(one.substring(i, i + 1));
            int tempResult = (valueOfOne * valueOfStringTwo + bit) % 10;
            bit = (valueOfOne * valueOfStringTwo + bit) / 10;
            result = tempResult + result;
        }
        if (bit != 0)
            result = bit + result;
        return result;
    }

    public String add(String one, String two) {
        if (one.length() < two.length()) {
            String temp = one;
            one = two;
            two = temp;
        }

        int bit = 0;
        int indexTwo = two.length() - 1;
        int indexOne = one.length() - 1;
        String result = "";
        while (indexTwo >= 0) {
            int numberOne = Integer.parseInt(one.substring(indexOne, indexOne + 1));
            int numberTwo = Integer.parseInt(two.substring(indexTwo, indexTwo + 1));
            int tempResult = (numberOne + numberTwo + bit) % 10;
            bit = (numberOne + numberTwo + bit) / 10;
            indexOne--;
            indexTwo--;
            result = tempResult + result;
        }

        while (indexOne >= 0) {
            int numberOne = Integer.parseInt(one.substring(indexOne, indexOne + 1));
            int tempResult = (numberOne + bit) % 10;
            bit = (numberOne + bit) / 10;
            indexOne--;
            result = tempResult + result;
        }

        if (bit != 0) {
            result = bit + result;
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.print(new MultiplyStrings().multiply("123", "456"));
    }
}
