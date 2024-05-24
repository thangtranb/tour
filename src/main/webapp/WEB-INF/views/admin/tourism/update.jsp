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
<title>Update Tourism</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-center">Update Tourism</h1>
		<form action="${pageContext.request.contextPath}/admin/tourism/update"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="idTour" value="${tourism.idTour}" />
			<div class="form-group">
				<label for="">Location Name</label> <input type="text"
					name="locationName" class="form-control"
					value="${tourism.locationName}" />
			</div>

			<div class="form-group">
				<label for="">Image</label> <input type="file" name="file"
					class="form-control" /> <img alt=""
					src="${pageContext.servletContext.contextPath}/${tourism.image}"
					width="60px">

			</div>



			<div class="form-group">
				<label for="description">Description</label>
				<textarea name="description" cols="132" rows="5">${tourism.description}</textarea>
			</div>

			<div class="form-group">
				<label for="name">Location</label> <input name="location"
					type="text" class="form-control" value="${tourism.location}" />
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Price</label>
				<input name="price" type="number" class="form-control"
					value="${tourism.price}" />
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Created
					at</label> <input name="created_at" type="date" class="form-control"
					value="${tourism.created_at}" />${tourism.created_at}
			</div>

			<div class="form-group">
				<label for="name" class="col-md-3 text-md-right col-form-label">Update
					at</label> <input name="update_at" type="date" class="form-control"
					value="${tourism.update_at}" />${tourism.update_at}
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