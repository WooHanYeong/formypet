function getBoardById(boardId) {
    fetch('/api/board/select/' + boardId)
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 문제 발생');
            }
            return response.json();
        })
        .then(data => {
            // 가져온 데이터를 화면에 표시
            document.getElementById('detailTitle').innerText = data.boardTitle;
            document.getElementById('detailContent').innerText = data.boardContent;
        })
        .catch(error => {
            console.error('에러가 발생했습니다.:', error);
            alert('게시글 불러오기 중 오류가 발생했습니다.');
        });
}

// 페이지 로드 시 특정 게시글 데이터를 가져와서 화면에 표시
window.onload = function() {
    const boardId = 3; // 특정 게시글의 ID를 지정해야 함
    getBoardById(boardId);
};