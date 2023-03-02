package com.producter.basketballcard.exception;

public class PositionNotFoundException extends Exception{
    
    public PositionNotFoundException(){
        super("Position does not exist.");
    }
}
