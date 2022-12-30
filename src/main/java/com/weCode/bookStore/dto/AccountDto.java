package com.weCode.bookStore.dto;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UserDto", description = "all details about Users")
public class AccountDto {

    @ApiModelProperty(readOnly = true, value = "UUID", dataType = "UUID", example = "b5607d38-8fc1-43ef-b44e-34967083c80", notes = "The database generated uuid for user id", required = true)
    private UUID id;

    @ApiModelProperty( value = "name", dataType = "String", example = "User name", notes = "User name", required = true)
    private String name;

    @ApiModelProperty( value = "email", dataType = "String", example = "User email", notes = "User email", required = true)
    private String email;

    @ApiModelProperty( value = "password", dataType = "String", example = "User password", notes = "User password", required = true)
    private String password;

}