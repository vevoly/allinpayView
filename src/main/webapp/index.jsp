<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>通联支付查询接口</title>
    <script src="js/jquery2.1.1.min.js" type="text/javascript"></script>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="bindContainer">
    <div class="pageTitle">查询卡信息</div>
    <div class="inputRow">
        <span class="title">卡号 </span>
        <input class="input" type="text" id="cardId" maxlength="19"/>
    </div>
    <div class="inputRow">
        <span class="title">密码 </span>
        <input class="input" type="password" id="password" maxlength="6"/>
    </div>
    <div class="tipRow">
        <input type="radio" name="searchType" id="searchBalance" value="balance" checked> <label for="searchBalance">查询余额</label>
        <input type="radio" name="searchType" id="searchLog" value="log"> <label for="searchLog">查询流水(90天内)</label>
    </div>
    <div id="buttonRow">
        <input type="button" id="confirm" value="确定"/>&nbsp;&nbsp; &nbsp;&nbsp;
        <input type="button" id="reset" value="取消"/>
    </div>
    <hr>
    <div id="info"></div>
</div>
</body>
</html>
<script src="js/index.js" type="text/javascript"></script>
