//카테고리 스크립트처리.
$(document).ready(function() {
	var initialData = $('#container').html();
	var container = $('#container');

	function filterItems(category) {
		container.empty();

		var itemList = $(initialData).find('.single_product_item').toArray(); // 클래스 선택자를 수정하여 공백을 없앴습니다.

		$.each(itemList, function(index, item) {
			var productCategory = $(item).find('h3').eq(1).text(); // 클래스 선택자를 수정하여 'single_product_text' 대신 'h3'을 사용했습니다.
			
			if (category === 'all' ||
				(category === '건사료' && productCategory === '건사료') ||
				(category === '배변패드' && productCategory === '배변패드') ||
				(category === '방석/쿠션' && productCategory === '방석/쿠션') ||
				(category === '이동가방' && productCategory === '이동가방') ||
				(category === '샴푸/비누' && productCategory === '샴푸/비누') ||
				(category === '기타' && productCategory === '기타')) {

				// <div class="col-lg-4 col-sm-6">로 한번 감싸고 추가하는 작업
				var productItemWrapper = $('<div class="col-lg-4 col-sm-6"></div>');
				productItemWrapper.append(item);
				container.append(productItemWrapper);
			}

		});
	}



	$(document).ready(function() {
		// 각 카테고리를 클릭할 때마다 실행되는 함수
		$('#category1').click(function() {
			filterItems('건사료');
		});
		$('#category2').click(function() {
			filterItems('배변패드');
		});
		$('#category3').click(function() {
			filterItems('방석/쿠션');
		});
		$('#category4').click(function() {
			filterItems('이동가방');
		});
		$('#category5').click(function() {
			filterItems('샴푸/비누');
		});
		$('#category6').click(function() {
			filterItems('기타');
		});

		$('#all').on('click', function() {
			filterItems('all');
		});

		// 전체를 클릭할 때마다 실행되는 함수
		$('#all').click(function() {
			$('.single_product_item').show();
		});

		$(document).ready(function() {
			// 스크립트 코드
		});
	});
});

//검색기능 스크립트 처리(엔터).
document.addEventListener('DOMContentLoaded', function() {
	const searchInput = document.getElementById('searchInput');
	const container = document.getElementById('container');
	var initialData = $('#container').html();

	searchInput.addEventListener('keydown', function(event) {
		if (event.key === 'Enter') {
			const searchValue = searchInput.value;

			// 여기에서 검색어를 사용하여 필터링된 항목을 표시하거나 처리할 수 있습니다
			filterItems(searchValue);
			searchInput.value = ''; // 검색어 필드 비우기
		}
	});

	var itemList = $(initialData).find('.single_product_item').toArray();

	function filterItems(searchQuery) {
		container.innerHTML = ''; // 리스트 비우기

		itemList.forEach(function(item) {
			var titleElement = item.getElementsByTagName('h4')[0]; // h4 요소 선택
			var title = titleElement.textContent;

			if (title.toLowerCase().includes(searchQuery.toLowerCase())) {
				// 새로운 제품 항목이 삽입될 때마다 이를 .col-lg-4.col-sm-6 클래스로 감싸서 결과를 추가
				var productItemWrapper = document.createElement('div');
				productItemWrapper.classList.add('col-lg-4', 'col-sm-6');
				productItemWrapper.appendChild(item.cloneNode(true));
				container.appendChild(productItemWrapper);
			}
		});
	}
});


