function submitForm() {
	const title = document.getElementById('boardTitle').value;
	const content = document.getElementById('boardContent').value;

	if (title.trim() === '' || content.trim() === '') {
		alert('제목과 내용을 모두 입력해주세요!');
		return;
	}

	const jsonData = {
		boardTitle: title,
		boardContent: content
	};
	console.log("제목"+title,"내용"+content);
	fetch('/api/board/create', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(jsonData)
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('네트워크 문제 발생');
			}
			alert('게시글이 성공적으로 작성되었습니다.');
			window.location.href = '/board_list';
		})
		.catch(error => {
			console.error('에러가 발생했습니다.:', error);
			alert('게시글 작성 중 오류가 발생했습니다. 다시 시도해주세요.');
		});
}

function clearForm() {
	document.getElementById('boardTitle').value = '';
	document.getElementById('boardContent').value = '';
}