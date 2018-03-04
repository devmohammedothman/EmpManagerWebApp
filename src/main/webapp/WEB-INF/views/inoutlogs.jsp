%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<t:genericpage title="Attendance Logs">
	<jsp:attribute name="content">
	  <div class="w3-panel">
    <div class="w3-row-padding" style="margin: 0 -16px">
      
      <div class="w3-twothird">
        <h5>Attendance Log View Items</h5>
        <table id="attLogTable" class="w3-table w3-striped w3-white">
        <thead>
            <tr>
            	<th></th>
            	<th>ID</th>
                <th>Date</th>
                <th>LogIn</th>
                <th>LogOut</th>
                <th>Working Hours</th>
            </tr>
        </thead>
        <tfoot>
	        <tr>
	        <th></th>
	        <th></th>
	        	<th> Total Working Hours : ${totalHours}</th>
	        </tr>
        </tfoot>
         <tbody>
       <c:forEach items="${attLogList}" var="attItem">
    		 <tr>
             	<td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
	            <td>${attItem.id}</td>
	            <td>
	            <fmt:parseDate value="${attItem.dayDate}" pattern="yyyy-MM-dd" var="itemDayDate"/>
	            <fmt:formatDate value="${itemDayDate}" type="date" /></td>
	            <td>
	            	<fmt:formatDate value="${attItem.logTimeIn}" type="time" pattern="yyyy-MM-dd HH:mm:ss" />
	            </td>
	            <td>
	            	<fmt:formatDate value="${attItem.logTimeOut}" type="time" pattern="yyyy-MM-dd HH:mm:ss" />
	           </td>
	            <td><i>${attItem.workingHours }</i></td>
          </tr>
		</c:forEach>
          <%-- <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>New record, over 90 views.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>10 mins</i></td>
          </tr>
          <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>Database error.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>15 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>New record, over 40 users.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>17 mins</i></td>
          </tr>
          <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>New comments.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>25 mins</i></td>
          </tr>
          <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>Check transactions.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>28 mins</i></td>
          </tr>
          <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>CPU overload.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>35 mins</i></td>
          </tr>
          <tr>
            
             <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>New shares.</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>2011/04/25</td>
            <td><i>39 mins</i></td>
          </tr> --%>
         </tbody>
        </table> 
      </div>
    </div>
  </div>
  
  <!-- Icons -->
  <%-- <td><i class="fa fa-user w3-text-blue w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-bell w3-text-red w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-users w3-text-yellow w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-comment w3-text-red w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-bookmark w3-text-blue w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-laptop w3-text-red w3-large"></i></td> --%>
  <%-- <td><i class="fa fa-share-alt w3-text-green w3-large"></i></td> --%>
<script type="text/javascript">
	$(document).ready(function() {
		$('#attLogTable').DataTable();
	});
</script>
	</jsp:attribute>
</t:genericpage>