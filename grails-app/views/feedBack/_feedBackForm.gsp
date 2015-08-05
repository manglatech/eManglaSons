<g:if test="${flash.message}">
	<div class="message" role="status">${flash.message}</div>
</g:if>
<g:hasErrors bean="${feedBackInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${feedBackInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
</g:hasErrors>
				            <div class="form-group col-md-6">
				                <g:textField name="name" required="required" class="form-control" placeholder="Name" value="${feedBackInstance?.name}"/>
				            </div>
				            <div class="fieldcontain ${hasErrors(bean: feedBackInstance, field: 'email', 'error')} ">
					            <div class="form-group col-md-6">
					                <g:field type="email" name="email" required="required" class="form-control" placeholder="Email" value="${feedBackInstance?.email}"/>
					            </div>
				            </div>
				            <div class="form-group col-md-12">
				                <g:textField name="phone" required="required" class="form-control" placeholder="eg. 9898588006" value="${feedBackInstance?.phone}"/>
				            </div>
				            <div class="form-group col-md-12">
				                <g:textField name="subject" required="required" class="form-control" placeholder="Subject" value="${feedBackInstance?.subject}"/>
				            </div>
				            <div class="form-group col-md-12">
				                <g:textArea name="message" required="required" class="form-control" placeholder="Your Message Here" value="${feedBackInstance?.message}"/>
				            </div>                        