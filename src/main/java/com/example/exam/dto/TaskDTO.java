package com.example.exam.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 12:19
 **/

@Data
public class TaskDTO {
    private String title;
    private String desc;
    private Date deadline;
}
