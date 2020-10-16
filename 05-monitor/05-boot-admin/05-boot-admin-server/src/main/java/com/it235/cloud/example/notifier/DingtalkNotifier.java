package com.it235.cloud.example.notifier;

/**
 * @description:
 * @package: com.it235.cloud.example.notifier
 * @author: jianjun.ren
 * @date: Created in 2020/10/16 12:43
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.config.NacosConfigService;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParserContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @package: com.tifang.adminserver.notifier
 * @author: jianjun.ren
 * @date: Created in 2020/7/18 20:42
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@Slf4j
@Component
public class DingtalkNotifier extends AbstractStatusChangeNotifier {

//    @Autowired
//    private DingTalkRobotClient dingTalkRobotClient;
    /**
     * 消息模板
     */
    private static final String template = "<<<%s>>> \n 【服务名】: %s(%s) \n 【状态】: %s(%s) \n 【服务ip】: %s \n 【详情】: %s";

    private String titleAlarm = "系统告警";

    private String titleNotice = "系统通知";

    private String[] ignoreChanges = new String[]{"UNKNOWN:UP","DOWN:UP","OFFLINE:UP"};

    public DingtalkNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected boolean shouldNotify(InstanceEvent event, Instance instance) {
        if (!(event instanceof InstanceStatusChangedEvent)) {
            return false;
        } else {
            InstanceStatusChangedEvent statusChange = (InstanceStatusChangedEvent)event;
            String from = this.getLastStatus(event.getInstance());
            String to = statusChange.getStatusInfo().getStatus();
            return Arrays.binarySearch(this.ignoreChanges, from + ":" + to) < 0 && Arrays.binarySearch(this.ignoreChanges, "*:" + to) < 0 && Arrays.binarySearch(this.ignoreChanges, from + ":*") < 0;
        }
    }


    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

        return Mono.fromRunnable(() -> {
//            if (!nacosConfigService.getIsopen()){
//                return;
//            }
//
//            String watchapplications = nacosConfigService.getWatchapplications();
//            Boolean flag=watchapplications.contains(instance.getRegistration().getName());
//            if (!flag){
//                return;
//            }
            if (event instanceof InstanceStatusChangedEvent) {
                log.info("Instance {} ({}) is {}", instance.getRegistration().getName(),
                        event.getInstance(),
                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());

                String status = ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus();
                String messageText = null;
                switch (status) {
                    // 健康检查没通过
                    case "DOWN":
                        log.info("发送 健康检查没通过 的通知！");
                        messageText = String
                                .format(template,titleAlarm, instance.getRegistration().getName(), event.getInstance(),
                                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus(), "健康检查没通过通知",
                                        instance.getRegistration().getServiceUrl(), JSONObject.toJSONString(instance.getStatusInfo().getDetails()));
//                        DingtalkUtils.pushInfoToDingding(messageText, "b240b227f5add0fsdfdfsdf5aca64450e71e54721bf08d7ee17114");
                        break;
                    // 服务离线
                    case "OFFLINE":
                        log.info("发送 服务离线 的通知！");
                        messageText = String
                                .format(template,titleAlarm, instance.getRegistration().getName(), event.getInstance(),
                                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus(), "服务离线通知",
                                        instance.getRegistration().getServiceUrl(), JSONObject.toJSONString(instance.getStatusInfo().getDetails()));
                        DingtalkUtils.pushInfoToDingding(messageText, "b240b227f5add0fsdfdfsdf5aca64450e71e54721bf08d7ee17114");
                        break;
                    //服务上线
                    case "UP":
                        log.info("发送 服务上线 的通知！");
                        messageText = String
                                .format(template,titleNotice, instance.getRegistration().getName(), event.getInstance(),
                                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus(), "服务上线通知",
                                        instance.getRegistration().getServiceUrl(), JSONObject.toJSONString(instance.getStatusInfo().getDetails()));
                        DingtalkUtils.pushInfoToDingding(messageText, "b240b227f5add0fsdfdfsdf5aca64450e71e54721bf08d7ee17114");
                        System.out.println(messageText);
                        break;
                    // 服务未知异常
                    case "UNKNOWN":
                        log.info("发送 服务未知异常 的通知！");
                        messageText = String
                                .format(template,titleAlarm, instance.getRegistration().getName(), event.getInstance(),
                                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus(), "服务未知异常通知",
                                        instance.getRegistration().getServiceUrl(), JSONObject.toJSONString(instance.getStatusInfo().getDetails()));
                        DingtalkUtils.pushInfoToDingding(messageText, "b240b227f5add0fsdfdfsdf5aca64450e71e54721bf08d7ee17114");
                        break;
                    default:
                        break;
                }
            } else {
                log.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
                        event.getType());
            }
        });
    }
}