package com.ccttic.entity.danger;

import java.io.Serializable;

import com.ccttic.entity.BaseBean;

public class DrDanger extends BaseBean implements Serializable{
	private static final long serialVersionUID = -8349678655503842856L;

    /**
     * 驾驶人名称
     */
    private String drivername;

    /**
     * 身份证号码
     */
    private String driveridcard;

    /**
     * 预警等级
     */
    private String dangertype;

    /**
     * 所属交巡警大队
     */
    private String ownergener;

    /**
     * 所属运管所
     */
    private String ownerorgid;

    /**
     * 预警时间
     */
    private String dangertime;

    /**
     * 整改期限
     */
    private String correcttime;

    /**
     * 整改进度
     */
    private String correctstate;

    /**
     * 预警主题
     */
    private String dangerdesc;

    /**
     * 驾驶员关联id
     */
    private String driverId;

    /**
     * 预期未换证状态 1是0否
     */
    private Integer overdueproofstate;

    /**
     * 预期未审验状态 1是0否
     */
    private Integer overdueexaminestate;

    /**
     * 满分未学习  1是0否
     */
    private Integer fullstudystate;
    /**
     * 预期未换证天数
     */
    private Integer overdueProofDays;

    /**
     * 预期未审验天数
     */
    private Integer overdueExamineDays;

    /**
     * 满分未学习天数
     */
    private Integer fullStudyDays;

    /**
     * 备注
     */
    private String remark;


    /**
     * 驾驶人名称
     * @return driverName 驾驶人名称
     */
    public String getDrivername() {
        return drivername;
    }

    /**
     * 驾驶人名称
     * @param drivername 驾驶人名称
     */
    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    /**
     * 身份证号码
     * @return driverIdcard 身份证号码
     */
    public String getDriveridcard() {
        return driveridcard;
    }

    /**
     * 身份证号码
     * @param driveridcard 身份证号码
     */
    public void setDriveridcard(String driveridcard) {
        this.driveridcard = driveridcard == null ? null : driveridcard.trim();
    }

    /**
     * 预警等级
     * @return dangerType 预警等级
     */
    public String getDangertype() {
        return dangertype;
    }

    /**
     * 预警等级
     * @param dangertype 预警等级
     */
    public void setDangertype(String dangertype) {
        this.dangertype = dangertype == null ? null : dangertype.trim();
    }

    /**
     * 所属交巡警大队
     * @return ownerGener 所属交巡警大队
     */
    public String getOwnergener() {
        return ownergener;
    }

    /**
     * 所属交巡警大队
     * @param ownergener 所属交巡警大队
     */
    public void setOwnergener(String ownergener) {
        this.ownergener = ownergener == null ? null : ownergener.trim();
    }

    /**
     * 所属运管所
     * @return ownerOrgId 所属运管所
     */
    public String getOwnerorgid() {
        return ownerorgid;
    }

    /**
     * 所属运管所
     * @param ownerorgid 所属运管所
     */
    public void setOwnerorgid(String ownerorgid) {
        this.ownerorgid = ownerorgid == null ? null : ownerorgid.trim();
    }

    /**
     * 预警时间
     * @return dangerTime 预警时间
     */
    public String getDangertime() {
        return dangertime;
    }

    /**
     * 预警时间
     * @param dangertime 预警时间
     */
    public void setDangertime(String dangertime) {
        this.dangertime = dangertime == null ? null : dangertime.trim();
    }

    /**
     * 整改期限
     * @return correctTime 整改期限
     */
    public String getCorrecttime() {
        return correcttime;
    }

    /**
     * 整改期限
     * @param correcttime 整改期限
     */
    public void setCorrecttime(String correcttime) {
        this.correcttime = correcttime == null ? null : correcttime.trim();
    }

    /**
     * 整改进度
     * @return correctState 整改进度
     */
    public String getCorrectstate() {
        return correctstate;
    }

    /**
     * 整改进度
     * @param correctstate 整改进度
     */
    public void setCorrectstate(String correctstate) {
        this.correctstate = correctstate == null ? null : correctstate.trim();
    }

    /**
     * 预警主题
     * @return dangerDesc 预警主题
     */
    public String getDangerdesc() {
        return dangerdesc;
    }

    /**
     * 预警主题
     * @param dangerdesc 预警主题
     */
    public void setDangerdesc(String dangerdesc) {
        this.dangerdesc = dangerdesc == null ? null : dangerdesc.trim();
    }

    /**
     * 驾驶员关联id
     * @return driver_id 驾驶员关联id
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * 驾驶员关联id
     * @param driverId 驾驶员关联id
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }



    /**
     * 预期未换证状态 1是0否
     * @return overdueProofState 预期未换证状态 1是0否
     */
    public Integer getOverdueproofstate() {
        return overdueproofstate;
    }

    /**
     * 预期未换证状态 1是0否
     * @param overdueproofstate 预期未换证状态 1是0否
     */
    public void setOverdueproofstate(Integer overdueproofstate) {
        this.overdueproofstate = overdueproofstate;
    }

    /**
     * 预期未审验状态 1是0否
     * @return overdueExamineState 预期未审验状态 1是0否
     */
    public Integer getOverdueexaminestate() {
        return overdueexaminestate;
    }

    /**
     * 预期未审验状态 1是0否
     * @param overdueexaminestate 预期未审验状态 1是0否
     */
    public void setOverdueexaminestate(Integer overdueexaminestate) {
        this.overdueexaminestate = overdueexaminestate;
    }

    /**
     * 满分未学习  1是0否
     * @return fullStudyState 满分未学习  1是0否
     */
    public Integer getFullstudystate() {
        return fullstudystate;
    }

    /**
     * 满分未学习  1是0否
     * @param fullstudystate 满分未学习  1是0否
     */
    public void setFullstudystate(Integer fullstudystate) {
        this.fullstudystate = fullstudystate;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }



    public Integer getFullStudyDays() {
        return fullStudyDays;
    }

    public void setFullStudyDays(Integer fullStudyDays) {
        this.fullStudyDays = fullStudyDays;
    }


    public Integer getOverdueProofDays() {
        return overdueProofDays;
    }

    public void setOverdueProofDays(Integer overdueProofDays) {
        this.overdueProofDays = overdueProofDays;
    }

    public Integer getOverdueExamineDays() {
        return overdueExamineDays;
    }

    public void setOverdueExamineDays(Integer overdueExamineDays) {
        this.overdueExamineDays = overdueExamineDays;
    }

    public DrDanger(String drivername, String driveridcard, String dangertype, String ownergener, String ownerorgid, String dangertime, String correcttime, String correctstate, String dangerdesc, String driverId, Integer overdueproofstate, Integer overdueexaminestate, Integer fullstudystate, Integer overdueProofDays, Integer overdueExamineDays, Integer fullStudyDays, String remark) {
        this.drivername = drivername;
        this.driveridcard = driveridcard;
        this.dangertype = dangertype;
        this.ownergener = ownergener;
        this.ownerorgid = ownerorgid;
        this.dangertime = dangertime;
        this.correcttime = correcttime;
        this.correctstate = correctstate;
        this.dangerdesc = dangerdesc;
        this.driverId = driverId;
        this.overdueproofstate = overdueproofstate;
        this.overdueexaminestate = overdueexaminestate;
        this.fullstudystate = fullstudystate;
        this.overdueProofDays = overdueProofDays;
        this.overdueExamineDays = overdueExamineDays;
        this.fullStudyDays = fullStudyDays;
        this.remark = remark;
    }

    public DrDanger() {
    }
}