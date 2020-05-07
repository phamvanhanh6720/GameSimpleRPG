package projectoop.exceptions;

import projectoop.SimpleRPG;

public class SimpleRPGException extends Exception {
    public SimpleRPGException(){

    }
    public SimpleRPGException(String str){
        super(str);
    }
    public SimpleRPGException(String str, Throwable cause){
        super(str,cause);
    }
    public SimpleRPGException(Throwable cause){
        super(cause);
    }
}
