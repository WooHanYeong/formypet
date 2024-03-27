$(document).ready(function() {
	var initialData = $('#container').html();
	var container = $('#container');

	// 드롭다운 메뉴를 선택하는 이벤트 정의
	$('.dropdowncuston').change(function() {
		var selectedBreed = $(this).val();
		var selectedAge = $('input[id="checkbox1"]:checked').next('a').text();
		var selectedSex = $('input[id="checkbox2"]:checked').next('a').text();
		var selectedNeutering = $('input[id="checkbox3"]:checked').next('a').text();
		filterItems(selectedBreed, selectedAge, selectedSex, selectedNeutering); // 선택된 품종, 나이, 성별, 중성화 여부에 따라 필터링된 항목들을 보여줌
	});

	// 체크박스를 클릭하는 이벤트 정의
	$('input[type="checkbox"]').change(function() {
		var selectedBreed = $('.dropdowncuston').val();
		var selectedAge = $('input[id="checkbox1"]:checked').next('a').text();
		var selectedSex = $('input[id="checkbox2"]:checked').next('a').text();
		var selectedNeutering = $('input[id="checkbox3"]:checked').next('a').text();
		filterItems(selectedBreed, selectedAge, selectedSex, selectedNeutering); // 선택된 품종, 나이, 성별, 중성화 여부에 따라 필터링된 항목들을 보여줌
	});

	function filterItems(breed, age, sex, neutering) {
		container.empty();

		var itemList = $(initialData).find('.single_product_item').toArray();

		$.each(itemList, function(index, item) {
			var productBreed = $(item).find('h3').eq(0).text().trim(); // 각 항목의 품종을 가져옴
			var productAge = $(item).find('h3').eq(1).text().trim(); // 각 항목의 나이 범위를 가져옴
			var productSex = $(item).find('h3').eq(2).text().trim(); // 각 항목의 성별을 가져옴
			var productNeutering = $(item).find('h3').eq(3).text().trim(); // 각 항목의 중성화 여부를 가져옴

			// 선택된 품종, 나이, 성별, 중성화 여부에 따라 필터링
			if ((breed === '품종' || breed === productBreed) &&
				(age === '' || age === productAge) &&
				(sex === '' || sex === productSex) &&
				(neutering === '' || neutering === productNeutering)) {
				var productItemWrapper = $('<div class="col-lg-4 col-sm-6"></div>');
				productItemWrapper.append(item);
				container.append(productItemWrapper);
			}
		});
	}
});
