/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.controller;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
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
    double counter = 1.0;
    double temp1 = 0.0;
    double temp2 = 0.0;
    double temp3 = 0.0;
    double temp4 = 0.0;
    
    public MapController(AppTemplate initApp) {
	app = initApp;
        //myManager=(DataManager)app.getDataComponent();
        
    }
    
    public DataManager getDataManager() { return myManager;}
    public void setDataManager(DataManager x) { myManager = x;}
    
    public void processInitialize() {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        myManager=(DataManager)app.getDataComponent();
        workspace.reloadWorkspace();
    }
    
    public void processZoomIn(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        myManager=(DataManager)app.getDataComponent();
        
        //double newOriginX = x;
        //double newOriginY = y-10;
        
        //renderPane.setLayoutX(x);
        //renderPane.setLayoutY(y);
        //renderPane.setTranslateX(xOrigin-x);
        //renderPane.setTranslateY(yOrigin-(y-10));
        
        //root.getLayoutX add root.getWidth/2 - x
        if (counter == 1) {
            double layoutX = renderPane.getLayoutX();
            double layoutY = renderPane.getLayoutY();
            temp3 = renderPane.getWidth()/2;
            temp4 = renderPane.getHeight()/2;
        }
        
        renderPane.setLayoutX(renderPane.getLayoutX() + (temp3) - x);
        renderPane.setLayoutY(renderPane.getLayoutY() + (temp4) - (y-62));
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
        
        //can center this at the point we clicked at for clarity
        Circle circle = new Circle(5.0, Paint.valueOf("#999999"));
        circle.setCenterX(x);
        circle.setCenterY(y-62);
        renderPane.getChildren().add(circle);
        //System.out.println(x);
        //System.out.println(y-62);
        double newX = renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX();
        double newY = renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY();
        //System.out.println(newX);
        //x - newX = some constant, and we want the same constant for x - newX after the zoom.
        double temp1 = newX;
        double temp2 = newY;
        
        //System.out.println(renderPane.getLayoutX());
        
        renderPane.setScaleX(renderPane.getScaleX()*2.0);
        renderPane.setScaleY(renderPane.getScaleY()*2.0);
        

        newX = renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX();
        newY = renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY();
        //System.out.println(newX);
        //while (Math.abs(x - newX - temp1) >= 2) {
        //System.out.println(renderPane.getLayoutX());
        if (counter == 0.0) {
            System.out.println(renderPane.getLayoutX());
            renderPane.setLayoutX(renderPane.getLayoutX() - (newX - temp1)/(counter));
            System.out.println(renderPane.getLayoutX());

            renderPane.setLayoutY(renderPane.getLayoutY() - (newY - temp2)/(counter));
        }
        System.out.println(app.getGUI().getPrimaryScene().getWidth()/2);
        System.out.println(app.getGUI().getPrimaryScene().getHeight()/2);

        if (counter != 0.0) {
            //while (Math.abs((app.getGUI().getPrimaryScene().getHeight()/2 - renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY())) > 5) {
               // if (app.getGUI().getPrimaryScene().getHeight()/2 < renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY())
               // {renderPane.setTranslateY(renderPane.getTranslateY()-1.0);}
               // if (app.getGUI().getPrimaryScene().getHeight()/2 > renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY())
               // {renderPane.setTranslateY(renderPane.getTranslateY()+1.0);}
               // System.out.println(renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getY());
                
                
            //}
            System.out.println("-----");
            while (Math.abs((app.getGUI().getPrimaryScene().getWidth()/2 - renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX())) > 5) {
                if (app.getGUI().getPrimaryScene().getWidth() < renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX())
                {renderPane.setTranslateX(renderPane.getTranslateX()+1.0);}
                if (app.getGUI().getPrimaryScene().getWidth() > renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX()) {
                    renderPane.setTranslateX(renderPane.getTranslateX()-1.0);
                }
                System.out.println(renderPane.localToScene(circle.getCenterX(), circle.getCenterY()).getX());

            }
            System.out.println("----");
        }
        System.out.println("*****");
        counter = counter*2.0;
        System.out.println("asdf");
        //}
        //System.out.println(newX);
        
        //while (renderPane.getLayoutX() )
        //System.out.println(renderPane.getLayoutX());
        //renderPane.setLayoutX(renderPane.getLayoutX() + newX - x);
        
        //System.out.println(renderPane.getLayoutX());
        //renderPane.setLayoutY(renderPane.getLayoutY() + newY - (y-62));
        
        
        /**
         * double multiplier = 1;
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
        * */
        
        //workspace.reloadWorkspace();
    }
    
    public void processZoomOut(double x, double y, Pane renderPane, double xOrigin, double yOrigin) {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        myManager=(DataManager)app.getDataComponent();
        
        renderPane.setScaleX(renderPane.getScaleX()*0.5);
        renderPane.setScaleY(renderPane.getScaleY()*0.5);
        
        workspace.reloadWorkspace();
        
        counter = counter/2.0;

        
    }
    
}
