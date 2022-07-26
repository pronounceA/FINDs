<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String title = "FINDs";%>
<% String cssName = "loginOk"; %>
<%@ include file="/include/header.jsp" %>
<p class="top">「FINDs」へようこそ！</p>
<p>
FINDsはECサイトのような機能を持つWEB APIです。（デバイス幅1000px以下非対応）<br>
職業訓練校のメンバー6名での作成物をポートフォリオ用に編集した物です。<br>
<br>
ユーザー作成<br>
↓<br>
ログイン<br>
↓<br>
商品購入<br>
<br>
というフローを体験していただけます。<br>
また、<a href="https://finds-portfolio.herokuapp.com/MasterServlet">商品の登録</a>も可能です。<br>
</p>

<!--
<p class="banner">
<a href="/FINDs/ItemListServlet" class=red title="いつも安い！ すぐ届く！ FINDsショッピングへ">★☆★　FINDsShop　★☆★</a>
<a href="/FINDs/GameServlet" class=orange title="気軽に遊べてポイントもゲット！ FINDsゲームスへ">★☆★　FINDsGAME　★☆★</a>
</p>
<p class="banner">
<a href="/FINDs/StockServlet" class=yellow title="トレーディングのことならおまかせ！ FINDs株式へ">★☆★　FINDs株式　★☆★</a>
<a href="/FINDs/TravelServlet" class=green title="休日・休暇を満喫！ 旅行のことならFIND旅行へ">★☆★　FINDsTravel　★☆★</a>
</p>
<p class="banner">
<a href="/FINDs/InsuranceServlet" class=blue title="車の保険を見直すのなら、弊社におまかせを！ FINDs自動車保険へ">★☆★　FINDs自動車保険　★☆★</a>
<a href="/FINDs/AdvServlet" class=deepblue title="宣伝・広告のご要望、何でもどうぞ！ FINDs広告へ">★☆★　FINDs広告　★☆★</a>
</p>
<p class="banner">
<a href="/FINDs/BooksServlet" class=purple title="電子書籍・中古書籍も取り扱います！ FINDsBooksへ">★☆★　FINDsBooks　★☆★</a>
<a href="/FINDs/ItemListServlet" class=red title="世界最大級のフリマアプリ！ FINDsフリマへ">★☆★　FINDsフリマ　★☆★</a>
</p>
<p class="banner">
<a href="/FINDs/MobileServlet" class=orange title="モバイルメディアのことならFINDモバイルへ">★☆★　FINDsモバイル　★☆★</a>
<a href="/FINDs/MyPageServlet" class=yellow title="アカウント確認・設定のページ">★☆★　FINDsMyPage　★☆★</a>
</p>
 -->
 <div class="github">
  <span style="font-weight: bold;">github</span><br>
  <a href="https://github.com/pronounceA/FINDs">https://github.com/pronounceA/FINDs</a>
 </div>

 <h1>主な宍戸作成箇所</h1>
 <div class="shishido-portfolio" style="margin-left :40px; margin-bottom: 30px;">
  <h2><a href="https://finds-portfolio.herokuapp.com/ItemListServlet" style="text-decoration: none; color: blue;">商品一覧</a></h2>
  <p>アクセス時にデータベースから商品の一覧を取得し、1ページに12個表示させます。<br>
  特にこだわった箇所はページネーションです。<br>
	  <ul style="list-style: square;">
		  <li>表示させているページの番号はリンクを外す</li>
		  <li>冒頭ページ、末尾ページでは矢印を表示させない</li>
		  <li>ページ数が多い場合は省略し、「…」を表示</li>
	  </ul>
  <p>
  等を実装しています。<br>
  <h2><a href="https://finds-portfolio.herokuapp.com/MasterServlet" style="text-decoration: none; color: blue;">画像アップロード</a></h2>
  商品登録の際に、商品画像をアップロードできるようにしました。<br>
  過去にアップロードされた画像と同名の画像をアップロードした場合、上書きされてしまうため、アップロード時、ファイル名に日付情報を付加する仕様にしました(<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/servlet/MasterServlet.java">105-114行</a>)。<br>
  アップロード時のファイル名の変更、また、Herokuにデプロイする際の一時ファイルの作成などを通してJavaEEのファイル構成に関して理解が深まりました。<br>
  <h2>バナー広告とカート内一覧の切り替え</h2>
  カートに商品が入っている場合、バナー広告の表示箇所にカート内商品が表示されるようになります。
  <h2>DAOファイルのDB変更</h2>
  職業訓練校の授業ではH2というDBを利用しましたが、Herokuは非対応であったため、MySQLを使用しました。<br>
  DBをローカル環境に構築する事は初めてだったため、良い経験になりました。
  <h2>githubのリポジトリ作成、Herokuへデプロイ</h2>
  githubは自分のプロジェクトを管理する目的で以前から利用していました。<br>
  Herokuは今回初めて利用しました。次回はrailsプロジェクトをデプロイして、Mavenとの差異を確認したいです。<br>
  <h2>その他</h2>
  職業訓練校ではCSSを学んでおらず、私は以前に勉強していたため、CSSの記述は担当範囲は広かったです。<br>
  他に全ページ共通のヘッターフッタ―、2カラムへの変更（バナー広告表示欄）などを担当しました。<br>
 </div>
  <div class="other">
  <p>&lt;記述ファイル一覧&gt;</p>
  <h3>Servlet</h3>
	  <ul style="list-style: none;">
		  <li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/servlet/ItemListServlet.java">ItemListServlet.java</a></li>
		  <li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/servlet/MasterServlet.java">MasterServlet.java</a>(一部記述)</li>
	  </ul>
 <h3>dao</h3>
      <ul style="list-style: none;">
      	<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/dao/ItemListDAO.java">ItemListDAO.java</a></li>
      	<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/dao/GetConnection.java">GetConnection.java</a></li>
      </ul>
 <h3>model</h3>
 	  <ul style="list-style: none;">
 	  	<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/model/GetItemListLogic.java">GetItemListLogic.java</a></li>
      	<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/model/Item.java">Item.java</a></li>
 	  </ul>
 <h3>jsp</h3>
 	<ul style="list-style: none;">
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/WEB-INF/jsp/itemList.jsp">itemList.jsp</a></li>
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/include/footer.jsp">footer.jsp</a></li>
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/include/header.jsp">header.jsp</a></li>
 	</ul>
 <h3>css</h3>
 	<ul style="list-style: none;">
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/buy.css">buy.css</a></li>
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/headerFooter.css">headerFooter.css</a></li>
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/itemDetails.css">itemDetails.css</a></li>
 		<li><a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/itemList.css">itemList.css</a></li>
 	</ul>		  
 </div>

<%@ include file="/include/footer.jsp" %>