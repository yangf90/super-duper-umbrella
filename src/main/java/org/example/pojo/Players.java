package org.example.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Players {
    private int pid;
    private String pname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private int height;
    private int weight;
    private String position;
    private int cid;
    private String cname;
}
