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
				window.location.href = "/board_list/1";
			} else if (categoryId === "2") {
				window.location.href = "/board_adopt/1";
			}
		});
	});
});

/*document.addEventListener("DOMContentLoaded", function() {
    // 현재 페이지의 URL에서 ID 값을 추출
    var categoryLinks = document.querySelectorAll(".main_category a");
    var categoryIdElement = document.querySelector('.test'); // 클래스 이름으로 선택
    var currentCategoryId = categoryIdElement.dataset.categoryid; // 데이터 속성 가져오기
    console.log(currentCategoryId);

    // 모든 카테고리 링크에 대해 처리
    var categoryLinks = document.querySelectorAll(".main_category a");
    categoryLinks.forEach(function(link) {
        var categoryId = link.dataset.category; // 데이터 속성 가져오기
        if (categoryId === currentCategoryId) {
            link.querySelector("span").style.color = "rgb(255, 128, 64)";
        }
    });
});*/

/*document.addEventListener("DOMContentLoaded", function() {
    var categoryLinks = document.querySelectorAll(".main_category a");
    var currentCategoryId = null;
    // 카테고리 링크를 클릭했을 때의 이벤트 처리
    categoryLinks.forEach(function(link) {
        link.addEventListener("click", function(event) {
            event.preventDefault(); // 링크의 기본 동작 방지
            // 클릭된 링크의 데이터 속성에서 카테고리 ID 가져오기
            currentCategoryId = link.getAttribute("data-category");
            console.log(currentCategoryId);
            debugger;
            // 모든 카테고리 링크에 대해 스타일을 초기화
            categoryLinks.forEach(function(link) {
                link.querySelector("span").style.color = "#333";
            });

            // 현재 클릭된 링크에 선택된 스타일 적용
            link.querySelector("span").style.color = "rgb(255, 128, 64)";
        });
    });
});*/


/*
document.addEventListener("DOMContentLoaded", function() {
    // 모든 카테고리 링크에 대해 처리
    var categoryLinks = document.querySelectorAll(".main_category a");
    categoryLinks.forEach(function(link) {
        // 링크의 data-category 속성에서 카테고리 ID를 가져옴
        var currentCategoryId = link.getAttribute("data-category");

        // 현재 페이지의 categoryId와 링크의 data-category를 비교하여 색상 변경
        if (currentCategoryId === link.getAttribute("data-category")) {
            link.querySelector("span").style.color = "rgb(255, 128, 64)";
            debugger;
        }
    });
});*/

