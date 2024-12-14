package commands;

public class checkers {
    public boolean isNumeric(String str){
        if(str == null || str.isEmpty()){
            return false;
        }
        for(char c: str.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
