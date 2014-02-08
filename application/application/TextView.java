package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.print.Pageable;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jidesoft.app.framework.gui.ComponentPageable;
import com.jidesoft.app.framework.DataModel;
import com.jidesoft.app.framework.file.FileDataModel;
import com.jidesoft.app.framework.gui.DataViewPane;

/**
 * This is a sample DataView. It implements a simple text area. Notice how we 
 * interact with the DataModel and how we set the dirty flag when there is typing.
 * <p>
 * This class is mapped to the <code>TextFileFormat</code> in the GUIApplication.
 *
 * @author JIDE Desktop Application Wizard
 */
public class TextView extends DataViewPane {
   
   /** the text area */
   private JTextArea textArea;
   private DocumentListener docListener;
    
   /**
    * Initialize our Components.
    */ 
   protected void initializeComponents() {
	    	
    	// sets the window size
        setPreferredSize(new Dimension(550, 400));
        setBackground(Color.WHITE);
        setBorder(null);
        
        // initialize text area
        textArea = new JTextArea();
        textArea.setFont(textArea.getFont().deriveFont(12f));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        docListener = new DocumentListener() {
        	public void insertUpdate(DocumentEvent e) {
        		makeDirty(true);
        	}
        	public void removeUpdate(DocumentEvent e) {
        		makeDirty(true);
        	}
        	public void changedUpdate(DocumentEvent e) {
        		// unnecessary for plain text
        	}
        };
        textArea.getDocument().addDocumentListener(docListener);
        textArea.setBorder(BorderFactory.createEmptyBorder(4,10,4,4));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        add(scrollPane);
        
        // install editing features
        installEditables();
    }
    
    /**
     * Update the view from the model.
     * 
     * @param dataModel
     */
    public void updateView(DataModel dataModel) {
        FileDataModel fileDataModel = (FileDataModel)dataModel;
    	textArea.getDocument().removeDocumentListener(docListener);
        textArea.setText(fileDataModel.getData() != null ? fileDataModel.getData().toString() : "");
        textArea.setCaretPosition(0);
        textArea.getDocument().addDocumentListener(docListener);
    }
        
    /**
     * Update the model from the view.
     * 
     * @param dataModel
     */
    public void updateModel(DataModel dataModel) {
        FileDataModel fileDataModel = (FileDataModel)dataModel;
        fileDataModel.setData(textArea.getText());
    }
    
    /**
     * This implementation just prints the TextArea component.
     *
     * @see com.jidesoft.app.framework.gui.PrintSource#getPageable()
     */
    public Pageable getPageable() {
       return new ComponentPageable(textArea);
    }
}