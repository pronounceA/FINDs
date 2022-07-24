<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String title = "商品の登録"; %>
<% String cssName = "masterHeader"; %>
<%@ include file="/include/masterHeader.jsp" %>
<!-- <body> -->
<div class="main">
<h2>
登録する商品の情報を入力してください
</h2>
<p>
「※」のある項目は入力必須項目です。<br>
また、商品の価格や追加個数は整数値にて入力ください。
</p>
<form action="/FINDs/MasterServlet" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>商品名：</td>
		<td><input type="text" name="item_Name" size="45"> ※<td>
	</tr>
	<tr>
		<td>価格：</td>
		<td><input type="text" name="item_Price" size="20"> 円 ※<td>
	</tr>
	<tr>
		<td>追加個数：</td>
		<td>
			<select name="item_Stock">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
				<option value="32">32</option>
				<option value="33">33</option>
				<option value="34">34</option>
				<option value="35">35</option>
				<option value="36">36</option>
				<option value="37">37</option>
				<option value="38">38</option>
				<option value="39">39</option>
				<option value="40">40</option>
				<option value="41">41</option>
				<option value="42">42</option>
				<option value="43">43</option>
				<option value="44">44</option>
				<option value="45">45</option>
				<option value="46">46</option>
				<option value="47">47</option>
				<option value="48">48</option>
				<option value="49">49</option>
				<option value="50">50</option>
			</select>
		<!-- <input type="text" name="item_Stock" size="20"> --> 個 ※</td>
	</tr>
	<tr>
		<td>商品詳細</td>
		<td><textarea name="item_Memo" cols="50" rows="10"></textarea><td>
	</tr>
	<tr>
		<td>商品画像：</td>
		<td><input type="file" name="item_Img"><td>
	</tr>
	<tr>
		<td><input type="submit" value="登録する"></td>
	</tr>
</table>
</form>
</div>
<!-- </body> -->
<%@ include file="/include/masterFooter.jsp" %>