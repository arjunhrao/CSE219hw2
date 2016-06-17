/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.gui;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import saf.components.AppWorkspaceComponent;
import mv.MapViewerApp;
import mv.controller.MapController;
import mv.data.DataManager;

/**
 *
 * @author McKillaGorilla
 */
public class Workspace extends AppWorkspaceComponent {
    MapViewerApp app;
    Pane renderPane = new Pane();
    MapController mapController;
    double xOrigin;
    double yOrigin;
    
    public Workspace(MapViewerApp initApp) {
        app = initApp;
        workspace = new Pane();
        xOrigin = app.getGUI().getPrimaryScene().getWidth()/2;
        yOrigin = (app.getGUI().getPrimaryScene().getHeight()-60)/2;
        removeButtons();
        
        
        //initialize processing of eventhandlers - create new method
        processEvents();
    }
    
    public void processEvents() {
        //create controller
        mapController = new MapController(app);
        
        workspace.setOnMouseClicked(e -> {
            double x = e.getSceneX();
            double y = e.getSceneY();
            if (e.getButton() == MouseButton.PRIMARY) {
                mapController.processZoomIn(x, y, renderPane, xOrigin, yOrigin);
            }
            
            if (e.getButton() == MouseButton.SECONDARY) {
                mapController.processZoomOut(x, y, renderPane, xOrigin, yOrigin);
            }
            
        });
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
        renderPane.setStyle("-fx-background-color: blue;");
        

        
        workspace.getChildren().addAll(renderPane);
        
        //clip it to avoid overflow
        Rectangle clip = new Rectangle();
        clip.setHeight(app.getGUI().getPrimaryScene().getHeight()-60);
        clip.setWidth(app.getGUI().getPrimaryScene().getWidth());
        clip.setLayoutX(0);
        clip.setLayoutY(0);
        workspace.setClip(clip);
        
        
    }

    @Override
    public void initStyle() {
    }
    
    public void addLines() {
        
        //renderPane.addLines
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
