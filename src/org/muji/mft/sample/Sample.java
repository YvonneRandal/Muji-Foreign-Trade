package org.muji.mft.sample;

import com.jidesoft.docking.*;
import com.jidesoft.swing.JideButton;
import com.jidesoft.action.*;
import com.jidesoft.plaf.LookAndFeelFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Sample extends DefaultDockableBarDockableHolder {

	public Sample(String title) throws HeadlessException {
		super(title);
	}

	/**
	 * Loads initial layout data from file.
	 * 
	 * @param fileName
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 */
	public void loadInitialLayout(String fileName) throws SAXException,
			ParserConfigurationException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(fileName));
		loadInitialLayout(document);
	}

	/**
	 * Loads initial layout data from Document.
	 * 
	 * @param document
	 */
	public void loadInitialLayout(Document document) {

		// //////////////////////////////////////////////
		// Begin to creates and adds DockableFrames
		//

		getDockingManager().beginLoadLayoutData();

		// TODO: add dockable frames code here
		// TODO: after you added all dockable frames (make sure the key matches)
		// defined in the initial layout,
		// TODO: you can remove the following call to setDockableFrameFactory.
		getDockingManager().setDockableFrameFactory(new DockableFrameFactory() {
			public DockableFrame create(String key) {
				DockableFrame frame = new DockableFrame(key);
				frame.getContentPane().add(new JScrollPane(new JTextArea()));
				return frame;
			}
		});

		getDockingManager().loadInitialLayout(document);

		//
		// End of creates and add DockableFrames
		// //////////////////////////////////////////////

		// //////////////////////////////////////////////
		// Begin to creates and adds DockableBars
		//
		getDockableBarManager().beginLoadLayoutData();

		// TODO: add dockable bars code here
		// TODO: after you added all dockable bars (make sure the key matches)
		// defined in the initial layout,
		// TODO: you can remove the following call to setDockableBarFactory.
		getDockableBarManager().setDockableBarFactory(new DockableBarFactory() {
			public DockableBar create(String key) {
				CommandBar bar = new CommandBar(key);
				bar.add(new JideButton(key));
				return bar;
			}
		});

		getDockableBarManager().loadInitialLayout(document);
		//
		// End of creates and add DockableFrames
		// //////////////////////////////////////////////

	}

	public static void main(String[] args) {
		com.jidesoft.utils.Lm.verifyLicense("Randal Yvonne", "Muji Foreign Trade", "akmV:W4iAz2jjh0k:SN:tT48wlS9cRL");

		if (args.length == 0) {
			System.out.println("Usage:\tjava Sample initialLayoutFile");
			System.out
					.println("\t\tinitialLayoutFile: full path to the initial layout file created by Visual Designer");
			return;
		}

		// set the L&F and add additional UIDefaults for JIDE components
		LookAndFeelFactory.installDefaultLookAndFeelAndExtension();

		Sample frame = new Sample(
				"Preview of initial layout designed by Visual Designer");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			// TODO: change args[0] to the location of initial layout file
			frame.loadInitialLayout(args[0]);
			frame.getLayoutPersistence().loadLayoutData();
			frame.toFront();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
