
<header id="header">
	<!--header-->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		id="slide-nav">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-toggle"> <span class="sr-only">Toggle
						navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a> <a class="navbar-brand" href="home">eManglaSons</a>
				<!-- <a class="navbar-brand" href="home"><img src="images/home/logo.png" alt="" /></a>  -->
			</div>

			<div id="slidemenu">
				<g:formRemote update="mainContent"
					url="[action:'searchProducts',controller:'product']"
					name="searchform" class="navbar-form navbar-right">
					<div class="form-group">
						<g:textField name="searchTerm" placeholder="Search Term Here"
							class="form-control" />
					</div>

				</g:formRemote>

				<ul class="nav navbar-nav">
					<g:each in="${msCatalog?.categories}" var="topCategory">
						<li class="dropdown">
						<g:link class="dropdown-toggle"
								data-toggle="dropdown" controller="product" action="productlist"
								params='[id:"${topCategory.id}"]'>
								${topCategory.name}
								<g:if test="${topCategory.childMapping}">
									<b class="caret"> </b>
								</g:if>
							</g:link>
							<ul class="dropdown-menu">
								<g:each in="${topCategory.childMapping}" var="childCategory">
									<li><g:link controller="product" action="productlist"
											params='[id:"${childCategory.child.id}"]'>
											${childCategory.child.name}
										</g:link></li>
								</g:each>
							</ul>
						</li>
					</g:each>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><i class="fa fa-user"></i> Account</a></li>
					<li><g:link url="contactus">
							<i class="fa fa-sign-in"> Contact Us</i>
						</g:link></li>
					<sec:ifLoggedIn>
						<li><g:link url="logout">
								<i class="fa fa-sign-in"> Logout</i>
							</g:link>
						<li>
					</sec:ifLoggedIn>
					<sec:ifNotLoggedIn>
						<li><g:link url="login">
								<i class="fa fa-sign-in"> Login</i>
							</g:link>
						<li>
					</sec:ifNotLoggedIn>
				</ul>
			</div>
		</div>
	</div>
</header>

