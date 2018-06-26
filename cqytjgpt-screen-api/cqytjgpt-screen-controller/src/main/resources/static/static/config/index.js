/**
 * 运用存放接口地址等配置信息
 */
// var baseinter = "http://test.zan1000.com/";

var baseinter = 'http://10.10.20.22:10101/manager/';
var config = {
    /**
     * 接口
     */
    interface: {
        whole_dri: baseinter + "screen/findDangerForDriver",            //驾驶人隐患发现情况
        whole_car: baseinter + "screen/findDangerForCar",               //机动车隐患发现情况
        pie_dri: baseinter + "screen/distributionDangerForDriver",      //驾驶员隐患问题分布情况
        pie_dri2: baseinter + "screen/distributionDangerForCar",        //机动车隐患问题分布情况
        ana_data: baseinter + 'screen/handleDangerForDriver',           //驾驶人隐患治理成果
        ana_data2: baseinter + 'screen/handleDangerForCar',             //机动车隐患治理成果
        line_data: baseinter + 'screen/resultDangerForDriver',          //驾驶员整治效果趋势
        line_data1: baseinter + 'screen/resultDangerForCar',            //机动车整治效果趋势
        bar_data1: baseinter + 'screen/areaDangersTop',                 //各区隐患情况排名
        map_data : baseinter + 'screen/areaDangerInfo',
        barn_data1: baseinter + 'screen/ratioDangerForCar',             //各分所驾驶员治理情况
        hide_dri: baseinter + 'screen/noticeDangerForDriver',           // 隐患驾驶员通报
        hide_car: baseinter + 'screen/noticeDangerForCar',              // 隐患机动车通报
        ratio_end: baseinter + 'screen/ratioDangerForDriver',           // 占比
        ratio_end1: baseinter + 'screen/deptDangerForDriver',           // 各分所机动车治理情况
        ratio_end2: baseinter + 'screen/deptDangerForCar',              // 各分所机动车治理情况
        end_cut_tab: baseinter + 'screen/findPlace',                    // 分所id
        all_dri: baseinter + 'screen/allDriver',                        // 全市驾驶员接口
        all_car: baseinter + 'screen/allCar',                           // 全市机动车接口
    },

    /**
     * 接口返回数据格式配置
     */
    ajax: {
        //  接口状态CODE
        STATE: {
            NAME: "result",
            SUCVAL: 0
        },
        // 接口状态信息
        MESSAGE: "msg",
        // 接口数据
        DATA: "data",
    },

    /**
     * 定时器
     */
    inter: {

    },

    /**
     * 图表通用配置
     */
    ecommon_option: {
        loading: {
            text: '加载中...',
            color: '#12dbff',
            textColor: '#12dbff',
            maskColor: 'rgba(0, 0, 0, 0.2)',
            zlevel: 1
        }
    }
};