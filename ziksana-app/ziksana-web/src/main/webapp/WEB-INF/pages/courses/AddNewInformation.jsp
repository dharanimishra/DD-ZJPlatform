<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Additional course information</title>
<link href="/ziksana-web/resources/css/main/styles.css" rel="stylesheet"
	type="text/css">
	<link rel="stylesheet"
		href="/ziksana-web/resources/css/common/datepicker/datepicker.css"
		type="text/css">
		<link rel="stylesheet"
			href="/ziksana-web/resources/css/common/validation/validation.css" />
		<script type="text/javascript"
			src="/ziksana-web/resources//js/ziksana/jquerylibrary/main/jquery-1.7.2.min.js"></script>
		<script
			src="/ziksana-web/resources//js/ziksana/validation/jquery.validationen.js"
			type="text/javascript" charset="utf-8">
			
		</script>
		<script
			src="/ziksana-web/resources/js/ziksana/validation/jquery.validation.js"
			type="text/javascript" charset="utf-8">
			
		</script>
		<script>
			jQuery(document).ready(function() {
				// binds form submission and fields to the validation engine
				jQuery("#AddNewInformation").validationEngine();
			});
		</script>

		<script
			src="/ziksana-web/resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script src="/ziksana-web/resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/datepicker/zebra_datepicker.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/datepicker/functions.js"></script>
<script src="/ziksana-web/resources/js/ziksana/coursecreation/define.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/ckeditor/adapters/jquery.js"></script>
<script src="/ziksana-web/resources/js/ziksana/ckeditor/ckeditor.js"></script>
</head>

<body style="background-image: none;">

	<div class="Addmodulecontainer">
		<br />
		<div class="definehelp"
			style="width: 680px; font-family: Verdana; font-size: 12px; color: #300;">
			<img src="/ziksana-web/resources/images/icons/helpicon.png"
				align="left"
				style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Add
			additional course information you require
		</div>

		<!----------------- start of first container --------------->
		<div class="coursename">
			<div class="control-group">
				<label class="control-label labelclass" for="New Information"
					style="margin-top: -4px;">New Information :</label>
				<div class="controls">
					<input type="text" id="Caddnewinfolblname"
						class="defaultvalue validate[required]" autofocus="true"
						placeholder="Enter the label for new information" tabindex="1"
						style="width: 240px; margin-left: 10px;" />
				</div>


				<br /> <label class="control-label labelclass"
					for="New Information" style="margin-top: -4px;">Information
					type :</label>
				<div class="controls">
					<select name="SelectArea" id="Caddnewinfotype" tabindex="2"
						class="defaultvalue validate[required]"
						style="margin-left: 8px; width: 250px;">
						<option value="Text">Text</option>
						<option value="Numeric">Numeric</option>
						<option value="Date">Date</option>
					</select>
				</div>
				<!-- end of moduleselection--->
				<br />

				<div id="infodate">
					<label for="coursemodule" class="labelclass">Additional
						Information :</label> <input id="Caddnewinfodate" type="text"
						value="Pick a Date" class="defaultvalue validate[required]">
				</div>
				<!-- end of coursename--->
				<div class="_newtext">
					<br /> <label for="coursemodule" class="labelclass">Additional
						Information :</label> <br /> <a class="f-r _richText" href="#"
						style="text-decoration: none;">Rich Text Editor</a> <a
						class="f-r _plainText" href="#" style="text-decoration: none;">Plain
						Text Editor</a>
					<textarea
						class="_plainTextShow labelclass defaultvalue validate[required]"
						id="Caddnewinfotext" cols="90" rows="7" style="resize: none;"
						placeholder="Describe the Course being created"></textarea>
					<br />
					<div class="_richTextShow">
						<textarea id="Caddnewinfotextrte" name="editor1"
							class="defaultvalue _focus validate[required]">Describe the Course being created</textarea>
					</div>
					<script type="text/javascript">
						CKEDITOR.replace('Caddnewinfotextrte');
					</script>
				</div>
				<br />
				<div id="infonumber">
					<label for="coursemodule" class="labelclass">Additional
						Information :</label> <input type="text" id="Caddnewinfonumeric"
						class="defaultvalue validate[required]" autofocus="true"
						placeholder="Enter Numberic Information" style="width: 240px;" />
				</div>
				<input type="reset" class="btn btn-info" id="Caddnewinfocncl"
					onclick="b.fancybox.close()" value="Cancel"
					style="float: right; margin-right: 20px;"> <input
					type="submit" class="btn btn-info" value="Add" id="Caddnewinfosbt"
					onClick="getaddnewinfosave()"
					style="float: right; margin-right: 20px;"><br /> <br />
		
			</div>
		</div>
	</div>
	<!-- end of addmodulecontainer--->
</body>
</html>
