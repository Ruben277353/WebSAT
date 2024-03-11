<!DOCTYPE html>
<html>
<head>
    <title>SLAVE</title>
</head>
<body>
<h1>SLAVE</h1>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${products.title}<br>
<b>Описание товара: </b>${products.description}<br>
<b>Цена: </b>${products.price}<br>
<b>Город: </b>${products.city}<br>
<b>Автор: </b>${products.author}<br>
<hr>
<form action="/product/delete/${products.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>