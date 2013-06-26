// JavaScript Document
$(document).ready(function(e) {
	
	var weblink_container_count = 1;
	
	weblink_container = $('#web_link_container');
	weblink_div = '<div class="weblink_row">';
	weblink_div += weblink_container.find('div.weblink_row').first().html();
	weblink_div += '</div>';


	$(".adlink").click(function(e) {
		

				
		weblink_container.append(weblink_div);
		weblink_container_count ++; 
		added_weblink_div = weblink_container.find('div.weblink_row').last();
		
		
		added_weblink_div.find('.upload_input').attr('id','upload_input_'+weblink_container_count);
		init_uploadify($('#upload_input_'+weblink_container_count));
		added_weblink_div.find('.editslide').hide();
		
		select_area = added_weblink_div.find('select.select_area');
		select_area.select2("destroy").html(onload_select_area_string).select2();
		select_area.change(function(){ on_select_area_change($(this)); });
		
		select_subject = added_weblink_div.find('select.select_subject');
		select_subject.change(function(){ on_select_subject_change($(this)); });
		
		
		

		added_weblink_div.find('.editdetailsweblink').click(function(){
			$(this).parents('div.weblink_row').find('.editslide').toggle();
			return false;
		});
		
		
		
	   });
	   
	   
$(".editdetailsweblink").click(function(){
	$(this).parents('div.weblink_row').find('.editslide').toggle();
});

			var onload_select_area_string = '';

			$.get('/ziksana-web/zcourse/getsubjectarea', {}, function(
					data) {
				options = data;
			
				for (i in options) {
					label = options[i].label;
					value = options[i].value;
					if (i == 0) {
						option = '<option selected="selected" value="'
								+ value + '">' + label + '</option>';
					} else
						option = '<option value="' + value + '">'
								+ label + '</option>';

					onload_select_area_string += option;
				}
				$('select.select_area').first().select2("destroy").html(onload_select_area_string).select2();
				$('select.select_area').first().change(function(){on_select_area_change($(this));});

			});
			
			function on_select_area_change(select_area){
				console.log('inside on select_area_change');
				console.log(select_area);
				select_container = select_area.parents('ul.select_container');
				
				select_subject = select_container.find('.select_subject');
				select_topic = select_container.find('.select_topic');
				
				console.log(select_container);
				console.log(select_area);
				console.log(select_subject);
				console.log(select_topic);
				
				edit_content_info_container = $(this)
						.parents('.addweblink');
				token = '';
				request_type = 'GET';
				uri = '/ziksana-web/zcourse/getsubject';

				var Course_Area = '';
				Course_Area = select_area.val();
				$.get(
								uri,
								{
									'Course_Area' : Course_Area
								},
								function(data) {
									options = data;
									var subject_string = '';

									subject_string += '<option selected="selected" value="Select Subject">Select Subject</option>';
									for (i in options) {
										label = options[i].label;
										value = options[i].value;
										if (i == 0) {
											option = '<option  value="'
													+ value
													+ '">'
													+ label
													+ '</option>';
										} else

											option = '<option value="'
													+ value
													+ '">'
													+ label
													+ '</option>';

										subject_string += option;
									}

									//select_area.select2("destroy").html(area_string).select2();
									select_subject.select2("destroy").html(subject_string).select2();

								});
				var topic_string = '<option value="Select Topic">Select Topic</option>';
				select_topic.select2("destroy");
				select_container.find('.select_topic').html(topic_string).select2();				
			}

			// function getSubject() {
			$("select.select_area").first().change(function(){ on_select_area_change($(this)); });

			function on_select_subject_change(select_subject){
				console.log('inside on select_subject_change');
				//select_subject = $(this);
				select_container = select_subject.parents('ul.select_container');
				
				select_area = select_container.find('.select_area');
				select_topic = select_container.find('.select_topic');
				
				edit_content_info_container = $(this)
						.parents('.addweblink');

				uri = '/ziksana-web/zcourse/gettopic';
				token = '';
				request_type = 'GET';
				var Course_Subject = select_subject.val();
				var parameters = {
					"Course_Subject" : Course_Subject
				};

				$
						.get(
								uri,
								{
									'Course_Subject' : Course_Subject
								},
								function(data) {
									options = data;
									var topic_string = '';
									topic_string += '<option selected="selected" value="Select Topic">Select Topic</option>';
									for (i in options) {
										label = options[i].label;
										value = options[i].value;
										if (i == 0) {
											option = '<option value="'
													+ value
													+ '">'
													+ label
													+ '</option>';
										} else

											option = '<option value="'
													+ value
													+ '">'
													+ label
													+ '</option>';

										topic_string += option;
									}
									select_topic.select2("destroy");
									select_container.find('.select_topic').html(topic_string).select2();

								});	
			}

			$("select.select_subject").change(function(){ on_select_subject_change($(this)); });
		});