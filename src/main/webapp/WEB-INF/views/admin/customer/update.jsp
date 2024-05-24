<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-center">Update Customer</h1>
		<form action="${pageContext.request.contextPath}/admin/customer/update">
			<input type="hidden" name="customerId" value="${customer.customerId}" />
			<div class="form-group">
				<label for="">Name</label> <input type="text"
					name="name" class="form-control"
					value="${customer.name}" />
			</div>

			<div class="form-group">
				<label for="">Address</label> <input type="text" name="address"
					class="form-control" value="${customer.address}" /> 

			</div>



			<div class="form-group">
				<label for="description">Email</label>
				<input type="text" name="email"
					class="form-control" value="${customer.email}" />
			</div>

			<div class="form-group">
				<label for="name">Phone</label> <input name="phone"
					type="number" class="form-control" value="${customer.phone}" />
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Payment</label>
				<input name="payment" type="text" class="form-control"
					value="${customer.payment}" />
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Created
					at</label> <input name="created_at" type="date" class="form-control"
					value="${customer.created_at}" />${customer.created_at}
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Update
					at</label> <input name="update_at" type="date" class="form-control"
					value="${customer.update_at}" />${customer.update_at}
			</div>

			<div class="form-group mb-1 p-3">
				<a href="#" class="border-0 btn btn-outline-danger mr-1"> <span
					class="btn-icon-wrapper pr-1 opacity-8"> <i
						class="fa fa-times fa-w-20"></i>
				</span> <span>Cancel</span>
				</a>

				<button type="submit"
					class="btn-shadow btn-hover-shine btn btn-primary">
					<span class="btn-icon-wrapper pr-2 opacity-8"> <i
						class="fa fa-download fa-w-20"></i>
					</span> <span>Save</span>
				</button>
			</div>

			<!-- <button type="submit" class="btn btn-primary">Submit</button> -->
		</form>
	</div>
</body>
</html>