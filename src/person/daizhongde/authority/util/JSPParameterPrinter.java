package person.daizhongde.authority.util;

public class JSPParameterPrinter {
	public String out(Object o){
		if(o==null)
			return "";
		else
			return o.toString();
	}
}
