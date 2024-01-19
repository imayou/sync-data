package com.yxt.syncLog.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import io.ebean.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sys_mis_request_log")
public class FlowLog extends Model implements Serializable {

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

    public void copy(FlowLog source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }

    public FlowLog re() {
        return BeanUtil.copyProperties(this, FlowLog.class);
    }
}
