// 当页面加载之后
window.onload=function  () {
	// 常量 const   默认的750屏幕大小和100px字体大小
	const designWidh=750;
	const fontSize= 100;
	//屏幕大小发生改变
	function resizeFont(){
		// 变量 var
		var CW = document.documentElement.clientWidth; //获取屏幕大小
		
		var radio = CW/designWidh; //  当前的大小/默认得到比例

		var newFontSize= fontSize*radio;

		document.querySelector("html").style.fontSize= newFontSize + "px";
		
	}
	// 执行resizeFont
	resizeFont();
	// 窗口大小改变时执行resizeFont
	window.onresize= resizeFont;
	window.addEventListener("orientationchange",resizeFont)
}