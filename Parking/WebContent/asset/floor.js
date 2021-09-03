$('document').ready(function(){
	$.getJSON('FetchAllFloorsJSON',{ajax:true},function(data){
		$('#vfno').append($('<option>').text('-Select-'));	
	$.each(data,function(i,item){
		$('#vfno').append($('<option>').text(item.FLOORNAME).val(item.FLOORNO));
 	});	
 	});

	$('#vfno').change(function(){
		 
		$.getJSON('FetchFloorByIdJSON',{ajax:true, fid:$('#vfno').val()},function(data){
		if(data.length==0)
			{
			$('#fdiv').html('<b><i><font color=red>Parking is Empty...</font></i></b>');
			
			}
		else
			{
		 totalspace=data[0].TOTALSPACE;
		 avl_space=data[0].AVL_SPACE;
		 tv=data[0].TOTALVEHICLE;
		 
		 
		 $('#fdiv').html('<font color=green><b><i>Total Space:'+totalspace+"<br>Available Space:"+avl_space+"<br>"+"Total Vehicle:"+tv+"</i></b></font>");
			}
	});

	});



});