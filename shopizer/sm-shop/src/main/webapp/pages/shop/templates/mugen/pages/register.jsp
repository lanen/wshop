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

<div class="container">
    <div class="row">

        <div class="col-md-3 col-sm-4">

            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
              <input class="form-control" type="text" placeholder="Email address">
            </div>

            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
              <input class="form-control" type="password" placeholder="Password">
            </div>
        </div>
    </div>

</div>