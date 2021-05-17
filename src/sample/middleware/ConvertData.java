package sample.middleware;

public class ConvertData {
    public ConvertData(){

    }
    public int convertTurn( String str){
        String numberOnly = str.replaceAll("[^0-9]", "");
        int result = Integer.parseInt(numberOnly);
        return result;
    }
}
