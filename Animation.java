import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {
    public void start(Stage stage) {

        // 3D Shapes
        // Sphere instance
        Sphere sphere = new Sphere();
        // Sets Sphere size
        sphere.setRadius(40.0f);
        sphere.setScaleZ(1.1);
        // Sets Sphere material and color
        PhongMaterial phMaterial2 = new PhongMaterial();
        phMaterial2.setDiffuseColor(Color.RED);
        sphere.setMaterial(phMaterial2);

        // Cylinder instance
        Cylinder cylinder = new Cylinder();
        // Sets Cylinder size
        cylinder.setRadius(30.0f);
        cylinder.setHeight(70.0f);
        // Sets Cylinder material and color
        PhongMaterial phMaterial1 = new PhongMaterial();
        phMaterial1.setDiffuseColor(Color.RED);
        cylinder.setMaterial(phMaterial1);

        // Box instance
        Box box = new Box();
        // Sets Box size
        box.setWidth(70.0f);
        box.setHeight(70.0f);
        box.setDepth(70.0f);
        // Sets box material and color
        PhongMaterial boxMaterial = new PhongMaterial();
        boxMaterial.setDiffuseColor(Color.RED);
        box.setMaterial(boxMaterial);

        // Polygon instance
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(50.0, 25.0, 75.0, 25.0, 100.0, 75.0, 75.0, 125.0, 50.0, 125.0, 38.0, 75.0);
        // Sets polygon color
        polygon.setFill(Color.RED);

        // When polygon is clicked changes its color to BLUE and all other shapes' color to GREEN
        polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                polygon.setFill(Color.BLUE);
                PhongMaterial resetColor = new PhongMaterial();
                resetColor.setDiffuseColor(Color.GREEN);
                sphere.setMaterial(resetColor);
                cylinder.setMaterial(resetColor);
                box.setMaterial(resetColor);
            }
        });

        // When box is clicked changes its color to BLUE and all other shapes' color to GREEN
        box.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                polygon.setFill(Color.GREEN);
                PhongMaterial resetColor = new PhongMaterial();
                resetColor.setDiffuseColor(Color.GREEN);
                sphere.setMaterial(resetColor);
                cylinder.setMaterial(resetColor);
                PhongMaterial resetColor1 = new PhongMaterial();
                resetColor1.setDiffuseColor(Color.BLUE);
                box.setMaterial(resetColor1);
            }
        });

        // When cylinder is clicked changes its color to BLUE and all other shapes' color to GREEN
        cylinder.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                polygon.setFill(Color.GREEN);
                PhongMaterial resetColor = new PhongMaterial();
                resetColor.setDiffuseColor(Color.GREEN);
                sphere.setMaterial(resetColor);
                box.setMaterial(resetColor);
                PhongMaterial resetColor1 = new PhongMaterial();
                resetColor1.setDiffuseColor(Color.BLUE);
                cylinder.setMaterial(resetColor1);
            }
        });

        // When sphere is clicked changes its color to BLUE and all other shapes' color to GREEN
        sphere.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                polygon.setFill(Color.GREEN);
                PhongMaterial resetColor = new PhongMaterial();
                resetColor.setDiffuseColor(Color.GREEN);
                cylinder.setMaterial(resetColor);
                box.setMaterial(resetColor);
                PhongMaterial resetColor1 = new PhongMaterial();
                resetColor1.setDiffuseColor(Color.BLUE);
                sphere.setMaterial(resetColor1);
            }
        });

        // Creates 4 button instances for the different effects on the shapes
        Button rotateTransition = new Button("Rotate");
        Button scaleTransition = new Button("Scale");
        Button fadeTransition = new Button("Fade");
        Button sequentialTransition = new Button("Sequence");


        // Rotation EventHandler
        EventHandler<MouseEvent> rotationEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                RotateTransition rotateTransition = new RotateTransition();
                // Sets duration of rotation animation
                rotateTransition.setDuration(Duration.millis(250));

                // Instance Variables to hold the PhongMaterial of the 3D Shapes
                PhongMaterial cylinderMaterial = (PhongMaterial) cylinder.getMaterial();
                PhongMaterial sphereMaterial = (PhongMaterial) sphere.getMaterial();
                PhongMaterial boxMaterial = (PhongMaterial) box.getMaterial();

                // Sets Node for rotateTransition depending on which one is BLUE
                if (polygon.getFill().equals(Color.BLUE))
                    rotateTransition.setNode(polygon);
                else if (cylinderMaterial.getDiffuseColor().equals(Color.BLUE))
                    rotateTransition.setNode(cylinder);
                else if (sphereMaterial.getDiffuseColor().equals(Color.BLUE))
                    rotateTransition.setNode(sphere);
                else if (boxMaterial.getDiffuseColor().equals(Color.BLUE))
                    rotateTransition.setNode(box);

                // Sets rotation transition about the X_AXIS
                rotateTransition.setAxis(Rotate.X_AXIS);
                // Sets rotation angle to 360 degrees
                rotateTransition.setByAngle(360);
                // Sets amount of cycles that rotation occurs
                rotateTransition.setCycleCount(10);
                rotateTransition.setAutoReverse(false);
                // Plays transition
                rotateTransition.play();


            }
        };
        // Sets rotationEvent to occur when rotateTransition Button is clicked
        rotateTransition.addEventHandler(MouseEvent.MOUSE_CLICKED, rotationEvent);

        // Scale EventHandler
        EventHandler<MouseEvent> scaleEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ScaleTransition scaleTransition = new ScaleTransition();
                // Sets duration of scaling animation
                scaleTransition.setDuration(Duration.millis(250));

                // Instance Variables to hold the PhongMaterial of the 3D Shapes
                PhongMaterial cylinderMaterial = (PhongMaterial) cylinder.getMaterial();
                PhongMaterial sphereMaterial = (PhongMaterial) sphere.getMaterial();
                PhongMaterial boxMaterial = (PhongMaterial) box.getMaterial();

                // Sets Node for scaleTransition depending on which one is BLUE
                if (polygon.getFill().equals(Color.BLUE))
                    scaleTransition.setNode(polygon);
                else if (cylinderMaterial.getDiffuseColor().equals(Color.BLUE))
                    scaleTransition.setNode(cylinder);
                else if (sphereMaterial.getDiffuseColor().equals(Color.BLUE))
                    scaleTransition.setNode(sphere);
                else if (boxMaterial.getDiffuseColor().equals(Color.BLUE))
                    scaleTransition.setNode(box);

                // Sets amount that specific shape scales by
                scaleTransition.setByY(1.5);
                scaleTransition.setByX(1.5);
                // Sets amount of cycles that animation occurs for
                scaleTransition.setCycleCount(10);
                // Auto Reverses animation
                scaleTransition.setAutoReverse(true);
                // Plays animation
                scaleTransition.play();
            }
        };
        // Sets scaleEvent to occur when scaleTransition Button is clicked
        scaleTransition.addEventHandler(MouseEvent.MOUSE_CLICKED, scaleEvent);

        //Sequential
        EventHandler<MouseEvent> sequentialEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Instantiates a scaleTransition
                ScaleTransition scaleTransition = new ScaleTransition();
                scaleTransition.setByY(1.5);
                scaleTransition.setByX(1.5);
                scaleTransition.setCycleCount(2);
                scaleTransition.setAutoReverse(true);

                // Instantiates a rotateTransition
                RotateTransition rotateTransition = new RotateTransition();
                rotateTransition.setByAngle(360);
                rotateTransition.setCycleCount(4);
                rotateTransition.setAutoReverse(true);

                SequentialTransition sequentialTransition;

                // Instance Variables to hold the PhongMaterial of the 3D Shapes
                PhongMaterial cylinderMaterial = (PhongMaterial) cylinder.getMaterial();
                PhongMaterial sphereMaterial = (PhongMaterial) sphere.getMaterial();
                PhongMaterial boxMaterial = (PhongMaterial) box.getMaterial();

                // Sets Node for sequentialTransition depending on which one is BLUE
                if (polygon.getFill().equals(Color.BLUE)) {
                    sequentialTransition = new SequentialTransition(polygon, scaleTransition, rotateTransition);
                    sequentialTransition.play();
                } else if (cylinderMaterial.getDiffuseColor().equals(Color.BLUE)) {
                    sequentialTransition = new SequentialTransition(cylinder, scaleTransition, rotateTransition);
                    sequentialTransition.play();
                } else if (sphereMaterial.getDiffuseColor().equals(Color.BLUE)) {
                    sequentialTransition = new SequentialTransition(sphere, scaleTransition, rotateTransition);
                    sequentialTransition.play();
                } else if (boxMaterial.getDiffuseColor().equals(Color.BLUE)) {
                    sequentialTransition = new SequentialTransition(box, scaleTransition, rotateTransition);
                    sequentialTransition.play();
                }


            }
        };
        // Sets sequentialEvent to occur when sequentialTransition Button is clicked
        sequentialTransition.addEventHandler(MouseEvent.MOUSE_CLICKED, sequentialEvent);

        // Fade EventHandler
        EventHandler<MouseEvent> fadeEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Sets FadeTransition to occur on polygon
                FadeTransition ft = new FadeTransition();
                ft.setNode(polygon);
                ft.setFromValue(1.0f);
                ft.setToValue(0.3f);
                ft.setCycleCount(2);
                ft.setAutoReverse(true);
                ft.play();
            }
        };
        // Sets fadeEvent to occur when fadeTransition Button is clicked
        fadeTransition.addEventHandler(MouseEvent.MOUSE_CLICKED, fadeEvent);

        // Instantiates a GridPane and adds each of the Shape Object Instances to it
        GridPane shapes = new GridPane();
        shapes.setVgap(10);
        shapes.setHgap(10);
        shapes.addColumn(1, sphere, new Line(0, 0, 75, 0), cylinder);
        shapes.addColumn(2, new Line(0, 0, 0, 75), new Label(""), new Line(0, 0, 0, 75));
        shapes.addColumn(3, box, new Line(0, 0, 75, 0), polygon);

        // Instantiates a GridPane and adds each of the Button Object Instances to it
        GridPane buttons = new GridPane();
        buttons.setVgap(10);
        buttons.setHgap(10);
        buttons.addRow(0, rotateTransition, scaleTransition, fadeTransition, sequentialTransition);

        // Instantiates a GridPane and adds Text Description of Program
        GridPane text = new GridPane();
        text.addRow(0, new Label("Click on a shape to change its color."));
        text.addRow(1, new Label("Click the buttons to perform action on"));
        text.addRow(2, new Label("Blue Shape. (fade only works on polygon)"));

        // Instantiates a VBox and adds each of teh GridPane instances to it
        VBox root = new VBox();
        root.setPadding(new Insets(15, 12, 15, 12));
        root.setSpacing(10);
        root.getChildren().addAll(buttons, new Label(""), shapes, text);

        // Instantiates a Scene instance with root VBox instance
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Sets Window attributes
        stage.setX(200);
        stage.setY(300);
        stage.setMinHeight(300);
        stage.setMinWidth(300);
        stage.setTitle("Shape Animations");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
