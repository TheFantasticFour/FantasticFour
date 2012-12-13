/**
 * This class is an extension of an order and is created when the
 * user presses the 'Add Pop' button on the MainMenuActivity page.
 * It is responsible having the user input a pop type and size,
 * creating the Pop object and adding that Pop to the main order. 
 * 
 * @author FantasticFour
 */

package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.widget.CheckBox;
import android.widget.RadioButton;

/*
 * This class is an extension of an order and is created when the
 * user presses the 'Add Pop' button on the MainMenuActivity page.
 * It is responsible having the user input a pop type and size,
 * creating the Pop object and adding that Pop to the main order. 
 */
public class AddPopActivity extends Activity {
	
	private static final String POP_SIZE_2_LITER = "2-Liter";
	private static final String POP_SIZE_CAN = "Can";
	private String popLiterFlavor = "";
	private String popCanFlavor = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);
    }
    
    /**
     * Called when the user clicks the 'Finished Adding Pop' button
     *
     */
    public void donePop(View view) {
    	
    	checkLiterChoice();
    	checkCanChoice(); 
    	
    	if(!popLiterFlavor.equals("")){
    		Pop tempPop = new Pop(POP_SIZE_2_LITER, popLiterFlavor);
    		MainMenuActivity.addPopToOrder(tempPop);
    	}
    	if(!popCanFlavor.equals("")){
    		Pop tempPop = new Pop(POP_SIZE_CAN, popCanFlavor);
    		MainMenuActivity.addPopToOrder(tempPop);
    	}
    	   	
    	finish();
    }
    
    /**
     * Checks values selected in the Liter Column.
     * 
     */
    private void checkLiterChoice(){
    	if(checkRadioButton(R.id.liter_coka_coke)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_coka_coke);
    	}
    	else if(checkRadioButton(R.id.liter_pepsi)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_pepsi);
    	}
    	else if(checkRadioButton(R.id.liter_mountain_dew)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_mountain_dew);
    	}
    	else if(checkRadioButton(R.id.liter_diet_coke)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_diet_coke);
    	}
    	else if(checkRadioButton(R.id.liter_orange_fanta)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_orange_fanta);
    	}
    	else if(checkRadioButton(R.id.liter_root_beer)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_root_beer);
    	}
    	else if(checkRadioButton(R.id.liter_dr_pepper)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_dr_pepper);
    	}
    	else if(checkRadioButton(R.id.liter_sprite)){
    		popLiterFlavor = getRadioButtonText(R.id.liter_sprite);
    	}// else{\\pop liter type set to ""}
    }
    /**
     * Checks values selected in the Can Column.
     * 
     */
    
    private void checkCanChoice(){
    	if(checkRadioButton(R.id.can_coka_cola)){
    		popCanFlavor = getRadioButtonText(R.id.can_coka_cola);
    	}
    	else if(checkRadioButton(R.id.can_pepsi)){
    		popCanFlavor = getRadioButtonText(R.id.can_pepsi);
    	}
    	else if(checkRadioButton(R.id.can_mountain_dew)){
    		popCanFlavor = getRadioButtonText(R.id.can_mountain_dew);
    	}
    	else if(checkRadioButton(R.id.can_diet_coke)){
    		popCanFlavor = getRadioButtonText(R.id.can_diet_coke);
    	}
    	else if(checkRadioButton(R.id.can_orage_fanta)){
    		popCanFlavor = getRadioButtonText(R.id.can_orage_fanta);
    	}
    	else if(checkRadioButton(R.id.can_root_beer)){
    		popCanFlavor = getRadioButtonText(R.id.can_root_beer);
    	}
    	else if(checkRadioButton(R.id.can_dr_pepper)){
    		popCanFlavor = getRadioButtonText(R.id.can_dr_pepper);
    	}
    	else if(checkRadioButton(R.id.can_sprite)){
    		popCanFlavor = getRadioButtonText(R.id.can_sprite);
    	}// else{\\pop can type set to ""}
    }
    
    /**
     * A helper method for CheckBox which aids in finding the value of a check box. 
     * 
     * @param idName The ID for a particular box.
     * @return Returns a boolean whether or not a particular box is checked.
     */
    
    private boolean checkRadioButton(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.isChecked();
    }
    /**
     * A helper method for Radio Buttons which aids in finding the value of a button. 
     * 
     * @param idName The ID for a particular button.
     * @return Returns a boolean whether or not a particular button is checked.
     */
    private String getRadioButtonText(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.getText().toString();
    }
}
