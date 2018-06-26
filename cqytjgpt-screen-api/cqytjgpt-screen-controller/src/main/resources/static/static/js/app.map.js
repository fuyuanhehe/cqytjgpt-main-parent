var app = new Vue({
    el: '#app-map',
    data: {
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
        ],
        pop_data: {
            title: '',
            nav: {
                nav1: 0,
                nav2: 0,
                nav3: 0,
                nav4: 0,
                nav5: 0,
                nav6: 0
            },
            nav_place: {
                nav1: 0,
                nav2: 0,
                nav3: 0,
                nav4: 0,
                nav5: 0,
                nav6: 0
            },
            new_add: {
              nav1: 0,
              nav2: 0,
              nav3: 0,
            },
            all_nav: [
                [
                    {
                        nav1: (Math.random() * 3000).toFixed(0),
                        nav2: (Math.random() * 3000).toFixed(0),
                        nav3: (Math.random() * 100).toFixed(0),
                        nav4: (Math.random() * 3000).toFixed(0),
                        nav5: (Math.random() * 3000).toFixed(0),
                        nav6: (Math.random() * 3000).toFixed(0),
                    }
                ],
                [
                    {
                        nav1: (Math.random() * 3000).toFixed(0),
                        nav2: (Math.random() * 3000).toFixed(0),
                        nav3: (Math.random() * 100).toFixed(0),
                        nav4: (Math.random() * 3000).toFixed(0),
                        nav5: (Math.random() * 3000).toFixed(0),
                        nav6: (Math.random() * 3000).toFixed(0),
                    }
                ],
                [
                    {
                        nav1: (Math.random() * 3000).toFixed(0),
                        nav2: (Math.random() * 3000).toFixed(0),
                        nav3: (Math.random() * 100).toFixed(0),
                        nav4: (Math.random() * 3000).toFixed(0),
                        nav5: (Math.random() * 3000).toFixed(0),
                        nav6: (Math.random() * 3000).toFixed(0),
                    }
                ],
                [
                    {
                        nav1: (Math.random() * 3000).toFixed(0),
                        nav2: (Math.random() * 3000).toFixed(0),
                        nav3: (Math.random() * 100).toFixed(0),
                        nav4: (Math.random() * 3000).toFixed(0),
                        nav5: (Math.random() * 3000).toFixed(0),
                        nav6: (Math.random() * 3000).toFixed(0),
                    }
                ]
            ]
        },
        cut_data: [
            {"name": "万州区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "涪陵区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "渝中区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "大渡口区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "江北区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "沙坪坝区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "九龙坡区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "南岸区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "北碚区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "綦江区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "大足区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "渝北区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "巴南区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "黔江区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "长寿区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "江津区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "合川区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "永川区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "南川区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "璧山区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "铜梁区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "潼南区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "荣昌区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "开州区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "梁平区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "丰都县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "垫江县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "武隆县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "忠县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "云阳县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "奉节县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "巫山县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "巫溪县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "石柱土家族自治县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "秀山土家族苗族自治县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "酉阳土家族苗族自治县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "彭水苗族土家族自治县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "城口县", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "万盛区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "双桥区", "value": (Math.random() * 2000).toFixed(0)},
            {"name": "", "value": (Math.random() * 2000).toFixed(0)}
        ],
        map_num: 0,
        chart_map: null,
        pro: true,
        car: true,
        enter: true,
        x: null,
        y: null,
        no_data_map: false,
    },
    mounted: function () {
        App = DperV('app-map');
        var _self = this;
        _self.$nextTick(function () {
            if(_self.pop_data.new_add.nav1 == 0 ){
                _self.pop_data.new_add.nav1 = '-'
            }
            if(_self.pop_data.new_add.nav2 == 0 ){
                _self.pop_data.new_add.nav2 = '-'
            }
            if(_self.pop_data.new_add.nav3 == 0 ){
                _self.pop_data.new_add.nav3 = '-'
            }
            if( _self.pop_data.nav.nav1 == 0 ){
                _self.pop_data.nav.nav1 = '-'
            }
            if( _self.pop_data.nav.nav2 == 0){
                _self.pop_data.nav.nav2 = '-'
            }
            if( _self.pop_data.nav.nav3 == 0){
                _self.pop_data.nav.nav3 = '-'
            }
            if( _self.pop_data.nav.nav4 == 0 ){
                _self.pop_data.nav.nav4 = '-'
            }
            if( _self.pop_data.nav.nav5 == 0){
                _self.pop_data.nav.nav5 = '-'
            }
            if( _self.pop_data.nav.nav6 == 0){
                _self.pop_data.nav.nav6 = '-'
            }
            if( _self.pop_data.nav_place.nav1 == 0 ){
                _self.pop_data.nav_place.nav1 = '-'
            }
            if( _self.pop_data.nav_place.nav2 == 0){
                _self.pop_data.nav_place.nav2 = '-'
            }
            if( _self.pop_data.nav_place.nav3 == 0){
                _self.pop_data.nav_place.nav3 = '-'
            }
            if( _self.pop_data.nav_place.nav4 == 0 ){
                _self.pop_data.nav_place.nav4 = '-'
            }
            if( _self.pop_data.nav_place.nav5 == 0){
                _self.pop_data.nav_place.nav5 = '-'
            }
            if( _self.pop_data.nav_place.nav6 == 0){
                _self.pop_data.nav_place.nav6 = '-'
            }
            _self.$refs.name[_self.map_num].className = "align-center background-img-full active text-overflow-e";
            _self.chart_map = new EchartsCqMap(App.getView('map'), '重庆地图');
            _self.map_tab_cut(0);
            _self.map_post(function(item){
                App.state('map',2);
                _self.chart_map.cq_map(item);
                _self.chart_map.myChart.on('click',function(itm){
                    for(var i = 0 ; i < item.length ; i++){
                        if(itm.name.substring(0,2) == item[i].orgNm.substring(0,2)){
                            // console.info(item)
                            /**
                             * 接入数
                             */
                            _self.pop_data.new_add.nav1 = item[i].drivers;
                            _self.pop_data.new_add.nav2 = item[i].cars;
                            // _self.pop_data.new_add.nav3 = item[i].drivers;
                            if(_self.pop_data.new_add.nav1 == 0 ){
                                _self.pop_data.new_add.nav1 = '-'
                            }
                            if(_self.pop_data.new_add.nav2 == 0 ){
                                _self.pop_data.new_add.nav2 = '-'
                            }
                            if(_self.pop_data.new_add.nav3 == 0 ){
                                _self.pop_data.new_add.nav3 = '-'
                            }
                            /**
                             * 累计
                             * @type {PaymentItem | number}
                             */
                            _self.pop_data.nav.nav1 = item[i].total;
                            _self.pop_data.nav.nav2 = '-';
                            _self.pop_data.nav.nav3 = '-';
                            _self.pop_data.nav.nav4 = item[i].driverDangers; // 驾驶人
                            _self.pop_data.nav.nav5 = item[i].carDangers; // 机动车
                            _self.pop_data.nav.nav6 = '-';
                            if( _self.pop_data.nav.nav1 == 0 ){
                                _self.pop_data.nav.nav1 = '-'
                            }
                            if( _self.pop_data.nav.nav2 == 0){
                                _self.pop_data.nav.nav2 = '-'
                            }
                            if( _self.pop_data.nav.nav3 == 0){
                                _self.pop_data.nav.nav3 = '-'
                            }
                            if( _self.pop_data.nav.nav4 == 0 ){
                                _self.pop_data.nav.nav4 = '-'
                            }
                            if( _self.pop_data.nav.nav5 == 0){
                                _self.pop_data.nav.nav5 = '-'
                            }
                            /**
                             * 本月
                             * @type {PaymentItem | number}
                             */
                            _self.pop_data.nav_place.nav1 = item[i].monthTotal;
                            _self.pop_data.nav_place.nav2 = '-';
                            _self.pop_data.nav_place.nav3 = '-';
                            _self.pop_data.nav_place.nav4 = item[i].monthDriverDangers; // 驾驶人
                            _self.pop_data.nav_place.nav5 = item[i].monthCarDangers; // 机动车
                            _self.pop_data.nav_place.nav6 = '-';
                            if( _self.pop_data.nav_place.nav1 == 0 ){
                                _self.pop_data.nav_place.nav1 = '-'
                            }
                            if( _self.pop_data.nav_place.nav2 == 0){
                                _self.pop_data.nav_place.nav2 = '-'
                            }
                            if( _self.pop_data.nav_place.nav3 == 0){
                                _self.pop_data.nav_place.nav3 = '-'
                            }
                            if( _self.pop_data.nav_place.nav4 == 0 ){
                                _self.pop_data.nav_place.nav4 = '-'
                            }
                            if( _self.pop_data.nav_place.nav5 == 0){
                                _self.pop_data.nav_place.nav5 = '-'
                            }
                        }
                    }
                })
            });

        })
    },
    methods: {
        //地图点切换事件
        map_tab_cut: function (num) {
            var _self = this;
            var arr = {
                '' : {}
            };

            _self.$refs.name[_self.map_num].className = "align-center background-img-full text-overflow-e";
            _self.$refs.name[num].className = "align-center background-img-full active text-overflow-e";
            if (num == 0) {
                _self.pro = true;
                _self.car = true;
                _self.enter = true;
            } else if (num == 1) {
                _self.pro = true;
                _self.car = false;
                _self.enter = false;
            } else if (num == 2) {
                _self.pro = false;
                _self.car = true;
                _self.enter = false;
            } else if (num == 3) {
                _self.pro = false;
                _self.car = false;
                _self.enter = true;
            }
            _self._self.map_num = num;
        },
        /**
         * map 接口调用
         *
         */
        map_post: function(callback){
            var this_ = this;
            $.ajax({
                url: config.interface.map_data,
                type: 'POST',
                data: '',
                success: function(res){
                    for(var i = 0 ; i < res.data.length ; i ++){
                        // this_.chart_map.option.series[0].data[i].value = '';
                        // console.info(this_.chart_map.option.series[0].data[i].name.substring(0,2))
                        // console.info(res.data[i].orgNm.substring(0,2))
                        if(this_.chart_map.option.series[0].data[0].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[0].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[1].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[1].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[2].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[2].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[3].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[3].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[4].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[4].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[5].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[5].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[6].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[6].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[7].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[7].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[8].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[8].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[9].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[9].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[10].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[10].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[11].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[11].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[12].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[12].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[13].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[13].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[14].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[14].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[15].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[15].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[16].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[16].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[17].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[17].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[18].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[18].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[19].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[19].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[20].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[20].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[21].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[21].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[22].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[22].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[23].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[23].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[24].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[24].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[25].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[25].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[26].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[26].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[27].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[27].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[28].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[28].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[29].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[29].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[30].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[30].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[31].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[31].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[32].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[32].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[33].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[33].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[34].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[34].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[35].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[35].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[36].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[36].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[37].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[37].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[38].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[8].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[39].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[39].value = res.data[i].total;
                        }
                        if(this_.chart_map.option.series[0].data[40].name.substring(0,2) == res.data[i].orgNm.substring(0,2)){
                            this_.chart_map.option.series[0].data[40].value = res.data[i].total;
                        }
                        // this_.cut_data[i].name =
                    }
                    callback(res.data)
                },
                error: function(){
                    this_.no_data_map = true
                }
            })
        }
    },

});

