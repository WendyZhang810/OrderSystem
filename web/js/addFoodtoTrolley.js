
function addFoodtoTrolley(item){
    var request = new XMLHttpRequest(); // 新建XMLHttpRequest对象
    var id =item.id;
    var div = "note"+id.toString();
    var note = document.getElementById(div).value;
    var url = 'id='+id+'&note='+note;
    request.open('post','/client/addTrolley?'+url);
    request.send();
}