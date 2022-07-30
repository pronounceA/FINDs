<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "FINDs";%>
<% String cssName = "loginOk"; %>
<%@ include file="/include/header.jsp" %>
<p class="top">「FINDs」へようこそ！</p>
<p>
FINDsはECサイト風の機能を持つWEB APIです。（デバイス幅1000px以下非対応）<br>
職業訓練校の自由制作の課題で、メンバー6名で考案し開発した作成物を、宍戸がgithub、Herokuを用いてデプロイしたものです。<br>
当サイトの機能と、宍戸の作成箇所を紹介させてください。<br>
</p>

<h1>【アカウント作成から商品の購入まで】</h1>
<div>
	<img class="pp" src="photo/p1.png" alt="process1"><br>
	「ログイン」をクリック。<br>
	なお、全ページ共通の<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/include/header.jsp">ヘッダーファイル</a>、
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/include/footer.jsp">フッターファイル</a>、及び、その
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/headerFooter.css">CSSファイル</a>は私が作成ました。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p2.png" alt="process2"><br>
	「FINDsアカウントを作成」をクリック。
</div>

<div class="process">
	<img class="pp" src="photo/p3.png" alt="process3"><br>
	各項目をご入力ください。<br>
	入力後、「登録」をクリック。
</div>

<div class="process">
	<img class="pp" src="photo/p4.png" alt="process4"><br>
	先ほど入力したアカウント情報を入力し、ログインをクリック。
</div>

<div class="process">
	<img class="pp" src="photo/p5.png" alt="process5"><br>
	商品一覧ページへ移動します。<br>
	お好みの商品をクリックしてください。<br>
	私はルートビアをクリックします。<br>
	このページの制御を行う
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/servlet/ItemListServlet.java">サーブレットファイル</a>、
	DBとの接続を行う
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/java/dao/ItemListDAO.java">DAOファイル</a>、
	画面の描画を行う
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/WEB-INF/jsp/itemList.jsp">JSPファイル</a>、
	<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/itemList.css">CSSファイル</a>は私が作成しました。<br>
	JSPファイルのページネーションの制御は最もこだわりました。<br>
</div>
<div class="process">
	<img class="pp" src="photo/p6.png" alt="process6"><br>
	<ul style="list-style: square; margin-left: 100px;">
		<li>現在表示しているページは黒文字表示させ、リンクを付けない</li>
		<li>1ページ目、あるいは、最終ページを表示させている時は矢印を付けない</li>
		<li>ページ数が7ページより多い場合、「…」を表示し省略する</li>
	</ul>
	を実現しました。<br>
	しかし、制御構文を多用しコードが冗長になってしまった、と感じております。<br>
	今後改良し、より良い端的なコードで実現したいです。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p7.png" alt="process7"><br>
	商品詳細ページへ移動します。<br>
	このページの<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/itemDetails.css">CSSファイル</a>も私が担当しました。<br>
	商品ページ下部の商品個数を選択し、「カートへ追加」をクリック。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p8.png" alt="process8"><br>
	これで商品をカートに追加することができました。<br>
	一度、「買い物に戻る」をクリックしてください。
	また、このページの<a href="https://github.com/pronounceA/FINDs/blob/main/src/main/webapp/css/buy.css">CSSファイル</a>は私が作成しました。<br>
	バックエンドエンジニア志望にも関わらずCSSファイルの記述が多くなってしまいました。<br>
	職業訓練校ではCSSは習いませんが、私は趣味でCSSの学習をしていたためCSSの担当範囲が広くなりました。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p9.png" alt="process9"><br>
	先ほどまでバナー広告が表示されていた箇所に、カート内商品が表示されます。<br>
	「購入画面」をクリックし、カートページに戻ります。<br>
	カートページの購入をクリックすると、買い物が終了します。<br>
</div>


<h1>【商品の登録】</h1>

<div>
	<img class="pp" src="photo/p10.png" alt="process10"><br>
	<a href="https://finds-portfolio.herokuapp.com/MasterServlet">https://finds-portfolio.herokuapp.com/MasterServlet</a>へ移動。
	各項目を入力し、「登録する」をクリックしてください。<br>
	なお、商品画像の登録機能は私が付加しました。<br>
	登録された画像ファイルは共通のディレクトリで管理されます。<br>
	画像の登録時に、画像ファイル名に日付情報を付与する事で、同一ファイル名の保存による上書きに対策しました。<br>
	また、対応画像は3MB以下です。<br>
	一部環境からアップロードした画像が反映されない不具合は調整中です。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p11.png" alt="process11"><br>
	登録確認がされます。<br>
	「登録」をクリックしてください。<br>
	その後、<a href="https://finds-portfolio.herokuapp.com/ItemListServlet">商品一覧</a>へ戻ります。<br>
</div>

<div class="process">
	<img class="pp" src="photo/p12.png" alt="process12"><br>
	商品一覧のページネーションの最終ページをクリックしてください。<br>
	先ほど追加した商品が登録されていれば成功です。<br>
</div>

<h2>【あとがき】</h2>
授業ではH2データベースを利用しましたが、HerokuではH2非対応だったため、MySQLを利用しました。<br>
MySQLの導入、Herokuを用いたデプロイと、新しい事に挑戦し時間は掛ったけれども、成果物としてネット上に公開できた事に達成感を感じました。<br>
今後も積極的に新しい知識を身に着け、誰かの役に立つサービスを開発していきたいです。<br>
FINDsを共に作成した友人、ここまでご覧くださった皆様へ感謝を申し上げます。<br>

 <div class="github">
  <span style="font-weight: bold;">github</span><br>
  <a href="https://github.com/pronounceA/FINDs">https://github.com/pronounceA/FINDs</a>
 </div>

<%@ include file="/include/footer.jsp" %>