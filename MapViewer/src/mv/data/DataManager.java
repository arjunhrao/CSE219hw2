package mv.data;

import java.util.ArrayList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import saf.components.AppDataComponent;
import mv.MapViewerApp;
import mv.gui.Workspace;

/**
 *
 * @author McKillaGorilla
 */
public class DataManager implements AppDataComponent {
    MapViewerApp app;
    ArrayList<Polygon> polygonList = new ArrayList<>();
    
    public DataManager(MapViewerApp initApp) {
        app = initApp;
    }
    
    @Override
    public void reset() {
        polygonList.clear();
    }
    
    public void addPolygon(Polygon p) {
        polygonList.add(p);
    }
    
    public ArrayList<Polygon> getPolygonList() {
        return polygonList;
    }
    
    public void fillPolygons(Paint p) {
        for (Polygon poly: polygonList) {
            poly.setFill(p);
        }
    }
    
    //prob won't use this method
    public Polygon convertPolygon(Polygon p) {
        Workspace workspace = (Workspace)app.getWorkspaceComponent();
        p.setScaleX(1/360*workspace.getRenderPane().getWidth());
        p.setScaleY(1/180*workspace.getRenderPane().getHeight());
        return p;

    }
    
    public void scaleXYCoordinates(ArrayList<Double> xy) {
        double halfX = app.getGUI().getPrimaryScene().getWidth()/2;
        double halfY = app.getGUI().getPrimaryScene().getHeight()/2;
        
        for (int n = 0; n < xy.size(); n++) {
                if (n%2 == 0) {//it's an x
                    //scale it
                    xy.set(n, xy.get(n)/360*app.getGUI().getPrimaryScene().getWidth());
                    //place it relative to origin
                    xy.set(n, halfX+xy.get(n));
                } else {
                    //scale
                    xy.set(n, xy.get(n)/180*app.getGUI().getPrimaryScene().getHeight());
                    //place relative to origin
                    xy.set(n, halfY-xy.get(n));
                }
            }

    }
    
}
