/*function getAllBoards() {
	alert("asdsadsa");
	fetch('/api/board/selectAll')
		.then(response => {
			if (!response.ok) {
				throw new Error('네트워크 문제 발생');
			}
			return response.json();
		})
		.then(data => {
			// 가져온 데이터를 화면에 표시
			data.forEach((board, index) => {
				const boardElement = document.createElement('div');
				boardElement.classList.add('table-row');
				boardElement.innerHTML = `
					<div class="serial">${index + 1}</div>
					<div class="country">${board.boardTitle}</div>
				`;
				document.getElementById('boardList').appendChild(boardElement);
			});
		})
		.catch(error => {
			console.error('에러가 발생했습니다.:', error);
			alert('게시글 목록 불러오기 중 오류가 발생했습니다.');
		});
}

// 페이지 로드 시 모든 게시글 데이터를 가져와서 화면에 표시
window.onload = function() {
	getAllBoards();
};*/

document.addEventListener("DOMContentLoaded", function() {
	var categoryLinks = document.querySelectorAll(".main_category a");
	categoryLinks.forEach(function(link) {
		link.addEventListener("click", function(event) {
			event.preventDefault();
			var categoryId = this.getAttribute("data-category");
			if (categoryId === "1") {
				window.location.href = "board_list";
			} else if (categoryId === "2") {
				window.location.href = "board_adopt";
			}
		});
	});
});