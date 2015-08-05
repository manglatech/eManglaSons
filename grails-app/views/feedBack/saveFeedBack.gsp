<g:if test="${flash.message}">
	<div class="message" role="status">${flash.message}</div>
</g:if>
<br/><h3>Your Feedback ${feedback?.id} - ${feedback?.subject} is submitted. We will get back to you soon !! </h3>

<g:remoteLink 
action="createFeedBackForm"
controller="feedBack" 
oncomplete="showSpinner(false);" 
onloading="showSpinner(true);" 
update="feedBackResult">
Another Request
</g:remoteLink> 