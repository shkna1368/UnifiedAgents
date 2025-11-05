package com.shabab.agentpattern.pullrequestagent;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class MergeRequestResponse {

    private int id;
    private int iid;
    @JsonProperty("project_id")
    private int projectId;
    private String title;
    private String description;
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    private Author author;
    private List<Assignee> assignees;
    private Assignee assignee;
    private List<Change> changes;
}