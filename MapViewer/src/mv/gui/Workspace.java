/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.gui;

import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import saf.components.AppWorkspaceComponent;
import mv.MapViewerApp;
import mv.data.DataManager;

/**
 *
 * @author McKillaGorilla
 */
public class Workspace extends AppWorkspaceComponent {
    MapViewerApp app;
    Pane renderPane = new Pane();
    
    public Workspace(MapViewerApp initApp) {
        app = initApp;
        workspace = new Pane();
        removeButtons();
    }

    @Override
    public void reloadWorkspace() {
        DataManager dataManager = (DataManager)app.getDataComponent();
        app.getWorkspaceComponent().getWorkspace().setStyle("-fx-background-color: lightblue;");
        //app.getWorkspaceComponent().getWorkspace().
                //.setBackground(new Background("#F0F8FF"));
        dataManager.fillPolygons(Paint.valueOf("#556B2F"));
        //for (int m = 0; m < dataManager.getPolygonList().size(); m++) {
        for (Polygon poly: dataManager.getPolygonList()) {
          //dataManager.getPolygonList().get(m).setScaleX(6);
          //dataManager.getPolygonList().get(m).setScaleY(6);
          
          renderPane.getChildren().addAll(poly);
        }
        renderPane.setScaleX(4);renderPane.setScaleY(4);

        app.getWorkspaceComponent().getWorkspace().getChildren().add(renderPane);
        //app.getWorkspaceComponent().
    }

    @Override
    public void initStyle() {
        
    }
    public void removeButtons() {
        FlowPane fp = (FlowPane)app.getGUI().getAppPane().getTop();
        fp.getChildren().remove(2);
        fp.getChildren().remove(0);
    }
}
