package com.yxt.syncLog.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(value = "data_http_log")
public class Log implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    @Column(name = "prams")
    private String prams;

    @Column(name = "response")
    private String response;

    @Column(name = "is_success")
    private Boolean isSuccess;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "method")
    private String method;

    @Column(name = "msg")
    private String msg;

    @Column(name = "url")
    private String url;

    @Column(name = "bid")
    private String bid;
}
