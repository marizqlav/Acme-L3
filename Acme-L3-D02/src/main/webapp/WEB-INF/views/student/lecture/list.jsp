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

<acme:list >
    <acme:list-column code="student.lecture.list.label.title" path="title" width="20%" />
    <acme:list-column code="student.lecture.list.label.abstractText" path="abstractDoc" width="25%"/>
    <acme:list-column code="student.lecture.list.label.learningTime" path="estimatedHours" width="10%"/>
    <acme:list-column code="student.lecture.list.label.body" path="body" width="20%"/>
    <acme:list-column code="student.lecture.list.label.type" path="type" width="10%"/>
    <acme:list-column code="student.lecture.list.label.additionalInfo" path="moreInfo" width="15%"/>
</acme:list>