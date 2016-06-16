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
        
        //initialize processing of eventhandlers - create new method
    }

    @Override
    public void reloadWorkspace() {
        DataManager dataManager = (DataManager)app.getDataComponent();
        //clears the workspace
        workspace.getChildren().clear();
        
        //set the background to be lightblue
        workspace.setStyle("-fx-background-color: lightblue;");
        //app.getWorkspaceComponent().getWorkspace().
        //.setBackground(new Background("#F0F8FF"));
           
        //fill polygons with green
        dataManager.fillPolygons(Paint.valueOf("#556B2F"));
        
        
        //clears the pane so you can load something else
        renderPane.getChildren().clear();
        
        //add the polygons
        for (Polygon poly: dataManager.getPolygonList()) {
          renderPane.getChildren().addAll(poly);
        }
        
        //renderPane.setScaleX(4);
        //renderPane.setScaleY(4);
        renderPane.setStyle("-fx-background-color: lightblue;");
        

        
        workspace.getChildren().addAll(renderPane);
        
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
    
    public Pane getRenderPane() {
        return renderPane;
    }
}
