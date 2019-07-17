package Model;


public class irisObject {


	private double sepalLength, sepalWidth, petalLength, petalWidth;
	private String resultantOutput;
	private double distance;
	
	public irisObject(double a, double b, double c,double d){
		this.sepalLength = a ;
		this.sepalWidth = b;
		this.petalLength = c;
		this.petalWidth = d;
	}
	
	public irisObject(double a, double b, double c,double d, String output){
		this.sepalLength = a ;
		this.sepalWidth = b;
		this.petalLength = c;
		this.petalWidth = d;
		this.resultantOutput = output;
	}
	
	public double computeDistance(irisObject obj1, irisObject obj2){
		
		double distance = Math.sqrt( ((obj1.sepalLength - obj2.sepalLength) * (obj1.sepalLength - obj2.sepalLength)) +  
								((obj1.sepalWidth - obj2.sepalWidth) * (obj1.sepalWidth - obj2.sepalWidth)) + 
									((obj1.petalLength - obj2.petalLength) * (obj1.petalLength - obj2.petalLength))+
										((obj1.petalWidth - obj2.petalWidth) * (obj1.petalWidth - obj2.petalWidth)) 
										); 
		return distance;
	}
	
	public double getSepalLength(){
		return this.sepalLength;
	}
	
	public double getSepalWidth(){
		return this.sepalWidth;
	}
	
	public double getPetalLength(){
		return this.petalLength;
	}
	
	public double getPetalWidth(){
		return this.petalWidth;
	}
	
	public String getValue(){
		return this.resultantOutput;
	}

	public void setDistance(double value){
	   this.distance = value;	
	}
	
	public double getDistance(){
		return this.distance;
	}

	public void printCase(irisObject caseInstance){
		System.out.println("Sepal Length :"+caseInstance.sepalLength);
		System.out.println("Sepal Width :"+caseInstance.sepalWidth);
		System.out.println("Petal Length :"+caseInstance.petalLength);
		System.out.println("Petal Width :"+caseInstance.petalWidth);
		System.out.println("Result :"+ caseInstance.resultantOutput);
	}

	public int compareTo(irisObject o) {
	    return new Double(this.distance).compareTo(new Double(o.distance));
	}
}
