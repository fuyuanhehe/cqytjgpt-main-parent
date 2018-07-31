package com.ccttic.cqytjgpt.screen.interfaces.danger;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.VehiDanger;

public interface IScreenService {


    /**
     * 查询全市驾驶员接入数
     */
    public Map<String, Object> allDriver();

    /**
     * 查询全市企业接入数
     */
    public Map<String, Object> allEnterprise();

    /**
     * 查询全市机动车接入数
     */
    public Map<String, Object> allCar();

    /**
     * 查询分所名称id接口
     */
    public List<Map<String, Object>> findPlace();

    /**
     * 驾驶人隐患发现情况
     */
    public Map<String, Object> findDangerForDriver();

    /**
     * 机动车隐患发现情况
     */
    public Map<String, Object> findDangerForCar();

    /**
     * 企业隐患发现情况
     */
    public Map<String, Object> findDangerForEnterprise();

    /**
     * 驾驶员隐患问题分布情况
     *
     * @param dateMap 根据条件查询数据 month season year
     */
    public List<Map<String, Object>> distributionDangerForDriver(Map<String, Object> dateMap);

    /**
     * 机动车隐患问题分布情况
     *
     * @param dateMap 根据条件查询数据 month season year
     */
    public List<Map<String, Object>> distributionDangerForCar(Map<String, Object> dateMap);

    /**
     * 企业隐患问题分布情况
     *
     * @param dateMap 根据条件查询数据 month season year
     */
    public List<Map<String, Object>> distributionDangerForEnterprise(Map<String, Object> dateMap);

    /**
     * 驾驶员隐患治理结果分析
     */
    public Map<String, Object> handleDangerForDriver();

    /**
     * 机动车隐患治理结果分析
     */
    public Map<String, Object> handleDangerForCar();

    /**
     * 企业隐患治理结果分析
     */
    public Map<String, Object> handleDangerForEnterprise();

    /**
     * 驾驶员整治效果趋势分析
     */
    public Map<String, Object> resultDangerForDriver();

    /**
     * 机动车整治效果趋势分析
     */
    public Map<String, Object> resultDangerForCar();

    /**
     * 企业整治效果趋势分析
     */
    public Map<String, Object> resultDangerForEnterprise();

    /**
     * 分区隐患信息
     */
    public List<Map<String, Object>> areaDangerInfo();

    /**
     * 隐患驾驶员通报
     *
     * @param map 条数 top
     */
    public Map<String, Object> noticeDangerForDriver(Map map);

    /**
     * 隐患机动车通报
     *
     * @param map 条数 top
     */
    public Map<String, Object> noticeDangerForCar(Map map);

    /**
     * 隐患企业通报
     *
     * @param map 条数 top
     */
    public Map<String, Object> noticeDangerForEnterprise(Map map);

    /**
     * 各区隐患排名
     */
    public List<Map<String, Object>> areaDangersTop();

    /**
     * 各区驾驶员隐患占比
     */
    public List<Map<String, Object>> ratioDangerForDriver();

    /**
     * 各区机动车隐患占比
     */
    public List<Map<String, Object>> ratioDangerForCar();
    /**
     * 各区企业隐患占比
     */
    List<Map<String,Object>> ratioDangerForEnterprise();
    /**
     * 各分所驾驶员治理情况同比
     *
     * @param map orgId 分所id
     */
    public Map<String, Object> deptDangerForDriver(Map<String, Object> map);

    /**
     * 各分所机动车治理情况同比
     *
     * @param map orgId 分所id
     */
    public Map<String, Object> deptDangerForCar(Map<String, Object> map);

    /**
     * 各分所企业治理情况同比
     *
     * @param map orgId 分所id
     */
    public Map<String, Object> deptDangerForEnterprise(Map<String, Object> map);

    /**
     * 各区治理排名
     * @return
     */
    List<Map<String, Object>> areaHandleDangersTop();

    /**
     * 各区治理排名
     * @return
     */
    void insertScreenTotal(List<Map<String, Object>> list);
}
