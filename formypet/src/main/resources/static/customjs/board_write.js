// 카테고리 콤보박스 비활성화
window.onload = function() {
	var categoryDropdown = document.getElementById('mainCategory');
	categoryDropdown.disabled = true;
};

function submitForm() {
	// 선택된 메인 카테고리와 서브 카테고리 ID 가져오기
	var mainCategory = document.getElementById("mainCategory");
	var subCategory = document.getElementById("subCategory");
	var categoryId = mainCategory.value;
	var subCategoryId = subCategory.value;

	// 제목과 내용 가져오기
	var boardTitle = document.getElementById("boardTitle").value;
	var boardContent = document.getElementById("boardContent").value;

	// 폼 데이터 생성
	var formData = {
		"boardCategoryId": categoryId,
		"boardSubCategoryId": subCategoryId,
		"boardTitle": boardTitle,
		"boardContent": boardContent
	};
	// POST 요청 보내기
	fetch("/api/board/create/" + categoryId + "/" + subCategoryId, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(formData)
	})
		.then(response => {
			if (response.status === 201) {
				alert("게시글이 등록되었습니다");
				window.location.href = "/board_list/" + categoryId + "/" + subCategoryId;
			} else {
				alert('게시글 등록에 실패했습니다.');
			}
		})
		.catch(error => {
			alert('에러 발생: ' + error);
		});
}

function clearForm() {
	// 폼 입력 필드 초기화
	var mainCategory = document.getElementById("mainCategory");
	var categoryId = mainCategory.value;
	window.location.href = "/board_list/" + categoryId
}