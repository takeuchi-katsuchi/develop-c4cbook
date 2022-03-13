$(function() {

	var windowWidth = window.innerWidth;

	$(".header ul.submenu").addClass("menuClose");
	$(".header ul.pulldown li.slidebtn>a").addClass("menuClose");

	$(".header ul.pulldown li.slidebtn>a").each(function() {
		var allsubmenu = $(".header ul.submenu");
		var btn1 = $(this);
		var submenu = $(this).next();
		btn1.click(function() {
			if ($(this).hasClass("menuOpen")) {

				// メニューが表示されていた場合は、スライドを閉じる
				$(".header ul.drowermenu").removeClass("menuOpen").addClass("menuClose");
				$(".header ul.drowermenu").slideUp("fast");

				$(this).removeClass("menuOpen").addClass("menuClose");
				$(submenu).slideUp("fast");
			} else {
				// メニューが表示されていた場合は、スライドを閉じる
				$(".header ul.drowermenu").removeClass("menuOpen").addClass("menuClose");
				$(".header ul.drowermenu").slideUp("fast");

				$(allsubmenu).slideUp("fast");
				$(".header ul.pulldown li.slidebtn>a").removeClass("menuOpen").addClass("menuClose");
				$(submenu).slideDown("fast");
				$(btn1).removeClass("menuClose").addClass("menuOpen");
			}
			return false;
		});
	});

	$(".header ul.drowermenu").addClass("menuClose");
	$(".header ul.pulldown li.drowerbtn>a").addClass("menuClose");

	$(".header ul.pulldown li.drowerbtn>a").each(function() {
		var alldrowermenu = $(".header ul.drowermenu");
		var btn2 = $(this);
		$(alldrowermenu).slideUp("fast");
		btn2.click(function() {
			if ($(this).hasClass("menuOpen")) {

				// メニューが表示されていた場合は、スライドを閉じる
				$(".header ul.submenu").removeClass("menuOpen").addClass("menuClose");
				$(".header ul.submenu").slideUp("fast");

				$(this).removeClass("menuOpen").addClass("menuClose");
				$(alldrowermenu).slideUp("fast");
			} else if ($(this).hasClass("menuClose") && windowWidth < 640)  {

				// メニューが表示されていた場合は、スライドを閉じる
				$(".header ul.submenu").removeClass("menuOpen").addClass("menuClose");
				$(".header ul.submenu").slideUp("fast");

				$(alldrowermenu).slideDown("fast");
				$(btn2).removeClass("menuClose").addClass("menuOpen");
			}
			return false;
		})
	});

	$(document).ready(function() {
		// ページ読み込み時に実行したい処理
		if (location.pathname != "/c4cbook/top") {
			$('.use_top').css("display", "none");
			$('.slidebtn').css("display", "none");
		}
	});
});
