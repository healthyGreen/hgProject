<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>