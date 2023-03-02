package com.producter.basketballcard.exception;

public class PlayerNotFoundException extends Exception{

    public PlayerNotFoundException(){
        super("Player does not exist");
    }
    
}
