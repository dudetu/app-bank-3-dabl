# app-bank-3-dabl
Дубликат
Приложение создано для внутри банковского использования. Сущности и в последствии могут дополнятся в зависимости от запросов банка.(Agreement,Product)
Сущность Account может быть дополнена  ( сущностями card debit, card credit,)
Связи с БД соответственно можна позже прописать при добавлении дополнительных сущностей .Не забываем ставить  @JsonIgnore для предупреждения рекурсии.
Основные опции прописаны.(Account,Client,Manager,Transaction)
Можно еще прописать переводы по IBAN с подключением через API другого банка
Секьюрити можно позже прописать (Аутоинтефикация и авторизация) .(чтобы не было проблем при тестировании в Postman)
Прописан генератор счетов (кредит и дебит карточек) для использования клиентом.
Прописан конвертер валют(его можно еще через API внешнего ресурса подключить в режиме реального времени.
Прописаны исключения ( "нет данных о клиенте ","на счету недостаточно денег")
Прописан глобальный обработчик исключений для контроллеров Handler(Обрабатывает исключение DataNotFoundException.,Обрабатывает исключение LowBalanceException.)
При тестировании запросов POST,GET данные передаются корректно.
Тесты на Controller,Repository,Service ошибок не выдают.
Для кеширования в Service используем @Cacheable и @CacheEvict для кеширования списка банковских счетов и обновления кеша при обновлении данных.(дополнительно можем прописать)
Были использованы DTO и Convector DTO для избирательной выдачи информации клиенту.
В enum прописаны статусы и валюты.(создано три enum)
