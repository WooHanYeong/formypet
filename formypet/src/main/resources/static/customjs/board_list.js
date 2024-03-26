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
document.getElementById("searchForm").addEventListener("submit", function(event) {
	event.preventDefault(); // 폼의 기본 동작 방지

	var categoryId = document.getElementById("categoryId").value; // categoryId 값을 가져옴
	var keyword = document.getElementById("searchInput").value; // 검색어를 가져옴

	// 동적으로 URL 생성 및 제출
	var url = "/board_list/" + categoryId + "?keyword=" + encodeURIComponent(keyword);
	window.location.href = url;
});

document.getElementById('searchForm').addEventListener('submit', function(event) {
	event.preventDefault(); // 기본 동작 방지
	var categoryId = '여기에_카테고리_ID_설정'; // categoryId를 동적으로 설정하거나 필요에 따라 가져오는 작업 필요
	var keyword = document.getElementById('searchInput').value.trim();
	// categoryId와 keyword를 사용하여 URL을 생성
	var url = '/board_list/' + categoryId + '?keyword=' + encodeURIComponent(keyword);
	// 생성된 URL을 form action으로 설정
	this.action = url;
	// form을 서버로 제출
	this.submit();
});