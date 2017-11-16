/*将Fri Oct 31 18:00:00 UTC+0800 2008  转换成日期格式*/
function Todate(num)
	{
		//Fri Oct 31 18:00:00 UTC+0800 2008  
		num=num+"";
		var date="";
		var month=new Array();
		 month["Jan"]=1;month["Feb"]=2;month["Mar"]=3;month["Apr"]=4;month["May"]=5;month["Jan"]=6;
		month["Jul"]=7;month["Aug"]=8;month["Sep"]=9;month["Oct"]=10;month["Nov"]=11;month["Dec"]=12;
		var week=new Array();
		week["Mon"]="一";week["Tue"]="二";week["Wed"]="三";week["Thu"]="四";week["Fri"]="五";week["Sat"]="六";week["Sun"]="日";
		str=num.split(" ");
		date=str[5]+"-";
		date=date+month[str[1]]+"-"+str[2]+" "+str[3];
		//date=date+" 周"+week[str[0]];
		 return date;
}

var format = function(time, format)
{
	var t = new Date(time);
	var tf = function(i){return (i < 10 ? '0' : '') + i};
	return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
	switch(a){
	case 'yyyy':
	return tf(t.getFullYear());
	break;
	case 'MM':
	return tf(t.getMonth() + 1);
	break;
	case 'mm':
	return tf(t.getMinutes());
	break;
	case 'dd':
	return tf(t.getDate());
	break;
	case 'HH':
	return tf(t.getHours());
	break;
	case 'ss':
	return tf(t.getSeconds());
	break;
	}
	});
}

/*将时间戳转换成日期格式*/
function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) /*+' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen)*/;//最后拼接时间
    return oTime;
};
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}

	