$(function() {
	$(".nav-menu ul.menu-area li>a").addClass("menuClose");

	var hederbtn = $(".header ul.pulldown li.drowerbtn>a");
	hederbtn.click(function() {
		if ($(".nav-menu ul.menu-area li>a").hasClass("menuOpen")) {
			$(".nav-menu").css('transform', 'translateX(100%)')
			$(".nav-menu ul.menu-area li>a").removeClass("menuOpen").addClass("menuClose");
		} else {
			$(".nav-menu").css('transform', 'translateX(50%)')
			$(".nav-menu ul.menu-area li>a").removeClass("menuClose").addClass("menuOpen");
		}
	});
});