package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    BorderPane borderPane;

    String http = "http://";

    WebHistory history;
    VBox historyPane;
    boolean show;

    @FXML
    TextField addressBar;

    String link;

    @FXML
    WebView web;

    @FXML
    ComboBox<String> historyBox;

    WebEngine engine;

    @FXML
    HBox statusBox;

    @FXML
    ProgressBar progressBar;

    @FXML
    Text status;

    public void go(ActionEvent actionEvent) {
        link = addressBar.getText().toString();
        engine.load(http + link);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(http + "www.google.com");
        history = engine.getHistory();
        show = false;
        initHistoryBox();
        initProgressBar();
    }

    private void initProgressBar(){
        progressBar = new ProgressBar();
        Worker<Void> worker = engine.getLoadWorker();
        worker.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (!progressBar.isVisible()){
                progressBar.setVisible(true);
            }
            status.setText(" Loading status: "+newValue.toString());
            if (newValue == Worker.State.SUCCEEDED){
                status.setText("Finished.");
                if (progressBar.isVisible()){
                    progressBar.setVisible(false);
                }
            }
        });
        progressBar.progressProperty().bind(worker.progressProperty());
    }

    private void initHistoryBox() {
        historyPane = new VBox();
        historyPane.setSpacing(8);
        historyPane.setPadding(new Insets(10));
        Text title = new Text("History");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        historyPane.getChildren().add(title);
    }

    private void updateHistory() {
        historyPane.getChildren().clear();
        Text title = new Text("History");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        historyPane.getChildren().add(title);
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        for (WebHistory.Entry entry : entries) {
            HBox row = new HBox();
            String url = entry.getUrl();
            String date = String.valueOf(entry.getLastVisitedDate());
            String titleH = entry.getTitle();
            Text historyRecord = new Text(titleH + " " + date);
            row.getChildren().add(historyRecord);
            row.setOnMouseClicked(event -> {
                link = url;
                engine.load(link);
            });
            historyPane.getChildren().add(row);
        }
    }

    public void showHistory(ActionEvent actionEvent) {
        updateHistory();
        if (show){
            historyPane.setVisible(false);
            borderPane.getChildren().remove(historyPane);
            show = false;
        } else {
            historyPane.setVisible(true);
            borderPane.setRight(historyPane);
            show = true;
        }
    }

    public void goHistory(ActionEvent actionEvent) {
        String link = historyBox.getValue();
    }

    public void nextHistory(ActionEvent actionEvent) {
        history.go(1);
    }

    public void previousHistory(ActionEvent actionEvent) {
        history.go(-1);
    }
}