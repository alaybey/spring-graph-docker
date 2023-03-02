package com.producter.basketballcard.model.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ErrorResponseModel extends BaseResponseModel {
    String errorMessage;
    public ErrorResponseModel(String message){
        super(true);
        this.errorMessage = message;
    }

    public ErrorResponseModel(){
        super(true);
    }
}
