$(function () {
//    创建两个数组，名字和工资两个数据
    var names = new Array();
    var salarys = new Array();

//    使用ajax方法得到服务端数据
    $.get("employee", function (data) {
        // alert(data);
        // 遍历五个对象 得到五个对象的名字和工资
        for (var i = 0; i < data.length; i++) {
            alert(data[i].name);
            names[i] = data[i].name;
            salarys[i] = data[i].salary;
        };

//    创建图表
        var options = {
            //    指定图表的图形
            chart: {
                type: "column"//柱形图
            },
            title: {
                text: "员工工资一览表"
            },
            xAxis: {
                //    指定x轴的分类：名字
                categories: names
            },
            yAxis: {
                //    设置最小值为0
                min: 0,
                title: {
                    text: "工资"
                }

            },
            //    数据列表
            series: [{
                name: "工资",
                //    指定工资的数组
                data: salarys
            }]
        };
//    放在div中显示出来 有两种方式，1是jquery的，2是HightCharts的
//1.jquery 绑定数据到div对象上
        $("#container").highcharts(options)


        /* 2.第二种就是charts中的
        var chart{

        }
    */
    });

});

