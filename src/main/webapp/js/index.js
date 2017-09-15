/**
 * Created by 柳阳 on 2017/9/7.
 *
 */
$(function() {
    $("#cardid").focus();
    $("#confirm").click(onConfirm);
    $("#reset").click(onReset);
});

//检查表单事件
function checkForm() {
    var $cardId = $("#cardId");
    var $password = $("#password");
    var cardId = $.trim($cardId.val());
    var password = $.trim($password.val());
    var $info = $("#info");
    if(cardId == "") {
        $info.html("<font style='color:red'>请输入卡号</font>");
        $cardId.focus();
        return false;
    }
    if(password == "") {
        $info.html("<font style='color:red'>请输入密码</font>");
        $password.focus();
        return false;
    }
    return true;
}

//复位事件
function onReset() {
    $("#cardId").val("").focus();
    $("#password").val("");
    $("#info").html("");
}

//提交事件
function onConfirm() {
    //检查表单
    if(!checkForm()) return;
    var searchType = $("input[name='searchType']:checked").val();
    //查询余额
    if(searchType == "balance") {
        getCardInfo();
    }
    //查询流水
    else if (searchType == "log") {
        getCardLog();
    }

}

//查询余额
function getCardInfo() {
    var cardId = $.trim($("#cardId").val());
    var password = $.trim($("#password").val());
    var $info = $("#info");
    $.ajax({
        type : "GET",
        async : false,
        dataType : "JSON",
        url : "allinpay/getCardInfo",
        data : {"cardId" : cardId, "password" : password, vevoly : Date()},
        success : function(data) {
            //返回错误信息
            if(data.error_response) {
                if(data.error_response.sub_msg) {
                    $info.html("<font style='color:red'>" + data.error_response.sub_msg + "</font>");
                } else {
                    $info.html("<font style='color:red'>" + data.error_response.msg + "</font>");
                }

            }
            //返回正确信息
            else if(data.card_cardinfo_get_response){
                var cardInfo = data.card_cardinfo_get_response.card_info;
                var cardProductInfoArrays = cardInfo.card_product_info_arrays;
                var cardProductInfo = cardProductInfoArrays.card_product_info;
                //账户余额
                var accountBalance = cardProductInfo[0].account_balance;
                //有效余额
                var validBalance = cardProductInfo[0].valid_balance;
                //有效期
                var validDate = cardInfo.validity_date;
                //卡状态
                var cardStatus = convertCardStatus(cardInfo.card_stat);

                $info.html("<ul><li>账户状态：" + cardStatus + "</li><li>账户余额：" + formatMoney(accountBalance) + "</li><li>可用余额：" + formatMoney(validBalance) + "</li><li>账户有效期：" + validDate + "</li></ul>");
            }

        },
        error : function() {
            $info.html("网络连接失败，请检网络后重试!");
        }

    });
}

//查询流水
function getCardLog() {
    var cardId = $.trim($("#cardId").val());
    var password = $.trim($("#password").val());
    var $info = $("#info");

    $.ajax({
        type : "GET",
        async : false,
        dataType : "JSON",
        url : "allinpay/getCardLog",
        data : {"cardId" : cardId, "password" : password, "pageSize" : 1000, vevoly : Date()},
        success : function(data) {
            //返回错误信息
            if(data.error_response) {
                if(data.error_response.sub_msg) {
                    $info.html("<font style='color:red'>" + data.error_response.sub_msg + "</font>");
                } else {
                    $info.html("<font style='color:red'>" + data.error_response.msg + "</font>");
                }

            }
            //返回正确信息
            else if(data.ppcs_txnlog_search_response){
                //记录数据
                var txn_log = data.ppcs_txnlog_search_response.txn_log_arrays.txn_log;
                //总记录数
                var total = data.ppcs_txnlog_search_response.total;

                var table_html = "<table><thead><tr><th>序号</th><th>交易流水号</th><th>交易日期</th><th>交易时间</th><th>商户号</th><th>终端号</th><th>交易金额</th><th>手续费</th><th>交易码</th><th>交易状态</th></tr></thead>";
                var tr_html = "";
                var td = "<tbody>";
                for(var i = 0; i < txn_log.length; i++) {
                    td = txn_log[i];
                    tr_html += "<tr><td>" + (i+1) + "</td><td>" + td.int_txn_seq_id + "</td><td>" + td.int_txn_dt+ "</td><td>" + td.int_txn_tm + "</td><td>" + td.accept_brh_id + "</td><td>" + td.term_id + "</td><td>" + formatMoney(td.txn_at) + "</td><td>" + formatMoney(td.txn_fee_at) + "</td><td>" + td.txn_cd + "-" + convertTxnCd(td.txn_cd) + "</td><td>" + convertTxnStatus(td.txn_sta_cd) + "</td></tr>";
                }
                table_html += tr_html + "</tbody></table>";
                $info.html(table_html);
            }

        },
        error : function() {
            $info.html("网络连接失败，请检网络后重试!");
        }

    });
}
//卡状态 转换
function convertCardStatus(stat) {
    return {
        0 : "正常",
        1 : "挂失",
        2 : "冻结",
        3 : "作废"
    }[stat];
}

//交易状态 转换
function convertTxnStatus(stat) {
    return {
        0 : "挂起",
        1 : "失败",
        2 : "成功",
        3 : "已冲正",
        4 : "撤销"
    }[stat];
}

//交易码 转换
function convertTxnCd(stat) {
    return {
        "B0010" : "消费",
        "B0011" : "消费撤销",
        "B0012" : "消费冲正",
        "B0013" : "消费撤销冲正",
        "B0020" : "网上支付",
        "B0071" : "退货申请确认"
    }[stat];
}

//格式化金钱
function formatMoney(money) {
    var value = money + "";
    var head = value.substring(0, value.length - 2);
    var tail = value.substring(value.length - 2);
    return head + "." + tail + "元";
}