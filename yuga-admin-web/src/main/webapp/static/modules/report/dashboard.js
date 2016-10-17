$(document).ready(function() {
		var currentLangCode = 'en';

		// build the language selector's options
		$.each($.fullCalendar.langs, function(langCode) {
			$('#lang-selector').append(
				$('<option/>')
					.attr('value', langCode)
					.prop('selected', langCode == currentLangCode)
					.text(langCode)
			);
		});

		// rerender the calendar when the selected option changes
		$('#lang-selector').on('change', function() {
			if (this.value) {
				currentLangCode = this.value;
				$('#calendar').fullCalendar('destroy');
				renderCalendar();
			}
		});

		function renderCalendar() {
			$('#calendar').fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,agendaWeek,agendaDay'
				},
				defaultDate: '2015-02-12',
				lang: currentLangCode,
				buttonIcons: false, // show the prev/next text
				weekNumbers: true,
				editable: true,
				eventLimit: true, // allow "more" link when too many events
				events: [
					{
						title: 'All Day Event',
						start: '2015-02-01'
					},
					{
						title: 'Long Event',
						start: '2015-02-07',
						end: '2015-02-10'
					},
					{
						id: 999,
						title: 'Repeating Event',
						start: '2015-02-09T16:00:00'
					},
					{
						id: 999,
						title: 'Repeating Event',
						start: '2015-02-16T16:00:00'
					},
					{
						title: 'Conference',
						start: '2015-02-11',
						end: '2015-02-13'
					},
					{
						title: 'Meeting',
						start: '2015-02-12T10:30:00',
						end: '2015-02-12T12:30:00'
					},
					{
						title: 'Lunch',
						start: '2015-02-12T12:00:00'
					},
					{
						title: 'Meeting',
						start: '2015-02-12T14:30:00'
					},
					{
						title: 'Happy Hour',
						start: '2015-02-12T17:30:00'
					},
					{
						title: 'Dinner',
						start: '2015-02-12T20:00:00'
					},
					{
						title: 'Birthday Party',
						start: '2015-02-13T07:00:00'
					},
					{
						title: 'Click for Google',
						url: 'http://google.com/',
						start: '2015-02-28'
					}
				]
			});
		}

		renderCalendar();
	});

