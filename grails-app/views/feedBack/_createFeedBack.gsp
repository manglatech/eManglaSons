<div id="feedBackResult">
	    				
	    				<div class="status alert alert-success" style="display: none"></div>
	    				<g:formRemote name="subForm" url="[controller:'feedBack', action:'saveFeedBack']" update="feedBackResult">
	    					<g:render template="/feedBack/feedBackForm" />
	    					 <div class="form-group col-md-12">
				                <g:actionSubmit class="btn btn-primary pull-right" value="${message(code: 'feedback.button.submit.label', default: 'Submit')}" />
				            </div>
	    				</g:formRemote>
				        </div>