package en.jadczyk.fractals;
import de.jreality.geometry.Primitives;
import de.jreality.plugin.JRViewer;
import de.jreality.plugin.JRViewer.ContentType;
import de.jreality.plugin.content.ContentAppearance;
import de.jreality.plugin.content.ContentTools;
import de.jreality.geometry.ParametricSurfaceFactory;
import de.jreality.geometry.ParametricSurfaceFactory.Immersion;
import de.jreality.plugin.JRViewer;
import de.jreality.plugin.JRViewer.ContentType;
import de.jreality.plugin.content.ContentAppearance;
import de.jreality.plugin.content.ContentTools;
import de.jreality.scene.SceneGraphComponent;
public class Icosahedron {
	public static void main(String[] args) {
		JRViewer v = new JRViewer();
		v.addBasicUI();
		v.addVRSupport();
		v.addContentSupport(ContentType.TerrainAligned);
		v.registerPlugin(new ContentAppearance());
		v.registerPlugin( new ContentTools());
		v.setContent( Primitives.icosahedron());
		v.startup();	
	}
	public static double[][] getVertices() {
		double[][] vertices = null;
		
		return vertices;
		
	}
	public static double[][][] getBaseMatrix( String name ) {
		double[][][] L;
		if ( name == "" ) {
			
		}
	}

}
