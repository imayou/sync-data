package com.yxt.syncLog.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.yxt.syncLog.domain.FlowLog;
import com.yxt.syncLog.domain.Log;
import io.ebean.DB;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @doc 插件 https://ebean.io/docs/getting-started/intellij-idea
 * @doc 文档 https://ebean.io/docs/
 */
@Service
public class LogService {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * @doc 查询语法 https://ebean.io/docs/persist/
     */
    @PostConstruct
    public void test() {
        FlowLog flowLog = DB.find(FlowLog.class, 77525L);
        System.out.println(flowLog);

        //Database database = DB.getDefault();
        //FlowLog df = database.find(FlowLog.class, 77525L);
        //System.err.println(df);
        //SqlRow one = database.sqlQuery("select * from sys_mis_request_log where id =?").setParameter(1, 77525L).findOne();
        //System.out.println(one);

        //FlowLog fq = new QFlowLog().id.equalTo(77525L).findOne();
        //System.out.println(fq);

        assert flowLog != null;
        Log save = mongoTemplate.save(BeanUtil.copyProperties(flowLog, Log.class));

        Query query = new Query();
        Criteria criteria = Criteria.where("response").regex("chNo");//模糊查询
        query.addCriteria(criteria);
        List<Log> logMons = mongoTemplate.find(query, Log.class);
        logMons.forEach(i -> {
            System.out.println(JSONUtil.parse(i.getResponse()));
        });

        //FlowLogMon save1 = mongoTemplate.save(BeanUtil.copyProperties(flowLog, FlowLogMon.class));
        //System.out.println(JSONUtil.toJsonPrettyStr(save1));

        //相当于创建表
        //MongoCollection<Document> dataHttpLog = mongoTemplate.createCollection("data_http_log");
        //List<FlowLogMon> logMons = mongoTemplate.findAll(FlowLogMon.class);
        //System.out.println(JSONUtil.toJsonPrettyStr(logMons));

        //增
        //FlowLog save = new FlowLog();
        //save.setJobId(1L);
        //save.save();

        //删
        //assert flowLog != null;
        //flowLog.delete();
    }
}
