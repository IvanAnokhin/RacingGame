### Гоночный симулятор
* Это простое JavaFX приложение представляет собой гоночный симулятор, в котором два гонщика соревнуются за первое место на дороге. Гонка проходит на прямой дороге длиной 735 пикселей. Во время гонки вы можете управлять движением гонщиков с помощью клавиш A и L. Победителем становится тот, кто первым достигнет финишной линии.
  
![racing1](https://github.com/IvanAnokhin/RacingGame/assets/119599047/7ae753d4-fbff-4b11-906a-1dd9d108d263)

### Требования
* Чтобы запустить приложение, выполните следующие шаги:

1) Убедитесь, что у вас установлены JRE и JavaFX библиотеки.
2) Скопируйте содержимое файла HelloApplication.java в свою среду разработки Java (например, IntelliJ IDEA или Eclipse).
3) Запустите приложение, щелкнув правой кнопкой мыши по классу RacingGame и выбрав "Run RacingGame".

### Управление
* Гонщик 1: Используйте клавишу A для ускорения.
* Гонщик 2: Используйте клавишу L для ускорения.

### Интерфейс
* Гонщики: Гонщик 1 обозначен синим цветом, а гонщик 2 - красным. Они представлены простыми прямоугольниками, представляющими автомобили.
* Дорога: Гоночная трасса представляет собой прямую дорогу длиной 735 пикселей. Пунктирные полосы на дороге помогают определить пройденное расстояние.
* Финиш: Финишная линия обозначена вертикальной черной линией в конце дороги.

  ![racing2](https://github.com/IvanAnokhin/RacingGame/assets/119599047/3fe59f42-d51b-46ec-83f1-82bbb7cfa936)

### Правила игры
* Гонка начинается с момента, когда вы нажимаете клавиши управления (A или L).
* Первый гонщик, который достигнет финишной линии, становится победителем.
* При завершении гонки появляется сообщение о победителе и появляется кнопка "Перезапустить игру", чтобы начать новую гонку.
### Описание кода
* Код приложения реализован на языке Java с использованием JavaFX для графического интерфейса. Главный класс RacingGame содержит всю логику игры и отображения.
* В start методе устанавливается графический интерфейс с использованием JavaFX и создается окно приложения с дорогой и гонщиками.
* Методы setOnKeyPressed и setOnKeyReleased обрабатывают события нажатия и отпускания клавиш для управления гонщиками.
* В методе handle класса AnimationTimer обновляется положение гонщиков и проверяется, достигли ли они финиша.
* При завершении гонки отображается победитель и кнопка "Перезапустить игру", чтобы начать новую гонку.
