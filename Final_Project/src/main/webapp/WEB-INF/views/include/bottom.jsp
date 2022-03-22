<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<div class="toast" data-autohide="false">
		<div class="toast-header">
			<strong class="mr-auto text-primary"></strong>
		</div>
	</div>
</div>	
	
<script>
	var serverName = location.host;
	var ws = new WebSocket("ws://" + serverName + "/ws/alert");
	
	ws.onmessage = function(recv){
		//console.log(recv.data);
		var obj = JSON.parse(recv.data);
		
		$(".toast").toast("show");
	}
</script>
</body>
</html>
