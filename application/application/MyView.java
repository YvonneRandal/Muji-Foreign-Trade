package application;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;

import com.jidesoft.app.framework.DataModel;
import com.jidesoft.app.framework.DataModelException;
import com.jidesoft.app.framework.gui.DataViewPane;

public class MyView extends DataViewPane {
	JLabel label;
	protected void initializeComponents() {
		label = new JLabel();
		label.setFont(new Font("serif", Font.PLAIN, 24));
		add(label, BorderLayout.CENTER);
	}
	public void updateView(DataModel dataModel) throws DataModelException {
		//label.setText((String)dataModel.getData());
	}
}
    