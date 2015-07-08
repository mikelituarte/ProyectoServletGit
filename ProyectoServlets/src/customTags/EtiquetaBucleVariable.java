package customTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaBucleVariable extends SimpleTagSupport{
	
	
	private int num;
	

	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();//PageContext da acceso a todos los saquitos
		getJspContext().getOut().println("<br>Usando el context");
		for (int i=0; i<num; i++) {
            getJspContext().setAttribute("count", String.valueOf( i + 1 ) );
            getJspBody().invoke(null);
        }
		getJspContext().getOut().println("<br>Ahora usando la Request");
		for (int i=0; i<num; i++) {
            pc.getRequest().setAttribute("count", String.valueOf( i + 1 ) );
            getJspBody().invoke(null);
        }
		
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	
	
}
