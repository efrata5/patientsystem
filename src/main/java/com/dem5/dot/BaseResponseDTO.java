package com.dem5.dot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BaseResponseDTO<T> {
    private String message;
    private int status;
    private T data;
    private String errors;
}
