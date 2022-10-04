<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center;">Actor Information Report</h1>

<c:choose>
	<c:when test="${!empty actorsInfo }">
		<table border="1" align="center" bgcolor="yellow">
			<tr bgcolor="green">
			  <th>Actor Id</th><th>Actor Name</th><th>Category</th><th>Mobile No</th><th>operations</th>
			</tr>
			<c:forEach var="artist" items="${actorsInfo }">
			   <tr>
			   	<td>${artist.actorId }</td>
			   	<td>${artist.actorName }</td>
			   	<td>${artist.category }</td>
			   	<td>${artist.mobileNo }</td>
			   	<td>
			   		<a href="actor_edit?aid=${artist.actorId }">edit<img src="images/edit.jpg" width="50px" height="50px"></img></a>
			   		<a href="actor_delete?aid=${artist.actorId }">delete<img src="images/delete.jpg" width="50px" height="50px"></img></a>
			   	</td>
			   </tr>
			</c:forEach>
		</table>
			<h1 style="text-align: center;color: green;">${resultMsg }</h1>
			<center><a href="./actor_add">register Actor<img src="images/add.jpg" width="50px" height="50px"></a></center>
			<center><a href="./"><b>home</b><img src="images/home.jpg" width="50px" height="50px"></a></center>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">Actors Not Found</h1>
	</c:otherwise>
</c:choose>





