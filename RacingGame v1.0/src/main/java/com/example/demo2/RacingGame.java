package com.example.demo2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RacingGame extends Application {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 400;
  private static final int DISTANCE = 735;

  private int position1 = 0;
  private int position2 = 0;
  private int speed1 = 0; // Скорость гонщика 1
  private int speed2 = 0; // Скорость гонщика 2

  private Button restartButton;
  private AnimationTimer gameLoop;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Симулятор гонок");

    Canvas canvas = new Canvas(WIDTH, HEIGHT);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    StackPane root = new StackPane();
    root.getChildren().add(canvas);
    primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));

    // Обработка нажатия клавиш
    primaryStage.getScene().setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case A:
          speed1 = 2;
          break;
        case L:
          speed2 = 2;
          break;
      }
    });

    // Обработка отпускания клавиш
    primaryStage.getScene().setOnKeyReleased(event -> {
      switch (event.getCode()) {
        case A:
          speed1 = 0;
          break;
        case L:
          speed2 = 0;
          break;
      }
    });

    restartButton = new Button("Перезапустить игру");
    restartButton.setOnAction(event -> restartGame());

    root.getChildren().add(restartButton);
    restartButton.setVisible(false);

    gameLoop = new AnimationTimer() {
      @Override
      public void handle(long now) {
        // Очистка экрана
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Рисуем дорогу
        gc.setFill(Color.GRAY);
        gc.fillRect(0, HEIGHT / 2 - 125, WIDTH, 175);

        // Рисуем пунктирные полосы на дороге
        gc.setLineWidth(5);
        gc.setStroke(Color.WHITE);
        double dashWidth = 20;
        double dashSpace = 15;
        double dashCount = WIDTH / (dashWidth + dashSpace);
        double centerY = HEIGHT / 2 - 35;
        for (int i = 0; i < dashCount; i++) {
          double x = i * (dashWidth + dashSpace);
          gc.strokeLine(x, centerY, x + dashWidth, centerY);
        }

        // Рисуем финишную линию
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(DISTANCE, centerY - 40, DISTANCE, centerY + 40);

        // Симуляция движения машин
        position1 += speed1;
        position2 += speed2;

        // Рисование машин
        drawCar(gc, Color.BLUE, position1, HEIGHT / 4);
        drawCar(gc, Color.RED, position2, HEIGHT / 2);

        // Проверка на финиш
        if (position1 >= DISTANCE && position2 >= DISTANCE) {
          System.out.println("Гонка закончилась вничью!");
          showRestartButton();
          stop();
        } else if (position1 >= DISTANCE) {
          System.out.println("Победитель: Гонщик 1!");
          showRestartButton();
          stop();
        } else if (position2 >= DISTANCE) {
          System.out.println("Победитель: Гонщик 2!");
          showRestartButton();
          stop();
        }
      }
    };

    primaryStage.show();
    gameLoop.start();
  }

  private void drawCar(GraphicsContext gc, Color color, double x, double y) {
    gc.setFill(color);
    gc.fillRect(x + 0, y - -7 , 60, 20); // Корпус машины
    gc.fillOval(x + 0, y + 25, 20, 20); // Левое колесо
    gc.fillOval(x + 40, y + 25, 20, 20); // Правое колесо
  }

  private void showRestartButton() {
    restartButton.setVisible(true);
  }

  private void restartGame() {
    position1 = 0;
    position2 = 0;
    speed1 = 0;
    speed2 = 0;
    restartButton.setVisible(false);
    gameLoop.start();
  }
}










