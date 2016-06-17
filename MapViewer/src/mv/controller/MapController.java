/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.controller;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
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
    
    public MapController(AppTemplate initApp) {
	app = initApp;
        
    }
    
    public DataManager getDataManager() { return myManager;}
    
    public void processZoomIn(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        myManager=(DataManager)app.getDataComponent();
        
        double newOriginX = x;
        double newOriginY = y;
        
        renderPane.setTranslateX(xOrigin-x);
        renderPane.setTranslateY(yOrigin-y);
        
        System.out.println(xOrigin);
        System.out.println(yOrigin);
        System.out.println(x);
        System.out.println(y);
        
        //System.out.println(renderPane.getScaleX());
        //renderPane.setScaleX(1.2*renderPane.getScaleX());
        //renderPane.setScaleY(1.2*renderPane.getScaleY());
        //System.out.println(renderPane.getScaleX());
        
        
        //set xOrigin
        //set yOrigin
        
        
        
        
        workspace.reloadWorkspace();
    }
    
    public void processZoomOut(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
    }
    
}
