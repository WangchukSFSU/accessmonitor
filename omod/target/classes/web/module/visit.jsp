<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<style>
            input[type=range] {
                -webkit-appearance: none;
                background-color: silver;
                height:20px;
            }

            input[type="range"]::-webkit-slider-thumb {
                -webkit-appearance: none;
                background-color: #666;
                opacity: 0.5;
                width: 10px;
                height: 26px;
            }

            .button {
                padding:5px;
                background-color:#ffffff;
                border:#ffffff;
                color:blue;
                text-decoration:none;
            }
</style>

<p>Hello ${user.systemId}!</p>

<div>
	<a class="button" href="person.htm">Person</a>
	<a class="button" href="visit.htm">Visit</a>
	<a class="button" href="order.htm">Order</a>
</div>
<div style="padding-top:10px">
	<span class="boxHeader">Visit Access Statistics</span>
</div>

<div>
	<form action="" method="get" class="box">
		<table cellspacing="0" width="100%">
			<tr>
				<td style="width:12%">
					<label for="From">From</label>
					<input type="text" name="datepickerFrom" id="datepickerFrom" value="" />
					<label for="To">To</label>
					<input type="text" name="datepickerTo"  id="datepickerTo" value="" />
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form>
</div>


		<script src="https://www.google.com/jsapi" type="text/javascript"></script>
		<script type="text/javascript">
		
		
			google.load('visualization', '1', {packages: ['corechart']});
			google.setOnLoadCallback(drawTooltipCharts);
			
			var patientIds = ${patientIds};
			var patientCounts = ${patientCounts};
			var dateSmall = ${dateSmallString};
			
			var primaryData = [];
			for (var i = 0; i < patientIds.length; i++) {
				primaryData[i] = ["ID" + (i+1), patientCounts[i]];
			}

			var tooltipData = ${tooltipdata};
			
			for (var i = 0; i < tooltipData.length - 1; i++) {
				tooltipData[i+1][0] = dateSmall[i];
			}

			for (var i = 0; i < tooltipData[0].length; i++) {
				tooltipData[0][i] = "";
			}
			
			var getDateString = function(name) {
				if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
      			return decodeURIComponent(name[1]);
			}
			
			$("#datepickerFrom").val(getDateString("datepickerFrom"));
			$("#datepickerTo").val(getDateString("datepickerTo"));
			
			var primaryTitle = 'Visit Access for Each Patient ID';
			if (getDateString("datepickerFrom")) {
				primaryTitle = primaryTitle + " From " + getDateString("datepickerFrom");
			}
			if (getDateString("datepickerTo")) {
				primaryTitle = primaryTitle + " To " + getDateString("datepickerTo");
			}
			
			var primaryOptions = {
				title: primaryTitle,
				legend: 'none',
				tooltip: {isHtml: true}
			};
				
			var options = function(idString) {
				var tooltipOptions = {
					title: 'Visit Access for Patient ID = ' + idString,
					legend: 'none'
				};
				return tooltipOptions;
			}
			
			function drawTooltipCharts() {
				var data = new google.visualization.arrayToDataTable(tooltipData);
				var view = new google.visualization.DataView(data);
				for (var i = 0; i < primaryData.length; i++) {
					view.setColumns([0, i + 1]);
					var hiddenDiv = document.getElementById('hidden_div');
					var tooltipChart = new google.visualization.LineChart(hiddenDiv);
					google.visualization.events.addListener(tooltipChart, 'ready', function() {
						var tooltipImg = '<img src="' + tooltipChart.getImageURI() + '">';
						primaryData[i][2] = tooltipImg;
					});
					tooltipChart.draw(view, options(patientIds[i]));
				}
				drawPrimaryChart();
			}
			
			function drawPrimaryChart() {
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');
				
				data.addColumn({
					type: 'string',
					label: 'Tooltip Chart',
					role: 'tooltip',
					'p': {'html': true}
				});
				data.addRows(primaryData);
			
				var visibleDiv = document.getElementById('visible_div');
				var primaryChart = new google.visualization.LineChart(visibleDiv);
				primaryChart.draw(data, primaryOptions);
			}
		</script>
		
		
		

<div id="hidden_div" style="display:none"></div>
<div id="visible_div" style="height:300px"></div>
		
		
<script>
	$(function () {
		$("#datepickerFrom").datepicker();
	});
</script>
<script>
	$(function () {
		$("#datepickerTo").datepicker();
	});
</script>


<%@ include file="/WEB-INF/template/footer.jsp"%>