<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理端</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<link rel="stylesheet" href="assets/css/app.css">
<script src="assets/js/echarts.min.js"></script>
</head>

<body data-type="index">


	<header class="am-topbar am-topbar-inverse admin-header">
	<div class="am-topbar-brand">
		<a href="https://www.jnu.edu.cn/" class="tpl-logo"> <img
			src="assets/img/logo.jpg" alt="" style="margin-top: 15px">
		</a>
	</div>
	<div
		class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right"
		style="margin-top: 27px"></div>

	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-bell-o"></span> 提醒 <span
					class="am-badge tpl-badge-success am-round">5</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-success">5</span> 条提醒
						</h3>
						<a href="###">全部</a>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span>
							【预览模块】移动端 查看时 手机、电脑框隐藏。</a> <span class="tpl-dropdown-list-fr">3小时前</span>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span>
							移动端，导航条下边距处理</a> <span class="tpl-dropdown-list-fr">15分钟前</span></li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span>
							追加统计代码</a> <span class="tpl-dropdown-list-fr">2天前</span></li>
				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-comment-o"></span> 消息
					<span class="am-badge tpl-badge-danger am-round">9</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-danger">9</span> 条新消息
						</h3>
						<a href="###">全部</a>
					</li>
					<li><a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/userImg.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from"> ${ manager.managerName }
							</span> <span class="tpl-dropdown-content-time">10分钟前 </span>
						</span> <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于
								GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
					</a> <a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/user03.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from"> Steam </span> <span
								class="tpl-dropdown-content-time">18分钟前</span>
						</span> <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题，
								建议你在反馈时附上演示，方便我们理解。 </span>
					</a></li>

				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-calendar"></span> 进度 <span
					class="am-badge tpl-badge-primary am-round">4</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-primary">4</span> 个任务进度
						</h3>
						<a href="###">全部</a>
					</li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">Amaze UI 用户中心 v1.2 </span> <span
								class="percent">45%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-success"
										style="width: 45%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">新闻内容页 </span> <span class="percent">30%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-secondary"
										style="width: 30%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">管理中心 </span> <span class="percent">60%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-warning"
										style="width: 60%"></div>
								</div>
						</span>
					</a></li>

				</ul>
			</li>
			<li class="am-hide-sm-only"><a href="javascript:;"
				id="admin-fullscreen" class="tpl-header-list-link"><span
					class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="tpl-header-list-user-nick">${ manager.managerName }</span><span
					class="tpl-header-list-user-ico"> <img
						src="${ manager.headImgPath }" style="margin: 15px"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
					<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
					<li><a
						href="${ pageContext.request.contextPath }/manager_logout.action"><span
							class="am-icon-power-off"></span> 退出</a></li>
				</ul>
			</li>
			<li><a
				href="${ pageContext.request.contextPath }/manager_logout.action"
				class="tpl-header-list-link"><span
					class="am-icon-sign-out tpl-header-list-ico-out-size"
					style="margin-top: 27px"></span></a></li>
		</ul>
	</div>
	</header>

	<div class="tpl-page-container tpl-page-header-fixed">


		<div class="tpl-left-nav tpl-left-nav-hover">
			<br>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="m_index.jsp"
						class="nav-link active"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>查询</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a
								href="${ pageContext.request.contextPath }/project_queryByPage.action?operation=projectList">
									<i class="am-icon-angle-right"></i> <span>项目</span> <i
									class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
							</a> <a
								href="${ pageContext.request.contextPath }/manager_queryByPage.action?operation=managerList">
									<i class="am-icon-angle-right"></i> <span>管理员</span> <i
									class="tpl-left-nav-content tpl-badge-success"> 18 </i>
							</a> <a
								href="${ pageContext.request.contextPath }/student_queryByPage.action?operation=studentList">
									<i class="am-icon-angle-right"></i> <span>成员</span> <i
									class="tpl-left-nav-content tpl-badge-primary"> 5 </i>
							</a> </li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>添加</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block;">
							<li><a
								href="${ pageContext.request.contextPath }/manager_list.action?operation=projectSave">
									<i class="am-icon-angle-right"></i> <span>项目</span> <i
									class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
							</a> <a href="m_save.jsp"> <i class="am-icon-angle-right"></i>
									<span>管理员</span>
							</a> <a
								href="${ pageContext.request.contextPath }/project_list.action?operation=studentSave">
									<i class="am-icon-angle-right"></i> <span>成员</span>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="m_repwd.jsp"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>修改密码</span>

					</a></li>
				</ul>
			</div>
		</div>

		<div class="tpl-content-wrapper">
			<ol class="am-breadcrumb">
				<li><a href="manager-index.jsp" class="am-icon-home">首页</a></li>
				<li><a href="#">添加</a></li>
				<li><a href="#">项目</a></li>
			</ol>
			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">
						<span class="am-icon-code"></span> 添加项目
					</div>
					<div class="tpl-portlet-input tpl-fz-ml">
						<div class="portlet-input input-small input-inline">
							<div class="input-icon right">
								<i class="am-icon-search"></i> <input type="text"
									class="form-control form-control-solid" placeholder="搜索...">
							</div>
						</div>
					</div>


				</div>
				<div class="tpl-block ">

					<div class="am-g tpl-amazeui-form">


						<div class="am-u-sm-12 am-u-md-9">
							<form class="am-form am-form-horizontal"
								action="${ pageContext.request.contextPath }/project_save.action"
								method="post">
								<div class="am-form-group">
									<label for="user-name" class="am-u-sm-3 am-form-label">项目名
										/ ProjectName</label>
									<div class="am-u-sm-9">
										<input type="text" id="user-name" name="projectName"
											placeholder="请输入项目名 / ProjectName">
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-email" class="am-u-sm-3 am-form-label">所属管理员
										/ Manager</label>
									<div class="am-u-sm-9">
										<select
											<%-- data-am-selected="{btnSize: 'sm'}" --%> name="managerId">
											<s:iterator value="managerList">
												<option value="${ managerId }"><s:property
														value="managerName" /></option>
											</s:iterator>
										</select>
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-intro" class="am-u-sm-3 am-form-label">项目简介
										/ Intro</label>
									<div class="am-u-sm-9">
										<textarea class="" rows="5" id="user-intro"
											name="projectIntro" placeholder="请输入项目简介"></textarea>
									</div>
								</div>

								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
										<button type="submit" class="am-btn am-btn-primary">确认添加</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>










		</div>

	</div>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>

</body>

</html>