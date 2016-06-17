/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.controller;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Scale;
import static javafx.scene.transform.Transform.scale;
import saf.AppTemplate;
import mv.data.DataManager;
import mv.gui.Workspace;

/**
 *
 * @author ravirao
 */
public class MapController {
    AppTemplate app;
    DataManager myManager;
    int counter = 0;
    
    public MapController(AppTemplate initApp) {
	app = initApp;
        
    }
    
    public DataManager getDataManager() { return myManager;}
    
    public void processZoomIn(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        myManager=(DataManager)app.getDataComponent();
        
        double newOriginX = x;
        double newOriginY = y-10;
        
        //renderPane.setLayoutX(x);
        //renderPane.setLayoutY(y);
        //renderPane.setTranslateX(xOrigin-x);
        //renderPane.setTranslateY(yOrigin-(y-10));
        
        //root.getLayoutX add root.getWidth/2 - x
        double layoutX = renderPane.getLayoutX();
        double layoutY = renderPane.getLayoutY();
        double paneWidth = renderPane.getWidth();
        double paneHeight = renderPane.getHeight();
        
        renderPane.setLayoutX(renderPane.getLayoutX() + (renderPane.getWidth()/2) - x);
        renderPane.setLayoutY(renderPane.getLayoutY() + (renderPane.getHeight()/2) - (y-60));
        //same for y
        
        /**
         *code testing for the x,y variables
        System.out.println("********");
        System.out.println(xOrigin);
        System.out.println("-------");
        System.out.println(xOrigin-x);
        System.out.println("-------");
        System.out.println(yOrigin);
        System.out.println("-------");
        System.out.println(yOrigin-y);
        System.out.println("-------");
        System.out.println(x);
        System.out.println("-------");
        System.out.println(y);
        System.out.println("-------");
         */
        
        
        //System.out.println(renderPane.getScaleX());
        //ZOOM
        //renderPane.setScaleX(1.2*renderPane.getScaleX());
        //renderPane.setScaleY(1.2*renderPane.getScaleY());
        
        //renderPane.setLayoutX(layoutX+ (.2*paneWidth) - x);
        //renderPane.setLayoutY(layoutY + (.2*paneHeight) - y);
        
        Scale scale = new Scale();
        
        
        double multiplier = 1;
        if (counter > 0) {
            multiplier = java.lang.Math.pow(2, (double)counter);
        }
        counter++;
        
        x = x/multiplier;
        y = y/multiplier;
        
        
        System.out.println(x + "------" + y);
        
        scale.setPivotX(x);
        scale.setPivotY(y);
        
        System.out.println(x + "------" + y);
        
        scale.setY(2);
        scale.setX(2);
        //set x,y origin
        //xOrigin = xOrigin+(xOrigin-x);
        //yOrigin = yOrigin+(yOrigin-y);
        
        
        
        renderPane.getTransforms().add(scale);
        
        workspace.reloadWorkspace();
    }
    
    public void processZoomOut(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
    }
    
}
