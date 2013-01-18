

function reorder_by_position(position) {

	$('.position_sortable').each(
			function() {

				var $this = $(this);

				current_position_element = $this.find('[data-position="'
						+ position + '"]');

				last_element_in_collection = current_position_element
						.siblings(":last");

				if (current_position_element.nextAll().length >= 1) {

					current_position_element.prevAll().slideUp().insertAfter(
							last_element_in_collection).slideDown();

				} else {

					current_position_element.prevAll().slideUp().insertAfter(
							current_position_element).slideDown();

				}

			});

}

function show_by_position(position) {

	$('.position_sortable').each(
			function() {

				var $this = $(this);

				current_position_element = $this.find('[data-position="'
						+ position + '"]');

				current_position_element.fadeIn();

				current_position_element.nextAll().show();

			});

}

function sort_by_position(order) {

	// order = 'descending';

	$('.position_sortable').each(function() {

		var $this = $(this);

		$this.append($this.find('.position').get().sort(function(a, b) {

			if (order == 'ascending') {

				return $(a).data('position') - $(b).data('position'); // ascending
																		// order

			} else {

				return $(b).data('position') - $(a).data('position'); // descending
																		// order

			}

		}));

	});

}

// looped show by position (process intensive)

function looped_show_by_position(order) {

	// order = 'descending';

	duration = Math.floor(jwplayer('player').getDuration());

	for ( var i = duration; i >= 0; i--) {

		show_by_position(i);

	}

}