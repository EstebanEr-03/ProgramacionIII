// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Stack;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hola");
        Stack<String> Simbolos = new Stack<>();
        String ejemploClases = "[{(]]";

        for (int i = 0; i <= ejemploClases.length(); i++)
        {
            if (ejemploClases.charAt(i) == '[' || ejemploClases.charAt(i) == '{' || ejemploClases.charAt(i) == '(')
            {
                Simbolos.push(String.valueOf(ejemploClases.charAt(i)));
            } else if (ejemploClases.charAt(i) == ']' || ejemploClases.charAt(i) == '}' || ejemploClases.charAt(i) == ')')
            {
                char comparar = ejemploClases.charAt(i);
                if (comparar == ']' && Simbolos.pop().equals(String.valueOf('[')) || comparar == '}' && Simbolos.pop().equals(String.valueOf('{')) || comparar == ')' && Simbolos.pop().equals(String.valueOf('(')))
                {
                    Simbolos.push(String.valueOf(comparar));
                }
            }
            System.out.println(Simbolos);
        }

        System.out.println("La pila almacenada actualmente es" + Simbolos);

        /*if (ejemploClases.charAt(0)=='[' || ejemploClases.charAt(0)=='{' || ejemploClases.(0)=='(' )
        {
            ejemploClases.push(ejemploClases[0]);
        }else if (ejemploClases[0]=='[' || ejemploClases[0]=='{' || ejemploClases[0]=='(' )
        {
            ejemploClases.push(ejemploClases[0]);
        }*/
    }

}