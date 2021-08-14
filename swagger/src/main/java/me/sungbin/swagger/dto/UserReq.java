package me.sungbin.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {

    @ApiModelProperty(value = "사용자의 이름", example = "robert", required = true)
    private String name;

    @ApiModelProperty(value = "사용자의 나이", example = "26", required = true)
    private int age;
}
