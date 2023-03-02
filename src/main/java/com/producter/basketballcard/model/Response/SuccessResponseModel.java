package com.producter.basketballcard.model.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.producter.basketballcard.model.Player;

@Data
@EqualsAndHashCode(callSuper=false)
public class SuccessResponseModel extends BaseResponseModel {
    Player[] data;
    public SuccessResponseModel(Player[] data){
        super(false);
        this.data = data;
    }

    public SuccessResponseModel(){
        super(false);
    }
}
