package AWT;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class ImageSelection implements Transferable{
	private Image image;
	//constructor, for hold a Image object
	public ImageSelection(Image image){
		this.image = image;
	}
	//return the DataFlavor of Transferable's object
	public DataFlavor[] getTransferDataFlavors(){
		return new DataFlavor[]{DataFlavor.imageFlavor};
	}
	//get the actual data of Transferable
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException{
		if(flavor.equals(DataFlavor.imageFlavor)){
			return image;
		}
		else{
			throw new UnsupportedFlavorException(flavor);
		}
	}
	public boolean isDataFlavorSupported(DataFlavor flavor){
		return flavor.equals(DataFlavor.imageFlavor);
	}
}
