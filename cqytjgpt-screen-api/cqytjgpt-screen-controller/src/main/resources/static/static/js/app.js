var app = new Vue({
    el: "#app",
    data: {
        all_data: {
            // data -- year
            data_year: [
                {
                    name: '月',
                    id: 1,
                    item: 'month'
                },
                {
                    name: '季',
                    id: 2,
                    item: 'season'
                },
                {
                    name: '年',
                    id: 3,
                    item: 'year'
                }
            ],
            ana_data: {
                sum_num: null,
                per_num: null
            },
            //    title obj
            title_item: [
                {
                    name: '全市隐患发现情况'
                },
                {
                    name: '隐患问题分布情况'
                },
                {
                    name: '治理成果分析'
                },
                {
                    name: '整治效果趋势分析'
                }
            ],
            //    left_data
            left_first: [
                {
                    name: '驾驶人隐患情况',
                    val1: '人',
                    val2: '个',
                    num1: (Math.random() * 1000).toFixed(0),
                    num2: (Math.random() * 1000).toFixed(0),
                    num3: (Math.random() * 1000).toFixed(0),
                    num4: (Math.random() * 1000).toFixed(0),
                    num5: (Math.random() * 1000).toFixed(0),
                    data:
                        {
                            name1: '一级预警：',
                            id1: '1',
                            name2: '二级预警：',
                            id2: '2',
                            name3: '三级预警：',
                            id3: '3'
                        }
                },
                {
                    name: '机动车隐患情况',
                    val1: '辆',
                    val2: '个',
                    num1: (Math.random() * 1000).toFixed(0),
                    num2: (Math.random() * 1000).toFixed(0),
                    num3: (Math.random() * 1000).toFixed(0),
                    num4: (Math.random() * 1000).toFixed(0),
                    num5: (Math.random() * 1000).toFixed(0),
                    data:
                        {
                            name1: '一级预警：',
                            id1: '1',
                            name2: '二级预警：',
                            id2: '2',
                            name3: '三级预警：',
                            id3: '3'
                        }
                },
                {
                    name: '企业隐患情况',
                    val1: '个',
                    val2: '个',
                    num1: (Math.random() * 1000).toFixed(0),
                    num2: (Math.random() * 1000).toFixed(0),
                    num3: (Math.random() * 1000).toFixed(0),
                    num4: (Math.random() * 1000).toFixed(0),
                    num5: (Math.random() * 1000).toFixed(0),
                    data:
                        {
                            name1: '一级预警：',
                            id1: '1',
                            name2: '二级预警：',
                            id2: '2',
                            name3: '三级预警：',
                            id3: '3'
                        }
                }
            ],
            left_second: [
                {
                    name: '约谈企业',
                    num1: '--',
                    num2: '--',
                },
                {
                    name: '处理机动车',
                    num1: '--',
                    num2: '--',
                },
                {
                    name: '处理驾驶人',
                    num1: '--',
                    num2: '--',
                }
            ],
            //    right
            r_title_item: [
                {
                    name: '各区县隐患占比'
                },
                {
                    name: '各分所治理情况同比'
                },
            ],
            //   dmv - data
            dmv_data: {
                show: false,
                tab_text: '车管所一分所',
                data: [
                    {
                        name: '车管所一分所',
                        id: '6183cb701b4a43d49a6e6b9aa105bc5b'
                    },
                    {
                        name: '车管所二分所',
                        id: '53fe582d817a45a2b32d70f85bd63aec'
                    },
                    {
                        name: '车管所三分所',
                        id: '704394bddf864a5fb7f91ce8bf8d3cd7'
                    },
                    {
                        name: '车管所四分所',
                        id: 'c5e6f2376f5b4a758c488378348d635c'
                    },
                    {
                        name: '车管所五分所',
                        id: '0704566c75634f34ab171ff8877acb47'
                    },
                    {
                        name: '车管所六分所',
                        id: 'a261b66014d8478bab0f88319302ba2d'
                    },
                    {
                        name: '车管所七分所',
                        id: '42438c77dde64d27a0fcce68706ae829'
                    },
                    {
                        name: '车管所八分所',
                        id: '392f7ec7c41c4a429cb744b5489c807e'
                    },
                    {
                        name: '车管所九分所',
                        id: 'd454d9ff55e84e398bd9f61cb151ad7c'
                    }
                ]
            },
            pro_data: {
                show: false,
                tab_text: '驾驶人',
                data: [
                    {
                        name: '全部'
                    },
                    {
                        name: '驾驶人'
                    },
                    {
                        name: '机动车'
                    },
                    {
                        name: '企业'
                    }
                ]
            },
            //   center-wrap-list
            center_data: {
                driver_title: '隐患驾驶员',
                driver_name: '--',
                driver_sex: '--',
                driver_num: '--',
                driver_yes1: '--',
                driver_yes2: '--',
                driver_yes3: '--',
                driver_no1: '--',
                driver_no2: '--',
                driver_warning: '--',
                vehicle_title: '隐患机动车',
                vehicle_name: '--',
                vehicle_car: '--',
                vehicle_cararea: '--',
                vehicle_yes: '--',
                vehicle_no1: '--',
                vehicle_no2: '--',
                vehicle_no3: '--',
                vehicle_no4: '--',
                vehicle_warning: '--',
                enter_title: '隐患企业',
                enter_name: '--',
                enter_enter: '--',
                enter_area: '--',
                enter_dmv: '--',
                enter_num1: '--',
                enter_num2: '--',
                enter_num3: '--',
                enter_yes: '--',
                enter_no: '--',
                enter_warning: '--',
                nav: {
                    driver: [
                        {
                            name: '--',
                            sex: '--',
                            num: '--',
                            yes1: '--',
                            yes2: '--',
                            yes3: '--',
                            no1: '--',
                            no2: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            sex: '--',
                            num: '--',
                            yes1: '--',
                            yes2: '--',
                            yes3: '--',
                            no1: '--',
                            no2: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            sex: '--',
                            num: '--',
                            yes1: '--',
                            yes2: '--',
                            yes3: '--',
                            no1: '--',
                            no2: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            sex: '--',
                            num: '--',
                            yes1: '--',
                            yes2: '--',
                            yes3: '--',
                            no1: '--',
                            no2: '--',
                            warning: '--'
                        }
                    ],
                    vehicle: [
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        },
                        {
                            name: '--',
                            car: '--',
                            cararea: '--',
                            yes: '--',
                            no1: '--',
                            no2: '--',
                            no3: '--',
                            no4: '--',
                            warning: '--'
                        }
                    ],
                    enter: [
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        },
                        {

                            name: '--',
                            enter: '--',
                            area: '--',
                            dmv: '--',
                            num1: '--',
                            num2: '--',
                            num3: '--',
                            yes: '--',
                            no: '--',
                            warning: '--'
                        }
                    ]
                }
            },
            // map_data
            map_data: {
                left_data: [
                    {
                        name: '全市接入驾驶员：',
                        unit: '名',
                        value: '--',
                        color: '#00ffa8'
                    },
                    {
                        name: '全市接入机动车：',
                        unit: '辆',
                        value: '--',
                        color: '#ff3c00'
                    },
                    {
                        name: '全市监管企业：',
                        unit: '家',
                        value: '--',
                        color: '#ffba00'
                    }
                ],
                cut_tab: [
                    {
                        name: '全部'
                    },
                    {
                        name: '驾驶人'
                    },
                    {
                        name: '机动车'
                    },
                    {
                        name: '企业'
                    }
                ]
            },
            // number-var
            number_var: {
                map_num: 0,
                left_l_num: 0,
                left_dit_num: 0,
                dit_click_num: 0,
                dvm_num: 0,
                hide_num: 0,
                hide_car_num: 0,
                hide_enter_num: 0,
                year_num: 0,
            },
            text_cut_box: {
                left_text: [
                    {
                        name: '驾驶人隐患问题类型',
                        color: '#00ff96'
                    },
                    {
                        name: '机动车隐患问题类型',
                        color: '#ff3600'
                    },
                    {
                        name: '企业类型分布情况',
                        color: '#ffc600'
                    }
                ],
                right_text: [
                    {
                        name: '驾驶员隐患占比',
                        color: '#00ff96'
                    },
                    {
                        name: '机动车隐患占比',
                        color: '#ff3600'
                    },
                    {
                        name: '企业隐患占比',
                        color: '#ffc600'
                    }
                ],
                no_text: [
                    {
                        name: '驾驶人隐患问题类型',
                        color: '#00ff96'
                    },
                    {
                        name: '机动车隐患问题类型',
                        color: '#ff3600'
                    },
                    {
                        name: '企业类型分布情况',
                        color: '#ffc600'
                    }
                ]
            },
            cut_text: {
                left_text_title: '隐患问题分布情况',
                right_text_title: '各区县隐患占比',
                no_text: '隐患问题分布情况',
                right_bar_1: '各区县隐患情况排名',
                right_bar_2: '各区县治理情况排名',
                no_right_bar: '各区县隐患情况排名',
            },
            //全市隐患发现情况
            whole_data_box: {
                level: '',
                all_data: [],
                pro_data: [],
                car_data: [],

            }
        },
        /**
         * 接口数据库
         *
         */
        post_data: {
            hide_post1: '',
            hide_post2: '',
            number_box: {
                line_bar_num1: 1,
                hide_dir: 0,
                hide_car: 0,
            }
        },
        // cut-variable
        cut_var: {
            cut_dmv: false,
            cut_pro: false,
            left_pie: false,
            right_bar: false,
            label_p_r: true,
            label_c_r: true,
            label_e_r: true,
            no_bar_data: false,
            no_pie_data: false
        },
        // 定时器
        timer_box: {
            left_hide_timer: null,
            left_timer: null,
            left_pop_timer: null,
            auto_peopel: null,
            auto_car: null,
            auto_enter: null,
            peo_timer: null,
            car_timer: null,
            enter_timer: null
        },
        //   实例对象
        obj_: {
            left: {
                left_pie1: null,                            //驾驶人隐患问题类型---pie1
                left_pie2: null,                            //机动车隐患问题类型---pie2
                left_pie3: null,                            //企业类型分布情况---pie3
                big_left_pie1: null,                        //驾驶人隐患问题类型---big-pie1
                big_left_pie2: null,                        //机动车隐患问题类型---big-pie2
                big_left_pie3: null,                        //企业类型分布情况---big-pie3
                left_end_line: null,                        //整治效果趋势---line
            },
            right: {
                right_bar1: null,                          //各区县隐患---bar1
                right_bar2: null,                          //各区县治安---bar2
                big_right_bar1: null,                      //各区县隐患---big-bar1
                big_right_bar2: null,                      //各区县治安---big-bar2
                right_pie1: null,                           //驾驶员隐患占比---pie1
                right_pie2: null,                           //机动车隐患占比---pie2
                right_pie3: null,                           //企业隐患占比---pie3
                big_right_pie1: null,                       //驾驶员隐患占比---big-pie1
                big_right_pie2: null,                       //机动车隐患占比---big-pie2
                big_right_pie3: null,                       //企业隐患占比---big-pie3
                right_end_sum: null,                        //各分所治理情况---line
            },
            map: null                                       //地图 -- map
        }
    },
    mounted: function () {
        App = DperV('app');
        // console.info(App.views)
        var _self = this;
        _self.$nextTick(function () {
            _self.$el.className = "cq-road-content dper-show";
            _self.all_echarts_data();
            // 全市隐患发现情况 -- 数据滚动
            _self.all_data_hide();
            _self.all_data_hide2();
            _self.enter_data();
            /**
             * 全市数据接入数
             */
            _self.all_dri_post();
            _self.all_car_post();
            // _self.hide_problem();
            /**
             * 治理成果接口调用
             * @param callback
             */
            _self.analy_data(function (a, b) {
                _self.analy_data2(a, b);
            });
            /**
             * 整治成果调用
             */
            _self.line_data_post();
            /**
             * 隐患问题分布 接口调用
             */
            // _self.sum_data();
            _self.hide_problem();
            //
            /**
             * 隐患问题分布 接口调用
             */
            _self.post_hide_car();
            /**
             * 各区隐患排名
             */
            _self.bar_hide_post();
            /**
             * 各区隐患占比
             */
            _self.other_area_post();
            /**
             * 各分所接口
             */
            // _self.barn_office_post();
            _self.end_echart_post(_self.post_data.number_box.line_bar_num1);
            _self.end_cut_tab_post();
            /**
             * 隐患大户
             * @type {string}
             */
            // 驾驶人
            _self.hide_dri_post(function (value) {
                _self.post_data.number_box.hide_dir = value
            });
            // 机动车
            _self.hide_car_post(function (value) {
                _self.post_data.number_box.hide_car = value
            });
            // 年月日默认添加事件
            _self.$refs.year[0].className = 'cut-year public-cursor active-year';
            _self.timer_box.left_hide_timer = setInterval(function(){
                /**
                 * echarts -- 接口调用
                 */
                _self.all_echarts_data();
                /**
                 * 全市隐患发现情况 -- 数据滚动
                 */
                _self.all_data_hide();
                _self.all_data_hide2();
                _self.enter_data();
                /**
                 * 全市数据接入数
                 */
                _self.all_dri_post();
                _self.all_car_post();
                // _self.hide_problem();
                /**
                 * 治理成果接口调用
                 * @param callback
                 */
                _self.analy_data(function (a, b) {
                    _self.analy_data2(a, b);
                });
                /**
                 * 整治成果调用
                 */
                _self.line_data_post();
                /**
                 * 隐患问题分布 接口调用
                 */
                // _self.sum_data();
                _self.hide_problem();
                //
                _self.post_hide_car();
                _self.bar_hide_post();
                /**
                 * 各区隐患占比
                 */
                _self.other_area_post()
                /**
                 * 各分所接口
                 */
                _self.end_echart_post(_self.post_data.number_box.line_bar_num1);
                _self.end_cut_tab_post();
                // 驾驶人
                _self.hide_dri_post(function (value) {
                    _self.post_data.number_box.hide_dir = value
                });
                // 机动车
                _self.hide_car_post(function (value) {
                    _self.post_data.number_box.hide_car = value
                });
                // 隐患大户信息--隐患驾驶员 自动切换
                _self.auto_center_peopel();
                _self.auto_center_car();
                _self.auto_center_enter();
            }, 60000);
            // setInterval(_self.all_echarts_data, 8000);
            // _self.all_echarts_data()
            // 隐患大户信息--隐患驾驶员 自动切换
            _self.auto_center_peopel();
            _self.auto_center_car();
            _self.auto_center_enter();
            // _self.$refs.name[_self.all_data.number_var.map_num].className = "align-center background-img-full active text-overflow-e";
        })
    },
    methods: {
        /**
         * year click
         * @param item
         * @param num
         */
        year_click: function (item, num) {
            // console.info(item);
            var _self = this;
            _self.$refs.year[_self.all_data.number_var.year_num].className = 'cut-year public-cursor';
            _self.$refs.year[num].className = 'cut-year public-cursor active-year';
            _self.all_data.number_var.year_num = num;
            console.info(num)
            console.log(_self.all_data.data_year[num].item);
            var data = {date: _self.all_data.data_year[num].item};
            $.ajax({
                url: config.interface.pie_dri,
                type: 'POST',
                data: JSON.stringify(data),
                datType: 'JSON',
                contentType: "application/json",
                success: function (res) {
                    console.info(res)
                    _self.obj_.left.left_pie1.left_pie_1(res.data);
                },
                error: function () {
                }
            });
            $.ajax({
                url: config.interface.pie_dri2,
                type: 'POST',
                data: JSON.stringify(data),
                datType: 'JSON',
                contentType: "application/json",
                success: function (res) {
                    _self.obj_.left.left_pie2.left_pie_2(res.data);
                },
                error: function () {
                }
            });
        },
        /**
         * 全市隐患发现情况接口调用
         */
        all_data_hide: function () {
            var _self = this;
            $.ajax({
                url: config.interface.whole_dri,
                type: 'POST',
                data: '',
                success: function (res) {
                    for (var i = 0; i < res.data.warnList.length; i++) {
                        // console.log(res.data.warnList[0]);
                        if (res.data.warnList[i].dangerType == '1') {
                            new NumAnimate(_self.$refs.number[2], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[2].innerText = '--'
                            }
                        }
                        if (res.data.warnList[i].dangerType == '2') {
                            new NumAnimate(_self.$refs.number[3], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[3].innerText = '--'
                            }
                        }
                        if (res.data.warnList[i].dangerType == '3') {
                            new NumAnimate(_self.$refs.number[4], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[4].innerText = '--'
                            }
                        }
                    }
                    for (var e = 0; e < _self.$refs.number.length; e++) {
                        if (_self.$refs.number[e].innerHTML == '' || _self.$refs.number[e].innerHTML == 0) {
                            _self.$refs.number[e].innerText = '--'
                        }
                    }
                    new NumAnimate(_self.$refs.number[0], res.data.findNum, '', 0).init();
                    new NumAnimate(_self.$refs.number[1], res.data.intoNum, '', 0).init();
                    // _self.all_data.whole_data_box.all_data.push(res.data);

                },
                error: function () {
                    _self.$refs.number[0].innerText = '--';
                    _self.$refs.number[1].innerText = '--';
                    _self.$refs.number[2].innerText = '--';
                    _self.$refs.number[3].innerText = '--';
                    _self.$refs.number[4].innerText = '--';
                }
            });
        },
        // 机动车查询
        all_data_hide2: function () {
            var _self = this;
            $.ajax({
                url: config.interface.whole_car,
                type: 'POST',
                data: '',
                success: function (res) {
                    for (var i = 0; i < res.data.warnList.length; i++) {
                        if (res.data.warnList[i].dangerType == '1') {
                            new NumAnimate(_self.$refs.number[7], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[7].innerText = '--'
                            }
                        }
                        if (res.data.warnList[i].dangerType == '2') {
                            new NumAnimate(_self.$refs.number[8], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[8].innerText = '--'
                            }
                        }
                        if (res.data.warnList[i].dangerType == '3') {
                            new NumAnimate(_self.$refs.number[9], res.data.warnList[i].warnNum, '', 0).init();
                            if (res.data.warnList[i].warnNum == 0) {
                                _self.$refs.number[8].innerText = '--'
                            }
                        }
                    }
                    if(res.data.intoNum == 0 ){
                        _self.$refs.number[5].innerText = '--'
                    }else{
                        new NumAnimate(_self.$refs.number[5], res.data.intoNum, '', 0).init();
                    }
                    if(res.data.findNum == 0 ){
                        _self.$refs.number[6].innerText = '--'
                    }else{
                        new NumAnimate(_self.$refs.number[6], res.data.findNum, '', 0).init();
                    }
                },
                error: function () {
                    _self.$refs.number[5].innerText = '--';
                    _self.$refs.number[6].innerText = '--';
                    _self.$refs.number[7].innerText = '--';
                    _self.$refs.number[8].innerText = '--';
                    _self.$refs.number[9].innerText = '--';
                }
            });
        },
        // 企业
        enter_data: function () {
            var _self = this;
            _self.$refs.number[10].innerText = '--';
            _self.$refs.number[11].innerText = '--';
            _self.$refs.number[12].innerText = '--';
            _self.$refs.number[13].innerText = '--';
            _self.$refs.number[14].innerText = '--';
        },
        /**
         * 全市驾驶员接入数
         */
        all_dri_post: function () {
            var _self = this;
            $.ajax({
                url: config.interface.all_dri,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info(res.data.allDriver)
                    if (res.data.allDriver == 0) {
                        _self.$refs.centerNumber[0].innerText = '--';
                    }
                    _self.$refs.centerNumber[0].innerText = res.data.allDriver;
                    _self.$refs.centerNumber[2].innerText = '--';
                },
                error: function () {
                    _self.$refs.centerNumber[0].innerText = '--';
                    _self.$refs.centerNumber[2].innerText = '--';
                }

            })
        },
        /**
         * 全市机动车接入数
         */
        all_car_post: function () {
            var _self = this;
            $.ajax({
                url: config.interface.all_car,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info()
                    if (res.data.allCar == 0) {
                        _self.$refs.centerNumber[1].innerText = '--';
                    }
                    _self.$refs.centerNumber[1].innerText = res.data.allCar;
                },
                error: function () {
                    _self.$refs.centerNumber[1].innerText = '--';
                    _self.$refs.centerNumber[2].innerText = '--';
                }

            })
        },
        /**
         * 隐患问题分布 默认显示
         */
        hide_problem: function () {
            var _self = this;
            var data = {date: "month"};
            $.ajax({
                url: config.interface.pie_dri,
                type: 'POST',
                data: JSON.stringify(data),
                datType: 'JSON',
                contentType: "application/json",
                // consumes: "application/json",
                success: function (res) {
                    App.state("echats-pie0", 2);
                    _self.obj_.left.left_pie1.left_pie_1(res.data);
                },
                error: function () {
                }
            });
        },
        post_hide_car: function () {
            var _self = this;
            var data = {date: "month"};
            $.ajax({
                url: config.interface.pie_dri2,
                type: 'POST',
                data: JSON.stringify(data),
                datType: 'JSON',
                contentType: "application/json",
                // consumes: "application/json",
                success: function (res) {
                    // _self.obj_.left.left_pie1.left_pie_1(res.data);
                    App.state("echats-pie1", 2);
                    _self.obj_.left.left_pie2.left_pie_2(res.data);
                    // console.info(res)
                },
                error: function () {
                }
            });
        },
        /**
         * 治理成果接口调用
         * @param callback
         */
        analy_data: function (callback) {
            var _self = this;
            $.ajax({
                url: config.interface.ana_data,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info(res)
                    _self.all_data.left_second[0].num1 = '--';
                    _self.all_data.left_second[0].num2 = '--';
                    if (res.data.handleDriver == 0) {
                        // res.data.handleDriver == '--';
                        _self.all_data.left_second[1].num1 = '--';
                    } else {

                        _self.all_data.left_second[1].num1 = res.data.handleDriver;
                    }
                    _self.all_data.left_second[1].num2 = res.data.noHandleDriver;
                    _self.$refs.full[0].style.width = 0 + 'px';
                    _self.$refs.full[1].style.width = res.data.handleDriver / res.data.noHandleDriver * _self.$refs.father[0].offsetWidth + 'px'
                    callback(res.data.handleDriver, res.data.noHandleDriver);
                },
                error: function () {
                    _self.all_data.left_second[0].num1 = '--';
                    _self.all_data.left_second[0].num2 = '--';
                    _self.all_data.left_second[1].num1 = '--';
                    _self.all_data.left_second[1].num2 = '--';
                    _self.all_data.left_second[2].num1 = '--';
                    _self.all_data.left_second[2].num2 = '--';
                    _self.$refs.full[0].style.width = 0 + 'px';
                    _self.$refs.full[1].style.width = 0 + 'px';
                    _self.$refs.full[2].style.width = 0 + 'px';
                }
            });
        },
        analy_data2: function (a, b) {
            var _self = this;
            $.ajax({
                url: config.interface.ana_data2,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info(res)
                    if (res.data.handleCar == 0) {
                        // res.data.handleDriver == '--';
                        _self.all_data.left_second[2].num1 = '--';
                    } else {
                        _self.all_data.left_second[2].num1 = res.data.handleCar;
                    }
                    _self.all_data.left_second[2].num2 = res.data.noHandleCar;
                    _self.$refs.full[2].style.width = res.data.handleCar / res.data.noHandleCar * _self.$refs.father[0].offsetWidth + 'px'
                    // callback(a,b,res.data.handleCar,res.data.noHandleCar)
                    // console.info(a,b)
                    _self.all_data.ana_data.sum_num = res.data.handleCar + a;
                    // console.log(_self.all_data.ana_data.sum_num);
                    _self.all_data.ana_data.per_num = ((_self.all_data.ana_data.sum_num) / (res.data.noHandleCar + b)).toFixed(0)
                    // console.log(_self.all_data.ana_data.per_num);
                    if (_self.all_data.ana_data.per_num == '0' || _self.all_data.ana_data.per_num == 0) {
                        _self.all_data.ana_data.per_num = '--'
                    }
                },
                error: function () {
                    _self.all_data.left_second[2].num1 = '--';
                    _self.all_data.left_second[2].num2 = '--';
                }
            });
        },
        /**
         * 整治效果趋势
         */
        line_data_post: function () {
            var _self = this;

            function one_line(callback) { // 驾驶人
                $.ajax({
                    url: config.interface.line_data,
                    type: 'POST',
                    data: '',
                    success: function (res) {
                        callback(res.data)
                    },
                    error: function () {
                    }
                });
            };
            one_line(function (item) {
                $.ajax({
                    url: config.interface.line_data1, // 机动车
                    type: 'POST',
                    data: '',
                    success: function (res) {
                        App.state("left-line", 2);
                        _self.obj_.left.left_end_line.left_line(item, res.data);
                    },
                    error: function () {
                    }
                });
            })

        },
        /**
         * 各区隐患排名
         */
        bar_hide_post: function () {
            var _self = this;
            $.ajax({
                url: config.interface.bar_data1,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info(res)
                    App.state("right-bar-one", 2);
                    _self.obj_.right.right_bar1.right_bar_one(res.data);
                },
                error: function () {
                }
            });
        },
        /**
         * 各区隐患占比
         */
        other_area_post: function () {
            var _self = this;
            $.ajax({
                url: config.interface.bar_data1,
                type: 'POST',
                data: '',
                success: function (res) {
                    // console.info(res)
                    App.state("r-pie0", 2);
                    _self.obj_.right.right_pie1.right_pie_1(res.data);
                    App.state("r-pie1", 2);
                    _self.obj_.right.right_pie2.right_pie_2(res.data);
                    App.state("r-pie2", 2);
                    _self.obj_.right.right_pie3.right_pie_3(res.data);
                },
                error: function () {
                }
            });
        },
        /**
         *隐患大户信息通报
         */
        //驾驶员
        hide_dri_post: function (callback) {
            var _self = this;
            _self.post_data.hide_post1 = {top: _self.all_data.number_var.hide_num};
            $.ajax({
                url: config.interface.hide_dri,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post1),
                contentType: 'application/json',
                success: function (res) {
                    _self.all_data.center_data.driver_name = res.data.drivername;
                    _self.all_data.center_data.driver_sex = '--';
                    _self.all_data.center_data.driver_num = res.data.driveridcard;
                    _self.all_data.center_data.driver_yes1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.driver_yes2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.driver_yes3 = _self.yes_box(res.data.overdueproofstate);
                    _self.all_data.center_data.driver_no1 = _self.yes_box(res.data.fullstudystate);
                    _self.all_data.center_data.driver_no2 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.driver_warning = _self.level_box(res.data.dangertype);
                    callback(res.data.totalnum)
                },
                error: function () {
                }
            });
        },
        // 机动车
        hide_car_post: function (callback) {
            var _self = this;
            _self.post_data.hide_post2 = {top: 0};
            $.ajax({
                url: config.interface.hide_car,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post2),
                contentType: 'application/json',
                success: function (res) {
                    _self.all_data.center_data.vehicle_name = res.data.vehino;
                    _self.all_data.center_data.vehicle_car = _self.car_big(res.data.vehitype);
                    _self.all_data.center_data.vehicle_cararea = _self.level_box(res.data.ownerenterprise);
                    _self.all_data.center_data.vehicle_yes = _self.yes_box(res.data.scrappedstate);
                    _self.all_data.center_data.vehicle_no1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.vehicle_no2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.vehicle_no3 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.vehicle_warning = _self.level_box(res.data.dangertype);
                    callback(res.data.totalnum)
                },
                error: function () {
                    _self.all_data.center_data.vehicle_name = '--';
                    _self.all_data.center_data.vehicle_car = '--';
                    _self.all_data.center_data.vehicle_cararea = '--';
                    _self.all_data.center_data.vehicle_yes = '--';
                    _self.all_data.center_data.vehicle_no1 = '--';
                    _self.all_data.center_data.vehicle_no2 = '--';
                    _self.all_data.center_data.vehicle_no3 = '--';
                    _self.all_data.center_data.vehicle_warning = '--';
                }
            });
        },
        /**
         * 各分所接口调用
         */
        // 分所名字
        end_cut_tab_post: function () {
            var _self = this;
            $.ajax({
                url: config.interface.end_cut_tab,
                type: 'POST',
                data: '',
                success: function (res) {
                    for (var i = 0; i < res.data.length; i++) {
                        _self.all_data.dmv_data.data[i].id = res.data[i].id
                    }
                },
                error: function () {
                }
            });
        },
        //分所数据调用
        end_echart_post: function (num) {
            var _self = this;
            var data = {orgId: _self.all_data.dmv_data.data[_self.all_data.number_var.dvm_num].id};
            if (num == 0) {// 0 全部
                function one(callback) {
                    $.ajax({
                        url: config.interface.ratio_end1,
                        type: 'POST',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function (res) {
                            // console.info(res)
                            App.state("end-bar", 2);
                            // _self.obj_.right.left_pie1.right_line(res.data);
                            callback(res.data)
                        },
                        error: function () {
                        }
                    });
                }

                one(function (item) {
                    $.ajax({
                        url: config.interface.ratio_end2,
                        type: 'POST',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function (res) {
                            for (var i = 0; i < item['本月'].length; i++) {
                                res.data['本月'][i].driverDangers += item['本月'][i].driverDangers;
                                res.data['上月'][i].driverDangers += item['上月'][i].driverDangers;
                            }
                            App.state("end-bar", 2);
                            _self.obj_.right.left_pie1.right_line(res.data);
                        },
                        error: function () {
                        }
                    });
                });
            }
            if (num == 1) { // 1 驾驶员
                $.ajax({
                    url: config.interface.ratio_end1,
                    type: 'POST',
                    data: JSON.stringify(data),
                    contentType: 'application/json',
                    success: function (res) {
                        // console.info(res)
                        App.state("end-bar", 2);
                        _self.obj_.right.left_pie1.right_line(res.data);
                    },
                    error: function () {
                    }
                });
            }
            if (num == 2) { // 2 机动车
                $.ajax({
                    url: config.interface.ratio_end2,
                    type: 'POST',
                    data: JSON.stringify(data),
                    contentType: 'application/json',
                    success: function (res) {
                        App.state("end-bar", 2);
                        _self.obj_.right.left_pie1.right_line(res.data);
                        // console.info(res)
                        // App.state("end-bar", 2);
                        // _self.obj_.right.left_pie1.right_line(res.data, );
                    },
                    error: function () {
                    }
                });
            }

        },
        //    车管所tab点击文字切换事件
        dmv_tab: function (item, num) {
            var _self = this;
            _self.all_data.dmv_data.show = false;
            _self.all_data.dmv_data.tab_text = item.name;
            // _self.all_data.dmv_car_data[num];
            // _self.obj_.right.left_pie1.right_line(_self.all_data.dmv_car_data[num], _self.all_data.dmv_car_val[num]);
            _self.all_data.number_var.dvm_num = num;
            _self.end_echart_post(_self.post_data.number_box.line_bar_num1);
        },
        //驾驶人下拉菜单文字切换事件
        cut_por: function (item, num) {
            var _self = this;
            _self.end_echart_post(num);
            _self.all_data.pro_data.show = false;
            _self.all_data.pro_data.tab_text = item.name;
            // _self.obj_.right.left_pie1.right_line(_self.all_data.dmv_car_data[_self.all_data.number_var.dvm_num], _self.all_data.dmv_people[num][_self.all_data.number_var.dvm_num]);

        },
        /**
         *  过滤数据
         */
        filtrer_empty: function (val) {
            return isEmpty(val) ? "--" : val;
        },

        //滚动监听事件
        handleScroll: function () {
            var _self = this;
            var all_height = _self.$refs.scroll.children[0].clientHeight;
            var f_height = _self.$refs.scroll.clientHeight;
            var poor = all_height - f_height;
            if (_self.$refs.scroll.scrollTop > (poor - 1)) {
                console.log(_self.$refs.imgicon.style.backgroundImage);
                _self.$refs.imgicon.style.backgroundImage = null;
            }
        },
        // 绑定监听事件
        Scrollbinld: function () {
            var _self = this;
            _self.$refs.scroll.addEventListener('scroll', _self.handleScroll);
        },
        all_echarts_data: function () {
            var _self = this;
            var arr = [{value: 0, name: '无数据'}];
            _self.obj_.left.left_pie1 = new EchartsPie1(App.getView('echats-pie0'), '驾驶人隐患问题类型');

            _self.obj_.left.left_pie2 = new EchartsPie2(App.getView('echats-pie1'), '机动车隐患问题类型');

            // App.state("echats-pie1", 2);
            _self.obj_.left.left_pie3 = new EchartsPie3(App.getView('echats-pie2'), '企业类型分布情况');

            App.state("echats-pie2", 2);
            _self.obj_.left.left_pie3.left_pie_3(arr);

            _self.obj_.left.left_end_line = new EchartsLeftLine(App.getView('left-line'), '整治效果趋势分析');
            // App.state("left-line", 1);

            /**
             * 右边
             * @type {EchartsPie1}
             */
            _self.obj_.right.right_bar1 = new EchartsRBar1(App.getView('right-bar-one'), '各区县隐患');

            _self.obj_.right.right_bar2 = new EchartsRBar2(App.getView('right-bar-two'), '各区县治安');
            // App.state("right-bar-two", 1);
            setTimeout(function () {
                if (false) {
                    App.state("right-bar-two", 0, "暂时没有数据～～");
                    return;
                }
                App.state("right-bar-two", 0, '暂时没有数据~~');
                // _self.obj_.right.right_bar2.right_bar_two();
            }, 3000);

            //各区县隐患占比
            _self.obj_.right.right_pie1 = new EchartsRPie1(App.getView('r-pie0'), '驾驶员隐患占比');
            _self.obj_.right.right_pie2 = new EchartsRPie2(App.getView('r-pie1'), '机动车隐患占比');
            _self.obj_.right.right_pie3 = new EchartsRPie3(App.getView('r-pie2'), '企业隐患占比');

            //各分所
            _self.obj_.right.left_pie1 = new EchartsRline(App.getView('end-bar'), '各分所治理情况');


            window.onresize = function () {

            }
        },
        // 左边pie弹框
        left_pop: function () {
            var _self = this;
            _self.public_width();
            var arr = [{value: 0, name: '无数据'}];
            /**
             *  left 弹框
             */
            _self.obj_.left.big_left_pie1 = new EchartsPie4('leftpie0', '驾驶人隐患问题类型');
            // _self.obj_.left.big_left_pie1.left_pie_4();
            _self.obj_.left.big_left_pie2 = new EchartsPie5('leftpie1', '机动车隐患问题类型');
            // _self.obj_.left.big_left_pie2.left_pie_5();
            _self.obj_.left.big_left_pie3 = new EchartsPie6('leftpie2', '企业类型分布情况');
            _self.obj_.left.big_left_pie3.left_pie_6(arr);

        },
        // 右边bar弹框
        right_pop: function () {
            var _self = this;
            /**
             * 弹框
             * @type {EchartsRPie4}
             */
            _self.obj_.right.big_right_bar1 = new EchartsRBar3('right-bar', '各区县隐患');
        },
        // 右边bar弹框
        right_pop_bar: function () {
            var _self = this;
            _self.obj_.right.big_right_bar2 = new EchartsRBar4('right-bar', '各区县治安');
            // _self.obj_.right.big_right_bar2.right_bar_4();
        },
        // 右边pie弹框
        right_pop_pie: function () {
            var _self = this;
            _self.public_width();
            /**
             * 弹框
             * @type {EchartsRPie4}
             */
            _self.obj_.right.big_right_pie1 = new EchartsRPie4('leftpie0', '驾驶员隐患占比');
            _self.obj_.right.big_right_pie2 = new EchartsRPie5('leftpie1', '机动车隐患占比');
            _self.obj_.right.big_right_pie3 = new EchartsRPie6('leftpie2', '企业隐患占比');
        },
        // 宽度设置
        public_width: function () {
            var _self = this;
            var h = _self.$refs.leftEBox.clientWidth;
            for (var i = 0; i < _self.$refs.leftE.length; i++) {
                _self.$refs.leftE[i].style.width = h + 'px';
            }
            _self.$refs.leftF.style.width = h * _self.$refs.leftE.length + 'px';
        },
        //隐患问题分布情况 --- 切换按钮
        //饼图弹框 左边按钮 切换事件
        left_cut_btn: function () {
            var _self = this;
            var h = _self.$refs.leftEBox.clientWidth;
            _self.all_data.number_var.left_l_num--;
            if (_self.all_data.number_var.left_l_num <= -1) {
                _self.all_data.number_var.left_l_num = _self.$refs.leftE.length - 1
            }
            _self.$refs.leftF.style.marginLeft = -h * _self.all_data.number_var.left_l_num + 'px';
            _self.$refs.popDit[_self.all_data.number_var.left_dit_num].className = 'public-bl-dit';
            _self.$refs.popDit[_self.all_data.number_var.left_l_num].className = 'active public-bl-dit';
            _self.all_data.number_var.left_dit_num = _self.all_data.number_var.left_l_num;
        },
        // 饼图弹框 右边按钮 切换事件
        right_cut_btn: function () {
            var _self = this;
            var h = _self.$refs.leftEBox.clientWidth;
            _self.all_data.number_var.left_l_num++;
            if (_self.all_data.number_var.left_l_num >= _self.$refs.leftE.length) {
                _self.all_data.number_var.left_l_num = 0
            }
            if(_self.all_data.number_var.left_l_num > 1){
                _self.$refs.pop[1].innerText = ''
            }
            if(_self.all_data.number_var.left_l_num > 0){
                _self.$refs.pop[0].innerText = ''
            }
            _self.$refs.leftF.style.marginLeft = -h * _self.all_data.number_var.left_l_num + 'px';
            _self.$refs.popDit[_self.all_data.number_var.left_dit_num].className = 'public-bl-dit';
            _self.$refs.popDit[_self.all_data.number_var.left_l_num].className = 'active public-bl-dit';
            _self.all_data.number_var.left_dit_num = _self.all_data.number_var.left_l_num;

        },
        //饼图弹框自动切换事件
        auto_left_btn: function () {
            var _self = this;
            _self.timer_box.left_timer = setInterval(function () {
                _self.right_cut_btn();
            }, 3000)
        },
        // 饼图弹框鼠标移入清除自动切换事件
        auto_left_clear: function () {
            var _self = this;
            clearInterval(_self.timer_box.left_timer)
        },
        // 饼图弹框鼠标移出自动切换事件
        auto_left_continue: function () {
            var _self = this;
            _self.auto_left_btn();
        },
        // 饼图弹框弹出事件
        left_amp_click: function (num) {
            var _self = this;
            var right = _self.all_data.text_cut_box.right_text;
            _self.all_data.text_cut_box.left_text = null;
            _self.all_data.text_cut_box.left_text = null;
            if (num == false) {
                // console.info(_self.all_data.number_var.year_num)
                var data = {date: _self.all_data.data_year[_self.all_data.number_var.year_num].item};
                setTimeout(function () {
                    $.ajax({
                        url: config.interface.pie_dri,
                        type: 'POST',
                        data: JSON.stringify(data),
                        datType: 'JSON',
                        contentType: "application/json",
                        success: function (res) {
                            _self.obj_.left.big_left_pie1.left_pie_4(res.data);
                        },
                        error: function () {
                            _self.cut_var.no_pie_data = true
                        }
                    });
                    $.ajax({
                        url: config.interface.pie_dri2,
                        type: 'POST',
                        data: JSON.stringify(data),
                        datType: 'JSON',
                        contentType: "application/json",
                        success: function (res) {
                            _self.obj_.left.big_left_pie2.left_pie_5(res.data);
                        },
                        error: function () {
                        }
                    });
                }, 600);
                setTimeout(_self.left_pop, 300);
                _self.cut_var.left_pie = true;
                _self.all_data.text_cut_box.left_text = _self.all_data.text_cut_box.no_text;
                _self.all_data.cut_text.left_text_title = _self.all_data.cut_text.no_text;
                _self.timer_box.left_pop_timer = setInterval(_self.left_pop, 8000);
                _self.auto_left_btn();
            } else if (num == true) {
                _self.cut_var.left_pie = true;
                _self.all_data.cut_text.left_text_title = _self.all_data.cut_text.right_text_title;
                _self.all_data.text_cut_box.left_text = right;
                setTimeout(function () {
                    $.ajax({
                        url: config.interface.bar_data1,
                        type: 'POST',
                        data: '',
                        success: function (res) {
                            _self.obj_.right.big_right_pie1.right_pie_4(res.data);
                            _self.obj_.right.big_right_pie2.right_pie_5(res.data);
                            _self.obj_.right.big_right_pie3.right_pie_6(res.data);
                            /**
                             * 点击显示数据--中间显示
                             */
                            _self.obj_.right.big_right_pie2.myChart.on('mouseover',function(item){
                                _self.$refs.pop[1].innerText = item.name + ':'+item.value +'%';
                            })
                            _self.obj_.right.big_right_pie1.myChart.on('mouseover',function(item){
                                _self.$refs.pop[0].innerText = item.name + ':'+item.value + '%';
                            })
                        },



                        error: function () {
                            _self.cut_var.no_pie_data = true
                        }
                    });
                }, 300);
                setTimeout(_self.right_pop_pie, 200);
                // _self.timer_box.left_pop_timer = setInterval(_self.right_pop_pie, 8000);
                _self.auto_left_btn();
            }
        },
        // 饼图弹框关闭事件
        left_shut_down: function () {
            var _self = this;
            clearInterval(_self.timer_box.left_timer);
            clearInterval(_self.timer_box.left_pop_timer);
            for (var i = 0; i < _self.$refs.leftE.length; i++) {
                _self.$refs.popDit[i].className = 'public-bl-dit';
                _self.clear_father_child(_self.$refs.popDit[i]);
            }
            // _self.all_echarts_data();
            _self.cut_var.left_pie = false;
            _self.all_data.number_var.left_dit_num = 0;
            _self.all_data.number_var.left_dit_num = 0;
            _self.all_data.number_var.left_l_num = 0;
            _self.cut_var.no_pie_data = false
        },
        // 饼图弹框点的点击切换事件
        dit_click: function (item) {
            var _self = this;
            var h = _self.$refs.leftEBox.clientWidth;
            _self.$refs.popDit[_self.all_data.number_var.left_dit_num].className = 'public-bl-dit';
            _self.$refs.popDit[item].className = 'active public-bl-dit';
            _self.$refs.leftF.style.marginLeft = -h * item + 'px';
            _self.all_data.number_var.left_dit_num = item;
            _self.all_data.number_var.left_l_num = item;
            // console.info(item)
            if(item == 2 || item == 0){
                _self.$refs.pop[1].innerText = ' '
            }
            if(item == 1 || item == 2){
                _self.$refs.pop[0].innerText = ' '
            }
        },
        /**
         * 各区县隐患情况排名 放大点击事件
         */

        bar_click: function (num) {
            var _self = this;
            if (num == false) {
                _self.all_data.cut_text.right_bar_1 = _self.all_data.cut_text.no_right_bar;
                _self.cut_var.right_bar = true;
                setTimeout(function () {
                    $.ajax({
                        url: config.interface.bar_data1,
                        type: 'POST',
                        data: '',
                        success: function (res) {
                            // console.info(res)
                            // App.state("right-bar-one", 2);
                            _self.cut_var.no_bar_data = false;
                            _self.obj_.right.big_right_bar1.right_bar_3(res.data);
                        },
                        error: function () {
                        }
                    });
                }, 400);
                setTimeout(_self.right_pop, 300);
            } else if (num == true) {
                _self.cut_var.right_bar = true;
                _self.cut_var.no_bar_data = true;
                _self.all_data.cut_text.right_bar_1 = _self.all_data.cut_text.right_bar_2;
                setTimeout(_self.right_pop_bar, 300);
            }
        },
        pop_bar_shut: function () {
            var _self = this;
            _self.clear_father_child(_self.$refs.bar);
            _self.cut_var.right_bar = false;
        },
        //清除父分本子元素
        clear_father_child: function (dom) {
            if (dom.hasChildNodes()) {
                dom.removeChild(dom.firstChild);
            }
        },
        /**
         * 隐患大户 事件
         */
        // 隐患驾驶员 -- 点击事件
        hide_peopel_left: function () {
            var _self = this;
            _self.all_data.number_var.hide_num--;
            if (_self.all_data.number_var.hide_num < 0) {
                _self.all_data.number_var.hide_num = _self.post_data.number_box.hide_dir - 1;
            }
            _self.cut_var.label_p_r = false;
            _self.timer_box.peo_timer = setTimeout(function () {
                _self.cut_var.label_p_r = true;
            }, 500);

            _self.post_data.hide_post1 = {top: _self.all_data.number_var.hide_num};
            $.ajax({
                url: config.interface.hide_dri,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post1),
                contentType: 'application/json',
                success: function (res) {
                    // _self.all_data.center_data.driver_name = res.data.drivername;
                    _self.all_data.center_data.driver_sex = '--';
                    _self.all_data.center_data.driver_num = res.data.driveridcard;
                    _self.all_data.center_data.driver_yes1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.driver_yes2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.driver_yes3 = _self.yes_box(res.data.overdueproofstate);
                    _self.all_data.center_data.driver_no1 = _self.yes_box(res.data.fullstudystate);
                    _self.all_data.center_data.driver_no2 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.driver_warning = _self.level_box(res.data.dangertype);
                },
                error: function () {
                }
            });
        },
        hide_peopel_right: function () {
            var _self = this;
            _self.all_data.number_var.hide_num++;
            if (_self.all_data.number_var.hide_num > _self.post_data.number_box.hide_dir - 1) {
                _self.all_data.number_var.hide_num = 0;
            }
            _self.cut_var.label_p_r = false;
            _self.timer_box.peo_timer = setTimeout(function () {
                _self.cut_var.label_p_r = true;
            }, 500);
            _self.post_data.hide_post1 = {top: _self.all_data.number_var.hide_num};
            $.ajax({
                url: config.interface.hide_dri,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post1),
                contentType: 'application/json',
                success: function (res) {
                    _self.all_data.center_data.driver_name = res.data.drivername;
                    _self.all_data.center_data.driver_sex = '--';
                    _self.all_data.center_data.driver_num = res.data.driveridcard;
                    _self.all_data.center_data.driver_yes1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.driver_yes2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.driver_yes3 = _self.yes_box(res.data.overdueproofstate);
                    _self.all_data.center_data.driver_no1 = _self.yes_box(res.data.fullstudystate);
                    _self.all_data.center_data.driver_no2 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.driver_warning = _self.level_box(res.data.dangertype);
                },
                error: function () {
                }
            });
        },
        /**
         * 数据处理方法
         * @param val
         * @returns {string}
         */
        yes_box: function (val) {
            return val ? '是' : '否';
        },
        level_box: function (val) {
            var data = '';
            if (val == 1) {
                data = '一级预警'
            } else if (val == 2) {
                data = '二级预警'
            } else if (val == 3) {
                data = '三级预警'
            } else if (val == null) {
                data = '--'
            }
            return data;
        },
        car_big: function (val) {
            var data = '';
            if (val == '01') {
                data = '大型车'
            } else if (val == '02') {
                data = '小型车'
            }
            return data;
        },
        auto_center_peopel: function () {
            var _self = this;
            _self.timer_box.auto_peopel = setInterval(_self.hide_peopel_right, 5000);
        },
        /**
         * hover function
         * @param num
         */
        peopel_over: function (num) {
            var _self = this;
            if (num == 0) {
                clearInterval(_self.timer_box.auto_peopel)
            } else if (num == 1) {
                clearInterval(_self.timer_box.auto_car)
            } else if (num == 2) {
                clearInterval(_self.timer_box.auto_enter)
            }
        },
        peopel_leave: function (num) {
            var _self = this;
            if (num == 0) {
                _self.auto_center_peopel();
            } else if (num == 1) {
                _self.auto_center_car();
            } else if (num == 2) {
                _self.auto_center_enter();
            }
        },
        //隐患机动车
        auto_center_car: function () {
            var _self = this;
            _self.timer_box.auto_car = setInterval(_self.hide_car_right, 5000);
        },
        hide_car_right: function () {
            var _self = this;
            _self.all_data.number_var.hide_car_num++;
            if (_self.all_data.number_var.hide_car_num > _self.post_data.number_box.hide_car - 1) {
                _self.all_data.number_var.hide_car_num = 0;
            }
            _self.cut_var.label_c_r = false;
            _self.timer_box.car_timer = setTimeout(function () {
                _self.cut_var.label_c_r = true;
            }, 500);
            _self.post_data.hide_post2 = {top: _self.all_data.number_var.hide_car_num};
            $.ajax({
                url: config.interface.hide_car,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post2),
                contentType: 'application/json',
                success: function (res) {
                    _self.all_data.center_data.vehicle_name = res.data.vehino;
                    _self.all_data.center_data.vehicle_car = _self.car_big(res.data.vehitype);
                    _self.all_data.center_data.vehicle_cararea = _self.level_box(res.data.ownerenterprise);
                    _self.all_data.center_data.vehicle_yes = _self.yes_box(res.data.scrappedstate);
                    _self.all_data.center_data.vehicle_no1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.vehicle_no2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.vehicle_no3 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.vehicle_warning = _self.level_box(res.data.dangertype);
                },
                error: function () {
                    _self.all_data.center_data.vehicle_name = '--';
                    _self.all_data.center_data.vehicle_car = '--';
                    _self.all_data.center_data.vehicle_cararea = '--';
                    _self.all_data.center_data.vehicle_yes = '--';
                    _self.all_data.center_data.vehicle_no1 = '--';
                    _self.all_data.center_data.vehicle_no2 = '--';
                    _self.all_data.center_data.vehicle_no3 = '--';
                    _self.all_data.center_data.vehicle_warning = '--';
                }
            });
        },
        hide_car_left: function () {
            var _self = this;
            _self.all_data.number_var.hide_car_num--;
            if (_self.all_data.number_var.hide_car_num <= 0) {
                _self.all_data.number_var.hide_car_num = _self.post_data.number_box.hide_car - 1;
            }
            _self.cut_var.label_c_r = false;
            _self.timer_box.car_timer = setTimeout(function () {
                _self.cut_var.label_c_r = true;
            }, 500);
            _self.post_data.hide_post2 = {top: _self.all_data.number_var.hide_car_num};
            $.ajax({
                url: config.interface.hide_car,
                type: 'POST',
                data: JSON.stringify(_self.post_data.hide_post2),
                contentType: 'application/json',
                success: function (res) {
                    _self.all_data.center_data.vehicle_name = res.data.vehino;
                    _self.all_data.center_data.vehicle_car = _self.car_big(res.data.vehitype);
                    _self.all_data.center_data.vehicle_cararea = _self.level_box(res.data.ownerenterprise);
                    _self.all_data.center_data.vehicle_yes = _self.yes_box(res.data.scrappedstate);
                    _self.all_data.center_data.vehicle_no1 = _self.yes_box(res.data.illicitstate);
                    _self.all_data.center_data.vehicle_no2 = _self.yes_box(res.data.failurestate);
                    _self.all_data.center_data.vehicle_no3 = _self.yes_box(res.data.overdueexaminestate);
                    _self.all_data.center_data.vehicle_warning = _self.level_box(res.data.dangertype);
                },
                error: function () {
                    _self.all_data.center_data.vehicle_name = '--';
                    _self.all_data.center_data.vehicle_car = '--';
                    _self.all_data.center_data.vehicle_cararea = '--';
                    _self.all_data.center_data.vehicle_yes = '--';
                    _self.all_data.center_data.vehicle_no1 = '--';
                    _self.all_data.center_data.vehicle_no2 = '--';
                    _self.all_data.center_data.vehicle_no3 = '--';
                    _self.all_data.center_data.vehicle_warning = '--';
                }
            });

        },
        // 企业切换
        auto_center_enter: function () {
            var _self = this;
            _self.timer_box.auto_enter = setInterval(_self.hide_enter_right, 5000);
        },
        hide_enter_right: function () {
            var _self = this;
            _self.all_data.number_var.hide_enter_num++;
            if (_self.all_data.number_var.hide_enter_num >= _self.all_data.center_data.nav.enter.length) {
                _self.all_data.number_var.hide_enter_num = 0;
            }
            _self.cut_var.label_e_r = false;
            _self.timer_box.enter_timer = setTimeout(function () {
                _self.cut_var.label_e_r = true;
            }, 500);
            _self.all_data.center_data.enter_name = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].name;
            _self.all_data.center_data.enter_enter = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].enter;
            _self.all_data.center_data.enter_area = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].area;
            _self.all_data.center_data.enter_dmv = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].dmv;
            _self.all_data.center_data.enter_num1 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num1;
            _self.all_data.center_data.enter_num2 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num2;
            _self.all_data.center_data.enter_num3 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num3;
            _self.all_data.center_data.enter_warning = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].warning;
        },
        hide_enter_left: function () {
            var _self = this;
            _self.all_data.number_var.hide_enter_num--;
            if (_self.all_data.number_var.hide_enter_num <= 0) {
                _self.all_data.number_var.hide_enter_num = _self.all_data.center_data.nav.enter.length - 1;
            }
            _self.cut_var.label_e_r = false;
            _self.timer_box.enter_timer = setTimeout(function () {
                _self.cut_var.label_e_r = true;
            }, 500);
            _self.all_data.center_data.enter_name = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].name;
            _self.all_data.center_data.enter_enter = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].enter;
            _self.all_data.center_data.enter_area = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].area;
            _self.all_data.center_data.enter_dmv = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].dmv;
            _self.all_data.center_data.enter_num1 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num1;
            _self.all_data.center_data.enter_num2 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num2;
            _self.all_data.center_data.enter_num3 = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].num3;
            _self.all_data.center_data.enter_warning = _self.all_data.center_data.nav.enter[_self.all_data.number_var.hide_enter_num].warning;
        },
    }
});
/**
 * 驾驶人隐患问题类型
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie1 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '驾驶人隐患问题类型',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#00ff96',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} 人"
        },
        color: [
            '#e05b5b',
            '#ffcc68',
            '#beff68',
            '#68ffc2',
            '#68cbff'
        ],
        series: [
            {
                name: '驾驶人隐患问题类型',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    {value: 0, name: '违法未处'},
                    {value: 0, name: '逾期未换'},
                    {value: 0, name: '满分未学'},
                    {value: 0, name: '逾期未审'},
                    {value: 0, name: '事故未处'}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)'
                    }
                },
                labelLine: {
                    show: false,
                    length: -3,
                    length2: -3
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie1.prototype = {
    constructor: EchartsPie1,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_1: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        // console.info(item)
        // console.info()
        var arr = [];
        item.forEach(function (v, index) {
            _self.option.series[0].data[index].name = v.dangerName;
            _self.option.series[0].data[index].value = v.num;
        });
        // _self.option.series[0].data = item;
        // console.info(_self.option.series[0].data)
        for (var i = 0; i < _self.option.series[0].data.length; i++) {
            // console.info(_self.option.series[0].data[i].value);
            if (_self.option.series[0].data[i].value == 0) {
                arr.push(_self.option.series[0].data[i].name);
                _self.option.series[0].data[i].name = '';
                // console.info(arr.length)
                if (arr.length == _self.option.series[0].data.length) {
                    // console.info(_self.option)
                    _self.option.series[0].radius = '110%';
                    _self.option.series[0].color = '';
                    _self.option.series[0].color = '#ccc';
                    _self.option.series[0].itemStyle.shadowColor = 'rgba(0,0,0,0)';
                    _self.option.series[0].label.position = 'center';
                    _self.option.series[0].label.textStyle.color = '#666';
                    _self.option.series[0].label.textStyle.fontSize = 24;
                    _self.option.series[0].data[i].name = '无数据';
                }
                // if(_self.option.series[0].data[i])
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 机动车隐患问题类型
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie2 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '机动车隐患问题类型',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#ff3600',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} 辆"
        },
        color: [
            '#689bff',
            '#a968ff',
            '#ff68a5',
            '#ff9c68'
        ],
        series: [
            {
                name: '机动车隐患问题类型',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    {value: 335, name: '达报废标'},
                    {value: 310, name: '逾期未检'},
                    {value: 274, name: '违法未处'},
                    {value: 235, name: '事故未处'}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)'
                    }
                },
                labelLine: {
                    show: false,
                    length: -3,
                    length2: -3
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie2.prototype = {
    constructor: EchartsPie2,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_2: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        var arr = [];
        item.forEach(function (v, index) {
            _self.option.series[0].data[index].name = v.dangerName;
            _self.option.series[0].data[index].value = v.num;
        });
        // _self.option.series[0].data = item;
        // console.info(_self.option.series[0].data)
        for (var i = 0; i < _self.option.series[0].data.length; i++) {
            // console.info(_self.option.series[0].data[i].value);
            if (_self.option.series[0].data[i].value == 0) {
                arr.push(_self.option.series[0].data[i].name);
                _self.option.series[0].data[i].name = '';
                // console.info(arr.length)
                if (arr.length == _self.option.series[0].data.length) {
                    // console.info(_self.option)
                    _self.option.series[0].radius = '95%';
                    _self.option.series[0].label.position = 'center';
                    _self.option.series[0].color = '';
                    _self.option.series[0].color = '#ccc';
                    _self.option.series[0].itemStyle.shadowColor = 'rgba(0,0,0,0)';
                    _self.option.series[0].label.textStyle.color = '#666';
                    _self.option.series[0].label.textStyle.fontSize = 24;
                    _self.option.series[0].data[i].name = '无数据';
                }
                // if(_self.option.series[0].data[i])
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 企业类型分布情况
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie3 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '企业类型分布情况',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#ffc600',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} %"
        },
        color: [
            '#0184c3',
            '#512ded',
            '#00c2af',
            '#ea544c'
        ],
        series: [
            {
                name: '企业类型分布情况',
                type: 'pie',
                zlevel: 2,
                radius: ['30%', '55%'],
                center: ['50%', '50%'],
                data: [
                    {value: 25, name: '其他'},
                    {value: 25, name: '货运企业'},
                    {value: 25, name: '客运企业'},
                    {value: 25, name: '危化品企业'},
                ],
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)'
                    },
                    formatter: '{b}\n{c}%'
                },
                labelLine: {
                    show: false,
                    length: -3,
                    length2: -3
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            },
            {
                name: 'other',
                type: 'pie',
                zlevel: 1,
                radius: ['25%', '30%'],
                center: ['50%', '50%'],
                data: [
                    {value: 50, name: 'other'},
                ],
                label: {
                    show: false
                },
                labelLine: {
                    show: false,
                },
                itemStyle: {
                    color: "rgba(60,59,102,.3)",
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            },
            {
                name: 'onther',
                type: 'pie',
                zlevel: 3,
                radius: ['34%', '55%'],
                center: ['50%', '50%'],
                data: [
                    {value: 100, name: '123'},
                ],
                label: {
                    show: false
                },
                labelLine: {
                    show: false,
                    length: -3,
                    length2: -3
                },
                itemStyle: {
                    color: "rgba(60,59,102,.3)",
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie3.prototype = {
    constructor: EchartsPie3,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_3: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        _self.option.series[0].data = item;
        for (var i = 0; i < item.length; i++) {
            if (item[i].value == 0) {
                _self.option.series[0].labelLine = false;
                _self.option.series[0].label.formatter = '{b}';
                _self.option.series[0].label.position = 'center'
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/*---------------------------------------------------  弹框  -------------------------------------------------------------*/
/**
 * 驾驶人隐患问题类型---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie4 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} 人"
        },
        color: [
            '#e05b5b',
            '#ffcc68',
            '#beff68',
            '#68ffc2',
            '#68cbff'
        ],
        series: [
            {
                name: '驾驶人隐患问题类型',
                type: 'pie',
                radius: '75%',
                center: ['50%', '50%'],
                data: [
                    {value: 335, name: '违法未处',label:{show:true},labelLine: {show:true}},
                    {value: 310, name: '逾期未换',label:{show:true},labelLine: {show:true}},
                    {value: 274, name: '满分未学',label:{show:true},labelLine: {show:true}},
                    {value: 235, name: '逾期未审',label:{show:true},labelLine: {show:true}},
                    {value: 400, name: '事故未处',label:{show:true},labelLine: {show:true}}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)',
                        fontSize: 30
                    },
                    formatter: '{b}\n{c} ({d}%)'
                },
                labelLine: {
                    show: true,
                    lineStyle: {
                        width: 3
                    }
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                },
                rich: {}
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie4.prototype = {
    constructor: EchartsPie4,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_4: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        var arr = [];
        item.forEach(function (v, index) {
            _self.option.series[0].data[index].name = v.dangerName;
            _self.option.series[0].data[index].value = v.num;
        });
        // _self.option.series[0].data = item;
        // console.info(_self.option.series[0].data)
        for (var i = 0; i < _self.option.series[0].data.length; i++) {
            // console.info(_self.option.series[0].data[i].value);
            if (_self.option.series[0].data[i].value == 0) {
                arr.push(_self.option.series[0].data[i].name);
                _self.option.series[0].data[i].name = '';
                _self.option.series[0].data[i].label.show = false;
                _self.option.series[0].data[i].labelLine.show = false;
                // console.info(arr.length)
                if (arr.length == _self.option.series[0].data.length) {
                    // console.info(_self.option)
                    _self.option.series[0].radius = '140%';
                    _self.option.series[0].color = '';
                    _self.option.series[0].color = '#ccc';
                    _self.option.series[0].itemStyle.shadowColor = 'rgba(0,0,0,0)';
                    _self.option.series[0].label.position = 'center';
                    // _self.option.series[0].label.textStyle.color = '#666';
                    _self.option.series[0].label.textStyle.fontSize = 24;
                    _self.option.series[0].labelLine = false;
                    _self.option.series[0].data[i].name = '无数据';
                    _self.option.series[0].label.formatter = '{b}';
                }
                // if(_self.option.series[0].data[i])
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 机动车隐患问题类型---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie5 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} 辆"
        },
        color: [
            '#689bff',
            '#a968ff',
            '#ff68a5',
            '#ff9c68'
        ],
        series: [
            {
                name: '机动车隐患问题类型',
                type: 'pie',
                radius: '75%',
                center: ['50%', '50%'],
                data: [
                    {value: 335, name: '达报废标',label:{show:true},labelLine:{show:true}},
                    {value: 310, name: '逾期未检',label:{show:true},labelLine:{show:true}},
                    {value: 274, name: '违法未处',label:{show:true},labelLine:{show:true}},
                    {value: 235, name: '事故未处',label:{show:true},labelLine:{show:true}}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)',
                        fontSize: 30
                    },
                    formatter: '{b}\n{c} ({d}%)'
                },
                labelLine: {
                    show: true,
                    lineStyle: {
                        width: 3
                    }
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie5.prototype = {
    constructor: EchartsPie5,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_5: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        var arr = [];
        item.forEach(function (v, index) {
            _self.option.series[0].data[index].name = v.dangerName;
            _self.option.series[0].data[index].value = v.num;
        });
        // _self.option.series[0].data = item;
        // console.info(_self.option.series[0].data)
        for (var i = 0; i < _self.option.series[0].data.length; i++) {
            // console.info(_self.option.series[0].data[i].value);
            if (_self.option.series[0].data[i].value == 0) {
                arr.push(_self.option.series[0].data[i].name);
                _self.option.series[0].data[i].name = '';
                _self.option.series[0].data[i].label.show = false;
                _self.option.series[0].data[i].labelLine.show = false;
                // console.info(arr.length)
                if (arr.length == _self.option.series[0].data.length) {
                    // console.info(_self.option)
                    _self.option.series[0].radius = '95%';
                    _self.option.series[0].label.position = 'center';
                    _self.option.series[0].label.textStyle.color = '#666';
                    _self.option.series[0].label.textStyle.fontSize = 24;
                    _self.option.series[0].labelLine = false;
                    _self.option.series[0].data[i].name = '无数据';
                    _self.option.series[0].label.formatter = '{b}';
                }
                // if(_self.option.series[0].data[i])
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 企业类型分布情况---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsPie6 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            show: true,
            confine: true,
            formatter: "{a} <br/>{b} : {c} %"
        },
        color: [
            '#0184c3',
            '#512ded',
            '#00c2af',
            '#ea544c'
        ],
        series: [
            {
                name: '企业类型分布情况',
                type: 'pie',
                zlevel: 2,
                radius: ['30%', '75%'],
                center: ['50%', '50%'],
                data: [
                    {value: 25, name: '其他'},
                    {value: 25, name: '货运企业'},
                    {value: 25, name: '客运企业'},
                    {value: 25, name: '危化品企业'},
                ],
                label: {
                    textStyle: {
                        color: 'rgba(255, 255, 255,1)',
                        fontSize: 30
                    },
                    formatter: '{b}\n{c}({d}%)'
                },
                labelLine: {
                    show: true,
                    lineStyle: {
                        width: 3
                    }
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            },
            {
                name: 'other',
                type: 'pie',
                zlevel: 1,
                radius: ['25%', '70%'],
                center: ['50%', '50%'],
                data: [
                    {value: 50, name: 'other'},
                ],
                label: {
                    show: false
                },
                labelLine: {
                    show: false,
                },
                itemStyle: {
                    color: "rgba(60,59,102,.3)",
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            },
            {
                name: 'onther',
                type: 'pie',
                zlevel: 3,
                radius: ['34%', '75%'],
                center: ['50%', '50%'],
                data: [
                    {value: 100, name: '123'},
                ],
                label: {
                    show: false
                },
                labelLine: {
                    show: false,
                    length: -3,
                    length2: -3
                },
                itemStyle: {
                    color: "rgba(60,59,102,.3)",
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsPie6.prototype = {
    constructor: EchartsPie6,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_pie_6: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        // console.info();
        _self.option.series[0].data = item;
        for (var i = 0; i < item.length; i++) {
            if (item[i].value == 0) {
                _self.option.series[0].labelLine = false;
                _self.option.series[0].label.formatter = '{b}';
                _self.option.series[0].label.position = 'center'
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/*---------------------------------------------------  left-line  -------------------------------------------------------------*/
/**
 * 整治效果趋势分析
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsLeftLine = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    var this_ = this;
    // 图表配置
    this.option = {
        xAxis: {
            type: 'category',
            data: (function () {
                var res = [];
                var num = 13;
                while (num--) {
                    res.push(num);
                }
                res.sort(campare_number);
                res.splice(res[0], 1)
                return res
            })(),
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#04beea',
                    fontSize: 12
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#164654'
                }
            }
        },
        tooltip: {
            trigger: 'axis',
            show: true,
            formatter: '{b}月<br>{a0}:{c0}人<br>{a1}:{c1}辆<br>{a2}:{c2}个'
        },
        grid: {
            top: '14%',
            left: '5%',
            right: '5%',
            bottom: '5%',
            containLabel: true
        },
        yAxis: {
            type: 'value',
            name: '隐患发现数',
            nameTextStyle: {
                color: '#04beea'
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#04beea',
                    fontSize: 12
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#164654'
                }
            },
            splitLine: {
                show: false
            }
        },
        series: [
            {
                name: '驾驶人',
                type: 'line',
                data: [],
                lineStyle: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 1, 0,
                        [
                            {offset: 0, color: '#00eaff'},
                            {offset: 1, color: '#00ff84'}
                        ]
                    ),
                    width: 4
                },
                symbol: "circle",
                color: '#fff',
            },
            {
                name: '机动车',
                type: 'line',
                data: (function () {
                    var res = [];
                    var num = 12;
                    while (num--) {
                        res.push(Math.round(Math.random() * 2500).toFixed(0));
                    }
                    return res;
                })(),
                lineStyle: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 1, 0,
                        [
                            {offset: 0, color: '#ff1900'},
                            {offset: 1, color: '#ff7100'}
                        ]
                    ),
                    width: 4
                },
                symbol: "circle",
                color: '#fff',

            },
            {
                name: '企业',
                type: 'line',
                data: (function () {
                    var res = [];
                    var num = 12;
                    while (num--) {
                        res.push(Math.round(Math.random() * 2500).toFixed(0));
                    }
                    return res;
                })(),
                lineStyle: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 1, 0,
                        [
                            {offset: 0, color: '#fe9200'},
                            {offset: 1, color: '#f8f601'}
                        ]
                    ),
                    width: 4
                },
                symbol: "circle",
                color: '#fff',
                label: {
                    show: false,
                    // formatter: function (val) {
                    //     var rel = '';
                    //     if (this_.data[2][this_.data[2].length - 1] === val.data) {
                    //         rel = val.seriesName
                    //     }
                    //     return rel;
                    // },
                    textStyle: {
                        color: '#00f6ff',
                        fontSize: 16
                    }
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
    // 实时数据
    this.data = [];
};
EchartsLeftLine.prototype = {
    constructor: EchartsLeftLine,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    left_line: function (item, item_car) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        // 数据渲染
        // 驾驶人
        _self.option.series[2].data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        // console.info(item)
        var arr = [];
        for (var e in item) {
            arr.push(item[e]);
        }
        for (var a = 0; a < arr.length; a++) {
            _self.option.series[0].data[a] = {value: 0};
            _self.option.series[0].data[arr.length - 1] = {
                value: 0, label: {
                    show: true,
                    formatter: '{a}',
                    textStyle: {
                        color: '#00f6ff',
                        fontSize: 16
                    }
                }
            }
            _self.option.series[1].data[a] = {value: 0};
            _self.option.series[1].data[arr.length - 1] = {
                value: 0, label: {
                    show: true,
                    formatter: '{a}',
                    textStyle: {
                        color: '#00f6ff',
                        fontSize: 16
                    }
                }
            }
        }
        for (var i in item) {

            if (i == "一") {
                _self.option.series[0].data[0].value = item[i];
                _self.option.series[1].data[0].value = item_car[i];
            } else if (i == '二') {
                _self.option.series[0].data[1].value = item[i];
                _self.option.series[1].data[1].value = item_car[i];
            } else if (i == '三') {
                _self.option.series[0].data[2].value = item[i];
                _self.option.series[1].data[2].value = item_car[i];
            } else if (i == '四') {
                _self.option.series[0].data[3].value = item[i];
                _self.option.series[1].data[3].value = item_car[i];
            } else if (i == '五') {
                _self.option.series[0].data[4].value = item[i];
                _self.option.series[1].data[4].value = item_car[i];
            } else if (i == '六') {
                _self.option.series[0].data[5].value = item[i];
                _self.option.series[1].data[5].value = item_car[i];
            } else if (i == '七') {
                _self.option.series[0].data[6].value = item[i];
                _self.option.series[1].data[6].value = item_car[i];
            } else if (i == '八') {
                _self.option.series[0].data[7].value = item[i];
                _self.option.series[1].data[7].value = item_car[i];
            } else if (i == '九') {
                _self.option.series[0].data[8].value = item[i];
                _self.option.series[1].data[8].value = item_car[i];
            } else if (i == '十') {
                _self.option.series[0].data[9].value = item[i];
                _self.option.series[1].data[9].value = item_car[i];
            } else if (i == '十一') {
                _self.option.series[0].data[10].value = item[i];
                _self.option.series[1].data[10].value = item_car[i];
            } else if (i == '十二') {
                _self.option.series[0].data[11].value = item[i];
                _self.option.series[1].data[11].value = item_car[i];
            }
        }
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/*---------------------------------------------------  右边  -------------------------------------------------------------*/
/**
 * 各区县隐患情况排名
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRBar1 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            confine: true,
            formatter: '{b}: {c} 次'
        },
        grid: {
            top: '2%',
            left: '3%',
            right: '4%',
            bottom: 0,
            containLabel: true
        },
        xAxis: {
            show: false,
        },
        yAxis: {
            type: 'category',
            data: [],
            axisLabel: {
                textStyle: {
                    color: '#61f7ff',
                    fontSize: 16
                }
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            }
        },
        color: [new echarts.graphic.LinearGradient(
            0, 0, 1, 0,
            [
                {offset: 0, color: '#ffc601'},
                {offset: 1, color: '#ff4800'}
            ]
        )],
        series: [
            {
                name: '2018年',
                type: 'bar',
                data: [],
                label: {
                    show: true,
                    position: "insideRight",
                    textStyle: {
                        color: '#fff'
                    }
                },
                barWidth: '45%'
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRBar1.prototype = {
    constructor: EchartsRBar1,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_bar_one: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        for (var i = 0; i < 10; i++) {
            // console.info(i)
            // _self.option.series[0].data[i] = '';
            _self.option.series[0].data.push({value: 0,label:{show:true,position: "insideRight",
                    textStyle: {
                        color: '#fff'
                    }}});
            _self.option.series[0].data[i].value = item[i].total;
            _self.option.yAxis.data.push(item[i].orgNm);
            if(_self.option.series[0].data[i].value == 0 ){
                _self.option.series[0].data[i].label.show = false;
            }
            // _self.option.series[0].data.reverse();
            // _self.option.yAxis.data.reverse();
            console.log();
        }
        _self.option.yAxis.data.reverse();
        _self.option.series[0].data.reverse()
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 各区县治理情况排名
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRBar2 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            confine: true,
            formatter: '{b}: {c} 次'
        },
        grid: {
            top: '2%',
            left: '3%',
            right: '4%',
            bottom: 0,
            containLabel: true
        },
        xAxis: {
            show: false,
        },
        yAxis: {
            type: 'category',
            data: [
                '渝中区',
                '南岸区',
                '九龙坡区',
                '沙坪坝区',
                '江北区',
                '长寿区',
                '涪陵区',
                '万州区',
                '万盛区',
                '黔江区'
            ].reverse(),
            axisLabel: {
                textStyle: {
                    color: '#61f7ff',
                    fontSize: 16
                }
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            }
        },
        color: [new echarts.graphic.LinearGradient(
            0, 0, 1, 0,
            [
                {offset: 0, color: '#00ff84'},
                {offset: 1, color: '#006cff'}
            ]
        )],
        series: [
            {
                name: '2018年',
                type: 'bar',
                data: [
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0)
                ],
                label: {
                    show: true,
                    position: "insideRight",
                    textStyle: {
                        color: '#fff'
                    }
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRBar2.prototype = {
    constructor: EchartsRBar2,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_bar_two: function () {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};
/*---------------------------------------------------  弹框  -------------------------------------------------------------*/

