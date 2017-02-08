$(document).ready(function () {
    $('.carousel').carousel({
        interval: 2000
    });
});

$(document).ready(function () {
    $('a.buy').click(function (event) {
        event.preventDefault();
        // очищаем содержимое модального окна
        $(".modal-info").empty();
        // принимаем значения url и id товара из ссылки
        var url = $(this).attr("href");
        var goodId = $(this).data("id");

        // делаем POST запрос
        $.ajax({
            url: url,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(goodId),
            dataType: 'json',
            type: 'post',
            success: function (data) {
                $(".modal-info").append(data);
            },
            error: function () {
                $(".modal-info").append('Before adding a good to the cart, please log in!');
            }
        });
    });

    $('button.good-calc').click(function (event) {
        event.preventDefault();
        // Идентификатор item'a - сущность, которая представляет товар
        var itemId = $(this).data("id");
        // Если у кнопки есть класс 'good-calc-up', значит мы прибавляем
        var isPlus = $(this).hasClass('good-calc-up');
        var count = 0;
        $.ajax({
            url: "/cart/calculate",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({id: itemId, isPlus: isPlus}),
            dataType: 'json',
            type: 'post',
            context: this,
            success: function (data) {
                $(this).parent().children('.good-count').text(data.count);
                $("h3>span").text(data.sum);
            },
            error: function () {
                console.log('Error! ' + $(this));
            }
        });
    });

});
