# Тестовое задание СПБМТСБ

Приложение - "Начисление бонусов за покупку".

## Краткое описание

Оплата покупок в магазине наличным и безналичным способами, и возврат бонуса в зависимости от типа оплаты.

### Запуск

- Стек:
    - Java 17.
    - Maven для сборки.
    - Spring Boot версии 3.n.n.

### Описание микросервиса

Микросервис имеет 3 REST эндпоинта:
  - POST /api/payment/{Shop|Online}/{amount} - указать тип оплаты и сумму и в зависимости от них списать сумму со счета клиента и начислить бонусы

Функция **makePurchase** - в зависимости от суммы, определяет состояние **ReturnState | PurchaseState**
Функция **handleTransaction** - в зависимости от состояние либо списывает комиссию либо начисляет бонусы
  - GET /api/bankAccountOfEMoney - получить количество бонусов на счете клиента
  - GET /api/money - количество наличных/безналичных денег


### Тестовые параметры
- /api/payment/ONLINE/100
- /api/payment/SHOP/120
- /api/payment/ONLINE/301
- /api/payment/ONLINE/17
- /api/payment/shop/1000
- /api/payment/online/21
- /api/payment/SHOP/570
- /api/payment/ONLINE/700
 
