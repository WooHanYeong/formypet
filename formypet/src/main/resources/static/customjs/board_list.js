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

$(document).ready(function() {
    $("#searchButton").click(function() {
        var keyword = $("#searchInput").val();
        $.ajax({
            type: "GET",
            url: "/api/board/search?keyword=" + keyword,
            success: function(boards) {
                $("#searchResults").empty();
                boards.forEach(function(board) {
                    $("#searchResults").append("<p>" + board.title + "</p>");
                });
            },
            error: function() {
                alert("검색에 실패했습니다.");
            }
        });
    });
});