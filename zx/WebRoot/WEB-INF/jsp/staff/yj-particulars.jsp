<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>OI - ${companyStaffer.company_name}</title>
    <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-particulars.css">
</head>
<body>
<header>
    <a href="javascript:;" class="back" >
        <i class="iconfont icon-fanhui"></i>
    </a>
   <p >个人资料</p>
</header>
<main>
    <p class="personTitle">&nbsp;</p>
    <div class="person">
        <div class="person-head">
			<c:if test="${staff.face !=null && staff.face!='' }">
				<img src="http://oi.sxfs0351.com/${staff.face}" alt="" style="width: 100%;height: 100%;">
			 </c:if>
			<c:if test="${staff.face==null || staff.face=='' }">
			   <img src="${staff.header}" alt="" style="width: 100%;height: 100%;">
			</c:if>
           <%--  <img src="${staff.header }" alt="头像" style="width: 100%; height: 100%;"> --%>
        </div>
        <div class="person-message">
        	<input type="hidden" id="user_id" value="${staff.user_id}">
            <li>姓&nbsp;&nbsp;&nbsp;名：<span class="name">${staff.realname }</span></li>
            <li>部&nbsp;&nbsp;&nbsp;门：<span class="bumen">技术开发部</span></li>
            <li>电&nbsp;&nbsp;&nbsp;话：<span class="phone" style="">${staff.phone }</span></li>
            <li>邮&nbsp;&nbsp;&nbsp;箱：<span class="email">${staff.email }</span></li>
            <li>入职时间： <span class="time">${staff.hire_date }</span></li>
        </div>
    </div>
    <div class="mark">
        <ul>
            <li>
                <span>${staff.qualityavg }</span>

                <div class="mark1">
                    <ul>
                        <li>mark</li>
                        <li>工作质量</li>
                    </ul>
                </div>
            </li>
            <li>
                <span>${staff.efficiencyavg}</span>

                <div class="mark1">
                    <ul>
                        <li>mark</li>
                        <li>工作效率</li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <p class="personTitle">个人能力评价</p>
    <div id="echars" style="width: 100%;height:400px;"></div>
    <p class="personTitle">任务统计</p>
    <div id="dataLine" style="width: 100%;height:400px;"></div>
</main>
</body>
<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/echarts.min.js"></script>
<!-- 日期格式转换JS -->
<script src="${pageContext.request.contextPath }/statics/js/dateFromt.js"></script>
<script>
    $(".back").click(function () {
        history.back();
    });
   
    	//入职时间转换
    	var time=$(".time");
    	var date=null;
    	if(time.html() !=null && time.html()!=""){
    		date=Todate(time.html());
    	}
    	
    	$(".time").html(date);
		//入职时间转换转换

var user_id=$("#user_id").val();

    $.ajax({
        url:" ${pageContext.request.contextPath }/Newstaff/selfInfo/"+user_id,
        dataType:"json",
        type:"POST",
        success:function (data) {
            /*data包括    个人信息：   头像  姓名 部门职位 电话 邮箱 入职时间  工作质量工作效率
            *             雷达图 ： 质量' '效率', '领导', '沟通',  '学习','创新'
            *             折线图 ：  1-12月的已完成 未完成 及逆行中
            * */
            console.log(data)
            var e=data.extend;
            var Radar=e.Radar;//雷达图
             var carry=e.carry;//进行中
              var complete=e.complete;   //已完成           
               var count=e.count;//总数
               
              
                var month=e.month;//月份
                 var staff=e.staff;//雷达图
                 var undo=[];
                 for(var i=0;i<count.length;i++){
                 	undo[i]=count[i]-carry[i];
                 
                 }
            var names=[];
            var val=[];
            for(var i=0;i<Radar.length;i++){
                names.push({"name":Radar[i].name,"max":5})
                val.push(parseFloat(Radar[i].max))
            }
            console.log(names,val)
            //    雷达图
            var myChart = echarts.init(document.getElementById('echars'));
            //    myChart.showLoading();
            var option = {
                title: {
                    text: '',

                },

                legend: {
                    data: '预算分配（Allocated Budget）'
                },
                radar: {
                    // shape: 'circle',
                    name: {
                        textStyle: {
                            color: '#fff',
                            backgroundColor: '#999',
                            borderRadius: 3,
                            padding: [3, 5]
                        }
                    },
                    indicator: names
                },
                series: [{
                    name: '预算 vs 开销（Budget vs spending）',
                    type: 'radar',
                    // areaStyle: {normal: {}},
                    data : [
                        {
                            value :val,
                            areaStyle :{
                                normal: {
                                    color: '#13a3ff'
                                }
                            },
                            name : '预算分配（Allocated Budget）',
                            label: {
                                normal: {
                                    show: true,
                                    formatter:function(params) {
                                        return params.value;
                                    }
                                }
                            }
                        },


                    ]
                }]
            };
            myChart.setOption(option);

            //    折线图
            var myChart1 = echarts.init(document.getElementById('dataLine'));
            //    myChart1.showLoading();
            var option1 = {
                title : {
                    text: '',
                    subtext: ''
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['已完成','未完成','进行中']
                },
                toolbox: {
                    show : false,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : month
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel : {
                            formatter: '{value} '
                        }
                    }
                ],
                series : [
                    {
                        name:'已完成',
                        type:'line',
                        data: complete

                    },
                    {
                        name:'未完成',
                        type:'line',
                        data: undo

                    }, {
                        name:'进行中',
                        type:'line',
                        data: carry

                    }


                ]
            };
            myChart1.setOption(option1);

        },
        error:function () {
            
        }

    });




</script>
</html>