<!DOCTYPE html>
<html lang="en">
<g:render template="/common/head" />

<body>
	<g:render template="/common/header" />
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-5 col-sm-offset-1">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="#">
							<input type="text" placeholder="Name"/>
							<input type="email" placeholder="Email Address"/>
							<input type="password" placeholder="Password"/>
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
				<div class="col-sm-1">
				</div>
				<div class="col-sm-3">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
							<input type='text' name='j_username' placeholder="UserName"/>
							<input type='password' name='j_password' id='password' placeholder="Password"/>
								<span>
								<input type='checkbox' class="checkbox" name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
								Keep me signed in
							</span>
							<button type='submit' class="btn btn-default" id="submit">
								${message(code: "springSecurity.login.button")}
							</button>
						</form>
					</div><!--/login form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	<g:render template="/common/footer" />
	
	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>