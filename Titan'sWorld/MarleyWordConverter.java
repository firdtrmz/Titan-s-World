import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author Lenovo_User
 */
public class MarleyWordConverter extends CustomHashMap{


    static void reverse(char A[], int l, int h)
    {
        if (l < h)
        {
            char ch = A[l];
            A[l] = A[h];
            A[h] = ch;
            reverse(A, l + 1, h - 1);
        }
    }

    // Function to return the modified string
    static String reverseParentheses(String str,int len)
    {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++)
        {

            // Push the index of the current
            // opening bracket
            if (str.charAt(i) == '(')
            {
                st.push(i);
            }

            // Reverse the substring starting
            // after the last encountered opening
            // bracket till the current character
            else if (str.charAt(i) == ')')
            {
                char[] A = str.toCharArray();
                reverse(A, st.peek() + 1, i);
                str = String.copyValueOf(A);
                st.pop();
            }
        }

        // To store the modified string
        String res = "";
        for (int i = 0; i < len; i++)
        {
            if (str.charAt(i) != ')' && str.charAt(i) != '(')
            {
                res += (str.charAt(i));
            }
        }
        return res;
    }}

