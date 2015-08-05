<%@ page import="com.mt.is.domain.users.FeedBack" %>



<div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="feedBack.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${feedBackInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="feedBack.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" maxlength="10" required="" value="${feedBackInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="feedBack.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${feedBackInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'subject', 'error')} required">
	<label for="subject">
		<g:message code="feedBack.subject.label" default="Subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" maxlength="100" required="" value="${feedBackInstance?.subject}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'message', 'error')} required">
	<label for="message">
		<g:message code="feedBack.message.label" default="Message" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="message" cols="40" rows="5" maxlength="1500" required="" value="${feedBackInstance?.message}"/>

</div>

