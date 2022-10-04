<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: blue;text-align: center;">Actor Registration</h1>

<form:form action="actor_add" modelAttribute="actor" method="post">
	<table bgcolor="cyan" align="center">
		<tr>
			<td>actor name ::</td>
			<td><form:input path="actorName"/></td>
		</tr>
		<tr>
			<td>Category ::</td>
			<td><form:input path="category"/></td>
		</tr>
		<tr>
			<td>Mobile No ::</td>
			<td><form:input path="mobileNo"/></td>
		</tr>
		<tr>
			<td>actor name ::</td>
			<td colspan="2"><input type="submit" value="register"/></td>
		</tr>
	</table>
</form:form>













