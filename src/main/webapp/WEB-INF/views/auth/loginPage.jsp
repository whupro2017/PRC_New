<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/include/taglibs.jsp" %>
<html ng-app="myIndex">
  <head>
    <title>案事件现场勘验综合展示系统</title>
	<meta http-equiv="contentType" content="application/x-javascript; charset=UTF-8">
	<%@ include file="/commons/include/css.jsp" %>
	<style type="text/css">
	 body{
	 background: url(${ctx}/images/modules/auth/login.png);
	 background-size:cover; 
  	 -webkit-background-size:cover;
	  }
	  form{
	     position:absolute;
	     top:20px;
	     left:140px;
	  }
	  #wrapper{
	    width:600px;
	    margin: auto;
	    position:relative;
	    top:250px;
	  }
	  .myinput{
	    margin:0.5em 0px;
	    padding-top:10px;
	    padding-bottom:10px;
	    font-size:20px;
	    height:48px;
	  }
	  .mycheckbox
	  {
	    height:28px;
	    line-height:28px;
	  }
	</style>
  </head>
  <body>
      <div id="wrapper">
      <!-- <img alt="" src="${ctx}/images/modules/auth/login.png"> -->
      
      <form ng-controller="formCtrl" action="${ctx}/spring_security_check" method="POST">
        <h5 class="text-warning" ng-show="errorExist"><span class="center-block" style="text-align:center" ng-bind="error"></span></h5>
        <input type="text" id="inputEmail" class="form-control myinput"  placeholder="用户名" name="username" required autofocus>
        <input type="password" id="inputPassword" class="form-control myinput"  placeholder="密码"   name="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" class="mycheckbox" style="margin-top: 0px"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block myinput" type="submit">登录</button>
      </form>
    </div> <!-- /container -->
    <%@ include file="/commons/include/login.jsp" %>
    <script type="text/javascript">
	  var myIndex= angular.module("myIndex",[]);
	  myIndex.controller("formCtrl",function($scope)
	  {
		  $scope.errorExist=${!empty error};
		  $scope.error="用户名或密码错误";
	  });
	</script>
  </body>
</html>