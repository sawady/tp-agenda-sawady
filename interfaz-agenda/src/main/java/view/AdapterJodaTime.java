package view;

import org.apache.log4j.helpers.DateTimeDateFormat;
import org.joda.time.DateTime;
import org.uqbar.commons.model.UserException;
import org.uqbar.lacar.ui.model.Adapter;

public class AdapterJodaTime implements Adapter<DateTime, String>{

	public DateTime viewToModel(String valueFromView) {
		
		String aux = valueFromView;
		int index;
		int dia;
		int mes;
		int anho;
		
		if(valueFromView == null)
		{
			throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
		}	
		
		index = aux.indexOf('-');
		
		if(index == -1)
			throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
		
		try{
			
			dia  = Integer.parseInt(aux.substring(
					0, index));
			aux = aux.substring(index+1);
			
			index = aux.indexOf('-');
			
			if(index == -1)
				throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
			
			mes  = Integer.parseInt(aux.substring(
					0, index));
			aux = aux.substring(index+1);
			
			anho = Integer.parseInt(aux);
			
		} catch(NumberFormatException exp) {
			throw new UserException("La fecha no tiene formato válido: dd-mm-aa");
		}
		
		return new DateTime(anho, mes, dia, 0, 0, 0, 0);
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
