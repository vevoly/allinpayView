<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>通联支付查询接口</title>
    <script src="js/jquery2.1.1.min.js" type="text/javascript"></script>
    <link href="css/index.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        $(function() {
            $("#confirm").click(onConfirm);
        });
    </script>

</head>

<body>
<div class="bindContainer">
    <div class="pageTitle">查询卡信息</div>
    <div class="inputRow">
        <span class="title">卡号 </span>
        <input class="input" type="text" id="cardId" maxlength="19"/>
    </div>
    <div class="tipRow">&nbsp;</div>
    <div id="info" ></div>
    <div class="inputRow">
        <span class="title">密码 </span>
        <input class="input" type="password" id="password" maxlength="6"/>
    </div>
    <div class="tipRow">&nbsp;</div>
    <div id="buttonRow">
        <input type="button" id="confirm" value="确定"/>&nbsp;&nbsp; &nbsp;&nbsp;
        <input type="button" id="reset" value="取消"/>
    </div>
    <hr>
    <div class="explain">
        说明：
    </div>
</div>
</body>
</html>

<script type="text/javascript">

    //检查表单事件
    function checkForm() {
        var cardId = $.trim($("#cardId").val());
        var password = $.trim($("#password").val());


    }

    //提交事件
    function onConfirm() {
        //检查表单
        checkForm();

        var cardId = $.trim($("#cardId").val());
        var password = $.trim($("#password").val());
        var $info = $("#info");
        $.ajax({
            type : "GET",
            async : false,
            dataType : "JSON",
            url : "allinpay/getCardInfo",
            data : {"cardId" : cardId, "password" : password},
            success : function(data) {
                //返回错误信息
                if(data.error_response) {
                    $info.html("<font style='color:red'>" + data.error_response.msg + "</font>");
                }
                //返回正确信息
                else if(data.card_cardinfo_get_response){
                    var cardInfo = data.card_cardinfo_get_response.card_info;
                    var cardProductInfoArrays = cardInfo.card_product_info_arrays;
                    //alert("cardProductInfoArrays = " + cardProductInfoArrays);
                    var cardProductInfo = cardProductInfoArrays.card_product_info;
                    //alert("cardProductInfo = " + cardProductInfo);
                    var balance = cardProductInfo[0].account_balance;
                    //alert("balance = " + balance);
                    $info.html("<font style='color:#5FBF5F'>账户余额：" + balance + "</font>");
                }
                /*if(data.flag) var colour = "#5FBF5F";
                else var colour = "red";

                $info.html("<font style='color:" + colour + "'>" + data.msg + "</font>");*/
            },
            error : function() {
                $info.html("网络连接失败，请检网络后重试!");
            }

        });
    }

</script>