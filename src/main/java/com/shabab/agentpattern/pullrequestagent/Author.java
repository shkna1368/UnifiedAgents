package com.shabab.agentpattern.pullrequestagent;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Author {
    private int id;
    private String username;
    private String name;
    private String state;
    private boolean locked;
    private String avatar_url;
    private String web_url;

    // Getters and setters...
}