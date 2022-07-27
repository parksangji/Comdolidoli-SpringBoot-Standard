package com.comdolidoli.dev.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BaseDto {

    boolean isOk = true;
    String msg = "SUCCESS";

    public BaseDto(boolean isOk,String msg) {
        this.isOk = isOk;
        this.msg = msg;
    }
}
