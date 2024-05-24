<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Pages</title>
</head>
<body>
	<div class="container-fluid pt-4 px-4">
		<div class="row">
			<div class="col-sm-12 col-xl-12">
				<div class="bg-light rounded h-100 p-4">
					<div class="text-center">
						<a href="?lang=en_US"><spring:message code="en" text="English" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="?lang=vi_VN"><spring:message code="vi"
								text="Vietnamese" /></a> <br>
					</div>
					<h6 class="mb-4">
						<spring:message code="courseTable" text="Customer Table" />
					</h6>
					<a class="btn btn-primary" href="customer/insertCustomer"
						role="button"><spring:message code="addNewCourse"
							text="Add New Customer" /></a>
					<div class="card-header mr-3">
						<form method="post"
							action="${pageContext.request.contextPath}/admin/customer/search">
							<div class="input-group">
								<div class="form-outline" data-mdb-input-init>
									<input type="search" id="search" name="key"
										class="form-control" placeholder="Search.." />
								</div>
								<button type="button" class="btn btn-primary"
									data-mdb-ripple-init>
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col"><spring:message code="courseId"
										text="Customer Id" /></th>
								<th scope="col"><spring:message code="courseName"
										text=" Name" /></th>
								<th scope="col"><spring:message code="description"
										text="Address" /></th>
								<th scope="col"><spring:message code="image" text="Email" /></th>
								<th scope="col"><spring:message code="numberOfStudent"
										text="Phone" /></th>
								<th scope="col"><spring:message code="price" text="Payment" /></th>
								<th scope="col"><spring:message code="status"
										text="Created_at" /></th>
								<th scope="col"><spring:message code="schedule"
										text="Update_at" /></th>
								<th scope="col"><spring:message code="action" text="Action" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${customer}" var="c">
								<tr>
									<td>${c.customerId }</td>
									<td>${c.name }</td>
									<td>${c.address}</td>
									<td>${c.email}</td>
									<td>${c.phone }</td>
									<td>${c.payment }</td>
									<td>${c.created_at }</td>
									<td>${c.update_at }</td>
									<td class="text-center"><a
										href="${pageContext.request.contextPath}/admin/customer/edit?customerId=${c.customerId}"
										data-toggle="tooltip" title="Edit" data-placement="bottom"
										class="btn btn-outline-warning border-0 btn-sm"> <span
											class="btn-icon-wrapper opacity-8"> <i
												class="fa fa-edit fa-w-20"></i>
										</span>
									</a>
										<form class="d-inline"
											action="${pageContext.request.contextPath}/admin/customer/delete?customerId=${c.customerId}"
											method="post">
											<button
												class="btn btn-hover-shine btn-outline-danger border-0 btn-sm"
												type="submit" data-toggle="tooltip" title="Delete"
												data-placement="bottom"
												onclick="return confirm('Are you sure??')">
												<span class="opacity-8"> <i class="fa fa-trash"></i>
												</span>
											</button>
										</form></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:forEach items="${list }" var="page">
						<a href="course?page=${page}">${page}</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>