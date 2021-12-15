function alter(item){
    document.getElementById("food_id").value=item.id;
    document.getElementById("food_name").value=item.name;
    var value = document.getElementById("price"+item.id).innerText;
    document.getElementById("food_price").value=value;
}