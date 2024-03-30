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

document.getElementById("sorting").addEventListener("change", function() {
	var sortingValue = this.value;
	var currentUrl = window.location.href; 
	var baseUrl = currentUrl.split('?')[0]; 
	var newUrl;

	if (sortingValue === "createdTimeDesc" || sortingValue === "createdTimeAsc") {
		if (currentUrl.includes("?")) {
			newUrl = baseUrl + "?sorting=" + sortingValue;
		} else {
			newUrl = baseUrl + "?sorting=" + sortingValue;
		}
	} else {
		newUrl = baseUrl;
	}

	window.location.href = newUrl;
});

window.addEventListener("DOMContentLoaded", function() {
	var params = new URLSearchParams(window.location.search);
	var sortingOption = params.get('sorting');
	if (sortingOption) {
		var selectElement = document.getElementById("sorting");
		selectElement.value = sortingOption;
	}
});

    function goToPage(pageNumber) {
        // 페이지 번호로 이동하는 로직 구현
        // pageNumber는 1부터 시작한다고 가정합니다.
        var pageSize = 10; // 페이지 그룹의 크기
        var groupNumber = Math.ceil(pageNumber / pageSize); // 현재 페이지의 그룹 번호 계산
        var startPage = (groupNumber - 1) * pageSize + 1; // 현재 그룹의 시작 페이지 번호
        var endPage = Math.min(startPage + pageSize - 1, totalPages); // 현재 그룹의 끝 페이지 번호

        // 페이지 번호 업데이트
        for (var i = 1; i <= totalPages; i++) {
            var pageLink = document.getElementById('page-' + i);
            if (pageLink) {
                if (i >= startPage && i <= endPage) {
                    pageLink.style.display = 'block';
                } else {
                    pageLink.style.display = 'none';
                }
            }
        }

        // 이전, 다음 버튼 상태 업데이트
        var prevButton = document.getElementById('prevButton');
        var nextButton = document.getElementById('nextButton');
        if (prevButton && nextButton) {
            prevButton.disabled = groupNumber === 1; // 첫 그룹에서는 이전 버튼 비활성화
            nextButton.disabled = groupNumber * pageSize >= totalPages; // 마지막 그룹에서는 다음 버튼 비활성화
        }
    }