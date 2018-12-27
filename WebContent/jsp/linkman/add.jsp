<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 标题做一个if判断，使得一个jsp页面既能用于修改，又能用于添加 -->
<TITLE><c:if test="${empty linkman.lkmId}">添加</c:if><c:if
		test="${!empty (linkman.lkmId)}">修改</c:if>联系人</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/linkman/addOrEdit.action"
		method=post>


		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>


								<TD class=manageHead>当前位置：联系人管理 &gt; <!-- 通过if判断，使得这个页面可以同事用于添加和修改 -->
									<c:if test="${empty linkman.lkmId}">添加</c:if> <c:if
										test="${!empty linkman.lkmId}">修改</c:if> 联系人
								</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
									<!-- 如果是修改联系人，那么在页面加载时这里会填充当前联系人所属的客户id --> <input id="custId"
									type="hidden" value="${linkman.lkmCustomer.custId }"
									name="lkmCustId" style="WIDTH: 180px" /> <!-- 如果是修改联系人，那么在页面加载时这里会显示当前联系人所属的客户姓名 -->
									<input id="custName" type="text"
									value="${linkman.lkmCustomer.custName}" disabled="disabled"
									style="WIDTH: 180px" /> <!-- 这里很重要，点击选择按钮会开一个新窗口，用于显示客户列表
								尤其要注意这个href带了一个select参数过去，这个参数是存放在queryvo中的，
								list.action方法获取queryvo后会把它再转发回jsp页面，这样能让客户列表jsp页面知道是用于选择 
								右边的超链接不再是修改删除了--> <input type="button" value="选择"
									onclick="window.open('${pageContext.request.contextPath }/customer/list.action?select=true','','width=600,height=400')" />
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td><!-- 隐藏框放联系人id -->
									<input type="hidden" name="lkmId"
									value="${linkman.lkmId}" /> 
									<INPUT class=textbox id=sChannel2
									value="${linkman.lkmName }" style="WIDTH: 180px" maxLength=50
									name="lkmName"></td>
								<td>联系人性别：</td>
								<td>
									<!-- 单选按钮，if标签用于修改联系人功能 --> <input type="radio" value="1"
									name="lkmGender"
									<c:if test="${linkman.lkmGender=='1' }">checked</c:if>>男
									<input type="radio" value="2" name="lkmGender"
									<c:if test="${linkman.lkmGender=='2' }">checked</c:if>>女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td><INPUT class=textbox id=sChannel2
									value="${linkman.lkmPhone }" style="WIDTH: 180px" maxLength=50
									name="lkmPhone"></td>
								<td>联系人手机 ：</td>
								<td><INPUT class=textbox id=sChannel2
									value="${linkman.lkmMobile }" style="WIDTH: 180px" maxLength=50
									name="lkmMobile"></td>
							</TR>
							<tr>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
							</tr>
						</TABLE>


					</TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
