	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +91 98985 88006</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> prakash@manglasons.in</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<sec:ifLoggedIn>
									<!-- <li> <g:remoteLink class="logout buttons" controller="logout"><i class="fa fa-sign-out"> <sec:username/> (Logout) </i> </g:remoteLink> </li>  -->
									<li><a href="logout"><i class="fa fa-sign-in"> Logout - <sec:username/> </i> </a></li>
									<li><g:remoteLink controller="logout" action="index" update="mainContent"> <i class="fa fa-sign-in"> Logout - <sec:username/> </i> </g:remoteLink><li>
								</sec:ifLoggedIn>
								<sec:ifNotLoggedIn>
									<li><a href="login"><i class="fa fa-sign-in"> Login</i> </a></li>
									<li><g:remoteLink controller="login" action="auth" update="mainContent"> <i class="fa fa-sign-in"> Login</i> </g:remoteLink><li>
									
								</sec:ifNotLoggedIn>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="home"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
								<!-- 
									<li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
									<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								 -->
								<li><a href="contactus"><i class="fa fa-phone"></i> Contact</a></li>
								<li><g:remoteLink controller="shop" action="contactus" update="mainContent"> <i class="fa fa-sign-in"> Contact</i> </g:remoteLink><li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><g:remoteLink controller="homePage" action="landingPage" update="mainContent">Home</g:remoteLink><li>
								
								
								<g:each in="${msCatalog?.categories}" var="topCategory">
            							<li class="dropdown">
            								<g:remoteLink controller="product" action="productlist" params='[id:"${topCategory.id}"]' update="mainContent">
            									${topCategory.name}
            									<g:if  test="${topCategory.childMapping}">
            										<i class="fa fa-angle-down"></i>
            									</g:if>
            								</g:remoteLink>
            							<ul role="menu" class="sub-menu">
	            							<g:each in="${topCategory.childMapping}" var="childCategory">
		            							<li><g:remoteLink controller="product" action="productlist" params='[id:"${childCategory.child.id}"]' update="mainContent">${childCategory.child.name}</g:remoteLink><li>
		            						</g:each>
	            						</ul>
	            						</li>
            					</g:each>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->