<!DOCTYPE html>
<html lang="en">
<g:render template="/common/head" />

<body>
	<g:render template="/common/header" />
	 
	 <div id="page-content">	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-5 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
							<input type='text' name='j_username' placeholder="UserName"/>
							<input type='password' name='j_password' id='password' placeholder="Password"/>
							<span>
								<input type='checkbox' class="checkbox" name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
								Keep me signed in
							</span>
							<span class="forgot-link">
								<g:link controller='register' action='forgotPassword'><g:message code='spring.security.ui.login.forgotPassword'/></g:link>
							</span>
							
							<span class="forgot-link">
								<a href="register">${message(code: "spring.security.ui.login.register")}</a>
							<span>
							
							<button type='submit' class="btn btn-default" id="submit">
								${message(code: "springSecurity.login.button")}
							</button>
							
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
				</div>
				<div class="col-sm-3">
					<div class="login-promo"><!--login form-->
						<span>
						<h2>Hello, world!</h2>
						<p>
							This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
						</p>
						</span>
						<button type='submit' class="btn btn-default" id="submit">
								${message(code: "springSecurity.login.button")}
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	</div>
	<g:render template="/common/footer" />
</body>
</html>