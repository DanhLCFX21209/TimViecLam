<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head">
<title>Work CV</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700&display=swap"
	rel="stylesheet">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/aos.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery.timepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css/bootstrap-reboot.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css/mixins/_text-hide.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/icomoon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-grid.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-reboot.css">

<!-- JS -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/google-map.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<body>
	<nav class="header_menu"
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container-fluid px-md-4	">
			<a class="navbar-brand" href="/">Work CV</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="/" class="nav-link">Trang
							chủ</a></li>
					<li class="'nav-item"><a href="/" class="nav-link">Công
							việc</a></li>
					<li class="nav-item"><a href="/" class="nav-link">Ứng cử
							viên</a></li>
					<!--        <li class="nav-item"><a href="blog.html" class="nav-link">Công ty</a></li>-->
					<!-- 
            <li th:if="${session.user}" class="nav-item"><a th:href="@{'/user/profile/'+${session.user.id}}" th:text="${session.user.fullName}" class="nav-link" ></a> -->

					<ul class="dropdown">
						<li><a href="/">Hồ Sơ</a></li>
						<!--            <li><a href="service-single.html">Đổi mật khẩu</a></li>-->
						<li><a href="/save-job/get-list">Công việc đã lưu</a></li>
						<li><a href="/user/list-post">Danh sách bài đăng</a></li>
						<li><a href="/user/get-list-apply">Công việc đã ứng tuyển</a></li>
						<li><a href="/user/get-list-company">Công ty đã theo dõi</a></li>
						<!--            <li th:if="${session.user.role.id == 2}"><a href="/auth/logout" >Ứng cử viên tiềm năng</a></li>-->
						<li><a href="/auth/logout">Đăng xuất</a></li>

					</ul>
					</li>

					<li></li>

					<li class="nav-item cta mr-md-1"><a href="/recruitment/post"
						class="nav-link">Đăng tuyển</a></li>
					<li class="nav-item cta cta-colored"><a href="/auth/login"
						class="nav-link">Đăng nhập</a></li>

				</ul>
			</div>
		</div>
	</nav>



	<div class="hero-wrap hero-wrap-2"
		style="background-image: url('user${pageContext.request.contextPath}/resources/images/bg_1.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-start">
				<div class="col-md-12 text-center mb-5">
					<h1 class="mb-3 bread">Hồ sơ</h1>
					<form action="${pageContext.request.contextPath}/update-avatar"
						method="POST" enctype="multipart/form-data">
						<input type="hidden" class="form-control" name="userId"
								value="${user.id}" />
						<div class="form-group">
							<label class="btn btn-primary btn-md btn-file"> Chọn ảnh
								<input type="file" name="file" id="fileUpload" hidden>
							</label>
						</div>
						<div style="margin-left: 0px" id="divImage">
							<img id="avatar" height="100" width="100"
								style="border-radius: 50px"
								src="${pageContext.request.contextPath}/resources/images/${user.image != null ? user.image : 'https://st.quantrimang.com/photos/image/072015/22/avatar.jpg'}">
						</div>
						<div class="text-center mt-4">
							<button type="submit" class="btn btn-primary">Lưu</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- HOME -->
<security:authorize access="hasRole('MANAGER')">
<div th:if="${userInformation.status == 0}" class="container-fluid"
		style="text-align: center">
		<p
			style="font-size: 20px; font-weight: bold; color: #aaa; margin-top: 10px">Xác
			thực email đăng nhập</p>
		<div
			style="width: 600px; height: 400px; border-radius: 5px; box-shadow: rgba(0, 0, 0, 0.4) 0px 0px 10px; margin: 20px auto; padding: 15px">
			<p style="line-height: 35px; font-size: 16px">
				Xin chào, <span th:text="${userInformation.fullName}"></span> và làm
				theo hướng dẫn trong email. Trường hợp không nhận được email, bạn
				vui lòng bấm nút Nhận email xác thực dưới đây.
			</p>
			<div class="row form-group">
				<form action="/user/confirm-account" method="post" class="col-md-12">
					<input type="hidden" th:value="${userInformation.email}"
						name="email" class="btn px-4 btn-primary text-white"> <input
						type="submit" value="Nhận email xác thực"
						class="btn px-4 btn-primary text-white">
				</form>
			</div>
			<p>
				Mọi thắc mắc vui lòng liên hệ bộ phận CSKH của WorkCV:<br>
			</p>
			- Điện thoại:<span style="color: #5f80ec">(024) 6680 5588</span><br>
			- Email: <a href="#" style="color: #5f80ec"> hotro@workcv.vn</a>
		</div>
		<div th:if="${comfirm_await}"
			style="width: 600px; height: 400px; border-radius: 5px; box-shadow: rgba(0, 0, 0, 0.4) 0px 0px 10px; margin: 20px auto; padding: 15px">
			<p style="line-height: 35px; font-size: 16px">
				Xin chào, <span th:text="${userInformation.fullName}"></span> .Bạn
				đã gửi yêu cầu xác thực thành công, vui lòng kiểm tra mail để xác
				thực.Cảm ơn bạn!!!
			</p>
			<p>
				Mọi thắc mắc vui lòng liên hệ bộ phận CSKH của WorkCV:<br>
			</p>
			- Điện thoại:<span style="color: #5f80ec">(024) 6680 5588</span><br>
			- Email: <a href="#" style="color: #5f80ec"> hotro@workcv.vn</a>
		</div>
	</div>
