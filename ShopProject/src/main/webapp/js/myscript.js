var countdown=60;
var realcode;
function huoqu(){
	var phone = $("#phone").val();
	var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		if(!reg.test(phone)){
			$("#phonets").html("手机格式不正确！");
			$("#phonets").css("color","red");
			return;
		}else{
			$("#phonets").html("");
		}
	$.ajax({
		url:"phonecode",
		data:"phone="+phone,
		type:"post",
		success:function(x){
			var obj = $("#dyMobileButton");
			settime(obj);
			realcode=x;
			
			$("#phone").change(function(){
				var phone1 = $(this).val();
				if(phone1!=phone){
					$("#phonets").html("手机号码与之前不一致！");
					$("#phonets").css("color","red");
				}else{
					$("#phonets").html("");
				}
			});
		}
	});
}
function settime(obj) { //发送验证码倒计时
    if (countdown == 0) { 
    	obj.attr("onclick","huoqu();");
        $("#sendMobileCode").attr("href","javascript:void(0);");
//        $("#sendMobileCode").removeAttr("opacity");
        //obj.removeattr("disabled"); 
        obj.html("获取");
        countdown = 60; 
        return;
    } else { 
        obj.attr("onclick","null");
        $("#sendMobileCode").removeAttr("href");
//        $("#sendMobileCode").css("opacity",0.5);
        obj.html(countdown+"s");
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj) }
    ,1000) 
}

function phonezc() {
		var phone = $("#phone").val();
		var code = $("#code").val();
		var pwd = $("#ppassword").val();
		var repwd = $("#ppasswordRepeat").val();
		if(phone==""){
			$("#phonets").html("手机号码不能为空！");
			$("#phonets").css("color","red");
			return;
		}
		if(code==""){
			$("#codets").html("验证码不能为空！");
			$("#codets").css("color","red");
			return;
		}else{
			$("#codets").html("");
		}
		if(realcode==""){
			$("#codets").html("请获取验证码！");
			$("#codets").css("color","red");
			//setTimeout("$('#codets').html('');",3000);
			return;
		}else{
			$("#codets").html("");
		}
		if(code!=realcode){
			$("#codets").html("验证码错误！");
			$("#codets").css("color","red");
			//setTimeout("$('#codets').html('');",3000);
			return;
		}else{
			$("#codets").html("");
		}
		if(pwd==""){
			$("#ppasswordts").html("密码不能为空！");
			$("#ppasswordts").css("color","red");
			return;
		}else{
			$("#ppasswordts").html("");
		}
		if(pwd!=repwd){
			$("#ppasswordRepeatts").html("密码不一致！");
			$("#ppasswordRepeatts").css("color","red");
			return;
		}else{
			$("#ppasswordRepeatts").html("");
		}
		$("#form1").submit();
	}
function emailzc(){
	var email = $("#email").val();
	var pwd = $("#password").val();
	var repwd = $("#passwordRepeat").val();
	if(email==""){
		$("#emailts").html("邮箱不能为空！");
		$("#emailts").css("color","red");
		return;
	}else{
		$("#emailts").html("");
	}
	if(pwd==""){
			$("#passwordts").html("密码不能为空！");
			$("#passwordts").css("color","red");
			return;
		}else{
			$("#passwordts").html("");
		}
		if(pwd!=repwd){
			$("#passwordRepeatts").html("密码不一致！");
			$("#passwordRepeatts").css("color","red");
			return;
		}else{
			$("#passwordRepeatts").html("");
		}
	$("#eform").submit();
}

$(function(){
	//同意XXX服务
	$("#reader-me").click(function(){
		if($(this).is(":checked")){
			$("#yxzc").attr("disabled",false);
		}else{
			$("#yxzc").attr("disabled",true);
		}
	});
	$("#reader-me1").click(function(){
		if($(this).is(":checked")){
			$("#phonezc").attr("disabled",false);
		}else{
			$("#phonezc").attr("disabled",true);
		}
	});
	

	//正则
	$("#email").blur(function(){
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(!reg.test($(this).val())){
			$("#emailts").html("邮箱格式不正确！");
			$("#emailts").css("color","red");
			setTimeout("$('#emailts').html('');",1500);
		}
//		$.ajax({
//			url:'',
//			type:'post',
//			success:function(data){
//				if(data=="error"){
//					$("#emailts").html("邮箱已存在，请换一个邮箱！");
//					$("#emailts").css("color","red");
//					return;
//				}else{
//					$("#emailts").html("");
//					location.href="login.jsp";
//				}
//			}
//		
//		});
	});
	$("#phone").blur(function(){
		var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|17[0-9]|16[0-9])\\d{8}$/;
		if(!reg.test($(this).val())){
			$("#phonets").html("手机格式不正确！");
			$("#phonets").css("color","red");
			setTimeout("$('#phonets').html('');",1500);
		}
	});
	$("#code").change(function(){
		var reg=/^.+$/;
		if(!reg.test($(this).val())){
			$("#codets").html("验证码不能为空");
			$("#codets").css("color","red");
			setTimeout("$('#codets').html('');",1500);
		}
	});
	$("#password").blur(function(){
		var reg = /^\w{6,18}$/;
		if(!reg.test($(this).val())){
			$("#passwordts").html("密码格式不正确！");
			$("#passwordts").css("color","red");
			setTimeout("$('#passwordts').html('');",1500);
		}
	});
	
	$("#passwordRepeat").blur(function(){
		if($("#password").val()!=$("#passwordRepeat").val()){
			$("#passwordRepeatts").html("密码不一致！");
			$("#passwordRepeatts").css("color","red");
			setTimeout("$('#passwordRepeatts').html('');",1500);
		}
	});
	$("#ppassword").blur(function(){
		var reg = /^\w{6,18}$/;
		if(!reg.test($(this).val())){
			$("#ppasswordts").html("密码格式不正确！");
			$("#ppasswordts").css("color","red");
			setTimeout("$('#ppasswordts').html('');",1500);
		}
	});
	
	$("#ppasswordRepeat").blur(function(){
		if($("#ppassword").val()!=$("#ppasswordRepeat").val()){
			$("#ppasswordRepeatts").html("密码不一致！");
			$("#ppasswordRepeatts").css("color","red");
			setTimeout("$('#ppasswordRepeatts').html('');",1500);
		}
	});
});

