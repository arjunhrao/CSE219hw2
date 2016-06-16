package mv.data;

import java.util.ArrayList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import saf.components.AppDataComponent;
import mv.MapViewerApp;

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
    
}
