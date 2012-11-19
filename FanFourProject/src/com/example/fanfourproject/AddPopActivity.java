package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.widget.CheckBox;
import android.widget.RadioButton;

public class AddPopActivity extends Activity {
	
	private String popSizeLiter = "2-Liter";
	private String popSizeCan = "Can";
	private String popLiterType = "";
	private String popCanType = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);
    }
    
//    private boolean checkCheckBox(int idName){
//    	CheckBox myCheckBox1 = (CheckBox) findViewById(idName);    	
//    	return myCheckBox1.isChecked();
//    }
    
    private boolean checkRadioButton(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.isChecked();
    }
    
    private String getRadioButtonText(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.getText().toString();
    }
    
    private void checkLiter(){
    	if(checkRadioButton(R.id.liter_coka_coke)){
    		popLiterType = getRadioButtonText(R.id.liter_coka_coke);
    	}
    	else if(checkRadioButton(R.id.liter_pepsi)){
    		popLiterType = getRadioButtonText(R.id.liter_pepsi);
    	}
    	else if(checkRadioButton(R.id.liter_mountain_dew)){
    		popLiterType = getRadioButtonText(R.id.liter_mountain_dew);
    	}
    	else if(checkRadioButton(R.id.liter_diet_coke)){
    		popLiterType = getRadioButtonText(R.id.liter_diet_coke);
    	}
    	else if(checkRadioButton(R.id.liter_orange_fanta)){
    		popLiterType = getRadioButtonText(R.id.liter_orange_fanta);
    	}
    	else if(checkRadioButton(R.id.liter_root_beer)){
    		popLiterType = getRadioButtonText(R.id.liter_root_beer);
    	}
    	else if(checkRadioButton(R.id.liter_dr_pepper)){
    		popLiterType = getRadioButtonText(R.id.liter_dr_pepper);
    	}
    	else if(checkRadioButton(R.id.liter_sprite)){
    		popLiterType = getRadioButtonText(R.id.liter_sprite);
    	}// else{\\pop liter type set to "none"}
    }
    private void checkCan(){
    	if(checkRadioButton(R.id.can_coka_cola)){
    		popCanType = getRadioButtonText(R.id.can_coka_cola);
    	}
    	else if(checkRadioButton(R.id.can_pepsi)){
    		popCanType = getRadioButtonText(R.id.can_pepsi);
    	}
    	else if(checkRadioButton(R.id.can_mountain_dew)){
    		popCanType = getRadioButtonText(R.id.can_mountain_dew);
    	}
    	else if(checkRadioButton(R.id.can_diet_coke)){
    		popCanType = getRadioButtonText(R.id.can_diet_coke);
    	}
    	else if(checkRadioButton(R.id.can_orage_fanta)){
    		popCanType = getRadioButtonText(R.id.can_orage_fanta);
    	}
    	else if(checkRadioButton(R.id.can_root_beer)){
    		popCanType = getRadioButtonText(R.id.can_root_beer);
    	}
    	else if(checkRadioButton(R.id.can_dr_pepper)){
    		popCanType = getRadioButtonText(R.id.can_dr_pepper);
    	}
    	else if(checkRadioButton(R.id.can_sprite)){
    		popCanType = getRadioButtonText(R.id.can_sprite);
    	}// else{\\pop can type set to "none"}
    }
    
    

    /** Called when the user clicks the 'Finished Adding Pop' button */
    public void donePop(View view) {
    	
    	checkLiter();
    	checkCan(); 
    	
    	if(!popLiterType.equals("")){
    		Pop tempPop = new Pop(popSizeLiter, popLiterType);
    		MainMenuActivity.addPopToOrder(tempPop);
    	}
    	if(!popCanType.equals("")){
    		Pop tempPop = new Pop(popSizeCan, popCanType);
    		MainMenuActivity.addPopToOrder(tempPop);
    	}
    	
    	//EditText myEditText = (EditText) findViewById(R.id.editText1);
    	//String message = myEditText.getText().toString();
    	
        //MainMenuActivity.i2.putExtra("POP_PASS_1", message);    	
    	finish();
    }
}
