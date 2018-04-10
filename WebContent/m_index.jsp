<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
					class="am-badge tpl-badge-success am-round">2</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-success">2</span> 条会议提醒
						</h3>
						<a href="###">全部</a>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl">
							基于图片的消防通道安全隐患识别</a> <span class="tpl-dropdown-list-fr">13:00</span>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"></span>
							基于OpenCV的轨道异物检测与识别</a> <span class="tpl-dropdown-list-fr">14:15</span></li>
				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-comment-o"></span> 消息
					<span class="am-badge tpl-badge-danger am-round">149</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-danger">149</span> 条新消息
						</h3>
						<a href="###">全部</a>
					</li>
					<li><a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/user01.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from"> 查宽
							</span> <span class="tpl-dropdown-content-time">10分钟前 </span>
						</span> <span class="tpl-dropdown-content-font"> 下午的会议是否可以请假？ </span>
					</a> <a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/user03.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from"> 杨慧 </span> <span
								class="tpl-dropdown-content-time">18分钟前</span>
						</span> <span class="tpl-dropdown-content-font"> 本月进度报告已经发送，请查收 </span>
					</a></li>

				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-calendar"></span> 进度 <span
					class="am-badge tpl-badge-primary am-round">3</span></span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-primary">3</span> 个项目进度
						</h3>
						<a href="###">全部</a>
					</li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">Android示波器</span> <span
								class="percent">+5%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-success"
										style="width: 45%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">图像隐写</span> <span class="percent">+10%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-secondary"
										style="width: 30%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">基于小波变换的3D压缩研究</span> <span class="percent">+6%</span>
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
					<li><a href="h_img_save.jsp"><span class="am-icon-bell-o"></span> 修改头像</a></li>
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
				<li><a href="#" class="am-icon-home">首页</a></li>
				<li><a href="#">分类</a></li>
				<li><a href="#">内容</a></li>
			</ol>

			<div class="row">
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat blue">
						<div class="visual">
							<i class="am-icon-comments-o"></i>
						</div>
						<div class="details">
							<div class="number">149</div>
							<div class="desc">新消息</div>
						</div>
						<a class="more" href="#"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat red">
						<div class="visual">
							<i class="am-icon-bar-chart-o"></i>
						</div>
						<div class="details">
							<div class="number">15</div>
							<div class="desc">管理项目数</div>
						</div>
						<a class="more" href="${ pageContext.request.contextPath }/project_queryByPage.action?operation=projectList"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat green">
						<div class="visual">
							<i class="am-icon-apple"></i>
						</div>
						<div class="details">
							<div class="number">3</div>
							<div class="desc">新项目进度</div>
						</div>
						<a class="more" href="#"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
					<div class="dashboard-stat purple">
						<div class="visual">
							<i class="am-icon-android"></i>
						</div>
						<div class="details">
							<div class="number">4</div>
							<div class="desc">本月新增项目</div>
						</div>
						<a class="more" href="#"> 查看更多 <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>



			</div>

			<div class="row">
				<div class="am-u-md-6 am-u-sm-12 row-mb">
					<div class="tpl-portlet">
						<div class="tpl-portlet-title">
							<div class="tpl-caption font-green ">
								<i class="am-icon-cloud-download"></i> <span> Lrm 数据统计</span>
							</div>
							<div class="actions">
								<ul class="actions-btn">
									<li class="red-on">本周</li>
									<li class="green">本月</li>
									<li class="blue">本学期</li>
								</ul>
							</div>
						</div>

						<!--此部分数据请在 js文件夹下中的 app.js 中的 “百度图表A” 处修改数据 插件使用的是 百度echarts-->
						<div class="tpl-echarts" id="tpl-echarts-A"></div>
					</div>
				</div>
				<div class="am-u-md-6 am-u-sm-12 row-mb">
					<div class="tpl-portlet">
						<div class="tpl-portlet-title">
							<div class="tpl-caption font-red ">
								<i class="am-icon-bar-chart"></i> <span> Lrm 研究所成员</span>
							</div>
							<div class="actions">
								<ul class="actions-btn">
									<li class="purple-on">大二</li>
									<li class="green">大三</li>
									<li class="dark">大四</li>
								</ul>
							</div>
						</div>
						<div class="tpl-scrollable">
							<div class="number-stats">
								<div class="stat-number am-fl am-u-md-6">
									<div class="title am-text-right">成员总数</div>
									<div class="number am-text-right am-text-warning">126</div>
								</div>
								<div class="stat-number am-fr am-u-md-6">
									<div class="title">项目总数</div>
									<div class="number am-text-success">42</div>
								</div>

							</div>

							<table class="am-table tpl-table">
								<thead>
									<tr class="tpl-table-uppercase">
										<th>姓名</th>
										<th>学号</th>
										<th>项目数</th>
										<th>综合进度</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img src="assets/img/user01.png" alt=""
											class="user-pic"> <a class="user-name" href="###">查宽</a>
										</td>
										<td>2016051347</td>
										<td>2</td>
										<td class="font-green bold">48%</td>
									</tr>
									<tr>
										<td><img src="assets/img/user02.png" alt=""
											class="user-pic"> <a class="user-name" href="###">贺鹏飞</a>
										</td>
										<td>2016051362</td>
										<td>1</td>
										<td class="font-green bold">75%</td>
									</tr>
									<tr>
										<td><img src="assets/img/user03.png" alt=""
											class="user-pic"> <a class="user-name" href="###">吴俊逸</a>
										</td>
										<td>2016053359</td>
										<td>1</td>
										<td class="font-green bold">51%</td>
									</tr>
									<tr>
										<td><img src="assets/img/user04.png" alt=""
											class="user-pic"> <a class="user-name" href="###">叶敬南</a>
										</td>
										<td>2016052375</td>
										<td>2</td>
										<td class="font-green bold">73%</td>
									</tr>
									<tr>
										<td><img src="assets/img/user05.png" alt=""
											class="user-pic"> <a class="user-name" href="###">黄永杰</a>
										</td>
										<td>2016052365</td>
										<td>3</td>
										<td class="font-green bold">40%</td>
									</tr>
									<tr>
										<td><img src="assets/img/user06.png" alt=""
											class="user-pic"> <a class="user-name" href="###">牛博雅</a>
										</td>
										<td>2016052301</td>
										<td>1</td>
										<td class="font-green bold">76%</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="am-u-md-6 am-u-sm-12 row-mb">

					<div class="tpl-portlet">
						<div class="tpl-portlet-title">
							<div class="tpl-caption font-green ">
								<span>会议安排</span> <span class="caption-helper">9 件</span>
							</div>
							<div class="tpl-portlet-input">
								<div class="portlet-input input-small input-inline">
									<div class="input-icon right">
										<i class="am-icon-search"></i> <input type="text"
											class="form-control form-control-solid" placeholder="搜索...">
									</div>
								</div>
							</div>
						</div>
						<div id="wrapper" class="wrapper">
							<div id="scroller" class="scroller">
								<ul class="tpl-task-list">
									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于图片的消防通道安全隐患识别
											</span>
											<span class="label label-sm label-success">13:00-13:20</span>
											<span class="label label-sm label-danger">线上</span>
											<span class="task-bell"> <i class="am-icon-bell-o"></i>
											</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>


											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于OpenCV实现对可见火点特征点的识别
											</span>
											<span class="label label-sm label-success">13:25-13:45</span>
											<span class="label label-sm label-danger">线上</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>


											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于深度学习的可见火点自动识别
											</span>
											<span class="label label-sm label-success">13:50-14:10</span>
											<span class="label label-sm label-danger">线上</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>


											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于网页的非在线信息采集系统
											</span>
											<span class="label label-sm label-default">已取消</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>
											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于OpenCV的轨道异物检测与识别
											</span>
											<span class="label label-sm label-success">14:15-14:35</span>
											<span class="label label-sm label-danger">线上</span>
											<span class="task-bell"> <i class="am-icon-bell-o"></i>
											</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>


											</div>
										</div>
									</li>
									
									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												基于触摸屏的身份认证APP
											</span>
											<span class="label label-sm label-default">已取消</span>

										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>
											</div>
										</div>
									</li>
									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												三维重构中物体边界的自动识别
											</span>
											<span class="label label-sm label-success">14:40-15:00</span>
											<span class="label label-sm label-danger">A307</span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>
											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp">
												常用基础图像处理算法在FPGA上的实现
											</span>
											<span class="label label-sm label-default">已取消</span>

										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>
											</div>
										</div>
									</li>

									<li>
										<div class="task-checkbox">
											<input type="hidden" value="1" name="test"> <input
												type="checkbox" class="liChild" value="2" name="test">
										</div>
										<div class="task-title">
											<span class="task-title-sp"> 按照示例组织好 HTML 结构（不加
												data-am-dropdown 属性），然后通过 JS 来调用。 </span>
											<span class="label label-sm label-success">15:05-15:25</span>
											<span class="label label-sm label-danger">A307</span>
											<span class="task-bell"> <i class="am-icon-bell-o"></i></span>
										</div>
										<div class="task-config">
											<div class="am-dropdown tpl-task-list-dropdown"
												data-am-dropdown>
												<a href="###"
													class="am-dropdown-toggle tpl-task-list-hover "
													data-am-dropdown-toggle> <i class="am-icon-cog"></i> <span
													class="am-icon-caret-down"></span>
												</a>
												<ul class="am-dropdown-content tpl-task-list-dropdown-ul">
													<li><a href="javascript:;"> <i
															class="am-icon-check"></i> 保存
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-pencil"></i> 编辑
													</a></li>
													<li><a href="javascript:;"> <i
															class="am-icon-trash-o"></i> 删除
													</a></li>
												</ul>


											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="am-u-md-6 am-u-sm-12 row-mb">
					<div class="tpl-portlet">
						<div class="tpl-portlet-title">
							<div class="tpl-caption font-green ">
								<span>项目进度</span>
							</div>

						</div>

						<div class="am-tabs tpl-index-tabs" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">进行中</a></li>
								<li><a href="#tab2">已完成</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div id="wrapperA" class="wrapper">
										<div id="scroller" class="scroller">
											<ul class="tpl-task-list tpl-task-remind">
												<li>
													<div class="cosB">1天前</div>
													<div class="cosA">
														<span class="cosIco"> <i class="am-icon-bell-o"></i>
														</span>
														<span>机场跑道上的垃圾检测与定位
															<span class="tpl-label-info"> 查看报告 <i class="am-icon-share"></i>
															</span>
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">1天前</div>
													<div class="cosA">
														<span class="cosIco label-danger"> <i
															class="am-icon-bolt"></i>
														</span>
														<span>
															基于视频结构化描述的交通异常事件识别
														</span>
													</div>

												</li>

												<li>
													<div class="cosB">2天前</div>
													<div class="cosA">
														<span class="cosIco label-info"> <i
															class="am-icon-bullhorn"></i>
														</span>
														<span>
															基于OpenCV的安卓图像处理软件框架
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">2天前</div>
													<div class="cosA">
														<span class="cosIco label-warning"> <i
															class="am-icon-plus"></i>
														</span>
														<span>
															远距离形状识别——神经网络的实现
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">2天前</div>
													<div class="cosA">
														<span class="cosIco"> <i class="am-icon-bell-o"></i>
														</span>
														<span>
															基于BCWT图像压缩算法的联合图像篡改检测
														<span class="tpl-label-info">查看报告<i class="am-icon-share"></i>
														</span>
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">4天前</div>
													<div class="cosA">
														<span class="cosIco label-danger"> <i
															class="am-icon-bolt"></i>
														</span>
														<span>
															基于BCWT图像压缩算法的联合局部加密实现
														</span>
													</div>

												</li>

												<li>
													<div class="cosB">7天前</div>
													<div class="cosA">
														<span class="cosIco label-info"> <i
															class="am-icon-bullhorn"></i>
														</span>
														<span>
															SM2非对称加密算法在FPGA上的实现
														</span>
													</div>

												</li>
												
												<li>
													<div class="cosB">超过7天前</div>
													<div class="cosA">
														<span class="cosIco label-info"> <i
															class="am-icon-bullhorn"></i>
														</span>
														<span>
															基于图像的行人与乘客的检测与识别
														</span>
													</div>

												</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="am-tab-panel am-fade" id="tab2">
									<div id="wrapperB" class="wrapper">
										<div id="scroller" class="scroller">
											<ul class="tpl-task-list tpl-task-remind">
												<li>
													<div class="cosB">1个月前</div>
													<div class="cosA">
														<span class="cosIco"> <i class="am-icon-bell-o"></i>
														</span>
														<span>
															SM4对称加密算法在FPGA上的实现
														<span class="tpl-label-info">查看报告<i class="am-icon-share"></i>
														</span>
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">1个月前</div>
													<div class="cosA">
														<span class="cosIco label-danger"> <i
															class="am-icon-bolt"></i>
														</span>
														<span>
															标签缺陷检测技术研究
														</span>
													</div>

												</li>

												<li>
													<div class="cosB">1个月前</div>
													<div class="cosA">
														<span class="cosIco label-info"> <i
															class="am-icon-bullhorn"></i>
														</span>
														<span>
															视频压缩中分区域的多QP量化技术研究
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">2个月前</div>
													<div class="cosA">
														<span class="cosIco label-warning"> <i
															class="am-icon-plus"></i>
														</span>
														<span>
															基于图片的消防门安全隐患识别
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">2个月前</div>
													<div class="cosA">
														<span class="cosIco"> <i class="am-icon-bell-o"></i>
														</span>
														<span>
														通用物联网数据平台——数据采集与传输
														<span class="tpl-label-info">查看报告<i class="am-icon-share"></i>
														</span>
														</span>
													</div>

												</li>
												<li>
													<div class="cosB">3个月前</div>
													<div class="cosA">
														<span class="cosIco label-danger"> <i
															class="am-icon-bolt"></i>
														</span>
														<span>
															通用物联网数据平台——数据存储与展示
														</span>
													</div>

												</li>

												<li>
													<div class="cosB">超过3个月前</div>
													<div class="cosA">
														<span class="cosIco label-info"> <i
															class="am-icon-bullhorn"></i>
														</span>
														<span>
															通用物联网数据平台——数据综合分析
														</span>
													</div>

												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	From 
	<a href="https://github.com/supercaoO/lrm" target="_blank" title="模板之家">supercaoO</a>
	- Open Source - 
	<a href="https://github.com/supercaoO/lrm" title="网页模板" target="_blank">https://github.com/supercaoO/lrm</a>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/iscroll.js"></script>
	<script src="assets/js/app.js"></script>
</body>

</html>