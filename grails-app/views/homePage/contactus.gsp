<!DOCTYPE html>
<html lang="en">
<g:render template="/common/head" />

<body>
	<g:render template="/common/header" />
	 
	 <div id="page-content">
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Contact <strong>Us</strong></h2>    			    				    				
					<div id="gmap" class="contact-map">
					</div>
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-8">
	    			<div class="contact-form">
	    				<h2 class="title text-center">Get In Touch</h2>
	    				<g:render template="/feedBack/createFeedBack" />
	    			</div>
	    		</div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Mangla Sons</h2>
	    				<address>
							<p>B 18, Mangalmurti Apartment, Opposite Novino Batteries, Makarpura Road</p>
							<p>Vadodara, Gujarat, India</p>
							<p>+91 265 264 4232</p>
							<p>Email: info@manglasons.net</p>
	    				</address>
	    				<address>
							<p>D-11, 12, Somnath Shopping Centre, Somnath Nagar, Tarsali</p>
							<p>Vadodara, Gujarat, India</p>
							<p>+91 84016 18856</p>
							<p>Email: info@manglasons.net</p>
	    				</address>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-google-plus"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-youtube"></i></a>
								</li>
							</ul>
	    				</div>
	    			</div>
    			</div>    			
	    	</div>  
    	</div>	
    </div><!--/#contact-page-->
	</div>
	
  	<g:render template="/common/footer" />
  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="js/gmaps.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
    
</body>
</html>