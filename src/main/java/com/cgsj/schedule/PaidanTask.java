package com.cgsj.schedule;

import com.cgsj.client.csm.CsmClientService;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaidanTask {

    @Inject
    CsmClientService csmClientService;

    @Scheduled(cron = "0/5 * * * * ? ")
    void cronJob(ScheduledExecution execution) {
        Log.infof("当前时间%s:派单任务触发！", execution.getScheduledFireTime());


    }
}
