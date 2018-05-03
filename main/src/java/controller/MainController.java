package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.AbstractSort;
import model.BubbleSort;
import model.InsertionSort;
import model.QuickSort;

public class MainController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private ToggleGroup tgFill;

        @FXML
        private ToggleGroup tgSortType;

        @FXML
        private Spinner<Integer> spArraysSize;

        @FXML
        private Spinner<Integer> spRepeatCount;

        @FXML
        private Spinner<Integer> spDiapasonMin;

        @FXML
        private Spinner<Integer> spDiapasonMax;

        @FXML
        private ListView<String> lvTimesList;

        private AbstractSort sort;

        @FXML
        void btnCalculate(ActionEvent event) {
            switch (((RadioButton)tgSortType.getSelectedToggle()).getText()){
                case "Простой обмен":  {
                    sort=new BubbleSort(spDiapasonMin.getValue(),spDiapasonMax.getValue(), spArraysSize.getValue(),spRepeatCount.getValue());
                    break;
                }
                case "Простое включение":  {
                    sort=new InsertionSort(spDiapasonMin.getValue(),spDiapasonMax.getValue(), spArraysSize.getValue(),spRepeatCount.getValue());
                    break;
                }
                case "Быстрая сортировка":  {
                    sort=new QuickSort(spDiapasonMin.getValue(),spDiapasonMax.getValue(), spArraysSize.getValue(),spRepeatCount.getValue());
                    break;
                }
            }
            sort.buildStatistics(((RadioButton)tgFill.getSelectedToggle()).getText());
            lvTimesList.getItems().add(sort.toString(((RadioButton)tgSortType.getSelectedToggle()).getText(),((RadioButton)tgFill.getSelectedToggle()).getText()));
        }

        @FXML
        void btnClear(ActionEvent event) {
            lvTimesList.getItems().clear();
        }
        private void setControllsBehaviour(){
            spArraysSize.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(100,50000,1000,100));
            spRepeatCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2,50));
            spDiapasonMin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));
            spDiapasonMax.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5,999,5,25));

        }
        @FXML
        void initialize() {
            assert tgFill != null : "fx:id=\"tgFill\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert tgSortType != null : "fx:id=\"tgSortType\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert spArraysSize != null : "fx:id=\"spArraysSize\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert spRepeatCount != null : "fx:id=\"spRepeatCount\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert spDiapasonMin != null : "fx:id=\"spDiapasonMin\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert spDiapasonMax != null : "fx:id=\"spDiapasonMax\" was not injected: check your FXML file 'MainWindow.fxml'.";
            assert lvTimesList != null : "fx:id=\"lvTimesList\" was not injected: check your FXML file 'MainWindow.fxml'.";
            setControllsBehaviour();
        }
    }

