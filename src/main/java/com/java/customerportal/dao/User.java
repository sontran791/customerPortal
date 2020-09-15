package com.java.customerportal.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.*;

@ApiModel(description = "This model is to create a user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @ApiModelProperty(notes = "Auto generated unique id", required = true, position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = WRITE_ONLY)
    private Long id;

    @ApiModelProperty(notes = "This is actual user id", example = "lb5454", required = false, position = 2)
    private String userId;
    private String firstName;
    private String lastName;
    private String username;

    @JsonProperty(access = WRITE_ONLY)
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role;
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
}
