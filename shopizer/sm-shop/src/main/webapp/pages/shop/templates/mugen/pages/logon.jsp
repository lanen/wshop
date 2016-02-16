<%
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/shopizer-tags.tld" prefix="sm" %> 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<script src="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/modernizr.js" />"></script>
<link href="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/templates/mugen/css/logon.css" />" rel="stylesheet" type="text/css" />

<div class="login-page">
    <div class="login-form">
        <div class="login-content">

            <c:if test="${not empty param.login_error}">
            <div class="form-login-error">
                <h3>Invalid login</h3>
                <p>Enter <strong>demo</strong>/<strong>demo</strong> as login and password.</p>
            </div>
            </c:if>

            <form method="post" role="form" id="form_login">

                <div class="form-group">使用合作网站账号登录
                </div>

				<div class="form-group">

					<a href="<c:url value="/shop/customer/openid/weixin.html" />" class="btn btn-default btn-lg btn-block weixin-button">
						&#160;&#160;
						<i class="fa fa-weixin"></i> |  微信登陆
					</a>

				</div>

                <div class="form-group">
					<em>- or -</em>
				</div>

				<div class="form-group">

					<a href="<c:url value="/shop/customer/openid/qq.html" />" class="btn btn-default btn-lg btn-block qq-button">
						&#160;&#160;
						<i class="fa fa-qq"></i> |  QQ登陆
					</a>

				</div>
                <!--
                <div class="form-group">
					<em>- or -</em>
				</div>

				<div class="form-group">

					<a class="btn btn-default btn-lg btn-block facebook-button">
						&#160;&#160;
						<i class="fa fa-facebook"></i> |  Login with Facebook
					</a>

				</div>
				-->


            </form>
        </div>
    </div>
</div>