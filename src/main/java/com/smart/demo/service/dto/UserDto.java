package com.smart.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("User")
public class UserDto {

    @Getter
    @Setter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModel("UserInfo1")
    public static class UserInfo extends UserDto{
        private Long id;
        private String userName;
        private RoleTuple role;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModel("UserCreate1")
    public static class UserCreate extends UserDto{
        @ApiModelProperty(required = true)
        private String userName;
        @ApiModelProperty(required = true)
        private String password;

        private RoleTuple role;
    }

    @Getter
    @Setter
    @ApiModel("RoleTuple")
    public static class RoleTuple{
        @ApiModelProperty(required = true)
        private Long id;
        private String roleName;
    }
}

