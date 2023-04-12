<%--
- list.jsp
-
- Copyright (C) 2012-2023 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
    <acme:input-textbox code="lecturer.lecture.label.title" path="title"/>
    <acme:input-textarea  code="lecturer.lecture.label.abstractDoc" path="abstractDoc"/>
    <acme:input-textbox code="lecturer.lecture.label.estimatedHours" path="estimatedHours"/>
    <acme:input-textarea code="lecturer.lecture.label.body" path="body"/>
    <acme:input-textbox code="lecturer.course.label.type" path="type"/>
    <acme:input-url code="lecturer.course.label.moreInfo" path="moreInfo"/>
    
    <jstl:choose>
	    <jstl:when test="${_command == 'create'}">
	      <acme:submit code="lecturer.lecture.button.create" action="/lecturer/lecture/create"/>
	    </jstl:when>
   		<jstl:when test="${acme:anyOf(_command, 'show|update|publish') && draftMode == true}">
	      <acme:submit code="lecturer.lecture.button.update" action="/lecturer/lecture/update"/>
	      <acme:submit code="lecturer.lecture.button.delete" action="/lecturer/lecture/delete"/>
	      <acme:submit code="lecturer.lecture.button.publish" action="/lecturer/lecture/publish"/>
    	</jstl:when>
  	</jstl:choose>
</acme:form>