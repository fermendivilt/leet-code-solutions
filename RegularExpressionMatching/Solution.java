class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty())                                     //caso base (no quedan más caracteres del pattern para validar)
            return s.isEmpty();                             //
        //if(!s.isEmpty)
        boolean first = ((!s.isEmpty()) && ((s.charAt(0)==p.charAt(0))||(p.charAt(0)=='.')));   //checar si hay match entre el primer caracter de string y pattern

        if(p.length() >=2 && p.charAt(1)=='*'){             //en caso de que haya estrella de kleene
            return (isMatch(s, p.substring(2)) ||           //caso de 0 repeticiones (kleene)
                    (first && isMatch(s.substring(1), p)));  //1 o + repeticiones
        }
        else {
            return first && isMatch(s.substring(1), p.substring(1));  //avanza +1 en string y pattern
        }
    }
}
