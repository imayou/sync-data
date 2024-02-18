package com.yxt.synclog.api;

import com.yxt.synclog.DataPermissionQueryInterceptor;
import com.yxt.synclog.domain.FlowLog;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/eb")
@RestController
public class EbAPI {
    @RequestMapping("/health")
    public boolean health() {
        DatabaseConfig config = new DatabaseConfig();
        config.add(new DataPermissionQueryInterceptor());

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setUrl("jdbc:mysql://10.0.38.115:3306/tinyx?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false");

        config.setDataSourceConfig(dataSourceConfig);

        DatabaseFactory.create(config);
        FlowLog flowLog = DB.find(FlowLog.class, 77525L);
        System.out.println(flowLog);
        return true;
    }

    @PostConstruct
    public void t() {
        health();
    }
}
