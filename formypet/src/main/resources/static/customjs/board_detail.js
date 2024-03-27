function recommend() {
	var userIdElement = document.getElementById('userId');
	var userId = userIdElement ? userIdElement.value : null;
	var writerUserId = document.getElementById('writerUserId').value;
	var boardId = document.getElementById('boardId').value;
	var recommendCountElement = document.getElementById('recommendCount');
	var recommendCount = parseInt(recommendCountElement.innerText);
	var recommendedKey = 'recommended_' + boardId + '_' + userId;
	var recommended = localStorage.getItem(recommendedKey);

	if (userId === writerUserId) {
		alert("자신의 글은 추천할 수 없습니다.");
	} else if (userId === null) {
		alert("로그인 한 유저만 추천할 수 있습니다.");
	} else {
		if (recommended === 'true') {
			recommendCount--;
			localStorage.removeItem(recommendedKey);
		} else {
			recommendCount++;
			localStorage.setItem(recommendedKey, 'true');
		}

		recommendCountElement.innerText = recommendCount;

		var url = '/api/board/update/recommend/' + boardId;
		fetch(url + '?recommend=' + recommendCount, {
			method: 'PUT'
		})
			.then(response => {
				if (!response.ok) {
					throw new Error('게시글 추천 업데이트에 실패했습니다.');
				}
				return response.text();
			})
			.then(data => {
				console.log(data);
			})
			.catch(error => {
				console.error('에러 발생:', error);
			});
	}
}



window.onload = function() {
	var userIdElement = document.getElementById('userId');
	var userId = userIdElement ? userIdElement.value : null;
	var writerUserId = document.getElementById('writerUserId').value;
	if (userId !== writerUserId) {
		document.getElementById('updateBtn').style.display = "none";
		document.getElementById('deleteBtn').style.display = "none";
	}
}



function deleteBoard() {
	var boardId = document.getElementById('boardId').value;
	if (confirm("게시글을 삭제하시겠습니까?")) {
		fetch('/api/board/delete/' + boardId, {
			method: 'DELETE'
		})
			.then(response => {
				if (!response.ok) {
					throw new Error('네트워크 에러 발생');
				}
				return response;
			})
			.then(() => {
				console.log('게시글 삭제 성공');
				alert('게시글이 삭제되었습니다.');
				window.location.href = '/board_list/1';
			})
			.catch(error => {
				console.error('게시글 삭제 실패:', error);
			});
	}
}

function updateBoard() {
	var categoryId = document.getElementById('categoryId').value;
	var boardId = document.getElementById('boardId').value;
	var subCategoryId = document.getElementById('subCategoryId').value;
	console.log(categoryId);
	console.log(boardId);
	console.log(subCategoryId);
	window.location.href = '/board_update/' + categoryId + '/' + boardId;
}







function registerReply() {
	var userId = document.getElementById('userId').value;
	var boardId = document.getElementById('boardId').value;
	var replyContent = document.getElementById('replyContent').value;
debugger;
	var formData = {
		"boardId": boardId,
		"replyContent": replyContent,
		"userId": userId
	};

	fetch("/api/boardReply/insert_reply/" + boardId, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(formData)
	})
	.then(response => {
		if(response.ok) {
			alert("댓글이 등록되었습니다.");
			window.location.href = "/board_detail?boardId=" + boardId;
		} else {
			alert("댓글 등록이 실패하였습니다.");
		}
	})
	.catch(error => {
		alert('에러 발생' + error);
	});
}













/*function registerReply() {
	// 사용자 ID 가져오기
	var userId = document.getElementById("userId").value;
	console.log(userId)
	if (userId === "id") {
		if (confirm("사용자 ID가 없습니다. 로그인 화면으로 이동하시겠습니까?")) {
			window.location.href = "/user_login_form";
		}
		return;
	}
	// 댓글 내용 가져오기
	var commentContent = document.getElementById("comment").value;

	// 댓글 내용이 비어 있는지 확인
	if (commentContent.trim() === "") {
		alert("댓글 내용을 입력해주세요.");
		return;
	}

	var formData = new FormData(); // FormData 객체 생성

	// FormData 객체에 댓글 내용과 사용자 ID 추가
	formData.append("replyContent", commentContent);
	formData.append("userId", userId);

	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);
	var boardId = urlParams.get('boardId');

	console.log("boardId:", boardId);

	$.ajax({
		url: "/api/boardReply/insert_reply/" + boardId,
		type: "POST",
		data: formData,
		processData: false,
		contentType: false,
		success: function(response) {
			alert("댓글이 성공적으로 등록되었습니다.");
			window.location.href = "board_detail?boardId=" + boardId;
		},
		error: function(error) {
			alert("댓글 등록에 실패했습니다.");
			console.log(error);
		}
	});
}*/