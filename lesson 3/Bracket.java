/**
 * проверка скобок
 */
public class Bracket {
    private String exp;

    public Bracket ( String in ){
        exp = in;
    }
    public boolean check (){
        int size = exp.length ();
        MyStack st = new MyStack( size );
        for ( int i = 0 ; i < exp.length (); i ++){
            char ch = exp.charAt( i );
            switch ( ch ){
                case '[':
                case '{':
                case '(':
                    st . push ( ch );
                    break;
                case ']':
                case '}':
                case ')':
                    if (! st . isEmpty ()){
                        char chr = (char)st.pop();
                        if (( ch == '}' && chr != '{' ) || ( ch == ']' && chr != '[' ) || ( ch == ')' && chr != '(' )){
                            System.out.println ( "Error: " + ch + " at " + i );
                        }
                    } else {
                        System.out.println ( "Error: " + ch + " at " + i );
                    }
                    break;
                default:
                    break;
            }
        }
        if (! st.isEmpty ()){
            System.out.println ( "Error: missing right delimiter" );
            return false;
        }
        return true;
    }
}

