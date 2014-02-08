package application;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;

import com.jidesoft.app.framework.BasicDataModel;
import com.jidesoft.app.framework.BasicDataModelFactory;
import com.jidesoft.app.framework.BasicDataViewFactory;
import com.jidesoft.app.framework.DataModel;
import com.jidesoft.app.framework.DataModelException;
import com.jidesoft.app.framework.gui.DataViewPane;
import com.jidesoft.app.framework.gui.GUIApplication;

public class HelloGUIWorld {

    public static void main(String[] args) {
        GUIApplication application = new GUIApplication("HelloGUIWorld");
        //application.addDataModelFactory(new BasicDataModelFactory(MyModel.class));
        application.addDataViewFactory(new BasicDataViewFactory(MyView.class));
        application.run(args);
    }

    public static class MyData extends BasicDataModel {
	   public void newData() {
		   setData("Hello World!");
	   }
    }

    public static class MyView extends DataViewPane {
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
}
    