</security:authorize>

<security:authorize access="hasRole('EMPLOYEE')">
<section class="site-section" style="margin-top: 10px">
		<div class="container">
			<form action="${pageContext.request.contextPath}/update-cv"
				method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="hidden"
					class="form-control" name="cvId" value="${user.cv.id}" /> <input
					type="hidden" class="form-control" name="userId" value="${user.id}" />

				<div class="row align-items-center mb-5">
					<div class="col-lg-8">
						<div class="d-flex align-items-center">
							<div class="form-group" style="margin-top: 15px">
								<label class="btn btn-primary btn-md btn-file"> Chọn CV
									(PDF)<input type="file" name="cvFile" id="cvFileUpload"
									required hidden>
								</label>
							</div>
						</div>
						<p id="cvName">
							<c:if test="${not empty cv}">
								<c:out value="${cv.fileName}" />
							</c:if>
							<c:if test="${empty cv}">
                                Chưa cập nhập
                            </c:if>
						</p>

					</div>
					<div class="col-lg-4">
						<div class="row">
							<div class="col-6">
								<button type="submit" class="btn btn-block btn-light btn-md">
									<span class="icon-open_in_new mr-2"></span>Cập nhật CV
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<form action="${pageContext.request.contextPath}/update-profile"
				method="POST">
				<security:csrfInput />

				<div class="row align-items-center mb-5">
					<div class="col-lg-8 mb-4 mb-lg-0">
						<div class="d-flex align-items-center">
							<div>
								<h2>Cập nhật thông tin</h2>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="row">
							<div class="col-6">
								<button type="submit" class="btn btn-block btn-primary btn-md">Lưu
									thông tin</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row mb-5">
					<div class="col-lg-12">
						<div class="p-4 p-md-5 border rounded" method="post">
							<h3 class="text-black mb-5 border-bottom pb-2">Thông tin chi
								tiết</h3>
							<input type="hidden" class="form-control" name="userId"
								value="${user.id}" />
							<div class="form-group">
								<label for="email">Email</label> <input type="email"
									class="form-control" id="email" name="email"
									value="${user.email != null ? user.email : null}" required
									placeholder="you@yourdomain.com">
							</div>
							<div class="form-group">
								<label for="job-title">Full name</label> <input type="text"
									class="form-control" name="fullName"
									value="${user.fullName != null ? user.fullName : null}"
									required id="job-title" placeholder="Full name">
							</div>
							<div class="form-group">
								<label for="job-location">Địa chỉ</label> <input type="text"
									name="address"
									value="${user.address != null ? user.address : null}"
									class="form-control" id="job-location" required
									placeholder="e.g. New York">
							</div>
							<div class="form-group">
								<label for="job-location">Số điện thoại</label> <input
									type="text" name="phoneNumber"
									value="${user.phoneNumber != null ? user.phoneNumber : null}"
									class="form-control" id="job-location" required
									placeholder="+ 84">
							</div>
							<div class="form-group">
								<label for="job-location">Mô tả bản thân</label>
								<textarea name="description" class="form-control" id="editor"
									placeholder="Mô tả">${user.description != null ? user.description : null}</textarea>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
