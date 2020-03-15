package factoryPattern;

public class BombFactory implements Factory {

	public BombFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getProduct(String BombType) {
		  if(BombType == null){
		         return null;
		      }		
		      if(BombType.equalsIgnoreCase("FATAl")){
		         return new Fatal();
		         
		      } else if(BombType.equalsIgnoreCase("DANGEROUS")){
		         return new Dangerous();
		         
		      } 
		      
		      return null;	

}
}
