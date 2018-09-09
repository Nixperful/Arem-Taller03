/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto3.parte2;

import co.edu.escuelaing.arem.taller03.punto3.parte1.*;

/**
 *
 * @author estudiante
 */
class DataProcessor {
    
    String actualOperation;
    float lastAns=0;
    public DataProcessor() {
      actualOperation="cos";
    }
    
    public Float sen(Float inputData) {
        return (float) Math.sin(inputData);  
    }
    public Float cos(Float inputData) {
        return (float) Math.cos(inputData); 
    }
    public Float tan(Float inputData) {
        return (float) Math.tan(inputData);  
    }
    private void changeOperation(String operation){
        if((operation.contains("cos"))||(operation.contains("sen"))||(operation.contains("tan"))){
            this.actualOperation=operation.substring(0, 3);
        }              
    }

    public void calculateOperation(String inputLine) {
        if(inputLine.contains("fun:")){
            changeOperation(inputLine.substring(4));
        }
        else{
            try{
                System.out.println(actualOperation);
                float input=Float.parseFloat(inputLine);
                if (actualOperation.contains("cos")){
                    this.lastAns= cos(input);
                }
                else if(actualOperation.contains("sen")){
                    this.lastAns= sen(input);
                }
                else if(actualOperation.contains("tan")){
                    this.lastAns= tan(input);
                }
                
            }catch(Exception e){
               System.out.println("ERROR EN LA OPERACIÓN"); 
            }
        }
    }

    public float getLastAns() {
        return lastAns;
    }

    public String getActualOperation() {
        return actualOperation;
    }
    
    
    
}
