<!DOCTYPE HTML>
<!--
	Strata by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Easy Movie</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body id="top">

		<!-- Header -->
			<header id="header">
				<div class="inner">
					<h1 id="recMovie" class="movieDetails"></h1>
					<p id="recDesc" class="movieDetails"></p>
				</div>
			</header>

		<!-- Main -->
			<div id="main">

				<!-- One -->
					<section id="one">
						<header class="major">
							<h2>Netflix Roulette</h2>
						</header>
						<p>Please select your genre:</p>

						<select id="genreId">
							<option name="All genres" value="0" /> All genres
							<option name="Comedy" value="6" /> Comedy
							<option name="Horror" value="17" /> Horror
							<option name="Sport" value="25" /> Sport
							<option name="Thriller" value="27" /> Thriller
						</select>

						<br><br>

						<ul class="actions">
							<li><a href="#" class="button" id="btnFindMovie">Find your movie!</a></li>
						</ul>
					</section>

				<!-- Two -->
					<section id="two">
						<h2>Recent suggestions</h2>
						<div class="row" id="history"></div>
					</section>
			</div>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<ul class="copyright">
						<li>&copy; Easy Movie</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>


		<script src="assets/js/app.js" data-backend="<?php echo getenv("PROD_BACKEND"); ?>"></script>
	</body>
</html>
