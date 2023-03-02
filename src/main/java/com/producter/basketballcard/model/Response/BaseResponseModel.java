package com.producter.basketballcard.model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponseModel implements IBaseResponseModel{
    Boolean error;
}