</security:authorize>	
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Bạn có chắc
						chắn muốn xóa ?</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Cv : <span id="cvXoa"></span> <span th:if="${Cv != null}"
						th:text="${Cv.fileName}"></span>
					<form action="/user/deleteCv" method="post">
						<div class="modal-footer mt-1">
							<input type="hidden" name="idCv">
							<button type="submit" class="btn btn-secondary"
								data-dismiss="modal">Đóng</button>
							<button type="submit" class="btn btn-danger">Xóa</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	Role(s): <security:authentication property="principal.authorities" />
	<section
		th:if="${userInformation.status == 1 && userInformation.role.id == 2}"
		class="site-section" style="margin-top: 10px">
		<security:authorize access="hasRole('MANAGER')">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-5">
					<h2 class="mb-4">Thông tin cá nhân</h2>
					<form id="profileForm"
						action="${pageContext.request.contextPath}/update-profile"
						method="POST">
						<security:csrfInput />

						<div class="row mb-5">
							<div class="col-lg-12">
								<div class="p-4 p-md-5 border rounded" method="post">
									<input type="hidden" class="form-control" name="userId"
										value="${user.id}" />

									<div class="form-group">
										<label for="email">Email</label> <input type="email"
											class="form-control" id="email" name="email"
											value="${user.email}" required
											placeholder="you@yourdomain.com">
									</div>
									<div class="form-group">
										<label for="job-title">Họ và tên</label> <input type="text"
											class="form-control" name="fullName" value="${user.fullName}"
											id="job-title" required placeholder="Full name">
									</div>
									<div class="form-group">
										<label for="job-location">Địa chỉ</label> <input type="text"
											name="address"
											value="${user.address != null ? user.address : null}"
											required class="form-control" id="job-location"
											placeholder="e.g. New York">
									</div>
									<div class="form-group">
										<label for="job-location">Số điện thoại</label> <input
											type="text" name="phoneNumber"
											value="${user.phoneNumber != null ? user.phoneNumber : null}"
											required class="form-control" id="job-location"
											placeholder="+ 84">
									</div>
									<div class="form-group">
										<label for="job-location">Mô tả bản thân</label>
										<textarea name="description" text="" class="form-control"
											id="editor" placeholder="Mô tả">${user.description != null ? user.description : null}</textarea>
									</div>
									<div class="row form-group">
										<div class="col-md-12">
											<input type="submit" value="Lưu thông tin"
												class="btn px-4 btn-primary text-white">
										</div>
									</div>
								</div>

							</div>

						</div>
					</form>
				</div>
				<div class="col-lg-6">
					<h2 class="mb-4">Thông tin công ty</h2>
					<form action="<c:url value='/update-company'/>" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<label for="company-website-tw d-block1">Cập nhật Logo</label> <br>
							<label class="btn btn-primary btn-md btn-file"> Chọn logo
								<input type="file" name="file" id="fileUpload2" type="hidden"">
							</label>
							<div id="divLogo">
								<img id="avatar1" height="100" width="100"
									style="border-radius: 50px"
									src="${pageContext.request.contextPath}/resources/images/${companyInformation.logo != null ? companyInformation.logo : 'https://st.quantrimang.com/photos/image/072015/22/avatar.jpg'}">
							</div>
						</div>
						<div class="row mb-5">
							<div class="col-lg-12">
								<div class="p-4 p-md-5 border rounded">
									<input type="hidden" name="companyId"
										value="${companyInformation.id}" />
									<div class="form-group">
										<label for="email">Email</label> <input type="text"
											class="form-control" required id="email1" name="email"
											value="${companyInformation.email}"
											placeholder="you@yourdomain.com">
									</div>
									<div class="form-group">
										<label for="job-title">Tên công ty</label> <input type="text"
											class="form-control" name="nameCompany"
											value="${companyInformation.nameCompany}" id="job-title"
											placeholder="Full name" required> <input
											type="hidden" class="form-control" name="user_id"
											value="${companyInformation.user.id}" id="job-title"
											placeholder="Full name"> <input type="hidden"
											class="form-control" name="id"
											value="${companyInformation.id}" id="job-title"
											placeholder="Full name">
									</div>
									<div class="form-group">
										<label for="job-location">Địa chỉ</label> <input type="text"
											name="address" value="${companyInformation.address}" required
											class="form-control" id="job-location"
											placeholder="e.g. New York">
									</div>
									<div class="form-group">
										<label for="job-location">Số điện thoại công ty</label> <input
											type="text" name="phoneNumber"
											value="${companyInformation.phoneNumber}" required
											class="form-control" id="job-location" placeholder="+ 84">
									</div>
									<div class="form-group">
										<label for="job-location">Mô tả công ty</label>
										<textarea name="description" class="form-control" id="editorN"
											placeholder="Mô tả">${companyInformation.description}</textarea>
									</div>

									<div class="row form-group">
										<div class="col-md-12">
											<input type="submit" value="Lưu thông tin"
												class="btn px-4 btn-primary text-white">
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		</security:authorize>
		
	</section>
	<script>
    ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
    })
        .catch(error => {
            console.error(error);
        });
    ClassicEditor.create(document.querySelector('#editorN')).then(eidt => {
        console.log("da" + eidt);
    })
        .catch(error => {
            console.error(error);
        });
</script>
	<script>
    
</script>

	<script>
    
</script>

	<script>
    
</script>

	<footer th:replace="public/fragments :: footer"
		class="ftco-footer ftco-bg-dark ftco-section"> </footer>
</body>
</html>