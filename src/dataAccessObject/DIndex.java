package dataAccessObject;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {

	protected OIndex oIndex;
	protected MIndex mIndex;

	public DIndex() {
		this.oIndex = new OIndex();
		this.mIndex = new MIndex();
	}

	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<>();
		File file = new File(fileName);
		try (Scanner scanner = new Scanner(file);) {
			while (mIndex.read(scanner)) {
				oIndex = oIndex.getInstance();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return indices;
	}

}
