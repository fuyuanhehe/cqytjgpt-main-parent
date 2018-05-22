package com.ccttic.util.common;

import java.util.Random;

public class CommonGenerator {

    /**
     * 说明：通用的ID生成器 [年月日 八位] - [机器号] - [PID] - [随机数 6位]
     * */
    public static String DistributiveIDGenerator() {
        StringBuilder builder = new StringBuilder("");
        // 前八位 年月日【20180522】
        builder.append(CCtticDateUtils.presentDay());
        // 获得机器码
        builder.append(SystemEnvironment.MAC_CODE);
        // 获得PID
        builder.append(SystemEnvironment.PID);
        // 6位随机数
        builder.append(CCtticStringUtils.getRandomString(6));
        return builder.toString();
    }
}
