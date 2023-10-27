package com.example.exam.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 13:28
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskAdminVO {
    private Integer id;
    private String username;
    private String title;
    private String summary;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadline;
    private Boolean status;
}
