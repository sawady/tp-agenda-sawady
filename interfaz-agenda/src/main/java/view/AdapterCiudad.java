package view;

import model.Ciudad;

import org.uqbar.lacar.ui.model.Adapter;

public class AdapterCiudad implements Adapter<Ciudad, String> {

	public Ciudad viewToModel(String valueFromView) {
		return new Ciudad(valueFromView);
	}

	public String modelToView(Ciudad valueFromModel) {
		return valueFromModel.getNombre();
	}

	public Class<Ciudad> getModelType() {
		return Ciudad.class;
	}

	public Class<String> getViewType() {
		return String.class;
	}

}
