window.onload = function() {
	var categoryDropdown = document.getElementById('mainCategory');
	categoryDropdown.disabled = true;

	// 서브카테고리 콤보박스에서 선택된 값 가져오기
	var subcategoryId = document.getElementById('subId').value;

	// 서브카테고리 콤보박스 요소 가져오기
	var subCategoryDropdown = document.getElementById('subCategory');

	// 서브카테고리 콤보박스의 옵션들을 반복하여 선택된 값과 일치하는 옵션을 찾음
	for (var i = 0; i < subCategoryDropdown.options.length; i++) {
		// 선택된 값과 현재 옵션의 값이 일치하는 경우
		if (subCategoryDropdown.options[i].value === subcategoryId) {
			// 해당 옵션을 선택함
			subCategoryDropdown.selectedIndex = i;
			subCategoryDropdown.disabled = true;
			break; // 반복문 종료
		}
	}

	// Update 요청을 보내는 함수
	function sendUpdateRequest() {
		const userId = document.getElementById('userId').value;
		const writerUserid = document.getElementById('writerUserId').value;
		if(userId === writerUserid){
			document.getElementById('updateBtn').style.display = "block";
			document.getElementById('deleteBtn').style.display = "block";
		} else {
			document.getElementById('updateBtn').style.display = "none";
			document.getElementById('deleteBtn').style.display = "none";
		}
		var boardTitle = document.getElementById("boardTitle").value;
		var boardContent = document.getElementById("boardContent").value;
		var boardId = document.getElementById('boardId').value; // 원하는 boardId 값
		var url = "/api/board/update/" + boardId; // Update 요청을 보낼 URL
		// Update 요청을 위한 설정
		var requestOptions = {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				boardTitle: boardTitle,
				boardContent: boardContent
			})
		};

		// Update 요청 보내기
		fetch(url, requestOptions)
			.then(response => {
				if (!response.ok) {
					throw new Error('Network response was not ok');
				}
				return response.text();
			})
			.then(data => {
				alert("게시글이 수정되었습니다.");
				console.log(data); // 성공한 경우 응답 데이터 출력
				window.location.href = "/board_detail?boardId=" + boardId;
				
			})
			.catch(error => {
				alert("수정 실패! 다시 시도해 주십시오.");
				console.error('게시글 수정 실패', error); // 오류 발생 시 처리
			});
	}

	// 수정하기 버튼 클릭 시 Update 요청 보내기
	document.getElementById("sendUpdateRequest").addEventListener("click", function(event) {
		event.preventDefault(); // 기본 동작 방지
		sendUpdateRequest(); // Update 요청 보내기
	});
	
};
function clearForm() {
	// 폼 입력 필드 초기화
	var boardId = document.getElementById('boardId').value;
	window.location.href = "/board_detail?boardId=" + boardId;
	window.location.href = "/board_list/" + categoryId
}