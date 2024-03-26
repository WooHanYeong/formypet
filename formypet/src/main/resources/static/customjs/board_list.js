document.addEventListener("DOMContentLoaded", function() {
	var categoryLinks = document.querySelectorAll(".main_category a");
	categoryLinks.forEach(function(link) {
		link.addEventListener("click", function(event) {
			event.preventDefault();
			var categoryId = this.getAttribute("data-category");
			if (categoryId === "1") {
				window.location.href = "/board_list/1";
			} else if (categoryId === "2") {
				window.location.href = "/board_adopt/1";
			}
		});
	});

});
function boardWrite() {
	var loginUser = document.getElementById('userId');
	if (loginUser && loginUser.value.trim() !== '') {
		window.location.href = '/board_write/1'

	} else {
		alert("로그인이 필요합니다");
		window.location.href = '/board_list/1'
	}
}


