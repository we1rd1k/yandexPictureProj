#language: ru

Функционал: : Yandex поиск

  Сценарий: : Тест поиска по картинке
    Дано Изображение для поиска "автокран"
    Когда Открываем главную страницу Yandex
    Когда Кликаем по иконке "Картинки"
    И Переключаемся на окно поиска картинок
    То Проверяем, что находимся на странцу для поиска картинок
    Когда Кликаем по кнопке Поиск по изображению
    Тогда Проверяем, что появился ToolBar для вставки изображения
    Когда Когда загружаем картинку для поиска
    И Кликаем по кнопке найти
    Тогда Проверяем, что в блоке "Кажется на изображении есть" присутствует название изображения