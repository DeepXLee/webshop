$(function(){
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/webshop/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl, function(data){
		if(data.redirect){
			window.location.href = data.url;
		}else{
			if(data.shopId != undefined && data.shopId != null){
				shopId = data.shopId;
				alert("shopId:"+shopId);
			}
			$('#shopInfo').attr('href','/webshop/shopadmin/shopoperation?shopId=' + shopId);
		}
	});
	
});
