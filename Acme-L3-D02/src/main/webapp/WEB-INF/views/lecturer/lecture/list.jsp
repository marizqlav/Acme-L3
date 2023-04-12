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

<acme:list>
    <acme:list-column code="lecturer.lecture.label.title" path="title" width="50%"/>
    <acme:list-column code="lecturer.lecture.label.estimatedHours" path="estimatedHours" width="25%"/>
    <acme:list-column code="lecturer.lecture.label.draftMode" path="draftMode" width="25%"/>
    
</acme:list>

<jstl:choose>
    <jstl:when test="${_command == 'list-course'}">
        <acme:button code="lecturer.lecture.button.add-lecture" action="/lecturer/lecture-course/add-lecture?courseId=${courseId}"/>
    </jstl:when>
    <jstl:otherwise>
        <acme:button code="lecturer.lecture.button.create" action="/lecturer/lecture/create"/>
    </jstl:otherwise>
</jstl:choose>