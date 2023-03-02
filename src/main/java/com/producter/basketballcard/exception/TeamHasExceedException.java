package com.producter.basketballcard.exception;

public class TeamHasExceedException extends Exception {
    
    public TeamHasExceedException() {
        super("Team already have maximum member");
    }

}
