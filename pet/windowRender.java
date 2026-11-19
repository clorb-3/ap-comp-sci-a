
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class pet {

  private int hunger = 75;
  private int weightLbs = 10;
  private int tiredness = 75;
  private boolean canSleep = false;
  private String name;
  private int happiness = 75;
  private int health = 75;

  public pet(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getHunger() {
    return this.hunger;
  }

  public int getExaustion() {
    return this.tiredness;
  }

  public boolean getCanSleep() {
    return this.canSleep;
  }

  public int getWeight() {
    return this.weightLbs;
  }

  public int getHealth() {
    return this.health;
  }

  public int getHappiness() {
    return this.happiness;
  }

}

public class windowRender extends Application {

  private double xOffset = 0;
  private double yOffset = 0;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.initStyle(StageStyle.TRANSPARENT);

    Label health = new Label("[75]");
    health.setStyle("-fx-text-fill: white;" +
        "-fx-font-size: 16px;");
    Label hunger = new Label("[75󱐠]");
    hunger.setStyle("-fx-text-fill: white;" +
        "-fx-font-size: 16px;");
    Label thirst = new Label("[75󰖌]");
    thirst.setStyle("-fx-text-fill: white;" +
        "-fx-font-size: 16px;");
    Label boredom = new Label("[75]");
    boredom.setStyle("-fx-text-fill: white;" +
        "-fx-font-size: 16px;");
    Label exaustion = new Label("[75💤]");
    exaustion.setStyle("-fx-text-fill: white;" +
        "-fx-font-size: 16px;");

    HBox petInfo = new HBox(15, health, hunger, thirst, boredom, exaustion);
    petInfo.setAlignment(Pos.CENTER);
    petInfo.setStyle("-fx-font-family: monospace;" +
        "-fx-background-color: rgba(30, 30, 30, 1);" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 10;");

    Label petImage = new Label("""
             |\\_/|
             | @ @   Woof!
             |   <>              _
             |  _/\\------____ ((| |))
             |               `--' |
         ____|_       ___|   |___.'
        /_/_____/____/_______|
        """);
    petImage.setStyle("-fx-font-family: monospace;" +
        "-fx-text-fill: white;" +
        "-fx-font-size: 16px;" +
        "-fx-background-color: rgba(30, 30, 30, 1);" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 10;");

    Button foodWaterButton = new Button("󰉚");
    foodWaterButton.setOnAction(e -> primaryStage.close());
    Button playButton = new Button("󰔇");
    playButton.setOnAction(e -> primaryStage.close());
    Button sleepButton = new Button("󰢠");
    sleepButton.setOnAction(e -> primaryStage.close());
    Button cleanButton = new Button("");
    cleanButton.setOnAction(e -> primaryStage.close());
    Button travelButton = new Button("");
    travelButton.setOnAction(e -> primaryStage.close());
    Button closeButton = new Button("");
    closeButton.setOnAction(e -> primaryStage.close());

    HBox actions = new HBox(15, foodWaterButton, playButton, sleepButton, cleanButton, travelButton, closeButton);
    actions.setAlignment(Pos.CENTER);
    actions.setStyle("-fx-font-family: monospace;" +
        "-fx-background-color: rgba(30, 30, 30, 1);" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 10;");

    VBox root = new VBox(15, petInfo, petImage, actions);
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(20));
    root.setStyle("-fx-background-color: rgba(30, 30, 30, 0);" +
        "-fx-border-color: rgba(255, 255, 255, 0);");

    root.setOnMousePressed(event -> {
      xOffset = event.getSceneX();
      yOffset = event.getSceneY();
    });

    root.setOnMouseDragged(event -> {
      primaryStage.setX(event.getScreenX() - xOffset);
      primaryStage.setY(event.getScreenY() - yOffset);
    });

    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
