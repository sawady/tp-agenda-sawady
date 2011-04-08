package view;

import org.joda.time.DateTime;
import org.uqbar.commons.model.UserException;
import org.uqbar.lacar.ui.model.Adapter;

public class AdapterJodaTime implements Adapter<DateTime, String>{

	public DateTime viewToModel(String valueFromView) {
		
		if(valueFromView.length() != 11){
			throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
		}
		
		int dia;
		int mes;
		int anho;
		
		try{
			dia  = Integer.parseInt(valueFromView.substring(0, 2));
			mes  = Integer.parseInt(valueFromView.substring(3, 5));
			anho = Integer.parseInt(valueFromView.substring(6, 10));
		} catch(NumberFormatException exp) {
			throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
		}
		
		return new DateTime(dia,mes,anho, 0, 0, 0, 0);
	}

	public String modelToView(DateTime valueFromModel) {
		return "" + valueFromModel.getDayOfMonth() + 
		      "-" + valueFromModel.getMonthOfYear() +
		      "-" + valueFromModel.getYear();
	}

	public Class<DateTime> getModelType() {
		return DateTime.class;
	}

	public Class<String> getViewType() {
		return String.class;
	}

}
