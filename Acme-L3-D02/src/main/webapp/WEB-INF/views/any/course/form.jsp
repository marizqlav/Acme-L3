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
    <acme:input-textbox code="any.course.label.code" path="code"/>
    <acme:input-textbox  code="any.course.label.title" path="title"/>
    <acme:input-textarea code="any.course.label.abstractDoc" path="abstractDoc"/>
    <acme:input-textbox code="any.course.label.type" path="type"/>
    <acme:input-money code="any.course.label.price" path="price"/>
    <acme:input-textbox code="any.course.label.lecturer" path="lecturer"/>
    <acme:input-url code="any.course.label.moreInfo" path="moreInfo"/>
</acme:form>