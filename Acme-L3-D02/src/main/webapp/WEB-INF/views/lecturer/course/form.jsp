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
    <acme:input-textbox code="lecturer.course.label.code" path="code"/>
    <acme:input-textbox  code="lecturer.course.label.title" path="title"/>
    <acme:input-textarea code="lecturer.course.label.abstractDoc" path="abstractDoc"/>
    <acme:input-select code="lecturer.course.label.type" path="type" choices="${types}"/>
    <acme:input-money code="lecturer.course.label.price" path="price"/>
    <acme:input-url code="lecturer.course.label.moreInfo" path="moreInfo"/>
    
    <jstl:choose>
	    <jstl:when test="${_command == 'create'}">
	      <acme:submit code="lecturer.course.button.create" action="/lecturer/course/create"/>
	    </jstl:when>
   		<jstl:when test="${acme:anyOf(_command, 'show|update|publish') && draftMode == true}">
	      <acme:submit code="lecturer.course.button.update" action="/lecturer/course/update"/>
	      <acme:submit code="lecturer.course.button.delete" action="/lecturer/course/delete"/>
	      <acme:submit code="lecturer.course.button.publish" action="/lecturer/course/publish"/>
	      <acme:button code="lecturer.course.button.lectures" action="/lecturer/lecture/list-course?courseId=${id}"/>
          <acme:button code="lecturer.course.button.add-lecture" action="/lecturer/lecture-course/add-lecture?courseId=${id}"/>
    	</jstl:when>
    	<jstl:when test="${acme:anyOf(_command, 'show|update|publish')}"> 
    	  <acme:button code="lecturer.course.button.lectures" action="/lecturer/lecture/list-course?courseId=${id}"/>
    	</jstl:when>
  	</jstl:choose>
</acme:form>