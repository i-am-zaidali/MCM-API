package com.crayyy_zee.MissionChiefMetrics.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedQuery extends RuntimeException{
    public MalformedQuery(String s) {
        super(s);
    }
}
