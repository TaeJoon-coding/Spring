<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	// declaration
	public void demo() {
		System.out.println("Demo !");
		// System.out.println("Demo !");
		// page fault(エラー) => ソースが露出される。 => セキュリティー的に問題！
	}
	public double rand(int num) {
		return Math.random() * num;
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
rand : <%=rand(30) %><br> <!-- expression -->
1~5までの合計 : ${1+2+3+4+5}<br> <!-- EL(表現言語) -->
<%
	request.setAttribute("java", 21);	// 引数生成
	// request : JSPの要請内装オブジェクト
%>
java : <%=request.getAttribute("java") %><br>
java : ${java}<br> <!-- EL(表現言語) -->
java : ${requestScope.java}<br> <!-- EL(表現言語) -->
<!-- requestScope : ELのHttp要請内装オブジェクト -->

java : <%
			out.println(request.getAttribute("java") + "<br>");
			out.println(request.getAttribute("java"));	// ここでは自動改行されない。<br>を使うべき
		// out : 
		%><br>
<%
	// scriptlet
	demo();
%>
</body>
</html>