package com.ccttic.task.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(value="cqytjgpt-screen-api")
public interface ISceenTotalFeign {
    @RequestMapping("/task/areaDangerInfo")
    // 统计大屏大地图数据
    String screenTotal();
}