/**
 * 各区县隐患情况排名---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRBar3 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            confine: true,
            formatter: '{b}: {c} 次'
        },
        grid: {
            top: 0,
            left: '3%',
            right: '4%',
            bottom: 0,
            containLabel: true
        },
        xAxis: {
            show: false,
        },
        yAxis: {
            type: 'category',

            data: [],
            axisLabel: {
                textStyle: {
                    color: '#61f7ff',
                    fontSize: 24
                }
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            }
        },
        color: [new echarts.graphic.LinearGradient(
            0, 0, 1, 0,
            [
                {offset: 0, color: '#ffc601'},
                {offset: 1, color: '#ff4800'}
            ]
        )],
        series: [
            {
                name: '2018年',
                type: 'bar',
                data: [],
                label: {
                    show: true,
                    position: "insideRight",
                    textStyle: {
                        color: '#fff',
                        fontSize: 18
                    }
                },
                barWidth: '55%'
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRBar3.prototype = {
    constructor: EchartsRBar3,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_bar_3: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // _self.option.series[0].data[i] = '';
            // _self.option.series[0].data.push(item[i].total);
            // _self.option.yAxis.data.push(item[i].orgNm);
            _self.option.series[0].data.push({value: 0,label:{show:true,position: "insideRight",
                    textStyle: {
                        color: '#fff'
                    }}});
            _self.option.series[0].data[i].value = item[i].total;
            _self.option.yAxis.data.push(item[i].orgNm);
            if(_self.option.series[0].data[i].value == 0 ){
                _self.option.series[0].data[i].label.show = false;
            }
        }
        _self.option.series[0].data.reverse();
        _self.option.yAxis.data.reverse();
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 各区县治理情况排名---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRBar4 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            confine: true,
            formatter: '{b}: {c} 次'
        },
        grid: {
            top: 0,
            left: '3%',
            right: '4%',
            bottom: 0,
            containLabel: true
        },
        xAxis: {
            show: false,
        },
        yAxis: {
            type: 'category',
            data: [
                '渝中区',
                '南岸区',
                '九龙坡区',
                '沙坪坝区',
                '江北区',
                '长寿区',
                '涪陵区',
                '万州区',
                '万盛区',
                '黔江区',
                '垫江区',
                '丰都区',
                '梁平区',
                '忠县区',
                '石柱区',
                '彭水区',
                '秀山区',
                '酉阳区',
                '开县区',
                '云阳区',
                '奉节区',
                '城口区',
                '巫溪区',
                '巫山区',
                '武隆区',
                '南川区',
                '綦江区',
                '巴南区',
                '渝北区',
                '大渡口区',
                '沙坪坝区',
                '北碚区',
                '江津区',
                '永川区',
                '荣昌区',
                '大足区',
                '合川区',
                '铜梁区',
                '潼南区'
            ].reverse(),
            axisLabel: {
                textStyle: {
                    color: '#61f7ff',
                    fontSize: 16
                }
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            }
        },
        color: [new echarts.graphic.LinearGradient(
            0, 0, 1, 0,
            [
                {offset: 0, color: '#00ff84'},
                {offset: 1, color: '#006cff'}
            ]
        )],
        series: [
            {
                name: '2018年',
                type: 'bar',
                data: [
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0),
                    Math.round(Math.random() * 2500).toFixed(0)
                ],
                label: {
                    show: true,
                    position: "insideRight",
                    textStyle: {
                        color: '#fff'
                    }
                },
                barWidth: '55%'
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRBar4.prototype = {
    constructor: EchartsRBar4,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_bar_4: function () {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 驾驶员隐患占比
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie1 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '驾驶员隐患占比',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#00ff96',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            position: 'center',
            formatter: "{a} <br/>{b} : {c} %"
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '驾驶员隐患占比',
                type: 'pie',
                zlevel: 2,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江'},
                    {value: 2.2, name: '丰都'},
                    {value: 2.2, name: '梁平'},
                    {value: 2.2, name: '忠县'},
                    {value: 2.2, name: '石柱'},
                    {value: 2.2, name: '彭水'},
                    {value: 2.2, name: '黔江'},
                    {value: 2.2, name: '秀山'},
                    {value: 2.2, name: '酉阳'},
                    {value: 2.2, name: '万州'},
                    {value: 2.2, name: '开县'},
                    {value: 2.2, name: '云阳'},
                    {value: 2.2, name: '奉节'},
                    {value: 2.2, name: '城口'},
                    {value: 2.2, name: '巫溪'},
                    {value: 2.2, name: '巫山'},
                    {value: 2.2, name: '武隆'},
                    {value: 2.2, name: '涪陵'},
                    {value: 2.2, name: '长寿'},
                    {value: 2.2, name: '南川'},
                    {value: 2.2, name: '万盛'},
                    {value: 2.2, name: '綦江'},
                    {value: 2.2, name: '巴南区'},
                    {value: 2.2, name: '渝北区'},
                    {value: 2.2, name: '江北区'},
                    {value: 2.2, name: '南岸区'},
                    {value: 2.2, name: '渝中区'},
                    {value: 2.2, name: '大渡口区'},
                    {value: 2.2, name: '九龙坡区'},
                    {value: 2.2, name: '沙坪坝区'},
                    {value: 2.2, name: '北碚区'},
                    {value: 2.2, name: '江津'},
                    {value: 2.2, name: '永川'},
                    {value: 2.2, name: '荣昌'},
                    {value: 2.2, name: '大足'},
                    {value: 2.2, name: '合川'},
                    {value: 2.2, name: '铜梁'},
                    {value: 1.8, name: '潼南'},
                    {value: 0, name: ''},
                    {value: 0, name: ''},
                    {value: 0, name: ''},
                ],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        formatter: '{b}\n{c}%',
                        textStyle: {
                            fontSize: '16',
                            color: '#fff '
                        }
                    }
                },
                labelLine: {
                    show: false,
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie1.prototype = {
    constructor: EchartsRPie1,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_1: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        // console.info(item);
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';
            _self.option.series[0].data[i].value = item[i].driverDangers;
            _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
        }
        // console.info(_self.option.series[0].data)
        // for(var v in item){
        //     console.info(v)
        // }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 机动车隐患占比
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie2 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '机动车隐患占比',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#ff3600',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            position: 'center',
            formatter: "{a} <br/>{b} : {c} %"
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '机动车隐患占比',
                type: 'pie',
                zlevel: 2,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江'},
                    {value: 2.2, name: '丰都'},
                    {value: 2.2, name: '梁平'},
                    {value: 2.2, name: '忠县'},
                    {value: 2.2, name: '石柱'},
                    {value: 2.2, name: '彭水'},
                    {value: 2.2, name: '黔江'},
                    {value: 2.2, name: '秀山'},
                    {value: 2.2, name: '酉阳'},
                    {value: 2.2, name: '万州'},
                    {value: 2.2, name: '开县'},
                    {value: 2.2, name: '云阳'},
                    {value: 2.2, name: '奉节'},
                    {value: 2.2, name: '城口'},
                    {value: 2.2, name: '巫溪'},
                    {value: 2.2, name: '巫山'},
                    {value: 2.2, name: '武隆'},
                    {value: 2.2, name: '涪陵'},
                    {value: 2.2, name: '长寿'},
                    {value: 2.2, name: '南川'},
                    {value: 2.2, name: '万盛'},
                    {value: 2.2, name: '綦江'},
                    {value: 2.2, name: '巴南区'},
                    {value: 2.2, name: '渝北区'},
                    {value: 2.2, name: '江北区'},
                    {value: 2.2, name: '南岸区'},
                    {value: 2.2, name: '渝中区'},
                    {value: 2.2, name: '大渡口区'},
                    {value: 2.2, name: '九龙坡区'},
                    {value: 2.2, name: '沙坪坝区'},
                    {value: 2.2, name: '北碚区'},
                    {value: 2.2, name: '江津'},
                    {value: 2.2, name: '永川'},
                    {value: 2.2, name: '荣昌'},
                    {value: 2.2, name: '大足'},
                    {value: 2.2, name: '合川'},
                    {value: 2.2, name: '铜梁'},
                    {value: 1.8, name: '潼南'},
                    {value: 0, name: ''},
                    {value: 0, name: ''},
                    {value: 0, name: ''},
                ],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        formatter: '{b}\n{c}%',
                        textStyle: {
                            fontSize: '16',
                            color: '#fff '
                        }
                    }
                },
                labelLine: {
                    show: false,
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie2.prototype = {
    constructor: EchartsRPie2,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_2: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';

            _self.option.series[0].data[i].value = item[i].driverDangers;
            _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 企业隐患占比
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie3 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: '企业隐患占比',
            left: 'center',
            bottom: 'bottom',
            textStyle: {
                color: '#ffc600',
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            confine: true,
            position: 'center',
            formatter: "{a} <br/>{b} : {c} %"
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '企业隐患占比',
                type: 'pie',
                zlevel: 2,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '丰都', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '梁平', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '忠县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '石柱', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '彭水', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '黔江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '秀山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '酉阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万州', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '开县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '云阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '奉节', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '城口', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫溪', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '武隆', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '涪陵', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '长寿', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万盛', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '綦江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巴南区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南岸区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝中区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大渡口区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '九龙坡区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '沙坪坝区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '北碚区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江津', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '永川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '荣昌', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大足', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '合川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '铜梁', label: {show: true}, labelLine: {show: true}},
                    {value: 1.8, name: '潼南', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}}
                ],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        formatter: '{b}\n{c}%',
                        textStyle: {
                            fontSize: '16',
                            color: '#fff '
                        }
                    }
                },
                labelLine: {
                    show: false,
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie3.prototype = {
    constructor: EchartsRPie3,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_3: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';
            if (_self.option.series[0].data[i].value == 0) {
                _self.option.series[0].data[item.length - 1].label.show = true;
                _self.option.series[0].data[i].labelLine.show = false;
                _self.option.color = '#ccc';
                _self.option.series[0].data[item.length - 1].name = '无数据';
                _self.option.series[0].itemStyle.shadowColor = 'rgba(0, 0, 0, 0)';
                _self.option.series[0].itemStyle.shadowBlur = 0;
                // _self.option.title.show = true;
            }
            // _self.option.series[0].data[i].value = item[i].driverDangers;
            // _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};


/*---------------------------------------------------  弹框  -------------------------------------------------------------*/
/**
 * 驾驶员隐患占比--------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie4 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            show: true,
            confine: true,
            // position: 'center',
            formatter: "{a} <br/>{b} : {c} %",
            textStyle: {
                fontSize: 32
            }
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '驾驶员隐患占比',
                type: 'pie',
                zlevel: 2,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '丰都', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '梁平', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '忠县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '石柱', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '彭水', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '黔江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '秀山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '酉阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万州', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '开县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '云阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '奉节', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '城口', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫溪', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '武隆', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '涪陵', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '长寿', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万盛', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '綦江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巴南区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南岸区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝中区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大渡口区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '九龙坡区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '沙坪坝区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '北碚区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江津', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '永川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '荣昌', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大足', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '合川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '铜梁', label: {show: true}, labelLine: {show: true}},
                    {value: 1.8, name: '潼南', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}}
                ],
                avoidLabelOverlap: false,
                label: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 24
                    },
                },
                labelLine: {
                    show: true,
                    length: 50,
                    length2: 30
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie4.prototype = {
    constructor: EchartsRPie4,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_4: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';
            _self.option.series[0].data[i].value = item[i].driverDangers;
            _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
            if (_self.option.series[0].data[i].value == 0) {
                _self.option.series[0].data[i].label.show = false;
                _self.option.series[0].data[i].labelLine.show = false;
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 机动车隐患占比---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie5 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: true,
            text: ' ',
            left: 'center',
            top: '40%',
            textStyle: {
                color: '#fff',
                fontSize: 32,
                fontWeight: 'bold'
            }
        },
        tooltip: {
            show: true,
            confine: true,
            // position: 'center',
            formatter: "{a} <br/>{b} : {c} %",
            textStyle: {
                fontSize: 32
            }
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '机动车隐患占比',
                type: 'pie',
                zlevel: 2,
                startAngle: 45,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '丰都', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '梁平', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '忠县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '石柱', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '彭水', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '黔江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '秀山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '酉阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万州', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '开县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '云阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '奉节', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '城口', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫溪', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '武隆', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '涪陵', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '长寿', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万盛', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '綦江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巴南区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南岸区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝中区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大渡口区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '九龙坡区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '沙坪坝区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '北碚区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江津', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '永川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '荣昌', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大足', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '合川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '铜梁', label: {show: true}, labelLine: {show: true}},
                    {value: 1.8, name: '潼南', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}}
                ],
                avoidLabelOverlap: false,
                label: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 24
                    }
                },
                labelLine: {
                    show: true,
                    length: 50,
                    length2: 30
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie5.prototype = {
    constructor: EchartsRPie5,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_5: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';
            _self.option.series[0].data[i].value = item[i].driverDangers;
            _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
            if (_self.option.series[0].data[i].value == 0) {
                _self.option.series[0].data[i].label.show = false;
                _self.option.series[0].data[i].labelLine.show = false;
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 企业隐患占比---------弹框
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRPie6 = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        title: {
            show: false,
            text: '无数据',
            left: 'center',
            top: '45%',
            textStyle: {
                color: '#fff',
                fontSize: 32,
                fontWeight: 'bold'
            }
        },
        tooltip: {
            show: true,
            confine: true,
            // position: 'center',
            formatter: "{a} <br/>{b} : {c} %",
            textStyle: {
                fontSize: 32
            }
        },
        color: [
            '#40d483',
            '#53d294',
            '#83bcd2',
            '#4e66bc',
            '#2833b4',
            '#5535de',
            '#af40e4',
            '#b124e3',
            '#b42856',
            '#de3137',
            '#24e448',
            '#bce3b3',
            '#aade35',
            '#b49e28',
            '#bc9849',
            '#d09482',
            '#c7c970',
            '#d2db85',
            '#93d083',
            '#51bd68',
            '#28b455',
            '#35deac',
            '#40b1e4',
            '#2441e3',
            '#82de35',
            '#a2b428',
            '#c7c06c',
            '#d0a582',
            '#d2526a',
            '#bf283e',
            '#e4ac24',
            '#e46040',
            '#de3554',
            '#b42772',
            '#bf51a0',
            '#bf82d2',
            '#5f57d4',
            '#382dc1'
        ],
        series: [
            {
                name: '企业隐患占比',
                type: 'pie',
                zlevel: 2,
                startAngle: 60,
                radius: ['35%', '72%'],
                center: ['50%', '45%'],
                data: [
                    {value: 1.8, name: '垫江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '丰都', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '梁平', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '忠县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '石柱', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '彭水', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '黔江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '秀山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '酉阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万州', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '开县', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '云阳', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '奉节', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '城口', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫溪', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巫山', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '武隆', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '涪陵', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '长寿', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '万盛', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '綦江', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '巴南区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江北区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '南岸区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '渝中区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大渡口区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '九龙坡区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '沙坪坝区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '北碚区', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '江津', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '永川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '荣昌', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '大足', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '合川', label: {show: true}, labelLine: {show: true}},
                    {value: 2.2, name: '铜梁', label: {show: true}, labelLine: {show: true}},
                    {value: 1.8, name: '潼南', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}},
                    {value: 0, name: '', label: {show: true}, labelLine: {show: true}}
                ],
                avoidLabelOverlap: false,
                label: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 24
                    }
                },
                labelLine: {
                    show: true,
                    length: 50,
                    length2: 30
                },
                itemStyle: {
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    shadowBlur: 10
                }
            }
        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRPie6.prototype = {
    constructor: EchartsRPie6,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_pie_6: function (item) {
        let _self = this;
        // 是否首次加载
        if (_self.load_first) {
            _self.myChart = echarts.init(document.getElementById(_self.dom_id));
            _self.load_first = false;
        }
        for (var i = 0; i < item.length; i++) {
            // console.info(i)
            // console.log(_self.option.series[0].data[i].value);
            _self.option.series[0].data[i].value = 0;
            _self.option.series[0].data[i].name = '';
            // _self.option.series[0].data[i].value = item[i].driverDangers;
            // _self.option.series[0].data[i].name = item[i].orgNm;
            // console.log(item[i].driverDangers);
            if (_self.option.series[0].data[i].value == 0) {
                _self.option.series[0].data[i].label.show = false;
                _self.option.series[0].data[i].labelLine.show = false;
                _self.option.color = '#ccc';
                _self.option.series[0].itemStyle.shadowColor = 'rgba(0, 0, 0, 0)';
                _self.option.series[0].itemStyle.shadowBlur = 0;
                _self.option.title.show = true;
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};

/**
 * 驾驶人隐患问题类型
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsRline = function (dom_id, url_desc, url) {
    public_data.call(this, dom_id, url_desc, url);
    // 图表配置
    this.option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '5%',
            containLabel: true
        },
        legend: {
            show: true,
            data: [
                {
                    name: '上月发现隐患总数'
                },
                {
                    name: '本月发现隐患总数'
                }
            ],
            textStyle: {
                color: "auto"
            },
            orient: 'vertical',
            right: '2%'
        },
        xAxis: {
            type: 'category',
            data: ['沙坪坝区', '大渡口区', '渝中区', '九龙坡区'],
            axisLabel: {
                color: '#00f6ff',
                fontSize: 12
            },
            axisLine: {
                lineStyle: {
                    color: '#dedcde'
                }
            },
            axisTick: {
                show: false
            }
        },
        yAxis: [
            {
                show: false,
            }
        ],
        series: [
            {
                name: '上月发现隐患总数',
                type: 'line',
                // stack: '总量',
                yAxisIndex: 0,
                // zlevel: 1,
                data: [],
                lineStyle: {
                    width: 3
                },
                color: '#ffc601',
                symbol: 'circle',
                symbolSize: 12
            },
            {
                name: '本月发现隐患总数',
                type: 'line',
                // yAxisIndex: 1,
                // zlevel: 2,
                // stack: '总量',
                data: [],
                lineStyle: {
                    width: 3
                },
                color: '#ff3000',
                symbol: 'circle',
                symbolSize: 12
            },
            {
                name: '已处理',
                type: 'bar',
                stack: '总量',
                // yAxisIndex: 1,
                // label: {
                //     show: true,
                //     position: 'insideTop',
                //     formatter: '{a}\n{c}',
                //     textStyle: {
                //         color: '#fff',
                //         fontSize: 12
                //     }
                // },
                data: [
                    // {
                    //     value: (Math.random() * 1000).toFixed(0) ,
                    //     label:{
                    //         show:true,
                    //         position: 'insideTop',
                    //         formatter: '{a}\n{c}',
                    //         textStyle: {
                    //             color: '#fff',
                    //             fontSize: 12
                    //         }
                    //     }
                    // },
                    // {value: (Math.random() * 1000).toFixed(0) ,label:{show:true}},
                    // {value: (Math.random() * 1000).toFixed(0) ,label:{show:true}},
                    // {value: (Math.random() * 1000).toFixed(0) ,label:{show:true}}
                ],
                color: new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#00ffde'},
                        {offset: 1, color: '#006ea7'}
                    ]
                ),
                legend: {
                    show: false
                }
            },
            {
                name: '未处理',
                type: 'bar',
                stack: '总量',
                // yAxisIndex: 1,
                // label: {
                //     show: true,
                //     position: 'insideTop',
                //     formatter: '{a}\n{c}',
                //     textStyle: {
                //         color: '#fff',
                //         fontSize: 12
                //     }
                // },
                data: [],
                color: '#004675'
            },

        ]
    };
    // 是否首次加载
    this.load_first = true;
};
EchartsRline.prototype = {
    constructor: EchartsRline,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    right_line: function (item) {
        let _self = this;
        // 是否首次加载
        // console.info(item)
        if (_self.load_first) {
            _self.myChart = echarts.init(_self.dom_id);
            _self.load_first = false;
        }
        _self.option.series[2].data = [];
        _self.option.series[3].data = [];
        _self.option.series[0].data = [];
        _self.option.series[1].data = [];
        _self.option.xAxis.data = [];
        for (var i = 0; i < item['本月'].length; i++) {

            // 已处理数据添加
            _self.option.series[2].data.push({
                value: null, label: {
                    show: true,
                    position: 'insideTop',
                    formatter: '{a}\n{c}',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12
                    }
                }
            });
            // 未处理数据添加
            _self.option.xAxis.data[i] = item['本月'][i].orgNm;
            _self.option.series[3].data.push({
                value: null, label: {
                    show: true,
                    position: 'insideTop',
                    formatter: '{a}\n{c}',
                    textStyle: {
                        color: '#fff',
                        fontSize: 12
                    }
                }
            });
            // 上月数据额
            _self.option.series[0].data.push({value: null});
            // 本月数据
            _self.option.series[1].data.push({value: null});
            // 已处理数据赋值
            _self.option.series[2].data[i].value = 0;
            // 未处理数据赋值
            _self.option.series[3].data[i].value = item['本月'][i].driverDangers;
            // 上月赋值
            _self.option.series[0].data[i].value = item['上月'][i].driverDangers;
            // 本月赋值
            _self.option.series[1].data[i].value = item['本月'][i].driverDangers;
            if (_self.option.series[2].data[i].value == 0) {
                _self.option.series[2].data[i].label = false;
            }
            if (_self.option.series[3].data[i].value == 0) {
                _self.option.series[3].data[i].label = false;
            }
        }
        // 数据渲染
        _self.myChart.clear();
        _self.myChart.setOption(_self.option);
    }
};


/**
 * 公共部分
 * @param dom_id
 * @param url_desc
 * @param url
 */
function public_data(dom_id, url_desc, url) {
    var _self = this;
    _self.dom_id = dom_id;
    _self.url_desc = url_desc;
    _self.url = url;
    // 图表实例
    this.myChart = null;
};

/**
 * 时间调用方法
 *
 */
function run_time() {
    var time = document.getElementById("time-data");
    var date = new Date();
    var year = date.getFullYear();
    var mou = date.getMonth() + 1;
    var day = date.getDate();
    // var week = date.getDay();
    var hous = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();
    time.innerHTML = year + "年" + mou + "月" + day + "日" + get_num(hous) + ":" + get_num(min) + ":" + get_num(sec);
}

setInterval(run_time, 1000);

function get_num(time) {
    return time > 9 ? time : "0" + time;
}