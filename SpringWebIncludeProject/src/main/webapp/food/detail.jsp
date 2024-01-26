<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td width=30% class="text-center" rowspan="8">
						<img src="https://www.menupan.com${vo.poster }" style="width: 290px;height: 400px">
					</td>
					<td colspan=2>
						<h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
					</td>
				</tr>
				<tr>
				<th width=20% class="text-right">주소</th>
				<td width="50%">${vo.address }</td>
				<th width=20% class="text-right">전화</th>
				<td width="50%">${vo.phone}</td>
				<th width=20% class="text-right">가격대</th>
				<td width="50%">${vo.price}</td>
				<th width=20% class="text-right">영업시간</th>
				<td width="50%">${vo.time}</td>
				<th width=20% class="text-right">테마</th>
				<td width="50%">${vo.theme}</td>
				<th width=20% class="text-right">음식종류</th>
				<td width="50%">${vo.type}</td>
				<th width=20% class="text-right">좌석</th>
				<td width="50%">${vo.seat}</td>
				</tr>
				<tr>
					<td colspan=3>
						<pre style="white-space: pre-wrap;border: none">
						${vo.content }
						</pre>
					</td>
				</tr>
				<tr>
					<td colspan=3>
						<a href="../main/main.do" class="btn-sm">목록</a>
					</td>
				</tr>
			</table>		
		</div>
		<div style="height: 20px"></div>
		<div class="col-sm-8">
		<c:if test="${sessionScope.id!=null }">
			<a href="#" class="btn btn-xs btn-info">수정</a>
			<a href="#" class="btn btn-xs btn-success">삭제</a>
		</c:if>	
			<table class="table">
				<tr>
					<td>
						<c:forEach var="rvo" items="${rList}">
							<table class="table">
								<tr>
									<td class="text-left"></td>
									<td class="text-right"></td>
								</tr>
								<tr>
									<td colspan="2" class="text-left" valign="top">
										<pre style="white-spaceL: pre;border: none;">${rvo.msg }</pre>
									</td>
							</table>
						</c:forEach>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						<form method="post" action="../reply/reply_insert.do">
						<input type="hidden" name=fno value="${vo.fno }">
							<textarea rows="4" cols="65" name="msg" style="float: left">
							
							</textarea>
							<button class="btn-primary" style="width: 100px;height: 95;float: left">
								댓글쓰기</button>
						</form>
					</td>
				</tr>
			</table>	
		</div>
	</div>
</body>
</html>