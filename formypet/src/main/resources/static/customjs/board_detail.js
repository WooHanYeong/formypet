function recommend() {
    // hidden input 요소에서 boardId 값을 가져옴
    var boardId = document.getElementById('boardId').value;
    // 추천 수 업데이트 요청을 보낼 URL
    var url = '/api/board/update/recommend/' + boardId;

    // 현재 추천 수 가져오기
    var recommendCount = parseInt(document.getElementById('recommendCount').innerText);

    // 추천 수 증가
    recommendCount++;

    // 추천 수를 화면에 업데이트
    document.getElementById('recommendCount').innerText = recommendCount;

    // 추천 수 업데이트를 서버에 요청
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
    var boardId = document.getElementById('boardId').value;
    window.location.href = '/board_write/' + boardId;
}