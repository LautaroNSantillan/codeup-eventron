
package com.mindhub.todolist.dtos;

import com.mindhub.todolist.enums.TaskStatus;
import com.mindhub.todolist.models.Task;

public class TaskPostDTO {
    private String tittle;
    private String description;

    public TaskPostDTO(){

    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

}
