package com.gamedoora.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StudiosDTO {

    private String emailId;

    private String name;

    private String  description;

    private String uid;

    private int isCommunity;

    private boolean visibility;

    private boolean registration;
}
