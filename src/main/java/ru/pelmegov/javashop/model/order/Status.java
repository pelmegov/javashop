package ru.pelmegov.javashop.model.order;

public enum Status {

    // заказ ожидает обработки администратором или модератором
    WAIT,
    // заказ в процессе доставки
    IN_PROCESS,
    // заказ успешно выполнен
    DONE

}
