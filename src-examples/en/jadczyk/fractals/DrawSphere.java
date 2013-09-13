package en.jadczyk.fractals;
import de.jreality.geometry.ParametricSurfaceFactory;
import de.jreality.geometry.ParametricSurfaceFactory.Immersion;
import de.jreality.plugin.JRViewer;
import de.jreality.plugin.JRViewer.ContentType;
import de.jreality.plugin.content.ContentAppearance;
import de.jreality.plugin.content.ContentTools;
import de.jreality.scene.SceneGraphComponent;
public class DrawSphere {
	public static class SphereDrawer implements Immersion {
		public void evaluate(double u, double v, double[] xyz, int index) {
			xyz[index]= Math.cos(u) * Math.sin(v);
			xyz[index+1]= Math.sin(u) * Math.sin(v);
			xyz[index+2]= Math.cos(v);
		}
		// how many dimensions in the image space?
		public int getDimensionOfAmbientSpace() { return 3;	}
		// Does evaluate() always put the same value into xyz for a given pair (u,v)?
		// If the immersion has parameters that affect the result of evaluate() then isImmutable()
		// should return false.
		public boolean isImmutable() { return true; }
	};
	public static void main(String[] args) {
		
		//initialize the parametric surface factory
		final ParametricSurfaceFactory psf = new ParametricSurfaceFactory(new SphereDrawer());
		//uv-extension of the domain
		psf.setUMin(0);psf.setUMax(2 * Math.PI);psf.setVMin(0);psf.setVMax(Math.PI);
		//subdivisions of th domain
		psf.setULineCount(20);psf.setVLineCount(20);
		//generate edges and normals
		psf.setGenerateEdgesFromFaces(true);
		psf.setGenerateVertexNormals(true);
		//generate the IndexFaceSet
		psf.update();
		
		//put the generated IndexedFaceSet into the SceneGraphComponent sgc
		SceneGraphComponent sgc = new SceneGraphComponent("Sphere Drawer");
		sgc.setGeometry(psf.getIndexedFaceSet());
		
		// Finally show the example in the JRViewer with virtual reality enabled, i.e., JRViewerVR
		JRViewer v = new JRViewer();
		v.addBasicUI();
		v.addVRSupport();
		v.addContentSupport(ContentType.TerrainAligned);
		v.registerPlugin(new ContentAppearance());
		v.registerPlugin(new ContentTools());
		v.setContent(sgc);

	
		//Start the viewer
		v.startup();

	}

}
