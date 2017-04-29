package AWT;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.Serializable;

public class SerialSelection implements Transferable{
	//create a serializable object
	private Serializable obj;
	public SerialSelection(Serializable obj){
		this.obj = obj;
	}
	public DataFlavor[] getTransferDataFlavors(){
		DataFlavor[] flavors = new DataFlavor[2];
		//get the type of the encapsulation object
		Class clazz = obj.getClass();
		try{
			flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + " ;class=" + clazz.getName());
			flavors[1] = DataFlavor.stringFlavor;
			return flavors;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException{
		if(!isDataFlavorSupported(flavor)){
			throw new UnsupportedFlavorException(flavor);
		}
		if(flavor.equals(DataFlavor.stringFlavor)){
			return obj.toString();
		}
		return obj;
	}
	public boolean isDataFlavorSupported(DataFlavor flavor){
		return flavor.equals(DataFlavor.stringFlavor) ||
				flavor.getPrimaryType().equals("application") &&
				flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
	}
}











