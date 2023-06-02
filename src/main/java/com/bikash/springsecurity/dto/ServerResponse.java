package com.bikash.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse extends BaseResponse {

    private Object obj;
    private Object errObj;

    public ServerResponse(boolean success) {
        this.success = success;
    }

    public ServerResponse(boolean success, Object obj) {
        this.success = success;
        this.obj = obj;
    }
}
