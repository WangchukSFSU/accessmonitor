<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>

		<script src="https://www.google.com/jsapi" type="text/javascript"></script>
		<script type="text/javascript">
		
		
			google.load('visualization', '1', {packages: ['corechart']});
			google.setOnLoadCallback(drawTooltipCharts);
			
			var personIds = ${personIds};
			var personCounts = ${personCounts};
			
			
			var primaryData = [
['NBA Finals', 22.4],
['NFL Super Bowl', 111.3],
['MLB World Series', 19.2],
['UEFA Champions League Final', 1.9],
['NHL Stanley Cup Finals', 6.4],
['Wimbledon Men\'s Championship', 2.4]
];
			var tooltipData1 = [
['Year', 'NBA Finals', 'NFL Super Bowl', 'MLB World Series',
'UEFA Champions League Final', 'NHL Stanley Cup Finals',
'Wimbledon Men\'s Championship'],
['2005', 12.5, 98.7, 25.3, 0.6, 3.3, 2.8],
['2006', 13.0, 90.7, 17.1, 0.8, 2.8, 3.4],
['2007', 9.3, 93.0, 15.8, 0.9, 1.8, 3.8],
['2008', 14.9, 97.5, 17.1, 1.3, 4.4, 5.1],
['2009', 14.3, 98.7, 13.6, 2.1, 4.9, 5.7],
['2010', 18.2, 106.5, 19.4, 2.2, 5.2, 2.3],
['2011', 17.4, 111.0, 14.3, 4.2, 4.6, 2.7],
['2012', 16.8, 111.3, 16.6, 2.0, 2.9, 3.9],
['2013', 16.6, 108.7, 12.7, 1.4, 5.8, 2.5],
['2014', 15.7, 111.3, 15.0, 1.9, 4.7, 2.4]
];

			var tooltipData = ${tooltipdata};
			
			for (var i = 1; i < tooltipData.length; i++) {
			
				for (var j = 1; j < tooltipData[i].length; j++) {
					
					tooltipData[i][j] = parseInt(tooltipData[i][j]);
					
				}
			
			}
			
			var primaryOptions = {
				title: 'Person Access for Each Person ID',
				legend: 'none',
				tooltip: {isHtml: true}
			};
				
			var tooltipOptions = {
				title: 'Person Access for This Person',
				legend: 'none'
			};
			
			function drawTooltipCharts() {
				console.log("start tolltip");
				var data = new google.visualization.arrayToDataTable(tooltipData);
				var view = new google.visualization.DataView(data);
				for (var i = 0; i < primaryData.length; i++) {
					view.setColumns([0, i + 1]);
					var hiddenDiv = document.getElementById('hidden_div');
					var tooltipChart = new google.visualization.LineChart(hiddenDiv);
					google.visualization.events.addListener(tooltipChart, 'ready', function() {
						console.log("doing tooltip");
						var tooltipImg = '<img src="' + tooltipChart.getImageURI() + '">';
						primaryData[i][2] = tooltipImg;
					});
					tooltipChart.draw(view, tooltipOptions);
				}
				console.log("end tooltip");
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
		
		
		<div>
            <form action="" method="get" class="box">
                <table cellspacing="0" width="100%">
                    <tr>
                        <td style="width:12%">
                            <label for="From">From</label>
                            <input type="text" name="datepickerFrom" id="datepickerFrom" value="date" />
                        </td>
                        <td style="width:12%">
                            <label for="To">To</label>
                            <input type="text" name="datepickerTo"  id="datepickerTo" value="date" />
                        </td>
                        <td style="width:2%">
                            <input type="submit" value="Submit" />
                        </td>
                    </tr>
                </table>
            </form>

        </div>

		<div id="hidden_div" style="display:none"></div>
		<div id="visible_div" style="height:300px"></div>


<%@ include file="/WEB-INF/template/footer.jsp"%>