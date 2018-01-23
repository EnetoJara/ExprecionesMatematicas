import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
/**
 * @author Ernesto Jara Olveda
 * @category Functions
 * @Date 07/12/2014
 */
public class Arbol 
{
	  LinkedList<String> pila;
	  LinkedList<String> postfija;
	  LinkedList<Double> exp;

	  public void reiniciar(){
	    pila=new LinkedList<String>();
	    postfija=new LinkedList<String>();
	    exp=new LinkedList<Double>();
	  }

	  public boolean esOperador(String x){
	    
	    if ( x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") ) return true;
	    else return false;
	  }

	  public int obtPrioridad(String operador){
	    int prioridad=0;
	    if(operador.equals("*")||operador.equals("/")) prioridad=2;
	    else if(operador.equals("+")||operador.equals("-")) prioridad=1;
	    return prioridad;
	  }

	  public Double hacerOperacion(Double opndo1, Double opndo2, String operador){
	    Double r=0.0;
	    if (operador.equals("+")) r=opndo2 + opndo1;
	    if (operador.equals("-")) r=opndo2 - opndo1;
	    if (operador.equals("*")) r=opndo2 * opndo1;
	    if (operador.equals("/")) r=opndo2 / opndo1;
	    return r;
	  }

	  public String evaluar(){
	    for(String termino:postfija)
	    try 
	    {
	      Double valor = Double.parseDouble(termino);
	      exp.push(valor);
	    }
	    catch (NumberFormatException nfe) 
	    {
	      exp.push( hacerOperacion( exp.pop(), exp.pop(), termino) );
	    }
	    String aReturn=exp.pop().toString();
	    Pattern p= Pattern.compile("(-)?\\d+\\.0");
	    if(p.matcher(aReturn).matches())
	    {
	    	 aReturn= aReturn.substring(0, aReturn.length()-2);
	    }
	    return aReturn;
	  }

	  public String infijaAPostfija(String infija){
	    reiniciar();
	    StringTokenizer st= new StringTokenizer(infija,"/+-*()",true);
	    String[] tokens= new String[st.countTokens()];
	    for (int i = 0; i < tokens.length; i++) {
			tokens[i]=st.nextToken();
		}
	    String[] aux= new String[tokens.length];
	    for (int i = 0; i < aux.length; i++) aux[i]="";
	    int con=0;
	    for (int i = 0; i < tokens.length; i++) {
	    	Pattern isDigito= Pattern.compile("\\d+(\\.\\d+)?");
			if((tokens[i].equals("(")||tokens[i].equals("*")||tokens[i].equals("+")||
					tokens[i].equals("-")||tokens[i].equals("/"))&&(tokens[i+1].equals("+")||tokens[i+1].equals("-"))
					&&isDigito.matcher(tokens[i+2]).matches())
			{
				aux[con]=tokens[i];//aux[0]=*
				con++;//1
				aux[con]=tokens[i+1]+tokens[i+2];//aux[1]= +5
				i=i+2;//i=2
			}else
			{
				aux[con]=tokens[i];//aux[0] pone lo que sea
			}
			con++;
		}
	    int newCont=0;
	    for (int i = 0; i < aux.length; i++) {
			if(!aux[i].equals(""))
			{
				newCont++;
			}
		}
	    String[] newTokens = new String[newCont];
	    newCont=0;
	    for (int i = 0; i < aux.length; i++) {
			if(!aux[i].equals(""))
			{
				newTokens[newCont]=aux[i];
				newCont++;
			}
		}
	    for (int i = 0; i < newTokens.length; i++) {
	    	
	        if(!newTokens[i].equals(" ")){
	          if (newTokens[i].equals("(")) pila.push(newTokens[i]);
	          else if(newTokens[i].equals(")")) {
	            while((!pila.isEmpty()) && (!pila.getFirst().equals("("))) postfija.add(pila.pop());
	            if ((!pila.isEmpty())&&(pila.getFirst().equals("("))) pila.pop();
	          }
	          else if(esOperador(newTokens[i])) {
	            while((!pila.isEmpty()) && ((obtPrioridad(pila.getFirst()) >= obtPrioridad(newTokens[i]))))
	             	  postfija.add(pila.pop());
	            pila.push(newTokens[i]);
	          }
	          else postfija.add(newTokens[i]);
	        }
	      }
	      while (pila.size()>0) postfija.add(pila.pop());
		
	    String salida="";
	    for(String x:postfija) salida=salida+" "+x;
	    return salida;
	  }
}
