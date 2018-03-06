function disableLinkByReplace(id){
	//create a dummy link and hide the original one
	var dummyLink = document.createElement('a');
	dummyLink.id = id + "_tmp";
	dummyLink.className =  $('#' + id).attr("class") + " dummyLink";
	$(dummyLink).html($('#' + id).html());
	
	$('#' + id).after($(dummyLink)).hide();
}

function enableLinkByReplace(id){
	//remove the dummy link and show the original again
	var tmpId = id + "_tmp";
	$('#' + id).siblings('#' + tmpId).remove(); $('#' + id).show();
}