var nameMap = {
    '綦江县': '綦江区',
    '开县': '开州区',
    '荣昌县': '荣昌区',
    '铜梁县': '铜梁区',
    '潼南县': '潼南区',
    '梁平县': '梁平区',
    '武隆县': '武隆县',
    '璧山县': '璧山区',
    '大足县': '大足区'
}

/**
 * 地图
 * @param dom_id      容器ID
 * @param url_desc    接口描述
 * @param url         接口地址
 * @constructor
 */
var EchartsCqMap = function (dom_id, url_desc, url) {
    this.dom_id = dom_id;
    this.url_desc = url_desc;
    this.url = url;
    this.myChart = null;
    this.option = {
        // tooltip: {
        //     trigger: 'item',
        //     // backgroundColor: 'rgba(0,0,0,0)',
        //     // formatter: function () {
        //     //     return "<div style='color: #f00;font-size: 20px;width: 300px;height: 200px; background-color: #ccc;' >哈儿</span>";
        //     // }
        // },
        //区域数值选择器
        dataRange: {
            min: 0,
            max: 10,
            x: 'right',
            y: 'bottom',
            color: [
                '#00ff7d',//00ff7d--原来的绿色
                '#00ffc3',
                '#00f5ee', //00fcec
                '#025bff' //0554ff
            ],
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true,
            textStyle: {
                color: '#fff'
            }
        },
        //地图放大工具
        /*roamController: {
            show: true,
            x: 'right',
            y: 'bottom',
            mapTypeControl: {
                '重庆': true
            }
        },*/
        series: [
            {
                name: '市内',
                type: 'map',
                zlevel: 10,
                z: 10,
                tooltip: {
                    show: true,
                    islandFormatter: '{a}<br>{b}'
                },
                mapType: '重庆',
                roam: false,
                selectedMode: 'single',
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            textStyle: {
                                color: '#fff'
                            }
                        },
                        borderWidth: 1,
                        borderColor: '#7ad4ec'
                    },
                    emphasis: {
                        color: "#ff5400",
                        label: {
                            show: true,
                            textStyle: {
                                color: '#fff'
                            }
                        }
                    }
                },
                nameMap: nameMap,
                data: [
                    {"name": "万州区", "value": 0},
                    {"name": "涪陵区", "value": 0},
                    {"name": "渝中区", "value": 0},
                    {"name": "大渡口区", "value": 0},
                    {"name": "江北区", "value": 0},
                    {"name": "沙坪坝区", "value": 0},
                    {"name": "九龙坡区", "value": 0},
                    {"name": "南岸区", "value": 0},
                    {"name": "北碚区", "value": 0},
                    {"name": "綦江区", "value": 0},
                    {"name": "大足区", "value": 0},
                    {"name": "渝北区", "value": 0},
                    {"name": "巴南区", "value": 0},
                    {"name": "黔江区", "value": 0},
                    {"name": "长寿区", "value": 0},
                    {"name": "江津区", "value": 0},
                    {"name": "合川区", "value": 0},
                    {"name": "永川区", "value": 0},
                    {"name": "南川区", "value": 0},
                    {"name": "璧山区", "value": 0},
                    {"name": "铜梁区", "value": 0},
                    {"name": "潼南区", "value": 0},
                    {"name": "荣昌区", "value": 0},
                    {"name": "开州区", "value": 0},
                    {"name": "梁平区", "value": 0},
                    {"name": "丰都县", "value": 0},
                    {"name": "垫江县", "value": 0},
                    {"name": "武隆县", "value": 0},
                    {"name": "忠县", "value": 0},
                    {"name": "云阳县", "value": 0},
                    {"name": "奉节县", "value": 0},
                    {"name": "巫山县", "value": 0},
                    {"name": "巫溪县", "value": 0},
                    {"name": "石柱土家族自治县", "value": 0},
                    {"name": "秀山土家族苗族自治县", "value": 0},
                    {"name": "酉阳土家族苗族自治县", "value": 0},
                    {"name": "彭水苗族土家族自治县", "value": 0},
                    {"name": "城口县", "value": 0},
                    {"name": "万盛区", "value": 0},
                    {"name": "双桥区", "value": 0},
                    {"name": "", "value": 0}
                ]
            },
        ]
    };
    this.tooltip = document.getElementById("dper-layer");
};
EchartsCqMap.prototype = {
    constructor: EchartsCqMap,
    /**
     * 初始化
     */
    init: function () {

    },
    /**
     * 图表渲染
     */
    cq_map: function (data) {
        var _self = this;
        if (_self.myChart == null) {
            _self.myChart = echarts.init(_self.dom_id);
        }
        var dit = document.getElementById("lg-dit");
        var shut = document.getElementById("shut");
        var title_txt = document.getElementById("nav-title");
        var w = dit.clientWidth;
        var h = dit.clientHeight;
        // 数据渲染
        _self.myChart.setOption(_self.option);
        _self.myChart.on("click", function (itm) {
            title_txt.innerText = itm.name;
            // console.info(data)
            _self.tooltip.style.top = itm.event.y - 130 + "px";
            _self.tooltip.style.left = itm.event.x + 30 + 'px';
            dit.style.top = itm.event.y - h + 'px';
            dit.style.left = itm.event.x - w / 2 + 'px';
            // console.log(itm.name);

            // console.info(window.innerWidth)
            if (window.innerWidth < 560) {
            }
            if (itm.name == '秀山土家族苗族自治县') {
                _self.tooltip.style.top = itm.event.y - 250 + "px";
                _self.tooltip.style.left = itm.event.x - 130 + 'px';
            } else if (itm.name == '酉阳土家族苗族自治县') {
                _self.tooltip.style.top = itm.event.y - 250 + "px";
                _self.tooltip.style.left = itm.event.x - 130 + 'px';
            } else if (itm.name == '黔江区') {
                _self.tooltip.style.top = itm.event.y - 250 + "px";
                _self.tooltip.style.left = itm.event.x - 130 + 'px';
            } else if (itm.name == '石柱土家族自治县') {
                _self.tooltip.style.top = itm.event.y - 250 + "px";
                _self.tooltip.style.left = itm.event.x - 130 + 'px';
            } else if (itm.name == '万州区') {
                _self.tooltip.style.top = itm.event.y + 30 + "px";
                _self.tooltip.style.left = itm.event.x - 200 + 'px';
            } else if (itm.name == '云阳县') {
                _self.tooltip.style.top = itm.event.y + 12 + "px";
                _self.tooltip.style.left = itm.event.x - 130 + 'px';
            } else if (itm.name == '奉节县') {
                _self.tooltip.style.top = itm.event.y + 12 + "px";
                _self.tooltip.style.left = itm.event.x - 230 + 'px';
            } else if (itm.name == '巫山县') {
                _self.tooltip.style.top = itm.event.y + 12 + "px";
                _self.tooltip.style.left = itm.event.x - 230 + 'px';
            } else if (itm.name == '巫溪县') {
                _self.tooltip.style.top = itm.event.y + 12 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '城口县') {
                _self.tooltip.style.top = itm.event.y + 12 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '开州区') {
                _self.tooltip.style.top = itm.event.y + 24 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '彭水苗族土家族自治县') {
                _self.tooltip.style.top = itm.event.y - 280 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '忠县') {
                _self.tooltip.style.top = itm.event.y + 30 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '梁平区') {
                _self.tooltip.style.top = itm.event.y + 30 + "px";
                _self.tooltip.style.left = itm.event.x - 180 + 'px';
            } else if (itm.name == '武隆县') {
                _self.tooltip.style.top = itm.event.y - 280 + "px";
                _self.tooltip.style.left = itm.event.x - 150 + 'px';
            } else if (itm.name == '丰都县') {
                _self.tooltip.style.top = itm.event.y - 280 + "px";
                _self.tooltip.style.left = itm.event.x - 150 + 'px';
            }
            setTimeout(function () {
                _self.tooltip.className = 'dper-layer';
                dit.className = 'lg-img';
            }, 250);
            return itm;
        });
        shut.onclick = function () {
            _self.tooltip.className = 'dper-layer active-map';
            dit.className = 'lg-img active-map';
        }
    }
};