package com.lbj.saas.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "角色", description = "")
public class Role  {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("角色")
    private String role;

}
