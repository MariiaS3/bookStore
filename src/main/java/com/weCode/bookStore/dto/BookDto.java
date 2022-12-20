package com.weCode.bookStore.dto;

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
@ApiModel(value = "BookDto", description = "all details about book")
public class BookDto {

    @ApiModelProperty(readOnly = true, value = "int", dataType = "Integer", example = "1", notes = "The database generated Integer(uuid) for book id", required = true)
    private Integer id;//UUID

    @ApiModelProperty( value = "title", dataType = "String", example = "book title", notes = "Book title", required = true)
    private String title;

    @ApiModelProperty( value = "description", dataType = "String", example = "book description", notes = "Book description", required = true)
    private String description;

    @ApiModelProperty( value = "releaseYear", dataType = "int", example = "2020", notes = "Book release Year", required = true)
    private int  releaseYear;

}
